package com.facebook.messaging.model.threads;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.user.model.UserKey;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableMap;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: updateOrderMethod */
public class ThreadDeliveryReceipts implements Parcelable {
    public static final Creator<ThreadDeliveryReceipts> CREATOR = new C01201();
    private final ThreadKey f2259a;
    private final ImmutableMap<UserKey, Long> f2260b;

    /* compiled from: updateOrderMethod */
    final class C01201 implements Creator<ThreadDeliveryReceipts> {
        C01201() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ThreadDeliveryReceipts(parcel);
        }

        public final Object[] newArray(int i) {
            return new ThreadDeliveryReceipts[i];
        }
    }

    public ThreadDeliveryReceipts(ThreadKey threadKey, ImmutableMap<UserKey, Long> immutableMap) {
        this.f2259a = threadKey;
        this.f2260b = immutableMap;
    }

    public ThreadDeliveryReceipts(Parcel parcel) {
        this.f2259a = (ThreadKey) parcel.readParcelable(ThreadKey.class.getClassLoader());
        this.f2260b = (ImmutableMap) parcel.readSerializable();
    }

    public final ThreadKey m3537a() {
        return this.f2259a;
    }

    public final ImmutableMap<UserKey, Long> m3538b() {
        return this.f2260b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f2259a, i);
        parcel.writeSerializable(this.f2260b);
    }

    public String toString() {
        return Objects.toStringHelper(ThreadDeliveryReceipts.class).add("mThreadKey", this.f2259a).add("mDeliveryReceipts", this.f2260b).toString();
    }
}
