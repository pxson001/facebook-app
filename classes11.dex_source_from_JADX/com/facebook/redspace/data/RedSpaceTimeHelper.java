package com.facebook.redspace.data;

import android.content.res.Resources;
import com.facebook.common.time.Clock;
import com.facebook.common.time.TimeConversions;
import com.facebook.common.timeformat.DefaultTimeFormatUtil;
import com.facebook.common.timeformat.DefaultTimeFormatUtil.RelativeTimePeriod;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;

/* compiled from: Platform Faceweb Picker Flow */
public class RedSpaceTimeHelper {
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<Clock> f11879a = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<Resources> f11880b = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<DefaultTimeFormatUtil> f11881c = UltralightRuntime.b;

    /* compiled from: Platform Faceweb Picker Flow */
    /* synthetic */ class C14111 {
        static final /* synthetic */ int[] f11878a = new int[RelativeTimePeriod.values().length];

        static {
            try {
                f11878a[RelativeTimePeriod.LESS_THAN_ONE_DAY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f11878a[RelativeTimePeriod.LESS_THAN_4_DAYS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f11878a[RelativeTimePeriod.LESS_THAN_MIN.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f11878a[RelativeTimePeriod.LESS_THAN_5_MINS.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f11878a[RelativeTimePeriod.LESS_THAN_HOUR.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f11878a[RelativeTimePeriod.SAME_DAY.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f11878a[RelativeTimePeriod.SAME_YEAR.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f11878a[RelativeTimePeriod.DIFFERENT_YEAR.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    public final String m12323a(long j) {
        long a = ((Clock) this.f11879a.get()).a() - j;
        switch (C14111.f11878a[((DefaultTimeFormatUtil) this.f11881c.get()).b(j).ordinal()]) {
            case 1:
            case 2:
                return ((Resources) this.f11880b.get()).getQuantityString(2131689635, (int) TimeConversions.a(a), new Object[]{Integer.valueOf((int) TimeConversions.a(a))});
            case 3:
                return ((Resources) this.f11880b.get()).getString(2131235779);
            default:
                return ((DefaultTimeFormatUtil) this.f11881c.get()).a(TimeFormatStyle.STREAM_RELATIVE_STYLE, j);
        }
    }
}
