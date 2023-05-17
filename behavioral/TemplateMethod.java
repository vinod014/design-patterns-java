class TemplateMethod{
    public static void main(String[] args) {
        GameOrder digitalOrder = new DigitalGame();
        digitalOrder.placeGameOrder();

        GameOrder physicalOrder = new PhysicalGame();
        physicalOrder.placeGameOrder();
    }
}

abstract class GameOrder{
    //Template method handling common steps for both type of order.
    final void placeGameOrder(){
        validateOrder();
        getPayment();
        fulfilOrderShipment();
        notifyUser();
    }
    private void validateOrder(){
        System.out.println("Validating the order");
    }
    private void getPayment(){
        System.out.println("Fetching the order payment");
    }
    abstract void fulfilOrderShipment();
    abstract void notifyUser();
}

class DigitalGame extends GameOrder{
    //Implementing the business logic specific to the type of order.
    public void fulfilOrderShipment(){
        System.out.println("Fulfilling order shipment of digital game");
    }
    public void notifyUser(){
        System.out.println("Notifying user about digital game purchase");
    }
}

class PhysicalGame extends GameOrder{
    //Implementing the business logic specific to the type of order.
    public void fulfilOrderShipment(){
        System.out.println("Fulfilling order shipment of physical game");
    }
    public void notifyUser(){
        System.out.println("Notifying user about physical game purchase");
    }
}