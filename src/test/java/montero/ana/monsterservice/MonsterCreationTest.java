package montero.ana.monsterservice;

import montero.ana.monsterservice.domain.Monster;
import montero.ana.monsterservice.service.MonsterService;
import montero.ana.monsterservice.service.MonsterServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MonsterCreationTest {

    @Test
    void shouldAddOneMonsterWhenNewMonsterIsCreated() {
        MonsterService monsterService = new MonsterServiceImpl();
        var monster = new Monster(1L, "Edward", "Vampire");
        monsterService.create(monster);

        var actual = monsterService.getAll();

        Assertions.assertEquals(1, actual.size());
        Assertions.assertEquals("Edward", actual.get(0).getName());
    }
}
