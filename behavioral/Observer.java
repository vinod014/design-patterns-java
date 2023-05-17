import java.util.List;
import java.util.ArrayList;
class Observer{
    public static void main(String[] args){
        BlogObserver u1 = new BlogObserverImpl("Vinod");
        BlogObserver u2 = new BlogObserverImpl("Prajwal");
        BlogObserver u3 = new BlogObserverImpl("Shravya");
        BlogObserver u4 = new BlogObserverImpl("Nishan");

        Subject blogSite = new Subject();

        blogSite.addObservers(u1);
        blogSite.addObservers(u2);
        blogSite.addObservers(u3);
        blogSite.addObservers(u4);

        Blog b1 = new Blog("Blog 1");
        blogSite.notify("Blog 1");
        Blog b2 = new Blog("Blog 2");
        blogSite.notify("Blog 2");
        Blog b3 = new Blog("Blog 3");
        blogSite.notify("Blog 3");
        Blog b4 = new Blog("Blog 4");
        blogSite.notify("Blog 4");
    }
}

interface BlogObserver{
    void update(String blogName);
}

class BlogObserverImpl implements BlogObserver{
    private String name;
    public BlogObserverImpl(String name){
        this.name = name;
    }
    public void update(String blogName){
        System.out.println(this.name + " is notified aboout blog - "+blogName);
    }
}

class Subject{
    List<BlogObserver> observers = new ArrayList<BlogObserver>();

    public void addObservers(BlogObserver blogUser){
        this.observers.add(blogUser);
    }
    public void removeObservers(BlogObserver blogUser){
        this.observers.remove(blogUser);
    }
    public void notify(String blogName){
        for(int i=0; i< this.observers.size(); i++){
            this.observers.get(i).update(blogName);
        }
    };
}

class Blog extends Subject{
    public Blog(String blogName){
    }
    public void getState(){

    }
}