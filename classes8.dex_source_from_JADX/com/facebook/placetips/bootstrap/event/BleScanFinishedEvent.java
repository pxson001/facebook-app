package com.facebook.placetips.bootstrap.event;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.placetips.bootstrap.data.BleScanResult;

/* compiled from: search_filter_id */
public class BleScanFinishedEvent extends PlaceTipsEvent {
    private final BleScanResult f3839a;

    public BleScanFinishedEvent(BleScanResult bleScanResult) {
        this.f3839a = bleScanResult;
    }

    public final String m3731a() {
        if (this.f3839a.f3835e == 0) {
            return StringFormatUtil.formatStrLocaleSafe("Empty Ble Scan: %d millis", Long.valueOf(this.f3839a.f3834d));
        }
        return StringFormatUtil.formatStrLocaleSafe("Successful Ble Scan: %d millis\n%d detection events across %d devices", Long.valueOf(this.f3839a.f3834d), Integer.valueOf(this.f3839a.f3835e), Integer.valueOf(this.f3839a.f3831a.size()));
    }
}
