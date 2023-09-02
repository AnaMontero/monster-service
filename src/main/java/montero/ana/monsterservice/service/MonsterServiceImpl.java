package montero.ana.monsterservice.service;

import montero.ana.monsterservice.domain.Monster;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MonsterServiceImpl implements MonsterService {
    List<Monster> monsters = new ArrayList<>();
    @Override
    public List<Monster> getAll() {
        return monsters;
    }

    @Override
    public void create(Monster monster) {
        monsters.add(monster);
    }
}
