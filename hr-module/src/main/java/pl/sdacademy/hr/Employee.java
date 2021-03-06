package pl.sdacademy.hr;

import java.util.stream.Stream;

class Employee implements Comparable<Employee>{
  private final String firstName;
  private final String lastName;
  private final String dateOfBirth;

  public Employee(String firstName, String lastName, String dateOfBirth) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.dateOfBirth = dateOfBirth;

      }

  public String getFirstName() {
   return firstName;
  }

  public String getLastName() {
   return lastName;
  }
  public String getDateOfBirth() {
   return dateOfBirth;


  }
  @Override
  public String toString() {
   return firstName + " " + lastName + " " + dateOfBirth;
  }


	 public boolean matches(String phrase) {
                return  firstName.contains(phrase)||
                        lastName.contains(phrase)||
                        dateOfBirth.contains(phrase);
	 }

        @Override
        public int compareTo(Employee other) {
                return firstName.compareTo(other.firstName);
        }
}
