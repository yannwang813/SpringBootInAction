package cn.ares.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import cn.ares.rest.vo.Person;

@RepositoryRestResource(path = "people")
public interface PersonRepository extends JpaRepository<Person, Long> {
	
	@RestResource(path = "nameStartsWith", rel = "nameStartWith")
	Person findByNameStartsWith(String name);

}
