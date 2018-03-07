package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzw;
import java.util.Locale;

public class LaunchOptions implements SafeParcelable {
    public static final Creator<LaunchOptions> CREATOR = new zzd();
    public final int f9985a;
    public boolean f9986b;
    public String f9987c;

    public final class Builder {
        public LaunchOptions f9984a = new LaunchOptions();
    }

    public LaunchOptions() {
        Locale locale = Locale.getDefault();
        StringBuilder stringBuilder = new StringBuilder(20);
        stringBuilder.append(locale.getLanguage());
        Object country = locale.getCountry();
        if (!TextUtils.isEmpty(country)) {
            stringBuilder.append('-').append(country);
        }
        country = locale.getVariant();
        if (!TextUtils.isEmpty(country)) {
            stringBuilder.append('-').append(country);
        }
        this(1, false, stringBuilder.toString());
    }

    LaunchOptions(int i, boolean z, String str) {
        this.f9985a = i;
        this.f9986b = z;
        this.f9987c = str;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LaunchOptions)) {
            return false;
        }
        LaunchOptions launchOptions = (LaunchOptions) obj;
        return this.f9986b == launchOptions.f9986b && zzf.m11922a(this.f9987c, launchOptions.f9987c);
    }

    public int hashCode() {
        return zzw.a(new Object[]{Boolean.valueOf(this.f9986b), this.f9987c});
    }

    public String toString() {
        return String.format("LaunchOptions(relaunchIfRunning=%b, language=%s)", new Object[]{Boolean.valueOf(this.f9986b), this.f9987c});
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f9985a);
        zzb.a(parcel, 2, this.f9986b);
        zzb.a(parcel, 3, this.f9987c, false);
        zzb.c(parcel, a);
    }
}
