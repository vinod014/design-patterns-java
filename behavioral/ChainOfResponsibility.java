class ChainOfResponsibility{
    public static void main(String[] args) {
        try{
            Handler handler = new Handler1();
            handler.handleEvent();
        } catch (Exception e){
            System.out.println("Main method catch " + e.getMessage());
        }
    }
}

//Exception handling is one of the example for chain of responsibility pattern.

interface Handler {
    void handleEvent() throws Exception;
}

class Handler1 implements Handler{
    public void handleEvent() throws Exception{
        try{
            System.out.println("Handler 1");
            Handler handler = new Handler2();
            handler.handleEvent();
        } catch (Exception e){
            System.out.println("Handler 1 catch " + e.getMessage());
        }
    }
}
class Handler2 implements Handler{
    public void handleEvent() throws Exception{
        try{
            System.out.println("Handler 2");
            Handler handler = new Handler3();
            handler.handleEvent();
        } catch (Exception e){
            System.out.println("Handler 2 catch " + e.getMessage());
            throw new Exception("Some error occurred in Handler 2");
        }
    }
}
class Handler3 implements Handler{
    public void handleEvent() throws Exception{
        try{
            System.out.println("Handler 3");
            throw new Exception("Error");
        } catch (Exception e){
            throw new Exception("Some error occurred in Handler 3");
        }
    }
}