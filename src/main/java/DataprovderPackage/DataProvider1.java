package DataprovderPackage;

import org.testng.annotations.DataProvider;

import java.util.HashMap;
import java.util.Map;

public class DataProvider1 {
    @DataProvider(name = "values")
    public Object[][] DataProvider(){
        Object[][] data=new Object[3][1];
        Map<String,String> map1=new HashMap<>();
        map1.put("id","400");
        map1.put("first_name","Percival");
        map1.put("last_name","Corwin");
        map1.put("email", "Carey.Torp@hotmail.com");
        Map<String,String> map2=new HashMap<>();
        map2.put("id","178");
        map2.put("first_name","Sydnee");
        map2.put("last_name","Collins");
        map2.put("email","Justina82@hotmail.com");
        Map<String,String> map3=new HashMap<>();
        map3.put("id","737");
        map3.put("first_name","Dandre");
        map3.put("last_name","Goyette");
        map3.put("email","Arvel.White@yahoo.com");
        data[0][0]=map1;
        data[1][0]=map2;
        data[2][0]=map3;
        return data;
    };
}
