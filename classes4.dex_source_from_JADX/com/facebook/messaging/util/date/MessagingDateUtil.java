package com.facebook.messaging.util.date;

import android.content.Context;
import android.text.format.DateFormat;
import com.facebook.common.i18n.BasicDateTimeFormat;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import javax.annotation.concurrent.NotThreadSafe;
import javax.inject.Inject;

@ContextScoped
@NotThreadSafe
/* compiled from: intercept_domain_whitelist */
public class MessagingDateUtil {
    private static MessagingDateUtil f10222d;
    private static final Object f10223e = new Object();
    public final Context f10224a;
    public final BasicDateTimeFormat f10225b;
    public final Clock f10226c;

    private static MessagingDateUtil m10718b(InjectorLike injectorLike) {
        return new MessagingDateUtil((Context) injectorLike.getInstance(Context.class), BasicDateTimeFormat.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public MessagingDateUtil(Context context, BasicDateTimeFormat basicDateTimeFormat, Clock clock) {
        this.f10224a = context;
        this.f10225b = basicDateTimeFormat;
        this.f10226c = clock;
    }

    public final String m10720a(long j) {
        int a = (int) ((((this.f10226c.a() - j) / 1000) / 60) / 60);
        if (a < 24) {
            return DateFormat.getTimeFormat(this.f10224a).format(Long.valueOf(j));
        }
        Date date = new Date(j);
        a /= 24;
        if (a < 4) {
            return this.f10225b.d().format(date);
        }
        if (a < 180) {
            return this.f10225b.g().format(date);
        }
        return this.f10225b.h().format(date);
    }

    public static MessagingDateUtil m10717a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MessagingDateUtil b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f10223e) {
                MessagingDateUtil messagingDateUtil;
                if (a2 != null) {
                    messagingDateUtil = (MessagingDateUtil) a2.a(f10223e);
                } else {
                    messagingDateUtil = f10222d;
                }
                if (messagingDateUtil == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10718b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f10223e, b3);
                        } else {
                            f10222d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = messagingDateUtil;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private static boolean m10719e(long j) {
        Calendar instance = GregorianCalendar.getInstance();
        instance.setTimeInMillis(j);
        Calendar instance2 = GregorianCalendar.getInstance();
        if (instance.get(1) == instance2.get(1) && instance.get(2) == instance2.get(2) && instance.get(5) == instance2.get(5)) {
            return true;
        }
        return false;
    }

    public final String m10721b(long j) {
        Date date = new Date(j);
        if (m10719e(j)) {
            return DateFormat.getTimeFormat(this.f10224a).format(date);
        }
        int a = ((int) ((((this.f10226c.a() - j) / 1000) / 60) / 60)) / 24;
        if (a < 4) {
            return this.f10224a.getString(2131235592, new Object[]{this.f10225b.d().format(date), DateFormat.getTimeFormat(this.f10224a).format(date)});
        } else if (a < 180) {
            return this.f10224a.getString(2131235592, new Object[]{this.f10225b.g().format(date), DateFormat.getTimeFormat(this.f10224a).format(date)});
        } else {
            return this.f10224a.getString(2131235592, new Object[]{this.f10225b.h().format(date), DateFormat.getTimeFormat(this.f10224a).format(date)});
        }
    }

    public final String m10722c(long j) {
        String[] strArr = new String[2];
        long a = (this.f10226c.a() - j) / 86400000;
        Date date = new Date(j);
        if (a < 1) {
            strArr[0] = "";
        } else if (a < 180) {
            strArr[0] = this.f10225b.e().format(date);
        } else {
            strArr[0] = this.f10225b.f().format(date);
        }
        strArr[1] = DateFormat.getTimeFormat(this.f10224a).format(date);
        String[] strArr2 = strArr;
        StringBuilder stringBuilder = new StringBuilder(100);
        if (!strArr2[0].isEmpty()) {
            stringBuilder.append(strArr2[0]);
            stringBuilder.append(", ");
        }
        stringBuilder.append(strArr2[1]);
        return stringBuilder.toString();
    }

    public final String m10723d(long j) {
        long a = (this.f10226c.a() - j) / 86400000;
        Date date = new Date(j);
        BasicDateTimeFormat basicDateTimeFormat;
        if (a < 180) {
            basicDateTimeFormat = this.f10225b;
            if (basicDateTimeFormat.j == null) {
                SimpleDateFormat simpleDateFormat = (SimpleDateFormat) basicDateTimeFormat.b().clone();
                BasicDateTimeFormat.a(simpleDateFormat, "MMM d h:mm a", (Locale) basicDateTimeFormat.a.get());
                basicDateTimeFormat.j = simpleDateFormat;
            }
            return basicDateTimeFormat.j.format(date);
        }
        basicDateTimeFormat = this.f10225b;
        if (basicDateTimeFormat.k == null) {
            basicDateTimeFormat.k = new SimpleDateFormat("MMM d, yyyy h:mm a", (Locale) basicDateTimeFormat.a.get());
        }
        return basicDateTimeFormat.k.format(date);
    }
}
