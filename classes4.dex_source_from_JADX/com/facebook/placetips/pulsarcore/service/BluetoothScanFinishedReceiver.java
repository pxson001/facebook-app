package com.facebook.placetips.pulsarcore.service;

import com.facebook.content.DynamicSecureBroadcastReceiver;

/* compiled from: last_refresh_time_ms */
public class BluetoothScanFinishedReceiver extends DynamicSecureBroadcastReceiver {
    public BluetoothScanFinishedReceiver() {
        super("android.bluetooth.adapter.action.DISCOVERY_FINISHED", new BluetoothDiscoveryFinishedActionReceiver());
    }
}
