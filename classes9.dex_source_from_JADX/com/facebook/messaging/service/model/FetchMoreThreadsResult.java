package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.fbservice.results.DataFetchDisposition;
import com.facebook.messaging.model.folders.FolderName;
import com.facebook.messaging.model.threads.ThreadsCollection;
import com.facebook.user.model.User;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: cover_photo_high_res_uri */
public class FetchMoreThreadsResult implements Parcelable {
    public static final Creator<FetchMoreThreadsResult> CREATOR = new C20201();
    public final DataFetchDisposition f17089a;
    public final FolderName f17090b;
    public final ThreadsCollection f17091c;
    public final ImmutableList<User> f17092d;
    public final long f17093e;

    /* compiled from: cover_photo_high_res_uri */
    final class C20201 implements Creator<FetchMoreThreadsResult> {
        C20201() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchMoreThreadsResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchMoreThreadsResult[i];
        }
    }

    public FetchMoreThreadsResult(DataFetchDisposition dataFetchDisposition, FolderName folderName, ThreadsCollection threadsCollection, @Nullable ImmutableList<User> immutableList, long j) {
        this.f17089a = dataFetchDisposition;
        this.f17090b = folderName;
        this.f17091c = threadsCollection;
        if (immutableList == null) {
            immutableList = RegularImmutableList.a;
        }
        this.f17092d = immutableList;
        this.f17093e = j;
    }

    public FetchMoreThreadsResult(Parcel parcel) {
        this.f17089a = (DataFetchDisposition) parcel.readParcelable(DataFetchDisposition.class.getClassLoader());
        this.f17090b = FolderName.fromDbName(parcel.readString());
        this.f17091c = (ThreadsCollection) parcel.readParcelable(ThreadsCollection.class.getClassLoader());
        this.f17092d = ImmutableList.copyOf(parcel.readArrayList(User.class.getClassLoader()));
        this.f17093e = parcel.readLong();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f17089a, i);
        parcel.writeString(this.f17090b.dbName);
        parcel.writeParcelable(this.f17091c, i);
        parcel.writeList(this.f17092d);
        parcel.writeLong(this.f17093e);
    }
}
