package Util;

public final class RandomNumber {// not to extend class
    private RandomNumber(){
        //not to expose constructor
    }
    public static int getId(){
        return FakerUtil.getNumber(10000,20000);
    }
    public static String getFirstName(){
        return FakerUtil.firstNamr().toLowerCase();
    }
    public static String getLastName(){
        return FakerUtil.lastName().toUpperCase();
    }
    public static String getEmil(){
        return getFirstName()+getLastName()+"@gmail.com";
    }
}
