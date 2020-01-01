package soundsystem;

import org.springframework.stereotype.Component;
import soundsystem.interfac.CompactDisc;

/**
 * @Author: ZHANG
 * @Date: 2019/12/28
 * @Description:
 */

@Component
public class SgtPeppers implements CompactDisc {
    @Override
    public void play() {
        System.out.print("palying something");
    }
}
