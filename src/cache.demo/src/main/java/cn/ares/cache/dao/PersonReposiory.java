package cn.ares.cache.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.ares.cache.vo.Person;

public interface PersonReposiory extends JpaRepository<Person, Long> {

}
