package com.facebook.react.cxxbridge;

import android.content.res.AssetManager;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.ExecutorToken;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.JavaScriptModuleRegistry;
import com.facebook.react.bridge.MemoryPressure;
import com.facebook.react.bridge.NativeArray;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.NativeModuleCallExceptionHandler;
import com.facebook.react.bridge.NotThreadSafeBridgeIdleDebugListener;
import com.facebook.react.bridge.Systrace;
import com.facebook.react.bridge.queue.MessageQueueThread;
import com.facebook.react.bridge.queue.QueueThreadExceptionHandler;
import com.facebook.react.bridge.queue.ReactQueueConfiguration;
import com.facebook.react.bridge.queue.ReactQueueConfigurationImpl;
import com.facebook.react.bridge.queue.ReactQueueConfigurationSpec;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.soloader.SoLoader;
import com.facebook.systrace.TraceConfig;
import com.facebook.systrace.TraceListener;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;

@DoNotStrip
/* compiled from: groups/ */
public class CatalystInstanceImpl implements CatalystInstance {
    private static final AtomicInteger f11598a = new AtomicInteger(1);
    private final ReactQueueConfigurationImpl f11599b;
    private final CopyOnWriteArrayList<NotThreadSafeBridgeIdleDebugListener> f11600c;
    private final AtomicInteger f11601d;
    private final String f11602e;
    private volatile boolean f11603f;
    private final TraceListener f11604g;
    private final JavaScriptModuleRegistry f11605h;
    private final JSBundleLoader f11606i;
    private ExecutorToken f11607j;
    public final NativeModuleRegistry f11608k;
    private final NativeModuleCallExceptionHandler f11609l;
    private boolean f11610m;
    private final HybridData mHybridData;
    private boolean f11611n;

    /* compiled from: groups/ */
    class C10241 implements Runnable {
        final /* synthetic */ CatalystInstanceImpl f11587a;

        C10241(CatalystInstanceImpl catalystInstanceImpl) {
            this.f11587a = catalystInstanceImpl;
        }

        public void run() {
            this.f11587a.mo653b();
        }
    }

    /* compiled from: groups/ */
    class BridgeCallback implements ReactCallback {
        private final WeakReference<CatalystInstanceImpl> f11589a;

        public BridgeCallback(CatalystInstanceImpl catalystInstanceImpl) {
            this.f11589a = new WeakReference(catalystInstanceImpl);
        }

        public void onBatchComplete() {
            CatalystInstanceImpl catalystInstanceImpl = (CatalystInstanceImpl) this.f11589a.get();
            if (catalystInstanceImpl != null) {
                catalystInstanceImpl.f11608k.m13675c();
            }
        }

        public void incrementPendingJSCalls() {
            CatalystInstanceImpl catalystInstanceImpl = (CatalystInstanceImpl) this.f11589a.get();
            if (catalystInstanceImpl != null) {
                CatalystInstanceImpl.m13640f(catalystInstanceImpl);
            }
        }

        public void decrementPendingJSCalls() {
            CatalystInstanceImpl catalystInstanceImpl = (CatalystInstanceImpl) this.f11589a.get();
            if (catalystInstanceImpl != null) {
                CatalystInstanceImpl.m13641g(catalystInstanceImpl);
            }
        }

        public void onNativeException(Exception exception) {
            CatalystInstanceImpl catalystInstanceImpl = (CatalystInstanceImpl) this.f11589a.get();
            if (catalystInstanceImpl != null) {
                catalystInstanceImpl.m13637a(exception);
            }
        }
    }

    /* compiled from: groups/ */
    public class Builder {
        @Nullable
        private ReactQueueConfigurationSpec f11590a;
        @Nullable
        private JSBundleLoader f11591b;
        @Nullable
        private NativeModuleRegistry f11592c;
        @Nullable
        private JavaScriptModuleRegistry f11593d;
        @Nullable
        private JavaScriptExecutor f11594e;
        @Nullable
        private NativeModuleCallExceptionHandler f11595f;

        public final Builder m13627a(ReactQueueConfigurationSpec reactQueueConfigurationSpec) {
            this.f11590a = reactQueueConfigurationSpec;
            return this;
        }

        public final Builder m13630a(NativeModuleRegistry nativeModuleRegistry) {
            this.f11592c = nativeModuleRegistry;
            return this;
        }

        public final Builder m13625a(JavaScriptModuleRegistry javaScriptModuleRegistry) {
            this.f11593d = javaScriptModuleRegistry;
            return this;
        }

        public final Builder m13628a(JSBundleLoader jSBundleLoader) {
            this.f11591b = jSBundleLoader;
            return this;
        }

        public final Builder m13629a(JavaScriptExecutor javaScriptExecutor) {
            this.f11594e = javaScriptExecutor;
            return this;
        }

        public final Builder m13626a(NativeModuleCallExceptionHandler nativeModuleCallExceptionHandler) {
            this.f11595f = nativeModuleCallExceptionHandler;
            return this;
        }

        public final CatalystInstanceImpl m13631a() {
            return new CatalystInstanceImpl((ReactQueueConfigurationSpec) Assertions.b(this.f11590a), (JavaScriptExecutor) Assertions.b(this.f11594e), (NativeModuleRegistry) Assertions.b(this.f11592c), (JavaScriptModuleRegistry) Assertions.b(this.f11593d), (JSBundleLoader) Assertions.b(this.f11591b), (NativeModuleCallExceptionHandler) Assertions.b(this.f11595f));
        }
    }

    /* compiled from: groups/ */
    class JSProfilerTraceListener implements TraceListener {
        private final WeakReference<CatalystInstanceImpl> f11596a;

        public JSProfilerTraceListener(CatalystInstanceImpl catalystInstanceImpl) {
            this.f11596a = new WeakReference(catalystInstanceImpl);
        }

        public final void m13632a() {
            CatalystInstanceImpl catalystInstanceImpl = (CatalystInstanceImpl) this.f11596a.get();
            if (catalystInstanceImpl != null) {
                ((Systrace) catalystInstanceImpl.mo648a(Systrace.class)).setEnabled(true);
            }
        }

        public final void m13633b() {
            CatalystInstanceImpl catalystInstanceImpl = (CatalystInstanceImpl) this.f11596a.get();
            if (catalystInstanceImpl != null) {
                ((Systrace) catalystInstanceImpl.mo648a(Systrace.class)).setEnabled(false);
            }
        }
    }

    /* compiled from: groups/ */
    class NativeExceptionHandler implements QueueThreadExceptionHandler {
        final /* synthetic */ CatalystInstanceImpl f11597a;

        public NativeExceptionHandler(CatalystInstanceImpl catalystInstanceImpl) {
            this.f11597a = catalystInstanceImpl;
        }

        public final void mo643a(Exception exception) {
            this.f11597a.m13637a(exception);
        }
    }

    private native void callJSCallback(ExecutorToken executorToken, int i, NativeArray nativeArray);

    private native void callJSFunction(ExecutorToken executorToken, String str, String str2, NativeArray nativeArray, String str3);

    private native ExecutorToken getMainExecutorToken();

    private native void handleMemoryPressureCritical();

    private native void handleMemoryPressureModerate();

    private native void handleMemoryPressureUiHidden();

    private static native HybridData initHybrid();

    private native void initializeBridge(ReactCallback reactCallback, JavaScriptExecutor javaScriptExecutor, MessageQueueThread messageQueueThread, MessageQueueThread messageQueueThread2, ModuleRegistryHolder moduleRegistryHolder);

    native void loadScriptFromAssets(AssetManager assetManager, String str);

    native void loadScriptFromFile(String str, String str2);

    public native void setGlobalVariable(String str, String str2);

    public native void startProfiler(String str);

    public native void stopProfiler(String str, String str2);

    public native boolean supportsProfiling();

    static {
        SoLoader.a("reactnativejnifb");
    }

    private CatalystInstanceImpl(ReactQueueConfigurationSpec reactQueueConfigurationSpec, JavaScriptExecutor javaScriptExecutor, NativeModuleRegistry nativeModuleRegistry, JavaScriptModuleRegistry javaScriptModuleRegistry, JSBundleLoader jSBundleLoader, NativeModuleCallExceptionHandler nativeModuleCallExceptionHandler) {
        this.f11601d = new AtomicInteger(0);
        this.f11602e = "pending_js_calls_instance" + f11598a.getAndIncrement();
        this.f11603f = false;
        this.f11610m = false;
        this.mHybridData = initHybrid();
        this.f11599b = ReactQueueConfigurationImpl.m13581a(reactQueueConfigurationSpec, new NativeExceptionHandler(this));
        this.f11600c = new CopyOnWriteArrayList();
        this.f11608k = nativeModuleRegistry;
        this.f11605h = javaScriptModuleRegistry;
        this.f11606i = jSBundleLoader;
        this.f11609l = nativeModuleCallExceptionHandler;
        this.f11604g = new JSProfilerTraceListener(this);
        initializeBridge(new BridgeCallback(this), javaScriptExecutor, this.f11599b.mo709c(), this.f11599b.mo708b(), this.f11608k.m13672a(this));
        this.f11607j = getMainExecutorToken();
    }

    public final void mo649a() {
        Assertions.a(!this.f11611n, "JS bundle was already loaded!");
        this.f11611n = true;
        this.f11606i.mo715a(this);
        TraceConfig.a(this.f11604g);
    }

    public void callFunction(ExecutorToken executorToken, String str, String str2, NativeArray nativeArray, String str3) {
        if (this.f11603f) {
            FLog.a("React", "Calling JS function after bridge has been destroyed.");
        } else {
            callJSFunction(executorToken, str, str2, nativeArray, str3);
        }
    }

    public void invokeCallback(ExecutorToken executorToken, int i, NativeArray nativeArray) {
        if (this.f11603f) {
            FLog.a("React", "Invoking JS callback after bridge has been destroyed.");
        } else {
            callJSCallback(executorToken, i, nativeArray);
        }
    }

    public final void mo653b() {
        boolean z = true;
        UiThreadUtil.m13677a();
        if (!this.f11603f) {
            this.f11603f = true;
            this.mHybridData.resetNative();
            this.f11608k.m13673a();
            if (this.f11601d.getAndSet(0) != 0) {
                z = false;
            }
            if (!(z || this.f11600c.isEmpty())) {
                Iterator it = this.f11600c.iterator();
                while (it.hasNext()) {
                    ((NotThreadSafeBridgeIdleDebugListener) it.next()).mo727a();
                }
            }
            TraceConfig.b(this.f11604g);
        }
    }

    public final boolean mo655c() {
        return this.f11603f;
    }

    @VisibleForTesting
    public final void mo657d() {
        UiThreadUtil.m13677a();
        Assertions.a(!this.f11610m, "This catalyst instance has already been initialized");
        this.f11610m = true;
        this.f11608k.m13674b();
    }

    public final ReactQueueConfiguration mo658e() {
        return this.f11599b;
    }

    public final <T extends JavaScriptModule> T mo648a(Class<T> cls) {
        return mo647a(this.f11607j, (Class) cls);
    }

    public final <T extends JavaScriptModule> T mo647a(ExecutorToken executorToken, Class<T> cls) {
        return ((JavaScriptModuleRegistry) Assertions.b(this.f11605h)).m13468a(this, executorToken, cls);
    }

    public final <T extends NativeModule> T mo652b(Class<T> cls) {
        return this.f11608k.m13671a((Class) cls);
    }

    public final void mo650a(MemoryPressure memoryPressure) {
        if (!this.f11603f) {
            switch (memoryPressure) {
                case UI_HIDDEN:
                    handleMemoryPressureUiHidden();
                    return;
                case MODERATE:
                    handleMemoryPressureModerate();
                    return;
                case CRITICAL:
                    handleMemoryPressureCritical();
                    return;
                default:
                    return;
            }
        }
    }

    public final void mo651a(NotThreadSafeBridgeIdleDebugListener notThreadSafeBridgeIdleDebugListener) {
        this.f11600c.add(notThreadSafeBridgeIdleDebugListener);
    }

    public final void mo654b(NotThreadSafeBridgeIdleDebugListener notThreadSafeBridgeIdleDebugListener) {
        this.f11600c.remove(notThreadSafeBridgeIdleDebugListener);
    }

    public static void m13640f(CatalystInstanceImpl catalystInstanceImpl) {
        int andIncrement = catalystInstanceImpl.f11601d.getAndIncrement();
        Object obj = andIncrement == 0 ? 1 : null;
        com.facebook.systrace.Systrace.a(8192, catalystInstanceImpl.f11602e, andIncrement + 1);
        if (obj != null && !catalystInstanceImpl.f11600c.isEmpty()) {
            Iterator it = catalystInstanceImpl.f11600c.iterator();
            while (it.hasNext()) {
                ((NotThreadSafeBridgeIdleDebugListener) it.next()).mo728b();
            }
        }
    }

    public static void m13641g(CatalystInstanceImpl catalystInstanceImpl) {
        int decrementAndGet = catalystInstanceImpl.f11601d.decrementAndGet();
        Object obj = decrementAndGet == 0 ? 1 : null;
        com.facebook.systrace.Systrace.a(8192, catalystInstanceImpl.f11602e, decrementAndGet);
        if (obj != null && !catalystInstanceImpl.f11600c.isEmpty()) {
            Iterator it = catalystInstanceImpl.f11600c.iterator();
            while (it.hasNext()) {
                ((NotThreadSafeBridgeIdleDebugListener) it.next()).mo727a();
            }
        }
    }

    private void m13637a(Exception exception) {
        this.f11609l.a(exception);
        this.f11599b.mo707a().runOnQueue(new C10241(this));
    }
}
