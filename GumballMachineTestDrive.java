

public class GumballMachineTestDrive {

	public static void main(String[] args) {
		GumballMachine gumballM1 = new GumballMachine(3);

		
        gumballM1.insertQuarter();
        gumballM1.insertNickel();
        gumballM1.insertDime();
        gumballM1.insertDime();
        gumballM1.turnCrank();
        gumballM1.insertDime();
        gumballM1.insertQuarter();
        gumballM1.insertNickel();
        gumballM1.insertQuarter();
        gumballM1.turnCrank();
        gumballM1.takeGumballFromSlot();
	}
}
