//package config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Scope;
//import org.springframework.context.annotation.ScopedProxyMode;
//import org.springframework.web.context.WebApplicationContext;
//import soundsystem.CdPlayer;
//import soundsystem.SgtPeppers;
//import soundsystem.interfac.CompactDisc;
//import soundsystem.interfac.MediaPlayer;
//
///**
// * @Author: ZHANG
// * @Date: 2020/1/4
// * @Description:
// */
//@Configuration
//public class ProxyModeConfig {
//
//    @Bean
//    @Scope(value = WebApplicationContext.SCOPE_REQUEST,proxyMode = ScopedProxyMode.TARGET_CLASS)
//    public CompactDisc sgtPeppers(){
//        return new SgtPeppers();
//    }
//
//    @Bean
//    public MediaPlayer mediaPlayer(CompactDisc sgtPeppers){
//        return new CdPlayer(sgtPeppers);
//    }
//}
