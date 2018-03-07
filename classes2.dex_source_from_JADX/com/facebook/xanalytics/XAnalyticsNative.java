package com.facebook.xanalytics;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;
import com.facebook.tigon.iface.TigonServiceHolder;

@DoNotStrip
/* compiled from: mAnimatingAway= */
public class XAnalyticsNative extends XAnalyticsHolder {
    protected static String f15724a = "graph.facebook.com";
    protected long f15725b = 0;
    protected TigonServiceHolder f15726c = null;

    @DoNotStrip
    /* compiled from: mAnimatingAway= */
    public interface XAnalyticsPropertiesProvider {
        @DoNotStrip
        String[] get();
    }

    private static native HybridData initHybrid();

    public native void cleanup();

    protected native int countFlushed();

    public native void flush();

    protected native String[] getFlushed();

    public native long init(String[] strArr, XAnalyticsPropertiesProvider xAnalyticsPropertiesProvider, TigonServiceHolder tigonServiceHolder, int i, int i2);

    public native boolean isInitialized();

    public native void logCounter(String str, long j);

    public native void logEvent(String str, String str2, String str3);

    public native void logRealtimeEvent(String str, String str2, String str3);

    public native void logSampledEvent(String str, String str2, int i, String str3);

    public native void onSwitchUserId();

    public native void resumeUploading(String str);

    public native void saveCounters();

    public native void setResponseListener(XAnalyticsResponseListener xAnalyticsResponseListener);

    public native long updateTigonInstance(String str, String str2, TigonServiceHolder tigonServiceHolder);

    static {
        SoLoader.a("fbacore-jni");
    }

    public XAnalyticsNative() {
        super(initHybrid());
    }

    public final long m22407a(XAnalyticsParams xAnalyticsParams, XAnalyticsPropertiesProvider xAnalyticsPropertiesProvider) {
        String[] strArr = new String[]{xAnalyticsParams.f16175a, xAnalyticsParams.f16176b, xAnalyticsParams.f16177c, xAnalyticsParams.f16178d};
        if (strArr[3] == null || strArr[3].length() == 0) {
            strArr[3] = f15724a;
        }
        return init(strArr, xAnalyticsPropertiesProvider, xAnalyticsParams.f16181g, xAnalyticsParams.f16179e, xAnalyticsParams.f16180f);
    }

    public final void m22408a(String str, String str2) {
        logEvent(str, str2, "");
    }
}
