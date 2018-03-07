package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.messaging.model.folders.FolderName;
import com.facebook.messaging.model.folders.ThreadTypeFilter;

/* compiled from: cover_photo_id */
public class FetchMoreThreadsParams implements Parcelable {
    public static final Creator<FetchMoreThreadsParams> CREATOR = new C20191();
    public final FolderName f17083a;
    public final ThreadTypeFilter f17084b;
    public final long f17085c;
    private final long f17086d;
    public final int f17087e;
    public final long f17088f;

    /* compiled from: cover_photo_id */
    final class C20191 implements Creator<FetchMoreThreadsParams> {
        C20191() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchMoreThreadsParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchMoreThreadsParams[i];
        }
    }

    public FetchMoreThreadsParams(FolderName folderName, long j, long j2, int i) {
        this(folderName, ThreadTypeFilter.ALL, j, j2, i, -1);
    }

    public FetchMoreThreadsParams(FolderName folderName, ThreadTypeFilter threadTypeFilter, long j, long j2, int i, long j3) {
        this.f17083a = folderName;
        this.f17084b = threadTypeFilter;
        this.f17085c = j;
        this.f17086d = j2;
        this.f17087e = i;
        this.f17088f = j3;
    }

    public FetchMoreThreadsParams(Parcel parcel) {
        this.f17083a = FolderName.fromDbName(parcel.readString());
        this.f17084b = ThreadTypeFilter.valueOf(parcel.readString());
        this.f17085c = parcel.readLong();
        this.f17086d = parcel.readLong();
        this.f17087e = parcel.readInt();
        this.f17088f = parcel.readLong();
    }

    public final FolderName m17089a() {
        return this.f17083a;
    }

    public final long m17090c() {
        return this.f17085c;
    }

    public final int m17091d() {
        return this.f17087e;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f17083a.dbName);
        parcel.writeString(this.f17084b.name());
        parcel.writeLong(this.f17085c);
        parcel.writeLong(this.f17086d);
        parcel.writeInt(this.f17087e);
        parcel.writeLong(this.f17088f);
    }
}
