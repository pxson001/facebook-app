package com.facebook.common.perftest.base;

import com.facebook.androidinternals.android.os.SystemPropertiesInternal;
import com.facebook.proguard.annotations.DoNotStrip;
import javax.annotation.Nullable;

@DoNotStrip
/* compiled from: use_service */
public class PerfTestConfigBase {
    public static boolean f1506a = false;
    public static boolean f1507b = false;
    public static boolean f1508c = false;
    public static boolean f1509d = false;
    public static long f1510e;
    public static boolean f1511f = false;
    private static boolean f1512g = false;
    public static boolean f1513h = false;
    public static boolean f1514i = false;
    public static boolean f1515j = false;
    public static boolean f1516k = true;
    public static long f1517l;
    public static boolean f1518m = false;
    public static boolean f1519n = false;
    public static boolean f1520o = false;
    public static boolean f1521p = false;
    public static boolean f1522q = false;
    public static boolean f1523r = false;
    private static boolean f1524s = false;
    private static boolean f1525t = false;
    @Nullable
    public static String f1526u = null;
    private static PerfTestConfigBase f1527v = null;

    /* compiled from: use_service */
    public class MainLoader {
        public static final boolean f2039a;
        public static final boolean f2040b = Boolean.getBoolean("use_liger");
        public static final boolean f2041c = Boolean.getBoolean("use_okhttp");

        static {
            boolean z = Boolean.getBoolean("is_perf_testing") || "1".equals(SystemPropertiesInternal.a("persist.facebook.LogPerf"));
            f2039a = z;
        }
    }

    protected PerfTestConfigBase() {
    }

    @DoNotStrip
    public static PerfTestConfigBase getInstance() {
        if (f1527v == null) {
            f1527v = new PerfTestConfigBase();
        }
        return f1527v;
    }

    public static boolean m2938a() {
        if (f1524s) {
            return f1525t;
        }
        return MainLoader.f2039a;
    }

    public static boolean m2939b() {
        return MainLoader.f2039a && SubLoader.a;
    }

    public final boolean m2943c() {
        return m2938a() && SubLoader.b;
    }

    @DoNotStrip
    public void setAlwaysLogImagePipelinePerf(boolean z) {
        f1519n = z;
    }

    @DoNotStrip
    public void setAlwaysLogDraweePerf(boolean z) {
        f1518m = z;
    }

    @DoNotStrip
    public void setAlwaysLogComponentsPerf(boolean z) {
        f1520o = z;
    }

    @DoNotStrip
    public void setPlacePickerSuppressLocationSourceDialog(boolean z) {
        f1515j = z;
    }

    @DoNotStrip
    public void setPlacePickerForceMockedLocation(boolean z) {
        f1514i = z;
    }

    @DoNotStrip
    public void setPlacePickerFlowsEnabled(boolean z) {
        f1516k = z;
    }

    @DoNotStrip
    public void setPlacePickerTimeoutMs(long j) {
        f1517l = j;
    }

    @DoNotStrip
    public void setDisableAnalyticsLogging(boolean z) {
        f1506a = z;
    }

    public static boolean m2940k() {
        return f1506a;
    }

    @DoNotStrip
    public void setForceRefreshNewsFeedOnResume(boolean z) {
        f1507b = z;
    }

    @DoNotStrip
    public void setAllowMainTabActivityKillingOnBackPressHandler(boolean z) {
        f1508c = z;
    }

    @DoNotStrip
    public void setFeedImagePreloaderDisabled(boolean z) {
        f1513h = z;
    }

    @DoNotStrip
    public void setDisableNewsFeedAutoRefresh(boolean z) {
        f1509d = z;
    }

    @DoNotStrip
    public void setForceSkipTimelineCache(boolean z) {
        f1511f = z;
    }

    public static boolean m2941p() {
        return f1511f;
    }

    @DoNotStrip
    public void setUseApiRequestCache(boolean z) {
        f1512g = z;
    }

    public static boolean m2942q() {
        return f1512g;
    }

    @DoNotStrip
    public void setDisablePrefetchControllerMemoryCacheFastpath(boolean z) {
        f1521p = z;
    }

    @DoNotStrip
    public void setSychronousPerfLoggerEvents(boolean z) {
        f1523r = z;
    }

    @DoNotStrip
    public void setDisablePerfLogging(boolean z) {
        f1522q = z;
    }

    @DoNotStrip
    public void setPerfTestInfo(String str) {
        f1526u = str;
    }
}
