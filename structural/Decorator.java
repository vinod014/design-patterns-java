public class Decorator {
    public static void main(String[] args) {
        Page webPage = new BasicPage();
        Page loginPage = new AuthPageComponent(new SocialLoginPageComponent(webPage));
        loginPage.display();
    }
}

//Type of page
interface Page{
    void display();
}

//Concrete base class for page
class BasicPage implements Page{
    public void display(){
        System.out.println("Basic page");
    }
}

//Abstract class to implement the stack behaviour by providing the page reference
abstract class PageDecorator implements Page{
    private Page page;
    public PageDecorator(Page page){
        this.page = page;
    }
    public void display(){
        this.page.display();
    }
}

//Decorator class extending the abstract class and referring it through super.
class AuthPageComponent extends PageDecorator{

    public AuthPageComponent(Page page){
        super(page);
    }
    public void display(){
        super.display();
        System.out.println("Auth page");
    }
}

//Decorator class
class SocialLoginPageComponent extends PageDecorator{
    public SocialLoginPageComponent(Page page){
        super(page);
    }

    public void display(){
        super.display();
        System.out.println("Social login page");
    }
}