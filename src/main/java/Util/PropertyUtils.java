package Util;

import Enums.ProprtyEnums;
import constants.FrameworkConstants;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public final class PropertyUtils {
    private PropertyUtils(){
        // read the Property file and store in Hashmap
        //read the data only once and use it.
    }
    private static Properties properties=new Properties();
    private static Map<String,String> map=new HashMap<>();
    static {
        try(FileInputStream inputStream=new FileInputStream(FrameworkConstants.getInstance().configProperties)){
                 properties.load(inputStream);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        properties
                .entrySet()
                .forEach(e->map.put(String.valueOf(e.getKey()),String.valueOf(e.getValue())));
    }
    public static String getValue(ProprtyEnums key){
        return map.get(key.toString().toLowerCase());
    }
}
