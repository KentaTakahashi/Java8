package chapter_5.ex_05_09;


import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.stream.Stream;

public class TimeZoneOffset {

    public static void main(String args[]){
        ZonedDateTime utcTime = ZonedDateTime.now(ZoneId.of("UTC"));
        Stream<String> zoneIDs = ZoneId.getAvailableZoneIds().stream();

        zoneIDs.filter(id -> {
           ZonedDateTime time = utcTime.toInstant().atZone(ZoneId.of(id));
           long diff = utcTime.toLocalTime().until(time.toLocalTime(), ChronoUnit.HOURS);
           if(diff == 0)//一時間未満→時差なし
               return true;
           else
               return false;
        }).
        forEach(id -> {
            System.out.println(utcTime.toInstant().atZone(ZoneId.of(id)));
        });
    }
}

