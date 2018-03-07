package com.facebook.placetips.pulsarcore.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import com.facebook.common.android.PackageManagerMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: last_register_time */
public class PulsarManifestComponentManager {
    private final PackageManager f9558a;
    private final ComponentName f9559b;
    private final ComponentName f9560c;

    public static PulsarManifestComponentManager m9938b(InjectorLike injectorLike) {
        return new PulsarManifestComponentManager(PackageManagerMethodAutoProvider.a(injectorLike), (Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public PulsarManifestComponentManager(PackageManager packageManager, Context context) {
        this.f9558a = packageManager;
        this.f9559b = new ComponentName(context, BluetoothScanFinishedReceiver.class);
        this.f9560c = new ComponentName(context, PulsarService.class);
    }

    public final void m9940a(boolean z) {
        m9937a(m9939c(z), this.f9559b);
    }

    public final void m9941b(boolean z) {
        m9937a(m9939c(z), this.f9560c);
    }

    private static int m9939c(boolean z) {
        return z ? 1 : 2;
    }

    private void m9937a(int i, ComponentName componentName) {
        if (this.f9558a.getComponentEnabledSetting(componentName) != i) {
            this.f9558a.setComponentEnabledSetting(componentName, i, 1);
        }
    }
}
