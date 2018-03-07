package com.facebook.common.executors;

import android.os.Handler;
import android.os.Looper;

/* compiled from: memory_usage */
public class UiThreadImmediateExecutorService extends HandlerExecutorServiceImpl {
    private static UiThreadImmediateExecutorService f14395a = null;

    private UiThreadImmediateExecutorService() {
        super(new Handler(Looper.getMainLooper()));
    }

    public static UiThreadImmediateExecutorService m20771b() {
        if (f14395a == null) {
            f14395a = new UiThreadImmediateExecutorService();
        }
        return f14395a;
    }

    public void execute(Runnable runnable) {
        Object obj;
        if (Thread.currentThread() == this.f14396a.getLooper().getThread()) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            runnable.run();
        } else {
            super.execute(runnable);
        }
    }
}
