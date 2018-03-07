package com.facebook.messaging.payment.service.model.pay;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@JsonDeserialize(using = SendPaymentBankDetailsDeserializer.class)
/* compiled from: fetch_saved_audiences */
public class SendPaymentBankDetails implements Parcelable {
    public static final Creator<SendPaymentBankDetails> CREATOR = new C16851();
    @JsonProperty("code")
    private final String mCode;
    @JsonProperty("dismiss_url")
    @Nullable
    private final String mDismissUrl;
    @JsonProperty("image")
    private final String mImage;
    @JsonProperty("name")
    private final String mName;
    @JsonProperty("redirect_url")
    @Nullable
    private final String mRedirectUrl;

    /* compiled from: fetch_saved_audiences */
    final class C16851 implements Creator<SendPaymentBankDetails> {
        C16851() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SendPaymentBankDetails(parcel);
        }

        public final Object[] newArray(int i) {
            return new SendPaymentBankDetails[i];
        }
    }

    private SendPaymentBankDetails() {
        this.mCode = null;
        this.mImage = null;
        this.mRedirectUrl = null;
        this.mDismissUrl = null;
        this.mName = null;
    }

    public SendPaymentBankDetails(String str, String str2, String str3, String str4, String str5) {
        this.mCode = str;
        this.mImage = str2;
        this.mRedirectUrl = str3;
        this.mDismissUrl = str4;
        this.mName = str5;
    }

    public SendPaymentBankDetails(Parcel parcel) {
        this.mCode = parcel.readString();
        this.mImage = parcel.readString();
        this.mRedirectUrl = parcel.readString();
        this.mDismissUrl = parcel.readString();
        this.mName = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mCode);
        parcel.writeString(this.mImage);
        parcel.writeString(this.mRedirectUrl);
        parcel.writeString(this.mDismissUrl);
        parcel.writeString(this.mName);
    }

    public final String m15177a() {
        return this.mCode;
    }

    public final String m15178b() {
        return this.mImage;
    }

    @Nullable
    public final String m15179c() {
        return this.mRedirectUrl;
    }

    @Nullable
    public final String m15180d() {
        return this.mDismissUrl;
    }

    public final String m15181e() {
        return this.mName;
    }
}
