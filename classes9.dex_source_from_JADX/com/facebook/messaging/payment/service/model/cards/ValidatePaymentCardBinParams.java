package com.facebook.messaging.payment.service.model.cards;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.util.StringUtil;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: fetch_websites */
public class ValidatePaymentCardBinParams implements Parcelable {
    public static final Creator<ValidatePaymentCardBinParams> CREATOR = new C16791();
    public static String f14657a = "validatePaymentCardBinParams";
    public final String f14658b;

    /* compiled from: fetch_websites */
    final class C16791 implements Creator<ValidatePaymentCardBinParams> {
        C16791() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ValidatePaymentCardBinParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new ValidatePaymentCardBinParams[i];
        }
    }

    public ValidatePaymentCardBinParams(String str) {
        boolean z;
        boolean z2 = true;
        if (StringUtil.a(str)) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z);
        if (str.length() != 6) {
            z2 = false;
        }
        Preconditions.checkArgument(z2);
        this.f14658b = str;
    }

    public ValidatePaymentCardBinParams(Parcel parcel) {
        this.f14658b = parcel.readString();
    }

    public String toString() {
        return Objects.toStringHelper(this).add("paymentCardBin", this.f14658b).toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f14658b);
    }
}
