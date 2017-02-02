package cn.ares.mongodb.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import cn.ares.mongodb.vo.Person;

public interface PersonRepository extends MongoRepository<Person, String> {
	
	/**
	 * 支持方法名查询
	 * @param name
	 * @return
	 */
	Person findByName(String name);
	
	/**
	 * 执行@Query查询，查询参数构造JSON字符串
	 * @param age
	 * @return
	 */
	@Query("{'age' : ?0}")
	List<Person> withQueryFindByAge(Integer age);
}
