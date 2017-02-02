package cn.ares.cache.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ares.cache.service.impl.DemoService;
import cn.ares.cache.vo.Person;

/**
 * 控制器
 * @author ares
 *
 */
@RestController
public class CacheController {
	
	@Autowired
	private DemoService demoService;
	
	@RequestMapping("/put")
	public Person put(Person person) {
		return demoService.save(person);
	}
	
	@RequestMapping("/able")
	public Person cacheable(Person person) {
		return demoService.findOne(person);
	}
	
	@RequestMapping("/evict")
	public String evict(Long id) {
		demoService.remove(id);
		return "ok";
	}
}
