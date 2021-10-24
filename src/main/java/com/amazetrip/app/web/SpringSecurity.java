package com.amazetrip.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Component
@EnableWebSecurity
public class SpringSecurity extends WebSecurityConfigurerAdapter {

    final boolean authentification = true;

    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        if (!authentification) {
            http.//
                    csrf().disable()//
                    .authorizeRequests()//
                    .anyRequest().permitAll();
            return;
        }
        http
                .csrf().disable()
                .authorizeRequests()//
                .antMatchers(HttpMethod.POST, "/api/users/create").permitAll()
                .antMatchers("/", "/webjars/**", "/login", "/app/users/**", "/api/users/**", "/app/trips/**", "/app/places/**", "/*.js", "/*.css", "/images/**")//
                .permitAll()//
                .anyRequest().authenticated()
                .and().formLogin().permitAll()
                .and().logout().permitAll();
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()//
                .dataSource(dataSource)//
                .usersByUsernameQuery(//
                        "select email,password,1 " + //
                                "from user where email = ?")
                .authoritiesByUsernameQuery("select email, authority from user where email = ?");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
