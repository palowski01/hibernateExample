package edu.guc.bootcamp.java.william.palowski.hibernateexample;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import org.hibernate.criterion.Restrictions;

public class HibernateDemo {
	
	static SessionFactory factory = new Configuration().configure().buildSessionFactory();
	
	public static void main(String[] args) {
	
		HibernateDemo demo = new HibernateDemo();
//		demo.createHibernateUsers();
//		demo.getHibernateUsersOne();
//		demo.printHibernateUsers(demo.getHibernateUsersTwo());
//		demo.getHibernateUsersThree();
		demo.updateHibernateUsers(4);
	}
	
	private void getHibernateUsersOne() {
		HibernateUsers user1 = new HibernateUsers();
		Session session = factory.openSession();
		session.beginTransaction();
		user1 = session.get(HibernateUsers.class, 1);
		session.getTransaction().commit();
		System.out.println("Email = " + user1.getUserEmailAddress());
	}
	
	private void getHibernateUsersThree() {
		
		try {
			
			Session session = factory.openSession();
			session.beginTransaction();
			Criteria crit = session.createCriteria(HibernateUsers.class);
			crit.add(Restrictions.eq("userId", 2));
			HibernateUsers hibernate = (HibernateUsers) crit.uniqueResult();
			if (hibernate != null) {
				System.out.println(hibernate.isHasHair());
			}
			
			session.getTransaction().commit();
			
		}
		catch(HibernateException e) {
			System.out.println("Ooops!");
		}
		
	}
	
	private boolean updateHibernateUsers(int id) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		CriteriaBuilder bob = session.getCriteriaBuilder();
		CriteriaUpdate<HibernateUsers> criteria = bob.createCriteriaUpdate(HibernateUsers.class);
		Root<HibernateUsers> groot = criteria.from(HibernateUsers.class);
		criteria.set(groot.get("salary"), 99000.00);
		criteria.where(bob.equal(groot.get("userId"), id));
		session.createQuery(criteria).executeUpdate();
		tx.commit();
		
		return true;
	}
	
	private void printHibernateUsers(List<HibernateUsers> list) {
		for(HibernateUsers h: list) {
			System.out.println(h);
		}
	}
	
	private List<HibernateUsers> getHibernateUsersTwo() {
		
		List<HibernateUsers> allUsers = null;
		
		try {
			Session session = factory.openSession();
//			allUsers = session.createCriteria(HibernateUsers.class).list();
			
			 CriteriaQuery<HibernateUsers> criteriaQuery = 
					 session.getCriteriaBuilder().createQuery(HibernateUsers.class);
					         criteriaQuery.from(HibernateUsers.class);
			allUsers = session.createQuery(criteriaQuery).getResultList();

			
		}
		catch(Exception e) {
		
		}
		
		return allUsers;
	}
	
	public void createStudentDetails() {
		
		StudentDetails student1 = new StudentDetails();
		student1.setFirstName("Bruce");
		student1.setLastName("Wayne");
		student1.setStudent_id(10);
		
		StudentDetails student2 = new StudentDetails();
		student2.setFirstName("Bruce");
		student2.setLastName("Banner");
		student2.setStudent_id(9);
		
		StudentDetails student3 = new StudentDetails();
		student3.setFirstName("Peter");
		student3.setLastName("Parker");
		student3.setStudent_id(8);
		
		
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(student1);
		session.save(student2);
		session.save(student3);
		session.getTransaction().commit();
		
	}
	
	public void createHibernateUsers() {
		Scanner input = new Scanner(System.in);
		HibernateUsers user1 = new HibernateUsers();
		List<Integer> id = new ArrayList<Integer>();
		id.add(1);
		id.add(2);
		id.add(3);
		id.add(4);
		id.add(5);
		id.add(6);
		int idToAdd;
//		user1.setUserId(2);
//		user1.setHasHair(true);
//		user1.setSalary(50000.00);
//		user1.setUserEmailAddress("bill@gmail.com");
		String ans = "n";
		System.out.println("We are creating Hibernate Users.  Please enter information below");
		do {
			System.out.print("Enter user id: ");
			String newId = input.nextLine();
			idToAdd = Integer.parseInt(newId);
			while(id.contains(idToAdd)) {
				System.out.print("That id already exists. Please pick a new id: ");
				newId = input.nextLine();
				idToAdd = Integer.parseInt(newId);
			}
			id.add(idToAdd);
			System.out.println(id);
			
			System.out.print("Enter user salary: ");
			String newSalary = input.nextLine();
			
			System.out.print("Does the user have hair? (y/n): ");
			String answer = input.nextLine().toLowerCase();
			if (answer.equals("y")) {
				user1.setHasHair(true);
			}
			else {
				user1.setHasHair(false);
			}
			
			System.out.print("Enter user email address: ");
			String emailAddress = input.nextLine();
			
			user1.setUserId(idToAdd);
			user1.setSalary(Double.parseDouble(newSalary));
			user1.setUserEmailAddress(emailAddress);
			
			
			Session session = factory.openSession();
			session.beginTransaction();
			session.save(user1);
			session.getTransaction().commit();
			
			System.out.println("would you like to enter another user? (y/n): ");
			ans = input.nextLine().toLowerCase();
			
		}while(ans.equals("y"));
		
		
//		SessionFactory factory = new Configuration().configure().buildSessionFactory();
//		Session session = factory.openSession();
//		session.beginTransaction();
//		session.save(user1);
//		session.getTransaction().commit();
		
	}

}
