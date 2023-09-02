package montero.ana.monsterservice.controller;

import montero.ana.monsterservice.domain.Monster;
import montero.ana.monsterservice.service.MonsterService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/monsters")
public class MonsterController {
    final
    MonsterService monsterService;

    public MonsterController(MonsterService monsterService) {
        this.monsterService = monsterService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Monster> getAll(){
        return monsterService.getAll();
    }
}
