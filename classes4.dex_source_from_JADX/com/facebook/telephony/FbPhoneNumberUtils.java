package com.facebook.telephony;

import android.telephony.PhoneNumberUtils;
import com.facebook.common.phonenumbers.PhoneNumberUtilMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.phonenumbers.NumberParseException;
import com.facebook.phonenumbers.PhoneNumberUtil;
import com.facebook.phonenumbers.PhoneNumberUtil.PhoneNumberFormat;
import com.facebook.phonenumbers.Phonenumber.PhoneNumber;
import com.google.common.base.Strings;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: eligible */
public class FbPhoneNumberUtils {
    private static final Pattern f13271a = Pattern.compile("^[0-9+\\(\\)#,;\\.\\s\\*\\-]+$");
    public final PhoneNumberUtil f13272b;
    public final Provider<String> f13273c;

    public static FbPhoneNumberUtils m14146b(InjectorLike injectorLike) {
        return new FbPhoneNumberUtils(IdBasedProvider.a(injectorLike, 4446), PhoneNumberUtilMethodAutoProvider.m14153a(injectorLike));
    }

    @Inject
    public FbPhoneNumberUtils(Provider<String> provider, PhoneNumberUtil phoneNumberUtil) {
        this.f13273c = provider;
        this.f13272b = phoneNumberUtil;
    }

    @Nullable
    public final PhoneNumber m14150a(String str) {
        String str2 = (String) this.f13273c.get();
        if (StringUtil.a(str2)) {
            BLog.b("FbPhoneNumberUtils", "Country code not available");
            return null;
        }
        try {
            return this.f13272b.parseAndKeepRawInput(str, str2);
        } catch (NumberParseException e) {
            return null;
        }
    }

    @Nullable
    public final String m14151b(@Nullable String str) {
        if (StringUtil.a(str)) {
            return null;
        }
        if (m14149g(str)) {
            return m14148e(str);
        }
        PhoneNumber a = m14150a(str);
        if (a == null) {
            return str;
        }
        Object obj;
        if (StringUtil.a((String) this.f13273c.get(), this.f13272b.getRegionCodeForCountryCode(a.countryCode_))) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            return this.f13272b.format(a, PhoneNumberFormat.INTERNATIONAL);
        }
        return this.f13272b.format(a, PhoneNumberFormat.NATIONAL);
    }

    public static boolean m14147c(@Nullable String str) {
        return !StringUtil.c(str) && str.length() <= 63 && f13271a.matcher(str).matches();
    }

    public final String m14152d(@Nullable String str) {
        if (Strings.isNullOrEmpty(str)) {
            return "";
        }
        String e = m14148e(str);
        if (m14149g(e) || e.length() < 7) {
            return e;
        }
        String str2 = null;
        if (!StringUtil.a(str)) {
            PhoneNumber a = m14150a(str);
            if (a != null) {
                str2 = this.f13272b.format(a, PhoneNumberFormat.E164);
            }
        }
        e = str2;
        if (e != null) {
            return e;
        }
        BLog.b("FbPhoneNumberUtils", "Parsing failed, fallback to normalize only.");
        return PhoneNumberUtil.normalizeDigitsOnly(str);
    }

    private static boolean m14149g(String str) {
        return str != null && (str.contains("*") || str.contains("#"));
    }

    public static String m14148e(String str) {
        if (Strings.isNullOrEmpty(str)) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (PhoneNumberUtils.isDialable(c)) {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }
}
