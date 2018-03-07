package com.facebook.payments.paymentmethods.cardform.protocol.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.payments.util.PaymentItemTypeUtil;
import com.google.common.base.Preconditions;
import java.util.List;
import javax.annotation.concurrent.Immutable;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

@Immutable
/* compiled from: swipe-right */
public class AddCreditCardParams extends CreditCardProtocolParams {
    public static final Creator<AddCreditCardParams> CREATOR = new C02121();
    public static final String f1921a = AddCreditCardParams.class.getSimpleName();
    public final String f1922b;
    public final String f1923c;

    /* compiled from: swipe-right */
    final class C02121 implements Creator<AddCreditCardParams> {
        C02121() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new AddCreditCardParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new AddCreditCardParams[i];
        }
    }

    /* compiled from: swipe-right */
    public class Builder extends com.facebook.payments.paymentmethods.cardform.protocol.model.CreditCardProtocolParams.Builder<Builder> {
        public String f1913a;
        public String f1914b;
    }

    public AddCreditCardParams(Builder builder) {
        super((com.facebook.payments.paymentmethods.cardform.protocol.model.CreditCardProtocolParams.Builder) builder);
        this.f1922b = (String) Preconditions.checkNotNull(builder.f1913a);
        this.f1923c = builder.f1914b;
    }

    public AddCreditCardParams(Parcel parcel) {
        super(parcel);
        this.f1922b = parcel.readString();
        this.f1923c = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f1922b);
        parcel.writeString(this.f1923c);
    }

    public final List<NameValuePair> mo88a() {
        List<NameValuePair> a = super.mo88a();
        a.add(new BasicNameValuePair("creditCardNumber", this.f1922b));
        if (PaymentItemTypeUtil.m2242a(this.f1915d)) {
            Preconditions.checkNotNull(this.f1923c);
            Preconditions.checkArgument(!"0".equals(this.f1923c), "AccountId can NOT be 0 for Ads invoice");
            a.add(new BasicNameValuePair("account_id", this.f1923c));
        }
        return a;
    }
}
