package com.facebook.messaging.payment.service.model.transactions;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: fetchQueryResultParams */
public class SendCampaignPaymentMessageParams implements Parcelable {
    public static final Creator<SendCampaignPaymentMessageParams> CREATOR = new C17081();
    public static String f14753a = "sendCampaignPaymentMessageParams";
    public final ImmutableList<Long> f14754b;
    public final String f14755c;
    public final String f14756d;
    public final String f14757e;

    /* compiled from: fetchQueryResultParams */
    final class C17081 implements Creator<SendCampaignPaymentMessageParams> {
        C17081() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SendCampaignPaymentMessageParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new SendCampaignPaymentMessageParams[i];
        }
    }

    protected SendCampaignPaymentMessageParams(Parcel parcel) {
        this.f14754b = ImmutableList.copyOf(parcel.readArrayList(Long.class.getClassLoader()));
        this.f14755c = parcel.readString();
        this.f14756d = parcel.readString();
        this.f14757e = parcel.readString();
    }

    public String toString() {
        return Objects.toStringHelper(this).add("recipientIds", this.f14754b).add("campaignName", this.f14755c).add("externalRequestId", this.f14756d).add("message", this.f14757e).toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f14754b);
        parcel.writeString(this.f14755c);
        parcel.writeString(this.f14756d);
        parcel.writeString(this.f14757e);
    }
}
