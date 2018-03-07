package com.facebook.timeline.tempprofilepic;

import com.facebook.common.timeformat.DefaultTimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.inject.Assisted;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

/* compiled from: facecast_pre_broadcast_exit */
public class ExpirationDialogModel {
    private static final String f14943a = null;
    public static Calendar f14944b;
    private final DefaultTimeFormatUtil f14945c;
    private final long f14946d;
    public int f14947e;
    public int f14948f;
    public int f14949g;

    @Inject
    public ExpirationDialogModel(DefaultTimeFormatUtil defaultTimeFormatUtil, @Assisted Long l) {
        this.f14945c = defaultTimeFormatUtil;
        this.f14946d = l.longValue();
    }

    public final long m18781d() {
        return m18779k() / 1000;
    }

    private long m18779k() {
        if (!m18783f()) {
            return 0;
        }
        Calendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.clear(11);
        gregorianCalendar.clear(12);
        gregorianCalendar.clear(13);
        gregorianCalendar.clear(14);
        gregorianCalendar.add(6, this.f14947e);
        gregorianCalendar.set(11, this.f14948f);
        gregorianCalendar.set(12, this.f14949g);
        return gregorianCalendar.getTimeInMillis();
    }

    public final String m18782e() {
        long k = m18779k();
        if (k == 0) {
            return f14943a;
        }
        return this.f14945c.a(TimeFormatStyle.DAY_HOUR_FUTURE_STYLE, k);
    }

    public final boolean m18783f() {
        return (this.f14947e == -1 || this.f14948f == -1 || this.f14949g == -1) ? false : true;
    }

    public final void m18784g() {
        this.f14947e = -1;
        this.f14948f = -1;
        this.f14949g = -1;
    }

    public final void m18780a(int i, int i2) {
        Calendar calendar = (Calendar) f14944b.clone();
        calendar.add(i, i2);
        m18777a(calendar);
    }

    public final void m18785h() {
        if (this.f14946d == 0) {
            m18784g();
            return;
        }
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(this.f14946d * 1000);
        if (instance.before(f14944b)) {
            m18784g();
        } else {
            m18777a(instance);
        }
    }

    public final boolean m18786i() {
        if (this.f14946d == 0) {
            return false;
        }
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(this.f14946d * 1000);
        return instance.after(f14944b);
    }

    private void m18777a(Calendar calendar) {
        calendar.add(12, 15 - (calendar.get(12) % 15));
        Calendar calendar2 = (Calendar) f14944b.clone();
        m18778c(calendar2);
        Calendar calendar3 = (Calendar) calendar.clone();
        m18778c(calendar3);
        this.f14947e = (int) TimeUnit.DAYS.convert(calendar3.getTimeInMillis() - calendar2.getTimeInMillis(), TimeUnit.MILLISECONDS);
        this.f14948f = calendar.get(11);
        this.f14949g = calendar.get(12);
    }

    public static void m18778c(Calendar calendar) {
        calendar.set(11, calendar.getActualMinimum(11));
        calendar.set(12, calendar.getActualMinimum(12));
        calendar.set(13, calendar.getActualMinimum(13));
        calendar.set(14, calendar.getActualMinimum(14));
    }
}
