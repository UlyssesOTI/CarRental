package com.ulyssess.carrental.service.implementation;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.ulyssess.carrental.dao.ClientDAO;
import com.ulyssess.carrental.entity.Client;



@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private ClientDAO clientDao;
	
	@Transactional
	public UserDetails loadUserByUsername(String login)
			throws UsernameNotFoundException {
		Client client = null;
		try {
			client = clientDao.findByLogin(login);
		} catch (NoResultException e) {
			return null;
		}
		
		
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		// User - клас зі Spring Security, об'єкт якого є поточним залогіненим користувачем.
		// username може бути як і логін, та і id юзера в базі даних. Але id буде оптимальніше.
		return new User(String.valueOf(client.getId()), client.getPassword(), authorities);
	}

}
