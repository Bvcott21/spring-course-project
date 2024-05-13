package com.bucott.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static List<User> users = new ArrayList<>();
	private static int usersCount = 0;
	
	static {
		users.add(new User(++usersCount, "Adam", LocalDate.now().minusYears(30)));
		users.add(new User(++usersCount, "John", LocalDate.now().minusYears(17)));
		users.add(new User(++usersCount, "Mike", LocalDate.now().minusYears(55)));
	}
	
	public List<User> findAll() {
		return users;
	}
	
	public User save(User user) {
		user.setId(++usersCount);
		users.add(user);
		return user;
	}
	
	public User findOne(int id) {
		return users
			.stream()
			.filter(user -> user.getId().equals(id))
			.findFirst()
			.orElse(null);
	}
	
	public void deleteById(int id) {
		users.removeIf(user -> user.getId().equals(id));
	}
}
