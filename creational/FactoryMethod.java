class FactoryMethod{
    public static void main(String[] args) {
        PaymentGateway regionalGateway = new RegionalPaymentGatewaysFactory();
        regionalGateway.createPaymentApp("paytm");
        regionalGateway.makePayment();
        PaymentGateway internationalGateway = new InternationalPaymentGatewaysFactory();
        internationalGateway.createPaymentApp("paypal");
        internationalGateway.makePayment();
    }
}

//Abstact class with createPaymentApp() as abstract method representing factory method
public abstract class PaymentGateway{
    public void makePayment(){
        System.out.println("Making payment");
    }
    public void refundPayment(){
        System.out.println("Refunding payment");
    }
    public abstract void createPaymentApp(String type);
}

//Factory class to handle regional payments with factory method implementation
class RegionalPaymentGatewaysFactory extends PaymentGateway{
    public void createPaymentApp(String type){
        if(type == "paytm"){
            System.out.println("Creating paytm instance");
        }
        else if(type == "phonepe"){
            System.out.println("Creating phonepe instance");
        }
        else{
            System.out.println("Creating googlepay instance");
        }
    }
}

//Factory class to handle international payments with factory method implementation
class InternationalPaymentGatewaysFactory extends PaymentGateway{
    public void createPaymentApp(String type){
        if(type == "paypal"){
            System.out.println("Creating paypal instance");
        }
        else if(type == "stripe"){
            System.out.println("Creating stripe instance");
        }
        else{
            System.out.println("Creating razorpay instance");
        }
    }
}
