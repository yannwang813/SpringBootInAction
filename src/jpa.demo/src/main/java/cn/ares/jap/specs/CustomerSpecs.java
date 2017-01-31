package cn.ares.jap.specs;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.Attribute;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.SingularAttribute;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import com.google.common.collect.Iterables;

public class CustomerSpecs {
	public static <T> Specification<T> byAuto(final EntityManager entityManager, final T example) {
		
		// 获取当前实体的类型
		
		Class<T> clazz = (Class<T>) example.getClass();
		
		return new Specification<T>() {

			@Override
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				List<Predicate> predicateList = new ArrayList<Predicate>();
				
				// 获取实体类的EntityType，可以从EntityType获取实体类的属性
				EntityType<T> entity = entityManager.getMetamodel().entity(clazz);
				
				for(Attribute<T, ?> attr : entity.getDeclaredAttributes()) {
					// 通过反射获得属性值
					Object attrValue = ReflectionUtils.getField((Field) attr.getJavaMember(), example);
					if(attrValue != null) {
						// 当当前属性为字符串类型时
						if(attr.getJavaType() == String.class) {
							if(!StringUtils.isEmpty(attrValue)) {
								// 构造当前属性like查询条件，并添加到条件列表中  
								predicateList.add(cb.like(root.get(getAttribute(entity, attr.getName(), String.class)), "%" + attrValue + "%"));
							}
						} else {
							predicateList.add(cb.equal(root.get(getAttribute(entity, attr.getName(), attrValue.getClass())), attrValue));
						}
					}
				}
				
				return predicateList.isEmpty() ? cb.conjunction() : cb.and(Iterables.toArray(predicateList, Predicate.class));
			}
			
			private <E, T> SingularAttribute<T, E> getAttribute(EntityType<T> entity, String name, Class<E> clazz) {
				return entity.getDeclaredSingularAttribute(name, clazz);
			}
		};
	}
}
