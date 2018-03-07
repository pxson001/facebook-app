package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzw;

public final class Status implements Result, SafeParcelable {
    public static final Creator<Status> CREATOR = new zzd();
    public static final Status f369a = new Status(0);
    public static final Status f370b = new Status(14);
    public static final Status f371c = new Status(8);
    public static final Status f372d = new Status(15);
    public static final Status f373e = new Status(16);
    public final int f374f;
    public final int f375g;
    public final String f376h;
    public final PendingIntent f377i;

    public Status(int i) {
        this(i, null);
    }

    Status(int i, int i2, String str, PendingIntent pendingIntent) {
        this.f374f = i;
        this.f375g = i2;
        this.f376h = str;
        this.f377i = pendingIntent;
    }

    public Status(int i, String str) {
        this(1, i, str, null);
    }

    public Status(int i, String str, PendingIntent pendingIntent) {
        this(1, i, str, pendingIntent);
    }

    public final void m732a(Activity activity, int i) {
        if ((this.f377i != null ? 1 : null) != null) {
            activity.startIntentSenderForResult(this.f377i.getIntentSender(), i, null, 0, 0, 0);
        }
    }

    public final String m733c() {
        return this.f376h;
    }

    public final Status cp_() {
        return this;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean m734e() {
        return this.f375g <= 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.f374f == status.f374f && this.f375g == status.f375g && zzw.m26867a(this.f376h, status.f376h) && zzw.m26867a(this.f377i, status.f377i);
    }

    public final int m735f() {
        return this.f375g;
    }

    public final int hashCode() {
        return zzw.m26865a(Integer.valueOf(this.f374f), Integer.valueOf(this.f375g), this.f376h, this.f377i);
    }

    public final String toString() {
        return zzw.m26866a((Object) this).a("statusCode", this.f376h != null ? this.f376h : CommonStatusCodes.a(this.f375g)).a("resolution", this.f377i).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f375g);
        zzb.a(parcel, 1000, this.f374f);
        zzb.a(parcel, 2, this.f376h, false);
        zzb.a(parcel, 3, this.f377i, i, false);
        zzb.c(parcel, a);
    }
}
