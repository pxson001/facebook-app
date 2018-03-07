package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.widget.LinearLayoutCompat;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public class AccountChangeEvent implements SafeParcelable {
    public static final Creator<AccountChangeEvent> CREATOR = new zza();
    public final int f6334a;
    public final long f6335b;
    public final String f6336c;
    public final int f6337d;
    public final int f6338e;
    public final String f6339f;

    AccountChangeEvent(int i, long j, String str, int i2, int i3, String str2) {
        this.f6334a = i;
        this.f6335b = j;
        this.f6336c = (String) zzx.a(str);
        this.f6337d = i2;
        this.f6338e = i3;
        this.f6339f = str2;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AccountChangeEvent)) {
            return false;
        }
        AccountChangeEvent accountChangeEvent = (AccountChangeEvent) obj;
        return this.f6334a == accountChangeEvent.f6334a && this.f6335b == accountChangeEvent.f6335b && zzw.a(this.f6336c, accountChangeEvent.f6336c) && this.f6337d == accountChangeEvent.f6337d && this.f6338e == accountChangeEvent.f6338e && zzw.a(this.f6339f, accountChangeEvent.f6339f);
    }

    public int hashCode() {
        return zzw.a(new Object[]{Integer.valueOf(this.f6334a), Long.valueOf(this.f6335b), this.f6336c, Integer.valueOf(this.f6337d), Integer.valueOf(this.f6338e), this.f6339f});
    }

    public String toString() {
        String str = "UNKNOWN";
        switch (this.f6337d) {
            case 1:
                str = "ADDED";
                break;
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                str = "REMOVED";
                break;
            case 3:
                str = "RENAMED_FROM";
                break;
            case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                str = "RENAMED_TO";
                break;
        }
        return "AccountChangeEvent {accountName = " + this.f6336c + ", changeType = " + str + ", changeData = " + this.f6339f + ", eventIndex = " + this.f6338e + "}";
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.m12237a(parcel);
        zzb.m12241a(parcel, 1, this.f6334a);
        zzb.m12242a(parcel, 2, this.f6335b);
        zzb.m12247a(parcel, 3, this.f6336c, false);
        zzb.m12241a(parcel, 4, this.f6337d);
        zzb.m12241a(parcel, 5, this.f6338e);
        zzb.m12247a(parcel, 6, this.f6339f, false);
        zzb.m12258c(parcel, a);
    }
}
