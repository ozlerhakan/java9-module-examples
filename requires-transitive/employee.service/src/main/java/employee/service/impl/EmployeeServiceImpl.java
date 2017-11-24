package employee.service.impl;

import employee.model.Employee;
import employee.service.api.EmployeeService;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Created by hakan on 23/11/2017
 */
public class EmployeeServiceImpl implements EmployeeService {

    // public no-arg constructor is a must in order for Service Loader to find the service implementation

    private static final Supplier<List<Employee>> orderedImmutableEmployeesByAge = () ->
            List.of(new Employee("Paul", "Doe", 25, "Izmir"),
                    new Employee("Joe", "Donalt", 30, "Istanbul"),
                    new Employee("Sophie", "Fun", 31, "Adana"),
                    new Employee("Marc", "Denim", 44, "Izmir"),
                    new Employee("Paul", "Richard", 51, "Ankara"));


    public Optional<Employee> findOneBy(String name) {
        return orderedImmutableEmployeesByAge.get()
                .stream()
                .filter(employee -> employee.getName().equals(name))
                .findFirst();
    }

    public Optional<Employee> findOneBy(int age) {
        return orderedImmutableEmployeesByAge.get()
                .stream()
                .filter(employee -> employee.getAge() == age)
                .findFirst();
    }

    public List<Employee> findBy(String name) {
        return orderedImmutableEmployeesByAge.get()
                .stream()
                .filter(employee -> employee.getName().equals(name))
                .collect(Collectors.toList());
    }

    public List<Employee> takeWhile(int age) {
        return orderedImmutableEmployeesByAge.get()
                .stream()
                .takeWhile(employee -> employee.getAge() == age)
                .collect(Collectors.toList());
    }
}
