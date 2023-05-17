import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Command{
    public static void main(String[] args){
        Order o1 = new Order();
        Order o2 = new Order();

        //List of commands being stored
        List<OrderCommand> commands = new ArrayList<OrderCommand>();
        commands.add(new CancelOrderCommand(o1));
        commands.add(new CancelOrderCommand(o2));
        commands.add(new RevokeCancelOrderCommand(o1));
        commands.add(new RevokeCancelOrderCommand(o2));

        //Executing all the commands later
        for(int i=0; i<commands.size();i++){
            commands.get(i).execute();
        }
    }
}

//Receiver class of order to cancel or revoke cancel
class Order{
    public int ID;
    Random random = new Random();
    public Order(){
        this.ID = random.nextInt(10);
    }
    public void cancelOrder(){
        System.out.println("Cancelling the order "+ this.ID);
    }
    public void revokeCancelOrder(){
        System.out.println("Revoking the order cancellation "+ this.ID);
    }
}

//interface to wrap order cancel as a command
interface OrderCommand{
    void execute();
}

//Concrete command to cancel order
class CancelOrderCommand implements OrderCommand{
    private Order order;
    public CancelOrderCommand(Order order){
        this.order = order;
    }
    public void execute() {
        order.cancelOrder();
    }
}

//Concrete command to revoke cancel order command
class RevokeCancelOrderCommand implements OrderCommand{
    private Order order;
    public RevokeCancelOrderCommand(Order order){
        this.order = order;
    }
    public void execute() {
        order.revokeCancelOrder();
    }
}