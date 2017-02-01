package cn.ares.transaction.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ares.transaction.dao.PersonReposiory;
import cn.ares.transaction.service.IDemoService;
import cn.ares.transaction.vo.Person;

@Service
public class DemoService implements IDemoService {

	@Autowired
	private PersonReposiory personReposiory;
	
	@Transactional(rollbackFor={IllegalArgumentException.class})
	@Override
	public Person savePersonWithRollback(Person person) {
		Person p = personReposiory.save(person);
		
		if(person.getName().equals("权胖")){
			throw new IllegalArgumentException("权胖已经存在，将回滚数据！");
		}
		return p;
	}

	@Transactional(noRollbackFor={IllegalArgumentException.class})
	@Override
	public Person savePersonWithoutRollback(Person person) {
		Person p = personReposiory.save(person);
		
		if(person.getName().equals("权胖")){
			throw new IllegalArgumentException("权胖已经存在，但滚数据不会回滚！");
		}
		return p;
	}

}
