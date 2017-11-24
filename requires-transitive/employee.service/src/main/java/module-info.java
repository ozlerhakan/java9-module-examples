import employee.service.impl.EmployeeServiceImpl;

module employee.service {

    exports employee.service.api;

    requires transitive employee.model;

    provides employee.service.api.EmployeeService with EmployeeServiceImpl;
}