package cn.ares.transaction.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ares.transaction.service.impl.DemoService;
import cn.ares.transaction.vo.Person;

@RestController
public class MyController {
	
	@Autowired
	private DemoService demoService;
	
	@RequestMapping("/rollback")
	public Person rollback(Person person) {
		return demoService.savePersonWithRollback(person);
	}
	
	@RequestMapping("/norollback")
	public Person noRollback(Person person) {
		return demoService.savePersonWithoutRollback(person);
	}
}
