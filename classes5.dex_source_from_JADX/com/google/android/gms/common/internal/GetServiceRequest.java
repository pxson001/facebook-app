package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzp.zza;
import java.util.Collection;

public class GetServiceRequest implements SafeParcelable {
    public static final Creator<GetServiceRequest> CREATOR = new zzi();
    public final int f6533a;
    public final int f6534b;
    public int f6535c;
    public String f6536d;
    public IBinder f6537e;
    public Scope[] f6538f;
    public Bundle f6539g;
    public Account f6540h;

    public GetServiceRequest(int i) {
        this.f6533a = 2;
        this.f6535c = GoogleApiAvailability.a;
        this.f6534b = i;
    }

    GetServiceRequest(int i, int i2, int i3, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account) {
        this.f6533a = i;
        this.f6534b = i2;
        this.f6535c = i3;
        this.f6536d = str;
        if (i < 2) {
            Account account2 = null;
            if (iBinder != null) {
                account2 = zza.m12263a(zza.m12262a(iBinder));
            }
            this.f6540h = account2;
        } else {
            this.f6537e = iBinder;
            this.f6540h = account;
        }
        this.f6538f = scopeArr;
        this.f6539g = bundle;
    }

    public final GetServiceRequest m12195a(Account account) {
        this.f6540h = account;
        return this;
    }

    public final GetServiceRequest m12196a(Bundle bundle) {
        this.f6539g = bundle;
        return this;
    }

    public final GetServiceRequest m12197a(zzp com_google_android_gms_common_internal_zzp) {
        if (com_google_android_gms_common_internal_zzp != null) {
            this.f6537e = com_google_android_gms_common_internal_zzp.asBinder();
        }
        return this;
    }

    public final GetServiceRequest m12198a(String str) {
        this.f6536d = str;
        return this;
    }

    public final GetServiceRequest m12199a(Collection<Scope> collection) {
        this.f6538f = (Scope[]) collection.toArray(new Scope[collection.size()]);
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.m12237a(parcel);
        zzb.m12241a(parcel, 1, this.f6533a);
        zzb.m12241a(parcel, 2, this.f6534b);
        zzb.m12241a(parcel, 3, this.f6535c);
        zzb.m12247a(parcel, 4, this.f6536d, false);
        zzb.m12244a(parcel, 5, this.f6537e, false);
        zzb.m12252a(parcel, 6, this.f6538f, i, false);
        zzb.m12243a(parcel, 7, this.f6539g, false);
        zzb.m12245a(parcel, 8, this.f6540h, i, false);
        zzb.m12258c(parcel, a);
    }
}
