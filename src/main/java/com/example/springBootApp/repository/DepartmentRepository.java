package com.example.springBootApp.repository;

import com.example.springBootApp.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

// Will extend the JPA repository for this interface.
// No concrete implementation

// Long is the primary key type.

//The @Query annotation in Spring Data JPA is used to define custom queries directly within repository interface methods. It allows developers to specify
// JPQL (Java Persistence Query Language) or native SQL queries, offering flexibility beyond the derived query methods provided by Spring Data JPA.
@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long>
{
    public Department findByDepartmentName(String departmentName);
    public Department findByDepartmentNameIgnoreCase(String departmentName);
}

//The JPA Repository is part of Spring Data JPA. It provides a layer
// of abstraction over the database and allows you to perform CRUD operations
// (Create, Read, Update, Delete) without writing SQL or boilerplate code.