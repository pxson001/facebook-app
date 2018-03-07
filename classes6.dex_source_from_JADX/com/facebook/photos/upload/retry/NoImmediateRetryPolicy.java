package com.facebook.photos.upload.retry;

import com.facebook.photos.base.analytics.ExceptionInterpreter;
import java.util.concurrent.Semaphore;

/* compiled from: full_screen_map */
public class NoImmediateRetryPolicy implements ImmediateRetryPolicy {
    private boolean f14220a = false;

    public final void mo1149a(Semaphore semaphore) {
    }

    public final void mo1146a() {
    }

    public final void mo1148a(Exception exception) {
        mo1147a(new ExceptionInterpreter(exception));
    }

    public final int mo1151b() {
        return 0;
    }

    public final void mo1150a(boolean z) {
        this.f14220a = z;
    }

    public final boolean mo1152c() {
        return this.f14220a;
    }

    public final void mo1147a(ExceptionInterpreter exceptionInterpreter) {
        throw exceptionInterpreter.f12622g;
    }
}
