package actions;

import interfaces.IMenu;
import services.DataOutput;
import services.DataProses;
import utilities.Utility;

public class MenuAction implements IMenu {
  public static void showMainMenu() {
    boolean isLooping = true;

    do {
      DataOutput.printMenu("Main Menu" ,MAIN_MENU);

      int pilih = Utility.validateNumberWithRange("Pilih Menu : ", "Inputan harus berupa angka 0-6!", Utility.regexNumber, 6, 0);

      switch (pilih) {
        case 1:
          DataOutput.printDataEmployee(DataProses.listDataEmployee, "Menu Add Employee : List Data Employee");
          String jabatan = Utility.validateInput("Masukan Jabatan Karyawan (Employee/Programmer/Analyst/Project Leader): ", "Jabatan tidak terdaftar!", Utility.regexJabatan);
          String name = Utility.validateInput("Masukan Nama Karyawan : ", "Inputan harus berupa string!", Utility.regexHuruf);
          String address = Utility.validateInput("Masukan Alamat Karyawan : ", "Inputan harus berupa string!", Utility.regexHuruf);
          int age = Utility.validateNumberWithRange("Masukan Umur Karyawan : ", "Inputan harus number positif!", Utility.regexNumber, 99, 1);
          String jobDesc = Utility.validateInput("Masukan Jobdesc Karyawan : ", "Inputan harus berupa string!", Utility.regexHuruf);
          String placementQuery = Utility.validateInput("Masukan Placement Karyawan (Garut/Bandung/Jakarta/Bekasi/Bogor): ", "Placement tidak valid!", Utility.regexPlacement);

          DataProses.addEmployee(jabatan, name, address, age, jobDesc, placementQuery);

          isLooping = Utility.confirmMenu("Press 0 for Back To Main Menu: ");
          break;

        case 2:
          DataOutput.printDataEmployee(DataProses.listDataEmployee, "Menu Edit Employee : List Data Employee");
          String employeeID = Utility.validateInput("Masukan Employee ID yang Akan Diubah : ", "Employee ID Tidak Valid!", Utility.regexID);
          String placement = Utility.validateInput("Masukan Placement Karyawan yang Baru (Garut/Bandung/Jakarta/Bekasi/Bogor): ", "Placement Karyawan tidak sesuai!", Utility.regexPlacement);
          DataProses.editDataEmployee(employeeID, placement);
          isLooping = Utility.confirmMenu("Press 0 for Back To Main Menu: ");
          break;

        case 3:
          DataOutput.printDataEmployee(DataProses.listDataEmployee, "List Data Employee");
          isLooping = Utility.confirmMenu("Press 0 for Back To Main Menu: ");
          break;

        case 4:
          DataOutput.printDataPayroll(DataProses.listDataEmployee, "List Data Payroll");
          isLooping = Utility.confirmMenu("Press 0 for Back To Main Menu: ");
          break;

        case 5:
          DataOutput.printDataEmployee(DataProses.listDataEmployee, "Menu Delete Employee : List Data Employee");
          String queryEmployeeID = Utility.validateInput("Masukan Employee ID yang Akan Dihapus : ", "Employee ID Tidak Valid!", Utility.regexID);
          DataProses.deleteDataEmployee(queryEmployeeID);
          isLooping = Utility.confirmMenu("Press 0 for Back To Main Menu: ");
          break;

        case 6:
          showMenuSearching();
          break;

        case 0:
          isLooping = false;
          break;

        default:
          System.out.println("\nPilihan tidak dimengerti!\n");
      }
    } while(isLooping);

    System.out.println("\nAplikasi Berhenti...\n");
  }

  public static void showMenuSearching() {
    boolean isLooping = true;

    do {
      DataOutput.printMenu("Searching Data Karyawan" ,MENU_SEARCHING);

      int pilih = Utility.validateNumberWithRange("Pilih Menu : ", "Inputan harus berupa angka 1 dan 0!", Utility.regexNumber, 1, 0);

      switch (pilih) {
        case 1:
          String queryPlacement = Utility.validateInput("Masukan Kota Penempatan Karyawan (Garut/Bandung/Jakarta/Bekasi/Bogor): ", "Placement tidak valid!", Utility.regexPlacement);
          DataOutput.printDataEmployee(DataProses.getAllDataByPlacement(queryPlacement), "Data Employee Berdasarkan Placement " + queryPlacement);
          isLooping = Utility.confirmMenu("Press 0 for Back To Menu: ");
          break;

        case 0:
          isLooping = false;
          break;

        default:
          System.out.println("\nPilihan tidak dimengerti!\n");
      }
    } while(isLooping);
  }
}
