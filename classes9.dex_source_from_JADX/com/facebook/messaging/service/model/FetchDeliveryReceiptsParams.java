package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.google.common.collect.ImmutableList;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: create_dialog_close */
public class FetchDeliveryReceiptsParams implements Parcelable {
    public static final Creator<FetchDeliveryReceiptsParams> CREATOR = new C20041();
    public final ImmutableList<ThreadKey> f17045a;

    /* compiled from: create_dialog_close */
    final class C20041 implements Creator<FetchDeliveryReceiptsParams> {
        C20041() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchDeliveryReceiptsParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchDeliveryReceiptsParams[i];
        }
    }

    public FetchDeliveryReceiptsParams(ImmutableList<ThreadKey> immutableList) {
        this.f17045a = immutableList;
    }

    public FetchDeliveryReceiptsParams(Parcel parcel) {
        this.f17045a = ImmutableList.copyOf(parcel.readArrayList(ThreadKey.class.getClassLoader()));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f17045a);
    }
}
