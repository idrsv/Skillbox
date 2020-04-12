import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Main {
    public static void main(String args[]) {
        DateFormat dateFormat = new SimpleDateFormat(" - dd.MM.yyyy - EEE", Locale.ENGLISH);
        Calendar calendar = Calendar.getInstance();
        calendar.set(1997, Calendar.MAY, 20);

        Date date = new Date();
        Date date2 = calendar.getTime();

        int i = 0;

        while (date.compareTo(date2) > 0)
        {
            System.out.println(i + dateFormat.format(date2));
            calendar.add(Calendar.YEAR, 1);
            date2 = calendar.getTime();
            i++;
        }
    }
}

