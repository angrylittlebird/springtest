package soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import soundsystem.interfac.CompactDisc;
import soundsystem.interfac.MediaPlayer;

/**
 * @Author: ZHANG
 * @Date: 2019/12/28
 * @Description:
 */
@Component
public class CdPlayer implements MediaPlayer {
    //@Autowired不管是构造器、Setter方法还是其他的方法，Spring都会尝试满足方法参数上所声明的依赖
    @Autowired
    private CompactDisc cd;

    @Override
    public void play() {
        cd.play();
    }


    public CdPlayer(CompactDisc cd) {
        this.cd = cd;
    }

    public CompactDisc getCd() {
        return cd;
    }
}
