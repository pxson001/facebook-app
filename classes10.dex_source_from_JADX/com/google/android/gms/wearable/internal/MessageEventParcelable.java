package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.wearable.MessageEvent;

public class MessageEventParcelable implements SafeParcelable, MessageEvent {
    public static final Creator<MessageEventParcelable> CREATOR = new zzbn();
    public final int f13332a;
    public final int f13333b;
    private final String f13334c;
    private final byte[] f13335d;
    public final String f13336e;

    MessageEventParcelable(int i, int i2, String str, byte[] bArr, String str2) {
        this.f13332a = i;
        this.f13333b = i2;
        this.f13334c = str;
        this.f13335d = bArr;
        this.f13336e = str2;
    }

    public final String mo581a() {
        return this.f13334c;
    }

    public final byte[] mo582b() {
        return this.f13335d;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "MessageEventParcelable[" + this.f13333b + "," + this.f13334c + ", size=" + (this.f13335d == null ? "null" : Integer.valueOf(this.f13335d.length)) + "]";
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f13332a);
        zzb.a(parcel, 2, this.f13333b);
        zzb.a(parcel, 3, mo581a(), false);
        zzb.a(parcel, 4, mo582b(), false);
        zzb.a(parcel, 5, this.f13336e, false);
        zzb.c(parcel, a);
    }
}
