package corefunctionality;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class is a test class of the class Unit
 */
class TestUnit {

    // A dummy unit for testing the methods
    private InfantryUnit infantry1;
    private CommanderUnit infantry2;


    /**
     * This method will create objects for the tests before each test
     */
    @BeforeEach
    void Setup() {
        infantry1 = new InfantryUnit("Martin", 100, 10, 20);
        infantry2 = new CommanderUnit("Martin", 100, 20, 10);
    }

    @Test
    void TestUnitConstructor() {
        assertEquals("Martin", infantry1.getName());
        assertEquals(100, infantry1.getHealth());
        assertEquals(10, infantry1.getAttack());
        assertEquals(20, infantry1.getArmour());
    }

    /**
     * This method tests attack and setHealth.
     */
    @Test
    void testAttackAndSetHealth() {
        infantry1.setHealth(50);
        assertEquals(50, infantry1.getHealth());
        infantry2.setHealth(60);
        assertEquals(60, infantry2.getHealth());

        infantry2.setHealth(infantry2.getHealth() - (infantry1.getAttack() + infantry1.getAttackBonus()) + (infantry2.getArmour() + infantry2.getResistBonus()));

        assertEquals(58, infantry2.getHealth());
    }

    /**
     * This method tests the counter hitsTaken and hitsDealt
     */
    @Test
    void testHitsDealtAndHitsTaken(){
        infantry1.attack(infantry2);
        assertEquals(1, infantry1.getHitsDealt());
        assertEquals(1, infantry2.getHitsTaken());
    }

    @Test
    void testGetName() {
        assertEquals("Martin", infantry1.getName());
        assertEquals("Martin", infantry2.getName());
    }

   @Test
   void testGetHealth() {
        assertEquals(100, infantry1.getHealth());
        assertEquals(100, infantry2.getHealth());
    }

    @Test
    void testGetAttack() {
        assertEquals(10, infantry1.getAttack());
        assertEquals(20, infantry2.getAttack());
    }


    @Test
    void testResistBonus() {
        assertEquals(1, infantry1.getResistBonus());
        assertEquals(0, infantry2.getResistBonus());
    }

    @Test
    void testAttackBonus() {
        assertEquals(2, infantry1.getAttackBonus());
        assertEquals(6, infantry2.getAttackBonus());
    }


}
