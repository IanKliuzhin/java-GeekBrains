package ex1Static;

/**
 * Created by MPotekhina on 21.06.15.
 */
public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Murka");
        Cat cat2 = new Cat();
        Cat cat3 = new Cat();

        System.out.println(Cat.catsAmount);

        Cat.test();
        Cat.test();

    }
}
