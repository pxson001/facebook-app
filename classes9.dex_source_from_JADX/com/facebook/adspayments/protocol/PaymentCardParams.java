package com.facebook.adspayments.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.common.locale.Country;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.payments.model.PaymentItemType;
import com.google.common.base.Strings;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

/* compiled from: USE_THREAD_NAME_IF_AVAILABLE */
public abstract class PaymentCardParams implements Parcelable {
    public final PaymentItemType f23685a;
    public final String f23686b;
    public final int f23687c;
    public final int f23688d;
    public final String f23689e;
    public final Country f23690f;

    public PaymentCardParams(PaymentItemType paymentItemType, String str, int i, int i2, String str2, Country country) {
        this.f23685a = paymentItemType;
        this.f23686b = str;
        this.f23687c = i;
        this.f23688d = i2;
        this.f23689e = str2;
        this.f23690f = country;
    }

    public PaymentCardParams(Parcel parcel) {
        this.f23685a = (PaymentItemType) ParcelUtil.c(parcel, PaymentItemType.class);
        this.f23686b = parcel.readString();
        this.f23687c = parcel.readInt();
        this.f23688d = parcel.readInt();
        this.f23689e = parcel.readString();
        this.f23690f = (Country) parcel.readParcelable(Country.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtil.a(parcel, this.f23685a);
        parcel.writeString(this.f23686b);
        parcel.writeInt(this.f23687c);
        parcel.writeInt(this.f23688d);
        parcel.writeString(this.f23689e);
        parcel.writeParcelable(this.f23690f, i);
    }

    public final List<NameValuePair> m25703f() {
        List<NameValuePair> arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("payment_type", this.f23685a.getValue()));
        arrayList.add(new BasicNameValuePair("csc", this.f23686b));
        arrayList.add(new BasicNameValuePair("expiry_month", String.valueOf(this.f23687c)));
        arrayList.add(new BasicNameValuePair("expiry_year", "20" + String.valueOf(this.f23688d)));
        JSONObject put = new JSONObject().put("country_code", this.f23690f.b());
        if (!Strings.isNullOrEmpty(this.f23689e)) {
            put.put("zip", this.f23689e);
        }
        arrayList.add(new BasicNameValuePair("billing_address", put.toString()));
        return arrayList;
    }
}
