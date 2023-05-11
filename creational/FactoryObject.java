class FactoryObject {
    public static void main(String[] args) {
        //Using factory to get the object of concrete class by passing an information such as type.
        PaymentGatewayFactory factory = new PaymentGatewayFactory();

        //Using PaymentGateway interface as type to avoid tight coupling.
        PaymentGateway paymentGateway;
        //new keyword is not used here to avoid tight coupling.
        paymentGateway = factory.createObject("paypal");

        paymentGateway.makePayment();

        paymentGateway = factory.createObject("razorpay");
        paymentGateway.makePayment();
    }
}

interface PaymentGateway {
    public void makePayment();
    public void refundPayment();
}

class PayPal implements PaymentGateway{
    public void makePayment(){
        System.out.println("Making payment using paypal");
    }
    public void refundPayment(){
        System.out.println("Refunding payment using paypal");
    }
}

class RazorPay implements PaymentGateway{
    public void makePayment(){
        System.out.println("Making payment using razorpay");
    }
    public void refundPayment(){
        System.out.println("Refunding payment using razorpay");
    }
}

class PaymentGatewayFactory {
    public PaymentGateway createObject(String type) {
        //Factory class creates object based on information provided
        //new keyword will be used here to create concrete instantiations
        if(type=="paypal"){
            return new PayPal();
        }
        else if(type=="razorpay"){
            return new RazorPay();
        } else {
            return null;
        }
    }
}