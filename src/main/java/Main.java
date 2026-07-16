import java.awt.*;
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

        // Reference Types/Objects
        int age = 21; // this is primitives
        Point pointA = new Point(10, 10);
        System.out.println("pointA = " + pointA); // print: pointA = java.awt.Point[x=10,y=10]

        // Pass Py Value With Primitives
        int height = 21;
        int heightCopy = increment(height);
        System.out.println("height = " + height); // height = 21
        System.out.println("heightCopy = " + heightCopy); // heightCopy = 22

        // Pass Py Value With Objects
        Point pointC = new Point(10, 10);
        Point pointD = pointC;

        pointC.x = 100;
        pointD.y = 90;

        System.out.println("pointC = " + pointC); // pointC = java.awt.Point[x=100,y=90]
        System.out.println("pointD = " + pointD); // pointD = java.awt.Point[x=100,y=90]

        pointD = new Point(100, 90);
        pointD.y = 55;

        System.out.println("pointC = " + pointC); // pointC = java.awt.Point[x=100,y=90]
        System.out.println("pointD = " + pointD); // pointD = java.awt.Point[x=100,y=55]
    }

    static int addNumber (int a, int b) {
        return a + b;
    }

    record Person(String name, int age) {}

    static int increment (int height) {
        return ++height;
    }
}
