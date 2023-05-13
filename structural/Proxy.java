import javax.print.Doc;

public class Proxy {
    public static void main(String[] args) {
        Document document = new ProxyDocument(null);
        document.write("Hello World");
        document.write("\nThis is a proxy pattern example");
        document.write("\nEnd of example");
        document.save();
    }

}

interface Document{
    void write(String text);
    void save();
}

//Remote proxy example
class ProxyDocument implements Document{

    private String text;
    private RemoteDocument remoteDocument;
    public ProxyDocument(String text){
        this.text = text;
        this.remoteDocument = new RemoteDocument("");
    }
    public void write(String text){
        if(this.text == null){
            this.text = text;
        } else{
            this.text += text;
        }
    }
    //save to remote server - polymorphism in action
    public void save(){
        this.remoteDocument.write(this.text);
        this.remoteDocument.save();
    }
}


class RemoteDocument implements Document{
    private String text;
    public RemoteDocument(String text){
        this.text = text;
    }
    public void write(String text){
        if(this.text == null){
            this.text = text;
        } else{
            this.text += text;
        }
    }
    public void save(){
        System.out.println("Saving to remote server");
        System.out.println("Text: \n"+this.text);
    }
}
