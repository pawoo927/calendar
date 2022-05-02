
import java.util.Scanner;

public class Calendar {

  public static final String DATE = null;
private static String DAY_OF_WEEK;

void printOption(){
    System.out.println("==========");
    System.out.println("| 1. 일정등록");
    System.out.println("| 2. 일정검색");
    System.out.println("| 3. 달력보기");
    System.out.println("| h. 도움말");
    System.out.println("| q. 종료");
    System.out.println("==========");
  }

  void registerEvent(Scanner s, Manager m){
    System.out.println("[새 일정 등록]");
    System.out.print("날짜 (yyyy-mm-dd)>");
    String date = s.next();
    System.out.print("일정>");
    String event = s.next();
    m.registerEvent(date, event);
  }

  void searchEvent(Scanner s, Manager m){
    System.out.println("[일정 검색]");
    System.out.println("날짜 (yyyy-mm-dd)>");
    String date = s.next();
    String event = m.searchEvent(date);
    switch(event){
      case "-1": break;
      default: System.out.println(event);
               break;
    }
  }

public void scan() {
     
      Scanner sc = new Scanner(System.in);
      
      System.out.println("년도 입력 : ");
      int year = Integer.parseInt(sc.nextLine());
      System.out.println("월 입력 : ");
      int month = Integer.parseInt(sc.nextLine());        
      int START_DAY_OF_WEEK = 0;
      int END_DAY = 0;
      
      Calendar start = Calendar.getInstance();
      Calendar end = Calendar.getInstance();
      
      start.set(year, month -1, 1);
      end.set(year, month, 1);
      end.add(Calendar.DATE, -1);
      
      START_DAY_OF_WEEK = start.get(Calendar.DAY_OF_WEEK);
      END_DAY = end.get(Calendar.DATE);
      
      System.out.println(year+"년 "+month+"월 달력\n"
              + "일\t월\t화\t수\t목\t금\t토");
      
      for(int q = 1 ; q < START_DAY_OF_WEEK ; q++) {
          System.out.print("\t");
      }
      
      int cnt = START_DAY_OF_WEEK - 1;
      for(int q = 1 ; q <= END_DAY ; q++) {
          System.out.print(q+"\t");
          cnt ++;
          if(cnt == 7) {
              cnt = 0;
              System.out.println("\n");
          }
      }    
  }
  
      
  static Calendar getInstance() {
	return null ;
}

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Manager manager = new Manager();
    Calendar calendar = new Calendar();
    String command;
    boolean quit = false;
    calendar.printOption();
    while(!quit){
      System.out.print("명령(1, 2, 3, h, q)>");
      command = scanner.next();
      switch (command){
        case "1": calendar.registerEvent(scanner, manager);
                  break;
        case "2": calendar.searchEvent(scanner, manager);
                  break;
        case "3": calendar.scan();
        	      break;
        case "h": calendar.printOption();
                  break;
        case "q": quit = true;
                  manager.writeFile();
                  break;
        default:  System.out.println("다시 입력해주세요.");
                  break;
      }
    }
    System.out.printf("종료합니다.\n");
    scanner.close();
  }



public void set(int year, int month, int date) {
	
}

public void add(String date2, int i) {
}

public int get(String date2) {
	
	return 0;
}
}
