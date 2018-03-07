package com.facebook.react.bridge;

import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.queue.QueueThreadExceptionHandler;
import com.facebook.react.bridge.queue.ReactQueueConfiguration;
import com.facebook.react.bridge.queue.ReactQueueConfigurationImpl;
import com.facebook.react.bridge.queue.ReactQueueConfigurationSpec;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.common.futures.SimpleSettableFuture;
import com.facebook.systrace.Systrace;
import com.facebook.systrace.TraceConfig;
import com.facebook.systrace.TraceListener;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;

@DoNotStrip
/* compiled from: groups/ */
public class CatalystInstanceImpl implements CatalystInstance {
    private static final AtomicInteger f11486a = new AtomicInteger(1);
    public final ReactQueueConfigurationImpl f11487b;
    private final CopyOnWriteArrayList<NotThreadSafeBridgeIdleDebugListener> f11488c;
    private final AtomicInteger f11489d;
    private final String f11490e;
    public volatile boolean f11491f;
    public volatile boolean f11492g;
    private final TraceListener f11493h;
    private final JavaScriptModuleRegistry f11494i;
    private final JSBundleLoader f11495j;
    @Nullable
    public ExecutorToken f11496k;
    public final Object f11497l;
    private final Object f11498m;
    public final NativeModuleRegistry f11499n;
    public final NativeModuleCallExceptionHandler f11500o;
    private boolean f11501p;
    public final ReactBridge f11502q;
    private boolean f11503r;

    /* compiled from: groups/ */
    public class Builder {
        @Nullable
        private ReactQueueConfigurationSpec f11476a;
        @Nullable
        private JSBundleLoader f11477b;
        @Nullable
        private NativeModuleRegistry f11478c;
        @Nullable
        private JavaScriptModuleRegistry f11479d;
        @Nullable
        private JavaScriptExecutor f11480e;
        @Nullable
        private NativeModuleCallExceptionHandler f11481f;

        public final Builder m13418a(ReactQueueConfigurationSpec reactQueueConfigurationSpec) {
            this.f11476a = reactQueueConfigurationSpec;
            return this;
        }

        public final Builder m13417a(NativeModuleRegistry nativeModuleRegistry) {
            this.f11478c = nativeModuleRegistry;
            return this;
        }

        public final Builder m13415a(JavaScriptModuleRegistry javaScriptModuleRegistry) {
            this.f11479d = javaScriptModuleRegistry;
            return this;
        }

        public final Builder m13413a(JSBundleLoader jSBundleLoader) {
            this.f11477b = jSBundleLoader;
            return this;
        }

        public final Builder m13414a(JavaScriptExecutor javaScriptExecutor) {
            this.f11480e = javaScriptExecutor;
            return this;
        }

        public final Builder m13416a(NativeModuleCallExceptionHandler nativeModuleCallExceptionHandler) {
            this.f11481f = nativeModuleCallExceptionHandler;
            return this;
        }

        public final CatalystInstanceImpl m13419a() {
            return new CatalystInstanceImpl((ReactQueueConfigurationSpec) Assertions.b(this.f11476a), (JavaScriptExecutor) Assertions.b(this.f11480e), (NativeModuleRegistry) Assertions.b(this.f11478c), (JavaScriptModuleRegistry) Assertions.b(this.f11479d), (JSBundleLoader) Assertions.b(this.f11477b), (NativeModuleCallExceptionHandler) Assertions.b(this.f11481f));
        }
    }

    /* compiled from: groups/ */
    class JSProfilerTraceListener implements TraceListener {
        final /* synthetic */ CatalystInstanceImpl f11482a;

        public JSProfilerTraceListener(CatalystInstanceImpl catalystInstanceImpl) {
            this.f11482a = catalystInstanceImpl;
        }

        public final void m13420a() {
            ((Systrace) this.f11482a.mo647a((ExecutorToken) Assertions.b(this.f11482a.f11496k), Systrace.class)).setEnabled(true);
        }

        public final void m13421b() {
            ((Systrace) this.f11482a.mo647a((ExecutorToken) Assertions.b(this.f11482a.f11496k), Systrace.class)).setEnabled(false);
        }
    }

    /* compiled from: groups/ */
    class NativeExceptionHandler implements QueueThreadExceptionHandler {
        final /* synthetic */ CatalystInstanceImpl f11484a;

        /* compiled from: groups/ */
        class C10131 implements Runnable {
            final /* synthetic */ NativeExceptionHandler f11483a;

            C10131(NativeExceptionHandler nativeExceptionHandler) {
                this.f11483a = nativeExceptionHandler;
            }

            public void run() {
                this.f11483a.f11484a.mo653b();
            }
        }

        public NativeExceptionHandler(CatalystInstanceImpl catalystInstanceImpl) {
            this.f11484a = catalystInstanceImpl;
        }

        public final void mo643a(Exception exception) {
            this.f11484a.f11500o.a(exception);
            this.f11484a.f11487b.mo707a().runOnQueue(new C10131(this));
        }
    }

    /* compiled from: groups/ */
    class NativeModulesReactCallback implements ReactCallback {
        final /* synthetic */ CatalystInstanceImpl f11485a;

        public NativeModulesReactCallback(CatalystInstanceImpl catalystInstanceImpl) {
            this.f11485a = catalystInstanceImpl;
        }

        public void call(ExecutorToken executorToken, int i, int i2, ReadableNativeArray readableNativeArray) {
            this.f11485a.f11487b.mo708b().assertIsOnThread();
            if (!this.f11485a.f11491f) {
                synchronized (this.f11485a.f11497l) {
                    if (this.f11485a.f11492g) {
                        return;
                    }
                    this.f11485a.f11499n.m13495a(this.f11485a, executorToken, i, i2, readableNativeArray);
                }
            }
        }

        public void onBatchComplete() {
            this.f11485a.f11487b.mo708b().assertIsOnThread();
            if (!this.f11485a.f11491f) {
                synchronized (this.f11485a.f11497l) {
                    if (this.f11485a.f11492g) {
                        return;
                    }
                    long j = 8192;
                    Systrace.a(8192, "onBatchComplete");
                    try {
                        this.f11485a.f11499n.m13500c();
                        Systrace.a(j);
                        this.f11485a.f11500o;
                    } finally {
                        j = 8192;
                        Systrace.a(8192);
                    }
                }
            }
        }

        public void onExecutorUnregistered(ExecutorToken executorToken) {
            this.f11485a.f11487b.mo708b().assertIsOnThread();
            if (!this.f11485a.f11491f) {
                synchronized (this.f11485a.f11497l) {
                    if (this.f11485a.f11492g) {
                        return;
                    }
                    Systrace.a(8192, "onExecutorUnregistered");
                    try {
                        this.f11485a.f11499n.m13496a(executorToken);
                        Systrace.a(8192);
                    } catch (Throwable th) {
                        Systrace.a(8192);
                    }
                }
            }
        }
    }

    private CatalystInstanceImpl(ReactQueueConfigurationSpec reactQueueConfigurationSpec, final JavaScriptExecutor javaScriptExecutor, NativeModuleRegistry nativeModuleRegistry, JavaScriptModuleRegistry javaScriptModuleRegistry, JSBundleLoader jSBundleLoader, NativeModuleCallExceptionHandler nativeModuleCallExceptionHandler) {
        this.f11489d = new AtomicInteger(0);
        this.f11490e = "pending_js_calls_instance" + f11486a.getAndIncrement();
        this.f11491f = false;
        this.f11492g = false;
        this.f11497l = new Object();
        this.f11498m = new Object();
        this.f11501p = false;
        this.f11487b = ReactQueueConfigurationImpl.m13581a(reactQueueConfigurationSpec, new NativeExceptionHandler(this));
        this.f11488c = new CopyOnWriteArrayList();
        this.f11499n = nativeModuleRegistry;
        this.f11494i = javaScriptModuleRegistry;
        this.f11495j = jSBundleLoader;
        this.f11500o = nativeModuleCallExceptionHandler;
        this.f11493h = new JSProfilerTraceListener(this);
        try {
            this.f11502q = (ReactBridge) FutureDetour.a(this.f11487b.mo709c().callOnQueue(new Callable<ReactBridge>(this) {
                final /* synthetic */ CatalystInstanceImpl f11471b;

                public Object call() {
                    Systrace.a(8192, "initializeBridge");
                    try {
                        Object a = this.f11471b.m13426a(javaScriptExecutor);
                        return a;
                    } finally {
                        Systrace.a(8192);
                    }
                }
            }), 617998829);
        } catch (Throwable e) {
            throw new RuntimeException("Failed to initialize bridge", e);
        }
    }

    private ReactBridge m13426a(JavaScriptExecutor javaScriptExecutor) {
        boolean z = false;
        this.f11487b.mo709c().assertIsOnThread();
        if (this.f11502q == null) {
            z = true;
        }
        ReactBridge reactBridge = "initializeBridge should be called once";
        Assertions.a(z, reactBridge);
        Systrace.a(8192, "ReactBridgeCtor");
        try {
            reactBridge = new ReactBridge(javaScriptExecutor, new NativeModulesReactCallback(this), this.f11487b.mo708b());
            this.f11496k = reactBridge.getMainExecutorToken();
            Systrace.a(8192, "setBatchedBridgeConfig");
            try {
                reactBridge.setGlobalVariable("__fbBatchedBridgeConfig", m13427a(this.f11499n));
                reactBridge.setGlobalVariable("__RCTProfileIsProfiling", TraceConfig.a(131072) ? "true" : "false");
                this.f11499n.m13498a(reactBridge);
                return reactBridge;
            } finally {
                Systrace.a(8192);
            }
        } finally {
            Systrace.a(8192);
        }
    }

    public final void mo649a() {
        this.f11487b.mo709c().assertIsOnThread();
        Assertions.a(!this.f11503r, "JS bundle was already loaded!");
        m13434g();
        Systrace.a(8192, "loadJSScript");
        try {
            this.f11495j.mo661a(this.f11502q);
            TraceConfig.a(this.f11493h);
        } catch (Exception e) {
            this.f11500o.a(e);
        } finally {
            Systrace.a(8192);
        }
        this.f11503r = true;
    }

    public void callFunction(ExecutorToken executorToken, String str, String str2, NativeArray nativeArray, String str3) {
        if (this.f11491f) {
            FLog.a("React", "Calling JS function after bridge has been destroyed.");
            return;
        }
        synchronized (this.f11498m) {
            if (this.f11492g) {
                FLog.a("React", "Calling JS function after bridge has been destroyed.");
                return;
            }
            m13434g();
            ((ReactBridge) Assertions.b(this.f11502q)).callFunction(executorToken, str, str2, nativeArray, str3);
        }
    }

    @DoNotStrip
    public void invokeCallback(ExecutorToken executorToken, int i, NativeArray nativeArray) {
        if (this.f11491f) {
            FLog.a("React", "Invoking JS callback after bridge has been destroyed.");
            return;
        }
        synchronized (this.f11498m) {
            if (this.f11492g) {
                FLog.a("React", "Invoking JS callback after bridge has been destroyed.");
                return;
            }
            m13434g();
            ((ReactBridge) Assertions.b(this.f11502q)).invokeCallback(executorToken, i, nativeArray);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo653b() {
        /*
        r5 = this;
        r1 = 0;
        r0 = 1;
        com.facebook.react.bridge.UiThreadUtil.m13554b();
        r5.f11491f = r0;
        r2 = r5.f11497l;
        monitor-enter(r2);
        r3 = r5.f11498m;	 Catch:{ all -> 0x0056 }
        monitor-enter(r3);	 Catch:{ all -> 0x0056 }
        r4 = r5.f11492g;	 Catch:{ all -> 0x0053 }
        if (r4 == 0) goto L_0x0014;
    L_0x0011:
        monitor-exit(r3);	 Catch:{ all -> 0x0053 }
        monitor-exit(r2);	 Catch:{  }
    L_0x0013:
        return;
    L_0x0014:
        r4 = 1;
        r5.f11492g = r4;	 Catch:{  }
        r4 = r5.f11499n;	 Catch:{  }
        r4.m13494a();	 Catch:{  }
        r4 = r5.f11493h;	 Catch:{  }
        com.facebook.systrace.TraceConfig.b(r4);	 Catch:{  }
        r5.m13433f();	 Catch:{  }
        monitor-exit(r3);	 Catch:{  }
        monitor-exit(r2);	 Catch:{  }
        r2 = r5.f11487b;
        r2.m13585d();
        r2 = r5.f11489d;
        r2 = r2.getAndSet(r1);
        if (r2 != 0) goto L_0x0059;
    L_0x0033:
        if (r0 != 0) goto L_0x0013;
    L_0x0035:
        r0 = r5.f11488c;
        r0 = r0.isEmpty();
        if (r0 != 0) goto L_0x0013;
    L_0x003d:
        r0 = r5.f11488c;
        r1 = r0.iterator();
    L_0x0043:
        r0 = r1.hasNext();
        if (r0 == 0) goto L_0x0013;
    L_0x0049:
        r0 = r1.next();
        r0 = (com.facebook.react.bridge.NotThreadSafeBridgeIdleDebugListener) r0;
        r0.mo727a();
        goto L_0x0043;
    L_0x0053:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0056:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{  }
        throw r0;
    L_0x0059:
        r0 = r1;
        goto L_0x0033;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.bridge.CatalystInstanceImpl.b():void");
    }

    private void m13433f() {
        final SimpleSettableFuture simpleSettableFuture = new SimpleSettableFuture();
        this.f11487b.mo709c().runOnQueue(new Runnable(this) {
            final /* synthetic */ CatalystInstanceImpl f11473b;

            public void run() {
                this.f11473b.f11502q.destroy();
                this.f11473b.f11502q.dispose();
                simpleSettableFuture.m13617a(null);
            }
        });
        simpleSettableFuture.m13615a();
    }

    public final boolean mo655c() {
        return this.f11492g;
    }

    @VisibleForTesting
    public final void mo657d() {
        UiThreadUtil.m13554b();
        Assertions.a(!this.f11501p, "This catalyst instance has already been initialized");
        this.f11501p = true;
        this.f11499n.m13499b();
    }

    public final ReactQueueConfiguration mo658e() {
        return this.f11487b;
    }

    public final <T extends JavaScriptModule> T mo648a(Class<T> cls) {
        return mo647a((ExecutorToken) Assertions.b(this.f11496k), (Class) cls);
    }

    public final <T extends JavaScriptModule> T mo647a(ExecutorToken executorToken, Class<T> cls) {
        return ((JavaScriptModuleRegistry) Assertions.b(this.f11494i)).m13468a(this, executorToken, cls);
    }

    public final <T extends NativeModule> T mo652b(Class<T> cls) {
        return this.f11499n.m13493a((Class) cls);
    }

    public final void mo650a(final MemoryPressure memoryPressure) {
        this.f11487b.mo709c().runOnQueue(new Runnable(this) {
            final /* synthetic */ CatalystInstanceImpl f11475b;

            public void run() {
                ((ReactBridge) Assertions.b(this.f11475b.f11502q)).m13538a(memoryPressure);
            }
        });
    }

    public final void mo651a(NotThreadSafeBridgeIdleDebugListener notThreadSafeBridgeIdleDebugListener) {
        this.f11488c.add(notThreadSafeBridgeIdleDebugListener);
    }

    public final void mo654b(NotThreadSafeBridgeIdleDebugListener notThreadSafeBridgeIdleDebugListener) {
        this.f11488c.remove(notThreadSafeBridgeIdleDebugListener);
    }

    private static String m13427a(NativeModuleRegistry nativeModuleRegistry) {
        Writer stringWriter = new StringWriter();
        JsonWriter jsonWriter = new JsonWriter(stringWriter);
        try {
            jsonWriter.m13482c();
            jsonWriter.m13478a("remoteModuleConfig");
            nativeModuleRegistry.m13497a(jsonWriter);
            jsonWriter.m13484d();
            String stringWriter2 = stringWriter.toString();
            try {
                jsonWriter.close();
            } catch (IOException e) {
            }
            return stringWriter2;
        } catch (Throwable e2) {
            throw new RuntimeException("Unable to serialize JavaScript module declaration", e2);
        } catch (Throwable th) {
            try {
                jsonWriter.close();
            } catch (IOException e3) {
            }
        }
    }

    private void m13434g() {
        int andIncrement = this.f11489d.getAndIncrement();
        Object obj = andIncrement == 0 ? 1 : null;
        Systrace.a(8192, this.f11490e, andIncrement + 1);
        if (obj != null && !this.f11488c.isEmpty()) {
            Iterator it = this.f11488c.iterator();
            while (it.hasNext()) {
                ((NotThreadSafeBridgeIdleDebugListener) it.next()).mo728b();
            }
        }
    }

    public static void m13437h(CatalystInstanceImpl catalystInstanceImpl) {
        int decrementAndGet = catalystInstanceImpl.f11489d.decrementAndGet();
        Object obj = decrementAndGet == 0 ? 1 : null;
        Systrace.a(8192, catalystInstanceImpl.f11490e, decrementAndGet);
        if (obj != null && !catalystInstanceImpl.f11488c.isEmpty()) {
            Iterator it = catalystInstanceImpl.f11488c.iterator();
            while (it.hasNext()) {
                ((NotThreadSafeBridgeIdleDebugListener) it.next()).mo727a();
            }
        }
    }

    protected void finalize() {
        Assertions.a(this.f11492g, "Bridge was not destroyed before finalizer!");
        super.finalize();
    }
}
