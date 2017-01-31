package cn.ares.jap.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ares.jap.dao.PersonRepository;
import cn.ares.jap.vo.Person;

@Deprecated
@RestController
public class _DataController {
	
	@Autowired
	private PersonRepository personRepository;
	
	@RequestMapping("/save")
	public Person save(String name, String address, Integer age) {
		Person p = personRepository.save(new Person(null, name, age, address));
		return p;
	}

	@RequestMapping("/q1")
	public List<Person> q1(String address) {
		List<Person> list = personRepository.findByAddress(address);
		return list;
	}
	
	@RequestMapping("/q2")
	public Person q2(String name, String address) {
		Person p = personRepository.findByNameAndAddress(name, address);
		return p;
	}

	@RequestMapping("/q3")
	public Person q3(String name, String address) {
		Person p = personRepository.withNameAndAddressQuery(name, address);
		return p;
	}

	@RequestMapping("/q4")
	public Person q4(String name, String address) {
		Person p = personRepository.withNameAndAddressNamedQuery(name, address);
		return p;
	}
	
	/**
	 * 测试排序
	 * @return
	 */
	@RequestMapping("/sort")
	public List<Person> sort() {
		List<Person> list = personRepository.findAll(new Sort(Direction.ASC, "age"));
		return list;
	}
	
	/**
	 * 测试分页
	 * @return
	 */
	@RequestMapping("/page")
	public Page<Person> page() {
		Page<Person> pageList = personRepository.findAll(new PageRequest(1, 2));
		return pageList;
	}
}
