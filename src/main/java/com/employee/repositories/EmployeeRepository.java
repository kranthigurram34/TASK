package com.employee.repositories;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.employee.documents.Employee;


@Repository("empRepo")
@CrossOrigin(origins="http://localhost:4200")
public interface EmployeeRepository extends MongoRepository<Employee,UUID> {
	
	Employee findByEmpId(UUID Id);

}
