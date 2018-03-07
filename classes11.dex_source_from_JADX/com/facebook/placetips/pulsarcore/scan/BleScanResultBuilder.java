package com.facebook.placetips.pulsarcore.scan;

import com.facebook.common.time.Clock;
import com.facebook.common.time.MonotonicClock;
import com.facebook.placetips.bootstrap.data.BleBroadcast;
import com.facebook.placetips.bootstrap.data.BleBroadcastSummary;
import java.util.Comparator;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: TURN */
public class BleScanResultBuilder {
    public final Clock f10760a;
    public final MonotonicClock f10761b;
    public Map<BleBroadcast, BleBroadcastSummary> f10762c;
    public int f10763d;
    public long f10764e;
    public long f10765f;

    /* compiled from: TURN */
    public class C12781 implements Comparator<BleBroadcastSummary> {
        final /* synthetic */ BleScanResultBuilder f10759a;

        public C12781(BleScanResultBuilder bleScanResultBuilder) {
            this.f10759a = bleScanResultBuilder;
        }

        public int compare(Object obj, Object obj2) {
            BleBroadcastSummary bleBroadcastSummary = (BleBroadcastSummary) obj;
            BleBroadcastSummary bleBroadcastSummary2 = (BleBroadcastSummary) obj2;
            int b = bleBroadcastSummary.b();
            int b2 = bleBroadcastSummary2.b();
            if (b == b2) {
                b = bleBroadcastSummary.c();
                b2 = bleBroadcastSummary2.c();
            }
            if (b > b2) {
                return -1;
            }
            return b < b2 ? 1 : 0;
        }
    }

    @Inject
    public BleScanResultBuilder(Clock clock, MonotonicClock monotonicClock) {
        this.f10760a = clock;
        this.f10761b = monotonicClock;
    }
}
