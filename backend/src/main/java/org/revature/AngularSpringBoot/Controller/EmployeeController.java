package org.revature.AngularSpringBoot.Controller;

import java.util.List;

import org.revature.AngularSpringBoot.Model.Employee;
import org.revature.AngularSpringBoot.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController is a convenience annotation that is itself annotated with @Controller and @ResponseBody. Applied to a
//class to mark it as a request handler. Used to created RESTful web services using Spring MVC.
@RestController

@CrossOrigin(origins = "http://localhost:4200")

//@RequestMapping is the most common and widely used annotation in Spring MVC. Used to map web requests onto specific handler classes and/or handler methods. 
//Can be applied to the controller class as well as methods. 
@RequestMapping("/api/v1/")
public class EmployeeController {
    //@Autowired is used for dependency injections. In Spring Boot all loaded beans are eligible for auto wiring to another bean. 
    @Autowired
    private EmployeeRepository employeeRepository;

    //@GetMapping is used for mapping HTTP GET requests onto specific handler methods. Specifically acts as a shortcut for @RequestMapping(method = RequestMethod.GET)
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    
    //@PostMapping maps HTTP POST requests onto specific handler methods. Specifically acts as a shortcut for @RequestMapping(method=RequestMethod.POST)
    @PostMapping("/employees")
    public Employee postArtist(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }
}
