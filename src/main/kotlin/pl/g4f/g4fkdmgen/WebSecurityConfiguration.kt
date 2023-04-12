package pl.g4f.g4fkdmgen

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.SecurityFilterChain


@Configuration
class WebSecurityConfiguration {
    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain? {
        return http
            .authorizeHttpRequests()
            .anyRequest().authenticated()
            .and()
            .oauth2Login()
            .and()
            .build()
    }
}