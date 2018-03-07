package com.facebook.messaging.payment.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.payments.paymentmethods.model.CreditCard;
import com.facebook.payments.paymentmethods.model.FbPaymentCard;
import com.facebook.payments.paymentmethods.model.FbPaymentCardType;
import com.facebook.payments.paymentmethods.model.FbPaymentCardUtil;
import com.facebook.payments.paymentmethods.model.PaymentMethodType;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: idToken */
public class PaymentCard implements FbPaymentCard {
    public static final Creator<PaymentCard> CREATOR = new C14841();
    public final long f13202a;
    private final String f13203b;
    public final int f13204c;
    public final int f13205d;
    public final Address f13206e;
    public final String f13207f;
    public final boolean f13208g;
    private final boolean f13209h;
    public final boolean f13210i;
    private final PaymentCardCategory f13211j;
    private final boolean f13212k;
    private final boolean f13213l;
    private final boolean f13214m;

    /* compiled from: idToken */
    final class C14841 implements Creator<PaymentCard> {
        C14841() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PaymentCard(parcel);
        }

        public final Object[] newArray(int i) {
            return new PaymentCard[i];
        }
    }

    public PaymentCard(PaymentCardBuilder paymentCardBuilder) {
        boolean z;
        PaymentCardCategory paymentCardCategory;
        if (paymentCardBuilder.f13215a > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        this.f13202a = paymentCardBuilder.f13215a;
        this.f13203b = paymentCardBuilder.f13216b;
        this.f13204c = paymentCardBuilder.f13217c;
        this.f13205d = paymentCardBuilder.f13218d;
        this.f13206e = paymentCardBuilder.f13219e;
        this.f13207f = paymentCardBuilder.f13220f;
        this.f13208g = paymentCardBuilder.f13221g;
        this.f13209h = paymentCardBuilder.f13222h;
        this.f13210i = paymentCardBuilder.f13223i;
        if (paymentCardBuilder.f13224j != null) {
            paymentCardCategory = paymentCardBuilder.f13224j;
        } else {
            paymentCardCategory = PaymentCardCategory.UNKNOWN;
        }
        this.f13211j = paymentCardCategory;
        this.f13212k = paymentCardBuilder.f13225k;
        this.f13213l = paymentCardBuilder.f13226l;
        this.f13214m = paymentCardBuilder.f13227m;
    }

    public static PaymentCardBuilder newBuilder() {
        return new PaymentCardBuilder();
    }

    public PaymentCard(Parcel parcel) {
        this.f13202a = parcel.readLong();
        this.f13203b = parcel.readString();
        this.f13204c = parcel.readInt();
        this.f13205d = parcel.readInt();
        this.f13206e = (Address) parcel.readParcelable(Address.class.getClassLoader());
        this.f13207f = parcel.readString();
        this.f13208g = ParcelUtil.a(parcel);
        this.f13209h = ParcelUtil.a(parcel);
        this.f13210i = ParcelUtil.a(parcel);
        this.f13211j = (PaymentCardCategory) parcel.readSerializable();
        this.f13212k = ParcelUtil.a(parcel);
        this.f13213l = ParcelUtil.a(parcel);
        this.f13214m = ParcelUtil.a(parcel);
    }

    public PaymentCard(P2pCreditCardWrapper p2pCreditCardWrapper) {
        Preconditions.checkNotNull(p2pCreditCardWrapper);
        P2pCreditCard b = p2pCreditCardWrapper.m13489b();
        this.f13202a = b.m13480b();
        this.f13203b = b.m13481c();
        this.f13204c = b.m13482d();
        this.f13205d = b.m13483e();
        this.f13206e = b.m13484f();
        this.f13207f = b.m13485g();
        this.f13208g = p2pCreditCardWrapper.m13490c();
        this.f13209h = p2pCreditCardWrapper.m13491d();
        this.f13210i = p2pCreditCardWrapper.m13492e();
        this.f13211j = PaymentCardCategory.fromString(p2pCreditCardWrapper.m13493f());
        this.f13212k = p2pCreditCardWrapper.m13494g();
        this.f13213l = p2pCreditCardWrapper.m13495h();
        this.f13214m = p2pCreditCardWrapper.m13496i();
    }

    public final String m13499a() {
        return String.valueOf(this.f13202a);
    }

    public final long m13511m() {
        return this.f13202a;
    }

    public final PaymentMethodType m13500b() {
        return PaymentMethodType.CREDIT_CARD;
    }

    public final String m13503e() {
        return this.f13203b;
    }

    public final boolean m13508j() {
        return FbPaymentCardUtil.a(this);
    }

    public final String m13501c() {
        return CreditCard.a(String.valueOf(this.f13204c));
    }

    public final String m13502d() {
        return String.valueOf(this.f13205d);
    }

    public final String m13507i() {
        return this.f13206e.m13462a();
    }

    public final FbPaymentCardType m13504f() {
        return FbPaymentCardType.forValue(this.f13207f);
    }

    public final String m13512q() {
        return this.f13207f;
    }

    public PaymentCardCategory mo522g() {
        return this.f13211j;
    }

    public boolean mo523h() {
        return this.f13212k;
    }

    public boolean mo524k() {
        return this.f13213l;
    }

    public boolean mo525l() {
        return this.f13214m;
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("credential_id", this.f13202a).add("number", this.f13203b).add("expire_month", this.f13204c).add("expire_year", this.f13205d).add("address", this.f13206e.toString()).add("association", this.f13207f).add("mobile_csc_verified", this.f13208g).add("web_csc_verified", this.f13209h).add("zip_verified", this.f13210i).add("method_category", this.f13211j).add("commerce_payment_eligible", this.f13212k).add("personal_transfer_eligible", this.f13213l).add("is_default_receiving", this.f13214m).toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f13202a);
        parcel.writeString(this.f13203b);
        parcel.writeInt(this.f13204c);
        parcel.writeInt(this.f13205d);
        parcel.writeParcelable(this.f13206e, i);
        parcel.writeString(this.f13207f);
        ParcelUtil.a(parcel, this.f13208g);
        ParcelUtil.a(parcel, this.f13209h);
        ParcelUtil.a(parcel, this.f13210i);
        parcel.writeSerializable(this.f13211j);
        ParcelUtil.a(parcel, this.f13212k);
        ParcelUtil.a(parcel, this.f13213l);
        ParcelUtil.a(parcel, this.f13214m);
    }

    public final boolean m13513t() {
        return this.f13208g || this.f13209h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PaymentCard paymentCard = (PaymentCard) obj;
        if (this.f13202a != paymentCard.f13202a) {
            return false;
        }
        if (!this.f13203b.equals(paymentCard.f13203b)) {
            return false;
        }
        if (this.f13204c != paymentCard.f13204c) {
            return false;
        }
        if (this.f13205d != paymentCard.f13205d) {
            return false;
        }
        if (!this.f13206e.equals(paymentCard.f13206e)) {
            return false;
        }
        if (!this.f13207f.equals(paymentCard.f13207f)) {
            return false;
        }
        if (this.f13208g != paymentCard.f13208g) {
            return false;
        }
        if (this.f13209h != paymentCard.f13209h) {
            return false;
        }
        if (this.f13210i != paymentCard.f13210i) {
            return false;
        }
        if (!this.f13211j.equals(paymentCard.f13211j)) {
            return false;
        }
        if (this.f13212k != paymentCard.mo523h()) {
            return false;
        }
        if (this.f13213l != paymentCard.mo524k()) {
            return false;
        }
        if (this.f13214m != paymentCard.mo525l()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{Long.valueOf(this.f13202a), this.f13203b, Integer.valueOf(this.f13204c), Integer.valueOf(this.f13205d), this.f13206e, this.f13207f, Boolean.valueOf(this.f13208g), Boolean.valueOf(this.f13209h), Boolean.valueOf(this.f13210i), this.f13211j, Boolean.valueOf(this.f13212k), Boolean.valueOf(this.f13213l), Boolean.valueOf(this.f13214m)});
    }
}
