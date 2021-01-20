import config.AppConfig;
import model.Lector;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.AddLectorService;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        AddLectorService addLectorService = context.getBean(AddLectorService.class);

        Lector lector = new Lector();
        lector.setDegree(Lector.Degree.PROFESSOR);
        lector.setSalary(2000L);
        addLectorService.add(lector);
        System.out.println(lector);
    }
}
