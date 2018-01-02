import java.util.Scanner;

public class Calendar {

  private final int[] maxDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

  public boolean isLeapYear(int year){
    if(year%4 == 0 && (year%100 != 0 || year%400 == 0)){
      return true;
    }
    return false;
  }

  public int maxDaysOfMonth(int year, int month){
    if(isLeapYear(year) && month == 2){
      return 29;
    }
    return maxDays[month - 1];
  }
  void printCalendar(int year, int month){
    int maxDays = maxDaysOfMonth(year, month);
    int first = getFirstDayOfMonth();
    System.out.printf("        <<%4d년 %3d월>>\n", year, month);
    System.out.println("  일  월  화  수  목  금  토");
    System.out.println("============================");
    if(first != 7){
      for(int i=0; i<first; i++){
        System.out.print("    ");
      }
    }
    for(int i=1; i<=maxDays; i++){
      if((i%7) + first == 7)
        System.out.printf("  %2d\n", i);
      else
        System.out.printf("  %2d", i);
    }
    System.out.println("");
  }

  public int getFirstDayOfMonth(){
    int i = 0;
    /*
    switch (firstDay){
      case "월": i = 1;
                 break;
      case "화": i = 2;
                 break;
      case "수": i = 3;
                 break;
      case "목": i = 4;
                break;
      case "금": i = 5;
                break;
      case "토": i = 6;
                break;
      case "일": i = 7;
                break;
      default: i = -1;
                break;
    }
    */
    return i;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Calendar calendar = new Calendar();
    int month = -1;
    int year = 0;
    while(true){
      System.out.println("년도와 달을 입력하세요. (종료: -1)");
      System.out.print("년도>");
      if((year = scanner.nextInt()) == -1)
        break;
      System.out.print("달>");
      if((month = scanner.nextInt()) == -1)
        break;
      if(month > 12)
        continue;
      calendar.printCalendar(year, month);
    }
    System.out.printf("종료합니다.\n");
    scanner.close();
  }
}
