package Madness;

import Madness.Repository.GameInfoRepository;
import Madness.Repository.GameStatRepository;
import Madness.Repository.TeamStatRepository;
import Madness.model.GameInfo;
import Madness.model.GameSchedule;
import Madness.model.GameStat;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Calendar;

@SpringBootApplication
public class MadnessApplication implements CommandLineRunner{

    @Autowired
    TeamStatRepository teamStatRepository;

    @Autowired
    GameStatRepository gameStatRepository;

    @Autowired
    GameInfoRepository gameInfoRepository;

    public static void main(String[] args) {
        SpringApplication.run(MadnessApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        RestTemplate restTemplate = new RestTemplate();

        Calendar calendar = Calendar.getInstance();
        String response = restTemplate.getForObject(
                "http://api.sportsdatallc.org/ncaamb-t3/games/" +  calendar.get(Calendar.YEAR) + "/" + (calendar.get(Calendar.MONTH)+1) + "/" + calendar.get(Calendar.DAY_OF_MONTH) + "/schedule.json?api_key=qpesczre2ywcr9fr3cazc4sb",
                String.class);

        Gson gson = new Gson();
        Thread.sleep(1000);
        saveGames(gson.fromJson(response, GameSchedule.class));
    }

    private void saveGames(GameSchedule result) throws InterruptedException {
        RestTemplate restTemplate = new RestTemplate();
        Gson gson = new Gson();
        for(GameInfo gameInfo : result.getGames()) {
            try {
                gameInfoRepository.save(gameInfo);
                String response = restTemplate.getForObject("http://api.sportsdatallc.org/ncaamb-t3/games/" + gameInfo.getId() + "/boxscore.json?api_key=qpesczre2ywcr9fr3cazc4sb", String.class);
                GameStat gameStat = gson.fromJson(response, GameStat.class);
                if(gameStat.getHome() != null) {
                    teamStatRepository.save(gameStat.getHome());
                }
                if(gameStat.getAway() != null) {
                    teamStatRepository.save(gameStat.getAway());
                }
                gameStatRepository.save(gameStat);
                Thread.sleep(1000);
            } catch (HttpClientErrorException e) {
                System.out.println(gson.toJson(gameInfo));
            }
        }
    }
}
