package com.jsp;

import java.util.List;
import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.jsp.config.StudentConfig;
import com.jsp.dao.StudentDao;
import com.jsp.entity.Student;
import com.jsp.service.StudentService;

public class StudentDriver {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(StudentConfig.class);
        StudentService service = ac.getBean("service", StudentService.class);
        Scanner sc = new Scanner(System.in);
        
        int op = 0;
        while (op != 7) {
            
            System.out.println("1. Save Student");
            System.out.println("2. Find Student By ID");
            System.out.println("3. Delete Student By ID");
            System.out.println("4. Update Student By ID");
            System.out.println("5. All Details of Student");
            System.out.println("6. Find Student by Name");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            op = sc.nextInt();
            
            switch (op) {
                case 1:
                    System.out.println("Enter Student Details");
                    Student st = new Student();
                    System.out.print("Enter Student's Name: ");
                    st.setName(sc.next());
                    System.out.print("Enter Student's Age: ");
                    st.setAge(sc.nextInt());
                    System.out.print("Enter Student's Address: ");
                    st.setAdress(sc.next());
                    System.out.print("Enter Student's Phone: ");
                    st.setPhone(sc.nextLong());
                    service.saveStudent(st);
                    System.out.println("Student saved successfully.");
                    break;
                
                case 2:
                    System.out.print("Enter Student ID to find: ");
                    Student s = service.findById(sc.nextInt());
                    if (s != null) {
                        System.out.println(s);
                    } else {
                        System.err.println("No data found with this ID.");
                    }
                    break;
                
                case 3:
                    System.out.print("Enter the ID to delete: ");
                    service.deleteById(sc.nextInt());
                    break;
                
                case 4:
                    System.out.println("Enter Updated Student Details");
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    
                    Student st1 = new Student();
                    System.out.print("Enter Updated Student's Name: ");
                    st1.setName(sc.next());
                    System.out.print("Enter Updated Student's Age: ");
                    st1.setAge(sc.nextInt());
                    System.out.print("Enter Updated Student's Address: ");
                    st1.setAdress(sc.next());
                    System.out.print("Enter Updated Student's Phone: ");
                    st1.setPhone(sc.nextLong());
                    service.updateStudent(st1, id);
                    System.out.println("Student updated successfully.");
                    break;
                case 5:
                	System.out.println("All Student Details");
                	List<Student> st2 = service.getAllStudent();
                	for (Student student : st2) {
						System.out.println(student.getName());
						System.out.println(student.getAge());
						
					}
                	break;
                case 6 : 
                	  System.out.print("Enter Student Name to find: ");
                      Student st3 = service.getStudentByName(sc.next());
                      if (st3 != null) {
                          System.out.println(st3);
                      } else {
                          System.err.println("No data found with this ID.");
                      }
                      break;
                  
                case 7:
                    System.out.println("Exiting program...");
                    break;
                
                default:
                    System.err.println("Invalid choice! Please select a valid option.");
                    break;
            }
        }
        
        sc.close(); 
    }
}
