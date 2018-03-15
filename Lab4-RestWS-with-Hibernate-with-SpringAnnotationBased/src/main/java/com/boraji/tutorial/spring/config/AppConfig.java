package com.boraji.tutorial.spring.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import static org.hibernate.cfg.Environment.*;

@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@ComponentScans(value = { @ComponentScan("com.boraji.tutorial.spring.dao"),
      @ComponentScan("com.boraji.tutorial.spring.service") })
public class AppConfig {

   @Autowired
   private Environment env;

   @Bean
   public LocalSessionFactoryBean getSessionFactory() {
      LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();

      Properties props = new Properties();
      // Setting JDBC properties
//      props.put(DRIVER, env.getProperty("mysql.driver"));
//      props.put(URL, env.getProperty("mysql.url"));
//      props.put(USER, env.getProperty("mysql.user"));
//      props.put(PASS, env.getProperty("mysql.password"));
      
      props.put(DRIVER, "com.mysql.jdbc.Driver");
      props.put(URL, "jdbc:mysql://localhost:3306/db1");
      props.put(USER, "root");
      props.put(PASS, "kofel");
      
      System.out.println("Properties:"+props);

      // Setting Hibernate properties
//      props.put(SHOW_SQL, env.getProperty("hibernate.show_sql"));
//      props.put(HBM2DDL_AUTO, env.getProperty("hibernate.hbm2ddl.auto"));
      props.put("hibernate.dialect","true");
      props.put(HBM2DDL_AUTO, "update");
      props.put("hibernate.dialect","org.hibernate.dialect.MySQLDialect");

      // Setting C3P0 properties
//      props.put(C3P0_MIN_SIZE, env.getProperty("hibernate.c3p0.min_size"));
//      props.put(C3P0_MAX_SIZE, env.getProperty("hibernate.c3p0.max_size"));
//      props.put(C3P0_ACQUIRE_INCREMENT, 
//            env.getProperty("hibernate.c3p0.acquire_increment"));
//      props.put(C3P0_TIMEOUT, env.getProperty("hibernate.c3p0.timeout"));
//      props.put(C3P0_MAX_STATEMENTS, env.getProperty("hibernate.c3p0.max_statements"));
      
      props.put(C3P0_MIN_SIZE, 5);
      props.put(C3P0_MAX_SIZE, 20);
      props.put(C3P0_ACQUIRE_INCREMENT, 1);
      props.put(C3P0_TIMEOUT, 1800);
      props.put(C3P0_MAX_STATEMENTS, 150);
      
      System.out.println("Properties:"+props);

      factoryBean.setHibernateProperties(props);
      factoryBean.setPackagesToScan("com.boraji.tutorial.spring.model");

      	System.out.println("FactgoryBean:"+factoryBean);
      return factoryBean;
   }

   @Bean
   public HibernateTransactionManager getTransactionManager() {
      HibernateTransactionManager transactionManager = new HibernateTransactionManager();
      transactionManager.setSessionFactory(getSessionFactory().getObject());
      System.out.println("TransactionManager:"+transactionManager);
      return transactionManager;
   }
}