package soundsystem;

import soundsystem.interfac.DataSource;

/**
 * @Author: ZHANG
 * @Date: 2020/1/4
 * @Description:
 */
public class OracleDataSource implements DataSource {
    @Override
    public void dataSourceName() {
        System.out.println("oracle datasource");
    }
}
