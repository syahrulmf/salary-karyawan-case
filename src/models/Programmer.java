package models;

import abstracts.AllowanceEmployee;
import utilities.Utility;

public class Programmer extends AllowanceEmployee {
  private String programmingLanguage;
  private int experiences;

  public Programmer() {
  }

  public Programmer(String name, String address, int age, double salary, String jobDesc, String placement, double allowance, String programmingLanguage, int experiences) {
    super(name, address, age, salary, jobDesc, placement, allowance);
    this.programmingLanguage = programmingLanguage;
    this.experiences = experiences;

    setEmployeeID(Utility.getUniqueID("Prog-", "Programmer"));
    calculateSalary();
    calculateAllowance();
  }

  @Override
  public void calculateAllowance() {
    double allowance = 0;

    if (getExperiences() > 4) {
      allowance = getSalary() * 0.2;
    } else if (getExperiences() < 5) {
      allowance = getSalary() * 0.1;
    }

    setAllowance(allowance);
  }

  @Override
  public void calculateSalary() {
    int umk = UMK_BERDASARKAN_KOTA.get(getPlacement().toUpperCase());
    double salary = umk * PROGRAMMER_SALARY_PERCENTAGE;

    setSalary(salary);
  }

  public String getProgrammingLanguage() {
    return programmingLanguage;
  }

  public void setProgrammingLanguage(String programmingLanguage) {
    this.programmingLanguage = programmingLanguage;
  }

  public int getExperiences() {
    return experiences;
  }

  public void setExperiences(int experiences) {
    this.experiences = experiences;
  }
}
