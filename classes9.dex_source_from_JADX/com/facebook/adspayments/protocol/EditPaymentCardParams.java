package com.facebook.adspayments.protocol;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.locale.Country;
import com.facebook.payments.model.PaymentItemType;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: findfriends?ci_flow={%s %s}&ccu_ref={%s %s}&force_show_legal_screen={!%s false} */
public class EditPaymentCardParams extends PaymentCardParams {
    public static final Creator<EditPaymentCardParams> CREATOR = new C28621();
    public final String f23696a;

    /* compiled from: findfriends?ci_flow={%s %s}&ccu_ref={%s %s}&force_show_legal_screen={!%s false} */
    final class C28621 implements Creator<EditPaymentCardParams> {
        C28621() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new EditPaymentCardParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new EditPaymentCardParams[i];
        }
    }

    public EditPaymentCardParams(String str, PaymentItemType paymentItemType, String str2, int i, int i2, String str3, Country country) {
        super(paymentItemType, str2, i, i2, str3, country);
        this.f23696a = str;
    }

    public EditPaymentCardParams(Parcel parcel) {
        super(parcel);
        this.f23696a = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f23696a);
    }
}
