package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzx;

public class UserAttributeParcel implements SafeParcelable {
    public static final zzad CREATOR = new zzad();
    public final int f7052a;
    public final String f7053b;
    public final long f7054c;
    public final Long f7055d;
    public final Float f7056e;
    public final String f7057f;
    public final String f7058g;

    UserAttributeParcel(int i, String str, long j, Long l, Float f, String str2, String str3) {
        this.f7052a = i;
        this.f7053b = str;
        this.f7054c = j;
        this.f7055d = l;
        this.f7056e = f;
        this.f7057f = str2;
        this.f7058g = str3;
    }

    UserAttributeParcel(String str, long j, Object obj, String str2) {
        zzx.a(str);
        this.f7052a = 1;
        this.f7053b = str;
        this.f7054c = j;
        this.f7058g = str2;
        if (obj == null) {
            this.f7055d = null;
            this.f7056e = null;
            this.f7057f = null;
        } else if (obj instanceof Long) {
            this.f7055d = (Long) obj;
            this.f7056e = null;
            this.f7057f = null;
        } else if (obj instanceof Float) {
            this.f7055d = null;
            this.f7056e = (Float) obj;
            this.f7057f = null;
        } else if (obj instanceof String) {
            this.f7055d = null;
            this.f7056e = null;
            this.f7057f = (String) obj;
        } else {
            throw new IllegalArgumentException("User attribute given of un-supported type");
        }
    }

    public final Object m13068a() {
        return this.f7055d != null ? this.f7055d : this.f7056e != null ? this.f7056e : this.f7057f != null ? this.f7057f : null;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.m12237a(parcel);
        zzb.m12241a(parcel, 1, this.f7052a);
        zzb.m12247a(parcel, 2, this.f7053b, false);
        zzb.m12242a(parcel, 3, this.f7054c);
        zzb.m12246a(parcel, 4, this.f7055d, false);
        Float f = this.f7056e;
        if (f != null) {
            zzb.m12256b(parcel, 5, 4);
            parcel.writeFloat(f.floatValue());
        } else if (null != null) {
            zzb.m12256b(parcel, 5, 0);
        }
        zzb.m12247a(parcel, 6, this.f7057f, false);
        zzb.m12247a(parcel, 7, this.f7058g, false);
        zzb.m12258c(parcel, a);
    }
}
