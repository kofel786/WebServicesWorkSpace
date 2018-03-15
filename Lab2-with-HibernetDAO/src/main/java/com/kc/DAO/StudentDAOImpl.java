package com.kc.DAO;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.kc.DAO.StudentDAO;
import com.kc.hibernate.HibernateUtil;
import com.kc.hibernate.Student;

/**
 * Class used to perform CRUD operation on database with Hibernate API's
 * 
 */
public class StudentDAOImpl  implements StudentDAO{
	public static Logger log=Logger.getLogger(StudentDAOImpl.class.getName());

    /**
     * This method saves a Student object in database
     */
    public int saveStudent(String firstName, String lastName, String section) {
    	log.info("saveStudent()");
        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setSection(section);
 
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
 
        int id = (Integer) session.save(student);
        session.getTransaction().commit();
        session.close();
        return id;
    }
 
    /**
     * This method returns list of all persisted Student objects/tuples from
     * database
     */
    public List<Student> getAllStudents() {
    	log.info("getAllStudents()");
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
 
        @SuppressWarnings("unchecked")
        List<Student> employees = (List<Student>) session.createQuery(
                "FROM Student s ORDER BY s.firstName ASC").list();
 
        session.getTransaction().commit();
        session.close();
        return employees;
    }
 
    /**
     * This method returns list of all students name
     */
    public List<Student> getAllStudentsName() {
    	log.info("getAllStudentsName()");
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
 
        @SuppressWarnings("unchecked")
        List<Student> student = (List<Student>) session.createQuery(
                "select stud.firstName,stud.lastName from Student stud").list();
 
        session.getTransaction().commit();
        session.close();
        return student;
    }
    
    /**
     * This method returns student info based on Id
     */
    public List<Student> getStudentsById(int id) {
    	log.info("getStudentsById(int)");
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
 
        @SuppressWarnings("unchecked")
        List< Student> slist = (List<Student>) session.createQuery(
                "FROM Student s where s.id=?").setParameter(0, id).list();
 
        session.getTransaction().commit();
        session.close();
        return slist;
    }
    /**
     * This method updates a specific Student object by name
     */
    public void updateStudent(int id, String name) {
    	log.info("updateStudent(int,String)");
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
 
        Student student = (Student) session.get(Student.class, id);
        student.setFirstName(name);
        //session.update(student);//No need to update manually as it will be updated automatically on transaction close.
        session.getTransaction().commit();
        session.close();
    }
 
    /**
     * This method deletes a specific Student based on Id
     */
    public void deleteStudent(int id) {
    	log.info("deleteStudent(int)");
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
 
        Student student = (Student) session.get(Student.class, id);
        session.delete(student);
        session.getTransaction().commit();
        session.close();
    }
}
