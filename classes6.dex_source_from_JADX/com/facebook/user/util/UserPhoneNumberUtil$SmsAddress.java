package com.facebook.user.util;

import com.facebook.phonenumbers.NumberParseException;
import com.facebook.phonenumbers.PhoneNumberUtil.PhoneNumberFormat;
import com.facebook.phonenumbers.Phonenumber.PhoneNumber;

/* compiled from: context_type */
public class UserPhoneNumberUtil$SmsAddress {
    final /* synthetic */ UserPhoneNumberUtil f18475a;
    public final String f18476b;
    private final PhoneNumber f18477c;

    public UserPhoneNumberUtil$SmsAddress(UserPhoneNumberUtil userPhoneNumberUtil, String str) {
        this.f18475a = userPhoneNumberUtil;
        this.f18476b = str;
        this.f18477c = m27091a(str);
    }

    public final boolean m27092a() {
        return this.f18477c != null;
    }

    public final String m27093b() {
        if (this.f18477c == null) {
            return this.f18476b;
        }
        if (this.f18475a.a.isValidNumber(this.f18477c)) {
            return this.f18475a.a.format(this.f18477c, PhoneNumberFormat.E164);
        }
        return this.f18476b;
    }

    public final String m27094c() {
        if (this.f18477c == null) {
            return this.f18476b;
        }
        PhoneNumberFormat phoneNumberFormat;
        int countryCodeForRegion = this.f18475a.a.getCountryCodeForRegion((String) this.f18475a.b.get());
        if (countryCodeForRegion == 0 || countryCodeForRegion != this.f18477c.countryCode_) {
            phoneNumberFormat = PhoneNumberFormat.INTERNATIONAL;
        } else {
            phoneNumberFormat = PhoneNumberFormat.NATIONAL;
        }
        return this.f18475a.a.format(this.f18477c, phoneNumberFormat).replace(' ', ' ').replace('-', '‑');
    }

    private PhoneNumber m27091a(String str) {
        String str2 = (String) this.f18475a.b.get();
        if (str != null) {
            try {
                return this.f18475a.a.parse(str, str2);
            } catch (NumberParseException e) {
            }
        }
        return null;
    }
}
