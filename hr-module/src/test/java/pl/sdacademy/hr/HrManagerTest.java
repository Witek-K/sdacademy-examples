package pl.sdacademy.hr;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class HrManagerTest {

	private HrManager hrManager = new HrManager();

	@DisplayName("should create non-null  new employeeList and find when name, surname and birthday is given")
	@Test
	void test0 (){
		// given
		String firstName = "Adam";
		String lastName = "Miauczynski";
		String dateOfBirth = "01-12-1960";


		// when
		Employee employee = hrManager.create(firstName,lastName,dateOfBirth);

		//then
		assertThat(employee).isNotNull();
	}

	@DisplayName("should create new employee with all fields: name, surname and birthday")
	@Test
	void test1 (){
		// given
		String firstName = "Adam";
		String lastName = "Miauczynski";
		String dateOfBirth = "01-12-1960";


		// when
		Employee employee = hrManager.create(firstName,lastName,dateOfBirth);

		//then
		assertThat(employee.getFirstName()).isEqualTo(firstName);
		assertThat(employee.getLastName()).isEqualTo(lastName);
		assertThat(employee.getDateOfBirth()).isEqualTo(dateOfBirth);
	}

	@DisplayName("should check if new Employee is added to the database")
	@Test
	void test2 (){
		// given
		String firstName = "Adam";
		String lastName = "Miauczynski";
		String dateOfBirth = "01-12-1960";
		Employee newEmployee = hrManager.create(firstName,lastName,dateOfBirth);
		// when
		List<Employee> allEmployees = hrManager.findAll();
		//then
		assertThat(allEmployees).containsOnly(newEmployee);
	}

	@DisplayName("should check if two new Employee are added to the database")
	@Test
	void test3 (){
		// given
		HrManager hrManager = new HrManager();
		Employee adam = hrManager.create("Adam","Miauczynski", "01-12-1960");
		Employee jurgen = hrManager.create("Jurgen","Muller", "13-12-1660");
		// when
		List<Employee> allEmployees = hrManager.findAll();
		//then
		assertThat(allEmployees).containsOnly(adam, jurgen);
	}

	@DisplayName("should find single employee with given last name ")
	@Test
	void test4() {
		//given
		Employee adam = hrManager.create("Adam","Miauczynski", "01-12-1960");
		Employee jurgen = hrManager.create("Jurgen","Muller", "13-12-1660");
		//Employee sztefan = hrManager.create("Sztefan", "Muller", "11-10-1971");
		//when
		List<Employee> foundEmployees = hrManager.searchByLastName("Miauczynski");
		//then
		assertThat(foundEmployees).containsOnly(adam);
	}

	@DisplayName("should find s employee with given last name ")
	@Test
	void test5() {
		//given
		Employee adam = hrManager.create("Adam","Miauczynski", "01-12-1960");
		Employee jurgen = hrManager.create("Jurgen","Muller", "13-12-1660");
		Employee sztefan = hrManager.create("Sztefan", "Miauczynski", "11-10-1971");
		//when
		List<Employee> foundEmployees = hrManager.searchByLastName("Miauczynski");
		//then
		assertThat(foundEmployees).containsOnly(adam, sztefan);
	}

	@DisplayName("should find no employee when there is no employee with given last name ")
	@Test
	void test6() {
		//given
		Employee adam = hrManager.create("Adam","Miauczynski", "01-12-1960");
		Employee jurgen = hrManager.create("Jurgen","Muller", "13-12-1660");
		Employee sztefan = hrManager.create("Sztefan", "Miauczynski", "11-10-1971");
		//when
		List<Employee> foundEmployees = hrManager.searchByLastName("Nowak");
		//then
		assertThat(foundEmployees).isEmpty();
	}

	@DisplayName("Should find two employees when firstName matches given search phrase")
	@Test
	void test7() {
		//given
		Employee adam = hrManager.create("Adam","Miauczynski", "01-12-1960");
		Employee jurgenMuller = hrManager.create("Jurgen","Muller", "13-12-1660");
		Employee jurgenBlitz = hrManager.create("Jurgen","Blitz", "13-12-1660");
		//when
		List<Employee> foundEmployees = hrManager.searchByPhrase("Jurgen");
		//then
		assertThat(foundEmployees).containsOnly(jurgenMuller, jurgenBlitz);
	}

	@DisplayName("Should find two employees when lastName matches given search phrase")
	@Test
	void test8() {
		//given
		Employee adam = hrManager.create("Adam","Miauczynski", "01-12-1960");
		Employee jurgenBlitz = hrManager.create("Jurgen","Blitz", "13-12-1660");
		Employee sztefan = hrManager.create("Sztefan", "Miauczynski", "11-10-1971");
		//when
		List<Employee> foundEmployees = hrManager.searchByPhrase("Miauczynski");
		//then
		assertThat(foundEmployees).containsOnly(adam,sztefan);
	}

	@DisplayName("Should find two employees when birthDate matches given search phrase")
	@Test
	void test9() {
		//given
		Employee adam = hrManager.create("Adam","Miauczynski", "01-12-1960");
		Employee jurgenBlitz = hrManager.create("Jurgen","Blitz", "13-12-1660");
		Employee sztefan = hrManager.create("Sztefan", "Miauczynski", "13-12-1660");
		//when
		List<Employee> foundEmployees = hrManager.searchByPhrase("13-12-1660");
		//then
		assertThat(foundEmployees).containsOnly(jurgenBlitz,sztefan);
	}

	@DisplayName("Should sort by firstName ascending")
	@Test
	void test10() {
		//given
		Employee adam = hrManager.create("Adam","Miauczynski", "01-12-1960");
		Employee jurgenblitz = hrManager.create("Jurgen","Blitz", "13-12-1660");
		Employee zenon = hrManager.create("Zenon","Miauczynski", "01-12-1968");
		//when
		List<Employee> sortEmployees = hrManager.searchByFirstName();
		//then
		assertThat(sortEmployees).containsExactly(adam,jurgenblitz,zenon);
	}

}