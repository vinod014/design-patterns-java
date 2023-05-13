import java.util.ArrayList;
import java.util.List;

public class Composite {
    public static void main(String[] args) {
        Employee employee1 = new Employee("John", 10000);
        Employee employee2 = new Employee("David", 15000);

        Manager manager1 = new Manager("Daniel", 25000);
        manager1.addReportee(employee1);
        manager1.addReportee(employee2);

        employee1.getName();
        employee1.getSalary();

        employee2.getName();
        employee2.getSalary();

        manager1.getName();
        manager1.getSalary();
        manager1.getReportees();

    }
}

//component interface for both leaf and composite classes
interface Component {
    void getName();
    void getSalary();
}

//leaf class - resembling individual employee of the organization
class Employee implements Component{
    private String name;
    private int salary;
    public Employee(String name, int salary){
        this.name = name;
        this.salary = salary;
    }
    public void getName(){
        System.out.println("Name: "+this.name);
    }
    public void getSalary(){
        System.out.println("Salary: "+this.salary);
    }
}

//composite class - resembling manager of the organization with reportees as leaf nodes
class Manager implements Component{
    private List<Component> reportees = new ArrayList<Component>();
    private String name;
    private int salary;
    public Manager(String name, int salary){
        this.name = name;
        this.salary = salary;
    }
    public void getName(){
        System.out.println("Name: "+this.name);
    }
    public void getSalary(){
        System.out.println("Salary: "+this.salary);
    }
    public void addReportee(Component reportee){
        this.reportees.add(reportee);
    }

    public void getReportees(){
        System.out.println("Reportees: ");
        for(Component reportee: this.reportees){
            reportee.getName();
        }
    }
}
