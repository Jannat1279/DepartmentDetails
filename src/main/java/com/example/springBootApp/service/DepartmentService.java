package com.example.springBootApp.service;

import com.example.springBootApp.entity.Department;
import com.example.springBootApp.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {

   public Department saveDepartment(Department department);

   public List<Department> fetchDepartmentList();

   public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

   public void deleteDepartmentById(Long departmentId);

   public Department updateDepartment(Long departmentId, Department department);

   public Department fetchDepartmentByName(String departmentName);
}
//The controller receives requests.
//The service layer processes logic (like validation, transformation, etc.).
//Then it talks to the repository to interact with the database.