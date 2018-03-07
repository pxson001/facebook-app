package com.facebook.messaging.payment.sync.delta;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: fetchMoreMessagesParams */
public class PaymentsPrefetchedSyncData implements Parcelable {
    public static final Creator<PaymentsPrefetchedSyncData> CREATOR = new C17171();

    /* compiled from: fetchMoreMessagesParams */
    final class C17171 implements Creator<PaymentsPrefetchedSyncData> {
        C17171() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PaymentsPrefetchedSyncData();
        }

        public final Object[] newArray(int i) {
            return new PaymentsPrefetchedSyncData[i];
        }
    }

    public String toString() {
        return Objects.toStringHelper(PaymentsPrefetchedSyncData.class).toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
    }
}
