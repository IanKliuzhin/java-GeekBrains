package ex3;

/**
 * Created by Clown on 14.06.2015.
 */
public class Horse {
    String name;
    int speed;
    String color;
    int age;
    boolean isMale;

    void eat() {
        about();
        System.out.println("eating...");
    }

    void ride() {
        about();
        System.out.println("riding...");
    }

    void about() {
        String sex = (isMale) ? "Male" : "Female"; //тернарный оператор
        System.out.printf("name: %s, age: %d, sex: %s\t\t", name, age, sex);
    }
}
