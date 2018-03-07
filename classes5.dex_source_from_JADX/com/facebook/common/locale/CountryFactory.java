package com.facebook.common.locale;

import java.util.Locale;

/* compiled from: signal_strength */
class CountryFactory extends LocaleMemberFactory<Country> {
    CountryFactory() {
    }

    protected final String[] mo574a() {
        return Locale.getISOCountries();
    }

    protected final LocaleMember mo572a(Locale locale) {
        return new Country(locale);
    }

    protected final Locale mo573a(String str) {
        return new Locale("", str);
    }
}
