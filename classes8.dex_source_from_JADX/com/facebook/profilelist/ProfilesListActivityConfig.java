package com.facebook.profilelist;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;

/* compiled from: remove_ids */
public class ProfilesListActivityConfig implements Parcelable {
    public static final Creator<ProfilesListActivityConfig> CREATOR = new C06011();
    public final int f4569a;
    public final int f4570b;
    public final int f4571c;
    public final long f4572d;
    public final boolean f4573e;

    /* compiled from: remove_ids */
    final class C06011 implements Creator<ProfilesListActivityConfig> {
        C06011() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ProfilesListActivityConfig(parcel);
        }

        public final Object[] newArray(int i) {
            return new ProfilesListActivityConfig[i];
        }
    }

    public ProfilesListActivityConfig(int i, int i2, int i3, boolean z, long j) {
        this.f4569a = i;
        this.f4570b = i2;
        this.f4571c = i3;
        this.f4572d = j;
        this.f4573e = z;
    }

    public ProfilesListActivityConfig(Parcel parcel) {
        this.f4569a = parcel.readInt();
        this.f4570b = parcel.readInt();
        this.f4571c = parcel.readInt();
        this.f4572d = parcel.readLong();
        this.f4573e = ParcelUtil.a(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f4569a);
        parcel.writeInt(this.f4570b);
        parcel.writeInt(this.f4571c);
        parcel.writeLong(this.f4572d);
        ParcelUtil.a(parcel, this.f4573e);
    }
}
