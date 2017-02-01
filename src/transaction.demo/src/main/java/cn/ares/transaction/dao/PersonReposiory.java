package cn.ares.transaction.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.ares.transaction.vo.Person;

public interface PersonReposiory extends JpaRepository<Person, Long> {

}
