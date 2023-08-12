package com.himedia.mybatis.common;

import com.himedia.mybatis.model.mapper.MusicMapper;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class Template {

    private static SqlSessionFactory sqlSessionFactory;

    private static String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static String USER = "C##DBHOMEWORK";
    private static String PASSWORD = "DBHOMEWORK";

    public static SqlSession getSqlSession(){

        if(sqlSessionFactory == null){
            Environment environment = new Environment(
                    "dev",
                    new JdbcTransactionFactory(),
                    new PooledDataSource(DRIVER, URL, USER, PASSWORD));

            Configuration configuration = new Configuration(environment);

            configuration.addMapper(MusicMapper.class);

            sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        }

        SqlSession sqlSession = sqlSessionFactory.openSession(false);

        return sqlSession;

    }
}
