package com.kc.controller;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.kc.DAO.DAOFactory;
import com.kc.hibernate.Student;

/*Use RestClient to test
 * 
 * 
 */


@Path("/students")
public class StudentController {
	private Logger log=Logger.getLogger(StudentController.class.getName());

    @GET
    @Path("/getallstudents")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getAllStudent(){
    	log.info("getAllStudent()");
    	List<Student> slist=DAOFactory.getStudentDAO().getAllStudents();
    	return slist;
//    	http://localhost:8080/Lab3/rest/students/getallstudents
    }
    
    @GET
    @Path("/getallstudentsname")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getAllStudentName(){
    	log.info("getAllStudentName()");
    	System.out.println("http://localhost:8080/Lab3/rest/students/getAllStudentsName");
    	List<Student> snamelist=DAOFactory.getStudentDAO().getAllStudentsName();
    	return snamelist;
//    	http://localhost:8080/Lab3/rest/students/getallstudentsname
    }
    
    @POST
    @Path("/savestud")
    @Produces(MediaType.APPLICATION_JSON)
    public String savestud(@FormParam("firstName") String fname,@FormParam("lastName") String lname,@FormParam("section") String sec) {
    	log.info("savestud()");
    	int id=DAOFactory.getStudentDAO().saveStudent(fname, lname, sec);
    	return "Student object is saved with id :"+id;
    	
//    	http://localhost:8080/Lab2-with-HibernetDAO/rest/students/savestud
    }
    
    
    @PUT
    @Path("/getstudbyid")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getStudById(@FormParam("id") int id ) {
    	log.info("getStudById()");
    	System.out.println("getStudById is called");
    	List<Student> slist=DAOFactory.getStudentDAO().getStudentsById(id);
    	return slist;
    	
    	
//    	http://localhost:8080/Lab3/rest/students/getstudbyid/3
    }
    
    @DELETE
    @Path("/deletetud")
    @Produces(MediaType.APPLICATION_JSON)
    public String deletestud(@FormParam("id") int id) {
    	log.info("deletestud()");
    	DAOFactory.getStudentDAO().deleteStudent(id);
    	return "Student deleted with having id:"+id;
    	
//    	http://localhost:8080/Lab3/rest/students/deletetud
    }
    
    @POST
    @Path("/updatestud")
    @Produces(MediaType.APPLICATION_JSON)
    public String updateStudent(@FormParam("id") int id, @FormParam("name") String name) {
    	log.info("updateStudent()");
    	DAOFactory.getStudentDAO().updateStudent(id, name);
    	return "Student updated with having id "+id+ " name "+name;
    	
//    	http://localhost:8080/Lab3/rest/students/updatestud
    }
    
    
}