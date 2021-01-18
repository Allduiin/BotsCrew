import services.MainService;
import services.impl.MainServiceImpl;

public class Main {
    public static void main(String[] args) {
        MainService mainService = new MainServiceImpl();
        mainService.start();
    }
}
