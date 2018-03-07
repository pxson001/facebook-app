package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class AmsEntityUpdateParcelable implements SafeParcelable {
    public static final Creator<AmsEntityUpdateParcelable> CREATOR = new zzf();
    public final int f13203a;
    public byte f13204b;
    public final byte f13205c;
    public final String f13206d;

    AmsEntityUpdateParcelable(int i, byte b, byte b2, String str) {
        this.f13204b = b;
        this.f13203a = i;
        this.f13205c = b2;
        this.f13206d = str;
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
        AmsEntityUpdateParcelable amsEntityUpdateParcelable = (AmsEntityUpdateParcelable) obj;
        return this.f13204b != amsEntityUpdateParcelable.f13204b ? false : this.f13203a != amsEntityUpdateParcelable.f13203a ? false : this.f13205c != amsEntityUpdateParcelable.f13205c ? false : this.f13206d.equals(amsEntityUpdateParcelable.f13206d);
    }

    public int hashCode() {
        return (((((this.f13203a * 31) + this.f13204b) * 31) + this.f13205c) * 31) + this.f13206d.hashCode();
    }

    public String toString() {
        return "AmsEntityUpdateParcelable{mVersionCode=" + this.f13203a + ", mEntityId=" + this.f13204b + ", mAttributeId=" + this.f13205c + ", mValue='" + this.f13206d + '\'' + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f13203a);
        zzb.a(parcel, 2, this.f13204b);
        zzb.a(parcel, 3, this.f13205c);
        zzb.a(parcel, 4, this.f13206d, false);
        zzb.c(parcel, a);
    }
}
