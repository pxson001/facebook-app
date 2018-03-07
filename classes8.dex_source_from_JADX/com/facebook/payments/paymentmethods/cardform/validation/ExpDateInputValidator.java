package com.facebook.payments.paymentmethods.cardform.validation;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.InjectorLike;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.inject.Inject;

/* compiled from: surafce_first_news_feed_after_login */
public class ExpDateInputValidator implements TextInputValidator {
    private final Clock f1934a;
    public final Calendar f1935b = GregorianCalendar.getInstance();
    private final Resources f1936c;

    public static ExpDateInputValidator m2134b(InjectorLike injectorLike) {
        return new ExpDateInputValidator((Clock) SystemClockMethodAutoProvider.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ExpDateInputValidator(Clock clock, Resources resources) {
        this.f1934a = clock;
        this.f1936c = resources;
    }

    public final boolean mo91a(InputValidatorParams inputValidatorParams) {
        String a = inputValidatorParams.mo93a();
        if (!StringUtil.a(a) && a.matches("\\d{2}\\/\\d{2}")) {
            return m2133a(a, this.f1934a.a());
        }
        return false;
    }

    public final String mo92b(InputValidatorParams inputValidatorParams) {
        return this.f1936c.getString(2131238321);
    }

    @VisibleForTesting
    private boolean m2133a(String str, long j) {
        Iterable split = Splitter.on("/").split(str);
        String str2 = (String) Iterables.a(split, 0);
        String str3 = (String) Iterables.a(split, 1);
        int parseInt = Integer.parseInt(str2);
        int parseInt2 = Integer.parseInt(str3);
        boolean z = false;
        int i = parseInt - 1;
        if (i >= 0 && i <= 11) {
            this.f1935b.setTimeInMillis(j);
            int i2 = this.f1935b.get(1) - 2000;
            int i3 = this.f1935b.get(2);
            if (parseInt2 > i2 || (parseInt2 == i2 && i >= i3)) {
                z = true;
            }
        }
        return z;
    }
}
