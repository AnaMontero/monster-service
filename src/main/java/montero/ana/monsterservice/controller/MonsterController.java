package montero.ana.monsterservice.controller;

import montero.ana.monsterservice.domain.Monster;
import montero.ana.monsterservice.service.MonsterService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/monsters")
public class MonsterController {
    private final MonsterService monsterService;

    private final ServletWebServerApplicationContext webServerAppCtxt;

    public MonsterController(MonsterService monsterService, ServletWebServerApplicationContext webServerAppCtxt) {
        this.monsterService = monsterService;
        this.webServerAppCtxt = webServerAppCtxt;
    }

    @Value("${spring.application.name}")
    String applicationName;

    @GetMapping("/who-am-i")
    public String whoAmI(){
        return "Hello I'm " + applicationName + " and I'm running on port: " + webServerAppCtxt.getWebServer().getPort();
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Monster> getAll(){
        return monsterService.getAll();
    }
}
