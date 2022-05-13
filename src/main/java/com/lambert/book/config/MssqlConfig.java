package com.lambert.book.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;

import io.r2dbc.mssql.MssqlConnectionConfiguration;
import io.r2dbc.mssql.MssqlConnectionFactory;

@Configuration
public class MssqlConfig extends AbstractR2dbcConfiguration {
	
	@Value("${spring.datasource.host}")
	private String host;
	
	@Value("${spring.datasource.port}")
	private String port;
	
	@Value("${spring.datasource.database}")
	private String database;
	
	@Value("${spring.datasource.username}")
	private String username;
	
	@Value("${spring.datasource.password}")
	private String password;
	
    @Bean
    @Override
    public MssqlConnectionFactory connectionFactory() {
        return new MssqlConnectionFactory(MssqlConnectionConfiguration.builder()
                .host(host)
                .port(Integer.parseInt(port))
                .database(database)
                .username(username)
                .password(password)
                .build());
    }
}
