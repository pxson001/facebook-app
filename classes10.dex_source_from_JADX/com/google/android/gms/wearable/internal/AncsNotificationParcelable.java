package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class AncsNotificationParcelable implements SafeParcelable {
    public static final Creator<AncsNotificationParcelable> CREATOR = new zzh();
    public final int f13207a;
    public int f13208b;
    public final String f13209c;
    public final String f13210d;
    public final String f13211e;
    public final String f13212f;
    public final String f13213g;
    public String f13214h;
    public byte f13215i;
    public byte f13216j;
    public byte f13217k;
    public byte f13218l;

    AncsNotificationParcelable(int i, int i2, String str, String str2, String str3, String str4, String str5, String str6, byte b, byte b2, byte b3, byte b4) {
        this.f13208b = i2;
        this.f13207a = i;
        this.f13209c = str;
        this.f13210d = str2;
        this.f13211e = str3;
        this.f13212f = str4;
        this.f13213g = str5;
        this.f13214h = str6;
        this.f13215i = b;
        this.f13216j = b2;
        this.f13217k = b3;
        this.f13218l = b4;
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
        AncsNotificationParcelable ancsNotificationParcelable = (AncsNotificationParcelable) obj;
        return this.f13218l != ancsNotificationParcelable.f13218l ? false : this.f13217k != ancsNotificationParcelable.f13217k ? false : this.f13216j != ancsNotificationParcelable.f13216j ? false : this.f13215i != ancsNotificationParcelable.f13215i ? false : this.f13208b != ancsNotificationParcelable.f13208b ? false : this.f13207a != ancsNotificationParcelable.f13207a ? false : !this.f13209c.equals(ancsNotificationParcelable.f13209c) ? false : (this.f13210d == null ? ancsNotificationParcelable.f13210d != null : !this.f13210d.equals(ancsNotificationParcelable.f13210d)) ? false : !this.f13214h.equals(ancsNotificationParcelable.f13214h) ? false : !this.f13211e.equals(ancsNotificationParcelable.f13211e) ? false : !this.f13213g.equals(ancsNotificationParcelable.f13213g) ? false : this.f13212f.equals(ancsNotificationParcelable.f13212f);
    }

    public int hashCode() {
        return (((((((((((((((((this.f13210d != null ? this.f13210d.hashCode() : 0) + (((((this.f13207a * 31) + this.f13208b) * 31) + this.f13209c.hashCode()) * 31)) * 31) + this.f13211e.hashCode()) * 31) + this.f13212f.hashCode()) * 31) + this.f13213g.hashCode()) * 31) + this.f13214h.hashCode()) * 31) + this.f13215i) * 31) + this.f13216j) * 31) + this.f13217k) * 31) + this.f13218l;
    }

    public String toString() {
        return "AncsNotificationParcelable{mVersionCode=" + this.f13207a + ", mId=" + this.f13208b + ", mAppId='" + this.f13209c + '\'' + ", mDateTime='" + this.f13210d + '\'' + ", mNotificationText='" + this.f13211e + '\'' + ", mTitle='" + this.f13212f + '\'' + ", mSubtitle='" + this.f13213g + '\'' + ", mDisplayName='" + this.f13214h + '\'' + ", mEventId=" + this.f13215i + ", mEventFlags=" + this.f13216j + ", mCategoryId=" + this.f13217k + ", mCategoryCount=" + this.f13218l + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f13207a);
        zzb.a(parcel, 2, this.f13208b);
        zzb.a(parcel, 3, this.f13209c, false);
        zzb.a(parcel, 4, this.f13210d, false);
        zzb.a(parcel, 5, this.f13211e, false);
        zzb.a(parcel, 6, this.f13212f, false);
        zzb.a(parcel, 7, this.f13213g, false);
        zzb.a(parcel, 8, this.f13214h == null ? this.f13209c : this.f13214h, false);
        zzb.a(parcel, 9, this.f13215i);
        zzb.a(parcel, 10, this.f13216j);
        zzb.a(parcel, 11, this.f13217k);
        zzb.a(parcel, 12, this.f13218l);
        zzb.c(parcel, a);
    }
}
