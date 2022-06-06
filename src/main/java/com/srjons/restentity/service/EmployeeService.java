package com.srjons.restentity.service;

import com.srjons.restentity.entity.Employee;
import com.srjons.restentity.repository.EmployeeRepository;
import com.srjons.restentity.utils.AppUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.IntStream;

@Service
@Slf4j
public class EmployeeService {

  @Autowired private EmployeeRepository employeeRepository;
  @Autowired private AsyncService asyncService;

  public void addEmp(int count) {
    IntStream.range(1, count + 1)
        .forEach(
            value -> {
              Employee employee = new Employee();
              employee.setEmployeeName(UUID.randomUUID().toString());
              asyncService.addEmp(employee);
            });
  }

  public Employee addEmployee(Employee employee) {
    Employee savedEmployee = new Employee();
    try {
      Employee entity = employeeRepository.save(employee);
      savedEmployee.setEmployeeId(entity.getEmployeeId());
    } catch (Exception e) {
      e.printStackTrace();
    }
    return savedEmployee;
  }

  public Employee getEmployeeById(int employeeId) {
    Employee employee = null;
    try {
      employee = employeeRepository.findById(employeeId).get();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return employee;
  }

  public List<Employee> getEmployeeList() {
    return employeeRepository.findAll();
  }

  public boolean updateProductById(int id, Employee employee) {
    boolean isUpdated = false;
    try {
      employee.setEmployeeId(id);
      Optional<Employee> byId = employeeRepository.findById(id);
      Employee existingEmployee = null;
      if (byId.isPresent()) {
        existingEmployee = byId.get();
        BeanUtils.copyProperties(
            employee, existingEmployee, AppUtil.getNullPropertyNames(employee));
        employeeRepository.save(existingEmployee);
        isUpdated = true;
      }
    } catch (Exception e) {
      log.error("error updating product. error = " + e.getMessage());
      e.printStackTrace();
    }
    return isUpdated;
  }

  public boolean deleteEmployeeById(int employeeId) {
    boolean isDeleted = false;
    try {
      employeeRepository.deleteById(employeeId);
      isDeleted = true;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return isDeleted;
  }

  public void addEmp2(int count) {
    IntStream.range(1, count + 1)
        .forEach(
            value -> {
              Employee employee = new Employee();
              employee.setEmployeeName(UUID.randomUUID().toString());
              asyncService.addEmp2(employee);
            });
  }
}
