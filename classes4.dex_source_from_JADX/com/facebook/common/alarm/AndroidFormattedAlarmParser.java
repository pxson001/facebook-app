package com.facebook.common.alarm;

import android.content.Context;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import android.text.format.DateFormat;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.katana.app.module.LocaleMethodAutoProvider;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.inject.Inject;

@ContextScoped
/* compiled from: sessionlessqe/ */
public class AndroidFormattedAlarmParser {
    private static AndroidFormattedAlarmParser f2476d;
    private static final Object f2477e = new Object();
    private final Context f2478a;
    private final Clock f2479b;
    private final Locale f2480c;

    private static AndroidFormattedAlarmParser m2750b(InjectorLike injectorLike) {
        return new AndroidFormattedAlarmParser((Context) injectorLike.getInstance(Context.class), (Clock) SystemClockMethodAutoProvider.a(injectorLike), LocaleMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public AndroidFormattedAlarmParser(Context context, Clock clock, Locale locale) {
        this.f2478a = context;
        this.f2479b = clock;
        this.f2480c = locale;
    }

    public final Date m2754a() {
        Date date = null;
        String string = System.getString(this.f2478a.getContentResolver(), "next_alarm_formatted");
        if (string != null) {
            try {
                date = m2749a(string);
            } catch (ParseException e) {
            }
        }
        return date;
    }

    public static AndroidFormattedAlarmParser m2748a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AndroidFormattedAlarmParser b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2477e) {
                AndroidFormattedAlarmParser androidFormattedAlarmParser;
                if (a2 != null) {
                    androidFormattedAlarmParser = (AndroidFormattedAlarmParser) a2.a(f2477e);
                } else {
                    androidFormattedAlarmParser = f2476d;
                }
                if (androidFormattedAlarmParser == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2750b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2477e, b3);
                        } else {
                            f2476d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = androidFormattedAlarmParser;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private Date m2749a(String str) {
        Date parse;
        try {
            parse = new SimpleDateFormat(m2752c(), this.f2480c).parse(str);
        } catch (ParseException e) {
            parse = new SimpleDateFormat(m2753d(), this.f2480c).parse(str);
        }
        Calendar instance = Calendar.getInstance(this.f2480c);
        instance.setTime(parse);
        Calendar b = m2751b();
        Calendar calendar = (Calendar) b.clone();
        calendar.set(7, instance.get(7));
        calendar.set(11, instance.get(11));
        calendar.set(12, instance.get(12));
        calendar.set(13, 0);
        calendar.set(14, 0);
        if (calendar.before(b)) {
            calendar.add(3, 1);
        }
        return calendar.getTime();
    }

    private Calendar m2751b() {
        Calendar instance = Calendar.getInstance(this.f2480c);
        instance.setTimeInMillis(this.f2479b.a());
        return instance;
    }

    private static String m2752c() {
        if (VERSION.SDK_INT >= 18) {
            return DateFormat.getBestDateTimePattern(Locale.getDefault(), "Ehma");
        }
        return "E h:mm aa";
    }

    private static String m2753d() {
        if (VERSION.SDK_INT >= 18) {
            return DateFormat.getBestDateTimePattern(Locale.getDefault(), "EHm");
        }
        return "E k:mm";
    }
}
