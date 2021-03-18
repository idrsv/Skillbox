import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        try(Session session = sessionFactory.openSession();) {
            Course course = session.get(Course.class, 1);
            System.out.println("Название курса: " + course.getName() + "\nКоличество студентов: " + course.getStudentsCount());
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
