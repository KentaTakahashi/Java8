package chapter_5.ex_05_07;


import java.time.LocalDateTime;

public class TimeInterval {
    LocalDateTime start;
    LocalDateTime end;

    public TimeInterval(LocalDateTime start, LocalDateTime end) {
        if(start.isAfter(end))
            throw new IllegalArgumentException("interval time is inverse ");
        this.start = start;
        this.end = end;
    }

    public boolean duplicateChaek(TimeInterval other) {
        if(this.start.isAfter(other.end) || other.start.isAfter(this.end))
            return false;
        else
            return true;
    }
}

