package config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @Author: ZHANG
 * @Date: 2020/1/4
 * @Description: 通过@Properties注解将属性源中的key/value注入到Spring的Environment中
 *              演示Environment的一些用例
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {EnvironmentConfig.class})
@ActiveProfiles({"dev", "prod"})
public class EnvironmentConfigTest {
    @Autowired
    Environment env;

    @Test
    public void person() {
        assertNotNull(env);

        assertEquals("zhangsan", env.getProperty("person.name"));
        assertTrue(12 == env.getProperty("person.age", Integer.class));
        assertTrue(env.containsProperty("person.age"));

        assertArrayEquals(new String[]{"dev", "prod"}, env.getActiveProfiles());
        assertArrayEquals(new String[]{"default"}, env.getDefaultProfiles());
        assertTrue(env.acceptsProfiles("prod", "dev", "default", "xxxxx"));//只要包含其中一个就返回true
    }
}