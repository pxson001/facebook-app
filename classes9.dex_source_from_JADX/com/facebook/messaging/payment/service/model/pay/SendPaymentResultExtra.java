package com.facebook.messaging.payment.service.model.pay;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@JsonDeserialize(using = SendPaymentResultExtraDeserializer.class)
/* compiled from: fetch_friendable_contacts */
public class SendPaymentResultExtra implements Parcelable {
    public static final Creator<SendPaymentResultExtra> CREATOR = new C16891();
    @JsonProperty("net_banking_info")
    @Nullable
    private final SendPaymentBankDetails mSendPaymentBankDetails;
    @JsonProperty("pay_over_counter_info")
    @Nullable
    private final SendPaymentBarCodeDetails mSendPaymentBarCodeDetails;

    /* compiled from: fetch_friendable_contacts */
    final class C16891 implements Creator<SendPaymentResultExtra> {
        C16891() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SendPaymentResultExtra(parcel);
        }

        public final Object[] newArray(int i) {
            return new SendPaymentResultExtra[i];
        }
    }

    private SendPaymentResultExtra() {
        this.mSendPaymentBarCodeDetails = null;
        this.mSendPaymentBankDetails = null;
    }

    public SendPaymentResultExtra(Parcel parcel) {
        this.mSendPaymentBarCodeDetails = (SendPaymentBarCodeDetails) parcel.readParcelable(SendPaymentBarCodeDetails.class.getClassLoader());
        this.mSendPaymentBankDetails = (SendPaymentBankDetails) parcel.readParcelable(SendPaymentBankDetails.class.getClassLoader());
    }

    @Nullable
    public final SendPaymentBarCodeDetails m15191a() {
        return this.mSendPaymentBarCodeDetails;
    }

    @Nullable
    public final SendPaymentBankDetails m15192b() {
        return this.mSendPaymentBankDetails;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mSendPaymentBarCodeDetails, i);
        parcel.writeParcelable(this.mSendPaymentBankDetails, i);
    }
}
