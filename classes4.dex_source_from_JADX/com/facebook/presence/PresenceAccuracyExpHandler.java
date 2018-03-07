package com.facebook.presence;

import com.facebook.common.executors.ScheduledExecutorService_SingleThreadedExecutorServiceMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.mqtt.messages.MqttQOSLevel;
import com.facebook.push.mqtt.external.MqttPushHandler;
import com.facebook.push.mqtt.service.MqttPushServiceWrapper;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.user.model.UserKey;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Singleton
/* compiled from: fetchStickerPackIdsParams */
public class PresenceAccuracyExpHandler implements MqttPushHandler {
    private static volatile PresenceAccuracyExpHandler f11724h;
    public final Lazy<PresenceManager> f11725a;
    public final Lazy<MqttPushServiceWrapper> f11726b;
    private final Clock f11727c;
    private final Executor f11728d;
    public volatile long f11729e = -1;
    public volatile long f11730f = 1;
    private final Runnable f11731g = new C05661(this);

    /* compiled from: fetchStickerPackIdsParams */
    class C05661 implements Runnable {
        final /* synthetic */ PresenceAccuracyExpHandler f11732a;

        C05661(PresenceAccuracyExpHandler presenceAccuracyExpHandler) {
            this.f11732a = presenceAccuracyExpHandler;
        }

        public void run() {
            Map g = ((DefaultPresenceManager) this.f11732a.f11725a.get()).m7768g();
            Set<UserKey> h = ((DefaultPresenceManager) this.f11732a.f11725a.get()).m7769h();
            JSONArray jSONArray = new JSONArray();
            for (UserKey userKey : h) {
                UserState userState = (UserState) g.get(userKey);
                if (userState != null) {
                    try {
                        jSONArray.put(PresenceAccuracyExpHandler.m12271b(userKey.b(), userState.f11485d, userState.f11486e, userState.f11488g, this.f11732a.f11729e, this.f11732a.f11730f));
                    } catch (JSONException e) {
                        return;
                    }
                }
            }
            ((MqttPushServiceWrapper) this.f11732a.f11726b.get()).m12141a("/p_a_resp", StringUtil.a(jSONArray.toString()), MqttQOSLevel.FIRE_AND_FORGET, null);
        }
    }

    public static com.facebook.presence.PresenceAccuracyExpHandler m12268a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f11724h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.presence.PresenceAccuracyExpHandler.class;
        monitor-enter(r1);
        r0 = f11724h;	 Catch:{ all -> 0x003a }
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
        r0 = m12270b(r0);	 Catch:{ all -> 0x0035 }
        f11724h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11724h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.presence.PresenceAccuracyExpHandler.a(com.facebook.inject.InjectorLike):com.facebook.presence.PresenceAccuracyExpHandler");
    }

    private static PresenceAccuracyExpHandler m12270b(InjectorLike injectorLike) {
        return new PresenceAccuracyExpHandler(IdBasedSingletonScopeProvider.b(injectorLike, 3088), IdBasedSingletonScopeProvider.b(injectorLike, 3210), (Clock) SystemClockMethodAutoProvider.a(injectorLike), ScheduledExecutorService_SingleThreadedExecutorServiceMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public PresenceAccuracyExpHandler(Lazy<PresenceManager> lazy, Lazy<MqttPushServiceWrapper> lazy2, Clock clock, ExecutorService executorService) {
        this.f11725a = lazy;
        this.f11726b = lazy2;
        this.f11727c = clock;
        this.f11728d = executorService;
    }

    public void onMessage(String str, byte[] bArr) {
        if ("/p_a_req".equals(str)) {
            ExecutorDetour.a(this.f11728d, this.f11731g, 970083230);
        } else if ("/t_p".equals(str)) {
            this.f11729e = this.f11727c.a();
        } else if ("/t_sp".equals(str)) {
            this.f11730f = this.f11727c.a();
        }
    }

    private static final JSONObject m12271b(String str, boolean z, long j, long j2, long j3, long j4) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("u", str);
        jSONObject.put("p", z);
        jSONObject.put("l", j);
        jSONObject.put("vc", j2);
        jSONObject.put("pt", j3);
        jSONObject.put("spt", j4);
        return jSONObject;
    }
}
