package cn.ares.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import cn.ares.security.dao.SysUserRepository;
import cn.ares.security.domain.SysUser;

public class CustomUserService implements UserDetailsService {

	@Autowired
	private SysUserRepository sysUserRepository;

	/**
	 * 重写方法获得用户
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SysUser user = sysUserRepository.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("用户名不存在");
		}
		return user;
	}

}
