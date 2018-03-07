package com.facebook.analytics2.beacon;

import android.content.Context;
import com.facebook.analytics2.beacon.idgenerator.BeaconIdGenerator;
import com.facebook.analytics2.logger.Analytics2Logger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: tap_back_button */
public class BeaconLogger {
    public final Analytics2Logger f3263a;
    public final Context f3264b;
    public final String f3265c;
    public final String f3266d;
    public final int f3267e;
    public final boolean f3268f;
    @Nullable
    public BeaconIdGenerator f3269g;
    public int f3270h = -1;

    public static BeaconLogger m5411a(Context context, Analytics2Logger analytics2Logger) {
        return new BeaconLogger(analytics2Logger, context, "normal", "normal", 97, false);
    }

    public static BeaconLogger m5412b(Context context, Analytics2Logger analytics2Logger) {
        return new BeaconLogger(analytics2Logger, context, "high", "hipri", 11, true);
    }

    private BeaconLogger(Analytics2Logger analytics2Logger, Context context, String str, String str2, int i, boolean z) {
        this.f3263a = analytics2Logger;
        this.f3264b = context.getApplicationContext();
        this.f3265c = str;
        this.f3266d = str2;
        this.f3267e = i;
        this.f3268f = z;
    }
}
