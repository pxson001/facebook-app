package com.facebook.mqttlite;

import android.content.Context;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.GlobalFbBroadcastManager;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.OnSharedPreferenceChangeListener;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.facebook.rti.mqtt.common.config.ConnectionConfigManager;
import com.facebook.rti.mqtt.common.config.MqttConnectionConfig;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import org.json.JSONObject;

@Singleton
/* compiled from: foreground_version_name */
public class MqttConnectionConfigManager extends ConnectionConfigManager {
    public static final PrefKey f23386a;
    public static final PrefKey f23387b;
    public static final PrefKey f23388c = ((PrefKey) f23390e.m2011a("sandbox"));
    private static final Class<?> f23389d = MqttConnectionConfigManager.class;
    private static final PrefKey f23390e;
    private static volatile MqttConnectionConfigManager f23391l;
    private final Context f23392f;
    private final OnSharedPreferenceChangeListener f23393g = new C09481(this);
    public final Provider<Boolean> f23394h;
    public final FbSharedPreferences f23395i;
    private final BaseFbBroadcastManager f23396j;
    public volatile MqttConnectionConfig f23397k;

    /* compiled from: foreground_version_name */
    class C09481 implements OnSharedPreferenceChangeListener {
        final /* synthetic */ MqttConnectionConfigManager f23398a;

        C09481(MqttConnectionConfigManager mqttConnectionConfigManager) {
            this.f23398a = mqttConnectionConfigManager;
        }

        public final void mo668a(FbSharedPreferences fbSharedPreferences, PrefKey prefKey) {
            MqttConnectionConfigManager.m31668f(this.f23398a);
        }
    }

    /* compiled from: foreground_version_name */
    class C09492 implements Runnable {
        final /* synthetic */ MqttConnectionConfigManager f23403a;

        C09492(MqttConnectionConfigManager mqttConnectionConfigManager) {
            this.f23403a = mqttConnectionConfigManager;
        }

        public void run() {
            MqttConnectionConfigManager.m31668f(this.f23403a);
        }
    }

    public static com.facebook.mqttlite.MqttConnectionConfigManager m31664a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f23391l;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.mqttlite.MqttConnectionConfigManager.class;
        monitor-enter(r1);
        r0 = f23391l;	 Catch:{ all -> 0x003a }
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
        r0 = m31667b(r0);	 Catch:{ all -> 0x0035 }
        f23391l = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f23391l;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.mqttlite.MqttConnectionConfigManager.a(com.facebook.inject.InjectorLike):com.facebook.mqttlite.MqttConnectionConfigManager");
    }

    private static MqttConnectionConfigManager m31667b(InjectorLike injectorLike) {
        return new MqttConnectionConfigManager((Context) injectorLike.getInstance(Context.class), IdBasedProvider.m1811a(injectorLike, 3937), FbSharedPreferencesImpl.m1826a(injectorLike), GlobalFbBroadcastManager.m4507a(injectorLike));
    }

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.f989c.m2011a("sandbox/");
        f23386a = prefKey;
        prefKey = (PrefKey) prefKey.m2011a("mqtt/");
        f23390e = prefKey;
        f23387b = (PrefKey) prefKey.m2011a("server_tier");
    }

    @Inject
    public MqttConnectionConfigManager(Context context, Provider<Boolean> provider, FbSharedPreferences fbSharedPreferences, FbBroadcastManager fbBroadcastManager) {
        this.f23392f = context;
        this.f23394h = provider;
        this.f23395i = fbSharedPreferences;
        this.f23396j = fbBroadcastManager;
        this.f23395i.mo283a(ImmutableSet.of(f23387b, f23388c, MqttPrefKeys.f23400b), this.f23393g);
        this.f23397k = MqttConnectionConfig.a(this.f23392f);
        this.f23395i.mo280a(new C09492(this));
    }

    public final void m31670a() {
        MqttConnectionConfig g = m31669g();
        if (!g.equals(this.f23397k)) {
            this.f23397k = g;
        }
    }

    public final MqttConnectionConfig m31671b() {
        return this.f23397k;
    }

    public final void m31672c() {
        this.f23396j.m2955a("com.facebook.rti.mqtt.ACTION_MQTT_CONFIG_CHANGED");
    }

    public final String m31673d() {
        return m31665a(MqttPrefKeys.f23400b).optString("host_name_v6", "mqtt-mini.facebook.com");
    }

    public static void m31668f(MqttConnectionConfigManager mqttConnectionConfigManager) {
        mqttConnectionConfigManager.a();
        mqttConnectionConfigManager.c();
    }

    private MqttConnectionConfig m31669g() {
        JSONObject a = m31665a(MqttPrefKeys.f23400b);
        a(a);
        if (((Boolean) this.f23394h.get()).booleanValue()) {
            if ("sandbox".equals(this.f23395i.mo278a(f23387b, "default"))) {
                CharSequence a2 = this.f23395i.mo278a(f23388c, null);
                if (!StringUtil.m3589a(a2)) {
                    m31666a(a, a2);
                }
            }
        }
        return MqttConnectionConfig.a(a, this.f23392f);
    }

    private JSONObject m31665a(PrefKey prefKey) {
        CharSequence a = this.f23395i.mo278a(prefKey, "");
        JSONObject jSONObject = new JSONObject();
        if (StringUtil.m3589a(a)) {
            return jSONObject;
        }
        try {
            return new JSONObject(a);
        } catch (Throwable e) {
            BLog.a(f23389d, e, "", new Object[0]);
            return jSONObject;
        }
    }

    public static void m31666a(JSONObject jSONObject, String str) {
        try {
            int parseInt;
            if (str.contains(":")) {
                String[] split = str.split(":", 2);
                str = split[0];
                parseInt = Integer.parseInt(split[1]);
            } else {
                parseInt = 8883;
            }
            jSONObject.put("host_name", str);
            jSONObject.put("host_name_v6", str);
            jSONObject.put("wifi_port", parseInt);
            jSONObject.put("default_port", parseInt);
            jSONObject.put("use_ssl", false);
            jSONObject.put("use_compression", false);
        } catch (Throwable th) {
            BLog.a(f23389d, "Failed to parse mqtt sandbox URL", th);
        }
    }
}
