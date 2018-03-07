package com.facebook.ui.images.fetch;

import com.facebook.analytics.BaseAnalyticsConfig;
import com.facebook.analytics.DataUsageCounters;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.logger.IAnalyticsPeriodicEventReporter;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.TriState;
import com.facebook.device.DeviceConditionHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.orca.FbAnalyticsConfig;
import com.facebook.ui.images.cache.CachedImage;
import com.facebook.ui.images.fetch.FetchedImage.Source;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: secondary_options */
public class FeatureAwareImageAccessLogger implements IAnalyticsPeriodicEventReporter {
    private static final Class<?> f5102a = FeatureAwareImageAccessLogger.class;
    private static volatile FeatureAwareImageAccessLogger f5103g;
    private final BaseAnalyticsConfig f5104b;
    private final DeviceConditionHelper f5105c;
    private Map<String, DataUsageCounters> f5106d = Maps.c();
    private boolean f5107e = false;
    private long f5108f = 0;

    /* compiled from: secondary_options */
    public enum FetchType {
        FETCH,
        PREFETCH
    }

    public static com.facebook.ui.images.fetch.FeatureAwareImageAccessLogger m7865a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f5103g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.ui.images.fetch.FeatureAwareImageAccessLogger.class;
        monitor-enter(r1);
        r0 = f5103g;	 Catch:{ all -> 0x003a }
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
        r0 = m7867b(r0);	 Catch:{ all -> 0x0035 }
        f5103g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5103g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ui.images.fetch.FeatureAwareImageAccessLogger.a(com.facebook.inject.InjectorLike):com.facebook.ui.images.fetch.FeatureAwareImageAccessLogger");
    }

    private static FeatureAwareImageAccessLogger m7867b(InjectorLike injectorLike) {
        return new FeatureAwareImageAccessLogger((BaseAnalyticsConfig) FbAnalyticsConfig.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), DeviceConditionHelper.a(injectorLike));
    }

    @Inject
    public FeatureAwareImageAccessLogger(BaseAnalyticsConfig baseAnalyticsConfig, Clock clock, DeviceConditionHelper deviceConditionHelper) {
        this.f5104b = baseAnalyticsConfig;
        this.f5108f = clock.a();
        this.f5105c = deviceConditionHelper;
    }

    public final HoneyAnalyticsEvent m7868a(long j, String str) {
        if (this.f5107e) {
            return m7864a(j);
        }
        return null;
    }

    public final void m7869a(String str, FetchedImage fetchedImage) {
        m7866a(str, fetchedImage, FetchType.FETCH);
    }

    private void m7866a(String str, FetchedImage fetchedImage, FetchType fetchType) {
        String str2;
        Preconditions.checkNotNull(str);
        TriState triState = TriState.UNSET;
        if (fetchedImage.e() == Source.DOWNLOADED) {
            TriState triState2 = this.f5105c.b() ? TriState.YES : TriState.NO;
            String str3 = fetchedImage.e() + (triState2 == TriState.YES ? "_WIFI" : "_MOBILE");
            triState = triState2;
            str2 = str3;
        } else {
            str2 = fetchedImage.e().toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2).append(',').append(fetchType).append(',');
        CachedImage c = fetchedImage.c();
        if (c != null) {
            stringBuilder.append(c.c()).append('x').append(c.d());
        } else {
            stringBuilder.append("0x0");
        }
        str2 = stringBuilder.toString();
        fetchedImage.a().a();
        synchronized (this) {
            DataUsageCounters a = m7863a(str);
            a.a(str2, 1);
            if (fetchedImage.f() > 0) {
                triState2 = triState == TriState.UNSET ? this.f5105c.b() ? TriState.YES : TriState.NO : triState;
                a.a("downloadsize", fetchedImage.f());
                a.a("downloadsize" + (triState2 == TriState.YES ? "_wifi" : "_mobile"), fetchedImage.f());
            }
            this.f5107e = true;
        }
    }

    private synchronized DataUsageCounters m7863a(String str) {
        DataUsageCounters dataUsageCounters;
        dataUsageCounters = (DataUsageCounters) this.f5106d.get(str);
        if (dataUsageCounters == null) {
            dataUsageCounters = new DataUsageCounters(null);
            this.f5106d.put(str, dataUsageCounters);
        }
        return dataUsageCounters;
    }

    private HoneyAnalyticsEvent m7864a(long j) {
        long j2;
        synchronized (this) {
            this.f5107e = false;
            j2 = this.f5108f;
            this.f5108f = j;
            List<Entry> a = Lists.a(this.f5106d.entrySet());
            this.f5106d = Maps.c();
        }
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("feature_image_access");
        honeyClientEvent.a("start", j2);
        honeyClientEvent.a("interval", 1800000);
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        for (Entry entry : a) {
            objectNode.c(((String) entry.getKey()).toString(), ((DataUsageCounters) entry.getValue()).c());
        }
        honeyClientEvent.a("counters", objectNode);
        return honeyClientEvent;
    }
}
