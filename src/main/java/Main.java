import config.AppConfig;
import java.util.Arrays;
import model.Department;
import model.Lector;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.AddDepartmentService;
import services.AddLectorService;
import services.MainService;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        Lector lector1 = new Lector();
        lector1.setDegree(Lector.Degree.PROFESSOR);
        lector1.setSalary(2000L);
        lector1.setName("Bogdan Shevchenko");
        AddLectorService addLectorService = context.getBean(AddLectorService.class);
        addLectorService.add(lector1);

        Lector lector2 = new Lector();
        lector2.setDegree(Lector.Degree.ASSISTANT);
        lector2.setSalary(1000L);
        lector2.setName("Olexandr Kovalenko");
        addLectorService.add(lector2);

        Department department = new Department();
        department.setHeadOfDepartment(lector1);
        department.setName("Math_Department");
        department.setLectors(Arrays.asList(lector1,lector2));
        AddDepartmentService addDepartmentService = context.getBean(AddDepartmentService.class);
        addDepartmentService.add(department);

        context.getBean(MainService.class).start();
    }
}
