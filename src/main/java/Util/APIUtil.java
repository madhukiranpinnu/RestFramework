package Util;

import io.restassured.response.Response;
import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Paths;

public final class APIUtil {// no to extend
    private APIUtil(){}
    @SneakyThrows
    public static String jsonConverToString(String filePath){
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }
    @SneakyThrows
    public static void responseToFile(String filePath, Response response){
        Files.write(Paths.get(filePath),response.asByteArray());
    }
}
