package com.facebook.placetips.pulsarcore;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.placetips.pulsarcore.scan.BleScanner;

/* compiled from: There is corrupt tiles JSON data */
public class BleScannerMethodAutoProvider extends AbstractProvider<BleScanner> {
    public Object get() {
        return PulsarCoreModule.m11185a(IdBasedProvider.a(this, 9608), IdBasedProvider.a(this, 9609));
    }
}
