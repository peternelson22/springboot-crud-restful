package com.nelson.springboot1.service;

import com.nelson.springboot1.entity.Department;
import com.nelson.springboot1.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .name("It")
                .address("Benin")
                .departmentCode("It-20")
                .id(1L)
                .build();
        Mockito.when(departmentRepository.findByNameIgnoreCase("It")).thenReturn(department);
    }

    @Test
    public void whenValidDepartName_thenDepartmentShouldShow() {
        String name = "It";
        Department found = departmentService.fetchDepartmentByName(name);

        assertEquals(name, found.getName());
    }
}