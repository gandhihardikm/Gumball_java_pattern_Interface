/*
 * GumballMachine class has implemented all methods of interface IGumballMachine. This class 
 * is mainly working as a GumballMachineController where coins is inserted, gumball is collected, 
 * cashchange is received and many other functionality.
 * Gumabll Machine accepts Quarter, Dime, Nickel.
 * @author - Hardik Gandhi
 * @date - 02/18/2015
 */

public class GumballMachine implements IGumballMachine {
    //state variable declared
    State objectSoldOutState;
    State objectNoCoinState;
    State objectHasCoinState;
    State objectSoldState;
    // Assign soldOutState reference to state variable when GumballMachine start
    State state = objectSoldOutState;
    // Declared interger variable 
    int iGumballInSlot = 0, gumballCount=0,iTotalMoneyInserted = 0,iCostOfGumball = 50;
 
    public GumballMachine(int gumballCount) {
        // Instantiated each state object and passing GumballMachine object reference
        objectSoldOutState = new SoldOutState(this);
        objectSoldState = new SoldState(this);
        objectNoCoinState = new NoCoinState(this);
        objectHasCoinState = new HasCoinState(this);
        
        //gumballCount is for total gumballs present in machine
        this.gumballCount = gumballCount;
        if (gumballCount > 0) { 
            //NoCoinState will assign when gumballcount is more than zero.
            state = objectNoCoinState; 
        } 
    }
    
    // Below function is written to maintain total money inserted in GumballMachine
    public void insertMoneyToGumballMachine(int cashIn){
        iTotalMoneyInserted += cashIn;  //Total money
    }
 
    // Below function is written to insert 25 cents in GumballMachine
    public void insertQuarter() {
        insertMoneyToGumballMachine(25);  //Passing 25 value because customer inserted Quarter.
        state.insertCoin();  // insertCoin() method called depending upon state value.
        System.out.println("You inserted a quarter");        
    }
    
    // Below function is written to insert 10 cents in GumballMachine
    public void insertDime() {
        insertMoneyToGumballMachine(10);  //Passing 10 value because customer inserted Dime.
        state.insertCoin();  // insertCoin() method called depending upon state value.
        System.out.println("You inserted a Dime");            
    }
    
    // Below function is written to insert 5 cents in GumballMachine
    public void insertNickel() {
        insertMoneyToGumballMachine(5);  //Passing 5 value because customer inserted Nickel.
        state.insertCoin();  // insertCoin() method called depending upon state value.
        System.out.println("You inserted a Nickel");        
    }
    
    // Below function tells whether Gumball is present in the slot or not.
    public boolean isGumballInSlot() {
        // iGumballInSlot variable track how many gumball present in Slot.
        if(iGumballInSlot > 0)   
            return true;
        else
            return false;
    }
    
    
   // Below function is used when customer takes gumball/gumballs from slot.
    public void takeGumballFromSlot() {
        System.out.println("Gumball is taken from slot");
        iGumballInSlot = 0;
    }
    
    // Below function is used to calculate how much change should be given to customer.
    public void getRemainingMoney(int iCostOfGumball){
        iTotalMoneyInserted -= iCostOfGumball;  // Deducting Gumball cost from total money
    }

    // Below function is used to turn crank of gumballmachine
    public void turnCrank() {
        // Condition for money has to be greater than 50 cent and minimum 1 gumball should be there
        if(iTotalMoneyInserted >= 50 && gumballCount >= 0) {
            state.turnCrank();
            state.dispense();
            getRemainingMoney(iCostOfGumball);
            System.out.println("Your change money,Sir : " + iTotalMoneyInserted);
        }
        else {
            System.out.println("Not Enough Money to eject Gumball, Sir!");
        } 
    }
    
    // Below function is used to set state variable 
    void setState(State state) {
        this.state = state;
    }
 
    // Below function is for giving gumball from gumballmachine.
    void releaseBall() {
        System.out.println("Gumball has come. Please collect Sir!!!");
        iGumballInSlot += 1;  // Increment gumball in slot
        if (gumballCount != 0) {
            gumballCount = gumballCount - 1;  // Decrement gumball count
        }
    }
 
    // Below function is used return gumballcount 
    int getCount() {
        return gumballCount;
    }
 
    void refill(int gumballCount) {
        this.gumballCount = gumballCount;
        state = objectNoCoinState;
    }

    // Below function return state reference 
    public State getState() {
        return state;
    }

    // Below function return object reference
    public State getSoldOutState() {
        return objectSoldOutState;
    }

    // Below function return object reference
    public State getNoCoinState() {
        return objectNoCoinState;
    }

    // Below function return object reference
    public State getHasCoinState() {
        return objectHasCoinState;
    }

    // Below function return object reference
    public State getSoldState() {
        return objectSoldState;
    }
 
    // Overriding toString method to print Gumabll Machine message
    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("\nMighty Gumball, Inc.");
        result.append("\nJava-enabled Standing Gumball Model #2004");
        result.append("\nInventory: " + gumballCount + " gumball");
        if (gumballCount != 1) {    // Checking if more than gumball is there or not.
            result.append("s");
        }
        result.append("\n");
        result.append("Machine is " + state + "\n");
        result.append("Money Left : " + iTotalMoneyInserted);
        return result.toString();
    }
}
