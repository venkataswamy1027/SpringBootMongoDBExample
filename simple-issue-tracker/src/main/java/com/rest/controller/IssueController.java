package com.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.model.Issue;
import com.rest.repository.IssueRepository;

@RestController
public class IssueController {

	@Autowired
	private IssueRepository issueRepository;

	@GetMapping("/issues")
	public List<Issue> getAllIssues() {
		return issueRepository.findAll();
	}

	@PostMapping("/issues")
	public Issue addIssue(@RequestBody Issue issue) {
		return issueRepository.save(issue);
	}
}
