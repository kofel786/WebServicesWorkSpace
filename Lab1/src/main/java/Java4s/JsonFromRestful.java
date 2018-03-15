package Java4s;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

@Path("/customers")
public class JsonFromRestful {
	   static Logger log = Logger.getLogger(JsonFromRestful.class.getName());
	   public JsonFromRestful(){
		   log.info("JsonFromRestful is instancated");
		   log.debug("JsonFromRestful is instancated");
	   }
    @GET
    @Path("/{cusNo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer produceCustomerDetailsinJSON(@PathParam("cusNo") int no) {
		   log.info("produceCustomerDetailsinJSON is instancated");

        /*
         * I AM PASSING CUST.NO AS AN INPUT, SO WRITE SOME BACKEND RELATED STUFF AND
         * FIND THE CUSTOMER DETAILS WITH THAT ID. AND FINALLY SET THOSE RETRIEVED VALUES TO
         * THE CUSTOMER OBJECT AND RETURN IT, HOWEVER IT WILL RETURN IN JSON FORMAT :-)
         * */
        
        Customer cust = new Customer();        
            cust .setCustNo(no);
            cust .setCustName("Java4s");
            cust .setCustCountry("India");
        return cust;
    }
}