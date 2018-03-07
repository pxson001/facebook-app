package com.facebook.platform.params;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* compiled from: fetched_bytes */
public class PlatformComposerParams implements Parcelable {
    public static final Creator<PlatformComposerParams> CREATOR = new C09841();
    public final String f14925a;
    public final boolean f14926b;
    public final boolean f14927c;
    public final String f14928d;
    public final String f14929e;
    public final String f14930f;
    public final String f14931g;
    public final String f14932h;
    public final Set<Long> f14933i;

    /* compiled from: fetched_bytes */
    final class C09841 implements Creator<PlatformComposerParams> {
        C09841() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PlatformComposerParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new PlatformComposerParams[i];
        }
    }

    public PlatformComposerParams(String str, boolean z, boolean z2, String str2, String str3, String str4, String str5, String str6, Set<Long> set) {
        this.f14925a = str;
        this.f14926b = z;
        this.f14927c = z2;
        this.f14928d = str2;
        this.f14929e = str3;
        this.f14930f = str4;
        this.f14931g = str5;
        this.f14932h = str6;
        this.f14933i = set;
    }

    public PlatformComposerParams(Parcel parcel) {
        boolean z = true;
        this.f14925a = parcel.readString();
        this.f14926b = parcel.readByte() != (byte) 0;
        if (parcel.readByte() == (byte) 0) {
            z = false;
        }
        this.f14927c = z;
        this.f14928d = parcel.readString();
        this.f14929e = parcel.readString();
        this.f14930f = parcel.readString();
        this.f14931g = parcel.readString();
        this.f14932h = parcel.readString();
        Iterable arrayList = new ArrayList();
        parcel.readList(arrayList, null);
        this.f14933i = Sets.b(arrayList);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeString(this.f14925a);
        parcel.writeByte((byte) (this.f14926b ? 1 : 0));
        if (!this.f14927c) {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeString(this.f14928d);
        parcel.writeString(this.f14929e);
        parcel.writeString(this.f14930f);
        parcel.writeString(this.f14931g);
        parcel.writeString(this.f14932h);
        List arrayList = new ArrayList();
        arrayList.addAll(this.f14933i);
        parcel.writeList(arrayList);
    }
}
