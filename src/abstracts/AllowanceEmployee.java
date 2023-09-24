package abstracts;

import interfaces.IAllowance;
import models.Employee;

public abstract class AllowanceEmployee extends Employee implements IAllowance {
  private double allowance;

  public AllowanceEmployee() {
  }

  public AllowanceEmployee(String name, String address, int age, double salary, String jobDesc, String placement, double allowance) {
    super(name, address, age, salary, jobDesc, placement);
    this.allowance = allowance;
  }

  @Override
  public void calculateAllowance() {

  }

  public double getAllowance() {
    return allowance;
  }

  public void setAllowance(double allowance) {
    this.allowance = allowance;
  }
}
