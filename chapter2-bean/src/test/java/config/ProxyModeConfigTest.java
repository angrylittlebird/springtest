//package config;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import CdPlayer;
//import CompactDisc;
//import MediaPlayer;
//
//import static org.junit.Assert.*;
//
///**
// * @Author: ZHANG
// * @Date: 2020/1/4
// * @Description:
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {ProxyModeConfig.class})
//public class ProxyModeConfigTest {
//    @Autowired
//    private MediaPlayer mediaPlayer;
//
//    @Test
//    public void testProxy(){
//        CompactDisc cd = ((CdPlayer) mediaPlayer).getCd();
//    }
//}