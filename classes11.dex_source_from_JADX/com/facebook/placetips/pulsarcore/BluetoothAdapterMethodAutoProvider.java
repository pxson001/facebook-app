package com.facebook.placetips.pulsarcore;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: The only valid indices for drawer's child are 0 or 1. Got  */
public class BluetoothAdapterMethodAutoProvider extends AbstractProvider<BluetoothAdapter> {
    public static BluetoothAdapter m11174b(InjectorLike injectorLike) {
        return PulsarCoreModule.m11184a((Context) injectorLike.getInstance(Context.class));
    }

    public Object get() {
        return PulsarCoreModule.m11184a((Context) getInstance(Context.class));
    }
}
