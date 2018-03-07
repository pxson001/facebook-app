package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzw;

public class JoinOptions implements SafeParcelable {
    public static final Creator<JoinOptions> CREATOR = new zzc();
    public final int f9982a;
    public int f9983b;

    public JoinOptions() {
        this(1, 0);
    }

    JoinOptions(int i, int i2) {
        this.f9982a = i;
        this.f9983b = i2;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof JoinOptions)) {
            return false;
        }
        return this.f9983b == ((JoinOptions) obj).f9983b;
    }

    public int hashCode() {
        return zzw.a(new Object[]{Integer.valueOf(this.f9983b)});
    }

    public String toString() {
        String str;
        switch (this.f9983b) {
            case 0:
                str = "STRONG";
                break;
            case 2:
                str = "INVISIBLE";
                break;
            default:
                str = "UNKNOWN";
                break;
        }
        return String.format("joinOptions(connectionType=%s)", new Object[]{str});
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f9982a);
        zzb.a(parcel, 2, this.f9983b);
        zzb.c(parcel, a);
    }
}
