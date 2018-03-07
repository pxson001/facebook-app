package com.facebook.common.locale;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Locale;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: single_line_full_address */
public class Country extends LocaleMember {
    public static final Creator<Country> CREATOR = new C01861();
    public static final Country f2686a = m3788a("US");
    private static final CountryFactory f2687c = new CountryFactory();

    /* compiled from: single_line_full_address */
    final class C01861 implements Creator<Country> {
        C01861() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return Country.m3788a(parcel.readString());
        }

        public final Object[] newArray(int i) {
            return new Country[i];
        }
    }

    Country(Locale locale) {
        super(locale);
    }

    public static Country m3788a(String str) {
        return (Country) f2687c.m3800b(str);
    }

    public static Country m3789a(Locale locale) {
        return m3788a(locale.getCountry());
    }

    public final String m3790a() {
        return this.f2685b.getDisplayCountry();
    }

    public final String mo570b(Locale locale) {
        return this.f2685b.getDisplayCountry(locale);
    }

    public final String mo569b() {
        return this.f2685b.getCountry();
    }

    public final String mo571c() {
        return this.f2685b.getISO3Country();
    }
}
