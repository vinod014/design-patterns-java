
public class Adapter {
    public static void main(String[] args) {
        //Client code feeding dog details in string format
        feedDogDetails feedDogDetails = new feedDogDetails();
        feedDogDetails.request("Maxi","5");
        feedDogDetails.request("Sufi","6");
        feedDogDetails.request("Bruno","7");
    }
}

class Dog {
    String name;
    String age;
    public Dog(String name, String age){
        this.name = name;
        this.age = age;
    }
}

//Adapter class - Converting string data to Dog object
class feedDogDetails{
    public void request(String name, String age){
        Dog dog = new Dog(name,age);
        logDogDetails logDogDetails = new logDogDetails();
        logDogDetails.printDogNameAndAge(dog);
    }

}

//Adaptee class - understands Dog object
class logDogDetails{
    public void printDogNameAndAge(Dog dog){
        System.out.println("Name: "+dog.name+" Age: "+dog.age);
    }
}

//Interface for Adapter can also be created and client can use the interface methods to call the adapter
