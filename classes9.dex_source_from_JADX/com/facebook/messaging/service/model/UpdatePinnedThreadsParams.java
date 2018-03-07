package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.google.common.collect.ImmutableList;

/* compiled from: confirmation_code */
public class UpdatePinnedThreadsParams implements Parcelable {
    public static final Creator<UpdatePinnedThreadsParams> CREATOR = new C20661();
    public final ImmutableList<ThreadKey> f17343a;
    public final ImmutableList<ThreadKey> f17344b;

    /* compiled from: confirmation_code */
    final class C20661 implements Creator<UpdatePinnedThreadsParams> {
        C20661() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new UpdatePinnedThreadsParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new UpdatePinnedThreadsParams[i];
        }
    }

    public UpdatePinnedThreadsParams(Parcel parcel) {
        this.f17343a = ImmutableList.copyOf(parcel.readArrayList(ThreadKey.class.getClassLoader()));
        this.f17344b = ImmutableList.copyOf(parcel.readArrayList(ThreadKey.class.getClassLoader()));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f17343a);
        parcel.writeList(this.f17344b);
    }
}
