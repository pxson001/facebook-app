package com.facebook.placetips.pulsarcore;

import android.bluetooth.BluetoothAdapter;
import com.facebook.inject.Lazy;
import com.facebook.location.FbLocationStatusUtil;
import com.facebook.placetips.bootstrap.PlaceTipsDebugStatusDataProvider;
import com.facebook.placetips.pulsarcore.bluetooth.BluetoothSupportChecker;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: The indicator needs to be set up. Please call setIndicator(...) beforehand. */
public class PlaceTipsBleDebugStatusProvider implements PlaceTipsDebugStatusDataProvider {
    private final Lazy<FbLocationStatusUtil> f10645a;
    private final Lazy<BluetoothSupportChecker> f10646b;
    private final Provider<BluetoothAdapter> f10647c;

    @Inject
    public PlaceTipsBleDebugStatusProvider(Lazy<FbLocationStatusUtil> lazy, Lazy<BluetoothSupportChecker> lazy2, Provider<BluetoothAdapter> provider) {
        this.f10645a = lazy;
        this.f10646b = lazy2;
        this.f10647c = provider;
    }

    public final CharSequence m11175a() {
        boolean z = false;
        if (((BluetoothSupportChecker) this.f10646b.get()).a()) {
            boolean z2;
            BluetoothAdapter bluetoothAdapter = (BluetoothAdapter) this.f10647c.get();
            if (bluetoothAdapter == null || !bluetoothAdapter.isEnabled()) {
                z2 = false;
            } else {
                z2 = true;
            }
            z = z2;
        }
        return new StringBuilder("-------------BLE RELATED DATA-------------\nDevice Location Status: ").append(((FbLocationStatusUtil) this.f10645a.get()).b().a).append("\nIs Bluetooth Supported: ").append(((BluetoothSupportChecker) this.f10646b.get()).a()).append("\nIs BLE Supported: ").append(((BluetoothSupportChecker) this.f10646b.get()).b()).append("\nHas Bluetooth Permission: ").append(((BluetoothSupportChecker) this.f10646b.get()).d()).append("\nHas Bluetooth Admin Permission: ").append(((BluetoothSupportChecker) this.f10646b.get()).c()).append("\nIs Bluetooth On: ").append(z).append("\n\n-------------BLE QE-------------\nEnabled: false");
    }
}
