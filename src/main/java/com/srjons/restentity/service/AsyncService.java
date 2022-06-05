package com.srjons.restentity.service;

import com.srjons.restentity.entity.Employee;
import com.srjons.restentity.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

@Service
@EnableAsync
public class AsyncService {
  @Autowired private EmployeeRepository employeeRepository;

  @Async(value = "executorA")
  public void addEmp(Employee employee) {
    employeeRepository.save(employee);
  }
}
