package models;

import abstracts.AllowanceEmployee;
import utilities.Utility;

public class ProjectLeader extends AllowanceEmployee {
  private int totalProject;

  public ProjectLeader() {
  }

  public ProjectLeader(String name, String address, int age, double salary, String jobDesc, String placement, double allowance, int totalProject) {
    super(name, address, age, salary, jobDesc, placement, allowance);
    this.totalProject = totalProject;

    setEmployeeID(Utility.getUniqueID("PL-", "Project Leader"));
    calculateSalary();
    calculateAllowance();
  }

  @Override
  public void calculateAllowance() {
    double allowance = 0;

    if (getTotalProject() >= 2) {
      allowance = getSalary() * 0.15;
    } else if (getTotalProject() < 2 && getTotalProject() >= 0) {
      allowance = getSalary() * 0.05;
    }

    setAllowance(allowance);
  }

  @Override
  public void calculateSalary() {
    int umk = UMK_BERDASARKAN_KOTA.get(getPlacement().toUpperCase());
    double salary = umk * PROJECT_LEADER_SALARY_PERCENTAGE;

    setSalary(salary);
  }

  public int getTotalProject() {
    return totalProject;
  }

  public void setTotalProject(int totalProject) {
    this.totalProject = totalProject;
  }
}
