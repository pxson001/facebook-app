package com.facebook.perftestutils;

import android.annotation.TargetApi;
import android.view.Choreographer;
import com.facebook.dalvikdistract.DalvikDistract;
import com.facebook.debug.log.BLog;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.systrace.Systrace;

@TargetApi(16)
/* compiled from: dbl_check_password */
public class FrameRateEventsTracer {
    public static void m10070a() {
        Throwable e;
        try {
            Class cls = Class.forName(Choreographer.class.getName() + "$CallbackRecord");
            new DalvikDistract().hook(Choreographer.class.getDeclaredMethod("scheduleVsyncLocked", new Class[0]), FrameRateEventsTracer.class.getDeclaredMethod("hookScheduleVsyncLocked", new Class[]{Choreographer.class}), FrameRateEventsTracer.class.getDeclaredMethod("originalScheduleVsyncLocked", new Class[]{Choreographer.class})).hook(Choreographer.class.getDeclaredMethod("doFrame", new Class[]{Long.TYPE, Integer.TYPE}), FrameRateEventsTracer.class.getDeclaredMethod("hookDoFrame", new Class[]{Choreographer.class, Long.TYPE, Integer.TYPE}), FrameRateEventsTracer.class.getDeclaredMethod("originalDoFrame", new Class[]{Choreographer.class, Long.TYPE, Integer.TYPE})).hook(DalvikDistract.unsafe(cls.getDeclaredMethod("run", new Class[]{Long.TYPE})), FrameRateEventsTracer.class.getDeclaredMethod("hookRun", new Class[]{Object.class, Long.TYPE}), FrameRateEventsTracer.class.getDeclaredMethod("originalRun", new Class[]{Object.class, Long.TYPE})).commit();
        } catch (ClassNotFoundException e2) {
            e = e2;
            BLog.b(FrameRateEventsTracer.class, "Failed to hook", e);
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e3) {
            e = e3;
            BLog.b(FrameRateEventsTracer.class, "Failed to hook", e);
            throw new RuntimeException(e);
        }
    }

    public static void m10071b() {
        Throwable e;
        try {
            Class cls = Class.forName(Choreographer.class.getName() + "$CallbackRecord");
            new DalvikDistract().unhook(Choreographer.class.getDeclaredMethod("scheduleVsyncLocked", new Class[0])).unhook(Choreographer.class.getDeclaredMethod("doFrame", new Class[]{Long.TYPE, Integer.TYPE})).unhook(cls.getDeclaredMethod("run", new Class[]{Long.TYPE})).commit();
        } catch (ClassNotFoundException e2) {
            e = e2;
            BLog.b(FrameRateEventsTracer.class, "Failed to unhook", e);
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e3) {
            e = e3;
            BLog.b(FrameRateEventsTracer.class, "Failed to unhook", e);
            throw new RuntimeException(e);
        }
    }

    @DoNotStrip
    private static void hookScheduleVsyncLocked(Choreographer choreographer) {
        Systrace.a(262144, "scheduleVsyncLocked");
        originalScheduleVsyncLocked(choreographer);
        Systrace.a(262144);
    }

    @DoNotStrip
    private static void originalScheduleVsyncLocked(Choreographer choreographer) {
        throw new RuntimeException("Stub!");
    }

    @DoNotStrip
    private static void hookDoFrame(Choreographer choreographer, long j, int i) {
        Systrace.a(262144, "doFrame");
        originalDoFrame(choreographer, j, i);
        Systrace.a(262144);
    }

    @DoNotStrip
    private static void originalDoFrame(Choreographer choreographer, long j, int i) {
        throw new RuntimeException("Stub!");
    }

    @DoNotStrip
    private static void hookRun(Object obj, long j) {
        Systrace.a(262144, "CallbackRun");
        originalRun(obj, j);
        Systrace.a(262144);
    }

    @DoNotStrip
    private static void originalRun(Object obj, long j) {
        throw new RuntimeException("Stub!");
    }
}
