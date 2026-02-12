package com.tka.sams.api.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.sams.api.entity.Users;
import com.tka.sams.api.model.LoginRequest;

@Repository
public class UserDao {

	@Autowired
	private SessionFactory factory;

	public Users loginUser(LoginRequest request) {
		Session session = null;
		Users user = null;
		try {
			session = factory.openSession();
			user = session.get(Users.class, request.getUsername());
			if (user != null) {
				if (user.getPassword().equals(request.getPassword())) {
					return user;
				}
			} else {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String deleteUserById(String username) {
		Session session = null;
		String msg = null;
		try {
			session = factory.openSession();
			Users user = session.get(Users.class, username);
			session.delete(user);
			session.beginTransaction().commit();
			msg = "deleted";

		} catch (Exception e) {
			msg = null;
			e.printStackTrace();
		} finally {
			session.close();
		}
		return msg;
	}

	public Users updateUser(Users user) {
		Session session = null;

		try {
			session = factory.openSession();
			session.update(user);
			session.beginTransaction().commit();
			return user;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Users> getAllUser() {
		Session session = null;
		List<Users> list = null;
		try {
			session = factory.openSession();
			Criteria criteria = session.createCriteria(Users.class);
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	public Users getUserByName(String username) {
		Session session = null;
		Users user = null;
		try {
			session = factory.openSession();
			user = session.get(Users.class, username);

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			session.close();
		}
		return user;
	}

	public Users registerUser(Users user) {
		Session session = null;
		Users user2 = null;
		try {
			session = factory.openSession();
			user2 = session.get(Users.class, user.getUsername());
			if (user2 == null) {
				session.save(user);
				session.beginTransaction().commit();
				return user;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
		return null;
	}

	public List<Users> getAllAdmins() {
		Session session = null;
		List<Users> list = null;
		try {
			session = factory.openSession();
			Criteria criteria = session.createCriteria(Users.class);
			criteria.add(Restrictions.eq("role", "admin"));
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
	
	public List<Users> getAllFaculties() {
		Session session = null;
		List<Users> list = null;
		try {
			session = factory.openSession();
			Criteria criteria = session.createCriteria(Users.class);
			criteria.add(Restrictions.eq("role", "faculty"));
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

}
