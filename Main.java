import java.util.*;
class Employee
 {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) 
{
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    void display() 
{
        System.out.println("ID: " + id + ", Name: " + name + ", Salary: ₹" + salary);
    }
}

class Main 
{
    public static void main(String[] args)
 {
        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();
        int choice;

        do 
{
            System.out.println("\n=== Employee Management System ===");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.println("6. View Employee by ID"); // New
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) 
{
                case 1:
                    // Add
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();
                    employees.add(new Employee(id, name, salary));
                    System.out.println("Employee added.");
                    break;

                case 2:
                    // View All
                    if (employees.isEmpty()) 
{
                        System.out.println("No employees found.");
                    } 
else
 {
                        for (Employee e : employees) 
{
                            e.display();
                        }
                    }
                    break;

                case 3:
                    // Update
                    System.out.print("Enter ID to update: ");
                    int updateId = sc.nextInt();
                    boolean updated = false;
                    for (Employee e : employees) 
{
                        if (e.id == updateId) 
{
                            sc.nextLine();
                            System.out.print("Enter new name: ");
                            e.name = sc.nextLine();
                            System.out.print("Enter new salary: ");
                            e.salary = sc.nextDouble();
                            System.out.println("Employee updated.");
                            updated = true;
                            break;
                        }
                    }
                    if (!updated)
 {
                        System.out.println("Employee not found.");
                    }
                    break;

                case 4:
                    // Delete
                    System.out.print("Enter ID to delete: ");
                    int deleteId = sc.nextInt();
                    boolean deleted = false;
                    for (int i = 0; i < employees.size(); i++)
 {
                        if (employees.get(i).id == deleteId) 
{
                            employees.remove(i);
                            System.out.println("Employee deleted.");
                            deleted = true;
                            break;
                        }
                    }
                    if (!deleted)
 {
                        System.out.println("Employee not found.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;
case 6:
                    // View by ID
                    System.out.print("Enter ID to view: ");
                    int viewId = sc.nextInt();
                    boolean found = false;
                    for (Employee e : employees)
 {
                        if (e.id == viewId) 
{
                            e.display();
                            found = true;
                            break;
                        }
                    }
                    if (!found) 
{
                        System.out.println("Employee not found.");
                    }
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        sc.close();
    }
}