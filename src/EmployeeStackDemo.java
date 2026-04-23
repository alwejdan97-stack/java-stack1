import java.util.Stack;

public class EmployeeStackDemo {
    public static void main(String[] args){
        Stack<String> employee = new Stack<>();
        employee.push("Wejdan");
        employee.push("Hoor");
        employee.push("Omar");
        employee.push("Sara");
        employee.push("Muna");
        System.out.println(employee);
        employee.push("Said");
        System.out.println("the updated stack is: " + employee);
    }
}
