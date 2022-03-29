package corefunctionality;

import exceptions.UnitException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class is a test class of the class Army
 * @author Martin Hegnum Johannessen
 * @version 1.0-SNAPSHOT
 */
class TestArmy {

    // A dummy unit for testing the methods
    private Unit infantry1;
    private CommanderUnit commander1;
    private CavalryUnit ranged1;
    private CavalryUnit cavalry1;
    private Army norway;
    private Army sweden;
    private Army finland;
    private Army simpleArmy;
    private List<Unit> militia;
    private List<Unit> militia1;
    private List<Unit> militia2;

    @BeforeEach
    @DisplayName("This method will create objects for the tests before each test")
    void Setup() {
        infantry1 = new InfantryUnit("Martin", 100, 10, 20);
        commander1 = new CommanderUnit("Martin", 100, 20, 10);
        cavalry1 = new CavalryUnit("Martin", 100, 10, 20);
        ranged1 = new CavalryUnit("Martin", 100, 10, 20);
        militia = new ArrayList<>();
        militia1 = new ArrayList<>();
        militia2 = null;
        norway = new Army("Norway", militia);
        sweden = new Army("Sweden", militia1);
        finland = new Army("Finland", militia2);
        simpleArmy = new Army("simple");

    }

    @Test
    @DisplayName("This method will test the constructor")
    void testArmyConstructor(){
        assertEquals("Norway", norway.getName());
        assertEquals(0, norway.getAllUnits().size());
    }

    @Test
    @DisplayName("This method will test to create an army with a militia which equals null")
    void testConstructorWithMilitiaEqualsNull(){
        assertEquals("Finland", finland.getName());
        assertNotNull(finland.getAllUnits().size(), "A new arraylist was not created");
    }

    @Test
    @DisplayName("This method will test to create an army only with a name")
    void testSimpleConstructor(){
        assertEquals("simple", simpleArmy.getName());
        assertEquals(0, simpleArmy.getAllUnits().size(), "A new arraylist was not created");
    }

    @Test
    @DisplayName("This method will test the getName method")
    void testGetName() {
        assertEquals("Norway", norway.getName());
    }

    @Test
    @DisplayName("This method will test the getAllUnits method")
    void testGetAllUnits() {
        assertEquals(0, norway.getAllUnits().size());
    }

    @Test
    @DisplayName("This method will test the addToArmy method")
    void testAddToArmy() {
        norway.addToArmy(infantry1);
        norway.addToArmy(commander1);
        assertEquals(2, norway.getAllUnits().size());
    }

    @Test
    @DisplayName("This method will test the addAll method, which adds all units from a list to an army")
    void testAddAllToArmy() {
        ArrayList<Unit> humanArmy = new ArrayList<>();
        humanArmy.add(infantry1);
        humanArmy.add(commander1);

        norway.addAllToArmy(humanArmy);

        assertEquals(2, norway.getAllUnits().size());
    }

    @Test
    @DisplayName("This method will test the removeUnit method")
    void testRemoveUnit() {
        norway.addToArmy(infantry1);
        norway.addToArmy(commander1);

        norway.removeUnit(infantry1);

        assertEquals(1, norway.getAllUnits().size());
    }

    @Test
    @DisplayName("This method will test the hasUnits method")
    void testHasUnits() {
        assertEquals(false, norway.hasUnits());
    }

    @Test
    @DisplayName("This method will test the toString method")
    void testToString() {
        assertEquals("\nName: Norway" + "\n" +
                "Army: []", norway.toString());
    }

    @Test
    @DisplayName("This method will test the equals method")
    void testEquals() {
        assertEquals(false, norway.equals(sweden));
    }

    @Test
    @DisplayName("This method will test the getRandomUnit method")
    void testGetRandomUnit(){
        militia.add(infantry1);
        militia.add(commander1);
        Unit randomUnit = norway.getRandomUnit();
        boolean expected = norway.getAllUnits().contains(randomUnit);
        assertTrue(true);
    }

    @Test
    @DisplayName("This method will test the hashCode method")
    void testHashCode(){
        int hashCodeNorway = norway.hashCode();
        assertEquals(hashCodeNorway, norway.hashCode());
    }

    @Test
    @DisplayName("This method will test the setArmyName method")
    void testSetArmyName(){
        norway.setArmyName("sverige");
        assertEquals("sverige", norway.getName());
    }

    @Test
    @DisplayName("This method test if the infantry units in the army are returned")
    void testGetInfantryUnits(){
        militia.add(infantry1);
        militia.add(commander1);

        assertEquals("[Name: Martin\n" + "Health: 100\n" +
                "Attack: 10\n" + "Armour: 20]", norway.getInfantryUnits().toString());
    }

    @Test
    @DisplayName("This method test if the commander units in the army are returned")
    void testGetCommanderUnits(){
        militia.add(infantry1);
        militia.add(commander1);

        assertEquals("[Name: Martin\n" + "Health: 100\n" +
                "Attack: 10\n" + "Armour: 20]", norway.getInfantryUnits().toString());
    }

    @Test
    @DisplayName("This method test if the cavalry units in the army are returned")
    void testGetCavalryUnits(){
        militia.add(infantry1);
        militia.add(commander1);
        militia.add(cavalry1);

        assertEquals("[Name: Martin\n" + "Health: 100\n" +
                "Attack: 10\n" + "Armour: 20]", norway.getInfantryUnits().toString());
    }

    @Test
    @DisplayName("This method test if the ranged units in the army are returned")
    void testGetRangedUnits(){
        militia.add(infantry1);
        militia.add(commander1);
        militia.add(ranged1);

        assertEquals("[Name: Martin\n" + "Health: 100\n" +
                "Attack: 10\n" + "Armour: 20]", norway.getInfantryUnits().toString());
    }
}