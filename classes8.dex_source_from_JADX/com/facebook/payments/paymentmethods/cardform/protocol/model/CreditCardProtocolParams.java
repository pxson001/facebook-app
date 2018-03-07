package com.facebook.payments.paymentmethods.cardform.protocol.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.payments.model.PaymentItemType;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.concurrent.Immutable;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

@Immutable
/* compiled from: swipe-left */
public abstract class CreditCardProtocolParams implements Parcelable {
    public final PaymentItemType f1915d;
    public final String f1916e;
    public final int f1917f;
    public final int f1918g;
    public final String f1919h;
    public final String f1920i;

    /* compiled from: swipe-left */
    public abstract class Builder<BUILDER extends Builder> {
        public PaymentItemType f1907a;
        public String f1908b;
        public int f1909c;
        public int f1910d;
        public String f1911e;
        public String f1912f;
    }

    protected CreditCardProtocolParams(Builder builder) {
        this.f1915d = (PaymentItemType) Preconditions.checkNotNull(builder.f1907a);
        this.f1916e = (String) Preconditions.checkNotNull(builder.f1908b);
        this.f1917f = ((Integer) Preconditions.checkNotNull(Integer.valueOf(builder.f1909c))).intValue();
        this.f1918g = ((Integer) Preconditions.checkNotNull(Integer.valueOf(builder.f1910d))).intValue();
        this.f1919h = (String) Preconditions.checkNotNull(builder.f1911e);
        this.f1920i = builder.f1912f;
    }

    protected CreditCardProtocolParams(Parcel parcel) {
        this.f1915d = (PaymentItemType) ParcelUtil.c(parcel, PaymentItemType.class);
        this.f1916e = parcel.readString();
        this.f1917f = parcel.readInt();
        this.f1918g = parcel.readInt();
        this.f1919h = parcel.readString();
        this.f1920i = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtil.a(parcel, this.f1915d);
        parcel.writeString(this.f1916e);
        parcel.writeInt(this.f1917f);
        parcel.writeInt(this.f1918g);
        parcel.writeString(this.f1919h);
        parcel.writeString(this.f1920i);
    }

    public List<NameValuePair> mo88a() {
        List<NameValuePair> arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("payment_type", this.f1915d.getValue()));
        arrayList.add(new BasicNameValuePair("csc", this.f1916e));
        arrayList.add(new BasicNameValuePair("expiry_month", String.valueOf(this.f1917f)));
        arrayList.add(new BasicNameValuePair("expiry_year", "20" + String.valueOf(this.f1918g)));
        arrayList.add(new BasicNameValuePair("billing_address", new JSONObject().put("zip", this.f1919h).put("country_code", this.f1920i).toString()));
        return arrayList;
    }
}
