package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import soundsystem.MysqlDataSource;
import soundsystem.OracleDataSource;
import soundsystem.interfac.DataSource;

/**
 * @Author: ZHANG
 * @Date: 2020/1/4
 * @Description: 演示 @profile 用例
 */
@Configuration
public class ProfileConfig {
    @Profile("dev")
    @Bean
    public DataSource mysqlDataSource(){
        return new MysqlDataSource();
    }

    @Profile("prod")
    @Bean
    public DataSource oracleDataSource(){
        return new OracleDataSource();
    }
}
