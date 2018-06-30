package pl.sdacademy.hr;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class HrManagerSwingAdapter {

	private HrManager hrManager;

	public HrManagerSwingAdapter(HrManager hrManager) {
		this.hrManager = hrManager;

	}

	public void addNewEmployee(DefaultTableModel tableModel, String firstName, String lastName, String
		dateOfBirth){
		Employee newEmployee = hrManager.create(firstName, lastName, dateOfBirth);
		tableModel.addRow(new Object[]{newEmployee.getFirstName(), newEmployee.getLastName(), newEmployee.getDateOfBirth()});

	}

	private void addRow(DefaultTableModel tableModel, Employee newEmployee){
		tableModel.addRow(new Object[]{newEmployee.getFirstName(),newEmployee.getLastName(),newEmployee
			.getDateOfBirth()});
	}

	public void sortByLastName(DefaultTableModel tableModel) {
		tableModel.getDataVector().clear();
		List<Employee> sortEmployees = hrManager.sortByFirstNameWithBubble();
		for (Employee employee: sortEmployees){
			addRow(tableModel, employee);
		}
	}
}