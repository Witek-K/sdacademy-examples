package pl.sdacademy.hr;

import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.Test;

import javax.swing.table.DefaultTableModel;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class HrManagerSwingAdapterTest {

	@DisplayName("should add to empty table model new row matching employee created by HrManager given Adam " +
		"Miauczyński")

	@Test
	void test01() {

		//given

		// create empty table model

		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("First Name");
		tableModel.addColumn("Last Name");
		tableModel.addColumn("Date of Birth");
		HrManagerSwingAdapter adapter = new HrManagerSwingAdapter(fakeHrManager());

		//when

		adapter.addNewEmployee(tableModel, "Adam","Miauczyński","11-11-1988");

		//then

		Object firstNameFromTableModel = tableModel.getValueAt(0, 0);
		assertThat(firstNameFromTableModel).isEqualTo("Zoltan");
		Object lastNameFromTableModel = tableModel.getValueAt(0, 1);
		assertThat(lastNameFromTableModel).isEqualTo("Bloodhammer");
		Object dateOfBirth = tableModel.getValueAt(0, 2);
		assertThat(dateOfBirth).isEqualTo("11-01-1210");

	}

	private HrManager fakeHrManager() {

		return new HrManager() {

			@Override

			Employee create(String firstName, String lastName, String dateOfBirth) {

				if(firstName.equals("Adam") && lastName.equals("Miauczyński") && dateOfBirth.equals

					("11-11-1988"))

					return new Employee("Zoltan", "Bloodhammer", "11-01-1210");

				throw new IllegalArgumentException("Bad arguments");

			}

		};

	}

	@DisplayName("should add two rows to empty table model matching HrManager data")
	@Test
	void test02(){
		//given

		// create empty table model

		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("First Name");
		tableModel.addColumn("Last Name");
		tableModel.addColumn("Date of Birth");
		HrManagerSwingAdapter adapter = new HrManagerSwingAdapter(fakeSortHrManager());

		//when

		adapter.sortByLastName(tableModel);

		//then

		//row0
		Object firstNameFromTableModel = tableModel.getValueAt(0, 0);
		assertThat(firstNameFromTableModel).isEqualTo("Tomek");
		Object lastNameFromTableModel = tableModel.getValueAt(0, 1);
		assertThat(lastNameFromTableModel).isEqualTo("Lipa");
		Object dateOfBirth = tableModel.getValueAt(0, 2);
		assertThat(dateOfBirth).isEqualTo("06-02-1997");

		//row1
		Object firstNameFromTableModel2 = tableModel.getValueAt(0, 0);
		assertThat(firstNameFromTableModel2).isEqualTo("Roger");
		Object lastNameFromTableModel2 = tableModel.getValueAt(0, 1);
		assertThat(lastNameFromTableModel2).isEqualTo("Nowak");
		Object dateOfBirth2 = tableModel.getValueAt(0, 2);
		assertThat(dateOfBirth2).isEqualTo("08-11-1985");

	}

	private HrManager fakeSortHrManager(){
		return new HrManager(){
			@Override
			public List<Employee> sortByFirstNameWithBubble(){
				return Arrays.asList(new Employee("Tomek","Lipa", "06-02-1997"),
					new Employee("Roger", "Nowak", "08-11-1985"));
			}
		};
	}

}