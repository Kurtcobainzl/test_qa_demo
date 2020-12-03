package learn.base;

import java.util.Date;

public class BaseTime {
    public static final long DAY = 1000L * 60 * 60 * 24;
    public long time(){
        Date date = new Date();
        long timeestamp = date.getTime();
        timeestamp += DAY;
        return timeestamp;
    }
}
