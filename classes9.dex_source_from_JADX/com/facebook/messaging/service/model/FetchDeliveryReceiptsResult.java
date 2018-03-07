package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.messaging.model.threads.ThreadDeliveryReceipts;
import com.google.common.collect.ImmutableList;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: create_dialog_cancel */
public class FetchDeliveryReceiptsResult implements Parcelable {
    public static final Creator<FetchDeliveryReceiptsResult> CREATOR = new C20051();
    public final ImmutableList<ThreadDeliveryReceipts> f17046a;

    /* compiled from: create_dialog_cancel */
    final class C20051 implements Creator<FetchDeliveryReceiptsResult> {
        C20051() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchDeliveryReceiptsResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchDeliveryReceiptsResult[i];
        }
    }

    public FetchDeliveryReceiptsResult(ImmutableList<ThreadDeliveryReceipts> immutableList) {
        this.f17046a = immutableList;
    }

    public FetchDeliveryReceiptsResult(Parcel parcel) {
        this.f17046a = ImmutableList.copyOf(parcel.readArrayList(ThreadDeliveryReceipts.class.getClassLoader()));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f17046a);
    }
}
