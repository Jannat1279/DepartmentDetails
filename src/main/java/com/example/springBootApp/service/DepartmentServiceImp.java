package com.example.springBootApp.service;

import com.example.springBootApp.entity.Department;
import com.example.springBootApp.error.DepartmentNotFoundException;
import com.example.springBootApp.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Objects;
import java.util.Optional;

// Spring Data JPA will create the table
@Service
public class DepartmentServiceImp implements DepartmentService {

//    Injects the repository layer that talks directly to the database.
//Spring auto-wires the bean for you behind the scenes.
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department=departmentRepository.findById(departmentId);
        if(!department.isPresent()){
            throw new DepartmentNotFoundException("Department not Available");
        }
        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department depDB=departmentRepository.findById(departmentId).get();
        if(Objects.nonNull(department.getDepartmentName()) && "".equalsIgnoreCase(department.getDepartmentName())){
            depDB.setDepartmentName(department.getDepartmentName());
        }
        if(Objects.nonNull(department.getDepartmentCode()) && "".equalsIgnoreCase(department.getDepartmentCode())){
            depDB.setDepartmentCode(department.getDepartmentCode());
        }
        if(Objects.nonNull(department.getDepartmentAddress()) && "".equalsIgnoreCase(department.getDepartmentAddress())){
            depDB.setDepartmentAddress(department.getDepartmentAddress());
        }
        return departmentRepository.save(depDB);
    }

//    No default method for this in the JPA repository.
    @Override
    public Department fetchDepartmentByName(String departmentName) {
//        So that the department is returned by its name regardless the case.
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }


}
