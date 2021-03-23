package com.cos.costagram.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cos.costagram.domain.user.User;

import lombok.Data;

@Data
public class PrincipalDetails implements UserDetails{

	private User user;

	public PrincipalDetails(User user) {
		this.user=user;
	}

	@Override
	public String getPassword() { //패스워드
		// TODO Auto-generated method stub
		return user.getPassword(); //user가 들고있는 패스워드
	}

	@Override
	public String getUsername() { //유저네임
		// TODO Auto-generated method stub
		return user.getUsername(); //user가 들고있는 username
	}

	@Override
	public boolean isAccountNonExpired() { //계정 만료
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() { //로그인 실패시 Lock 
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() { //비밀번호 만료
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() { //계정활성화
		// TODO Auto-generated method stub
		return true;
	} 

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() { //권한 체크
		// TODO Auto-generated method stub
	      Collection<GrantedAuthority> collectors = new ArrayList<>();
	      collectors.add(()-> "ROLE_"+user.getRole().toString());

		 //String 타입이 아니기 때문에 toString

		return collectors;
	}



}
