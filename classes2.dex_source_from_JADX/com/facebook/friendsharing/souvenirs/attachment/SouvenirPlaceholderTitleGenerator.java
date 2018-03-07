package com.facebook.friendsharing.souvenirs.attachment;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.app.module.LocaleMethodAutoProvider;
import com.google.common.annotations.VisibleForTesting;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: most_recent_hosts_table */
public class SouvenirPlaceholderTitleGenerator {
    private final Context f13315a;
    private final Locale f13316b;
    private final Provider<GregorianCalendar> f13317c;

    public static SouvenirPlaceholderTitleGenerator m19610b(InjectorLike injectorLike) {
        return new SouvenirPlaceholderTitleGenerator((Context) injectorLike.getInstance(Context.class), LocaleMethodAutoProvider.m4768b(injectorLike), IdBasedProvider.m1811a(injectorLike, 4482));
    }

    @Inject
    public SouvenirPlaceholderTitleGenerator(Context context, Locale locale, Provider<GregorianCalendar> provider) {
        this.f13315a = context;
        this.f13316b = locale;
        this.f13317c = provider;
    }

    public final String m19612a(long j, long j2) {
        Resources resources = this.f13315a.getResources();
        Calendar instance = GregorianCalendar.getInstance();
        instance.setTimeInMillis(j);
        Calendar instance2 = GregorianCalendar.getInstance();
        instance2.setTimeInMillis(j2);
        Calendar calendar = (Calendar) this.f13317c.get();
        int i = instance.get(11);
        int i2 = instance2.get(11);
        int i3 = instance.get(7);
        if (m19608a(instance, instance2) && i >= 18 && i2 <= 5) {
            return m19607a(i3, 3);
        }
        if (m19611b(instance, instance2)) {
            if (m19611b(instance, calendar)) {
                return resources.getString(2131238460);
            }
            if (m19608a(instance, calendar)) {
                return resources.getString(2131238461);
            }
            if (i >= 4 && i2 < 12) {
                return m19607a(i3, 0);
            }
            if (i >= 12 && i2 <= 18) {
                return m19607a(i3, 1);
            }
            if (i >= 16) {
                return m19607a(i3, 2);
            }
        }
        return instance.getDisplayName(7, 2, this.f13316b);
    }

    private String m19607a(int i, int i2) {
        return this.f13315a.getResources().getStringArray(2131755081)[m19609b(i, i2)];
    }

    @VisibleForTesting
    private static int m19609b(int i, int i2) {
        return ((i - 1) * 4) + i2;
    }

    private static boolean m19608a(Calendar calendar, Calendar calendar2) {
        Calendar instance = GregorianCalendar.getInstance();
        instance.setTimeInMillis(calendar2.getTimeInMillis());
        instance.add(6, -1);
        return m19611b(calendar, instance);
    }

    private static boolean m19611b(Calendar calendar, Calendar calendar2) {
        return calendar.get(6) == calendar2.get(6) && calendar.get(1) == calendar2.get(1);
    }
}
