package com.facebook.react.modules.core;

import android.util.SparseArray;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ExecutorToken;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.OnExecutorUnregisteredListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.common.SystemClock;
import com.facebook.react.uimanager.ReactChoreographer;
import com.facebook.react.uimanager.ReactChoreographer.CallbackType;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;

/* compiled from: from_get_notified_notification */
public final class Timing extends ReactContextBaseJavaModule implements LifecycleEventListener, OnExecutorUnregisteredListener {
    public final Object f11644a = new Object();
    public final PriorityQueue<Timer> f11645b = new PriorityQueue(11, new C10291(this));
    public final HashMap<ExecutorToken, SparseArray<Timer>> f11646c = new HashMap();
    public final AtomicBoolean f11647d = new AtomicBoolean(true);
    private final FrameCallback f11648e = new FrameCallback(this);
    @Nullable
    public ReactChoreographer f11649f;
    private boolean f11650g = false;

    /* compiled from: from_get_notified_notification */
    class C10291 implements Comparator<Timer> {
        final /* synthetic */ Timing f11636a;

        C10291(Timing timing) {
            this.f11636a = timing;
        }

        public int compare(Object obj, Object obj2) {
            long j = ((Timer) obj).f11643e - ((Timer) obj2).f11643e;
            if (j == 0) {
                return 0;
            }
            if (j < 0) {
                return -1;
            }
            return 1;
        }
    }

    /* compiled from: from_get_notified_notification */
    class FrameCallback implements android.view.Choreographer.FrameCallback {
        final /* synthetic */ Timing f11637a;
        private final HashMap<ExecutorToken, WritableArray> f11638b;

        public FrameCallback(Timing timing) {
            this.f11637a = timing;
            this.f11638b = new HashMap();
        }

        public void doFrame(long j) {
            if (!this.f11637a.f11647d.get()) {
                long j2 = j / 1000000;
                synchronized (this.f11637a.f11644a) {
                    while (!this.f11637a.f11645b.isEmpty() && ((Timer) this.f11637a.f11645b.peek()).f11643e < j2) {
                        Timer timer = (Timer) this.f11637a.f11645b.poll();
                        WritableArray writableArray = (WritableArray) this.f11638b.get(timer.f11639a);
                        if (writableArray == null) {
                            writableArray = Arguments.m13384a();
                            this.f11638b.put(timer.f11639a, writableArray);
                        }
                        writableArray.pushInt(timer.f11640b);
                        if (timer.f11641c) {
                            timer.f11643e = ((long) timer.f11642d) + j2;
                            this.f11637a.f11645b.add(timer);
                        } else {
                            this.f11637a.f11646c.remove(Integer.valueOf(timer.f11640b));
                        }
                    }
                }
                for (Entry entry : this.f11638b.entrySet()) {
                    ((JSTimersExecution) this.f11637a.f1100a.m13514a((ExecutorToken) entry.getKey(), JSTimersExecution.class)).callTimers((WritableArray) entry.getValue());
                }
                this.f11638b.clear();
                ((ReactChoreographer) Assertions.b(this.f11637a.f11649f)).m13933a(CallbackType.TIMERS_EVENTS, (android.view.Choreographer.FrameCallback) this);
            }
        }
    }

    /* compiled from: from_get_notified_notification */
    class Timer {
        public final ExecutorToken f11639a;
        public final int f11640b;
        public final boolean f11641c;
        public final int f11642d;
        public long f11643e;

        private Timer(ExecutorToken executorToken, int i, long j, int i2, boolean z) {
            this.f11639a = executorToken;
            this.f11640b = i;
            this.f11643e = j;
            this.f11642d = i2;
            this.f11641c = z;
        }
    }

    public Timing(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public final void m13716c() {
        this.f11649f = ReactChoreographer.m13927a();
        this.f1100a.mo745a((LifecycleEventListener) this);
    }

    public final void hg_() {
        this.f11647d.set(true);
        m13714s();
    }

    public final void hh_() {
        m13714s();
    }

    public final void hf_() {
        this.f11647d.set(false);
        m13713r();
    }

    public final void m13717e() {
        m13714s();
    }

    private void m13713r() {
        if (!this.f11650g) {
            ((ReactChoreographer) Assertions.b(this.f11649f)).m13933a(CallbackType.TIMERS_EVENTS, this.f11648e);
            this.f11650g = true;
        }
    }

    private void m13714s() {
        if (this.f11650g) {
            ((ReactChoreographer) Assertions.b(this.f11649f)).m13934b(CallbackType.TIMERS_EVENTS, this.f11648e);
            this.f11650g = false;
        }
    }

    public final String getName() {
        return "RKTiming";
    }

    public final boolean m13718f() {
        return true;
    }

    public final void mo723a(ExecutorToken executorToken) {
        synchronized (this.f11644a) {
            SparseArray sparseArray = (SparseArray) this.f11646c.remove(executorToken);
            if (sparseArray == null) {
                return;
            }
            for (int i = 0; i < sparseArray.size(); i++) {
                this.f11645b.remove((Timer) sparseArray.get(sparseArray.keyAt(i)));
            }
        }
    }

    @ReactMethod
    public final void createTimer(ExecutorToken executorToken, int i, int i2, double d, boolean z) {
        long max = (long) Math.max(0.0d, (d - ((double) SystemClock.m13612a())) + ((double) i2));
        if (i2 != 0 || z) {
            Timer timer = new Timer(executorToken, i, (SystemClock.m13613b() / 1000000) + max, i2, z);
            synchronized (this.f11644a) {
                this.f11645b.add(timer);
                SparseArray sparseArray = (SparseArray) this.f11646c.get(executorToken);
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.f11646c.put(executorToken, sparseArray);
                }
                sparseArray.put(i, timer);
            }
            return;
        }
        WritableArray a = Arguments.m13384a();
        a.pushInt(i);
        ((JSTimersExecution) m1069p().m13514a(executorToken, JSTimersExecution.class)).callTimers(a);
    }

    @ReactMethod
    public final void deleteTimer(ExecutorToken executorToken, int i) {
        synchronized (this.f11644a) {
            SparseArray sparseArray = (SparseArray) this.f11646c.get(executorToken);
            if (sparseArray == null) {
                return;
            }
            Timer timer = (Timer) sparseArray.get(i);
            if (timer == null) {
                return;
            }
            this.f11646c.remove(Integer.valueOf(i));
            this.f11645b.remove(timer);
        }
    }
}
