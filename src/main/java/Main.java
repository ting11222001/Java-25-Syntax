import java.util.List;

/**
 * @author Li-Ting Liao
 * @version 1.0
 * @since 07/2026
 */
public class Main {
    void main() {
        var name = "Tiff";
        System.out.println(name.toLowerCase());

        var numberA = 10;
        var numberB = 20;
        System.out.println(addNumber(numberA, numberB));

        var jamila = new Person("Jamila", 20);
        System.out.println(jamila);
        System.out.println(jamila.name());
        System.out.println(jamila.equals(new Person("Jamila", 20)));

        var isValid = false;
        if (isValid) {
            System.out.println("isValid");
        } else {
            System.out.println("isNotValid");
        }

        var numbers = List.of(1,2,3,4,5);
        numbers.forEach(number -> {
            System.out.println(number * 2);
        });
    }

    static int addNumber (int a, int b) {
        return a + b;
    }

    record Person(String name, int age) {}
}
