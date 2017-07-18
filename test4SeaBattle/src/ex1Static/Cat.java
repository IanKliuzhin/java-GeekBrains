package ex1Static;

/**
 * Created by MPotekhina on 21.06.15.
 */
class Cat {
    private String name;
    int age;
    static int catsAmount;

    public Cat(String name) {
        this();
        this.name = name;
    }

    public Cat() {
        catsAmount++;
    }

    static void test() {
        System.out.println("hello, cat!");
    }
}
