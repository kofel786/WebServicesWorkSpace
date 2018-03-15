package com.kc.DAO;

import org.apache.log4j.Logger;

public class DAOFactory {
	private static Logger log=Logger.getLogger(DAOFactory.class.getName());
public static StudentDAO stuDAO=new StudentDAOImpl();
public static  StudentDAO getStudentDAO(){
	log.info("getStudentDao()");
	return stuDAO;
}
}
