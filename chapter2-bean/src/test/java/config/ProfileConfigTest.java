package config;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import soundsystem.interfac.DataSource;

/**
 * @Author: ZHANG
 * @Date: 2020/1/4
 * @Description: 演示Spring根据激活不同的profile来选择实例化所对应的Bean
 * 设置激活哪个profile依赖两个独立的属性：spring.profiles.active和 spring.profiles.default。
 * Spring会查找pring.profiles.active的值，没有设置则查找spring.profiles.default的值。
 * 如果spring.profiles.active和spring.profiles.default均没有设置的话，那就没有激活的profile，因此只会创建那些没有定义在profile中的bean。
 * 设置这两个属性的地点：
 *      作为DispatcherServlet的初始化参数；
 *      作为Web应用的上下文参数；
 *      作为JNDI条目；
 *      作为环境变量；
 *      作为JVM的系统属性；
 *      在集成测试类上，使用@ActiveProfiles注解设置。
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ProfileConfig.class})
@ActiveProfiles("prod") //激活profile声明为prod的Bean
public class ProfileConfigTest {
    @Autowired
    private DataSource dataSource;

    @Test
    public void mysqlDataSource() {
        Assert.assertNotNull(dataSource);
        dataSource.dataSourceName();
    }
}