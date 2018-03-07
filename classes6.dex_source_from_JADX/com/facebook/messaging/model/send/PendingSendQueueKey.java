package com.facebook.messaging.model.send;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.google.common.base.Preconditions;

/* compiled from: upload_fail */
public class PendingSendQueueKey implements Parcelable {
    public static final Creator<PendingSendQueueKey> CREATOR = new C01051();
    public final ThreadKey f2166a;
    public final PendingSendQueueType f2167b;

    /* compiled from: upload_fail */
    final class C01051 implements Creator<PendingSendQueueKey> {
        C01051() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PendingSendQueueKey(parcel);
        }

        public final Object[] newArray(int i) {
            return new PendingSendQueueKey[i];
        }
    }

    public PendingSendQueueKey(ThreadKey threadKey, PendingSendQueueType pendingSendQueueType) {
        Preconditions.checkNotNull(threadKey);
        Preconditions.checkNotNull(pendingSendQueueType);
        this.f2166a = threadKey;
        this.f2167b = pendingSendQueueType;
    }

    public PendingSendQueueKey(Parcel parcel) {
        this.f2166a = (ThreadKey) parcel.readParcelable(ThreadKey.class.getClassLoader());
        this.f2167b = (PendingSendQueueType) parcel.readSerializable();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PendingSendQueueKey pendingSendQueueKey = (PendingSendQueueKey) obj;
        if (this.f2167b != pendingSendQueueKey.f2167b) {
            return false;
        }
        if (this.f2166a.equals(pendingSendQueueKey.f2166a)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.f2166a.hashCode() * 31) + this.f2167b.hashCode();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f2166a, i);
        parcel.writeSerializable(this.f2167b);
    }
}
