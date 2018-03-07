package com.facebook.messaging.payment.service.model.transactions;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.payments.checkout.model.SendPaymentCheckoutResult;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.Optional;

@AutoGenJsonDeserializer
@JsonDeserialize(using = SendPaymentMessageResultDeserializer.class)
/* compiled from: fetchPaymentTransactionParams */
public class SendPaymentMessageResult implements Parcelable, SendPaymentCheckoutResult {
    public static final Creator<SendPaymentMessageResult> CREATOR = new C17111();
    @JsonProperty("id")
    private final String id;
    @JsonProperty("risk_result")
    private final String riskResult;
    @JsonProperty("verification_url")
    private final String verificationUrl;

    /* compiled from: fetchPaymentTransactionParams */
    final class C17111 implements Creator<SendPaymentMessageResult> {
        C17111() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SendPaymentMessageResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new SendPaymentMessageResult[i];
        }
    }

    public SendPaymentMessageResult() {
        this.id = null;
        this.riskResult = null;
        this.verificationUrl = null;
    }

    public SendPaymentMessageResult(Parcel parcel) {
        this.id = parcel.readString();
        this.riskResult = parcel.readString();
        this.verificationUrl = parcel.readString();
    }

    public final String m15207b() {
        return this.id;
    }

    public final String m15208c() {
        return this.riskResult;
    }

    public final Optional<String> m15209d() {
        return Optional.fromNullable(this.verificationUrl);
    }

    public final String mo598a() {
        return this.id;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.riskResult);
        parcel.writeString(this.verificationUrl);
    }
}
