import java.awt.*;
import java.util.Arrays;
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
        
        // Fixed sized Arrays
        int[] numbersArray = new int[3];
        numbersArray[0] = 1;
        numbersArray[1] = 33;
        numbersArray[2] = 9;
        System.out.println("numbersArray = " + Arrays.toString(numbersArray)); // numbersArray = [1, 33, 9]

        int[] numbersArray2 = {0, 5, 6, 2, 3};
        System.out.println("numbersArray2 = " + Arrays.toString(numbersArray2)); // numbersArray2 = [0, 5, 6, 2, 3]
        numbersArray2[1] = 55;
        System.out.println("numbersArray2 = " + Arrays.toString(numbersArray2)); // numbersArray2 = [0, 55, 6, 2, 3]

        System.out.println("numbersArray2.length = " + numbersArray2.length); // numbersArray2.length = 5

        String[] names = {"Alex", "Betsy"};
        System.out.println(Arrays.toString(names)); // [Alex, Betsy]

        double[] numbersArray3 = {0, 5, 6, 2, 3};
        System.out.println(Arrays.toString(numbersArray3)); // [0.0, 5.0, 6.0, 2.0, 3.0]
    }

    static int addNumber (int a, int b) {
        return a + b;
    }

    record Person(String name, int age) {}

    static int increment (int height) {
        return ++height;
    }
}
