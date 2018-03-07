package com.facebook.loom.provider;

import android.annotation.SuppressLint;
import android.os.Debug;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import com.facebook.loom.core.TraceEvents;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;
import java.lang.ref.WeakReference;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: zero_rating2/clearable/default_optin/primary_button_intent_key */
public class SystemCounterThread {
    private int f436a = 250;
    @GuardedBy("this")
    private boolean f437b = false;
    @GuardedBy("this")
    private HandlerThread f438c = null;
    @GuardedBy("this")
    private Handler f439d = null;
    @GuardedBy("this")
    private final Runnable f440e;
    @GuardedBy("this")
    private Map<Integer, WeakReference<Thread>> f441f;
    private final int f442g = Process.myPid();

    /* compiled from: zero_rating2/clearable/default_optin/primary_button_intent_key */
    class C00151 implements Runnable {
        final /* synthetic */ SystemCounterThread f453a;

        C00151(SystemCounterThread systemCounterThread) {
            this.f453a = systemCounterThread;
        }

        public void run() {
            SystemCounterThread.m927e(this.f453a);
        }
    }

    public SystemCounterThread() {
        int myTid = Process.myTid();
        if (this.f442g != myTid) {
            this.f441f = ImmutableBiMap.m978b(Integer.valueOf(myTid), new WeakReference(Thread.currentThread()));
        }
        this.f440e = new C00151(this);
    }

    @SuppressLint({"BadMethodUse-android.os.HandlerThread._Constructor", "BadMethodUse-java.lang.Thread.start"})
    private synchronized void m925c() {
        if (this.f439d == null) {
            this.f438c = new HandlerThread("Loom System Counters");
            this.f438c.start();
            this.f439d = new Handler(this.f438c.getLooper());
        }
    }

    private synchronized boolean m926d() {
        boolean z = true;
        synchronized (this) {
            if (!this.f437b) {
                z = false;
            }
        }
        return z;
    }

    public static synchronized void m927e(SystemCounterThread systemCounterThread) {
        synchronized (systemCounterThread) {
            if (systemCounterThread.m926d()) {
                SystemCounterLogger.a(systemCounterThread.f441f);
                HandlerDetour.b(systemCounterThread.f439d, systemCounterThread.f440e, (long) systemCounterThread.f436a, 2075148930);
            }
        }
    }

    public final synchronized void m928a() {
        if (TraceEvents.a(64)) {
            this.f437b = true;
            WeakReference weakReference = new WeakReference(Looper.getMainLooper().getThread());
            if (this.f441f != null) {
                this.f441f = ImmutableMap.builder().m608a(this.f441f).m609b(Integer.valueOf(this.f442g), weakReference).m610b();
            } else {
                this.f441f = ImmutableBiMap.m978b(Integer.valueOf(this.f442g), weakReference);
            }
            m925c();
            Debug.startAllocCounting();
            m927e(this);
        }
    }

    public final synchronized void m929b() {
        if (this.f437b) {
            SystemCounterLogger.a(this.f441f);
        }
        this.f437b = false;
        if (this.f438c != null) {
            this.f438c.quit();
            this.f438c = null;
        }
        this.f439d = null;
        this.f441f = null;
        Debug.stopAllocCounting();
    }
}
