package com.facebook.placetips.pulsarcore;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.Build.VERSION;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.placetips.pulsarcore.scan.BleScanner;
import com.facebook.placetips.pulsarcore.scan.BleScannerImpl;
import com.facebook.placetips.pulsarcore.scan.EmptyBleScanner;
import javax.inject.Provider;

@InjectorModule
/* compiled from: The given position is not within the People You May Know section */
public class PulsarCoreModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    public static BleScanner m11185a(Provider<BleScannerImpl> provider, Provider<EmptyBleScanner> provider2) {
        if (VERSION.SDK_INT >= 18) {
            return (BleScanner) provider.get();
        }
        return (BleScanner) provider2.get();
    }

    @ProviderMethod
    static BluetoothAdapter m11184a(Context context) {
        if (VERSION.SDK_INT >= 18) {
            return ((BluetoothManager) context.getSystemService("bluetooth")).getAdapter();
        }
        return BluetoothAdapter.getDefaultAdapter();
    }
}
