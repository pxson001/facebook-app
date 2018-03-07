package com.facebook.backgroundworklog;

import android.os.Debug;
import android.os.Process;
import com.facebook.backgroundworklog.BackgroundWorkEvent.Builder;
import com.facebook.common.appchoreographer.DefaultAppChoreographer;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.executors.BackgroundWorkLogger.StatsCollector;
import com.facebook.common.time.MonotonicClock;
import com.facebook.inject.Assisted;
import com.facebook.systrace.Systrace;
import com.facebook.systrace.SystraceMetadata;
import com.facebook.systrace.TraceConfig;
import java.util.EnumSet;
import javax.inject.Inject;

/* compiled from: select_composer_shortcut_from_composer */
public class DumpStatsCollector implements StatsCollector {
    private final String f4243a;
    private final Object f4244b;
    private final AppStateManager f4245c;
    private final DefaultAppChoreographer f4246d;
    private final BackgroundWorkRecorder f4247e;
    private final MonotonicClock f4248f;
    private final Builder f4249g = new Builder();
    private volatile long f4250h = this.f4248f.now();

    @Inject
    public DumpStatsCollector(@Assisted String str, @Assisted Object obj, AppStateManager appStateManager, DefaultAppChoreographer defaultAppChoreographer, BackgroundWorkRecorder backgroundWorkRecorder, MonotonicClock monotonicClock) {
        this.f4243a = str;
        this.f4244b = obj;
        this.f4245c = appStateManager;
        this.f4246d = defaultAppChoreographer;
        this.f4247e = backgroundWorkRecorder;
        this.f4248f = monotonicClock;
    }

    public final void m4252a() {
        String obj = this.f4244b.toString();
        if (TraceConfig.a(128)) {
            SystraceMetadata.c();
            Systrace.a(128, this.f4243a + "/" + obj);
        }
        long now = this.f4248f.now();
        EnumSet noneOf = EnumSet.noneOf(BackgroundWorkAppState.class);
        if (!this.f4245c.h()) {
            noneOf.add(BackgroundWorkAppState.INITIALIZING);
        }
        if (!this.f4246d.a()) {
            noneOf.add(BackgroundWorkAppState.LOADING);
        }
        if (this.f4245c.j()) {
            noneOf.add(BackgroundWorkAppState.BACKGROUND);
        }
        if (this.f4246d.b()) {
            noneOf.add(BackgroundWorkAppState.LOADING_UI);
        }
        if (this.f4245c.p() < 1000) {
            noneOf.add(BackgroundWorkAppState.INTERACTIVE);
        }
        Builder builder = this.f4249g;
        builder.f4210a = this.f4243a;
        builder = builder;
        builder.f4211b = obj;
        Builder builder2 = builder;
        builder2.f4215f = this.f4250h;
        builder2 = builder2;
        builder2.f4216g = now;
        builder2 = builder2;
        builder2.f4218i = EnumSet.copyOf(noneOf);
        builder2.f4220k = Debug.threadCpuTimeNanos();
        this.f4250h = now;
    }

    public final void m4253a(boolean z) {
        Builder builder = this.f4249g;
        builder.f4217h = this.f4248f.now();
        builder = builder;
        builder.f4221l = Debug.threadCpuTimeNanos();
        builder = builder;
        builder.f4212c = Process.myTid();
        builder = builder;
        builder.f4213d = Thread.currentThread().getName();
        builder = builder;
        builder.f4214e = Process.getThreadPriority(Process.myTid());
        builder = builder;
        builder.f4219j = z;
        BackgroundWorkEvent a = builder.m4240a();
        BackgroundWorkRecorder backgroundWorkRecorder = this.f4247e;
        String str = a.f4222a + ':' + a.f4223b;
        BackgroundWorkAccumulator backgroundWorkAccumulator = (BackgroundWorkAccumulator) backgroundWorkRecorder.f4233a.get(str);
        if (backgroundWorkAccumulator == null) {
            backgroundWorkAccumulator = new BackgroundWorkAccumulator(a.f4222a, a.f4223b);
            backgroundWorkAccumulator.m4239a(a);
            backgroundWorkAccumulator = (BackgroundWorkAccumulator) backgroundWorkRecorder.f4233a.putIfAbsent(str, backgroundWorkAccumulator);
        }
        if (backgroundWorkAccumulator != null) {
            backgroundWorkAccumulator.m4239a(a);
        }
        backgroundWorkRecorder.f4234b.m4245a(a);
        Systrace.a(128);
    }

    public String toString() {
        return this.f4249g.m4240a().toString();
    }
}
