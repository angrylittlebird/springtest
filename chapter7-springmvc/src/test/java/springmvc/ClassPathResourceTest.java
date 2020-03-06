package springmvc;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;

/**
 * @Author: ZHANG
 * @Date: 2020/3/6
 * @Description: 当前符合maven目录的结构下，
 *  测试 ClassPathResource 会优先在使用ClassPathResource的包下寻找符合路径条件的资源，比如这里是现在test-class下寻找aaa.txt,如果没有再到classes下寻找。
 */
public class ClassPathResourceTest {

    @Test
    public void test() throws IOException {

        Resource classPathResource = new ClassPathResource("config" + File.separator + "aaa.txt");
        System.out.println(classPathResource.getFile().getAbsolutePath());
        Resource classPathResource2 = new ClassPathResource("config" + File.separator + "bbb.txt");
        System.out.println(classPathResource2.getFile().getAbsolutePath());
    }
}
