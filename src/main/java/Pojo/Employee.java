package Pojo;

import lombok.Builder;
import lombok.Getter;

@Builder(setterPrefix = "set")
@Getter
public class Employee {
    private int id;
    private String first_name;
    private String last_name;
    private String email;
}
