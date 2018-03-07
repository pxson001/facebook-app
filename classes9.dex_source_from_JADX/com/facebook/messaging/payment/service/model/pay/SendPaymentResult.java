package com.facebook.messaging.payment.service.model.pay;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@AutoGenJsonDeserializer
@JsonDeserialize(using = SendPaymentResultDeserializer.class)
/* compiled from: fetch_invoice_key */
public class SendPaymentResult implements Parcelable {
    public static final Creator<SendPaymentResult> CREATOR = new C16881();
    @JsonProperty("id")
    private final String mId;
    @JsonProperty("extra_data")
    private final SendPaymentResultExtra mSendPaymentResultExtra;

    /* compiled from: fetch_invoice_key */
    final class C16881 implements Creator<SendPaymentResult> {
        C16881() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SendPaymentResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new SendPaymentResult[i];
        }
    }

    public SendPaymentResult() {
        this.mId = null;
        this.mSendPaymentResultExtra = null;
    }

    public SendPaymentResult(Parcel parcel) {
        this.mId = parcel.readString();
        this.mSendPaymentResultExtra = (SendPaymentResultExtra) parcel.readParcelable(SendPaymentResultExtra.class.getClassLoader());
    }

    public final SendPaymentResultExtra m15188a() {
        return this.mSendPaymentResultExtra;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mId);
        parcel.writeParcelable(this.mSendPaymentResultExtra, i);
    }
}
