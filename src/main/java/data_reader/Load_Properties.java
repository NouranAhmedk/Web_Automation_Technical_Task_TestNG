package data_reader;

import lombok.SneakyThrows;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

/**
 * @author Nouran_Ahmed
 *<p>This class is built to read data from different properties files, where every TestCase has its own data,
 * and there are different data for the environments also.</p>
 */
public class Load_Properties {

    /**
     * @param properties_File_Name
     * @return
     */

    @SneakyThrows
    private static Properties load_Properties_Data(String properties_File_Name)
    {
        FileReader fr = new FileReader(properties_File_Name);
        Properties pro = new Properties();
        pro.load(fr);
        return pro;
    }


    public static Properties environment_Data =
            load_Properties_Data("src/test/resources/Properties/EnvironmentData.properties");

    public static Properties login_Data =
            load_Properties_Data("src/test/resources/Properties/Login.properties");

}
