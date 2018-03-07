package com.facebook.loom.provider;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.facebook.cpuprofiler.CPUProfiler;
import com.facebook.loom.core.TraceEvents;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.soloader.SoLoader;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: zero_rating2/clearable/default_optin/primary_button_action_key */
public class StackFrameThread {
    private int f443a;
    @GuardedBy("this")
    private boolean f444b;
    @GuardedBy("this")
    @Nullable
    private HandlerThread f445c;
    @GuardedBy("this")
    @Nullable
    private Handler f446d;
    @GuardedBy("this")
    @Nullable
    private Runnable f447e;
    @GuardedBy("this")
    @Nullable
    private Context f448f;

    /* compiled from: zero_rating2/clearable/default_optin/primary_button_action_key */
    class C00161 implements Runnable {
        final /* synthetic */ StackFrameThread f454a;

        C00161(StackFrameThread stackFrameThread) {
            this.f454a = stackFrameThread;
        }

        public void run() {
            StackFrameThread.m932e(this.f454a);
        }
    }

    static {
        if (m933f()) {
            SoLoader.a("loom");
        }
    }

    public StackFrameThread(Context context) {
        if (m933f()) {
            this.f443a = 17;
            this.f444b = false;
            this.f447e = new C00161(this);
            this.f448f = context;
        }
    }

    @SuppressLint({"BadMethodUse-android.os.HandlerThread._Constructor", "BadMethodUse-java.lang.Thread.start"})
    private synchronized boolean m930c() {
        boolean z = true;
        synchronized (this) {
            if (this.f446d == null) {
                try {
                    CPUProfiler.a(this.f448f);
                    this.f445c = new HandlerThread("CPU Profiler");
                    this.f445c.start();
                    this.f446d = new Handler(this.f445c.getLooper());
                } catch (Throwable e) {
                    Log.e("StackFrameThread", e.getMessage(), e);
                    z = false;
                }
            }
        }
        return z;
    }

    private synchronized boolean m931d() {
        return this.f444b;
    }

    public static synchronized void m932e(StackFrameThread stackFrameThread) {
        synchronized (stackFrameThread) {
            if (stackFrameThread.m931d()) {
                CPUProfiler.a();
                HandlerDetour.b(stackFrameThread.f446d, stackFrameThread.f447e, (long) stackFrameThread.f443a, -1633176558);
            }
        }
    }

    public final synchronized void m934a() {
        if (TraceEvents.a(HTTPTransportCallback.BODY_BYTES_RECEIVED) && m933f() && m930c()) {
            this.f444b = true;
            m932e(this);
        }
    }

    public final synchronized void m935b() {
        if (m933f()) {
            if (this.f444b) {
                CPUProfiler.a();
            }
            CPUProfiler.b();
            this.f444b = false;
            if (this.f445c != null) {
                this.f445c.quit();
                this.f445c = null;
            }
            this.f446d = null;
        }
    }

    @TargetApi(19)
    private static boolean m933f() {
        return VERSION.SDK_INT <= 19;
    }
}
