package com.utn.sprint3.Config;

import com.utn.sprint3.Jwt.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authProvider;



    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        return http
                .csrf(csrf ->
                        csrf
                                .disable())
                .authorizeHttpRequests(authRequest ->
                                authRequest
                                        .requestMatchers(new AntPathRequestMatcher("/auth/**")).permitAll()

                                        //Consola H2:
                                        .requestMatchers(PathRequest.toH2Console()).permitAll()

                                        //Autorizacion de acceso a la url:
                                       // .requestMatchers(new AntPathRequestMatcher("/api/v1/empleados/**")).hasAuthority("ADMINISTRADOR")
                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/empleados/**")).permitAll()
                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/domicilios/**")).permitAll()
                                       // .requestMatchers(new AntPathRequestMatcher("/api/v1/usuario/**")).hasAnyAuthority("CLIENTE", "ADMINISTRADOR")
                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/usuario/**")).permitAll()
                                        .requestMatchers(new AntPathRequestMatcher("/api/admin/**")).permitAll()
                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/articulosInsumo/**")).permitAll()
                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/articulosManufacturado/**")).permitAll()
                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/DetallesArtManufacturado/**")).permitAll()
                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/detallesFactura/**")).permitAll()
                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/detallesPedido/**")).permitAll()
                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/EstadisticasAriticulo/**")).permitAll()
                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/EstadisticasAriticulo/**")).permitAll()
                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/estadisticasMonetarias/**")).permitAll()
                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/EstadisticasPedidos/**")).permitAll()
                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/facturas/**")).permitAll()
                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/pedidos/**")).permitAll()
                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/rubrosArticulo/**")).permitAll()
                                        .requestMatchers(new AntPathRequestMatcher("/api/v1/unidadesMedida/**")).permitAll()




                        //.anyRequest().authenticated()
                )
                .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable)) //H2
                .sessionManagement(sessionManager->
                        sessionManager
                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();


    }

}
