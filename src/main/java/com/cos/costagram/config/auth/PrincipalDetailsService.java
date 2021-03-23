package com.cos.costagram.config.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cos.costagram.domain.user.User;
import com.cos.costagram.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PrincipalDetailsService implements UserDetailsService{
	
	private final UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User principal = userRepository.findByUsername(username);
		
		if(principal == null) {
			return null;
		}else { //유저가 있으면
			System.out.println("유저가 있다.");
			return new PrincipalDetails(principal); 
			//리턴시 SecurityContextHolder => Authentication 객체 내부에 담긴다.
		}
		
	}

}
