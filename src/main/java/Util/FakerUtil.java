package Util;

import com.github.javafaker.Faker;

public final class FakerUtil {// not to extend class
    private FakerUtil(){
        //not to expose Constructor
    }
    private static final Faker faker=new Faker();
    static int getNumber(int lowerRange,int upperRange){
        return faker.number().numberBetween(lowerRange,upperRange);
    }
    static String firstNamr(){
        return faker.name().firstName();
    }
    static String lastName(){
        return faker.name().lastName();
    }
}
