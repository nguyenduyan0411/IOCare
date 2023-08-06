package com.fpoly.iocare;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fpoly.iocare.model.Employee;
import com.fpoly.iocare.service.IEmployeeService;

/**
 *	@EnableWebSecurity : Kích hoạt tính năng bảo mật trong Spring Security
 */

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)

/**
 * 	WebSecurityConfigurerAdapter là một lớp trừu tượng trong Spring Security
 *                               được sử dụng để cấu hình bảo mật cho ứng dụng web
 *                               xác thực, phân quyền, giới hạn truy cập và xác thực CSRF (Cross-site Request Forgery).
 */
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired private IEmployeeService dao;
	@Autowired private BCryptPasswordEncoder pe;
	//Cung cấp nguồn dữ liệu đăng nhập
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.eraseCredentials(false).userDetailsService(id->{
			try {
				Employee user =  dao.findById(id);
				String password = pe.encode(user.getEmployeePassword());
				String[] roles = user.getAuthorities().stream()
						.map(el->el.getRole().getRoleId())
						.collect(Collectors.toList()).toArray(new String[0]);
				return User.withUsername(user.getEmployeeId()).password(user.getEmployeePassword()).roles(roles).build();
			} catch (Exception e) {
				e.printStackTrace();
				throw new UsernameNotFoundException(id + "not found!");
			}
		});
	}
	
	//Phân quyền sử dụng
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests()
			
			//Các yêu cầu chỉ được cấp phép khi roleId = 1 và 2 (ADMIN, USER1)
			.antMatchers("/security/user1").hasAnyRole("1", "2")
			.antMatchers("/rest/imported").hasAnyRole("1","3")
			//.antMatchers("?").hasAnyRole("1","2")
			
			//Các yêu cầu chỉ được cấp phép khi roleId = 1 và 3 (ADMIN, USER2)
	        .antMatchers("/security/user2").hasAnyRole("1", "3")
	        .antMatchers("/campaign-management").hasAnyRole("1","3")
	        .antMatchers("/data-management").hasAnyRole("1","3")
	        .antMatchers("/rest/campaign").hasAnyRole("1","3")
	        
	        //Các yêu cầu chỉ được cấp phép khi roleId = 1 (ADMIN)
			.antMatchers("/security/admin").hasRole("1")
			.antMatchers("/authority-management").hasRole("1")
			.antMatchers("/account-management").hasRole("1")
			.antMatchers("/rest/authorities").hasRole("1")
			.antMatchers("/rest/employee").hasRole("1")
			
			///Các yêu cầu chỉ được cấp phép khi đã đăng nhập
			.antMatchers("/security/authenticated").authenticated()
//			.antMatchers("/rest/**").authenticated()
			
			//Các yêu cầu còn lại không cần cấp phép (tránh lỗi vòng lặp xác thực) 
			.anyRequest().permitAll();

		http.formLogin()
			.loginPage("/security/login/form")
			.loginProcessingUrl("/security/login")
			.defaultSuccessUrl("/security/login/success",true)
			.failureUrl("/security/login/error");
		
		http.rememberMe()
			//Đảm bảo rằng chỉ máy bạn mới có thể giải mã cookie và truy xuất thông tin xác định người dùng.
			.key("uniqueAndSecret")
			//Lưu đăng nhập 10 ngày
			.tokenValiditySeconds(864000);
		
		http.exceptionHandling()
			.accessDeniedPage("/security/unauthorized");
		
		http.logout()
			.logoutUrl("/security/logoff")
			.logoutSuccessUrl("/security/logoff/success");
	}
	
	//Cơ chế mã hoá mật khẩu
	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	//Cho phép truy xuất REST API từ bên ngoài (domain khác)
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(HttpMethod.OPTIONS,"/**");
	}
}
