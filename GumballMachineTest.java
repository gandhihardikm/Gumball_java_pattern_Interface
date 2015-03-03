import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class GumballMachineTest.
 * @author - Hardik Gandhi
 * @date - 02/18/2015
 */
public class GumballMachineTest
{
    private GumballMachine ObjectGumball;

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        ObjectGumball = new GumballMachine(3);
    }
    
    @Test
    public void getAGumball()
    {
        ObjectGumball.insertQuarter();
        ObjectGumball.insertDime();
        ObjectGumball.insertDime();
        ObjectGumball.insertDime();
        ObjectGumball.turnCrank();
        assertEquals(true, ObjectGumball.isGumballInSlot());
    }

    @Test
    public void twoGumballInSlot()
    {
        ObjectGumball.insertDime();
        ObjectGumball.insertDime();
        ObjectGumball.insertNickel();
        ObjectGumball.insertNickel();
        ObjectGumball.insertDime();
        ObjectGumball.insertNickel();
        ObjectGumball.insertNickel();
        ObjectGumball.turnCrank();
        assertEquals(true, ObjectGumball.isGumballInSlot());
        ObjectGumball.insertQuarter();
        ObjectGumball.insertQuarter();
        ObjectGumball.turnCrank();
        assertEquals(true, ObjectGumball.isGumballInSlot());
        ObjectGumball.takeGumballFromSlot();
        assertEquals(false, ObjectGumball.isGumballInSlot());
    }

    @Test
    public void testtakeGumballFromSlot()
    {
        ObjectGumball.insertQuarter();
        ObjectGumball.insertNickel();
        ObjectGumball.insertDime();
        ObjectGumball.insertDime();
        ObjectGumball.turnCrank();
        ObjectGumball.insertDime();
        ObjectGumball.insertQuarter();
        ObjectGumball.insertNickel();
        ObjectGumball.insertQuarter();
        ObjectGumball.turnCrank();
        ObjectGumball.takeGumballFromSlot();
        assertEquals(false, ObjectGumball.isGumballInSlot());
    }
    
    @Test
    public void notEnoughMoneyInSlot()
    {
        ObjectGumball.insertQuarter();
        ObjectGumball.turnCrank();
        assertEquals(false, ObjectGumball.isGumballInSlot());
        System.out.println(ObjectGumball);
    }
    
    @Test
    public void lessAmountFollowedbyEnoughmoneyToDispenseGumball()
    {
        ObjectGumball.insertQuarter();
        ObjectGumball.insertNickel();
        ObjectGumball.insertDime();
        ObjectGumball.turnCrank();
        assertEquals(false, ObjectGumball.isGumballInSlot());
        ObjectGumball.insertQuarter();
        ObjectGumball.turnCrank();
        assertEquals(true, ObjectGumball.isGumballInSlot());
        ObjectGumball.takeGumballFromSlot();
        assertEquals(false, ObjectGumball.isGumballInSlot());
    }
    
    @Test
    public void turnCrankBeforeInsertCoin()
    {
        ObjectGumball.turnCrank();
        assertEquals(false, ObjectGumball.isGumballInSlot()); 
        ObjectGumball.takeGumballFromSlot();
    }
    
    @Test
    public void testIsGumBallInSlot()
    {
        assertEquals(false, ObjectGumball.isGumballInSlot());
    }
}



