package services;

import jdk.jshell.execution.Util;
import models.Analyst;
import models.Employee;
import models.Programmer;
import models.ProjectLeader;
import repositories.RepositoryEmployee;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProses {
  public static List<Employee> listDataEmployee = RepositoryEmployee.getAllEmployee();

  public static List<Employee> getAllDataByPlacement(String placement) {
    List<Employee> listEmployee = new ArrayList<Employee>();

    for (Employee data : listDataEmployee) {
      if (data.getPlacement().toLowerCase().contains(placement.toLowerCase())) {
        listEmployee.add(data);
      }
    }

    return listEmployee;
  }

  public static void addEmployee(String jabatan, String name, String address, int age, String jobDesc, String placement) {
    String result = "";

    if (jabatan.equalsIgnoreCase("Employee")) {
      listDataEmployee.add(new Employee(name, address, age, 0, jobDesc, placement));
      result = "Add Data Employee Success!";

    } else if (jabatan.equalsIgnoreCase("Programmer")) {
      String programmingLanguage = Utility.validateInput("Masukan Programming Language : ", "Inputan harus berupa String!", Utility.regexHuruf);
      int experiences = Utility.validateNumberWithRange("Masukan Lama Experience : ", "Inputan harus berupa number positif!", Utility.regexNumber, 99, 0);
      listDataEmployee.add(new Programmer(name, address, age, 0, jobDesc, placement, 0, programmingLanguage, experiences));
      result = "Add Data Programmer Success!";

    } else if (jabatan.equalsIgnoreCase("Analyst")) {
      listDataEmployee.add(new Analyst(name, address, age, 0, jobDesc, placement, 0));
      result = "Add Data Analyst Success!";

    } else if (jabatan.equalsIgnoreCase("Project Leader")) {
      int totalProject = Utility.validateNumberWithRange("Masukan Total Project : ", "Inputan harus berupa number positif!", Utility.regexNumber, 99, 0);
      listDataEmployee.add(new ProjectLeader(name, address, age, 0, jobDesc, placement, 0, totalProject));
      result = "Add Data Project Leader Success!";

    } else {
      result = "Add Data Failed! Make sure your input is valid!";
    }

    System.out.println("\n" + result + "\n");
  }

  public static Employee getDataEmployeeByID(String employeeID) {
    Employee dataEmployee = new Employee();

    for (Employee data : listDataEmployee) {
      if (data.getEmployeeID().equalsIgnoreCase(employeeID)) {
        dataEmployee = data;
      }
    }

    return dataEmployee;
  }

  public static void editDataEmployee(String employeeID, String placement) {
    Employee employee = getDataEmployeeByID(employeeID);
    String result = "";

    if (employee.getEmployeeID() != null) {
      // set new placement
      employee.setPlacement(placement);

      //check instance
      if (employee instanceof Programmer) {
        employee.calculateSalary();
        ((Programmer)employee).calculateAllowance();
      } else if (employee instanceof Analyst) {
        employee.calculateSalary();
        ((Analyst)employee).calculateAllowance();
      } else if (employee instanceof ProjectLeader) {
        employee.calculateSalary();
        ((ProjectLeader)employee).calculateAllowance();
      } else {
        employee.calculateSalary();
      }

      result = "Edit Seccess...";
    } else {
      result = "Edit Failed! Make sure input Employee ID is valid.";
    }

    System.out.println("\n" + result + "\n");
  }

  public static void deleteDataEmployee(String employeeID) {
    Employee dataEmployee = getDataEmployeeByID(employeeID);
    String result = "";

    if (dataEmployee.getEmployeeID() != null) {
      listDataEmployee.removeIf(data -> data.getEmployeeID().contains(dataEmployee.getEmployeeID()));

      result = "Delete Data Success!";
    } else {
      result = "Delete Failed! Make sure input Employee ID is valid.";
    }

    System.out.println("\n" + result + "\n");
  }
}
