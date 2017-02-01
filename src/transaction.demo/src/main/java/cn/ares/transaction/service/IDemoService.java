package cn.ares.transaction.service;

import cn.ares.transaction.vo.Person;

public interface IDemoService {
	Person savePersonWithRollback(Person person);
	Person savePersonWithoutRollback(Person person);
}
