package com.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.WriteResult;
import com.rest.model.Domain;
import com.rest.repository.DomainRepository;

@RestController
public class DomainController {

	@Autowired
	private DomainRepository domainRepository;

	@Autowired
	private MongoTemplate mongoTemplate;

	@PostMapping("/addDomain")
	public String saveDomain(@RequestBody Domain domain) {
		domainRepository.save(domain);
		return "Added domain with id : " + domain.getId();
	}

	@GetMapping("/findAllDomains")
	public List<Domain> getDomains() {
		return domainRepository.findAll();
	}

	@GetMapping("/findFirstByDomain/{domain}")
	public Domain findFirstByDomain(@PathVariable String domain) {
		return domainRepository.findFirstByDomain(domain);
	}

	@GetMapping("/findCustomByDomain/{domain}")
	public Domain findCustomByDomain(@PathVariable String domain) {
		return domainRepository.findCustomByDomain(domain);
	}

	@GetMapping("/findCustomByRegExDomain/{domain}")
	public List<Domain> findCustomByRegExDomain(@PathVariable String domain) {
		return domainRepository.findCustomByRegExDomain(domain);
	}

	@PutMapping("/updateDomain")
	public int updateDomainByDisplayAds(@RequestParam String domain, @RequestParam boolean displayAds) {
		Query query = new Query(Criteria.where("domain").is(domain));
		Update update = new Update();
		update.set("displayAds", displayAds);

		WriteResult result = mongoTemplate.updateFirst(query, update, Domain.class);

		if (result != null)
			return result.getN();
		else
			return 0;
	}
}
