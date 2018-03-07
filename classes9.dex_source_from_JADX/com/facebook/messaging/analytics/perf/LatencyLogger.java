package com.facebook.messaging.analytics.perf;

import android.util.Base64;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.cache.DataCache;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threadkey.ThreadKey.Type;
import com.facebook.messaging.prefs.MessagingPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: p2p_history_visible_tab */
public class LatencyLogger {
    private static final PrefKey f7636a = ((PrefKey) MessagingPrefKeys.a.a("latencies_serialized"));
    private static volatile LatencyLogger f7637i;
    private final Clock f7638b;
    private final AnalyticsLogger f7639c;
    private final Provider<Boolean> f7640d;
    private final Provider<DataCache> f7641e;
    private final FbSharedPreferences f7642f;
    private final Lazy<FbErrorReporter> f7643g;
    private LinkedHashMap<String, LatencyInfo> f7644h = null;

    /* compiled from: p2p_history_visible_tab */
    public class LatencyInfo implements Serializable {
        public long deliveryReceiptLatency = -1;
        public long pubAckLatency = -1;
        public final long sendAttemptTimestamp;

        LatencyInfo(long j) {
            this.sendAttemptTimestamp = j;
        }
    }

    public static com.facebook.messaging.analytics.perf.LatencyLogger m7918a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7637i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.analytics.perf.LatencyLogger.class;
        monitor-enter(r1);
        r0 = f7637i;	 Catch:{ all -> 0x003a }
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
        r0 = m7921b(r0);	 Catch:{ all -> 0x0035 }
        f7637i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7637i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.analytics.perf.LatencyLogger.a(com.facebook.inject.InjectorLike):com.facebook.messaging.analytics.perf.LatencyLogger");
    }

    private static LatencyLogger m7921b(InjectorLike injectorLike) {
        return new LatencyLogger((Clock) SystemClockMethodAutoProvider.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 4043), IdBasedProvider.a(injectorLike, 2567), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 494));
    }

    @Inject
    public LatencyLogger(Clock clock, AnalyticsLogger analyticsLogger, Provider<Boolean> provider, Provider<DataCache> provider2, FbSharedPreferences fbSharedPreferences, Lazy<FbErrorReporter> lazy) {
        this.f7638b = clock;
        this.f7639c = analyticsLogger;
        this.f7640d = provider;
        this.f7641e = provider2;
        this.f7642f = fbSharedPreferences;
        this.f7643g = lazy;
        Preconditions.checkState(true, "MAX_ENTRIES_TO_KEEP should always be larger than NUM_ENTRIES_TO_SEND_IN_ONE_EVENT");
    }

    public final synchronized void m7928a(ThreadKey threadKey, String str) {
        if (threadKey.a == Type.ONE_TO_ONE && ((Boolean) this.f7640d.get()).booleanValue() && m7927f() && !this.f7644h.containsKey(str)) {
            this.f7644h.put(str, new LatencyInfo(this.f7638b.a()));
            m7925d();
        }
    }

    public final synchronized void m7929a(String str) {
        if (((Boolean) this.f7640d.get()).booleanValue() && m7927f()) {
            LatencyInfo latencyInfo = (LatencyInfo) this.f7644h.get(str);
            if (latencyInfo != null) {
                latencyInfo.pubAckLatency = this.f7638b.a() - latencyInfo.sendAttemptTimestamp;
                m7925d();
            }
        }
    }

    @VisibleForTesting
    private synchronized String m7919a() {
        StringBuilder stringBuilder;
        Iterator it = this.f7644h.entrySet().iterator();
        stringBuilder = new StringBuilder();
        for (int i = 0; i < 10 && it.hasNext(); i++) {
            Entry entry = (Entry) it.next();
            it.remove();
            m7920a((String) entry.getKey(), (LatencyInfo) entry.getValue(), stringBuilder);
        }
        return stringBuilder.toString();
    }

    @VisibleForTesting
    private synchronized void m7922b() {
        if (this.f7644h != null) {
            try {
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                objectOutputStream.writeObject(this.f7644h);
                objectOutputStream.flush();
                String str = new String(Base64.encode(byteArrayOutputStream.toByteArray(), 0));
                objectOutputStream.close();
                this.f7642f.edit().a(f7636a, str).commit();
            } catch (Throwable e) {
                ((AbstractFbErrorReporter) this.f7643g.get()).a("latencies_serialization_failed", e);
                this.f7642f.edit().a(f7636a).commit();
            }
        }
    }

    @Nullable
    @VisibleForTesting
    private synchronized LinkedHashMap<String, LatencyInfo> m7924c() {
        LinkedHashMap<String, LatencyInfo> linkedHashMap = null;
        synchronized (this) {
            if (this.f7642f.a()) {
                String a = this.f7642f.a(f7636a, null);
                if (a == null) {
                    linkedHashMap = new LinkedHashMap();
                } else {
                    try {
                        linkedHashMap = (LinkedHashMap) new ObjectInputStream(new ByteArrayInputStream(Base64.decode(a, 0))).readObject();
                    } catch (Throwable e) {
                        ((AbstractFbErrorReporter) this.f7643g.get()).a("bad_latencies_deserialization", e);
                        this.f7642f.edit().a(f7636a).commit();
                        linkedHashMap = new LinkedHashMap();
                    }
                }
            }
        }
        return linkedHashMap;
    }

    private synchronized void m7925d() {
        m7926e();
        if (this.f7644h.size() < 12) {
            m7922b();
        } else {
            m7923b(m7919a());
            m7922b();
        }
    }

    private synchronized void m7923b(String str) {
        if (!StringUtil.c(str)) {
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("msg_latencies");
            honeyClientEvent.b("latencies_map", str);
            this.f7639c.a(honeyClientEvent);
        }
    }

    private synchronized void m7926e() {
        if (!this.f7644h.isEmpty()) {
            Iterator it = this.f7644h.entrySet().iterator();
            Entry entry = (Entry) it.next();
            LatencyInfo latencyInfo = (LatencyInfo) entry.getValue();
            if (latencyInfo.sendAttemptTimestamp <= this.f7638b.a() - 43200000) {
                StringBuilder stringBuilder = new StringBuilder();
                while (latencyInfo.sendAttemptTimestamp < this.f7638b.a() - 43200000) {
                    m7920a((String) entry.getKey(), latencyInfo, stringBuilder);
                    it.remove();
                    if (!it.hasNext()) {
                        break;
                    }
                    entry = (Entry) it.next();
                    latencyInfo = (LatencyInfo) entry.getValue();
                }
                m7923b(stringBuilder.toString());
            }
        }
    }

    private synchronized void m7920a(String str, LatencyInfo latencyInfo, StringBuilder stringBuilder) {
        if (!(latencyInfo.pubAckLatency == -1 && latencyInfo.deliveryReceiptLatency == -1)) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(',');
            }
            stringBuilder.append(str).append("=");
            stringBuilder.append(latencyInfo.pubAckLatency);
            if (latencyInfo.deliveryReceiptLatency != -1) {
                stringBuilder.append(':').append(latencyInfo.deliveryReceiptLatency);
            }
        }
    }

    private synchronized boolean m7927f() {
        if (this.f7644h == null) {
            this.f7644h = m7924c();
        }
        return this.f7644h != null;
    }
}
