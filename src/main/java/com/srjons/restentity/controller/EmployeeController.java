package com.srjons.restentity.controller;

import com.srjons.restentity.entity.Employee;
import com.srjons.restentity.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

  @Autowired private EmployeeService employeeService;

  @PostMapping(
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public Employee addTemplate(@RequestBody Employee employee) {
    return employeeService.addEmployee(employee);
  }

  @GetMapping(value = "/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Employee getEmployeeById(@PathVariable("employeeId") int employeeId) {
    return employeeService.getEmployeeById(employeeId);
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Employee> getEmployeeList() {
    return employeeService.getEmployeeList();
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/asyncLoad/{count}")
  public String loadEmployeeList(@PathVariable("count") int count) {
    employeeService.addEmp(count);
    return "Request submitted";
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/asyncLoad2/{count}")
  public String loadEmployeeList2(@PathVariable("count") int count) {
    employeeService.addEmp2(count);
    return "Request submitted";
  }


  @DeleteMapping("/{employeeId}")
  public ResponseEntity<String> deleteEmployeeById(@PathVariable("employeeId") int employeeId) {
    boolean isDeleted = employeeService.deleteEmployeeById(employeeId);
    if (isDeleted) {
      return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Employee deleted");
    } else {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Employee not deleted");
    }
  }
}
