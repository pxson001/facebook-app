package com.facebook.payments.paymentmethods.picker.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.locale.Country;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.payments.model.PaymentItemType;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import org.json.JSONException;
import org.json.JSONObject;

@Immutable
/* compiled from: birthdays/ */
public class GetPaymentMethodsInfoParams implements Parcelable {
    public static final Creator<GetPaymentMethodsInfoParams> CREATOR = new C22101();
    public final PaymentItemType f18856a;
    public final String f18857b;
    public final JSONObject f18858c;
    public final Country f18859d;

    /* compiled from: birthdays/ */
    final class C22101 implements Creator<GetPaymentMethodsInfoParams> {
        C22101() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GetPaymentMethodsInfoParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new GetPaymentMethodsInfoParams[i];
        }
    }

    public GetPaymentMethodsInfoParams(GetPaymentMethodsInfoParamsBuilder getPaymentMethodsInfoParamsBuilder) {
        this.f18856a = (PaymentItemType) Preconditions.checkNotNull(getPaymentMethodsInfoParamsBuilder.f18860a);
        this.f18857b = (String) Preconditions.checkNotNull(getPaymentMethodsInfoParamsBuilder.f18861b);
        this.f18858c = getPaymentMethodsInfoParamsBuilder.f18862c;
        this.f18859d = getPaymentMethodsInfoParamsBuilder.f18863d;
    }

    public GetPaymentMethodsInfoParams(Parcel parcel) {
        this.f18856a = (PaymentItemType) ParcelUtil.c(parcel, PaymentItemType.class);
        this.f18857b = parcel.readString();
        this.f18858c = m18862a(parcel);
        this.f18859d = (Country) parcel.readParcelable(Country.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtil.a(parcel, this.f18856a);
        parcel.writeString(this.f18857b);
        parcel.writeString(this.f18858c != null ? this.f18858c.toString() : null);
        parcel.writeParcelable(this.f18859d, i);
    }

    @Nullable
    private static JSONObject m18862a(Parcel parcel) {
        try {
            Object readString = parcel.readString();
            if (StringUtil.a(readString)) {
                return null;
            }
            return new JSONObject(readString);
        } catch (JSONException e) {
            return null;
        }
    }
}
