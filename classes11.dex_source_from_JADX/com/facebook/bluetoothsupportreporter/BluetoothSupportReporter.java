package com.facebook.bluetoothsupportreporter;

import android.content.Context;
import android.content.pm.PackageManager;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.init.AppInitLockFuture;
import com.facebook.common.init.INeedInit;
import com.facebook.inject.Lazy;
import com.google.common.util.concurrent.MoreExecutors;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: media_error_malformed */
public class BluetoothSupportReporter implements INeedInit {
    public final Context f5484a;
    public final Provider<AnalyticsLogger> f5485b;
    private final Lazy<AppInitLockFuture> f5486c;

    /* compiled from: media_error_malformed */
    class C07131 implements Runnable {
        final /* synthetic */ BluetoothSupportReporter f5483a;

        C07131(BluetoothSupportReporter bluetoothSupportReporter) {
            this.f5483a = bluetoothSupportReporter;
        }

        public void run() {
            BluetoothSupportReporter bluetoothSupportReporter = this.f5483a;
            PackageManager packageManager = bluetoothSupportReporter.f5484a.getPackageManager();
            boolean hasSystemFeature = packageManager.hasSystemFeature("android.hardware.bluetooth");
            ((AnalyticsLogger) bluetoothSupportReporter.f5485b.get()).a(new HoneyClientEvent("android_bluetooth_support_detection").a("bluetooth_supported", hasSystemFeature).a("ble_supported", packageManager.hasSystemFeature("android.hardware.bluetooth_le")));
        }
    }

    @Inject
    public BluetoothSupportReporter(Context context, Provider<AnalyticsLogger> provider, Lazy<AppInitLockFuture> lazy) {
        this.f5484a = context;
        this.f5485b = provider;
        this.f5486c = lazy;
    }

    public void init() {
        ((AppInitLockFuture) this.f5486c.get()).a(new C07131(this), MoreExecutors.a());
    }
}
