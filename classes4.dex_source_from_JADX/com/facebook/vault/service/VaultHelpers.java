package com.facebook.vault.service;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Build.VERSION;
import com.facebook.common.hardware.BatteryStateManager;
import com.facebook.common.hardware.SystemBatteryStateManager;
import com.facebook.device.DeviceConditionHelper;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.vault.prefs.DeviceIDPref;
import com.facebook.vault.prefs.SyncModePref;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: legacy_graph_api_privacy_json */
public class VaultHelpers {
    private static final Class<?> f9432b = VaultHelpers.class;
    Provider<Boolean> f9433a;
    public Context f9434c;
    public SyncModePref f9435d;
    private DeviceIDPref f9436e;
    public DeviceConditionHelper f9437f;
    private SystemBatteryStateManager f9438g;

    public static VaultHelpers m9810b(InjectorLike injectorLike) {
        return new VaultHelpers((Context) injectorLike.getInstance(Context.class), IdBasedProvider.a(injectorLike, 4362), SyncModePref.m9802a(injectorLike), DeviceIDPref.m9819a(injectorLike), SystemBatteryStateManager.a(injectorLike), DeviceConditionHelper.a(injectorLike));
    }

    @Inject
    public VaultHelpers(Context context, Provider<Boolean> provider, SyncModePref syncModePref, DeviceIDPref deviceIDPref, BatteryStateManager batteryStateManager, DeviceConditionHelper deviceConditionHelper) {
        this.f9434c = context;
        this.f9433a = provider;
        this.f9435d = syncModePref;
        this.f9436e = deviceIDPref;
        this.f9437f = deviceConditionHelper;
        this.f9438g = batteryStateManager;
    }

    public static VaultHelpers m9809a(InjectorLike injectorLike) {
        return m9810b(injectorLike);
    }

    public final boolean m9811a() {
        return ((Boolean) this.f9433a.get()).booleanValue() && VERSION.SDK_INT <= 22;
    }

    public final boolean m9814b() {
        return m9811a() && !this.f9435d.m9804a().equals("OFF");
    }

    public final boolean m9812a(int i) {
        if (!m9811a()) {
            return false;
        }
        if (this.f9436e.m9821a() == 0) {
            return false;
        }
        if (!UploadManagerConnectivity.a(this.f9434c)) {
            return false;
        }
        if (i == 8) {
            return true;
        }
        if (m9817d()) {
            Object obj;
            if (i == 12 || i == 11) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null) {
                return false;
            }
        }
        if (!((ConnectivityManager) this.f9434c.getSystemService("connectivity")).getBackgroundDataSetting()) {
            return false;
        }
        boolean b;
        String a = this.f9435d.m9804a();
        if (a.equals("WIFI_ONLY")) {
            b = this.f9437f.b();
        } else if (a.equals("MOBILE_RADIO")) {
            b = UploadManagerConnectivity.a(this.f9434c);
        } else {
            b = false;
        }
        return b;
    }

    public final boolean m9816c() {
        return this.f9437f.b();
    }

    public final boolean m9817d() {
        return this.f9438g.a(15);
    }

    public final Intent m9813b(int i) {
        Intent intent = new Intent(this.f9434c, VaultSyncService.class);
        intent.putExtra("sync_reason", i);
        return intent;
    }

    public final void m9815c(int i) {
        if (m9812a(i)) {
            try {
                this.f9434c.startService(m9813b(i));
            } catch (SecurityException e) {
            }
        }
    }

    public final boolean m9818e() {
        return this.f9436e.m9821a() == 0;
    }
}
