package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.google.common.collect.ImmutableSet;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: create_thread_key */
public class DeleteAllTincanThreadsResult implements Parcelable {
    public static final Creator<DeleteAllTincanThreadsResult> CREATOR = new C19961();
    public final ImmutableSet<ThreadKey> f17024a;

    /* compiled from: create_thread_key */
    final class C19961 implements Creator<DeleteAllTincanThreadsResult> {
        C19961() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new DeleteAllTincanThreadsResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new DeleteAllTincanThreadsResult[i];
        }
    }

    DeleteAllTincanThreadsResult(Parcel parcel) {
        this.f17024a = ImmutableSet.copyOf((ThreadKey[]) parcel.readArray(ThreadKey.class.getClassLoader()));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelableArray((ThreadKey[]) this.f17024a.toArray(), i);
    }
}
