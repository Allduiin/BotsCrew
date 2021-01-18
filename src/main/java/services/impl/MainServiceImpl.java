package services.impl;

import java.util.Scanner;
import services.AverageSalaryForDepartmentService;
import services.CountOfEmployeeService;
import services.DepartmentStaticsService;
import services.GlobalSearchService;
import services.HeadOfDepartmentService;
import services.MainService;

public class MainServiceImpl implements MainService {
    private static final String STATISTICS_COMMAND = "Show statistics.";
    private static final String SALARY_COMMAND = "Show the average salary for the department ";
    private static final String COUNT_EMPLOYEE_COMMAND = "Show count of employee for ";
    private static final String SEARCH_COMMAND = "Global search by ";
    private static final String EXIT_COMMAND = "exit";
    private static final String HEAD_DEPARTMENT_COMMAND
            = "Who is head of department ";
    private static Byte exitConstant = 0;
    private final AverageSalaryForDepartmentService averageSalaryForDepartmentService
            = new AverageSalaryForDepartmentServiceImpl();
    private final CountOfEmployeeService countOfEmployeeService
            = new CountOfEmployeeServiceImpl();
    private final DepartmentStaticsService departmentStaticsService
            = new DepartmentStaticsServiceImpl();
    private final GlobalSearchService globalSearchService
            = new GlobalSearchServiceImpl();
    private final HeadOfDepartmentService headOfDepartmentService
            = new HeadOfDepartmentServiceImpl();

    @Override
    public void start() {
        System.out.println("Welcome to university bot service\n"
                + "here you can ask questions like:\n"
                + "Who is head of department {department_name}\n"
                + "Show {department_name} statistics.\n"
                + "Show the average salary for the department {department_name}.\n"
                + "Show count of employee for {department_name}\n"
                + "Global search by {template}.\n"
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
                && command.endsWith(" statistics.")) {
            departmentStaticsService.takeDepartmentStatistics(command
                    .substring("Show ".length(), command.length() - " statistics.".length()));
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
        }
    }
}
