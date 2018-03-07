package com.facebook.abtest.qe.log;

import android.os.Bundle;
import com.facebook.abtest.qe.analytics.QuickExperimentAnalyticsEvent;
import com.facebook.abtest.qe.analytics.QuickExperimentAnalyticsEvent.QuickExperimentEventType;
import com.facebook.abtest.qe.bootstrap.data.QuickExperimentInfo;
import com.facebook.abtest.qe.protocol.sync.QuickExperimentLoggingParams.Builder;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.process.DefaultProcessUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.crudolib.prefs.LightSharedPreferencesFactory;
import com.facebook.crudolib.prefs.LightSharedPreferencesImpl;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.light.LightSharedPreferencesFactoryMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Optional;
import com.google.common.collect.Maps;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: unspecified */
public class QuickExperimentLogger {
    private static final Class<QuickExperimentLogger> f1866a = QuickExperimentLogger.class;
    private static volatile QuickExperimentLogger f1867h;
    public final Clock f1868b;
    private final AnalyticsLogger f1869c;
    private final DefaultBlueServiceOperationFactory f1870d;
    private final DefaultProcessUtil f1871e;
    public final LightSharedPreferencesFactory f1872f;
    @GuardedBy("this")
    @Nullable
    private Map<String, Long> f1873g = null;

    /* compiled from: unspecified */
    public enum LoggingChannel {
        QUICK_EXPERIMENT,
        MARAUDER,
        NO_CHANNEL;

        public static LoggingChannel valueOfIgnoreCase(String str) {
            return valueOf(str.toUpperCase(Locale.US));
        }
    }

    public static com.facebook.abtest.qe.log.QuickExperimentLogger m3771a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1867h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.abtest.qe.log.QuickExperimentLogger.class;
        monitor-enter(r1);
        r0 = f1867h;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m3776b(r0);	 Catch:{ all -> 0x0035 }
        f1867h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1867h;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.abtest.qe.log.QuickExperimentLogger.a(com.facebook.inject.InjectorLike):com.facebook.abtest.qe.log.QuickExperimentLogger");
    }

    private static QuickExperimentLogger m3776b(InjectorLike injectorLike) {
        return new QuickExperimentLogger(SystemClockMethodAutoProvider.m1498a(injectorLike), AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), DefaultBlueServiceOperationFactory.m3782b(injectorLike), DefaultProcessUtil.m2387a(injectorLike), LightSharedPreferencesFactoryMethodAutoProvider.m2543a(injectorLike));
    }

    public final void m3778a(QuickExperimentInfo quickExperimentInfo, String str, @Nullable JsonNode jsonNode) {
        if (quickExperimentInfo.f10006c && m3775a(quickExperimentInfo.f10004a)) {
            m3772a(quickExperimentInfo, str, jsonNode, QuickExperimentEventType.EXPOSURE);
        }
    }

    @Inject
    public QuickExperimentLogger(Clock clock, AnalyticsLogger analyticsLogger, DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, DefaultProcessUtil defaultProcessUtil, LightSharedPreferencesFactory lightSharedPreferencesFactory) {
        this.f1868b = clock;
        this.f1869c = analyticsLogger;
        this.f1870d = defaultBlueServiceOperationFactory;
        this.f1871e = defaultProcessUtil;
        this.f1872f = lightSharedPreferencesFactory;
    }

    public final void m3779a(boolean z, String str, String str2, LoggingChannel loggingChannel, String str3, @Nullable JsonNode jsonNode) {
        if (z && m3775a(str)) {
            m3773a(str, str2, loggingChannel, str3, jsonNode, QuickExperimentEventType.EXPOSURE);
        }
    }

    private void m3773a(String str, String str2, LoggingChannel loggingChannel, String str3, @Nullable JsonNode jsonNode, QuickExperimentEventType quickExperimentEventType) {
        if (loggingChannel == LoggingChannel.MARAUDER) {
            this.f1869c.mo533c(new QuickExperimentAnalyticsEvent(str, str2, quickExperimentEventType, str3, jsonNode));
        } else if (loggingChannel == LoggingChannel.QUICK_EXPERIMENT) {
            Bundle bundle = new Bundle();
            Builder builder = new Builder();
            builder.c = quickExperimentEventType.toString().toLowerCase(Locale.US);
            Builder builder2 = builder;
            builder2.a = str;
            builder2 = builder2;
            builder2.d = str3;
            builder2 = builder2;
            if (jsonNode != null) {
                builder2.e = jsonNode.toString();
            }
            bundle.putParcelable("experiment_logging_params", builder.a());
            BlueServiceOperationFactoryDetour.a(this.f1870d, "log_to_qe", bundle, -657432960).mo3451a(true).mo3452a();
        }
    }

    private boolean m3775a(String str) {
        if (!this.f1871e.m2389a().e()) {
            return m3777c(str);
        }
        boolean z;
        LightSharedPreferencesImpl a = this.f1872f.m2550a("QuickExperimentLogger-LastLogTimestamps");
        long a2 = this.f1868b.mo211a();
        long a3 = a.m2642a(str, 0);
        if (a3 == 0 || m3774a(a3, a2)) {
            a.m2648b().mo3282a(str, a2).mo3287c();
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    private synchronized boolean m3777c(String str) {
        boolean z;
        if (this.f1873g == null) {
            this.f1873g = Maps.m838c();
        }
        long a = this.f1868b.mo211a();
        Long l = (Long) this.f1873g.get(str);
        if (l == null || m3774a(l.longValue(), a)) {
            this.f1873g.put(str, Long.valueOf(a));
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    public static boolean m3774a(long j, long j2) {
        long j3 = j2 - j;
        return j3 < 0 || j3 > 14400000;
    }

    private void m3772a(QuickExperimentInfo quickExperimentInfo, String str, @Nullable JsonNode jsonNode, QuickExperimentEventType quickExperimentEventType) {
        LoggingChannel loggingChannel = LoggingChannel.MARAUDER;
        Optional a = quickExperimentInfo.m15050a("logging_channel");
        if (a.isPresent()) {
            try {
                loggingChannel = LoggingChannel.valueOfIgnoreCase((String) a.get());
            } catch (Exception e) {
                new Object[1][0] = a.get();
            }
        }
        m3773a(quickExperimentInfo.m15055g(), quickExperimentInfo.m15056h(), loggingChannel, str, jsonNode, quickExperimentEventType);
    }
}
