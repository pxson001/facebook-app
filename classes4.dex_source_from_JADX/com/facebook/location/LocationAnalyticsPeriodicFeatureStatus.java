package com.facebook.location;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.provider.Settings.Secure;
import android.provider.Settings.SettingNotFoundException;
import com.facebook.analytics.feature.PeriodicFeatureStatus;
import com.facebook.common.android.ContentResolverMethodAutoProvider;
import com.facebook.common.android.PackageManagerMethodAutoProvider;
import com.facebook.common.android.SensorManagerMethodAutoProvider;
import com.facebook.common.android.WifiManagerMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.perftest.PerfTestConfig;
import com.facebook.common.util.TriState;
import com.facebook.device.DeviceConditionHelper;
import com.facebook.device.SystemSettings;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.iorg.common.zero.interfaces.ZeroFeatureVisibilityHelper;
import com.facebook.location.FbLocationStatus.State;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.sensor.SensorType;
import com.facebook.zero.FbZeroFeatureVisibilityHelper;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Preconditions;
import java.util.Collection;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: guess_was_bg */
public class LocationAnalyticsPeriodicFeatureStatus extends PeriodicFeatureStatus {
    private static volatile LocationAnalyticsPeriodicFeatureStatus f10919o;
    private final Context f10920a;
    private final PackageManager f10921b;
    private final FbLocationStatusUtil f10922c;
    private final DeviceConditionHelper f10923d;
    private final SystemSettings f10924e;
    public final ContentResolver f10925f;
    public final WifiManager f10926g;
    public final Provider<TriState> f10927h;
    public final FbZeroFeatureVisibilityHelper f10928i;
    public final GooglePlayServicesUtil f10929j;
    public final AbstractFbErrorReporter f10930k;
    public final FbSharedPreferences f10931l;
    public final PerfTestConfig f10932m;
    private final SensorManager f10933n;

    public static com.facebook.location.LocationAnalyticsPeriodicFeatureStatus m11359a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10919o;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.location.LocationAnalyticsPeriodicFeatureStatus.class;
        monitor-enter(r1);
        r0 = f10919o;	 Catch:{ all -> 0x003a }
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
        r0 = m11362b(r0);	 Catch:{ all -> 0x0035 }
        f10919o = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10919o;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.location.LocationAnalyticsPeriodicFeatureStatus.a(com.facebook.inject.InjectorLike):com.facebook.location.LocationAnalyticsPeriodicFeatureStatus");
    }

    private static LocationAnalyticsPeriodicFeatureStatus m11362b(InjectorLike injectorLike) {
        return new LocationAnalyticsPeriodicFeatureStatus((Context) injectorLike.getInstance(Context.class), PackageManagerMethodAutoProvider.a(injectorLike), FbLocationStatusUtil.a(injectorLike), DeviceConditionHelper.a(injectorLike), SystemSettings.m11371a(injectorLike), ContentResolverMethodAutoProvider.b(injectorLike), WifiManagerMethodAutoProvider.b(injectorLike), IdBasedProvider.a(injectorLike, 703), FbZeroFeatureVisibilityHelper.a(injectorLike), GooglePlayServicesUtil.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), PerfTestConfig.a(injectorLike), SensorManagerMethodAutoProvider.m11374b(injectorLike));
    }

    @Inject
    public LocationAnalyticsPeriodicFeatureStatus(Context context, PackageManager packageManager, FbLocationStatusUtil fbLocationStatusUtil, DeviceConditionHelper deviceConditionHelper, SystemSettings systemSettings, ContentResolver contentResolver, WifiManager wifiManager, Provider<TriState> provider, ZeroFeatureVisibilityHelper zeroFeatureVisibilityHelper, GooglePlayServicesUtil googlePlayServicesUtil, FbErrorReporter fbErrorReporter, FbSharedPreferences fbSharedPreferences, PerfTestConfig perfTestConfig, SensorManager sensorManager) {
        this.f10920a = context;
        this.f10921b = packageManager;
        this.f10922c = fbLocationStatusUtil;
        this.f10923d = deviceConditionHelper;
        this.f10924e = systemSettings;
        this.f10925f = contentResolver;
        this.f10926g = wifiManager;
        this.f10927h = provider;
        this.f10928i = zeroFeatureVisibilityHelper;
        this.f10929j = googlePlayServicesUtil;
        this.f10930k = fbErrorReporter;
        this.f10931l = fbSharedPreferences;
        this.f10932m = perfTestConfig;
        this.f10933n = sensorManager;
    }

    public final String mo61b() {
        return "location";
    }

    public final boolean mo62c() {
        return this.f10922c.a() == State.OKAY;
    }

    public final JsonNode mo829a() {
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        FbLocationStatus b = this.f10922c.b();
        objectNode.a("state", b.a.toString());
        ObjectNode objectNode2 = new ObjectNode(JsonNodeFactory.a);
        objectNode2.c("user_enabled", m11360a(b.b));
        objectNode2.c("user_disabled", m11360a(b.c));
        objectNode.c("providers", objectNode2);
        objectNode.c("wifi_info", m11364d());
        objectNode.c("bluetooth_info", m11366h());
        objectNode.a("manager_impl", FbLocationManagerProvider.a(this.f10927h, this.f10928i, this.f10929j, this.f10932m, this.f10931l, this.f10930k).toString());
        objectNode.a("passive_impl", FbLocationPassiveListenerProvider.m11375a(this.f10927h, this.f10929j, this.f10930k).toString());
        objectNode.a("zero_rating_interstitial", this.f10928i.a(ZeroFeatureKey.LOCATION_SERVICES_INTERSTITIAL));
        objectNode.c("sensors", m11367m());
        return objectNode;
    }

    public static ArrayNode m11360a(Collection<String> collection) {
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
        for (String h : collection) {
            arrayNode.h(h);
        }
        return arrayNode;
    }

    private JsonNode m11364d() {
        String str;
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        objectNode.a("enabled", this.f10923d.a());
        objectNode.a("sleep_policy", m11365e());
        String str2 = "can_always_scan";
        if (VERSION.SDK_INT < 18) {
            str = "unsupported";
        } else {
            Preconditions.checkState(VERSION.SDK_INT >= 18);
            str = Boolean.toString(this.f10926g.isScanAlwaysAvailable());
        }
        objectNode.a(str2, str);
        return objectNode;
    }

    private String m11365e() {
        try {
            switch (this.f10924e.m11373a("wifi_sleep_policy")) {
                case 0:
                    return "default";
                case 1:
                    return "never_while_plugged";
                case 2:
                    return "never";
            }
        } catch (SettingNotFoundException e) {
        }
        return "unknown";
    }

    private JsonNode m11366h() {
        String a;
        ObjectNode c = JsonNodeFactory.a.c();
        c.a("system_supports_bluetooth", this.f10921b.hasSystemFeature("android.hardware.bluetooth"));
        c.a("system_supports_bluetooth_low_energy", this.f10921b.hasSystemFeature("android.hardware.bluetooth_le"));
        c.a("has_bluetooth_permission", m11363b(this.f10920a.checkCallingOrSelfPermission("android.permission.BLUETOOTH")));
        c.a("has_bluetooth_admin_permission", m11363b(this.f10920a.checkCallingOrSelfPermission("android.permission.BLUETOOTH_ADMIN")));
        String str = "bluetooth_enabled";
        if (VERSION.SDK_INT >= 17) {
            Preconditions.checkState(VERSION.SDK_INT >= 17);
            a = m11361a(Global.getInt(this.f10925f, "bluetooth_on", -1));
        } else {
            a = m11361a(Secure.getInt(this.f10925f, "bluetooth_on", -1));
        }
        c.a(str, a);
        return c;
    }

    public static String m11361a(int i) {
        switch (i) {
            case -1:
                return "unsupported";
            case 0:
                return Boolean.FALSE.toString();
            default:
                return Boolean.TRUE.toString();
        }
    }

    private static String m11363b(int i) {
        switch (i) {
            case -1:
                return Boolean.FALSE.toString();
            case 0:
                return Boolean.TRUE.toString();
            default:
                return "unknown";
        }
    }

    private JsonNode m11367m() {
        ArrayNode b = JsonNodeFactory.a.b();
        for (Sensor sensor : this.f10933n.getSensorList(-1)) {
            ObjectNode c = JsonNodeFactory.a.c();
            c.a("name", sensor.getName());
            c.a("type", SensorType.m11378a(sensor.getType(), "unknown"));
            b.a(c);
        }
        return b;
    }
}
