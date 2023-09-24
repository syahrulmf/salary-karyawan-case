package utilities;

import java.text.DecimalFormat;

public class Utility {
  public static java.util.Scanner scanner = new java.util.Scanner(System.in);
  public static int numberEmployee = 1;
  public static int numberProgrammer = 1;
  public static int numberProjectLeader = 1;
  public static int numberAnalyst = 1;
  public static String regexNumber = "^[0-9]+$";
  public static String regexHuruf = "^[a-zA-Z ]+$";
  public static String regexID = "^[A-Za-z0-9\\-]+$";
  public static String regexPlacement = "^(?i)(Garut|Bandung|Jakarta|Bekasi|Bogor)$";
  public static String regexJabatan = "^(?i)(Employee|Programmer|Analyst|Project Leader)$";

  public static String validateInput(String question, String errorMessage, String regex) {
    String result;
    boolean isLooping = true;
    do {
      System.out.print(question);
      result = scanner.nextLine();

      if (result.matches(regex)) {
        isLooping = false;
      }else {
        System.out.println(errorMessage);
      }
    } while (isLooping);

    return result;
  }

  public static int validateNumberWithRange(String question, String errorMessage, String regex, int max, int min) {
    int result;
    boolean isLooping = true;

    do {
      result = Integer.valueOf(validateInput(question, errorMessage, regex));
      if (result >= min && result <= max) {
        isLooping = false;
      }else {
        System.out.println(errorMessage);
      }
    } while (isLooping);

    return result;
  }

  public static boolean confirmMenu(String question) {
    boolean isLooping = false;

    var pilihan = validateNumberWithRange(question, "Hanya menerima inputan angka 0!", regexNumber, 0, 0);
    if (pilihan == 0) {
      isLooping = true;
    }

    return isLooping;
  }

  public static String formatNumber(int number) {
    if (number < 10) {
      return "00" + number;
    } else if (number < 100) {
      return "0" + number;
    } else {
      return Integer.toString(number);
    }
  }

  public static String getUniqueID(String format, String employeeType) {
    String numberFormat = "";
    if (employeeType.equalsIgnoreCase("Employee")) {
      numberFormat = formatNumber(numberEmployee);
      numberEmployee++;
    } else if (employeeType.equalsIgnoreCase("Programmer")) {
      numberFormat = formatNumber(numberProgrammer);
      numberProgrammer++;
    } else if (employeeType.equalsIgnoreCase("Project Leader")) {
      numberFormat = formatNumber(numberProjectLeader);
      numberProjectLeader++;
    } else if (employeeType.equalsIgnoreCase("Analyst")) {
      numberFormat = formatNumber(numberAnalyst);
      numberAnalyst++;
    }

    return format + numberFormat;
  }

  public static String formatCurency(double number) {
    DecimalFormat df = new DecimalFormat("#,###.00");

    return df.format(number);
  }

}
