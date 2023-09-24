package interfaces;

import java.util.HashMap;

public interface IEmployee {
  HashMap<String, Integer> UMK_BERDASARKAN_KOTA = new HashMap<>(){{
    put("GARUT", 1961085);
    put("BANDUNG", 3742276);
    put("JAKARTA", 4453935);
    put("BEKASI", 4782935);
    put("BOGOR", 4330249);
  }};

  double EMPLOYEE_SALARY_PERCENTAGE = 1;
  double PROGRAMMER_SALARY_PERCENTAGE = 1.5;
  double PROJECT_LEADER_SALARY_PERCENTAGE = 2;
  double ANALYST_SALARY_PERCENTAGE = 1.6;
}
