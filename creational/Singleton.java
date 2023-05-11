public class Singleton {
    public static void main(String[] args) {
        PaymentApp inst1 = PaymentApp.getInstance();
        PaymentApp inst2 = PaymentApp.getInstance();
    }
}

// Singleton class with lazy initialization
public class PaymentApp {
    private static PaymentApp instance = null;
    //Private constructor to restrict instantiation of the class from other classes.
    private PaymentApp() {
    }
    public static PaymentApp getInstance() {
        // creating instance only once
        if (instance == null) {
            System.out.println("Creating new instance");
            instance = new PaymentApp();
        }
        System.out.println("Returning instance");
        return instance;
    }
}