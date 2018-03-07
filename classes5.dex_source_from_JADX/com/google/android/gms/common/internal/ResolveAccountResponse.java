package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzp.zza;

public class ResolveAccountResponse implements SafeParcelable {
    public static final Creator<ResolveAccountResponse> CREATOR = new zzz();
    public final int f6545a;
    public IBinder f6546b;
    public ConnectionResult f6547c;
    public boolean f6548d;
    public boolean f6549e;

    public ResolveAccountResponse(int i) {
        this(new ConnectionResult(i, null));
    }

    ResolveAccountResponse(int i, IBinder iBinder, ConnectionResult connectionResult, boolean z, boolean z2) {
        this.f6545a = i;
        this.f6546b = iBinder;
        this.f6547c = connectionResult;
        this.f6548d = z;
        this.f6549e = z2;
    }

    private ResolveAccountResponse(ConnectionResult connectionResult) {
        this(1, null, connectionResult, false, false);
    }

    public final zzp m12200a() {
        return zza.m12262a(this.f6546b);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResolveAccountResponse)) {
            return false;
        }
        ResolveAccountResponse resolveAccountResponse = (ResolveAccountResponse) obj;
        return this.f6547c.equals(resolveAccountResponse.f6547c) && m12200a().equals(resolveAccountResponse.m12200a());
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.m12237a(parcel);
        zzb.m12241a(parcel, 1, this.f6545a);
        zzb.m12244a(parcel, 2, this.f6546b, false);
        zzb.m12245a(parcel, 3, (Parcelable) this.f6547c, i, false);
        zzb.m12249a(parcel, 4, this.f6548d);
        zzb.m12249a(parcel, 5, this.f6549e);
        zzb.m12258c(parcel, a);
    }
}
