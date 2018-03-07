package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzw;
import java.util.Comparator;

public class DetectedActivity implements SafeParcelable {
    public static final DetectedActivityCreator CREATOR = new DetectedActivityCreator();
    public static final Comparator<DetectedActivity> f6291a = new C03801();
    public int f6292b;
    public int f6293c;
    public final int f6294d;

    final class C03801 implements Comparator<DetectedActivity> {
        C03801() {
        }

        public final int compare(Object obj, Object obj2) {
            DetectedActivity detectedActivity = (DetectedActivity) obj;
            DetectedActivity detectedActivity2 = (DetectedActivity) obj2;
            int compareTo = Integer.valueOf(detectedActivity2.f6293c).compareTo(Integer.valueOf(detectedActivity.f6293c));
            return compareTo == 0 ? Integer.valueOf(detectedActivity.m8835a()).compareTo(Integer.valueOf(detectedActivity2.m8835a())) : compareTo;
        }
    }

    public DetectedActivity(int i, int i2, int i3) {
        this.f6294d = i;
        this.f6292b = i2;
        this.f6293c = i3;
    }

    private static int m8834a(int i) {
        return i > 15 ? 4 : i;
    }

    public final int m8835a() {
        return m8834a(this.f6292b);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DetectedActivity detectedActivity = (DetectedActivity) obj;
        return this.f6292b == detectedActivity.f6292b && this.f6293c == detectedActivity.f6293c;
    }

    public int hashCode() {
        return zzw.a(new Object[]{Integer.valueOf(this.f6292b), Integer.valueOf(this.f6293c)});
    }

    public String toString() {
        String str;
        StringBuilder stringBuilder = new StringBuilder("DetectedActivity [type=");
        int a = m8835a();
        switch (a) {
            case 0:
                str = "IN_VEHICLE";
                break;
            case 1:
                str = "ON_BICYCLE";
                break;
            case 2:
                str = "ON_FOOT";
                break;
            case 3:
                str = "STILL";
                break;
            case 4:
                str = "UNKNOWN";
                break;
            case 5:
                str = "TILTING";
                break;
            case 7:
                str = "WALKING";
                break;
            case 8:
                str = "RUNNING";
                break;
            default:
                str = Integer.toString(a);
                break;
        }
        return stringBuilder.append(str).append(", confidence=").append(this.f6293c).append("]").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f6292b);
        zzb.a(parcel, 1000, this.f6294d);
        zzb.a(parcel, 2, this.f6293c);
        zzb.c(parcel, a);
    }
}
