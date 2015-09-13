package chapter_5.ex_05_08;


import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.stream.Stream;

public class TimeZoneOffset {

    public static void main(String args[]){
        ZonedDateTime utcTime = ZonedDateTime.now(ZoneId.of("UTC"));
        Stream<String> zoneIDs = ZoneId.getAvailableZoneIds().stream();

        zoneIDs.forEach(id -> {
            System.out.println(utcTime.toInstant().atZone(ZoneId.of(id)));
        });
    }
}

