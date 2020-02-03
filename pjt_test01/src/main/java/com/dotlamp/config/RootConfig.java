package com.dotlamp.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/* 스프링 프레임워크가 시작되면 스프링이 먼저 사용하는 메모리영역 생성(Context) - ApplicationContext 객체 생성 
 * 1. root-context.xml 또는 RootConfig.java (스프링은 자신이 객체를 생성하고 관리해야하는 객체들에 대한 설정이 필요한 파일)
 * 2. commponent-scan을 통해 설정되어있는 패키지 스캔 후 
 * 3. @Component라는 어노테이션이 존재하는 클래스의 인스턴스 생성 
 * 4. A객체는 B객체가 필요하다는 @Autowired 어노테이션 설정이 있으면  B객체의 레퍼런스를 A객체에 주입함. */

@Configuration
@ComponentScan(basePackages = {"com.dotlamp.service"})
@ComponentScan(basePackages = "com.dotlamp.task")
@EnableScheduling
@EnableTransactionManagement 
@MapperScan(basePackages = {"com.dotlamp.mapper"})
public class RootConfig {

	/* HikariCP */
	@Bean
	public DataSource dataSource() {
	    HikariConfig hikariConfig = new HikariConfig();
	    hikariConfig.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
	    hikariConfig.setJdbcUrl("jdbc:log4jdbc:oracle:thin:@localhost:1521:XE");

	    hikariConfig.setUsername("book_ex");
	    hikariConfig.setPassword("book_ex");

	    hikariConfig.setMinimumIdle(5);
	    // test Query
//	    hikariConfig.setConnectionTestQuery("SELECT sysdate FROM dual");
//	    hikariConfig.setPoolName("springHikariCP");

	    hikariConfig.addDataSourceProperty("dataSource.cachePrepStmts", "true");
	    hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSize", "200");
	    hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSqlLimit", "2048");
	    hikariConfig.addDataSourceProperty("dataSource.useServerPrepStmts", "true");

	    HikariDataSource dataSource = new HikariDataSource(hikariConfig);

	    return dataSource;
    }
	
	/* MyBatis */
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
	    SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
	    sqlSessionFactory.setDataSource(dataSource());
	    return (SqlSessionFactory) sqlSessionFactory.getObject();
	} 
	
	@Bean
	public DataSourceTransactionManager txManager() {
		return new DataSourceTransactionManager(dataSource());
	}
}
