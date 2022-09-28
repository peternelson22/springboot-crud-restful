package com.nelson.springboot1.service;

import com.nelson.springboot1.entity.Department;
import com.nelson.springboot1.exception.DepartmentNotFoundException;
import com.nelson.springboot1.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@AllArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long id) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepository.findById(id);

        if (!department.isPresent()) {
            throw new DepartmentNotFoundException("Not found");
        }
        return department.get();
    }

    @Override
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Department updateDepartment(Long id, Department department) {
        Department deptDB = departmentRepository.findById(id).get();
        if (Objects.nonNull(department.getName()) && !"".equalsIgnoreCase(department.getName())) {
            deptDB.setName(department.getName());
        }
        if (Objects.nonNull(department.getAddress()) && !"".equalsIgnoreCase(department.getAddress())) {
            deptDB.setAddress(department.getAddress());
        }
        if (Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
            deptDB.setDepartmentCode(department.getDepartmentCode());
        }
        return departmentRepository.save(deptDB);

    }

    @Override
    public Department fetchDepartmentByName(String name) {
        return departmentRepository.findByNameIgnoreCase(name);
    }
}
