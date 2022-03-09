package com.example.demo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import
        org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user")
                .password("user")
                .roles("USER")
                .and()
                .withUser("admin")
                .password("admin")
                .roles("ADMIN");
    }
    @Bean
    public PasswordEncoder getPasswordEncoder() { return NoOpPasswordEncoder.getInstance();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/index").permitAll()
                .antMatchers("/resources/static/**").permitAll()

                .antMatchers("/main").authenticated()
                .antMatchers("/dzialy").authenticated()
                .antMatchers("/klienci").authenticated()
                .antMatchers("/pracownicy").authenticated()
                .antMatchers("/adresy").authenticated()
                .antMatchers("/sale").authenticated()
                .antMatchers("/poczty").authenticated()

                .antMatchers("/newDzial").hasRole("ADMIN")
                .antMatchers("/editDzial/**").hasRole("ADMIN")
                .antMatchers("/deleteDzial/**").hasRole("ADMIN")

                .antMatchers("/newKlient").hasRole("ADMIN")
                .antMatchers("/editKlient/**").hasRole("ADMIN")
                .antMatchers("/deleteKlient/**").hasRole("ADMIN")

                .antMatchers("/newPracownik").hasRole("ADMIN")
                .antMatchers("/editPracownik/**").hasRole("ADMIN")
                .antMatchers("/deletePracownik/**").hasRole("ADMIN")

                .antMatchers("/newAdres").hasRole("ADMIN")
                .antMatchers("/editAdres/**").hasRole("ADMIN")
                .antMatchers("/deleteAdres/**").hasRole("ADMIN")

                .antMatchers("/newSala").hasRole("ADMIN")
                .antMatchers("/editSala/**").hasRole("ADMIN")
                .antMatchers("/deleteSala/**").hasRole("ADMIN")

                .antMatchers("/newPoczta").hasRole("ADMIN")
                .antMatchers("/editPoczta/**").hasRole("ADMIN")
                .antMatchers("/deletePoczta/**").hasRole("ADMIN")

                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/index")
                .logoutSuccessUrl("/index")
                .permitAll();
    }
}
