package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.Set;

public class AuthAccountRequest implements SafeParcelable {
    public static final Creator<AuthAccountRequest> CREATOR = new zzc();
    public final int f6525a;
    public final IBinder f6526b;
    public final Scope[] f6527c;

    AuthAccountRequest(int i, IBinder iBinder, Scope[] scopeArr) {
        this.f6525a = i;
        this.f6526b = iBinder;
        this.f6527c = scopeArr;
    }

    public AuthAccountRequest(zzp com_google_android_gms_common_internal_zzp, Set<Scope> set) {
        this(1, com_google_android_gms_common_internal_zzp.asBinder(), (Scope[]) set.toArray(new Scope[set.size()]));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.m12237a(parcel);
        zzb.m12241a(parcel, 1, this.f6525a);
        zzb.m12244a(parcel, 2, this.f6526b, false);
        zzb.m12252a(parcel, 3, this.f6527c, i, false);
        zzb.m12258c(parcel, a);
    }
}
