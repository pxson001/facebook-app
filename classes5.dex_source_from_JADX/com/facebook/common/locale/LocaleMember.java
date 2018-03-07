package com.facebook.common.locale;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.common.stringformat.StringFormatUtil;
import java.util.Locale;

/* compiled from: silent_link */
public abstract class LocaleMember implements Parcelable {
    protected final Locale f2685b;

    public abstract String mo569b();

    public abstract String mo570b(Locale locale);

    public abstract String mo571c();

    public LocaleMember(Locale locale) {
        this.f2685b = locale;
    }

    public String toString() {
        return StringFormatUtil.formatStrLocaleSafe("%s (%s/%s)", mo570b(Locale.US), mo569b(), mo571c());
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        return mo569b().equals(((LocaleMember) obj).mo569b());
    }

    public int hashCode() {
        return mo569b().hashCode();
    }

    public int describeContents() {
        return hashCode();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mo569b());
    }
}
