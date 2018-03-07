package com.google.android.gms.location;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzw;
import java.util.List;

public class ActivityRecognitionResult implements SafeParcelable {
    public static final ActivityRecognitionResultCreator CREATOR = new ActivityRecognitionResultCreator();
    public List<DetectedActivity> f6285a;
    public long f6286b;
    public long f6287c;
    public int f6288d;
    public Bundle f6289e;
    public final int f6290f;

    public ActivityRecognitionResult(int i, List<DetectedActivity> list, long j, long j2, int i2, Bundle bundle) {
        this.f6290f = i;
        this.f6285a = list;
        this.f6286b = j;
        this.f6287c = j2;
        this.f6288d = i2;
        this.f6289e = bundle;
    }

    private static boolean m8832a(Bundle bundle, Bundle bundle2) {
        if (bundle == null && bundle2 == null) {
            return true;
        }
        if ((bundle == null && bundle2 != null) || (bundle != null && bundle2 == null)) {
            return false;
        }
        if (bundle.size() != bundle2.size()) {
            return false;
        }
        for (String str : bundle.keySet()) {
            if (!bundle2.containsKey(str)) {
                return false;
            }
            if (bundle.get(str) == null) {
                if (bundle2.get(str) != null) {
                    return false;
                }
            } else if (bundle.get(str) instanceof Bundle) {
                if (!m8832a(bundle.getBundle(str), bundle2.getBundle(str))) {
                    return false;
                }
            } else if (!bundle.get(str).equals(bundle2.get(str))) {
                return false;
            }
        }
        return true;
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
        ActivityRecognitionResult activityRecognitionResult = (ActivityRecognitionResult) obj;
        return this.f6286b == activityRecognitionResult.f6286b && this.f6287c == activityRecognitionResult.f6287c && this.f6288d == activityRecognitionResult.f6288d && zzw.a(this.f6285a, activityRecognitionResult.f6285a) && m8832a(this.f6289e, activityRecognitionResult.f6289e);
    }

    public int hashCode() {
        return zzw.a(new Object[]{Long.valueOf(this.f6286b), Long.valueOf(this.f6287c), Integer.valueOf(this.f6288d), this.f6285a, this.f6289e});
    }

    public String toString() {
        return "ActivityRecognitionResult [probableActivities=" + this.f6285a + ", timeMillis=" + this.f6286b + ", elapsedRealtimeMillis=" + this.f6287c + "]";
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.c(parcel, 1, this.f6285a, false);
        zzb.a(parcel, 1000, this.f6290f);
        zzb.a(parcel, 2, this.f6286b);
        zzb.a(parcel, 3, this.f6287c);
        zzb.a(parcel, 4, this.f6288d);
        zzb.a(parcel, 5, this.f6289e, false);
        zzb.c(parcel, a);
    }
}
