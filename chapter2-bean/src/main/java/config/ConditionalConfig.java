package config;

import config.condition.ConditionDemo;
import config.condition.DataSourceCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;
import soundsystem.OracleDataSource;
import soundsystem.interfac.DataSource;

/**
 * @Author: ZHANG
 * @Date: 2020/1/4
 * @Description: 演示条件化的配置Bean（@Conditional + Condition 接口）
 * 希望一个或多个bean只有在应用的类路径下包含特定的库时才创建。
 * 或者我们希望某个bean只有当另外某个特定的bean也声明了之后才会创建。
 * 我们还可能要求只有某个特定的环境变量设置之后，才会创建某个bean
 * <p>
 * <p>
 * //值得注意的是这里实例化Bean的顺序是和声明方法的顺序一致
 */
@Configuration
public class ConditionalConfig {
    @Conditional(DataSourceCondition.class)
    @Bean
    public DataSource dataSource() {
        return new OracleDataSource();
    }

    //演示Condition接口中ConditionContext可以拿到的Bean的属性
    @Bean
    @Scope(WebApplicationContext.SCOPE_SESSION)
    public DataSource myDataSource() {
        OracleDataSource source = new OracleDataSource();
        return source;
    }

    @Conditional(ConditionDemo.class)
    @Bean
    public DataSource dataSource2() {
        return new OracleDataSource();
    }


}
