import lombok.Getter;

@Getter
@MyAnnotation(intValue = 12,stringValue = "Jack")
public class User {
    private String firstName;
    private String lastName;
    private int age;
}
