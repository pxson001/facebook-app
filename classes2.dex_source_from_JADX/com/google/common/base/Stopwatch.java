package com.google.common.base;

import com.facebook.proxygen.HTTPTransportCallback;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckReturnValue;

@GwtCompatible
/* compiled from: whistle */
public final class Stopwatch {
    public long elapsedNanos;
    public boolean isRunning;
    private long startTick;
    private final Ticker ticker = Ticker.SYSTEM_TICKER;

    @CheckReturnValue
    public static Stopwatch createUnstarted() {
        return new Stopwatch();
    }

    @CheckReturnValue
    public static Stopwatch createStarted() {
        return new Stopwatch().start();
    }

    Stopwatch() {
    }

    public final Stopwatch start() {
        Preconditions.checkState(!this.isRunning, "This stopwatch is already running.");
        this.isRunning = true;
        this.startTick = this.ticker.read();
        return this;
    }

    public final Stopwatch stop() {
        long read = this.ticker.read();
        Preconditions.checkState(this.isRunning, "This stopwatch is already stopped.");
        this.isRunning = false;
        this.elapsedNanos = (read - this.startTick) + this.elapsedNanos;
        return this;
    }

    private long elapsedNanos() {
        return this.isRunning ? (this.ticker.read() - this.startTick) + this.elapsedNanos : this.elapsedNanos;
    }

    @CheckReturnValue
    public final long elapsed(TimeUnit timeUnit) {
        return timeUnit.convert(elapsedNanos(), TimeUnit.NANOSECONDS);
    }

    @GwtIncompatible("String.format()")
    public final String toString() {
        TimeUnit timeUnit;
        long elapsedNanos = elapsedNanos();
        if (TimeUnit.DAYS.convert(elapsedNanos, TimeUnit.NANOSECONDS) > 0) {
            timeUnit = TimeUnit.DAYS;
        } else if (TimeUnit.HOURS.convert(elapsedNanos, TimeUnit.NANOSECONDS) > 0) {
            timeUnit = TimeUnit.HOURS;
        } else if (TimeUnit.MINUTES.convert(elapsedNanos, TimeUnit.NANOSECONDS) > 0) {
            timeUnit = TimeUnit.MINUTES;
        } else if (TimeUnit.SECONDS.convert(elapsedNanos, TimeUnit.NANOSECONDS) > 0) {
            timeUnit = TimeUnit.SECONDS;
        } else if (TimeUnit.MILLISECONDS.convert(elapsedNanos, TimeUnit.NANOSECONDS) > 0) {
            timeUnit = TimeUnit.MILLISECONDS;
        } else if (TimeUnit.MICROSECONDS.convert(elapsedNanos, TimeUnit.NANOSECONDS) > 0) {
            timeUnit = TimeUnit.MICROSECONDS;
        } else {
            timeUnit = TimeUnit.NANOSECONDS;
        }
        double convert = ((double) elapsedNanos) / ((double) TimeUnit.NANOSECONDS.convert(1, timeUnit));
        return String.format(Locale.ROOT, "%.4g %s", new Object[]{Double.valueOf(convert), abbreviate(timeUnit)});
    }

    private static String abbreviate(TimeUnit timeUnit) {
        switch (1.$SwitchMap$java$util$concurrent$TimeUnit[timeUnit.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return "ns";
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return "μs";
            case 3:
                return "ms";
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return "s";
            case 5:
                return "min";
            case 6:
                return "h";
            case 7:
                return "d";
            default:
                throw new AssertionError();
        }
    }
}
