package com.facebook.messaging.analytics.reliability;

import android.util.Base64;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.init.INeedInit;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.messageclassifier.MessageClassifier;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.prefs.MessagingPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.xconfig.core.XConfigReader;
import com.google.common.annotations.VisibleForTesting;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: mTtl */
public class AggregatedReliabilityLogger implements INeedInit {
    private static final PrefKey f8474a = ((PrefKey) MessagingPrefKeys.a.a("reliability_serialized"));
    private static volatile AggregatedReliabilityLogger f8475j;
    private final Clock f8476b;
    private final MessageClassifier f8477c;
    private final AnalyticsLogger f8478d;
    private final Provider<Boolean> f8479e;
    private final FbSharedPreferences f8480f;
    private final Lazy<FbErrorReporter> f8481g;
    private final XConfigReader f8482h;
    private LinkedHashMap<String, ReliabilityInfo> f8483i = null;

    public static com.facebook.messaging.analytics.reliability.AggregatedReliabilityLogger m8724a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8475j;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.analytics.reliability.AggregatedReliabilityLogger.class;
        monitor-enter(r1);
        r0 = f8475j;	 Catch:{ all -> 0x003a }
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
        r0 = m8728b(r0);	 Catch:{ all -> 0x0035 }
        f8475j = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8475j;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.analytics.reliability.AggregatedReliabilityLogger.a(com.facebook.inject.InjectorLike):com.facebook.messaging.analytics.reliability.AggregatedReliabilityLogger");
    }

    private static AggregatedReliabilityLogger m8728b(InjectorLike injectorLike) {
        return new AggregatedReliabilityLogger((Clock) SystemClockMethodAutoProvider.a(injectorLike), MessageClassifier.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 4044), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 494), XConfigReader.a(injectorLike));
    }

    @Inject
    public AggregatedReliabilityLogger(Clock clock, MessageClassifier messageClassifier, AnalyticsLogger analyticsLogger, Provider<Boolean> provider, FbSharedPreferences fbSharedPreferences, Lazy<FbErrorReporter> lazy, XConfigReader xConfigReader) {
        this.f8476b = clock;
        this.f8477c = messageClassifier;
        this.f8478d = analyticsLogger;
        this.f8479e = provider;
        this.f8480f = fbSharedPreferences;
        this.f8481g = lazy;
        this.f8482h = xConfigReader;
    }

    public void init() {
        m8738a();
    }

    public final synchronized void m8739a(NetworkChannel networkChannel, Message message) {
        if (((Boolean) this.f8479e.get()).booleanValue() && m8737j()) {
            ReliabilityInfo reliabilityInfo = (ReliabilityInfo) this.f8483i.get(message.n);
            if (reliabilityInfo == null) {
                reliabilityInfo = new ReliabilityInfo(this.f8476b.a(), this.f8477c.b(message));
                this.f8483i.put(message.n, reliabilityInfo);
            }
            m8725a(reliabilityInfo, networkChannel);
            m8735h();
        }
    }

    public final synchronized void m8740a(NetworkChannel networkChannel, String str, boolean z) {
        if (((Boolean) this.f8479e.get()).booleanValue() && m8737j()) {
            ReliabilityInfo reliabilityInfo = (ReliabilityInfo) this.f8483i.get(str);
            if (reliabilityInfo == null) {
                if (!z) {
                    ((AbstractFbErrorReporter) this.f8481g.get()).a("no_send_attempt_on_success", "No previous send attempt for msg with offline threading id " + str);
                }
            } else if (reliabilityInfo.graphAttempts + reliabilityInfo.mqttAttempts == 1) {
                this.f8483i.remove(str);
                m8735h();
            } else {
                reliabilityInfo.timeSinceFirstSendAttempt = this.f8476b.a() - reliabilityInfo.sendAttemptTimestamp;
                if (networkChannel == NetworkChannel.MQTT) {
                    reliabilityInfo.outcome = Outcome.SUCCESS_MQTT;
                } else {
                    reliabilityInfo.outcome = Outcome.SUCCESS_GRAPH;
                }
                m8735h();
            }
        }
    }

    public final synchronized void m8741a(String str, boolean z) {
        if (((Boolean) this.f8479e.get()).booleanValue() && m8737j()) {
            ReliabilityInfo reliabilityInfo = (ReliabilityInfo) this.f8483i.get(str);
            if (reliabilityInfo == null) {
                ((AbstractFbErrorReporter) this.f8481g.get()).a("no_send_attempt_on_failure", "No previous send attempt for msg with offline threading id " + str);
            } else {
                reliabilityInfo.timeSinceFirstSendAttempt = this.f8476b.a() - reliabilityInfo.sendAttemptTimestamp;
                reliabilityInfo.outcome = z ? Outcome.FAILURE_RETRYABLE : Outcome.FAILURE_PERMANENT;
                m8735h();
            }
        }
    }

    @Nullable
    @VisibleForTesting
    private synchronized String m8729b() {
        String stringBuilder;
        Iterator it = this.f8483i.entrySet().iterator();
        Entry entry = (Entry) it.next();
        ReliabilityInfo reliabilityInfo = (ReliabilityInfo) entry.getValue();
        if (((long) this.f8483i.size()) >= m8734g() || reliabilityInfo.sendAttemptTimestamp <= this.f8476b.a() - m8732e()) {
            StringBuilder stringBuilder2 = new StringBuilder();
            while (true) {
                if (((long) this.f8483i.size()) <= m8734g() && Outcome.UNKNOWN.equals(reliabilityInfo.outcome) && reliabilityInfo.sendAttemptTimestamp >= this.f8476b.a() - m8733f()) {
                    break;
                }
                m8727a((String) entry.getKey(), reliabilityInfo, stringBuilder2);
                it.remove();
                if (!it.hasNext()) {
                    break;
                }
                entry = (Entry) it.next();
                reliabilityInfo = (ReliabilityInfo) entry.getValue();
            }
            stringBuilder = stringBuilder2.toString();
        } else {
            stringBuilder = null;
        }
        return stringBuilder;
    }

    @VisibleForTesting
    private synchronized void m8730c() {
        if (this.f8483i != null) {
            try {
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                objectOutputStream.writeObject(this.f8483i);
                objectOutputStream.flush();
                String str = new String(Base64.encode(byteArrayOutputStream.toByteArray(), 0));
                objectOutputStream.close();
                this.f8480f.edit().a(f8474a, str).commit();
            } catch (Throwable e) {
                ((AbstractFbErrorReporter) this.f8481g.get()).a("reliabilities_serialization_failed", e);
                this.f8480f.edit().a(f8474a).commit();
            }
        }
    }

    @Nullable
    @VisibleForTesting
    private synchronized LinkedHashMap<String, ReliabilityInfo> m8731d() {
        LinkedHashMap<String, ReliabilityInfo> linkedHashMap = null;
        synchronized (this) {
            if (this.f8480f.a()) {
                String a = this.f8480f.a(f8474a, null);
                if (a == null) {
                    linkedHashMap = new LinkedHashMap();
                } else {
                    try {
                        linkedHashMap = (LinkedHashMap) new ObjectInputStream(new ByteArrayInputStream(Base64.decode(a, 0))).readObject();
                    } catch (Throwable e) {
                        ((AbstractFbErrorReporter) this.f8481g.get()).a("bad_reliabilities_deserialization", e);
                        this.f8480f.edit().a(f8474a).commit();
                        linkedHashMap = new LinkedHashMap();
                    }
                }
            }
        }
        return linkedHashMap;
    }

    @VisibleForTesting
    private long m8732e() {
        return this.f8482h.a(AggregatedReliabilityLoggerXConfig.f1795e, 21600) * 1000;
    }

    @VisibleForTesting
    private long m8733f() {
        return this.f8482h.a(AggregatedReliabilityLoggerXConfig.f1794d, 10800) * 1000;
    }

    @VisibleForTesting
    private long m8734g() {
        return (long) this.f8482h.a(AggregatedReliabilityLoggerXConfig.f1793c, 500);
    }

    final synchronized void m8738a() {
        if (((Boolean) this.f8479e.get()).booleanValue() && m8736i()) {
            m8730c();
        }
    }

    private synchronized void m8735h() {
        m8736i();
        m8730c();
    }

    private synchronized boolean m8736i() {
        boolean z = false;
        synchronized (this) {
            if (m8737j() && !this.f8483i.isEmpty()) {
                String b = m8729b();
                if (!StringUtil.c(b)) {
                    m8726a(b);
                    z = true;
                }
            }
        }
        return z;
    }

    private synchronized void m8726a(String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("msg_reliability");
        honeyClientEvent.b("reliabilities_map", str);
        this.f8478d.a(honeyClientEvent);
    }

    private synchronized boolean m8737j() {
        if (this.f8483i == null) {
            this.f8483i = m8731d();
        }
        return this.f8483i != null;
    }

    private static void m8727a(String str, ReliabilityInfo reliabilityInfo, StringBuilder stringBuilder) {
        if (stringBuilder.length() > 0) {
            stringBuilder.append(',');
        }
        stringBuilder.append(str).append("=");
        stringBuilder.append(reliabilityInfo.messageType).append(":");
        stringBuilder.append(reliabilityInfo.mqttAttempts).append(":");
        stringBuilder.append(reliabilityInfo.graphAttempts).append(":");
        if (reliabilityInfo.outcome == Outcome.FAILURE_PERMANENT || reliabilityInfo.outcome == Outcome.FAILURE_RETRYABLE || reliabilityInfo.outcome == Outcome.UNKNOWN) {
            stringBuilder.append(reliabilityInfo.sendAttemptTimestamp);
        } else {
            stringBuilder.append(reliabilityInfo.timeSinceFirstSendAttempt);
        }
        stringBuilder.append(":");
        stringBuilder.append(reliabilityInfo.outcome.rawValue);
    }

    private static void m8725a(ReliabilityInfo reliabilityInfo, NetworkChannel networkChannel) {
        if (networkChannel == NetworkChannel.MQTT) {
            reliabilityInfo.mqttAttempts++;
        } else {
            reliabilityInfo.graphAttempts++;
        }
    }
}
