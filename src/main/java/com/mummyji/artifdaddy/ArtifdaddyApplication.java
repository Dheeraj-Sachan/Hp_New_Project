package com.mummyji.artifdaddy;

import com.mummyji.artifdaddy.service.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ArtifdaddyApplication implements CommandLineRunner {
    @Autowired

    public static void main(String[] args) {
        SpringApplication.run(ArtifdaddyApplication.class, args);
        System.out.println("I am in main class");
        Student s2 = new Student(2, "Vivek Sachan", "Army School");
        Student s3 = new Student(3, "Mummy Sachan", "Army School");
        Student s4 = new Student(4, "Daddy Sachan", "Army School");
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();

        session.save(s3);
        session.save(s4);

        Transaction tx = session.beginTransaction();
        tx.commit();
        System.out.println(factory);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("I am here");


    }
}
