package com.facebook.placetips.pulsarcore.bluetooth;

import android.content.Context;
import android.content.pm.PackageManager;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: method/user.initiatePreconfirmation */
public class BluetoothSupportChecker {
    private final Context f13556a;
    private final PackageManager f13557b;

    public static BluetoothSupportChecker m19940b(InjectorLike injectorLike) {
        return new BluetoothSupportChecker((Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public BluetoothSupportChecker(Context context) {
        this.f13556a = context;
        this.f13557b = context.getPackageManager();
    }

    public final boolean m19941a() {
        return m19944d() && this.f13557b.hasSystemFeature("android.hardware.bluetooth");
    }

    public final boolean m19942b() {
        return m19944d() && this.f13557b.hasSystemFeature("android.hardware.bluetooth_le");
    }

    public final boolean m19943c() {
        return m19939a("android.permission.BLUETOOTH_ADMIN");
    }

    public final boolean m19944d() {
        return m19939a("android.permission.BLUETOOTH");
    }

    private boolean m19939a(String str) {
        return this.f13557b.checkPermission(str, this.f13556a.getPackageName()) == 0;
    }
}
