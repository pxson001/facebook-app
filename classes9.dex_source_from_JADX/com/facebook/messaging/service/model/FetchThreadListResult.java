package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.fbservice.results.DataFetchDisposition;
import com.facebook.messaging.model.folders.FolderCounts;
import com.facebook.messaging.model.folders.FolderName;
import com.facebook.messaging.model.threads.NotificationSetting;
import com.facebook.messaging.model.threads.ThreadsCollection;
import com.facebook.user.model.User;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: copy_message */
public class FetchThreadListResult implements Parcelable {
    public static final Creator<FetchThreadListResult> CREATOR = new C20281();
    public final DataFetchDisposition f17131a;
    public final FolderName f17132b;
    public final ThreadsCollection f17133c;
    public final ImmutableList<User> f17134d;
    public final ImmutableList<String> f17135e;
    public final ImmutableList<String> f17136f;
    public final FolderCounts f17137g;
    public final NotificationSetting f17138h;
    public final boolean f17139i;
    public final long f17140j;
    public final long f17141k;
    public final long f17142l;

    /* compiled from: copy_message */
    final class C20281 implements Creator<FetchThreadListResult> {
        C20281() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchThreadListResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchThreadListResult[i];
        }
    }

    public static FetchThreadListResultBuilder newBuilder() {
        return new FetchThreadListResultBuilder();
    }

    public static FetchThreadListResult m17117a(FolderName folderName) {
        FetchThreadListResultBuilder newBuilder = newBuilder();
        newBuilder.f17143a = DataFetchDisposition.a;
        newBuilder = newBuilder;
        newBuilder.f17144b = folderName;
        return newBuilder.m17129m();
    }

    FetchThreadListResult(FetchThreadListResultBuilder fetchThreadListResultBuilder) {
        Preconditions.checkNotNull(fetchThreadListResultBuilder.f17143a);
        this.f17131a = fetchThreadListResultBuilder.f17143a;
        this.f17132b = fetchThreadListResultBuilder.f17144b;
        this.f17133c = fetchThreadListResultBuilder.f17145c;
        this.f17134d = ImmutableList.copyOf(fetchThreadListResultBuilder.f17146d);
        this.f17135e = ImmutableList.copyOf(fetchThreadListResultBuilder.f17147e);
        this.f17136f = ImmutableList.copyOf(fetchThreadListResultBuilder.f17148f);
        this.f17137g = fetchThreadListResultBuilder.f17149g;
        this.f17138h = fetchThreadListResultBuilder.f17150h;
        this.f17139i = fetchThreadListResultBuilder.f17151i;
        this.f17140j = fetchThreadListResultBuilder.f17153k;
        this.f17141k = fetchThreadListResultBuilder.f17154l;
        this.f17142l = fetchThreadListResultBuilder.f17152j;
    }

    public FetchThreadListResult(Parcel parcel) {
        this.f17131a = (DataFetchDisposition) parcel.readParcelable(DataFetchDisposition.class.getClassLoader());
        this.f17132b = FolderName.fromDbName(parcel.readString());
        this.f17133c = (ThreadsCollection) parcel.readParcelable(ThreadsCollection.class.getClassLoader());
        this.f17134d = ImmutableList.copyOf(parcel.readArrayList(User.class.getClassLoader()));
        this.f17137g = (FolderCounts) parcel.readParcelable(FolderCounts.class.getClassLoader());
        this.f17138h = (NotificationSetting) parcel.readParcelable(NotificationSetting.class.getClassLoader());
        this.f17135e = ImmutableList.copyOf(parcel.createStringArrayList());
        this.f17136f = ImmutableList.copyOf(parcel.createStringArrayList());
        this.f17139i = ParcelUtil.a(parcel);
        this.f17140j = parcel.readLong();
        this.f17141k = parcel.readLong();
        this.f17142l = parcel.readLong();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f17131a, i);
        parcel.writeString(this.f17132b.dbName);
        parcel.writeParcelable(this.f17133c, i);
        parcel.writeList(this.f17134d);
        parcel.writeParcelable(this.f17137g, i);
        parcel.writeParcelable(this.f17138h, i);
        parcel.writeStringList(this.f17135e);
        parcel.writeStringList(this.f17136f);
        ParcelUtil.a(parcel, this.f17139i);
        parcel.writeLong(this.f17140j);
        parcel.writeLong(this.f17141k);
        parcel.writeLong(this.f17142l);
    }
}
