package com.facebook.messaging.payment.service.model.pay;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.payments.model.PaymentItemType;
import com.facebook.payments.paymentmethods.model.PaymentMethod;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import org.json.JSONException;
import org.json.JSONObject;

@Immutable
/* compiled from: fetch_location */
public class SendPaymentParams implements Parcelable {
    public static final Creator<SendPaymentParams> CREATOR = new C16871();
    public final PaymentItemType f14674a;
    public final String f14675b;
    public final String f14676c;
    public final String f14677d;
    public final String f14678e;
    public final String f14679f;
    public final String f14680g;
    @Nullable
    public final String f14681h;
    public final String f14682i;
    public final String f14683j;
    public final PaymentMethod f14684k;
    public final String f14685l;
    public final JSONObject f14686m;
    public final String f14687n;

    /* compiled from: fetch_location */
    final class C16871 implements Creator<SendPaymentParams> {
        C16871() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SendPaymentParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new SendPaymentParams[i];
        }
    }

    public SendPaymentParams(SendPaymentParamsBuilder sendPaymentParamsBuilder) {
        boolean z;
        boolean z2 = true;
        if (StringUtil.a(sendPaymentParamsBuilder.f14689b)) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z);
        if (StringUtil.a(sendPaymentParamsBuilder.f14690c)) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z);
        if (StringUtil.a(sendPaymentParamsBuilder.f14693f)) {
            z2 = false;
        }
        Preconditions.checkArgument(z2);
        this.f14674a = sendPaymentParamsBuilder.f14688a;
        this.f14675b = sendPaymentParamsBuilder.f14689b;
        this.f14676c = sendPaymentParamsBuilder.f14690c;
        this.f14677d = sendPaymentParamsBuilder.f14691d;
        this.f14678e = sendPaymentParamsBuilder.f14692e;
        this.f14679f = sendPaymentParamsBuilder.f14693f;
        this.f14680g = sendPaymentParamsBuilder.f14694g;
        this.f14681h = sendPaymentParamsBuilder.f14695h;
        this.f14682i = sendPaymentParamsBuilder.f14696i;
        this.f14683j = sendPaymentParamsBuilder.f14697j;
        this.f14684k = sendPaymentParamsBuilder.f14698k;
        this.f14685l = sendPaymentParamsBuilder.f14699l;
        this.f14686m = sendPaymentParamsBuilder.f14700m;
        this.f14687n = sendPaymentParamsBuilder.f14701n;
    }

    public SendPaymentParams(Parcel parcel) {
        this.f14674a = (PaymentItemType) ParcelUtil.c(parcel, PaymentItemType.class);
        this.f14675b = parcel.readString();
        this.f14676c = parcel.readString();
        this.f14677d = parcel.readString();
        this.f14678e = parcel.readString();
        this.f14679f = parcel.readString();
        this.f14680g = parcel.readString();
        this.f14681h = parcel.readString();
        this.f14682i = parcel.readString();
        this.f14683j = parcel.readString();
        this.f14684k = (PaymentMethod) ParcelUtil.b(parcel, PaymentMethod.class);
        this.f14685l = parcel.readString();
        this.f14686m = m15187a(parcel);
        this.f14687n = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtil.a(parcel, this.f14674a);
        parcel.writeString(this.f14675b);
        parcel.writeString(this.f14676c);
        parcel.writeString(this.f14677d);
        parcel.writeString(this.f14678e);
        parcel.writeString(this.f14679f);
        parcel.writeString(this.f14680g);
        parcel.writeString(this.f14681h);
        parcel.writeString(this.f14682i);
        parcel.writeString(this.f14683j);
        parcel.writeParcelable(this.f14684k, i);
        parcel.writeString(this.f14685l);
        parcel.writeString(this.f14686m != null ? this.f14686m.toString() : null);
        parcel.writeString(this.f14687n);
    }

    @Nullable
    private static JSONObject m15187a(Parcel parcel) {
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
