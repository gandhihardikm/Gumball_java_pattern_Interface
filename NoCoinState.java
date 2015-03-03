/**
 * NoCoinState Class is used to indicate currently no coin present in GumballMachine.
 * @author - Hardik Gandhi
 * @date - 02/18/2015
 */
public class NoCoinState implements State {
    GumballMachine gumballMachine;
    // Constructor initialize gumballmachine object
    public NoCoinState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
    //Coin insertion logic
    public void insertCoin() {
        gumballMachine.setState(gumballMachine.getHasCoinState()); // Assign HasCoinState
    }
    // Eject coin logic
    public void ejectCoin() {
        System.out.println("You haven't inserted a coin");
    }
    // crank turn logic when machine is at NoCoinState
    public void turnCrank() {
        System.out.println("You turned, but there's no coin");
     }
    // Dispense gumball from gumballmachine when machine has no coin
    public void dispense() {
        System.out.println("You need to pay first");
    } 
    // Override toString method to print class message
    public String toString() {
        return "waiting for coin";
    }
}
