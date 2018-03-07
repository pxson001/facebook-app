package com.facebook.common.executors;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Throwables;
import com.google.common.util.concurrent.ExecutionList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/* compiled from: web */
public class GuavaExecutionListHack {
    @VisibleForTesting
    public static final AtomicBoolean f887a = new AtomicBoolean(false);
    private static final Handler f888b = new C00531();

    /* compiled from: web */
    final class C00531 extends Handler {
        C00531() {
        }

        public final void publish(LogRecord logRecord) {
            if (logRecord.getLevel() == Level.SEVERE && logRecord.getThrown() != null) {
                String message = logRecord.getMessage();
                if (message != null && message.startsWith("RuntimeException while executing runnable ")) {
                    throw Throwables.propagate(logRecord.getThrown());
                }
            }
        }

        public final void flush() {
        }

        public final void close() {
        }
    }

    public static synchronized void m1743a() {
        synchronized (GuavaExecutionListHack.class) {
            if (!f887a.getAndSet(true)) {
                ExecutionList executionList = new ExecutionList();
                Logger.getLogger(ExecutionList.class.getName()).addHandler(f888b);
            }
        }
    }
}
