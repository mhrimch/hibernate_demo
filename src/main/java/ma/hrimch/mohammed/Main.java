package ma.hrimch.mohammed;

import ma.hrimch.mohammed.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Main {
    public static void main(String[] args) {

        Student str1 = new Student("mohammed Hrimch", "java");

        System.out.println("--->strarting transaction<---");
        // Hibernate SessionFactory erstellen
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")  // Hibernate-Konfigurationsdatei laden
                .addAnnotatedClass(Student.class)  // Entity manuell hinzufügen
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            session.persist(str1);
            session.getTransaction().commit();
            System.out.println("---> Transaction committed <---");
        } finally {
            factory.close();
        }
    }
}