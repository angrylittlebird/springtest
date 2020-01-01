package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import soundsystem.CdPlayer;
import soundsystem.SgtPeppers;
import soundsystem.interfac.CompactDisc;
import soundsystem.interfac.MediaPlayer;

/**
 * @Author: ZHANG
 * @Date: 2019/12/28
 * @Description:
 */
@Configuration
public class CDPlayerConfig {
    //默认方法名即为该Bean的Id
    @Bean
    public MediaPlayer mediaPlayer(){
        return new CdPlayer(sgtPeppers());
    }

    //看起来，CompactDisc是通过调用sgtPeppers()得到的，但情况并非完全如此。
    //因为sgtPeppers()方法上添加了@Bean注解，Spring将会拦截所有对它的调用，并确保直接返回该方法所创建的bean，
    //而不是每次都对其进行实际的调用。
    //想想也是，不然不就破坏了单例吗？
    @Bean("anotherMediaPlayer1")//修改Bean的Id
    public MediaPlayer anotherMediaPlayer(){
        return new CdPlayer(sgtPeppers());
    }

    //上面的做法会令人产生上述的歧义，以下为best practice
    //在这里甚至没有要 求CompactDisc必须要在JavaConfig中声明，实际上它可以通过组件 扫描功能自动发现或者通过XML来进行配置。
    @Bean
    public MediaPlayer anotherMediaPlayer2(CompactDisc sgtPeppers){
        return new CdPlayer(sgtPeppers);
    }

    @Bean
    public CompactDisc sgtPeppers(){
        return new SgtPeppers();
    }
}
