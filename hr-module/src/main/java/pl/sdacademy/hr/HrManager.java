package pl.sdacademy.hr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HrManager {

	private List<Employee> allEmployees = new ArrayList<>();


	Employee create(String firstName, String lastName, String dateOfBirth) {

		Employee employee = new Employee(firstName, lastName, dateOfBirth);
		allEmployees.add(employee);
		return employee;
	}

	List<Employee> findAll() {
		return allEmployees;
	}


	/* public List<Employee> searchByLastName(String lastName) {
		for (Employee employee : allEmployees) {
			if (employee.getLastName().equals(lastName)) {
				return Arrays.asList(employee);
			}

		}
		return null;
	} */

		public List<Employee> searchByLastName(String lastName){
			List<Employee> foundEmployees = new ArrayList<>();
			for (Employee employee : allEmployees) {
				if (employee.getLastName().equals(lastName)) {
					foundEmployees.add(employee);
				}

			}
			return foundEmployees;

		}
	}

