package in.ineuron.Test;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import in.ineuron.model.Employee;
import in.ineuron.util.HibernateUtil;


public class InsertApp {

	public static void main(String[] args) {
		
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		
		try {
			session = HibernateUtil.getSession();
			
			if(session != null) {
				transaction = session.beginTransaction();
			}
			
			if(transaction != null) {
				
				Employee emp = new Employee();
				emp.setEid(10);
				emp.setEname("Rahul");
				emp.setEaddress("Pune");
				
				emp.setFriendList(List.of("Rohit", "Sakshi", "Malaika"));
				emp.setPhones(Set.of(9857478745L, 5874787455L, 5874785878L));
				emp.setBankAccounts(Map.of("SBI", 112233L, "HDFC", 223344L, "ICICI", 112244L));
				
				flag = true;
				session.save(emp);
			}
		}
		catch (HibernateException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(flag) {
				transaction.commit();
				System.out.println("Object Inserted in the DB");
			}
			else {
				transaction.rollback();
				System.out.println("Object Failed to insert");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
		
	}

}
