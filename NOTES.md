# Notes

## learn Java 25 in 10 minutes


### Using `record`

`record` is a shorthand for creating a class.

When you run `System.out.println(jamila)`, it does not print a memory address:
```java
public class Main {
    void main() {
        var jamila = new Person("Jamila", 20);
        System.out.println(jamila);
        
    record Person(String name, int age) {}
}
```

It prints something readable like this:
```bash
Person[name=Jamila, age=20]
```

Java secretly writes a lot of code for you behind the scenes. You get:

- A constructor, so `new Person("Jamila", 20)` works.
- Read methods called `name()` and `age()`. Note they are not `getName()`. A record uses the field name directly.
- An `equals()` method, so two `Person` objects with the same name and age count as equal.
- A `hashCode()` method, useful when you put the object in a Set or Map.
- A `toString()` method.

```java
public class Main {
    void main() {
        var jamila = new Person("Jamila", 20);
        System.out.println(jamila.name());
        
    record Person(String name, int age) {}
}
```

It prints something like this:
```bash
Jamila
```

If I do this:
```java
System.out.println(jamila.equals(new Person("Jamila", 20)));
```

It prints something like this:
```bash
true
```

Here is the normal, correct way to write it by hand:
```java
public class Person {
    // 1. Declare the fields
    private final String name;
    private final int age;

    // 2. Constructor: same name as the class
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 3. Getters, so other code can read the values
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person[name=" + name + ", age=" + age + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person p = (Person) o;
        return age == p.age && name.equals(p.name);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(name, age);
    }
}
```

Now you can see the point of `record`.

All of this, the fields, the constructor, the getters, toString, equals, and hashCode, is what one line `record Person(String name, int age) {}` replaces.

## Java for Beginners

### `sout` Keyboard Shortcut
I can just write `void main() {}` instead of `public static void main(String[] args) {}` for the entry `Main.class`.

### Reference Types And Objects Differences

`Memory Stack` is used to store the execution of a thread.

`frame` in the stack: contains all the data of one function call. `int` types' variables' values will be stored in the frame directly whereas `String` and `Object` will only have their address stored.

Those addresses point to the actual location of the values of those objects and strings.

`Heap` is used to store objects and strings.

### Pass Py Value With Primitives

`height` will be put on the stack. `heightCopy` will be put on the stack separately with the same value as `height` on the stack.

```java
public class Main {
    void main() {
        // Pass Py Value With Primitives
        int height = 21;
        int heightCopy = increment(height);
        System.out.println("height = " + height); // height = 21
        System.out.println("heightCopy = " + heightCopy); // heightCopy = 22
    }
    
    static int increment (int height) {
        return ++height;
    }
}
```

### Pass Py Value With Reference Types

For objects, it's all about copying references, not the actual values.

So when I change the values of either objects, they're changed altogether:
```java
public class Main {
    void main() {
        // Pass Py Value With Objects
        Point pointC = new Point(10, 10);
        Point pointD = pointC;

        pointC.x = 100;
        pointD.y = 90;

        System.out.println("pointC = " + pointC); // pointC = java.awt.Point[x=100,y=90]
        System.out.println("pointD = " + pointD); // pointD = java.awt.Point[x=100,y=90]
    }
}
```

If I then create a new object and assign it to `pointD`, then they're referencing to different objects in the heap now.

So `pointC` will remain the same when data in `pointD` has changed:
```java
public class Main {
    void main() {
        // Pass Py Value With Objects
        Point pointC = new Point(10, 10);
        Point pointD = pointC;

        pointC.x = 100;
        pointD.y = 90;

        System.out.println("pointC = " + pointC); // pointC = java.awt.Point[x=100,y=90]
        System.out.println("pointD = " + pointD); // pointD = java.awt.Point[x=100,y=90]
        
        // Adding:
        pointD = new Point(100, 90);
        pointD.y = 55;

        System.out.println("pointC = " + pointC); // pointC = java.awt.Point[x=100,y=90]
        System.out.println("pointD = " + pointD); // pointD = java.awt.Point[x=100,y=55]
    }
}
```