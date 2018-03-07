package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class RecordConsentRequest implements SafeParcelable {
    public static final Creator<RecordConsentRequest> CREATOR = new zzg();
    public final int f7158a;
    public final Account f7159b;
    public final Scope[] f7160c;
    public final String f7161d;

    RecordConsentRequest(int i, Account account, Scope[] scopeArr, String str) {
        this.f7158a = i;
        this.f7159b = account;
        this.f7160c = scopeArr;
        this.f7161d = str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.m12237a(parcel);
        zzb.m12241a(parcel, 1, this.f7158a);
        zzb.m12245a(parcel, 2, (Parcelable) this.f7159b, i, false);
        zzb.m12252a(parcel, 3, (Parcelable[]) this.f7160c, i, false);
        zzb.m12247a(parcel, 4, this.f7161d, false);
        zzb.m12258c(parcel, a);
    }
}
