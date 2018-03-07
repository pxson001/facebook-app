package com.facebook.mqttlite;

import android.text.TextUtils;
import com.facebook.config.background.AbstractConfigurationComponent;
import com.facebook.http.protocol.BatchComponent;
import com.facebook.http.protocol.BatchOperation;
import com.facebook.http.protocol.BatchOperation.Builder;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: rtcOngoingGroupCalls */
public class MqttConfigurationComponent extends AbstractConfigurationComponent {
    private static volatile MqttConfigurationComponent f3315d;
    @VisibleForTesting
    long f3316a = 24;
    public final FetchMqttParametersMethod f3317b;
    public final FbSharedPreferences f3318c;

    /* compiled from: rtcOngoingGroupCalls */
    class MyBatchComponent implements BatchComponent {
        final /* synthetic */ MqttConfigurationComponent f3319a;

        public MyBatchComponent(MqttConfigurationComponent mqttConfigurationComponent) {
            this.f3319a = mqttConfigurationComponent;
        }

        public final Iterable<BatchOperation> mo99a() {
            Builder a = BatchOperation.m12541a(this.f3319a.f3317b, null);
            a.f11927c = "mqtt_config";
            return ImmutableList.of(a.m12548a(false).m12549a());
        }

        public final void mo100a(Map<String, Object> map) {
            Map map2 = (Map) map.get("mqtt_config");
            String str = "";
            if (map2 != null) {
                JsonNode jsonNode = (JsonNode) map2.get("mqtt_config");
                if (jsonNode != null) {
                    str = jsonNode.toString();
                    this.f3319a.f3316a = Math.min(this.f3319a.f3316a, jsonNode.c("fetch_delay_hours").a(this.f3319a.f3316a));
                }
            }
            String str2 = str;
            MqttConfigurationComponent mqttConfigurationComponent = this.f3319a;
            if (mqttConfigurationComponent.f3318c.a() && !TextUtils.isEmpty(str2)) {
                mqttConfigurationComponent.f3318c.edit().a(MqttPrefKeys.b, str2).commit();
            }
        }
    }

    public static com.facebook.mqttlite.MqttConfigurationComponent m3526a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3315d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.mqttlite.MqttConfigurationComponent.class;
        monitor-enter(r1);
        r0 = f3315d;	 Catch:{ all -> 0x003a }
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
        r0 = m3527b(r0);	 Catch:{ all -> 0x0035 }
        f3315d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3315d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.mqttlite.MqttConfigurationComponent.a(com.facebook.inject.InjectorLike):com.facebook.mqttlite.MqttConfigurationComponent");
    }

    private static MqttConfigurationComponent m3527b(InjectorLike injectorLike) {
        return new MqttConfigurationComponent(new FetchMqttParametersMethod(), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    @Inject
    public MqttConfigurationComponent(FetchMqttParametersMethod fetchMqttParametersMethod, FbSharedPreferences fbSharedPreferences) {
        this.f3317b = fetchMqttParametersMethod;
        this.f3318c = fbSharedPreferences;
    }

    public final BatchComponent mo101b() {
        return new MyBatchComponent(this);
    }

    public final long co_() {
        return this.f3316a * 3600000;
    }
}
