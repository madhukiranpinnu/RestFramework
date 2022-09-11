package constants;

public class FrameworkConstants {
    private static FrameworkConstants INSTANCE=null;
    private FrameworkConstants(){}
    public static synchronized FrameworkConstants getInstance(){
        if(INSTANCE==null){
            INSTANCE=new FrameworkConstants();
        }
        return INSTANCE;
    }
    public String requestJsonPath=
            System.getProperty("user.dir")+"\\src\\test\\resources\\jsons\\";
    public String responseJsonPath=
            System.getProperty("user.dir")+"\\src\\test\\resources\\output\\";
    public String configProperties=
            System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties";
}
