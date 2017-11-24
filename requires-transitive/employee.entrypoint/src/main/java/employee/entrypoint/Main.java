package employee.entrypoint;

import employee.service.api.EmployeeService;

import java.util.ServiceLoader;

/**
 * Created by hakan on 23/11/2017
 */
public class Main {

    public static void main(String[] args) {

        EmployeeService employeeService = ServiceLoader.load(EmployeeService.class).findFirst().get();

        employeeService.findOneBy(44).ifPresent(System.out::println);
        employeeService.findOneBy("Sophie").ifPresent(System.out::println);

        employeeService.findBy("Paul").forEach(System.out::println);
        employeeService.takeWhile(54).forEach(System.out::println);

    }
}
