package spring_mvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import spring_mvc.dto.Employee;

@Repository
public class EmployeeDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("magician");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	
	public Employee empSave(Employee emp) {
		et.begin();
		em.persist(emp);
		et.commit();
		return emp;
	}
	public Employee loginEmp(Employee employee) throws Exception{
		Query query = em.createQuery("select a from Employee a where a.email=?1 and a.password=?2");
		query.setParameter(1, employee.getEmail());
		query.setParameter(2, employee.getPassword());
		return (Employee)query.getSingleResult();
	}
	
	public List<Employee> empFetchAll() {
		Query query = em.createQuery("select a from Employee a");
		return query.getResultList();
		
	}
	public Employee fetch(int id) {
		Query q = em.createQuery("select e from Employee e where e.eNo=?1");
		q.setParameter(1, id);

		return (Employee) q.getSingleResult();

	}
	
	public Employee empUpdate(Employee e1) {
		if (e1!=null) {
			et.begin();
			em.merge(e1);
			et.commit();
			return e1;
		}
		else {
			return null;
		}
		
	}
	
	public Employee empDelete(int id) {
		Employee emp = em.find(Employee.class, id);
		if(emp!=null) {
			et.begin();
			em.remove(emp);
			et.commit();
			return emp;
		}else {
			return null;
		}
		
	}
}
