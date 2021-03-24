package com.cos.costagram.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.costagram.domain.user.User;
import com.cos.costagram.domain.user.UserRepository;
import com.cos.costagram.web.dto.auth.UserJoinReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AuthService {
	private final UserRepository userRepository;
	//SecurityConfig 클래스가 config로 ioc컨테이너에 띄워져 있기 때문에 @Bean이 있는 BCryptPasswordEncoder 사용가능
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Transactional
	public void 회원가입(User user) {
		
		//암호화
		String first = user.getPassword();
		String bCrypt = bCryptPasswordEncoder.encode(first);
		user.setPassword(bCrypt);
		//
		user.setRole("USER");
		userRepository.save(user);	
	} //사용자에게 UX를 보여줘야하면 util 사용을 권장
	
}
