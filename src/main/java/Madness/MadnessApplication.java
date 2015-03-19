package Madness;

import Repository.TeamRepo;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import model.Team;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.List;

@SpringBootApplication
public class MadnessApplication implements CommandLineRunner{

    @Autowired
    TeamRepo teamRepo;

    public static void main(String[] args) {
        SpringApplication.run(MadnessApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(
                "http://marchmadness.kimonolabs.com/api/teams?apikey=tb7AECxFi06nzpu7A7vpzqzRuA9uJfJP",
                String.class);

        Gson gson = new Gson();
        JsonElement element = gson.toJsonTree(response);
        JsonObject object = element.getAsJsonObject();
        Type listType = new TypeToken<List<Team>>() {}.getType();
        List<Team> result = gson.fromJson(object.get("team"), listType);

        for(Team team : result) {
            System.out.println(team.getTeamName());
            teamRepo.save(team);
        }
    }
}
