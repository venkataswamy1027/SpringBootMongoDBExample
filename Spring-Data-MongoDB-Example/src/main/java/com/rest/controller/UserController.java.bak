package com.rest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rest.dal.UserDAL;
import com.rest.model.User;
import com.rest.repository.UserRepository;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	private final Logger LOG = LoggerFactory.getLogger(getClass());

	private final UserRepository userRepository;

	private final UserDAL userDAL;

	public UserController(UserRepository userRepository, UserDAL userDAL) {
		this.userRepository = userRepository;
		this.userDAL = userDAL;
	}

	// Getting all users
	@RequestMapping(method = RequestMethod.GET)
	public List<User> getAllUsers() {
		LOG.info("Getting all users.");
		return userRepository.findAll();
	}

	// Getting all users
	@RequestMapping(value = "mongotemplate/all", method = RequestMethod.GET)
	public List<User> getAllUsersByMongoTemplate() {
		LOG.info("Getting all users ByMongoTemplate.");
		return userDAL.getAllUsers();
	}

	// get a specific user with an ID
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public User getUser(@PathVariable String userId) {
		LOG.info("Getting user with ID: {}.", userId);
		return userRepository.findOne(userId);
	}

	// get a specific user with an ID
	@RequestMapping(value = "mongotemplate/{userId}", method = RequestMethod.GET)
	public User getUserByMongoTemplate(@PathVariable String userId) {
		LOG.info("getUserByMongoTemplate: {}.", userId);
		return userRepository.findOne(userId);
	}

	// adding a new user
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public User addNewUsers(@RequestBody User user) {
		LOG.info("Saving user.");
		return userRepository.save(user);
	}

	// adding a new user
	@RequestMapping(value = "mongotemplate/create", method = RequestMethod.POST)
	public User addNewUsersByMongoTemplate(@RequestBody User user) {
		LOG.info("addNewUsersByMongoTemplate.");
		return userDAL.addNewUser(user);
	}

	// Getting User settings
	@RequestMapping(value = "/settings/{userId}", method = RequestMethod.GET)
	public Object getAllUserSettings(@PathVariable String userId) {
		LOG.info("getAllUserSettings.");
		User user = userRepository.findOne(userId);
		if (user != null) {
			return user.getUserSettings();
		} else {
			return "User not found.";
		}
	}

	// Getting User settings
	@RequestMapping(value = "mongotemplate/settings/{userId}", method = RequestMethod.GET)
	public Object getAllUserSettingsByMongoTemplate(@PathVariable String userId) {
		LOG.info("getAllUserSettingsByMongoTemplate.");
		Object object = userDAL.getAllUserSettings(userId);
		if (object != null) {
			return object;
		} else {
			return "User not found.";
		}
	}

	// Getting a particular User setting
	@RequestMapping(value = "/settings/{userId}/{key}", method = RequestMethod.GET)
	public String getUserSetting(@PathVariable String userId, @PathVariable String key) {
		LOG.info("getUserSetting.");
		User user = userRepository.findOne(userId);
		if (user != null) {
			return user.getUserSettings().get(key);
		} else {
			return "User not found.";
		}
	}
	
	@RequestMapping(value = "mongotemplate/settings/{userId}/{key}", method = RequestMethod.GET)
	public String getUserSettingByMongoTemplate(@PathVariable String userId, @PathVariable String key) {
		LOG.info("getUserSettingByMongoTemplate.");
		return userDAL.getUserSetting(userId, key);
	}
	
	@RequestMapping(value = "mongotemplate/settings/{userId}/{key}/{value}", method = RequestMethod.POST)
	public String addUserSettingByMongoTemplate(@PathVariable String userId, @PathVariable String key, @PathVariable String value) {
		LOG.info("addUserSettingByMongoTemplate.");
		return userDAL.addUserSetting(userId, key, value);
	}
}
