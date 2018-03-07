package com.facebook.messaging.payment.service.model.moneypenny;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.payments.checkout.model.SendPaymentCheckoutResult;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@JsonDeserialize(using = MoneyPennyPlaceOrderResultDeserializer.class)
@Immutable
/* compiled from: fetch_single_notification_from_db  */
public class MoneyPennyPlaceOrderResult implements Parcelable, SendPaymentCheckoutResult {
    public static final Creator<MoneyPennyPlaceOrderResult> CREATOR = new C16841();
    @JsonProperty("payment_id")
    private final String mTransactionId;

    /* compiled from: fetch_single_notification_from_db  */
    final class C16841 implements Creator<MoneyPennyPlaceOrderResult> {
        C16841() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new MoneyPennyPlaceOrderResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new MoneyPennyPlaceOrderResult[i];
        }
    }

    public MoneyPennyPlaceOrderResult(Parcel parcel) {
        this.mTransactionId = parcel.readString();
    }

    public final String mo598a() {
        return this.mTransactionId;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mTransactionId);
    }

    private MoneyPennyPlaceOrderResult() {
        this.mTransactionId = null;
    }
}
