package services;

import models.Analyst;
import models.Employee;
import models.Programmer;
import models.ProjectLeader;
import utilities.Utility;

import java.util.List;

public class DataOutput {
  public static void printDataEmployee(List<Employee> listData, String title) {
    int number = 1;
    String formatTabel = "| %-3s | %-12s | %-12s | %-8s | %-4s | %-19s | %-10s | %n";

    System.out.println("==========================================================================================");
    System.out.format("| %-86s |%n", title);
    System.out.println("==========================================================================================");
    System.out.printf(formatTabel, "No", "Employee ID", "Name", "Address", "Age", "Job Desc", "Placement");
    System.out.println("==========================================================================================");

//     iterates over the list
    for(Employee data: listData){
      System.out.format(formatTabel, number, data.getEmployeeID(), data.getName(), data.getAddress(), data.getAge(), data.getJobDesc(), data.getPlacement());
      number++;
    }
    System.out.println("==========================================================================================");
    System.out.format("| %-3s | %-80s |%n", 0, "Kembali Ke Main Menu");
    System.out.println("==========================================================================================");
  }

  public static void printDataPayroll(List<Employee> listData, String title) {
    int number = 1;
    String formatTabel = "| %-3s | %-12s | %-12s | %-19s | %-10s | %-12s | %-14s |%n";

    System.out.println("========================================================================================================");
    System.out.format("| %-100s |%n", title);
    System.out.println("========================================================================================================");
    System.out.printf(formatTabel, "No", "Employee ID", "Name", "Job Desc", "Placement", "Allowance", "Salary");
    System.out.println("========================================================================================================");

    for (Employee data : listData) {
      String allowance = "";

      if (data instanceof Programmer) {
        allowance = String.valueOf(((Programmer)data).getAllowance());
      }else if (data instanceof Analyst) {
        allowance = String.valueOf(((Analyst)data).getAllowance());
      } else if (data instanceof ProjectLeader) {
        allowance = String.valueOf(((ProjectLeader)data).getAllowance());
      } else {
        allowance = "-";
      }
      System.out.format(formatTabel, number, data.getEmployeeID(), data.getName(), data.getJobDesc(), data.getPlacement(), (allowance.length() > 1 ? Utility.formatCurency(Double.valueOf(allowance)) : allowance) , Utility.formatCurency(data.getSalary()));

      number++;
    }
    System.out.println("========================================================================================================");
    System.out.format("| %-3s | %-77s | %-14s |%n", number, "Total Payroll", Utility.formatCurency(DataProses.calculateTotalPayroll(listData)));
    System.out.println("========================================================================================================");
    System.out.format("| %-3s | %-94s |%n", 0, "Kembali Ke Main Menu");
    System.out.println("========================================================================================================");
  }

  public static void printMenu(String title, String[] listMenu) {
    int number = 1;
    String formatTabel = "| %-3s | %-48s |%n";
    System.out.println(title);
    System.out.println("==========================================================");
    System.out.printf(formatTabel, "No", "Menu");
    System.out.println("==========================================================");

    for (String menu : listMenu) {
      if (number == listMenu.length) {
        System.out.printf(formatTabel, 0, menu);
      }else {
        System.out.printf(formatTabel, number, menu);
      }
      number++;
    }
    System.out.println("==========================================================");
  }
}
