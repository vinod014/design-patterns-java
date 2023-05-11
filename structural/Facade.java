class Facade{
    public static void main(String[] args) {
        //client placing the order
        OrderFacade orderFacade = new OrderFacade();
        orderFacade.placeOrder();
    }
}

class OrderVerification{
    public void verifyOrder(){
        System.out.println("Order Verified");
    }
}
class OrderShippment{
    public void shipOrder(){
        System.out.println("Order Shipped");
    }
}

class ProcessOrder{
    public void processOrder(){
        System.out.println("Order Processed");
    }
}

//Facade class
class OrderFacade{
    //All the subsystems are kept private to encapsulate and hide the information
    private OrderVerification orderVerification;
    private OrderShippment orderShippment;
    private ProcessOrder processOrder;

    public OrderFacade(){
        orderVerification = new OrderVerification();
        orderShippment = new OrderShippment();
        processOrder = new ProcessOrder();
    }
    // Facade method to place the order hiding all the subsystem complexity
    public void placeOrder(){
        orderVerification.verifyOrder();
        orderShippment.shipOrder();
        processOrder.processOrder();
    }
}

//Interface can also be created with sub classes implementing this interface, a facade class will be created which will have the reference of all the sub classes and will call the methods of the sub classes to perform the operation.