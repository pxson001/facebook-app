package com.facebook.messaging.clockskew;

import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.mqtt.model.thrift.TimeSyncRequest;
import com.facebook.mqtt.model.thrift.TimeSyncResponse;
import com.facebook.mqtt.model.thrift.TopicType;
import com.facebook.push.mqtt.service.MqttPushServiceClient;
import com.facebook.push.mqtt.service.MqttPushServiceClientManagerImpl;
import com.facebook.push.mqtt.service.response.MqttResponse;
import com.facebook.push.mqtt.service.response.MqttResponseManager;
import com.facebook.push.mqtt.service.response.MqttResponseProcessor;
import com.facebook.thrift.TSerializer;
import com.facebook.thrift.protocol.TCompactProtocol.Factory;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: favorite_sms_contacts */
public class ClockSkewChecker {
    private static final String f12187a = ("/" + ((String) TopicType.b.get(Integer.valueOf(119))));
    private static final String f12188b = ("/" + ((String) TopicType.b.get(Integer.valueOf(120))));
    private static volatile ClockSkewChecker f12189j;
    private final Clock f12190c;
    private final MqttPushServiceClientManagerImpl f12191d;
    private final MqttResponseManager f12192e;
    private final AutoDateTimeChecker f12193f;
    private final EstimatedServerClock f12194g;
    private ClockSkewLogger f12195h;
    private final TSerializer f12196i = new TSerializer(new Factory());

    public static com.facebook.messaging.clockskew.ClockSkewChecker m12861a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12189j;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.clockskew.ClockSkewChecker.class;
        monitor-enter(r1);
        r0 = f12189j;	 Catch:{ all -> 0x003a }
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
        r0 = m12863b(r0);	 Catch:{ all -> 0x0035 }
        f12189j = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12189j;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.clockskew.ClockSkewChecker.a(com.facebook.inject.InjectorLike):com.facebook.messaging.clockskew.ClockSkewChecker");
    }

    private static ClockSkewChecker m12863b(InjectorLike injectorLike) {
        return new ClockSkewChecker((Clock) SystemClockMethodAutoProvider.a(injectorLike), MqttPushServiceClientManagerImpl.a(injectorLike), MqttResponseManager.a(injectorLike), AutoDateTimeChecker.m12865b(injectorLike), EstimatedServerClock.m12867a(injectorLike), ClockSkewLogger.b(injectorLike));
    }

    @Inject
    public ClockSkewChecker(Clock clock, MqttPushServiceClientManagerImpl mqttPushServiceClientManagerImpl, MqttResponseManager mqttResponseManager, AutoDateTimeChecker autoDateTimeChecker, EstimatedServerClock estimatedServerClock, ClockSkewLogger clockSkewLogger) {
        this.f12190c = clock;
        this.f12191d = mqttPushServiceClientManagerImpl;
        this.f12192e = mqttResponseManager;
        this.f12193f = autoDateTimeChecker;
        this.f12194g = estimatedServerClock;
        this.f12195h = clockSkewLogger;
    }

    public final void m12864a() {
        if (this.f12193f.m12866a()) {
            this.f12194g.m12872d();
            return;
        }
        long b = m12862b();
        ClockSkewLogger clockSkewLogger = this.f12195h;
        clockSkewLogger.a.a(new HoneyClientEvent("time_skew_event").a("time_skew", b));
        this.f12194g.m12871b(b);
    }

    private long m12862b() {
        MqttPushServiceClient a = this.f12191d.a();
        try {
            MqttResponseProcessor a2 = this.f12192e.a(f12188b, new TimeSyncMqttResponseProcessorCallback());
            long a3 = this.f12190c.a();
            Object a4 = this.f12196i.a(new TimeSyncRequest(Long.valueOf(a3)));
            byte[] bArr = new byte[(a4.length + 1)];
            System.arraycopy(a4, 0, bArr, 1, a4.length);
            MqttResponse a5 = a.mo859a(f12187a, bArr, a2);
            a3 += (this.f12190c.a() - a3) / 2;
            a.mo870f();
            if (a5 == null) {
                throw new ClockSkewException("ipc call failed");
            } else if (!a5.a) {
                throw new ClockSkewException("Result was not success", a5.d);
            } else if (a5.b != null) {
                return a3 - ((TimeSyncResponse) a5.b).time.longValue();
            } else {
                throw new ClockSkewException("empty response");
            }
        } catch (Exception e) {
            throw new ClockSkewException("can not publish");
        } catch (Throwable th) {
            a.mo870f();
        }
    }
}
