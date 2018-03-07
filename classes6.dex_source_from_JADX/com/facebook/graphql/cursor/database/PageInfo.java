package com.facebook.graphql.cursor.database;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: mProfilePictureOverlay */
public final class PageInfo implements Parcelable {
    public static final Creator<PageInfo> CREATOR = new C06791();
    public final String f10971a;
    public final String f10972b;
    @Nullable
    public final String f10973c;
    @Nullable
    public final String f10974d;
    public final boolean f10975e;
    public final boolean f10976f;
    public final int f10977g;
    public final long f10978h;

    /* compiled from: mProfilePictureOverlay */
    final class C06791 implements Creator<PageInfo> {
        C06791() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PageInfo(parcel);
        }

        public final Object[] newArray(int i) {
            return new PageInfo[i];
        }
    }

    public PageInfo(String str, String str2, String str3, String str4, boolean z, boolean z2, int i) {
        this(str, str2, str3, str4, z, z2, i, 0);
    }

    @VisibleForTesting
    public PageInfo(String str, String str2, String str3, String str4, boolean z, boolean z2, int i, long j) {
        boolean z3;
        boolean z4 = true;
        Preconditions.checkArgument(str.compareTo(str2) > 0);
        if (str.length() == 32) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3);
        if (str2.length() == 32) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3);
        if (i < 0) {
            z4 = false;
        }
        Preconditions.checkArgument(z4);
        this.f10971a = str;
        this.f10972b = str2;
        this.f10973c = str3;
        this.f10974d = str4;
        this.f10975e = z;
        this.f10976f = z2;
        this.f10977g = i;
        this.f10978h = j;
    }

    public PageInfo(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.f10971a = parcel.readString();
        this.f10972b = parcel.readString();
        this.f10973c = parcel.readString();
        this.f10974d = parcel.readString();
        if (parcel.readInt() > 0) {
            z = true;
        } else {
            z = false;
        }
        this.f10975e = z;
        if (parcel.readInt() <= 0) {
            z2 = false;
        }
        this.f10976f = z2;
        this.f10977g = parcel.readInt();
        this.f10978h = parcel.readLong();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(this.f10971a);
        parcel.writeString(this.f10972b);
        parcel.writeString(this.f10973c);
        parcel.writeString(this.f10974d);
        if (this.f10975e) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!this.f10976f) {
            i3 = 0;
        }
        parcel.writeInt(i3);
        parcel.writeInt(this.f10977g);
        parcel.writeLong(this.f10978h);
    }
}
