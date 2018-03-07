package com.facebook.funnellogger.beacon;

import android.content.Context;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.funnellogger.Funnel;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.io.File;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: tap_back_button */
public class BeaconLogger {
    public static final String f4355a = BeaconLogger.class.getSimpleName();
    public final AnalyticsLogger f4356b;
    private final Context f4357c;
    private final ExecutorService f4358d;
    private int f4359e = -1;

    @Inject
    public BeaconLogger(Context context, AnalyticsLogger analyticsLogger, ExecutorService executorService) {
        this.f4357c = context.getApplicationContext();
        this.f4356b = analyticsLogger;
        this.f4358d = executorService;
    }

    public final void m8050a(BeaconType beaconType, Funnel funnel) {
        if (beaconType == BeaconType.FUNNEL_STARTED) {
            this.f4359e = this.f4359e == Integer.MAX_VALUE ? 0 : this.f4359e + 1;
            if (this.f4359e % 11 == 0) {
                funnel.i = true;
                m8048a(beaconType);
            }
        } else if (funnel.i) {
            m8048a(beaconType);
        }
    }

    private void m8048a(BeaconType beaconType) {
        ExecutorDetour.a(this.f4358d, new 1(this, beaconType), 1772441022);
    }

    @Nullable
    public static File m8049b(BeaconLogger beaconLogger, BeaconType beaconType) {
        File file = new File(beaconLogger.f4357c.getDir("funnel_beacon", 0), beaconType.name());
        if (file.isDirectory() || file.mkdir()) {
            return file;
        }
        return null;
    }
}
