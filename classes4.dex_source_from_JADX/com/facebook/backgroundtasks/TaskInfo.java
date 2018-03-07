package com.facebook.backgroundtasks;

import com.facebook.common.executors.BackgroundWorkLogger;
import com.facebook.common.executors.BackgroundWorkLogger.StatsCollector;
import com.facebook.common.time.Clock;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: extra_app_id */
public class TaskInfo {
    public final BackgroundTask f12535a;
    public int f12536b;
    public long f12537c;
    public boolean f12538d;
    private StatsCollector f12539e;

    public TaskInfo(BackgroundTask backgroundTask) {
        this.f12535a = backgroundTask;
    }

    public String toString() {
        return this.f12535a.mo597a();
    }

    public final BackgroundTask m13281a() {
        return this.f12535a;
    }

    public final boolean m13286b() {
        return this.f12536b > 0;
    }

    public final boolean m13284a(Clock clock) {
        return m13286b() && clock.a() < this.f12537c;
    }

    public final void m13283a(Clock clock, long j, long j2) {
        this.f12536b++;
        int i = this.f12536b - 1;
        while (i > 0 && j < j2) {
            i--;
            j *= 2;
        }
        this.f12537c = clock.a() + Math.min(j, j2);
    }

    public final ListenableFuture<BackgroundResult> m13282a(BackgroundWorkLogger backgroundWorkLogger) {
        this.f12539e = backgroundWorkLogger.a("BackgroundTask", this.f12535a.mo597a());
        if (this.f12539e != null) {
            this.f12539e.a();
        }
        return this.f12535a.mo596j();
    }

    public final void m13285b(boolean z) {
        if (this.f12539e != null) {
            this.f12539e.a(z);
            this.f12539e = null;
        }
    }
}
