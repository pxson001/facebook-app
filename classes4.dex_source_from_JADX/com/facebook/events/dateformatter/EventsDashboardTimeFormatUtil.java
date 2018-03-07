package com.facebook.events.dateformatter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.format.Time;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.TimeConversions;
import com.facebook.common.timeformat.TimeFormatUtil;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.languages.switchercommonex.LocaleChangeController;
import com.facebook.languages.switchercommonex.LocaleChangeListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.util.concurrent.ListenableFuture;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: opus_plc */
public class EventsDashboardTimeFormatUtil {
    private static volatile EventsDashboardTimeFormatUtil f5995x;
    public DateFormat f5996a;
    private TimeZone f5997b;
    public final Context f5998c;
    public final Provider<TimeFormatUtil> f5999d;
    private DateFormat f6000e;
    private DateFormat f6001f;
    private DateFormat f6002g;
    private DateFormat f6003h;
    public String f6004i;
    private String f6005j;
    public String f6006k;
    private String f6007l;
    private String f6008m;
    private String f6009n;
    public String f6010o;
    public String f6011p;
    public String f6012q;
    private String[] f6013r;
    private DateFormat f6014s;
    private DateFormat f6015t;
    private DateFormat f6016u;
    private String f6017v;
    private int f6018w;

    public static com.facebook.events.dateformatter.EventsDashboardTimeFormatUtil m6462a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f5995x;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.events.dateformatter.EventsDashboardTimeFormatUtil.class;
        monitor-enter(r1);
        r0 = f5995x;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m6465b(r0);	 Catch:{ all -> 0x0035 }
        f5995x = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5995x;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.events.dateformatter.EventsDashboardTimeFormatUtil.a(com.facebook.inject.InjectorLike):com.facebook.events.dateformatter.EventsDashboardTimeFormatUtil");
    }

    private static EventsDashboardTimeFormatUtil m6465b(InjectorLike injectorLike) {
        return new EventsDashboardTimeFormatUtil((Context) injectorLike.getInstance(Context.class), IdBasedSingletonScopeProvider.a(injectorLike, 610), IdBasedProvider.a(injectorLike, 4483), IdBasedProvider.a(injectorLike, 4485), LocaleChangeController.a(injectorLike));
    }

    @Inject
    public EventsDashboardTimeFormatUtil(Context context, Provider<TimeFormatUtil> provider, Provider<Locale> provider2, Provider<TimeZone> provider3, LocaleChangeController localeChangeController) {
        this.f5998c = context;
        this.f5999d = provider;
        EventsDateFormatBuilder.m6488a(EventsDateFormatBuilder.f6020b, EventsDateFormatBuilder.f6019a, EventsDateFormatBuilder.f6021c);
        m6470b(this, (Locale) provider2.get(), (TimeZone) provider3.get());
        final TimeZone timeZone = (TimeZone) provider3.get();
        localeChangeController.a(new LocaleChangeListener(this) {
            final /* synthetic */ EventsDashboardTimeFormatUtil f6023b;

            public final ListenableFuture m6490a(Locale locale) {
                EventsDashboardTimeFormatUtil.m6470b(this.f6023b, locale, timeZone);
                return null;
            }
        });
        final Locale locale = (Locale) provider2.get();
        final TimeZone timeZone2 = (TimeZone) provider3.get();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
        this.f5998c.registerReceiver(new BroadcastReceiver(this) {
            final /* synthetic */ EventsDashboardTimeFormatUtil f6026c;

            public void onReceive(Context context, Intent intent) {
                int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1773241440);
                EventsDashboardTimeFormatUtil.m6470b(this.f6026c, locale, timeZone2);
                LogUtils.a(intent, 2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 2130353323, a);
            }
        }, intentFilter);
    }

    public static void m6470b(EventsDashboardTimeFormatUtil eventsDashboardTimeFormatUtil, Locale locale, TimeZone timeZone) {
        eventsDashboardTimeFormatUtil.f5997b = timeZone;
        eventsDashboardTimeFormatUtil.f6004i = eventsDashboardTimeFormatUtil.f5998c.getString(2131239071);
        eventsDashboardTimeFormatUtil.f6005j = eventsDashboardTimeFormatUtil.f5998c.getString(2131239073);
        eventsDashboardTimeFormatUtil.f6006k = eventsDashboardTimeFormatUtil.f5998c.getString(2131239074);
        eventsDashboardTimeFormatUtil.f6007l = eventsDashboardTimeFormatUtil.f5998c.getString(2131239079);
        eventsDashboardTimeFormatUtil.f6008m = eventsDashboardTimeFormatUtil.f5998c.getString(2131233727);
        eventsDashboardTimeFormatUtil.f6009n = eventsDashboardTimeFormatUtil.f5998c.getString(2131233728);
        eventsDashboardTimeFormatUtil.f6010o = eventsDashboardTimeFormatUtil.f5998c.getString(2131239075);
        eventsDashboardTimeFormatUtil.f6011p = eventsDashboardTimeFormatUtil.f5998c.getString(2131239076);
        eventsDashboardTimeFormatUtil.f6012q = eventsDashboardTimeFormatUtil.f5998c.getString(2131239077);
        eventsDashboardTimeFormatUtil.f6017v = eventsDashboardTimeFormatUtil.f5998c.getString(2131239078);
        eventsDashboardTimeFormatUtil.f6013r = eventsDashboardTimeFormatUtil.f5998c.getResources().getStringArray(2131755082);
        DateFormat simpleDateFormat = new SimpleDateFormat(EventsDateFormatBuilder.f6019a, locale);
        simpleDateFormat.setTimeZone(timeZone);
        eventsDashboardTimeFormatUtil.f6000e = simpleDateFormat;
        eventsDashboardTimeFormatUtil.f6001f = EventsDateFormatBuilder.m6487a(locale, timeZone);
        String[] strArr = eventsDashboardTimeFormatUtil.f6013r;
        DateFormat timeInstance = DateFormat.getTimeInstance(3, locale);
        if (timeInstance instanceof SimpleDateFormat) {
            DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(locale);
            dateFormatSymbols.setAmPmStrings(strArr);
            ((SimpleDateFormat) timeInstance).setDateFormatSymbols(dateFormatSymbols);
        }
        timeInstance.setTimeZone(timeZone);
        eventsDashboardTimeFormatUtil.f5996a = timeInstance;
        simpleDateFormat = new SimpleDateFormat(EventsDateFormatBuilder.f6021c, locale);
        simpleDateFormat.setTimeZone(timeZone);
        eventsDashboardTimeFormatUtil.f6014s = simpleDateFormat;
        if (VERSION.SDK_INT < 18) {
            simpleDateFormat = new SimpleDateFormat("MMMM yyyy", locale);
        } else {
            DateFormat simpleDateFormat2 = new SimpleDateFormat(android.text.format.DateFormat.getBestDateTimePattern(locale, "MMMMyyyy"), locale);
            simpleDateFormat2.setTimeZone(timeZone);
            simpleDateFormat = simpleDateFormat2;
        }
        simpleDateFormat.setTimeZone(timeZone);
        eventsDashboardTimeFormatUtil.f6015t = simpleDateFormat;
        if (VERSION.SDK_INT < 18) {
            simpleDateFormat = new SimpleDateFormat("MMM d", locale);
        } else {
            simpleDateFormat2 = new SimpleDateFormat(android.text.format.DateFormat.getBestDateTimePattern(locale, "MMMd"), locale);
            simpleDateFormat2.setTimeZone(timeZone);
            simpleDateFormat = simpleDateFormat2;
        }
        simpleDateFormat.setTimeZone(timeZone);
        eventsDashboardTimeFormatUtil.f6016u = simpleDateFormat;
        simpleDateFormat = new SimpleDateFormat("MMM", locale);
        simpleDateFormat.setTimeZone(timeZone);
        eventsDashboardTimeFormatUtil.f6002g = simpleDateFormat;
        simpleDateFormat = new SimpleDateFormat("dd", locale);
        simpleDateFormat.setTimeZone(timeZone);
        eventsDashboardTimeFormatUtil.f6003h = simpleDateFormat;
        if (Locale.US.equals(locale)) {
            eventsDashboardTimeFormatUtil.f6018w = 1;
        } else {
            eventsDashboardTimeFormatUtil.f6018w = Calendar.getInstance().getFirstDayOfWeek() - 1;
        }
    }

    @VisibleForTesting
    public final String m6476a(boolean z, Date date, @Nullable Date date2, boolean z2) {
        if (date2 == null || m6473a(date.getTime(), date2.getTime()) == CalendarBucket.TODAY) {
            return m6475a(z, date, date2);
        }
        return m6469b(z, date, date2, z2);
    }

    public final String m6475a(boolean z, Date date, @Nullable Date date2) {
        return m6463a(z, date, date2, new Date());
    }

    public final String m6478b(boolean z, Date date, @Nullable Date date2) {
        return m6469b(z, date, date2, true);
    }

    private String m6469b(boolean z, Date date, @Nullable Date date2, boolean z2) {
        return m6464a(z, date, date2, new Date(), z2);
    }

    public final String m6480c(boolean z, Date date, @Nullable Date date2) {
        return m6467b(z, date, date2, new Date());
    }

    @VisibleForTesting
    private String m6463a(boolean z, Date date, @Nullable Date date2, Date date3) {
        if (date2 == null || m6473a(date.getTime(), date2.getTime()) == CalendarBucket.TODAY) {
            return m6472d(z, date, date3);
        }
        return this.f6001f.format(date);
    }

    private String m6464a(boolean z, Date date, @Nullable Date date2, Date date3, boolean z2) {
        if (z || date2 == null) {
            return m6472d(z, date, date3);
        }
        return m6468b(z, date, date2, date3, z2);
    }

    private String m6472d(boolean z, Date date, Date date2) {
        if (z) {
            return m6474a(date, date2);
        }
        String a = m6474a(date, date2);
        String format = this.f5996a.format(date);
        return StringFormatUtil.a(this.f6004i, new Object[]{a, format});
    }

    private String m6468b(boolean z, Date date, Date date2, Date date3, boolean z2) {
        if (m6473a(date.getTime(), date2.getTime()) == CalendarBucket.TODAY) {
            String d = m6472d(z, date, date3);
            String format = this.f5996a.format(date2);
            return StringFormatUtil.a(this.f6005j, new Object[]{d, format});
        }
        Object format2;
        if (z2) {
            format2 = this.f6001f.format(date);
        } else {
            format = m6477b(date);
        }
        d = z2 ? this.f6001f.format(date2) : m6477b(date2);
        return StringFormatUtil.a(this.f6005j, new Object[]{format2, d});
    }

    public final String m6474a(@Nonnull Date date, @Nonnull Date date2) {
        switch (3.a[m6473a(date.getTime(), date2.getTime()).ordinal()]) {
            case 1:
                return this.f6001f.format(date);
            case 2:
                return this.f6010o;
            case 3:
                return this.f6011p;
            case 4:
                return this.f6012q;
            case 5:
                return this.f6000e.format(date);
            default:
                return this.f6001f.format(date);
        }
    }

    public final String m6477b(Date date) {
        return this.f6016u.format(date);
    }

    public final String m6479c(Date date) {
        return this.f6002g.format(date);
    }

    public final String m6481d(Date date) {
        return this.f6003h.format(date);
    }

    public final CalendarBucket m6473a(long j, long j2) {
        int a = m6461a(j2, this.f5997b);
        int a2 = m6461a(j, this.f5997b);
        if (a > a2) {
            if (a - a2 == 1) {
                return CalendarBucket.YESTERDAY;
            }
            return CalendarBucket.PAST;
        } else if (a == a2) {
            return CalendarBucket.TODAY;
        } else {
            if (a2 - a == 1) {
                return CalendarBucket.TOMORROW;
            }
            a = m6460a(a2, this.f6018w) - m6460a(a, this.f6018w);
            if (a == 0) {
                return CalendarBucket.THIS_WEEK;
            }
            if (a == 1) {
                return CalendarBucket.NEXT_WEEK;
            }
            return CalendarBucket.FUTURE;
        }
    }

    private static int m6460a(int i, int i2) {
        int i3 = 4 - i2;
        if (i3 < 0) {
            i3 += 7;
        }
        return (i - (2440588 - i3)) / 7;
    }

    private static int m6461a(long j, TimeZone timeZone) {
        return Time.getJulianDay(j, (long) (timeZone.getOffset(j) / 1000));
    }

    public final String m6482e(Date date) {
        return this.f6000e.format(date);
    }

    public final String m6483f(Date date) {
        return this.f6014s.format(date);
    }

    public final String m6484g(Date date) {
        return this.f6015t.format(date);
    }

    public final String m6485h(Date date) {
        return StringLocaleUtil.a(this.f6017v, new Object[]{m6483f(date)});
    }

    @VisibleForTesting
    private String m6467b(boolean z, Date date, @Nullable Date date2, Date date3) {
        if (date2 != null && date3.after(date) && date3.before(date2)) {
            return this.f6009n;
        }
        if (z || date2 == null || m6473a(date.getTime(), date2.getTime()) == CalendarBucket.TODAY) {
            return m6471c(date, date3);
        }
        String i = m6486i(date);
        String i2 = m6486i(date2);
        return StringFormatUtil.a(this.f6006k, new Object[]{i, i2});
    }

    private String m6471c(Date date, Date date2) {
        if (date.before(date2)) {
            return m6466b(date.getTime(), date2.getTime()).toString();
        }
        return StringFormatUtil.a(this.f6007l, new Object[]{m6466b(date.getTime(), date2.getTime())});
    }

    public final String m6486i(Date date) {
        String b = m6477b(date);
        String format = this.f5996a.format(date);
        return StringFormatUtil.a(this.f6004i, new Object[]{b, format});
    }

    private CharSequence m6466b(long j, long j2) {
        Resources resources = this.f5998c.getResources();
        long abs = Math.abs(j2 - j);
        int d;
        if (abs < 3600000) {
            d = (int) TimeConversions.d(abs);
            if (j2 > j) {
                if (d == 0) {
                    return this.f6009n;
                }
                return resources.getQuantityString(2131689723, d, new Object[]{Integer.valueOf(d)});
            } else if (d == 0) {
                return this.f6008m;
            } else {
                return resources.getQuantityString(2131689720, d, new Object[]{Integer.valueOf(d)});
            }
        } else if (abs < 86400000) {
            d = (int) TimeConversions.a(abs);
            if (j2 > j) {
                return resources.getQuantityString(2131689724, d, new Object[]{Integer.valueOf(d)});
            }
            return resources.getQuantityString(2131689721, d, new Object[]{Integer.valueOf(d)});
        } else if (abs >= 604800000) {
            return this.f6001f.format(Long.valueOf(j));
        } else {
            Calendar instance = Calendar.getInstance(this.f5997b);
            instance.setTimeInMillis(j);
            Calendar instance2 = Calendar.getInstance(this.f5997b);
            instance2.setTimeInMillis(j2);
            int i = instance.get(1);
            int i2 = instance2.get(1);
            if (i == i2) {
                d = Math.abs(instance.get(6) - instance2.get(6));
            } else if (i > i2) {
                d = instance.get(6) + (instance2.getActualMaximum(6) - instance2.get(6));
            } else {
                d = (instance.getActualMaximum(6) - instance.get(6)) + instance2.get(6);
            }
            if (j2 > j) {
                if (d == 1) {
                    return this.f5998c.getResources().getString(2131239075);
                }
                return resources.getQuantityString(2131689725, d, new Object[]{Integer.valueOf(d)});
            } else if (d == 1) {
                return this.f5998c.getResources().getString(2131239077);
            } else {
                return resources.getQuantityString(2131689722, d, new Object[]{Integer.valueOf(d)});
            }
        }
    }
}
