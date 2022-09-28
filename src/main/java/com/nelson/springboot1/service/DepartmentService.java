package com.nelson.springboot1.service;

import com.nelson.springboot1.entity.Department;
import com.nelson.springboot1.exception.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> fetchDepartment();

    Department getDepartmentById(Long id) throws DepartmentNotFoundException;

    void deleteDepartment(Long id);

    Department updateDepartment(Long id, Department department);

    Department fetchDepartmentByName(String name);
}
