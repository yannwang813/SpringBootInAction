package cn.ares.jap.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ares.jap.dao.PersonRepository;
import cn.ares.jap.vo.Person;

@RestController
public class DataController {
	
	@Autowired
	private PersonRepository personRepository;
	
	@RequestMapping("/auto")
	public Page<Person> auto(Person person) {
		Page<Person> pagePeople = personRepository.findByAuto(person, new PageRequest(0, 10));
		return pagePeople;
	}
}
