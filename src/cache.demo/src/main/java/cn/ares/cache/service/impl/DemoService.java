package cn.ares.cache.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import cn.ares.cache.dao.PersonReposiory;
import cn.ares.cache.service.IDemoService;
import cn.ares.cache.vo.Person;

@Service
public class DemoService implements IDemoService {
	
	@Autowired
	private PersonReposiory personReposiory;

	@Override
	@CachePut(value="people", key="#person.id") // 缓存新增或更新的数据到缓存，缓存名称为people
	public Person save(Person person) {
		Person p = personReposiory.save(person);
		System.out.println("为id、key为：" + (p == null ? -1 : p.getId()) + "数据做了缓存");
		return p;
	}

	@Override
	@CacheEvict(value="people") // 从缓存people中删除key为id的数据
	public void remove(Long id) {
		System.out.println("删除了id、key为：" + id + "的数据缓存");
		personReposiory.delete(id);
	}

	@Override
	@Cacheable(value="people", key="#person.id") // 缓存key为people的id数据到缓存people中
	public Person findOne(Person person) {
		Person p = personReposiory.findOne(person.getId());
		System.out.println("~为id、key为：" + (p == null ? -1 : p.getId()) + "数据做了缓存");
		return p;
	}

}
