package soundsystem;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author: ZHANG
 * @Date: 2020/1/5
 * @Description: 演示SpEL Spring Expression Language
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:SpEL.xml")
public class SpELTest {

    @Autowired
    private Person person;

    @Test
    public void testPerson(){
        Assert.assertNotNull(person.getName());
        Assert.assertEquals(3,person.getAge());
        Assert.assertEquals(true,person.isGender());
    }
}
