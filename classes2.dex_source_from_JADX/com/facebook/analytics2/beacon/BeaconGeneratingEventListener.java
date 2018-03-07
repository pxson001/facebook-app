package com.facebook.analytics2.beacon;

import com.facebook.analytics2.beacon.idgenerator.BeaconIdGenerator;
import com.facebook.analytics2.logger.EventBuilder;
import com.facebook.analytics2.logger.EventListener;
import com.facebook.analytics2.logger.EventLogType;
import java.io.File;

/* compiled from: tap_behavior */
public class BeaconGeneratingEventListener implements EventListener {
    private final BeaconLogger f3262a;

    public BeaconGeneratingEventListener(BeaconLogger beaconLogger) {
        this.f3262a = beaconLogger;
    }

    public final void mo733a() {
        BeaconLogger beaconLogger = this.f3262a;
        beaconLogger.f3270h = beaconLogger.f3270h == Integer.MAX_VALUE ? (Integer.MAX_VALUE % beaconLogger.f3267e) + 1 : beaconLogger.f3270h + 1;
        if (beaconLogger.f3270h % beaconLogger.f3267e == 0) {
            EventBuilder a = beaconLogger.f3263a.m5368a("marauder", "pigeon_beacon", EventLogType.CLIENT_EVENT, beaconLogger.f3268f);
            if (beaconLogger.f3269g == null) {
                beaconLogger.f3269g = new BeaconIdGenerator(new File(beaconLogger.f3264b.getDir("analytics_beacon", 0), beaconLogger.f3265c));
            }
            long a2 = beaconLogger.f3269g.m5689a();
            a = a.m5389d("tier", beaconLogger.f3266d).m5381a("beacon_id", Integer.valueOf(BeaconIdGenerator.m5680a(a2))).m5381a("beacon_session_id", Integer.valueOf(BeaconIdGenerator.m5682b(a2)));
            a.f3218g = true;
            a.m5390d();
        }
    }
}
