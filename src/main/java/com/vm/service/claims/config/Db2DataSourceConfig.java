package com.vm.service.claims.config;

//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//        basePackages = "com.vm.service.claims.repositorysOtherRepo",
//        entityManagerFactoryRef = "pgEntityManagerFactory",
//        transactionManagerRef = "pgTransactionManager"
//
//)

public class Db2DataSourceConfig {

//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource.pg")
//    public DataSource pgDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean pgEntityManagerFactory(
//            @Qualifier("pgDataSource") DataSource pgDataSource) {
//
//        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
//        emf.setDataSource(pgDataSource);
//
//        // 🔥 Important: Scan Postgres Entities
//        emf.setPackagesToScan("com.vm.service.claims.entitysOtherDB");
//       // emf.setPackagesToScan("com.vm.service.claims.entitysOtherDB", "com.vm.service.claims.entitys");
//
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        emf.setJpaVendorAdapter(vendorAdapter);
//
//        // 🔥 ADD HIBERNATE PROPERTIES (DIALECT!)
//        Map<String, Object> properties = new HashMap<>();
//        properties.put("hibernate.hbm2ddl.auto", "update");
//        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
//        properties.put("hibernate.show_sql", "true");
//
//        emf.setJpaPropertyMap(properties);
//
//        return emf;
//    }
//
//    @Bean
//    public PlatformTransactionManager pgTransactionManager(
//            @Qualifier("pgEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
//
//        return new JpaTransactionManager(entityManagerFactory);
//    }
}
