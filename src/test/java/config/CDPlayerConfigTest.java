package config;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import soundsystem.CdPlayer;
import soundsystem.interfac.MediaPlayer;

/**
 * @Author: ZHANG
 * @Date: 2019/12/28
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CDPlayerConfig.class})
public class CDPlayerConfigTest {
    //这里会先根据类型寻找，该类型在javaConfig或是Xml中只声明了一个就会直接注入，
    //若是有多个同类型的声明，则会从中寻找变量名称与声明id名称一致的实例（这里的id即为javaConfig中的方法名称），一致就会注入对应的实例
    //不一致就会报NoUniqueBeanDefinitionException
    @Autowired
    private MediaPlayer anotherMediaPlayer1;

    @Autowired
    private MediaPlayer mediaPlayer;

    @Autowired
    private MediaPlayer anotherMediaPlayer2;



    @Test
    public void cdIsTheSameInstanceInMediaPlayer() {
        assert(((CdPlayer) anotherMediaPlayer1).getCd() == ((CdPlayer)mediaPlayer).getCd());
    }

    @Test
    public void getPlayer2(){
        Assert.assertNotNull(((CdPlayer) anotherMediaPlayer2).getCd());
        assert(((CdPlayer) anotherMediaPlayer1).getCd() == ((CdPlayer)anotherMediaPlayer2).getCd());
    }
}