package com.facebook.react.bridge;

import android.content.res.AssetManager;
import com.facebook.jni.Countable;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.queue.MessageQueueThread;
import com.facebook.soloader.SoLoader;
import javax.annotation.Nullable;

@DoNotStrip
/* compiled from: graph.internet.org */
public class ReactBridge extends Countable {
    private final ReactCallback f11545a;
    private final JavaScriptExecutor f11546b;
    private final MessageQueueThread f11547c;

    private native void handleMemoryPressureCritical();

    private native void handleMemoryPressureModerate();

    private native void handleMemoryPressureUiHidden();

    private native void initialize(JavaScriptExecutor javaScriptExecutor, ReactCallback reactCallback, MessageQueueThread messageQueueThread);

    public native void callFunction(ExecutorToken executorToken, String str, String str2, NativeArray nativeArray, String str3);

    public native void destroy();

    public native long getJavaScriptContextNativePtrExperimental();

    public native ExecutorToken getMainExecutorToken();

    public native void invokeCallback(ExecutorToken executorToken, int i, NativeArray nativeArray);

    public native void loadScriptFromAssets(AssetManager assetManager, String str);

    public native void loadScriptFromFile(@Nullable String str, @Nullable String str2);

    public native void setGlobalVariable(String str, String str2);

    public native void startProfiler(String str);

    public native void stopProfiler(String str, String str2);

    public native boolean supportsProfiling();

    static {
        SoLoader.a("reactnativejni");
    }

    public ReactBridge(JavaScriptExecutor javaScriptExecutor, ReactCallback reactCallback, MessageQueueThread messageQueueThread) {
        this.f11546b = javaScriptExecutor;
        this.f11545a = reactCallback;
        this.f11547c = messageQueueThread;
        initialize(javaScriptExecutor, reactCallback, this.f11547c);
    }

    public void dispose() {
        this.f11546b.mo667a();
        this.f11546b.dispose();
        super.dispose();
    }

    public final void m13538a(MemoryPressure memoryPressure) {
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
                throw new IllegalArgumentException("Unknown level: " + memoryPressure);
        }
    }
}
