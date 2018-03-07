package com.facebook.messaging.model.folders;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: user_enabled_location_providers */
public class FolderCounts implements Parcelable {
    public static final Creator<FolderCounts> CREATOR = new C00831();
    public static final FolderCounts f1932a = new FolderCounts(0, 0, 0, 0);
    public final int f1933b;
    public final int f1934c;
    public final long f1935d;
    public final long f1936e;

    /* compiled from: user_enabled_location_providers */
    final class C00831 implements Creator<FolderCounts> {
        C00831() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FolderCounts(parcel);
        }

        public final Object[] newArray(int i) {
            return new FolderCounts[i];
        }
    }

    public FolderCounts(int i, int i2, long j, long j2) {
        this.f1933b = i;
        this.f1934c = i2;
        this.f1935d = j;
        this.f1936e = j2;
    }

    public FolderCounts(Parcel parcel) {
        this.f1933b = parcel.readInt();
        this.f1934c = parcel.readInt();
        this.f1935d = parcel.readLong();
        this.f1936e = parcel.readLong();
    }

    public final long m3280d() {
        return this.f1936e;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f1933b);
        parcel.writeInt(this.f1934c);
        parcel.writeLong(this.f1935d);
        parcel.writeLong(this.f1936e);
    }
}
