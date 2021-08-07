package com.natymere.dockerspringbootapp.payroll;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    private final EmployeeRepository repository;

    public EmployeeController(EmployeeRepository repository){
        this.repository = repository;
    }

    @GetMapping("/employees")
    public List<Employee> all(){
      return repository.findAll();
    }

    @PostMapping("/employees")
    public Employee newEmployee(@RequestParam Employee newEmployee){
        return repository.save(newEmployee);
    }

    // Single item
    @GetMapping("/employees/{id}")
    public Employee one(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(()-> new EmployeeNotFoundException(id));
    }

    @PutMapping("/employees/{id}")
    public Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
        return repository.findById(id)
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setRole(newEmployee.getRole());
                    return repository.save(employee);
                })
                .orElseGet(()->{
                    newEmployee.setId(id);
                    return repository.save(newEmployee);
                });
    }

    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable Long id){
        repository.deleteById(id);
    }
}
