package cn.ares.mongodb.web;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ares.mongodb.dao.PersonRepository;
import cn.ares.mongodb.vo.Location;
import cn.ares.mongodb.vo.Person;

@RestController
public class DataController {
	
	@Autowired
	private PersonRepository personRepository;
	
	@RequestMapping("/save")
	public Person save() {
		Person p = new Person("权胖", 18);
		Collection<Location> locations = new LinkedHashSet<Location>();
		Location loc1 = new Location("哈尔滨", "2009");
		Location loc2 = new Location("深圳", "2010");
		Location loc3 = new Location("武汉", "2011");
		Location loc4 = new Location("北京", "2012");
		locations.add(loc1);
		locations.add(loc2);
		locations.add(loc3);
		locations.add(loc4);
		p.setLocations(locations);
		return personRepository.save(p);
	}

	@RequestMapping("/q1")
	public Person q1(String name) {
		return personRepository.findByName(name);
	}

	@RequestMapping("/q2")
	public List<Person> q2(Integer age) {
		return personRepository.withQueryFindByAge(age);
	}
}
