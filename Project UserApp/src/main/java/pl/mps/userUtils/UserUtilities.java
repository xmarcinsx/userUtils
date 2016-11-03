package pl.mps.userUtils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.SourceType;
import org.hibernate.cfg.Configuration;
import java.util.Collection;

public class UserUtilities {
    public static SessionFactory sessionFactory;

    UserUtilities() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public void closeSessionFactory(){
        sessionFactory.close();
    }

    public void addUser(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    public User getUserById(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        User user= session.get(User.class, id);
        session.getTransaction().commit();
        session.close();
        return user;
    }

    public Collection<Car> getCarsForUser(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        User user= session.get(User.class, id);
        session.getTransaction().commit();
        session.close();
        return user.getCars();
    }

    public void changeUserEmail(int id, String email){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        User user= session.get(User.class, id);
        user.setEmail("xyz@qwert.pl");
        session.getTransaction().commit();
        session.close();
    }

    public void deleteUser(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        User user= session.get(User.class, id);
        session.delete(user);
        session.getTransaction().commit();
        session.close();
    }

    public void addCarForUser(int id, String nameCar) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        User user= session.get(User.class, id);
        Car car = new CarBuilder()
                .setNameCar(nameCar)
                .setOwner(user)
                .build();
        session.save(car);
        session.getTransaction().commit();
        session.close();
    }
}
