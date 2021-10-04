import lombok.SneakyThrows;
import java.lang.reflect.Field;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        User user=new User();

        MyAnnotation annotation= user.getClass().getAnnotation(MyAnnotation.class);
        Field[] fieldsUser=user.getClass().getDeclaredFields();

        for (Field field:fieldsUser){
            if(field.getType()==Integer.TYPE){
                System.out.println("Поле  " + field+ "  класу User є типу int, отже значення intValue= "+annotation.intValue() +" з анотації записуємо у це поле");
                field.setAccessible(true);
                field.set(user,annotation.intValue());
            }else {
                System.out.println("Поле  " + field+ "  класу User є типу String - отже значення stringValue= "+annotation.stringValue() +" з анотації записуємо у це поле");
                field.setAccessible(true);
                field.set(user,annotation.stringValue());
            }
        }
        System.out.println("Перевірка");
        System.out.println("user Age = "+ user.getAge());
        System.out.println("user FirstName = "+ user.getFirstName());
        System.out.println("user LastName = "+ user.getLastName());
    }
}
