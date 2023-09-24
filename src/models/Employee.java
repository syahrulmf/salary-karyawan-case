package models;

import abstracts.Person;
import interfaces.IEmployee;
import interfaces.ISalary;
import utilities.Utility;

public class Employee extends Person implements ISalary, IEmployee {
  private String employeeID;
  private double salary;
  private String jobDesc;
  private String placement;

  public Employee() {
  }

  public Employee(String name, String address, int age, double salary, String jobDesc, String placement) {
    super(name, address, age);
    this.salary = salary;
    this.jobDesc = jobDesc;
    this.placement = placement;

    setEmployeeID(Utility.getUniqueID("Emp-", "Employee"));
    calculateSalary();
  }

  @Override
  public void calculateSalary() {
    int umk = UMK_BERDASARKAN_KOTA.get(getPlacement().toUpperCase());
    double salary = umk * EMPLOYEE_SALARY_PERCENTAGE;

    setSalary(salary);
  }

  public String getEmployeeID() {
    return employeeID;
  }

  public void setEmployeeID(String employeeID) {
    this.employeeID = employeeID;
  }

  public double getSalary() {
    return salary;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

  public String getJobDesc() {
    return jobDesc;
  }

  public void setJobDesc(String jobDesc) {
    this.jobDesc = jobDesc;
  }

  public String getPlacement() {
    return placement;
  }

  public void setPlacement(String placement) {
    this.placement = placement;
  }
}
