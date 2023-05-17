import java.util.List;
import java.util.ArrayList;
class Mediator{
    public static void main(String[] args){
        ChatMediator mediator = new ChatMediatorImpl();
        User u1 = new User("Vinod",mediator);
        User u2 = new User("Shravya",mediator);
        User u3 = new User("Nishan", mediator);
        User u4 = new User("Prajwal",mediator);

        //Adding users to mediator
        mediator.addUser(u1);
        mediator.addUser(u2);
        mediator.addUser(u3);
        mediator.addUser(u4);

        u1.sendMessage("Hello World!");
        u2.sendMessage("Bravo!");
    }
}

interface ChatMediator{
    void sendMessage(String text, User user);
    void addUser(User user);
}

class ChatMediatorImpl implements ChatMediator{
    List<User> users = new ArrayList<User>();
    public void addUser(User user){
        this.users.add(user);
    }
    //Mediator sending message to all the users on behalf of the sender user.
    public void sendMessage(String text, User user){
        for(int i=0; i< users.size(); i++){
            if(users.get(i) != user){
                users.get(i).receiveMessage(text);
            }
        }
    }
}

class User{
    public String name;
    private ChatMediator mediator;
    public User(String name,ChatMediator mediator){
        this.name = name;
        this.mediator = mediator;
    }
    //User sending the message to mediator instead of all the users
    public void sendMessage(String text){
        System.out.println(this.name + " is sending a message - "+text);
        this.mediator.sendMessage(text,this);
    }
    public void receiveMessage(String text){
        System.out.println(this.name + " received a message - "+text);
    }
}