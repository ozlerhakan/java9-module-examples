package employee.service.api;

import employee.model.Employee;

import java.util.List;
import java.util.Optional;

/**
 * Created by hakan on 23/11/2017
 */
public interface EmployeeService {

    Optional<Employee> findOneBy(String name);

    Optional<Employee> findOneBy(int age);

    List<Employee> findBy(String name);

    List<Employee> takeWhile(int age);

}
