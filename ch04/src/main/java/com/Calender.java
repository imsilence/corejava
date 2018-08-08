import java.time.LocalDate;
import java.time.DayOfWeek;


public class Calender {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();

        int year = date.getYear();
        int month = date.getMonthValue();
        int day = date.getDayOfMonth();


        date = LocalDate.of(year, month, 1);

        int dayOfWeek = date.getDayOfWeek().getValue();
        System.out.println("Mon  Tue  Wed  Thu  Fri  Sat  Sun");
        for(int i=1; i < dayOfWeek; ++i) {
            System.out.print("     ");
        }
        while(month == date.getMonthValue()) {
            System.out.printf("%3d", date.getDayOfMonth());
            if(day == date.getDayOfMonth()) {
                System.out.print("* ");
            } else {
                System.out.print("  ");
            }
            date = date.plusDays(1);
            if(date.getDayOfWeek().getValue() == 1) {
                System.out.println();
            }
        }
        if(date.getDayOfWeek().getValue() != 1) {
            System.out.println();
        }
    }
}