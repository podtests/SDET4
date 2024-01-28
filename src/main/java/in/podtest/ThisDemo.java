package in.podtest;

public class ThisDemo {

    String name; //null

    public ThisDemo() {

    }
    public ThisDemo(String name2) {
        name = name2;
    }

    public ThisDemo sayHello() {
        System.out.println("Hello "+name+ "!");
        return this;
    }
}
