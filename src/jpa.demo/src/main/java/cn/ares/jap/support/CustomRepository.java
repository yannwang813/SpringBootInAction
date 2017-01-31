package cn.ares.jap.support;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import cn.ares.jap.specs.CustomerSpecs;

public class CustomRepository<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements ICustomRepository<T, ID> {

	private final EntityManager entityManager;
	
	public CustomRepository(Class<T> domainClass, EntityManager entityManager) {
		super(domainClass, entityManager);
		this.entityManager = entityManager;
	}

	@Override
	public Page<T> findByAuto(T example, Pageable pageable) {
		return findAll(CustomerSpecs.byAuto(entityManager, example), pageable);
	}

}
