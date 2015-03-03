/**
 * IGumballMachine Interface has declared methods which all need to implemented by GumballMachine class.
 * 
 * @author - Hardik Gandhi
 * @date - 02/18/2015
 */
public interface IGumballMachine
{
    void insertQuarter();
    void insertDime();
    void insertNickel();
    void turnCrank();
    boolean isGumballInSlot();
    void takeGumballFromSlot();
    
}
