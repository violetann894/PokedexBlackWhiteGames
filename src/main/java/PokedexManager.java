
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PokedexManager {
	private SessionFactory factory;

	public PokedexManager() {
		factory = new Configuration().configure().buildSessionFactory();
	}

	public void addItem(Pokemon item) {
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(item);
		session.getTransaction().commit();
		session.close();
	}

	public Pokemon getItem(int id) {
		Session session = factory.openSession();
		Pokemon item = session.get(Pokemon.class, id);
		session.close();
		return item;
	}

	public void updateItem(Pokemon item) {
		Session session = factory.openSession();
		session.beginTransaction();
		session.update(item);
		session.getTransaction().commit();
		session.close();
	}

	public void deleteItem(int id) {
		Session session = factory.openSession();
		session.beginTransaction();
		Pokemon item = session.get(Pokemon.class, id);
		if(item != null) {
			session.delete(item);
		}
		session.getTransaction().commit();
		session.close();
	}
}
