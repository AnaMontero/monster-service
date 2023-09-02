package montero.ana.monsterservice;

import montero.ana.monsterservice.domain.Monster;
import montero.ana.monsterservice.service.MonsterService;
import montero.ana.monsterservice.service.MonsterServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class MonsterServiceTest {
    private MonsterService monsterService;
    private List<Monster> monsters;
    @BeforeEach
    void setUp() {
        monsters = new ArrayList<>();
        monsterService = new MonsterServiceImpl(monsters);
    }

    @Test
    void should_return_empty_list_when_no_monsters() {
        monsters = monsterService.getAll();

        Assertions.assertTrue(monsters.isEmpty());
    }

    @Test
    void should_return_one_monster_when_new_monster_is_created() {
        monsterService.create(new Monster(1L, "Edward", "Vampire"));

        var actual = monsterService.getAll();

        Assertions.assertEquals(1, actual.size());
        Assertions.assertEquals("Edward", actual.get(0).getName());
    }

    @Test
    void should_return_monster_found_when_correct_id_is_entered() {
        monsters.add(new Monster(10L, "Buffy", "Vampire"));

        var monsterFound = monsterService.getById(10L);

        Assertions.assertEquals("Buffy", monsterFound.getName());
    }
}