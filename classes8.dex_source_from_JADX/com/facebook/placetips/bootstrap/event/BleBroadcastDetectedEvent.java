package com.facebook.placetips.bootstrap.event;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.placetips.bootstrap.data.BleBroadcast;

/* compiled from: search_filter_name */
public class BleBroadcastDetectedEvent extends PlaceTipsEvent {
    private final BleBroadcast f3837a;
    private final int f3838b;

    public BleBroadcastDetectedEvent(BleBroadcast bleBroadcast, int i) {
        this.f3837a = bleBroadcast;
        this.f3838b = i;
    }

    public final String m3730a() {
        return StringFormatUtil.formatStrLocaleSafe("BLE Broadcast Detected:\n  MAC: %s\n  RSSI: %d\n%s\n", this.f3837a.f3826a.getAddress(), Integer.valueOf(this.f3838b), this.f3837a.f3828c);
    }
}
