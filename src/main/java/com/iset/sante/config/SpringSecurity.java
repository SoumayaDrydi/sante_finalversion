package com.iset.sante.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurity {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private CustomSuccessHandler customSuccessHandler;

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests((authorize) ->
                        authorize.requestMatchers("/register/**").permitAll()
                                .requestMatchers("/index").permitAll()
                                .requestMatchers("/home").hasRole("ADMIN")
                                .requestMatchers("/homeUser").hasRole("USER")
                                .requestMatchers("/ListeProfils").hasRole("ADMIN")
                                .requestMatchers("/ListeRegimes").hasRole("ADMIN")
                                .requestMatchers("/activiteList").hasRole("ADMIN")
                                .requestMatchers("/showCreate3").hasRole("ADMIN")
                                .requestMatchers("/showCreate1").hasRole("ADMIN")
                                .requestMatchers("/saveRegime").hasRole("ADMIN")
                                .requestMatchers("/saveAc").hasRole("ADMIN")
                                .requestMatchers("/detailsRegime").hasRole("ADMIN")
                                .requestMatchers("/modifierRegime").hasRole("ADMIN")
                                .requestMatchers("/supprimerRegime").hasRole("ADMIN")
                                .requestMatchers("/supprimerActivite").hasRole("ADMIN")
                                .requestMatchers("/modifierActivite").hasRole("ADMIN")
                                .requestMatchers("/admin_chat").hasRole("ADMIN")
                                .requestMatchers("/saveProfil").hasRole("USER")
                                .requestMatchers("/showCreate").hasRole("USER")
                                .requestMatchers("/saisirNom").hasRole("USER")
                                .requestMatchers("/afficherProfil").hasRole("USER")
                                .requestMatchers("/modifierProfil1").hasRole("USER")
                                .requestMatchers("/updateProfil1").hasRole("USER")
                                .requestMatchers("/updateRegime").hasRole("ADMIN")
                                .requestMatchers("/ListeRegimes1").hasRole("USER")
                                .requestMatchers("/regime/detailsRegime").hasRole("USER")
                                .requestMatchers("/modifierProfil").hasRole("ADMIN")
                                .requestMatchers("/updateProfil").hasRole("ADMIN")
                                .requestMatchers("/supprimerProfil").hasRole("ADMIN")
                                .requestMatchers("/regime/detailsRegime1").hasRole("ADMIN")
                                .requestMatchers("updateActivite").hasRole("ADMIN")
                                .requestMatchers("admin_to_user/send").hasRole("ADMIN")
                                .requestMatchers("/user_chat").hasRole("USER")
                                .requestMatchers("user_to_admin/send").hasRole("USER")
                                .requestMatchers("/activiteList1").hasRole("USER")
                                .requestMatchers("/activiteDetails").hasRole("USER")
                                .requestMatchers("/Plus").hasRole("USER")
                ).formLogin(
                        form -> form
                                .loginPage("/login")
                                .loginProcessingUrl("/login")
                                .successHandler(customSuccessHandler)
                                .permitAll()
                ).logout(
                        logout -> logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .permitAll()
                );
        return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }}