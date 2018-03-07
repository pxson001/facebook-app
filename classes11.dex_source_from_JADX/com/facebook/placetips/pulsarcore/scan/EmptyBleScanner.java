package com.facebook.placetips.pulsarcore.scan;

import com.facebook.placetips.bootstrap.data.BleScanResult;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: TOP_BOTTOM */
public class EmptyBleScanner implements BleScanner {
    public final ListenableFuture<BleScanResult> mo288a(long j) {
        return Futures.a(new UnsupportedOperationException("Cannot start a ble scan with the EmptyBleScanner"));
    }
}
