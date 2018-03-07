package com.facebook.common.executors;

import com.facebook.common.executors.BackgroundWorkLogger.StatsCollector;
import java.util.concurrent.Callable;

/* compiled from: messenger_inbox_item_hides_remaining */
public class LoggingCallable<E> implements ProvidesName, Callable<E> {
    private final Callable<E> f13940a;
    private final String f13941b = LoggingUtils.a(this.f13940a);
    private final StatsCollector f13942c;

    public static <V> Callable<V> m20280a(Callable<V> callable, BackgroundWorkLogger backgroundWorkLogger, String str) {
        if (backgroundWorkLogger.mo231a()) {
            return new LoggingCallable(callable, backgroundWorkLogger, str);
        }
        return callable;
    }

    private LoggingCallable(Callable<E> callable, BackgroundWorkLogger backgroundWorkLogger, String str) {
        this.f13940a = callable;
        this.f13942c = backgroundWorkLogger.mo229a(str, this.f13941b);
    }

    public final String mo502a() {
        return this.f13941b;
    }

    public E call() {
        this.f13942c.mo2832a();
        try {
            E call = this.f13940a.call();
            this.f13942c.mo2833a(true);
            return call;
        } catch (Throwable th) {
            this.f13942c.mo2833a(false);
        }
    }
}
