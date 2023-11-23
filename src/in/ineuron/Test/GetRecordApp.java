package in.ineuron.Test;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import in.ineuron.model.Employee;
import in.ineuron.util.HibernateUtil;


public class GetRecordApp {

	public static void main(String[] args) {
		
		Session session = null; 
		
		try {
			
			session = HibernateUtil.getSession();
			Query<Employee> query = session.createQuery("from in.ineuron.model.Employee");
			List<Employee> list = query.getResultList();
			list.forEach(System.out::println);
			
		}
		catch (HibernateException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
		
	}

}
