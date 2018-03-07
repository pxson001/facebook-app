package com.facebook.widget.countryselector;

import android.content.Context;
import com.facebook.common.locale.Locales;
import com.facebook.common.phonenumbers.PhoneNumberUtilMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: shares.count */
public class CountrySelectorProvider extends AbstractAssistedProvider<CountrySelector> {
    public final CountrySelector m3342a(Context context, boolean z) {
        return new CountrySelector(context, z, Locales.a(this), PhoneNumberUtilMethodAutoProvider.a(this));
    }
}
