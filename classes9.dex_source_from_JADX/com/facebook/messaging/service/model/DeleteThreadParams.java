package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.messaging.model.threadkey.ThreadKey;

/* compiled from: create_session_fail */
public class DeleteThreadParams implements Parcelable {
    public static final Creator<DeleteThreadParams> CREATOR = new C19991();
    public final ThreadKey f17035a;

    /* compiled from: create_session_fail */
    final class C19991 implements Creator<DeleteThreadParams> {
        C19991() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new DeleteThreadParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new DeleteThreadParams[i];
        }
    }

    public DeleteThreadParams(ThreadKey threadKey) {
        this.f17035a = threadKey;
    }

    public DeleteThreadParams(Parcel parcel) {
        this.f17035a = (ThreadKey) parcel.readParcelable(ThreadKey.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f17035a, i);
    }
}
