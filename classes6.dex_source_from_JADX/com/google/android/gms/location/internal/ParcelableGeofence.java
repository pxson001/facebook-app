package com.google.android.gms.location.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.location.Geofence;
import java.util.Locale;

public class ParcelableGeofence implements SafeParcelable, Geofence {
    public static final zzo CREATOR = new zzo();
    public final int f6375a;
    public final String f6376b;
    public final long f6377c;
    public final short f6378d;
    public final double f6379e;
    public final double f6380f;
    public final float f6381g;
    public final int f6382h;
    public final int f6383i;
    public final int f6384j;

    public ParcelableGeofence(int i, String str, int i2, short s, double d, double d2, float f, long j, int i3, int i4) {
        m8864a(str);
        m8863a(f);
        m8862a(d, d2);
        int a = m8861a(i2);
        this.f6375a = i;
        this.f6378d = s;
        this.f6376b = str;
        this.f6379e = d;
        this.f6380f = d2;
        this.f6381g = f;
        this.f6377c = j;
        this.f6382h = a;
        this.f6383i = i3;
        this.f6384j = i4;
    }

    public ParcelableGeofence(String str, int i, short s, double d, double d2, float f, long j, int i2, int i3) {
        this(1, str, i, s, d, d2, f, j, i2, i3);
    }

    private static int m8861a(int i) {
        int i2 = i & 7;
        if (i2 != 0) {
            return i2;
        }
        throw new IllegalArgumentException("No supported transition specified: " + i);
    }

    private static void m8862a(double d, double d2) {
        if (d > 90.0d || d < -90.0d) {
            throw new IllegalArgumentException("invalid latitude: " + d);
        } else if (d2 > 180.0d || d2 < -180.0d) {
            throw new IllegalArgumentException("invalid longitude: " + d2);
        }
    }

    private static void m8863a(float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("invalid radius: " + f);
        }
    }

    private static void m8864a(String str) {
        if (str == null || str.length() > 100) {
            throw new IllegalArgumentException("requestId is null or too long: " + str);
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ParcelableGeofence)) {
            return false;
        }
        ParcelableGeofence parcelableGeofence = (ParcelableGeofence) obj;
        return this.f6381g != parcelableGeofence.f6381g ? false : this.f6379e != parcelableGeofence.f6379e ? false : this.f6380f != parcelableGeofence.f6380f ? false : this.f6378d == parcelableGeofence.f6378d;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f6379e);
        int i = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.f6380f);
        return (((((((i * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + Float.floatToIntBits(this.f6381g)) * 31) + this.f6378d) * 31) + this.f6382h;
    }

    public String toString() {
        String str;
        Locale locale = Locale.US;
        String str2 = "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]";
        Object[] objArr = new Object[9];
        switch (this.f6378d) {
            case (short) 1:
                str = "CIRCLE";
                break;
            default:
                str = null;
                break;
        }
        objArr[0] = str;
        objArr[1] = this.f6376b;
        objArr[2] = Integer.valueOf(this.f6382h);
        objArr[3] = Double.valueOf(this.f6379e);
        objArr[4] = Double.valueOf(this.f6380f);
        objArr[5] = Float.valueOf(this.f6381g);
        objArr[6] = Integer.valueOf(this.f6383i / 1000);
        objArr[7] = Integer.valueOf(this.f6384j);
        objArr[8] = Long.valueOf(this.f6377c);
        return String.format(locale, str2, objArr);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f6376b, false);
        zzb.a(parcel, 1000, this.f6375a);
        zzb.a(parcel, 2, this.f6377c);
        short s = this.f6378d;
        zzb.b(parcel, 3, 4);
        parcel.writeInt(s);
        zzb.a(parcel, 4, this.f6379e);
        zzb.a(parcel, 5, this.f6380f);
        zzb.a(parcel, 6, this.f6381g);
        zzb.a(parcel, 7, this.f6382h);
        zzb.a(parcel, 8, this.f6383i);
        zzb.a(parcel, 9, this.f6384j);
        zzb.c(parcel, a);
    }
}
