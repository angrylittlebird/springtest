package config;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import soundsystem.interfac.DataSource;

import static org.junit.Assert.*;

/**
 * @Author: ZHANG
 * @Date: 2020/1/4
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ConditionalConfig.class})
public class ConditionalConfigTest {
    @Autowired
    private DataSource dataSource2;

    @BeforeClass
    public static void setUp() {
        //Note：需要在Edit Configuration中预先设置Environment variables, java运行时貌似不可以通过代码设置
        String magic = System.getenv("magic");
        Assert.assertNotNull(magic);
    }

    @Test
    public void dataSource() {
        Assert.assertNotNull(dataSource2);
    }
}