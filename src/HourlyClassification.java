import java.util.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.FileWriter;
import java.time.LocalDate;
public class HourlyClassification implements PaymentClassification
{
    public double hourlyRate;
    public HashMap<LocalDate,TimeCard> timecards = new HashMap<LocalDate,TimeCard>();
    public HourlyClassification(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
    public TimeCard getTimeCard(LocalDate date) {
        return timecards.get(date);
    }
    public void addTimeCard(LocalDate date, double workingHours) {
        timecards.put(date, new TimeCard(date, workingHours)); 
    }
    public double calculatePay(Paycheck paycheck) {
      double salary = 0;
      for(LocalDate date = paycheck.startDate; date.isBefore(paycheck.payDate.plusDays(1));date = date.plusDays(1)) {
        if (timecards.get(date) != null) {
          double hours = timecards.get(date).hours;
          salary += hourlyRate * hours;
          if (hours > 8.0)
            salary += hourlyRate * (hours - 8) *1.5;
        }
      }
      return salary;
    }
}
