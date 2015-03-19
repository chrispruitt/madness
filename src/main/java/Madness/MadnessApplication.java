package Madness;

import Madness.Repository.TeamRepository;
import Madness.model.Team;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.List;

@SpringBootApplication
public class MadnessApplication implements CommandLineRunner{

    @Autowired
    TeamRepository teamRepository;

    public static void main(String[] args) {
        SpringApplication.run(MadnessApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        RestTemplate restTemplate = new RestTemplate();

        String response = restTemplate.getForObject(
                "http://marchmadness.kimonolabs.com/api/teams?apikey=tb7AECxFi06nzpu7A7vpzqzRuA9uJfJP",
                String.class);

        System.out.println(response);

        Gson gson = new Gson();
        Type listType = new TypeToken<List<Team>>() {}.getType();
        List<Team> result = gson.fromJson(response, listType);

        for(Team team : result) {
            System.out.println(team.getTeamName());
            teamRepository.save(team);
        }
    }
}
