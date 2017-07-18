// Однострочный комментарий

/*
    Многострочный
    комментарий
 */

/**
 * javadoc
 * Created by Clown on 14.06.2015.
 */
// самодокументирующийся код (отказ от комментариев, использование говорящих переменных)
public class Kitchen {

    // psvm + Tab
    public static void main(String[] args) {
        System.out.println("Ура, заработало!");
        System.out.println("Kitchen");
        cookSoup();

    }


    // метод, функция, процедура, подпрограмма, блок кода, рецепт — синонимы
    static void cookSoup() {
        System.out.println("Boil water");
        //sout + Tab
        System.out.println("...");
        cookBreakfast();
        System.out.println("done.");
    }

    static void cookBreakfast() {
        System.out.println("Breakfast done.");
    }

}
