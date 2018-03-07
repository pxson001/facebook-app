package com.facebook.analytics.anrwatchdog;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.Debug;
import android.os.Handler;
import android.os.Message;
import com.facebook.analytics.appstatelogger.AppStateLogger;
import com.facebook.common.build.BuildConstants;
import com.facebook.debug.log.BLog;
import com.facebook.soloader.DoNotOptimize;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import java.util.Arrays;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: enable_friend_tagging */
public class ANRDetector {
    private static final ImmutableList<String> f14479g = ImmutableList.of("com.facebook.acra.ErrorReporter.handleException", "com.facebook.acra.ErrorReporter.uncaughtException", "com.facebook.common.errorreporting.memory.MemoryDumpHandler.uncaughtException", "com.facebook.nobreak.ExceptionHandlerToDispatchKnownExceptionRemedies.uncaughtException", "com.facebook.nobreak.DefaultCatchMeIfYouCan.uncaughtException");
    private final Handler f14480a;
    private final ANRDetectorRunnable f14481b;
    private final Provider<ANRReport> f14482c;
    private final Throwable f14483d = new ANRException("ANR detected by ANRWatchdog");
    private int f14484e;
    private boolean f14485f;
    private StackTraceElement[] f14486h;

    @DoNotOptimize
    @TargetApi(16)
    /* compiled from: enable_friend_tagging */
    final class Api16Utils {
        private Api16Utils() {
        }

        static void m14658a(Message message) {
            message.setAsynchronous(true);
        }
    }

    @Inject
    public ANRDetector(ANRDetectorRunnable aNRDetectorRunnable, Provider<ANRReport> provider, Handler handler) {
        this.f14480a = handler;
        this.f14481b = aNRDetectorRunnable;
        this.f14482c = provider;
    }

    public final void m14661a() {
        this.f14484e = -1;
        m14660d();
    }

    public final void m14662b() {
        int i = this.f14481b.f14491a;
        if (i == this.f14484e) {
            Object obj;
            if (BuildConstants.i && Debug.isDebuggerConnected()) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null) {
                if (!this.f14485f) {
                    this.f14485f = true;
                    AppStateLogger.a(true);
                }
                StackTraceElement[] stackTrace = this.f14480a.getLooper().getThread().getStackTrace();
                if (!(m14659a(stackTrace) || Arrays.deepEquals(this.f14486h, stackTrace))) {
                    this.f14486h = stackTrace;
                    this.f14483d.setStackTrace(stackTrace);
                    BLog.b(ANRDetector.class, "Starting ANR report", this.f14483d);
                    ((ANRReport) this.f14482c.get()).m14664a();
                }
                this.f14484e = i;
            }
        }
        if (this.f14485f) {
            this.f14485f = false;
            AppStateLogger.a(false);
        }
        m14660d();
        this.f14484e = i;
    }

    @VisibleForTesting
    private static boolean m14659a(StackTraceElement[] stackTraceElementArr) {
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            if (f14479g.contains(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName())) {
                return true;
            }
        }
        return false;
    }

    private void m14660d() {
        Message obtain = Message.obtain(this.f14480a, this.f14481b);
        if (VERSION.SDK_INT >= 16) {
            Api16Utils.m14658a(obtain);
        }
        obtain.sendToTarget();
    }
}
