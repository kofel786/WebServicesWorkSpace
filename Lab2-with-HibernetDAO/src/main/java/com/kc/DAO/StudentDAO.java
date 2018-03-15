package com.kc.DAO;

import java.util.List;

import com.kc.hibernate.Student;

public interface StudentDAO {
	  public int saveStudent(String firstName, String lastName, String section);
	    public List<Student> getAllStudents() ;
	    public List<Student> getAllStudentsName();
	    public List<Student> getStudentsById(int id) ;
	    public void updateStudent(int id, String name) ;
	    public void deleteStudent(int id) ;
}
