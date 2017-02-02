package cn.ares.redis.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ares.redis.dao.PersonDao;
import cn.ares.redis.vo.Person;

@RestController
public class DataController {

	@Autowired
	private PersonDao personDao;
	
	/**
	 * 设置字符和对象
	 */
	@RequestMapping("/set")
	public void set() {
		Person person = new Person("1", "权大胖", 18);
		personDao.save(person);
		personDao.stringRedisTemplateDemo();
	}

	/**
	 * 获得字符
	 * @return
	 */
	@RequestMapping("/getStr")
	public String getStr() {
		return personDao.getString();
	}

	/**
	 *  获得对象
	 * @return
	 */
	@RequestMapping("/getPerson")
	public Person getPerson() {
		return personDao.getPerson();
	}
}
