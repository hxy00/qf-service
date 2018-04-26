package com.emt.qf.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @Author: Mr.Huang
 * @Date: 2018-04-10
 * @Description:
 */
@Configuration
@MapperScan(basePackages = "com.emt.qf.dao.mapper.mp2", sqlSessionTemplateRef = "sqlSessionTemplate2")
public class DateSource2 {

    public class DataSource2 {

        @Bean(name = "ds2")
        @ConfigurationProperties(prefix = "spring.datasource.ds2")
        public DataSource getDataSource() {
            return DataSourceBuilder.create().build();
        }

        @Bean(name = "sqlSessionFactory2")
        public SqlSessionFactory getSqlSessionFactory(@Qualifier("ds2") DataSource dataSource) throws Exception {
            SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
            bean.setDataSource(dataSource);
            bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/mp2/*.xml"));
            return bean.getObject();
        }

        @Bean(name = "transactionManager2")
        public PlatformTransactionManager getTransactionManager(@Qualifier("ds2") DataSource dataSource) {
            return new DataSourceTransactionManager(dataSource);
        }

        @Bean(name = "sqlSessionTemplate2")
        public SqlSessionTemplate getSqlSessionTemplate(@Qualifier("sqlSessionFactory2") SqlSessionFactory sqlSessionFactory) throws Exception {
            return new SqlSessionTemplate(sqlSessionFactory);
        }

    }
}
