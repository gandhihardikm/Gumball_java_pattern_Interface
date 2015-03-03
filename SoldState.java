/**
 * SoldState Class used to dispense gumball from machine.
 * @author - Hardik Gandhi
 * @date - 02/18/2015
 */
public class SoldState implements State {
 
    GumballMachine gumballMachine;
    // Constructor initialize gumballmachine object
    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
    //Coin insertion logic 
    public void insertCoin() {
        System.out.println("Please wait, we're already giving you a gumball");
    }
    // Eject coin logic
    public void ejectCoin() {
        System.out.println("Sorry, you already turned the crank");
    }
    // crank turn logic when machine is at SoldState
    public void turnCrank() {
        System.out.println("Turning twice doesn't get you another gumball!");
    }
 
    // Dispense gumball from gumballmachine
    public void dispense() {
        gumballMachine.releaseBall();
        // After ejecting gumball, checking if gumballmachine has gumball or not.
        if (gumballMachine.getCount() > 0) {
            gumballMachine.setState(gumballMachine.getNoCoinState()); // assigning NoCoinState
        } else {
            System.out.println("Oops, out of gumballs!");
            gumballMachine.setState(gumballMachine.getSoldOutState()); //assigning SoldOutState
        }
    }
 
    public String toString() {
        return "dispensing a gumball";
    }
}


