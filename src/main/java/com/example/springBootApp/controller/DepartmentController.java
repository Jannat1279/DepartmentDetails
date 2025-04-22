package com.example.springBootApp.controller;

import com.example.springBootApp.entity.Department;
import com.example.springBootApp.error.DepartmentNotFoundException;
import com.example.springBootApp.service.DepartmentService;
import com.example.springBootApp.service.DepartmentServiceImp;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @RestController, @PostMapping, @GetMapping, etc.—used to build RESTful web services.
//Logger for debugging/logging requests.

@RestController
public class DepartmentController {

//    Autowire the particular object that you have in your spring container
    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER= LoggerFactory.getLogger(DepartmentController.class
    );
    @PostMapping("/departments")
//    With this annotation, we are getting the entire JSON object to the dep object
    public Department saveDepartment(@RequestBody Department department){
//        DepartmentService service=new DepartmentServiceImp();
        LOGGER.info("Inside saveDepartment of DepartmentController");
            return departmentService.saveDepartment(department);
    }
    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        LOGGER.info("Inside fetchDepartmentList of DepartmentController");
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted successfully";
    }

//    In Spring Boot, @RequestBody is used to automatically convert the JSON data coming in from an HTTP request into a Java object.
    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department){
        return departmentService.updateDepartment(departmentId,department);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@Valid @PathVariable("name") String departmentName){
        return departmentService.fetchDepartmentByName(departmentName);
    }
}
