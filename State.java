/**
 * State interface declared methods which needs to be implemented by different state(GumballMachine state) classes.
 * @author - Hardik Gandhi
 * @Date - 02/18/2015
 */

public interface State {
	public void turnCrank();
	public void dispense();
	public void insertCoin();
	public void ejectCoin();
}
