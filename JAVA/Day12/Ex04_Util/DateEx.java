package Day12.Ex04_Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateEx {
   
   public static void main(String[] args) throws ParseException {
      // Date 객체는 시스템에서 현재 날짜를 가져온 정보를 가지고 있다
      Date now = new Date();
      System.out.println("now : " + now);
      
      String dateStr = now.toString();
      System.out.println("Date 문자열 기본 포맷 : " + dateStr);
      
      // 날짜/시간 문자
      // yyyy : 년도,    MM : 월,    dd : 일
      // hh   : 시,    mm : 분,    ss : 초
      String dateFormat = "yyyy년 MM월 dd일 hh시 mm분 ss초";
      SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
      String nowStr = sdf.format(now);
      System.out.println(nowStr);
      
      String day1 = "2024/01/31";
      String day2 = "2024/08/01";
      
      Date date1 = new SimpleDateFormat("yyyy/MM/dd").parse(day1);
      Date date2 = new SimpleDateFormat("yyyy/MM/dd").parse(day2);
      
      System.out.println("date1 : " + date1);
      System.out.println("date2 : " + date2);
            
      
      //Date.getTime();
      // : 1970년1월1일0시0분0초 부터 Date에 지정된 날짜/시간 까지의 ms(밀리초) 누적값
      long gapDays = (date2.getTime() - date1.getTime()) / (1000*60*60*24);
      long gapHours = (date2.getTime() - date1.getTime()) / (1000*60*60);
      long gapMin = (date2.getTime() - date1.getTime()) / (1000*60);
      long gapSec = (date2.getTime() - date1.getTime()) / (1000);
      
      System.out.println("종강 D-day : " + gapDays);
      System.out.println("종강까지 남은 시간(/시) : " + gapHours);
      System.out.println("종강까지 남은 시간(/분) : " + gapMin);
      System.out.println("종강까지 남은 시간(/초) : " + gapSec);
      
   }

}