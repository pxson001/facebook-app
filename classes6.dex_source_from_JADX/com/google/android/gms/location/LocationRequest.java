package com.google.android.gms.location;

import android.os.Parcel;
import android.os.SystemClock;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzw;

public final class LocationRequest implements SafeParcelable {
    public static final LocationRequestCreator CREATOR = new LocationRequestCreator();
    public int f6324a;
    public long f6325b;
    public long f6326c;
    public boolean f6327d;
    public long f6328e;
    public int f6329f;
    public float f6330g;
    public long f6331h;
    public final int f6332i;

    public LocationRequest() {
        this.f6332i = 1;
        this.f6324a = 102;
        this.f6325b = 3600000;
        this.f6326c = 600000;
        this.f6327d = false;
        this.f6328e = Long.MAX_VALUE;
        this.f6329f = Integer.MAX_VALUE;
        this.f6330g = 0.0f;
        this.f6331h = 0;
    }

    LocationRequest(int i, int i2, long j, long j2, boolean z, long j3, int i3, float f, long j4) {
        this.f6332i = i;
        this.f6324a = i2;
        this.f6325b = j;
        this.f6326c = j2;
        this.f6327d = z;
        this.f6328e = j3;
        this.f6329f = i3;
        this.f6330g = f;
        this.f6331h = j4;
    }

    public static LocationRequest m8848a() {
        return new LocationRequest();
    }

    public static void m8849b(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("invalid displacement: " + f);
        }
    }

    private static void m8850b(int i) {
        switch (i) {
            case 100:
            case 102:
            case 104:
            case 105:
                return;
            default:
                throw new IllegalArgumentException("invalid quality: " + i);
        }
    }

    public static void m8851c(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("invalid interval: " + j);
        }
    }

    public final LocationRequest m8852a(int i) {
        m8850b(i);
        this.f6324a = i;
        return this;
    }

    public final LocationRequest m8853a(long j) {
        m8851c(j);
        this.f6325b = j;
        if (!this.f6327d) {
            this.f6326c = (long) (((double) this.f6325b) / 6.0d);
        }
        return this;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocationRequest)) {
            return false;
        }
        LocationRequest locationRequest = (LocationRequest) obj;
        return this.f6324a == locationRequest.f6324a && this.f6325b == locationRequest.f6325b && this.f6326c == locationRequest.f6326c && this.f6327d == locationRequest.f6327d && this.f6328e == locationRequest.f6328e && this.f6329f == locationRequest.f6329f && this.f6330g == locationRequest.f6330g;
    }

    public final int hashCode() {
        return zzw.a(new Object[]{Integer.valueOf(this.f6324a), Long.valueOf(this.f6325b), Long.valueOf(this.f6326c), Boolean.valueOf(this.f6327d), Long.valueOf(this.f6328e), Integer.valueOf(this.f6329f), Float.valueOf(this.f6330g)});
    }

    public final String toString() {
        String str;
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder append = stringBuilder.append("Request[");
        switch (this.f6324a) {
            case 100:
                str = "PRIORITY_HIGH_ACCURACY";
                break;
            case 102:
                str = "PRIORITY_BALANCED_POWER_ACCURACY";
                break;
            case 104:
                str = "PRIORITY_LOW_POWER";
                break;
            case 105:
                str = "PRIORITY_NO_POWER";
                break;
            default:
                str = "???";
                break;
        }
        append.append(str);
        if (this.f6324a != 105) {
            stringBuilder.append(" requested=");
            stringBuilder.append(this.f6325b).append("ms");
        }
        stringBuilder.append(" fastest=");
        stringBuilder.append(this.f6326c).append("ms");
        if (this.f6331h > this.f6325b) {
            stringBuilder.append(" maxWait=");
            stringBuilder.append(this.f6331h).append("ms");
        }
        if (this.f6328e != Long.MAX_VALUE) {
            long elapsedRealtime = this.f6328e - SystemClock.elapsedRealtime();
            stringBuilder.append(" expireIn=");
            stringBuilder.append(elapsedRealtime).append("ms");
        }
        if (this.f6329f != Integer.MAX_VALUE) {
            stringBuilder.append(" num=").append(this.f6329f);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f6324a);
        zzb.a(parcel, 1000, this.f6332i);
        zzb.a(parcel, 2, this.f6325b);
        zzb.a(parcel, 3, this.f6326c);
        zzb.a(parcel, 4, this.f6327d);
        zzb.a(parcel, 5, this.f6328e);
        zzb.a(parcel, 6, this.f6329f);
        zzb.a(parcel, 7, this.f6330g);
        zzb.a(parcel, 8, this.f6331h);
        zzb.c(parcel, a);
    }
}
