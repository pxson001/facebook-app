package com.facebook.adspayments.utils;

import com.facebook.common.stringformat.StringFormatUtil;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;

/* compiled from: UPLOAD_TYPES */
public class AdsPaymentsPreconditions {
    public static <T> T m25752a(T t, Predicate<? super T> predicate) {
        return m25753a(t, predicate, "Invalid value: %s - does not conform to %s", t, predicate);
    }

    public static <T> T m25753a(T t, Predicate<? super T> predicate, String str, Object... objArr) {
        Preconditions.checkArgument(predicate.apply(t), str, objArr);
        return t;
    }

    public static <T extends S, S> T m25754a(S s, Class<T> cls) {
        if (cls.isInstance(s)) {
            return s;
        }
        throw new RuntimeException(StringFormatUtil.formatStrLocaleSafe("Illegal cast to %s of: %s", cls, s));
    }

    private AdsPaymentsPreconditions() {
    }
}
