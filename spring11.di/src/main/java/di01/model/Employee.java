package di01.model;

public class Employee {
    
    // 필드 추가
    private String firstname;
    private String lastname;
    private int    salary;
    
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "Employee [firstname=" + firstname + ", lastname=" + lastname
                + ", salary=" + salary + "]";
    }
    public Employee() {
        super();
    }
    public Employee(String firstname, String lastname, int salary) {
        super();
        this.firstname = firstname;
        this.lastname = lastname;
        this.salary = salary;
    }
    
    
}
