/**
 * SoldOutState Class used to when gumaballmachine does not have gumballs.
 * @author - Hardik Gandhi
 * @date - 02/18/2015
 */
public class SoldOutState implements State {
    GumballMachine gumballMachine;
    // Constructor initialize gumballmachine object
    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
    //Coin insertion logic 
    public void insertCoin() {
        System.out.println("You can't insert a coin, no gumball present in machine.");
    }
    // Eject coin logic
    public void ejectCoin() {
        System.out.println("Coin won't eject,You haven't inserted a coin yet");
    }
    // crank turn logic when machine is at SoldOutState
    public void turnCrank() {
        System.out.println("Crank turned, but sorry no gumballs");
    }
    // Dispense logic when machine is at SoldOutState
    public void dispense() {
        System.out.println("No gumball dispensed");
    }
 
    public String toString() {
        return "sold out";
    }
}
