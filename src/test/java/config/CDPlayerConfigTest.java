package config;

import config.qualiifer.Cold;
import config.qualiifer.Sweet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import soundsystem.CdPlayer;
import soundsystem.interfac.MediaPlayer;

/**
 * @Author: ZHANG
 * @Date: 2019/12/28
 * @Description: 这里会先根据类型寻找，该类型在javaConfig或是Xml中只声明了一个就会直接注入，
 * 若是有多个同类型的声明，则会从中寻找变量名称与声明时名称一致的实例（这里的name即为javaConfig中的方法名称），一致就会注入对应的实例
 * 不一致就会报NoUniqueBeanDefinitionException
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CDPlayerConfig.class})
public class CDPlayerConfigTest {
    private ApplicationContext context;

    @Autowired
    private MediaPlayer mediaPlayer;

    @Autowired
    private MediaPlayer anotherMediaPlayer1;

    @Autowired
    private MediaPlayer anotherMediaPlayer2;

    @Before
    public void setUp() {
        //ApplicationContext 三种常用实现类：
        // ClassPathXmlApplicationContext，加载类路径下的配置文件
        // FileSystemXmlApplicationContext，加载磁盘任意路径下的配置文件
        // AnnotationConfigApplicationContext，用于读取注解创建容器
        context = new AnnotationConfigApplicationContext(CDPlayerConfig.class);
    }

    @Test
    public void test_inject_cd_instance_is_same() {
        assert (((CdPlayer) anotherMediaPlayer1).getCd() == ((CdPlayer) mediaPlayer).getCd());
        assert (((CdPlayer) anotherMediaPlayer1).getCd() == ((CdPlayer) anotherMediaPlayer2).getCd());

    }

    @Autowired
    private MediaPlayer myMediaPlayer;

    @Test
    public void testGetBeanChangedName() {
        Assert.assertNotNull(myMediaPlayer);
    }

    @Test(expected = NoSuchBeanDefinitionException.class)
    public void getBeanByNameNotExisted() {
        // can not get Bean by default name (method name)
        context.getBean("changeName", MediaPlayer.class);
    }

    @Autowired
//    @Qualifier("player2") //这里把限制符直接指向方法名也可以
    @Qualifier("play_excited") //这里把限制符直接指向方法名也可以
    private MediaPlayer xxx;

    @Test
    public void testQualifier(){
        Assert.assertNotNull(xxx);
    }


    // just for fun
    @Autowired
    @Sweet
    private MediaPlayer yyy;

    @Test
    public void testQualifier2(){
        Assert.assertNotNull(yyy);
    }

}