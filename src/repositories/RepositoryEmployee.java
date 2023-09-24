package repositories;

import models.Analyst;
import models.Employee;
import models.Programmer;
import models.ProjectLeader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepositoryEmployee {
  public static List<Employee> getAllEmployee() {
    // Employee
    Employee employee1 = new Employee("Susi", "Bandung", 27, 0, "Admin", "Jakarta");
    Employee employee2 = new Employee("Anto", "Bandung", 35, 0, "Office Boy", "Bandung");
    Employee employee3 = new Employee("Riman", "Jakarta", 28, 0, "Human Resource Dev", "Bandung");

    // Programmer
    Programmer programmer1 = new Programmer("Budi", "Bandung", 25, 0, "Back End Dev", "Jakarta", 0, "Java", 2);
    Programmer programmer2 = new Programmer("Ani", "Bandung", 30, 0, "Front End Dev", "Bandung", 0, "React JS", 6);
    Programmer programmer3 = new Programmer("Ujang", "Jakarta", 28, 0, "Fullstack Dev", "Bandung", 0, "Kotlin", 4);

    // Analyst
    Analyst analyst1 = new Analyst("Indah", "Garut", 25, 0, "Analyst", "Jakarta", 0);
    Analyst analyst2 = new Analyst("Puspa", "Bandung", 30, 0, "Analyst", "Bekasi", 0);
    Analyst analyst3 = new Analyst("Sari", "Jakarta", 28, 0, "Analyst", "Bogor", 0);

    // Project Leader
    ProjectLeader projectLeader1 = new ProjectLeader("Ahmad", "Bandung", 25, 0, "Project Leader", "Garut", 0, 2);
    ProjectLeader projectLeader2 = new ProjectLeader("Dani", "Bandung", 30, 0, "Scrum Master", "Bekasi", 0, 1);
    ProjectLeader projectLeader3 = new ProjectLeader("Cecep", "Jakarta", 28, 0, "Project Owner", "Bogor", 0, 4);

    List<Employee> listEmployee = new ArrayList<>(Arrays.asList(employee1, employee2, employee3, programmer1, programmer2, programmer3, analyst1, analyst2, analyst3, projectLeader1, projectLeader2, projectLeader3));

    return listEmployee;
  }
}
