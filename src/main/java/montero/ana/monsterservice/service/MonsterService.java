package montero.ana.monsterservice.service;

import montero.ana.monsterservice.domain.Monster;

import java.util.List;

public interface MonsterService {
    List<Monster> getAll();
    void create(Monster monster);
}
