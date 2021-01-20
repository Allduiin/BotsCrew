import model.Lector;
import services.AddLectorService;
import services.MainService;
import services.impl.AddLectorServiceImpl;
import services.impl.MainServiceImpl;

public class Main {

    public static void main(String[] args) {
        Lector lector = new Lector();
        lector.setDegree(Lector.Degree.PROFESSOR);
        lector.setSalary(2000L);
        AddLectorService addLectorService = new AddLectorServiceImpl();
        addLectorService.add(lector);
        System.out.println(lector);
        MainService mainService = new MainServiceImpl();
        mainService.start();
    }
}
