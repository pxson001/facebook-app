package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.google.common.base.MoreObjects;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: createThread */
public class FetchIdentityKeysParams implements Parcelable {
    public static final Creator<FetchIdentityKeysParams> CREATOR = new C20091();
    public final ThreadKey f17058a;

    /* compiled from: createThread */
    final class C20091 implements Creator<FetchIdentityKeysParams> {
        C20091() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchIdentityKeysParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchIdentityKeysParams[i];
        }
    }

    public FetchIdentityKeysParams(Parcel parcel) {
        this.f17058a = (ThreadKey) parcel.readParcelable(ThreadKey.class.getClassLoader());
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("threadkey", this.f17058a.toString()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f17058a, i);
    }
}
