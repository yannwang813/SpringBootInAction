package cn.ares.jap.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cn.ares.jap.vo.Person;

/**
 * 数据访问接口
 * @author ares
 *
 */
@Deprecated
public interface _PersonRepository extends JpaRepository<Person, Long> {
	
	/**
	 * 使用方法名查询，接受一个name参数，返回值为List
	 * @param name
	 * @return
	 */
	List<Person> findByAddress(String address);

	
	/**
	 * 使用方法名查询，接受name和address参数
	 * @param name
	 * @return
	 */
	Person findByNameAndAddress(String name, String address);

	
	/**
	 * 使用@Query查询，参数按照名称绑定
	 * @param name
	 * @return
	 */
	@Query("select p from Person p where p.name= :name and p.address= :address")
	Person withNameAndAddressQuery(@Param("name") String name, @Param("address") String address);

	
	/**
	 * 使用@NamedQuery查询，对应PersonVO中的@NamedQuery
	 * @param name
	 * @return
	 */
	Person withNameAndAddressNamedQuery(String name, String address);
}
