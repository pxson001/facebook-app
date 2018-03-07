package com.facebook.backstage.consumption;

import android.content.res.Resources;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.time.Clock;
import java.util.TimeZone;
import javax.inject.Inject;

/* compiled from: rtc_instant_button_nux_chat_head */
public class TimeUtil {
    private static final String f4651a = TimeUtil.class.getSimpleName();
    private final Clock f4652b;
    private final AbstractFbErrorReporter f4653c;

    @Inject
    public TimeUtil(Clock clock, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f4652b = clock;
        this.f4653c = abstractFbErrorReporter;
    }

    public final String m4565a(Resources resources, long j) {
        if (this.f4652b.a() - j < 0) {
            this.f4653c.a(f4651a, "Incorrect time found. time : " + j + ", now : " + this.f4652b.a() + ", time zone: " + TimeZone.getDefault().getRawOffset());
            return null;
        }
        String quantityString;
        if (j != 0) {
            int round = Math.round(((float) ((this.f4652b.a() - j) / 1000)) / 60.0f);
            if (round < 0) {
                this.f4653c.a(f4651a, "Incorrect minutes calculation. time : " + j + ", now : " + this.f4652b.a() + ", time zone: " + TimeZone.getDefault().getRawOffset());
                return null;
            } else if (round <= 60) {
                quantityString = resources.getQuantityString(2131689750, round, new Object[]{Integer.valueOf(round)});
            } else {
                int round2 = Math.round((float) (((long) round) / 60));
                quantityString = resources.getQuantityString(2131689751, round2, new Object[]{Integer.valueOf(round2)});
                if (round2 < 0) {
                    this.f4653c.a(f4651a, "Incorrect hour calculation. time : " + j + ", now : " + this.f4652b.a() + ", time zone: " + TimeZone.getDefault().getRawOffset());
                    return null;
                }
            }
        }
        quantityString = null;
        return quantityString;
    }
}
