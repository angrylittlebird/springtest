package soundsystem;

import soundsystem.interfac.DataSource;

/**
 * @Author: ZHANG
 * @Date: 2020/1/4
 * @Description:
 */
public class MysqlDataSource implements DataSource {
    @Override
    public void dataSourceName() {
        System.out.println("mysql datasource");
    }
}
