package demo.mockito.more;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Queue;

public class Sample6 {
    public Queue<String> addElements(Queue<String> stringSet) {
        stringSet.add("aaaa");
        stringSet.add("bbbb");
        return stringSet;
    }

    public Date format(String date) throws ParseException {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        return df.parse(date);
    }

}
