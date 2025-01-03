package com.lcwd.electronic.store.intergationDb.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.lcwd.electronic.store.integration.repositories", // Change to your JPA repository package
        entityManagerFactoryRef = "integrationEntityManagerFactory",
        transactionManagerRef = "integrationTransactionManager"
)
public class IntegrationDataSourceConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.integration")
    public DataSourceProperties integrationDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource integrationDataSource() {
        return integrationDataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean integrationEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(integrationDataSource())
                .packages("com.lcwd.electronic.store.entities") // Change to your JPA entity package
                .persistenceUnit("integrations")
                .build();
    }

    @Bean
    public PlatformTransactionManager integrationTransactionManager(EntityManagerFactory integrationEntityManagerFactory) {
        return new JpaTransactionManager(integrationEntityManagerFactory);
    }
}
