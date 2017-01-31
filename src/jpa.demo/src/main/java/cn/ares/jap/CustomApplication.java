package cn.ares.jap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import cn.ares.jap.dao.PersonRepository;
import cn.ares.jap.support.CustomRepositoryFactoryBean;

@SpringBootApplication
@EnableJpaRepositories(repositoryFactoryBeanClass = CustomRepositoryFactoryBean.class) // 让自定义的Repository生效
public class CustomApplication {

	PersonRepository personRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CustomApplication.class, args);
	}
}
