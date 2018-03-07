package com.facebook.payments.paymentmethods.picker.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.locale.Country;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.payments.picker.model.PickerScreenFetcherParams;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import org.json.JSONException;
import org.json.JSONObject;

@Immutable
/* compiled from: blockee */
public class PaymentMethodsPickerScreenFetcherParams implements PickerScreenFetcherParams {
    public static final Creator<PaymentMethodsPickerScreenFetcherParams> CREATOR = new C22091();
    public final boolean f18847a;
    public final JSONObject f18848b;
    @Nullable
    public final Country f18849c;

    /* compiled from: blockee */
    final class C22091 implements Creator<PaymentMethodsPickerScreenFetcherParams> {
        C22091() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PaymentMethodsPickerScreenFetcherParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new PaymentMethodsPickerScreenFetcherParams[i];
        }
    }

    public static PaymentMethodsPickerScreenFetcherParamsBuilder newBuilder() {
        return new PaymentMethodsPickerScreenFetcherParamsBuilder();
    }

    public PaymentMethodsPickerScreenFetcherParams(PaymentMethodsPickerScreenFetcherParamsBuilder paymentMethodsPickerScreenFetcherParamsBuilder) {
        this.f18847a = paymentMethodsPickerScreenFetcherParamsBuilder.f18850a;
        this.f18848b = paymentMethodsPickerScreenFetcherParamsBuilder.f18851b;
        this.f18849c = paymentMethodsPickerScreenFetcherParamsBuilder.f18852c;
    }

    public PaymentMethodsPickerScreenFetcherParams(Parcel parcel) {
        this.f18847a = ParcelUtil.a(parcel);
        this.f18848b = m18852a(parcel);
        this.f18849c = (Country) parcel.readParcelable(Country.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtil.a(parcel, this.f18847a);
        parcel.writeString(this.f18848b != null ? this.f18848b.toString() : null);
        parcel.writeParcelable(this.f18849c, i);
    }

    @Nullable
    private static JSONObject m18852a(Parcel parcel) {
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
