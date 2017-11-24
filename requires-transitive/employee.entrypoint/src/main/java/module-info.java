module employee.entrypoint {

    requires employee.service;

    uses employee.service.api.EmployeeService;
}

//  uses employee.service.impl.EmployeeServiceImpl; we cannot use the implementation directly!
