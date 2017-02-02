package cn.ares.cache.service;

import cn.ares.cache.vo.Person;

public interface IDemoService {
	
	Person save(Person person);
	
	void remove(Long id);
	
	Person findOne(Person person);
}
