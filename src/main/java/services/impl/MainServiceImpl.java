package services.impl;

import java.util.Scanner;
import org.springframework.stereotype.Service;
import services.AverageSalaryForDepartmentService;
import services.CountOfEmployeeService;
import services.DepartmentStaticsService;
import services.GlobalSearchService;
import services.HeadOfDepartmentService;
import services.MainService;

@Service
public class MainServiceImpl implements MainService {
    private static final String[] STATISTICS_COMMAND = {"Show ", " statistics"};
    private static final String SALARY_COMMAND = "Show the average salary for the department ";
    private static final String COUNT_EMPLOYEE_COMMAND = "Show count of employee for ";
    private static final String SEARCH_COMMAND = "Global search by ";
    private static final String EXIT_COMMAND = "exit";
    private static final String HEAD_DEPARTMENT_COMMAND
            = "Who is head of department ";
    private static Byte exitConstant = 0;
    private final AverageSalaryForDepartmentService averageSalaryForDepartmentService;
    private final CountOfEmployeeService countOfEmployeeService;
    private final DepartmentStaticsService departmentStaticsService;
    private final GlobalSearchService globalSearchService;
    private final HeadOfDepartmentService headOfDepartmentService;

    public MainServiceImpl(AverageSalaryForDepartmentService averageSalaryForDepartmentService,
                           CountOfEmployeeService countOfEmployeeService,
                           DepartmentStaticsService departmentStaticsService,
                           GlobalSearchService globalSearchService,
                           HeadOfDepartmentService headOfDepartmentService) {
        this.averageSalaryForDepartmentService = averageSalaryForDepartmentService;
        this.countOfEmployeeService = countOfEmployeeService;
        this.departmentStaticsService = departmentStaticsService;
        this.globalSearchService = globalSearchService;
        this.headOfDepartmentService = headOfDepartmentService;
    }

    @Override
    public void start() {
        System.out.println("Welcome to university bot service\n"
                + "here you can ask questions like:\n"
                + "Who is head of department {department_name}\n"
                + "Show {department_name} statistics\n"
                + "Show the average salary for the department {department_name}\n"
                + "Show count of employee for {department_name}\n"
                + "Global search by {template}\n"
                + "exit\n");
        try (Scanner scanner = new Scanner(System.in)) {
            while (exitConstant == 0) {
                releaseUserCommand(scanner.nextLine());
            }
        }
    }

    @Override
    public void releaseUserCommand(String command) {
        if (command.startsWith(HEAD_DEPARTMENT_COMMAND)) {
            headOfDepartmentService.takeHeadOfDepartment(command
                    .substring(HEAD_DEPARTMENT_COMMAND.length()));
        } else if (command.startsWith("Show ")
                && command.endsWith(" statistics")) {
            departmentStaticsService.takeDepartmentStatistics(command
                    .substring(STATISTICS_COMMAND[0].length(),
                            command.length() - STATISTICS_COMMAND[1].length()));
        } else if (command.startsWith(SALARY_COMMAND)) {
            averageSalaryForDepartmentService.takeAverageSalary(command
                    .substring(SALARY_COMMAND.length()));
        } else if (command.startsWith(COUNT_EMPLOYEE_COMMAND)) {
            countOfEmployeeService.takeEmployeeCount(command
                    .substring(COUNT_EMPLOYEE_COMMAND.length()));
        } else if (command.startsWith(SEARCH_COMMAND)) {
            globalSearchService.globalSearch(command.substring(SEARCH_COMMAND.length()));
        } else if (command.equals(EXIT_COMMAND)) {
            System.out.println("Thanks for using our bot");
            exitConstant = 1;
        } else if (command.equals("/help")) {
            System.out.println("here you can ask commands like:\n"
                    + "Who is head of department {department_name}\n"
                    + "Show {department_name} statistics\n"
                    + "Show the average salary for the department {department_name}\n"
                    + "Show count of employee for {department_name}\n"
                    + "Global search by {template}\n"
                    + "exit\n");
        } else {
            System.out.println("Incorrect command please try again, "
                    + "you can also use command '/help'");
        }
    }
}
