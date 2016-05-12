package com.foodmood.services;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.foodmood.models.User;
import com.foodmood.repositories.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;

	//@Resource
    //private SessionFactory sessionFactory;

	
	public UserService() {
		
	}


	public User saveUser(HttpServletRequest request) {
		User user = createUser(request);
		user = userRepository.saveAndFlush(user);
		return user;
	}
	

	public User getUser(Long id) {
		return (User) userRepository.findOne(id);
	}	
	
	public void deleteRecipe(Long id) {
		userRepository.delete(id);
	}	
			
	public List<User> getAllUsers() {
		List<User> users = userRepository.findAll();
		return users;
	}
	
	
	public User loginUser(Long id, String username, String password)  {
		List<User> users = userRepository.findAll();
		User getUser = userRepository.findOne(id); //get only one user
		User user = null;
		for(User currentUser : users ) {
			System.out.println("username: " + currentUser.getUsername());
			if(currentUser.getUsername().equals(username) && currentUser.getPassword().equals(password)) {
				user = currentUser;
				System.out.println("found user");
				break;
			}
		}
		return user;
	}
	
	private User createUser(HttpServletRequest request) {
		String username = request.getParameter("registerUsername");
		String password = request.getParameter("registerPassword");
		String name = request.getParameter("registerName");
		String email = request.getParameter("registerEmail");
		String address1 = request.getParameter("registerAddress1");
		String address2 = request.getParameter("registerAddress2");
		String phonenumber = request.getParameter("registerPhonenumber");
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setName(name);
		user.setEmail(email);
		user.setAddress1(address1);
		user.setAddress2(address2);
		user.setPhoneNumber(phonenumber);
		user.setId(user.getId());
		//detta gör alla users till admin, fixa sen!!
		//user.setAdmin(true);
					
		return user;
	}


	
	
	public User updateUser(HttpServletRequest request, Long id) {
		User currentUser = null;
		try {
			if (id != null && request != null) {
				currentUser = (User)userRepository.findOne(id);
				currentUser.setUsername(request.getParameter("username"));
				userRepository.saveAndFlush(currentUser);
				request.getSession().setAttribute("updateuser", currentUser);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			//throw new UserNotFoundException();
		}
		/*
		 
		FORTSÄTT KOLLA UPP sessionfactory och annotation för injection....
		
		
		final Session session = sessionFactory.getCurrentSession();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		String phonenumber = request.getParameter("phonenumber");
		
		User user = (User) session.get(User.class, id);
		
		user.setUsername(username);
		user.setPassword(password);
		user.setName(name);
		user.setEmail(email);
		user.setAddress1(address1);
		user.setAddress2(address2);
		user.setPhoneNumber(phonenumber);
		
		session.update(user);
		*/
		return currentUser;
		
	}


	
	
	
	
	
}
