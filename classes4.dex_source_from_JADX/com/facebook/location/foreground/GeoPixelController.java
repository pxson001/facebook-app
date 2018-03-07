package com.facebook.location.foreground;

import android.annotation.SuppressLint;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.BaseAnalyticsConfig;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsConfig;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.hardware.CellDiagnosticsSerializer;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.http.common.FbHttpRequestProcessor;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.katana.orca.FbAnalyticsConfig;
import com.facebook.location.FbLocationStatusUtil;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.telephony.FbTelephonyManager;
import com.facebook.xconfig.core.XConfigReader;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.json.JSONObject;

@Singleton
/* compiled from: is_resend */
public class GeoPixelController {
    public static final String f9894a = GeoPixelController.class.getSimpleName();
    public static final CallerContext f9895b = CallerContext.a(GeoPixelController.class);
    public static final Random f9896c = new Random();
    public static final Pattern f9897d = Pattern.compile("From (.*?)(([\\d]{1,3})\\.([\\d]{1,3})\\.([\\d]{1,3})\\.([\\d]{1,3})).*");
    public static final Pattern f9898e = Pattern.compile(".*bytes from.*time=(\\d+\\.?\\d*)");
    private static volatile GeoPixelController f9899q;
    public final XConfigReader f9900f;
    public final BaseAnalyticsConfig f9901g;
    public final AnalyticsLogger f9902h;
    public final QeAccessor f9903i;
    public final AbstractFbErrorReporter f9904j;
    public final Lazy<FbNetworkManager> f9905k;
    public final Lazy<CellDiagnosticsSerializer> f9906l;
    public final FbLocationStatusUtil f9907m;
    public final ListeningExecutorService f9908n;
    private final FbTelephonyManager f9909o;
    public final FbHttpRequestProcessor f9910p;

    public static com.facebook.location.foreground.GeoPixelController m10288a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f9899q;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.location.foreground.GeoPixelController.class;
        monitor-enter(r1);
        r0 = f9899q;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m10294b(r0);	 Catch:{ all -> 0x0035 }
        f9899q = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9899q;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.location.foreground.GeoPixelController.a(com.facebook.inject.InjectorLike):com.facebook.location.foreground.GeoPixelController");
    }

    private static GeoPixelController m10294b(InjectorLike injectorLike) {
        return new GeoPixelController(XConfigReader.a(injectorLike), (BaseAnalyticsConfig) FbAnalyticsConfig.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 544), IdBasedSingletonScopeProvider.b(injectorLike, 585), FbLocationStatusUtil.a(injectorLike), FbHttpRequestProcessor.a(injectorLike), FbTelephonyManager.b(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public GeoPixelController(XConfigReader xConfigReader, AnalyticsConfig analyticsConfig, AnalyticsLogger analyticsLogger, QeAccessor qeAccessor, FbErrorReporter fbErrorReporter, Lazy<CellDiagnosticsSerializer> lazy, Lazy<FbNetworkManager> lazy2, FbLocationStatusUtil fbLocationStatusUtil, FbHttpRequestProcessor fbHttpRequestProcessor, FbTelephonyManager fbTelephonyManager, ListeningExecutorService listeningExecutorService) {
        this.f9900f = xConfigReader;
        this.f9901g = analyticsConfig;
        this.f9902h = analyticsLogger;
        this.f9903i = qeAccessor;
        this.f9904j = fbErrorReporter;
        this.f9906l = lazy;
        this.f9905k = lazy2;
        this.f9907m = fbLocationStatusUtil;
        this.f9908n = listeningExecutorService;
        this.f9909o = fbTelephonyManager;
        this.f9910p = fbHttpRequestProcessor;
    }

    @SuppressLint({"BadMethodUse-java.lang.String.length"})
    @Nullable
    public static String m10291a(GeoPixelController geoPixelController, int i) {
        String g = geoPixelController.f9909o.g(i);
        return (g == null || g.length() < 7 || !g.startsWith("1")) ? null : g.substring(0, 7);
    }

    @Nullable
    public static Integer m10295b(HttpResponse httpResponse) {
        Integer num = null;
        Header firstHeader = httpResponse.getFirstHeader("X-FB-Connection-Quality");
        if (firstHeader != null) {
            String value = firstHeader.getValue();
            if (value != null) {
                int indexOf = value.indexOf("rtt=");
                if (indexOf != -1) {
                    int indexOf2 = value.indexOf(44, indexOf);
                    if (indexOf2 != -1) {
                        try {
                            num = Integer.valueOf(Integer.parseInt(value.substring(indexOf + 4, indexOf2)));
                        } catch (NumberFormatException e) {
                        }
                    }
                }
            }
        }
        return num;
    }

    @Nullable
    private static List<String> m10292a(String str, Integer num, int i, float f, float f2) {
        List arrayList = new ArrayList();
        arrayList.add("ping");
        arrayList.add("-c");
        arrayList.add(Integer.toString(i));
        arrayList.add("-w");
        arrayList.add(Float.toString(f));
        arrayList.add("-i");
        arrayList.add(Float.toString(f2));
        if (num != null) {
            arrayList.add("-t");
            arrayList.add(Integer.toString(num.intValue()));
        }
        arrayList.add(str);
        ProcessBuilder processBuilder = new ProcessBuilder(arrayList);
        List<String> arrayList2 = new ArrayList();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(processBuilder.start().getInputStream()));
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return arrayList2;
            }
            arrayList2.add(readLine);
        }
    }

    @Nullable
    private static String m10290a(int i, String str, float f, float f2) {
        String group;
        for (String group2 : m10292a(str, Integer.valueOf(i), 1, f, f2)) {
            Matcher matcher = f9897d.matcher(group2);
            if (matcher.find() && matcher.groupCount() >= 2) {
                group2 = matcher.group(2);
                break;
            }
        }
        group2 = null;
        return group2;
    }

    private static Float m10289a(String str, int i, float f, float f2) {
        int i2 = 0;
        float f3 = 0.0f;
        for (String matcher : m10292a(str, null, i, f, f2)) {
            float floatValue;
            int i3;
            Matcher matcher2 = f9898e.matcher(matcher);
            if (matcher2.find() && matcher2.groupCount() > 0) {
                Float valueOf = Float.valueOf(Float.parseFloat(matcher2.group(1)));
                if (valueOf != null) {
                    floatValue = f3 + valueOf.floatValue();
                    i3 = i2 + 1;
                    i2 = i3;
                    f3 = floatValue;
                }
            }
            floatValue = f3;
            i3 = i2;
            i2 = i3;
            f3 = floatValue;
        }
        return i2 <= 0 ? null : Float.valueOf(f3 / ((float) i2));
    }

    @Nullable
    private static JSONObject m10296b(int i, int i2, String str, float f, float f2, AnalyticsLogger analyticsLogger) {
        JSONObject jSONObject = new JSONObject();
        int i3 = 1;
        while (i3 <= i) {
            try {
                String a = m10290a(i3, str, f, f2);
                if (a != null) {
                    Float a2 = m10289a(a, i2, f, f2);
                    if (a2 == null) {
                        HoneyClientEventFast a3 = analyticsLogger.a("geopixel_ping_failed", false);
                        if (a3.a()) {
                            a3.a("ping_failure", "ping_address_failure");
                            a3.a("ping_failure_address", a);
                            a3.b();
                        }
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("ping_ip", a);
                    jSONObject2.put("ping_rtt", a2);
                    jSONObject.put(Integer.toString(i3), jSONObject2);
                }
                i3++;
            } catch (Exception e) {
                HoneyClientEventFast a4 = analyticsLogger.a("geopixel_ping_failed", false);
                if (a4.a()) {
                    a4.a("ping_failure", "ping_process_failure");
                    a4.b();
                }
                return null;
            }
        }
        return jSONObject;
    }
}
