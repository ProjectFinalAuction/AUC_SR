package org.khmeracademy.auction.configuration;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@MapperScan("org.khmeracademy.auction.repositories")
public class AUCConfiguration {
		@Bean 
		public DataSource getDataSource(){
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName("org.postgresql.Driver");
			dataSource.setUrl("jdbc:postgresql://120.136.24.174:5432/AUCTION_SR_DB");
			dataSource.setUsername("AUCTION_SR");
			dataSource.setPassword("AUCTION_SR");
			return dataSource;
		}
		
		@Bean
	    public DataSourceTransactionManager transactionManager() {
	        return new DataSourceTransactionManager(getDataSource());
	    }

	 
	    @Bean
	    public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
	        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
	        sessionFactory.setDataSource(getDataSource());
	        return sessionFactory;
	    }
}
