package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: create_thread_participant_count */
public class BlockUserParams implements Parcelable {
    public static final Creator<BlockUserParams> CREATOR = new C19931();
    public final long f17015a;
    public final long f17016b;

    /* compiled from: create_thread_participant_count */
    final class C19931 implements Creator<BlockUserParams> {
        C19931() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new BlockUserParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new BlockUserParams[i];
        }
    }

    public BlockUserParams(Parcel parcel) {
        this.f17015a = parcel.readLong();
        this.f17016b = parcel.readLong();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f17016b);
        parcel.writeLong(this.f17015a);
    }
}
