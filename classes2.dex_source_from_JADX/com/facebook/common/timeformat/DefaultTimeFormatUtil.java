package com.facebook.common.timeformat;

import android.content.Context;
import android.content.res.Resources;
import android.text.format.DateUtils;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.i18n.BasicDateTimeFormat;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.time.TimeConversions;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.resources.utils.ResourceUtils;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: request_priority */
public class DefaultTimeFormatUtil implements TimeFormatUtil {
    private static final Class f7282a = DefaultTimeFormatUtil.class;
    public static TimeFormatUtil f7283b;
    private static volatile DefaultTimeFormatUtil f7284j;
    public final Context f7285c;
    public final Clock f7286d;
    private final Provider<TimeZone> f7287e;
    private final BasicDateTimeFormat f7288f;
    private Calendar f7289g;
    private Calendar f7290h;
    private AbstractFbErrorReporter f7291i;

    /* compiled from: request_priority */
    public enum RelativeTimePeriod {
        LESS_THAN_MIN,
        LESS_THAN_5_MINS,
        LESS_THAN_HOUR,
        SAME_DAY,
        LESS_THAN_ONE_DAY,
        LESS_THAN_4_DAYS,
        SAME_YEAR,
        DIFFERENT_YEAR
    }

    public static com.facebook.common.timeformat.DefaultTimeFormatUtil m11785a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f7284j;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.common.timeformat.DefaultTimeFormatUtil.class;
        monitor-enter(r1);
        r0 = f7284j;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m11789b(r0);	 Catch:{ all -> 0x0035 }
        f7284j = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7284j;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.timeformat.DefaultTimeFormatUtil.a(com.facebook.inject.InjectorLike):com.facebook.common.timeformat.DefaultTimeFormatUtil");
    }

    private static DefaultTimeFormatUtil m11789b(InjectorLike injectorLike) {
        return new DefaultTimeFormatUtil((Context) injectorLike.getInstance(Context.class), SystemClockMethodAutoProvider.m1498a(injectorLike), IdBasedProvider.m1811a(injectorLike, 4486), BasicDateTimeFormat.m11815a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike));
    }

    @Inject
    public DefaultTimeFormatUtil(Context context, Clock clock, Provider<TimeZone> provider, BasicDateTimeFormat basicDateTimeFormat, FbErrorReporter fbErrorReporter) {
        this.f7285c = context;
        this.f7286d = clock;
        this.f7291i = fbErrorReporter;
        this.f7287e = provider;
        this.f7288f = basicDateTimeFormat;
        TimeZone timeZone = (TimeZone) provider.get();
        this.f7289g = Calendar.getInstance(timeZone);
        this.f7290h = Calendar.getInstance(timeZone);
    }

    public final String mo1649a(TimeFormatStyle timeFormatStyle, long j) {
        if (timeFormatStyle == TimeFormatStyle.STREAM_RELATIVE_STYLE) {
            return m11795g(j);
        }
        if (timeFormatStyle == TimeFormatStyle.NOTIFICATIONS_STREAM_RELATIVE_STYLE) {
            return m11796h(j);
        }
        if (timeFormatStyle == TimeFormatStyle.EXACT_STREAM_RELATIVE_STYLE) {
            return m11794f(j);
        }
        if (timeFormatStyle == TimeFormatStyle.EVENTS_RELATIVE_STYLE) {
            String a;
            Resources resources = this.f7285c.getResources();
            long a2 = j - this.f7286d.mo211a();
            if (a2 <= 0) {
                a = mo1649a(TimeFormatStyle.STREAM_RELATIVE_STYLE, j);
            } else if (a2 < 60000) {
                a = this.f7285c.getString(2131233743);
            } else if (a2 < 3600000) {
                a = ResourceUtils.m29971a(resources, 2131233741, 2131233742, (int) (a2 / 60000));
            } else if (a2 < 86400000) {
                if (new Date(j).getDate() == new Date().getDate()) {
                    a = ResourceUtils.m29971a(resources, 2131233739, 2131233740, (int) (a2 / 3600000));
                } else {
                    a = this.f7285c.getString(2131233751, new Object[]{DateUtils.formatDateTime(this.f7285c, j, 2561)});
                }
            } else {
                a = this.f7285c.getString(2131233726, new Object[]{DateUtils.formatDateTime(this.f7285c, j, 65560), DateUtils.formatDateTime(this.f7285c, j, 2561)});
            }
            return a;
        } else if (timeFormatStyle == TimeFormatStyle.FUZZY_RELATIVE_DATE_STYLE) {
            return m11799k(j);
        } else {
            if (timeFormatStyle == TimeFormatStyle.EVENTS_RELATIVE_DATE_STYLE) {
                return m11798j(j);
            }
            if (timeFormatStyle == TimeFormatStyle.EXACT_TIME_DATE_STYLE) {
                return m11800l(j);
            }
            if (timeFormatStyle == TimeFormatStyle.EXACT_TIME_DATE_DOT_STYLE) {
                return m11786a(j, 2131233749, 2131233752);
            }
            if (timeFormatStyle == TimeFormatStyle.HOUR_MINUTE_STYLE) {
                return DateUtils.formatDateTime(this.f7285c, j, 2561);
            }
            if (timeFormatStyle == TimeFormatStyle.WEEK_DAY_STYLE) {
                return DateUtils.formatDateTime(this.f7285c, j, 32770);
            }
            if (timeFormatStyle == TimeFormatStyle.MONTH_DAY_YEAR_STYLE) {
                return DateUtils.formatDateTime(this.f7285c, j, 65556);
            }
            if (timeFormatStyle == TimeFormatStyle.NUMERIC_MONTH_DAY_YEAR_STYLE) {
                return DateUtils.formatDateTime(this.f7285c, j, 131092);
            }
            if (timeFormatStyle == TimeFormatStyle.DATE_PICKER_STYLE) {
                return DateUtils.formatDateTime(this.f7285c, j, 98326);
            }
            if (timeFormatStyle == TimeFormatStyle.SHORT_DATE_STYLE) {
                return m11801m(j);
            }
            if (timeFormatStyle == TimeFormatStyle.THREAD_DATE_STYLE) {
                return m11792d(j);
            }
            if (timeFormatStyle == TimeFormatStyle.SHORTEST_RELATIVE_PAST_STYLE) {
                return m11802n(j);
            }
            if (timeFormatStyle == TimeFormatStyle.SHORTEST_RELATIVE_FUTURE_STYLE) {
                return m11803o(j);
            }
            if (timeFormatStyle == TimeFormatStyle.DAY_HOUR_FUTURE_STYLE) {
                return m11804p(j);
            }
            if (timeFormatStyle == TimeFormatStyle.MONTH_DAY_YEAR_SHORT_STYLE) {
                return m11805q(j);
            }
            if (timeFormatStyle == TimeFormatStyle.RFC1123_STYLE) {
                return m11806r(j);
            }
            if (timeFormatStyle == TimeFormatStyle.DURATION_LARGEST_UNIT_STYLE) {
                return m11807s(j);
            }
            throw new IllegalArgumentException("Unknown style");
        }
    }

    private long m11783a(long j, long j2) {
        return m11788b(j, j2) / 86400000;
    }

    public final long m11808a(long j) {
        return m11791c(j) / 86400000;
    }

    private long m11791c(long j) {
        return m11788b(this.f7286d.mo211a(), j);
    }

    private long m11788b(long j, long j2) {
        this.f7289g = m11787a(this.f7289g, j);
        this.f7289g.set(11, 0);
        this.f7289g.set(12, 0);
        this.f7289g.set(13, 0);
        this.f7289g.set(14, 0);
        this.f7290h = m11787a(this.f7290h, j2);
        this.f7290h.setTimeInMillis(j2);
        this.f7290h.set(11, 0);
        this.f7290h.set(12, 0);
        this.f7290h.set(13, 0);
        this.f7290h.set(14, 0);
        long timeInMillis = this.f7290h.getTimeInMillis() - this.f7289g.getTimeInMillis();
        boolean inDaylightTime = TimeZone.getDefault().inDaylightTime(this.f7289g.getTime());
        boolean inDaylightTime2 = TimeZone.getDefault().inDaylightTime(this.f7290h.getTime());
        if (inDaylightTime && !inDaylightTime2) {
            timeInMillis -= 3600000;
        } else if (!inDaylightTime && inDaylightTime2) {
            timeInMillis += 3600000;
        }
        if (!(timeInMillis % 86400000 == 0 || this.f7291i == null)) {
            this.f7291i.m2340a(f7282a.getName(), "getDayAlignedDiffMs result isn't aligned to day. It's off by " + String.valueOf(timeInMillis % 86400000));
        }
        return timeInMillis;
    }

    private String m11792d(long j) {
        long a = this.f7286d.mo211a() - j;
        if (a < 86400000) {
            return DateUtils.formatDateTime(this.f7285c, j, 2561);
        }
        if (a < 345600000) {
            return DateUtils.formatDateTime(this.f7285c, j, 32770);
        }
        if (a < 15552000000L) {
            return DateUtils.formatDateTime(this.f7285c, j, 65560);
        }
        return DateUtils.formatDateTime(this.f7285c, j, 65556);
    }

    private String m11794f(long j) {
        if (m11810b(j) != RelativeTimePeriod.LESS_THAN_MIN) {
            return m11795g(j);
        }
        int m = (int) TimeConversions.m11973m(this.f7286d.mo211a() - j);
        if (m < 0) {
            return this.f7285c.getString(2131233743);
        }
        return ResourceUtils.m29971a(this.f7285c.getResources(), 2131233730, 2131233729, m);
    }

    private String m11795g(long j) {
        Resources resources = this.f7285c.getResources();
        long a = this.f7286d.mo211a() - j;
        switch (1.a[m11810b(j).ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return this.f7285c.getString(2131233743);
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
            case 3:
                return ResourceUtils.m29971a(resources, 2131233735, 2131233736, (int) TimeConversions.m11970d(a));
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return ResourceUtils.m29971a(resources, 2131233731, 2131233733, (int) TimeConversions.m11967a(a));
            case 5:
                return this.f7285c.getString(2131233755, new Object[]{this.f7288f.m11818a().format(Long.valueOf(j))});
            case 6:
                return this.f7285c.getString(2131233754, new Object[]{this.f7288f.m11821d().format(Long.valueOf(j)), this.f7288f.m11818a().format(Long.valueOf(j))});
            case 7:
                return this.f7285c.getString(2131233726, new Object[]{this.f7288f.m11824g().format(Long.valueOf(j)), this.f7288f.m11818a().format(Long.valueOf(j))});
            default:
                return this.f7288f.m11819b().format(Long.valueOf(j));
        }
    }

    private String m11796h(long j) {
        Resources resources = this.f7285c.getResources();
        long a = this.f7286d.mo211a();
        long j2 = a - j;
        a = m11783a(a, j);
        if (a == -1) {
            return this.f7285c.getString(2131233755, new Object[]{this.f7288f.m11818a().format(Long.valueOf(j))});
        } else if (a >= -1 || a < -4) {
            switch (1.a[m11810b(j).ordinal()]) {
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    return this.f7285c.getString(2131233743);
                case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                case 3:
                    return ResourceUtils.m29971a(resources, 2131233735, 2131233736, (int) TimeConversions.m11970d(j2));
                case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                    return ResourceUtils.m29971a(resources, 2131233731, 2131233733, (int) TimeConversions.m11967a(j2));
                case 7:
                    return this.f7285c.getString(2131233726, new Object[]{this.f7288f.m11824g().format(Long.valueOf(j)), this.f7288f.m11818a().format(Long.valueOf(j))});
                default:
                    return this.f7288f.m11819b().format(Long.valueOf(j));
            }
        } else {
            return this.f7285c.getString(2131233754, new Object[]{this.f7288f.m11821d().format(Long.valueOf(j)), this.f7288f.m11818a().format(Long.valueOf(j))});
        }
    }

    public final RelativeTimePeriod m11810b(long j) {
        long a = this.f7286d.mo211a();
        return m11784a(a - j, j, a);
    }

    private RelativeTimePeriod m11797i(long j) {
        long a = this.f7286d.mo211a();
        return m11784a(j - a, j, a);
    }

    private RelativeTimePeriod m11784a(long j, long j2, long j3) {
        if (j < 60000) {
            return RelativeTimePeriod.LESS_THAN_MIN;
        }
        if (j < 300000) {
            return RelativeTimePeriod.LESS_THAN_5_MINS;
        }
        if (j < 3600000) {
            return RelativeTimePeriod.LESS_THAN_HOUR;
        }
        if (j < 86400000) {
            m11793d(j2, j3);
            if (this.f7289g.get(5) == this.f7290h.get(5)) {
                return RelativeTimePeriod.SAME_DAY;
            }
            return RelativeTimePeriod.LESS_THAN_ONE_DAY;
        } else if (j < 345600000) {
            return RelativeTimePeriod.LESS_THAN_4_DAYS;
        } else {
            m11793d(j2, j3);
            if (this.f7289g.get(1) == this.f7290h.get(1)) {
                return RelativeTimePeriod.SAME_YEAR;
            }
            return RelativeTimePeriod.DIFFERENT_YEAR;
        }
    }

    private String m11798j(long j) {
        long a = m11808a(j);
        if (a < 0) {
            return this.f7288f.m11819b().format(Long.valueOf(j));
        }
        if (a == 0) {
            return this.f7285c.getString(2131233747);
        }
        if (a == 1) {
            return this.f7285c.getString(2131233750);
        }
        if (a < 7) {
            return this.f7288f.m11820c().format(Long.valueOf(j));
        }
        return this.f7288f.m11819b().format(Long.valueOf(j));
    }

    private String m11799k(long j) {
        long a = this.f7286d.mo211a() - j;
        if (a < 60000) {
            return this.f7285c.getString(2131233743);
        }
        int c;
        int c2;
        if (a < 3600000) {
            c = m11790c(a, 60000);
            if (((long) c) < 60) {
                return ResourceUtils.m29971a(this.f7285c.getResources(), 2131233735, 2131233736, c);
            }
        }
        if (a < 86400000) {
            c2 = m11790c(a, 3600000);
            if (((long) c2) < 24) {
                return ResourceUtils.m29971a(this.f7285c.getResources(), 2131233731, 2131233733, c2);
            }
        }
        a = -m11791c(j);
        if (a < 172800000) {
            return this.f7285c.getString(2131233756);
        }
        if (a < 604800000) {
            return this.f7288f.m11820c().format(Long.valueOf(j));
        }
        if (a < 2592000000L) {
            c2 = m11790c(a, 604800000);
            return this.f7285c.getResources().getQuantityString(2131689559, c2, new Object[]{Integer.valueOf(c2)});
        }
        if (a < 31536000000L) {
            c = m11790c(a, 2592000000L);
            if (((long) c) < 12) {
                return this.f7285c.getResources().getQuantityString(2131689560, c, new Object[]{Integer.valueOf(c)});
            }
        }
        c2 = m11790c(a, 31536000000L);
        return this.f7285c.getResources().getQuantityString(2131689561, c2, new Object[]{Integer.valueOf(c2)});
    }

    private static int m11790c(long j, long j2) {
        return (int) (((j2 / 2) + j) / j2);
    }

    private String m11800l(long j) {
        return m11786a(j, 2131233748, 2131233751);
    }

    private String m11786a(long j, int i, int i2) {
        long a = m11808a(j);
        if (a == 0) {
            return this.f7285c.getString(i, new Object[]{DateUtils.formatDateTime(this.f7285c, j, 18945)});
        } else if (a == 1) {
            return this.f7285c.getString(i2, new Object[]{DateUtils.formatDateTime(this.f7285c, j, 18945)});
        } else if (a < 7) {
            return DateUtils.formatDateTime(this.f7285c, j, 51715);
        } else {
            return DateUtils.formatDateTime(this.f7285c, j, 84497);
        }
    }

    private String m11801m(long j) {
        long a = m11808a(j);
        if (a < 0) {
            return DateUtils.formatDateTime(this.f7285c, j, 65560);
        }
        if (a == 0) {
            return this.f7285c.getString(2131233747);
        }
        if (a == 1) {
            return this.f7285c.getString(2131233750);
        }
        return DateUtils.formatDateTime(this.f7285c, j, 65560);
    }

    private String m11802n(long j) {
        RelativeTimePeriod b = m11810b(j);
        Resources resources = this.f7285c.getResources();
        long a = this.f7286d.mo211a() - j;
        int d;
        switch (1.a[b.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
            case 3:
                d = (int) TimeConversions.m11970d(a);
                if (d <= 0) {
                    d = 1;
                }
                return resources.getString(2131233757, new Object[]{Integer.valueOf(d)});
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
            case 5:
                d = (int) TimeConversions.m11967a(a);
                if (d == 0) {
                    d = 1;
                }
                return resources.getString(2131233758, new Object[]{Integer.valueOf(d)});
            case 6:
            case 7:
                d = (int) TimeConversions.m11971f(a);
                if (d == 0) {
                    d = 1;
                }
                return resources.getString(2131233759, new Object[]{Integer.valueOf(d)});
            default:
                d = (int) TimeConversions.m11972k(a);
                if (d == 0) {
                    d = 1;
                }
                return resources.getString(2131233760, new Object[]{Integer.valueOf(d)});
        }
    }

    private String m11803o(long j) {
        RelativeTimePeriod i = m11797i(j);
        Resources resources = this.f7285c.getResources();
        long a = j - this.f7286d.mo211a();
        int a2;
        switch (1.a[i.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return resources.getString(2131233761);
            case 3:
                a2 = (int) TimeConversions.m11968a(a, 60000);
                if (a2 <= 0) {
                    a2 = 1;
                }
                return resources.getString(2131233762, new Object[]{Integer.valueOf(a2)});
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
            case 5:
                a2 = (int) TimeConversions.m11968a(a, 3600000);
                if (a2 == 0) {
                    a2 = 1;
                }
                return resources.getString(2131233763, new Object[]{Integer.valueOf(a2)});
            case 6:
            case 7:
                a2 = (int) TimeConversions.m11968a(a, 86400000);
                if (a2 == 0) {
                    a2 = 1;
                }
                return resources.getString(2131233764, new Object[]{Integer.valueOf(a2)});
            default:
                a2 = (int) TimeConversions.m11968a(a, 31536000000L);
                if (a2 == 0) {
                    a2 = 1;
                }
                return resources.getString(2131233765, new Object[]{Integer.valueOf(a2)});
        }
    }

    private String m11804p(long j) {
        RelativeTimePeriod i = m11797i(j);
        Resources resources = this.f7285c.getResources();
        long a = j - this.f7286d.mo211a();
        int b;
        switch (1.a[i.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
            case 3:
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
            case 5:
                b = (int) TimeConversions.m11969b(a, 3600000);
                if (b == 0) {
                    b = 1;
                }
                return resources.getQuantityString(2131689562, b, new Object[]{Integer.valueOf(b)});
            default:
                b = (int) TimeConversions.m11969b(a, 86400000);
                if (b == 0) {
                    b = 1;
                }
                return resources.getQuantityString(2131689563, b, new Object[]{Integer.valueOf(b)});
        }
    }

    private String m11805q(long j) {
        m11793d(j, this.f7286d.mo211a());
        if (this.f7289g.get(1) == this.f7290h.get(1)) {
            return DateUtils.formatDateTime(this.f7285c, j, 65560);
        }
        return DateUtils.formatDateTime(this.f7285c, j, 65556);
    }

    private static String m11806r(long j) {
        DateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.format(new Date(j));
    }

    private String m11807s(long j) {
        long abs = Math.abs(j);
        Resources resources = this.f7285c.getResources();
        if (abs < 60000) {
            return resources.getQuantityString(2131689564, (int) TimeConversions.m11973m(abs), new Object[]{Integer.valueOf((int) TimeConversions.m11973m(abs))});
        } else if (abs < 3600000) {
            return resources.getQuantityString(2131689565, (int) TimeConversions.m11970d(abs), new Object[]{Integer.valueOf((int) TimeConversions.m11970d(abs))});
        } else if (abs < 86400000) {
            return resources.getQuantityString(2131689566, (int) TimeConversions.m11967a(abs), new Object[]{Integer.valueOf((int) TimeConversions.m11967a(abs))});
        } else if (abs < 604800000) {
            return resources.getQuantityString(2131689567, (int) TimeConversions.m11971f(abs), new Object[]{Integer.valueOf((int) TimeConversions.m11971f(abs))});
        } else if (abs < 2592000000L) {
            return resources.getQuantityString(2131689568, (int) (abs / 604800000), new Object[]{Integer.valueOf((int) (abs / 604800000))});
        } else if (abs < 31536000000L) {
            return resources.getQuantityString(2131689569, (int) (abs / 2592000000L), new Object[]{Integer.valueOf((int) (abs / 2592000000L))});
        } else {
            return resources.getQuantityString(2131689570, (int) TimeConversions.m11972k(abs), new Object[]{Integer.valueOf((int) TimeConversions.m11972k(abs))});
        }
    }

    private Calendar m11787a(Calendar calendar, long j) {
        TimeZone timeZone = (TimeZone) this.f7287e.get();
        if (calendar.getTimeZone() != timeZone) {
            calendar = Calendar.getInstance(timeZone);
        }
        calendar.setTimeInMillis(j);
        return calendar;
    }

    private void m11793d(long j, long j2) {
        this.f7289g = m11787a(this.f7289g, j2);
        this.f7290h = m11787a(this.f7290h, j);
    }
}
