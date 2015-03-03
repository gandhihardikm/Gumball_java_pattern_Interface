/**
 * HasCoinState Class is used to indicate coins present in GumballMachine.
 * @author - Hardik Gandhi
 * @date - 02/18/2015
 */
public class HasCoinState implements State {
    GumballMachine gumballMachine;
    // Constructor initialize gumballmachine object
    public HasCoinState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
    //Coin insertion logic
    public void insertCoin() {
        System.out.println("You have inserted another coin.");
    }
    // Eject coin logic
    public void ejectCoin() {
        System.out.println("You can't eject coin");
    }
    // crank turn logic when machine is at HasCoinState
    public void turnCrank() {
        System.out.println("You turned crank!!!");
        gumballMachine.setState(gumballMachine.getSoldState()); //assign SoldState
    }
    // Dispense gumball from gumballmachine when machine has coin
    public void dispense() {
        System.out.println("No gumball dispensed without crankturn");
    }
    // Override toString method to print class message
    public String toString() {
        return "waiting for turn of crank";
    }
}
