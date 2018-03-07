package com.facebook.messaging.payment.service.model.transactions;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.collect.ImmutableList;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: fetchPrimaryEmailAddress */
public class SendCampaignPaymentMessageResult implements Parcelable {
    public static final Creator<SendCampaignPaymentMessageResult> CREATOR = new C17091();
    private final ImmutableList<String> f14758a;

    /* compiled from: fetchPrimaryEmailAddress */
    final class C17091 implements Creator<SendCampaignPaymentMessageResult> {
        C17091() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SendCampaignPaymentMessageResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new SendCampaignPaymentMessageResult[i];
        }
    }

    public SendCampaignPaymentMessageResult(ImmutableList<String> immutableList) {
        this.f14758a = immutableList;
    }

    protected SendCampaignPaymentMessageResult(Parcel parcel) {
        this.f14758a = ImmutableList.copyOf(parcel.readArrayList(String.class.getClassLoader()));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f14758a);
    }
}
