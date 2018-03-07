package com.facebook.adspayments.validation;

import com.facebook.common.time.Clock;
import com.facebook.common.util.StringUtil;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.inject.Inject;

/* compiled from: UPLOADING_COVER_PHOTO */
public class ExpDateInputValidator extends InputValidatorCallbackHandler {
    private final Clock f23729a;
    public final Calendar f23730b = GregorianCalendar.getInstance();

    @Inject
    public ExpDateInputValidator(Clock clock) {
        this.f23729a = clock;
    }

    public final boolean m25764a(String str) {
        if (!StringUtil.a(str) && str.matches("\\d{2}\\/\\d{2}")) {
            return m25763a(str, this.f23729a.a());
        }
        return false;
    }

    @VisibleForTesting
    private boolean m25763a(String str, long j) {
        Iterable split = Splitter.on("/").split(str);
        String str2 = (String) Iterables.a(split, 0);
        String str3 = (String) Iterables.a(split, 1);
        int parseInt = Integer.parseInt(str2);
        int parseInt2 = Integer.parseInt(str3);
        boolean z = false;
        int i = parseInt - 1;
        if (i >= 0 && i <= 11) {
            this.f23730b.setTimeInMillis(j);
            int i2 = this.f23730b.get(1) - 2000;
            int i3 = this.f23730b.get(2);
            if (parseInt2 > i2 || (parseInt2 == i2 && i >= i3)) {
                z = true;
            }
        }
        return z;
    }
}
