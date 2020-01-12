package config;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import soundsystem.Person;

/**
 * @Author: ZHANG
 * @Date: 2020/1/5
 * @Description:  *                  演示SpEL #{}
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PlaceHolderConfig.class})
public class PlaceHolderConfigTest {
    @Autowired
    private Person person;

    @Test
    public void person() {
        Assert.assertEquals("zhangsan",person.getName());
    }
}