	package com.myMiniProject.javaspringboot.miniproject.user;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserServices {
	
	private static List<User> users = new ArrayList<>();
	private static int usersCount = 0;
	
	static {
		users.add(new User(++usersCount,"SaiKumar","A+","saikumar@gmail.com","java"));
		users.add(new User(++usersCount,"Kumar","O+","kumar@gmail.com","C++"));
		users.add(new User(++usersCount,"Lakshmi","B-","lakshmi@gmail.com","python"));
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
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		return users.stream().filter(predicate).findFirst().orElse(null);
	}
	
//	public User findOne(String name) {
//		Predicate<? super User> predicate = user -> user.getName().equals(name);
//		return users.stream().filter(predicate).findFirst().orElse(null);
//	}

	public void deleteById(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		users.removeIf(predicate);
	}
	
	public void editById(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		users.removeIf(predicate);
	}

//	public void deleteByName(String name) {
//		Predicate<? super User> predicate = user -> user.getName().equals(name);
//		users.removeIf(predicate);
//	}
	
//	public User filterUserByBloodGroup(String bloodGroup) {
//		Predicate<? super User> predicate = user -> user.getBloodGroup().equals(bloodGroup);
//		return (User) users.stream().filter(predicate).map(user -> user.getBloodGroup());
//	}

}
