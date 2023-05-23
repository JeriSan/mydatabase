package my.project;

import dao.StudentDao;
import entity.Student;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        StudentDao studentDao = new StudentDao();
        Student student = new Student("Ramesh", "Fadatare", "rameshfadatare@javaguides.com");
        studentDao.saveStudent(student);

        List<Student> students = studentDao.getStudents();
        for(Student s : students){
            System.out.println(s.getFirstName());
        }
        //students.forEach(s -> System.out.println(s.getFirstName()));
        //System.out.println( "Hello World!" );
    }
}
