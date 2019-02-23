package Java4s;

import org.apache.log4j.Logger;

public class Customer {
	   static Logger log = Logger.getLogger(Customer.class.getName());

	private int custNo;
    private String custName;
    private String custCountry;
    
    public Customer(){
    	log.info( "Customer class instancatiead");
    	log.info("This is info");
    	log.error("this error");
    	log.debug("This is debug");
    	log.fatal("This is fatal");
    }
    
	public int getCustNo() {
		return custNo;
	}
	public void setCustNo(int custNo) {
		this.custNo = custNo;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustCountry() {
		return custCountry;
	}
	public void setCustCountry(String custCountry) {
		this.custCountry = custCountry;
	}
    public void show(){
    	System.out.println("hello");
    	System.out.println("hello");

    }
}
