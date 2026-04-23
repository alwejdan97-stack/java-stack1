import java.util.Stack;

public class EmployeeStackSearch {
    public static void main(String[] args){
        Stack<String> employee = new Stack<>();
        employee.push("Wejdan"); // add elements to the stack
        employee.push("Hoor");
        employee.push("Omar");
        employee.push("Sara");
        employee.push("Muna");
        employee.push("Said");
        System.out.println("the current stack is: "+employee); //display the stack
        System.out.println("search for employee Sara: "+employee.search("Sara")); //search for specific employee
        System.out.println("search for employee Said: " + employee.search("Said"));
        System.out.println("check if employee Noor is exist or not: "+employee.contains("Noor")); // check if the stack contain this employee or not
        for(int i= employee.size()-1; i>=0; i--){ // iterate the stack from top to down
            System.out.println(employee.get(i));
        }
        for(int i= 0; i<employee.size(); i++){ // iterate the stack from down to top
            System.out.println(employee.get(i));
        }
    }
}
