package com.facebook.widget.countryspinner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.facebook.common.locale.Locales;
import com.facebook.common.phonenumbers.PhoneNumberUtilMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.phonenumbers.PhoneNumberUtil;
import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: sharer/sharer.php?u={share_link}&app_id={#app_id 0}&in_app={in_app false} */
public class CountrySpinner extends Spinner {
    public CountryCodeFormatter f3552a;
    private CountryCode[] f3553b;
    private Locale f3554c;
    private Locales f3555d;
    private PhoneNumberUtil f3556e;
    private String f3557f;

    /* compiled from: sharer/sharer.php?u={share_link}&app_id={#app_id 0}&in_app={in_app false} */
    public interface CountryCodeFormatter {
        String m3343a();
    }

    private static <T extends View> void m3348a(Class<T> cls, T t) {
        m3349a((Object) t, t.getContext());
    }

    private static void m3349a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((CountrySpinner) obj).m3347a(Locales.a(fbInjector), PhoneNumberUtilMethodAutoProvider.a(fbInjector), IdBasedProvider.a(fbInjector, 4446));
    }

    @Inject
    private void m3347a(Locales locales, PhoneNumberUtil phoneNumberUtil, Provider<String> provider) {
        this.f3555d = locales;
        this.f3556e = phoneNumberUtil;
        this.f3557f = (String) provider.get();
    }

    public CountrySpinner(Context context) {
        super(context);
        m3346a();
    }

    public CountrySpinner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m3346a();
    }

    private void m3346a() {
        m3348a(CountrySpinner.class, (View) this);
        this.f3554c = this.f3555d.a();
        String[] iSOCountries = Locale.getISOCountries();
        List a = Lists.a();
        for (String a2 : iSOCountries) {
            CountryCode a3 = m3344a(a2);
            if (a3 != null) {
                a.add(a3);
            }
        }
        Collections.sort(a);
        this.f3553b = (CountryCode[]) a.toArray(new CountryCode[0]);
        setAdapter(new ArrayAdapter(getContext(), 2130903810, 2131559311, this.f3553b));
        setCountrySelection(this.f3557f);
    }

    public void setCountrySelection(String str) {
        if (!StringUtil.c(str)) {
            int i = 0;
            while (i < this.f3553b.length) {
                if (this.f3553b[i].f3547a.equals(str)) {
                    break;
                }
                i++;
            }
            i = -1;
            if (i != -1) {
                setSelection(i);
            }
        }
    }

    public CountryCode[] getCountryCodes() {
        return this.f3553b;
    }

    public String getSelectedCountryIsoCode() {
        return ((CountryCode) getSelectedItem()).f3547a;
    }

    public String getSelectedCountryDialingCode() {
        return ((CountryCode) getSelectedItem()).f3548b;
    }

    public void setCountryCodeFormatter(CountryCodeFormatter countryCodeFormatter) {
        this.f3552a = countryCodeFormatter;
    }

    @Nullable
    private CountryCode m3344a(String str) {
        int countryCodeForRegion = this.f3556e.getCountryCodeForRegion(str);
        if (countryCodeForRegion == 0) {
            return null;
        }
        return new CountryCode(this, str, "+" + countryCodeForRegion, new Locale(this.f3554c.getLanguage(), str).getDisplayCountry(this.f3554c)) {
            final /* synthetic */ CountrySpinner f3551d;

            public String toString() {
                if (this.f3551d.f3552a != null) {
                    return this.f3551d.f3552a.m3343a();
                }
                return super.toString();
            }
        };
    }
}
