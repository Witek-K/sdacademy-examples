package pl.sdacademy.hr;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CommandLineRunnerTest {

	@DisplayName("should reject input data when only firstname is empty")
	@Test
	void test00(){
		//given
		HrManager hrManager = new HrManager();
		String[] args = {"lastName=Miauczyński","dateOfBirth=23-09-2000","anything"};
		CommandLineRunner clr = new CommandLineRunner();

		// when
		assertThatThrownBy(() -> CommandLineRunner.load(args, hrManager))

			// then
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("should check if 3 arguments: firstname, lastname and dateofbirth is given then database isn't " +
		"empty")
	@Test
	void test01() {
		//given
		HrManager hrManager = new HrManager();
		String[] args = {"firstName=Adam", "lastName=Miauczyński", "dateOfBirth=23-09-2000"};
		//when
		CommandLineRunner.load(args,
			hrManager);
		//then
		assertThat(hrManager.findAll()).isNotEmpty();
	}

	@DisplayName("should reject input data when only laststname is empty")
	@Test
	void test02(){
		//given
		HrManager hrManager = new HrManager();
		String[] args = {"firstName=Adam","dateOfBirth=23-09-2000","anything"};
		CommandLineRunner clr = new CommandLineRunner();

		// when
		assertThatThrownBy(() -> CommandLineRunner.load(args, hrManager))

			// then
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("should reject input data when only dateOfBirth is empty")
	@Test
	void test03(){
		//given
		HrManager hrManager = new HrManager();
		String[] args = {"firstName=Adam","lastName=Miauczyński","anything"};
		//CommandLineRunner clr = new CommandLineRunner();

		// when
		assertThatThrownBy(() -> CommandLineRunner.load(args, hrManager))

			// then
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("should check if firstName, lastName and dateOfBirth isn't empty then database contains single " +
		"single employee with the same name ")
	@Test
	void test04(){
		//given
		HrManager hrManager = new HrManager();
		String[] args = {"firstName=Adam", "lastName=Miauczyński", "dateOfBirth=23-09-2000"};
		//when
		CommandLineRunner.load(args,hrManager);
		//then
		Employee employee = hrManager.findAll().get(0);
		assertThat(employee.getFirstName()).isEqualTo("Adam");
		assertThat(employee.getLastName()).isEqualTo("Miauczyński");
		assertThat(employee.getDateOfBirth()).isEqualTo("23-09-2000");
	}

	@DisplayName("should return list of text representation of all Employees from database")
	@Test
	void test05(){
		//given
		HrManager hrManager = new HrManager();
		String[] args = {"firstName=Adam", "lastName=Miauczyński", "dateOfBirth=23-09-2000"};
		CommandLineRunner.load(args,hrManager);
		//when
		List<String> allEmployees = CommandLineRunner.list(hrManager);
		//then
		assertThat(allEmployees).containsOnly("Adam Miauczyński 23-09-2000");
	}



}
