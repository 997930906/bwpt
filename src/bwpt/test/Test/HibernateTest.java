package bwpt.test.Test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

public class HibernateTest {

	@Test
	public void run11(){
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		
		String hql = "from AppMenu  ";
		Query query = session.createQuery(hql);
		List list = query.list();
		tx.commit();
		session.close();
	}
}
