package models;

import abstracts.AllowanceEmployee;
import utilities.Utility;

public class Analyst extends AllowanceEmployee {
  public Analyst() {
  }

  public Analyst(String name, String address, int age, double salary, String jobDesc, String placement, double allowance) {
    super(name, address, age, salary, jobDesc, placement, allowance);

    setEmployeeID(Utility.getUniqueID("AL-", "Analyst"));
    calculateSalary();
    calculateAllowance();
  }

  @Override
  public void calculateAllowance() {
    double allowance = getSalary() * 0.05;

    setAllowance(allowance);

  }

  @Override
  public void calculateSalary() {
    int umk = UMK_BERDASARKAN_KOTA.get(getPlacement().toUpperCase());
    double salary = umk * ANALYST_SALARY_PERCENTAGE;

    setSalary(salary);
  }
}
