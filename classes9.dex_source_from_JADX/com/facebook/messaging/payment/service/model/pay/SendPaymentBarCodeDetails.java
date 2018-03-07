package com.facebook.messaging.payment.service.model.pay;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@AutoGenJsonDeserializer
@JsonDeserialize(using = SendPaymentBarCodeDetailsDeserializer.class)
/* compiled from: fetch_payment_methods */
public class SendPaymentBarCodeDetails implements Parcelable {
    public static final Creator<SendPaymentBarCodeDetails> CREATOR = new C16861();
    @JsonProperty("barcode")
    private final String mBarCode;
    @JsonProperty("barcode_value")
    private final String mBarCodeValue;
    @JsonProperty("expiry_timestamp")
    private final String mExpiryTimeStamp;
    @JsonProperty("instructions_url")
    private final String mInstructionsUrl;
    @JsonProperty("qrcode")
    private final String mQrCode;
    @JsonProperty("reference_no_1")
    private final String mReferenceNo1;
    @JsonProperty("reference_no_2")
    private final String mReferenceNo2;

    /* compiled from: fetch_payment_methods */
    final class C16861 implements Creator<SendPaymentBarCodeDetails> {
        C16861() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SendPaymentBarCodeDetails(parcel);
        }

        public final Object[] newArray(int i) {
            return new SendPaymentBarCodeDetails[i];
        }
    }

    public SendPaymentBarCodeDetails() {
        this.mBarCode = null;
        this.mQrCode = null;
        this.mBarCodeValue = null;
        this.mExpiryTimeStamp = null;
        this.mInstructionsUrl = null;
        this.mReferenceNo1 = null;
        this.mReferenceNo2 = null;
    }

    public SendPaymentBarCodeDetails(Parcel parcel) {
        this.mBarCode = parcel.readString();
        this.mQrCode = parcel.readString();
        this.mBarCodeValue = parcel.readString();
        this.mExpiryTimeStamp = parcel.readString();
        this.mInstructionsUrl = parcel.readString();
        this.mReferenceNo1 = parcel.readString();
        this.mReferenceNo2 = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mBarCode);
        parcel.writeString(this.mQrCode);
        parcel.writeString(this.mBarCodeValue);
        parcel.writeString(this.mExpiryTimeStamp);
        parcel.writeString(this.mInstructionsUrl);
        parcel.writeString(this.mReferenceNo1);
        parcel.writeString(this.mReferenceNo2);
    }

    public final String m15184a() {
        return this.mInstructionsUrl;
    }
}
