package nl.syntouch.api.beerservice.controller;

import nl.syntouch.api.beerservice.dto.EmployeeDto;
import nl.syntouch.api.beerservice.model.Employee;
import nl.syntouch.api.beerservice.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final ModelMapper modelMapper;

    public EmployeeController(EmployeeService employeeService, ModelMapper modelMapper) {
        this.employeeService = employeeService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<EmployeeDto> getEmployee() {
        return modelMapper.map(employeeService.getEmployee(), new TypeToken<List<EmployeeDto>>() {
        }.getType());
    }

    @PostMapping
    public void postEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
        employeeService.saveEmployee(modelMapper.map(employeeDto, Employee.class));
    }
}
