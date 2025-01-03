package com.lcwd.electronic.store.synergyDb.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class SynergyDataSourceConfig {

	@Bean
	@ConfigurationProperties("spring.datasource.synergy")
	public DataSourceProperties synergyDataSourceProperties() {
		return new DataSourceProperties();
	}

	/*
	 * @Bean public DataSource synergyDataSource() { // Get properties from
	 * synergyDataSourceProperties DataSourceProperties properties =
	 * synergyDataSourceProperties();
	 * 
	 * // Create HikariConfig and set properties manually HikariConfig hikariConfig
	 * = new HikariConfig(); hikariConfig.setJdbcUrl(properties.getUrl());
	 * hikariConfig.setUsername(properties.getUsername());
	 * hikariConfig.setPassword(properties.getPassword());
	 * hikariConfig.setDriverClassName(properties.getDriverClassName());
	 * 
	 * // Other HikariCP settings can be set here if needed //
	 * hikariConfig.setMaximumPoolSize(10); // Example: set max pool size
	 * 
	 * return new HikariDataSource(hikariConfig); }
	 */

	@Bean
	public DataSource synergyDataSource() {
		return synergyDataSourceProperties().initializeDataSourceBuilder().build();
	}

	@Bean
	public JdbcTemplate synergyJdbcTemplate(DataSource synergyDataSource) {
		return new JdbcTemplate(synergyDataSource);
	}
}
