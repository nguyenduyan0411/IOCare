//package com.fpoly.iocare;
//
//import java.util.stream.Collectors;
//
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//import com.fpoly.iocare.dao.IEmployeeDAO;
//import com.fpoly.iocare.model.Employee;
//import com.fpoly.iocare.service.IEmployeeService;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter{
////	@Autowired private IEmployeeService dao;
////	@Autowired private BCryptPasswordEncoder pe;
////	//Cung cấp nguồn dữ liệu đăng nhập
////	
////	@Override
////	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////		auth.userDetailsService(id->{
////			try {
////				Employee user =  dao.findById(id);
////				String password = pe.encode(user.getPasword());
////				String[] roles = user.getAuthorities().stream()
////						.map(el->el.getRole().getRoleId())
////						.collect(Collectors.toList()).toArray(new String[0]);
////				return User.withUsername(user.getId()).password(password).roles(roles).build();
////			} catch (Exception e) {
////				e.printStackTrace();
////				throw new UsernameNotFoundException(id + "not found!");
////			}
////		});
////	}
////	
////	//Phân quyền sử dụng
////	@Override
////	protected void configure(HttpSecurity http) throws Exception {
////		http.csrf().disable();
////		http.authorizeRequests()
//////		 	.antMatchers("/security/sign-in").permitAll() // Cho phép truy cập không cần xác thực vào "/sign-in"
//////		    .anyRequest().authenticated(); // Yêu cầu xác thực đối với tất cả các URL còn lại
////			.antMatchers("/security").authenticated()
////			.anyRequest().permitAll();
////
////		http.formLogin()
////			.loginPage("/security/login/form")
////			.loginProcessingUrl("/security/login")
////			.defaultSuccessUrl("/security/login/success",true)
////			.failureUrl("/security/login/error");
////		
////		http.rememberMe()
////			.tokenValiditySeconds(86400);
////		
////		http.exceptionHandling()
////			.accessDeniedPage("/security/unauthorized");
////		
////		http.logout()
////			.logoutUrl("/security/logoff")
////			.logoutSuccessUrl("/security/logoff/success");
////	}
////	
////	//Cơ chế mã hoá mật khẩu
////	@Bean
////	public BCryptPasswordEncoder getPasswordEncoder() {
////		return new BCryptPasswordEncoder();
////	}
////	
////	//Cho phép truy xuất REST API từ bên ngoài (domain khác)
////	@Override
////	public void configure(WebSecurity web) throws Exception {
////		web.ignoring().antMatchers(HttpMethod.OPTIONS,"/**");
////	}
//}
