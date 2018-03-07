package com.facebook.pages.common.contactinbox.util;

import android.content.Context;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.timeformat.DefaultTimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.inject.InjectorLike;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: spotify_unsave */
public class PagesContactInboxTimeUtils {
    private final Clock f1460a;
    private final TimeFormatUtil f1461b;

    /* compiled from: spotify_unsave */
    public enum AlertType {
        TITLE,
        DETAIL
    }

    public static PagesContactInboxTimeUtils m2134b(InjectorLike injectorLike) {
        return new PagesContactInboxTimeUtils((Clock) SystemClockMethodAutoProvider.a(injectorLike), (TimeFormatUtil) DefaultTimeFormatUtil.a(injectorLike));
    }

    @Inject
    public PagesContactInboxTimeUtils(Clock clock, TimeFormatUtil timeFormatUtil) {
        this.f1460a = clock;
        this.f1461b = timeFormatUtil;
    }

    public final long m2136a(long j) {
        return (j - this.f1460a.a()) / 86400000;
    }

    public final boolean m2138b(long j) {
        long a = m2136a(j);
        return a <= 10 && a >= 0;
    }

    public final int m2135a(Context context, long j) {
        long a = m2136a(j);
        if (a < 0 && a > 10) {
            return -1;
        }
        if (a <= 5) {
            return context.getResources().getColor(2131363023);
        }
        return context.getResources().getColor(2131363024);
    }

    @Nullable
    public final String m2137b(Context context, long j) {
        long a = m2136a(j);
        if (a < 0 && a > 10) {
            return null;
        }
        if (a <= 0) {
            return context.getResources().getString(2131241670);
        }
        return context.getResources().getString(2131241669, new Object[]{this.f1461b.a(TimeFormatStyle.MONTH_DAY_YEAR_STYLE, j)});
    }
}
