package cn.ares.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.ares.security.domain.SysUser;

public interface SysUserRepository extends JpaRepository<SysUser, Long> {
	
	SysUser findByUsername(String username);
	
}
