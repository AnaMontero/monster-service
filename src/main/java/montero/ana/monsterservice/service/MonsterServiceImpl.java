package montero.ana.monsterservice.service;

import log.LogService;
import montero.ana.monsterservice.domain.Monster;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonsterServiceImpl implements MonsterService {
    LogService log = new LogService();

    private final List<Monster> monsters;

    public MonsterServiceImpl(List<Monster> monsters) {
        this.monsters = monsters;
    }

    @Override
    public List<Monster> getAll() {
        return monsters;
    }

    @Override
    public void create(Monster monster) {
        monsters.add(monster);
        log.createInfoLevel(true, String.format("Created monster with id: %s}", monster.getId()));
    }

    @Override
    public Monster getById(Long id) {
        for (var monster:monsters) {
            if (monster.getId().equals(id)) {
                return monster;
            }
        }

        try {
            throw new Exception("Monster with id " + id + " not found.");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}