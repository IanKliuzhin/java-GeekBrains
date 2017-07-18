/**
 * Created by Clown on 14.06.2015.
 */
public class Dog {

    public static void main(String[] args) {
        String s;
        s = aport("Косточка", 12);
        System.out.println("Наша собака вернула нам: " + s);

    }

    static String aport(String it, int amount) {
        String result;
        result = "Пожеванная " + it + " в количестве " + amount;
        return result;
    }
}
