package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzx;
import java.util.List;

public class AccountChangeEventsResponse implements SafeParcelable {
    public static final Creator<AccountChangeEventsResponse> CREATOR = new zzc();
    public final int f6344a;
    public final List<AccountChangeEvent> f6345b;

    AccountChangeEventsResponse(int i, List<AccountChangeEvent> list) {
        this.f6344a = i;
        this.f6345b = (List) zzx.a(list);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.m12237a(parcel);
        zzb.m12241a(parcel, 1, this.f6344a);
        zzb.m12259c(parcel, 2, this.f6345b, false);
        zzb.m12258c(parcel, a);
    }
}
