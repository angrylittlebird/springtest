package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * @Author: ZHANG
 * @Date: 2020/1/4
 * @Description: 演示属性源文件会加载到Spring的Environment中，以及Environment中用例
 */
@Configuration
@PropertySource("classpath:app.properties") //这个属性文件会加载到Spring的Environment中
public class EnvironmentConfig {
    @Autowired
    Environment env;

    @Bean
    public Environment env() {
        return env;
    }
}
