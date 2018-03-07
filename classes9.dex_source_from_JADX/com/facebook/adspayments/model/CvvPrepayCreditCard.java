package com.facebook.adspayments.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.payments.model.CurrencyAmount;
import com.facebook.payments.paymentmethods.model.CreditCard;
import com.google.common.base.Preconditions;
import com.google.common.collect.Range;
import javax.annotation.Nullable;

/* compiled from: UT */
public class CvvPrepayCreditCard extends CreditCard {
    public static final Creator<CvvPrepayCreditCard> CREATOR = new C28581();
    public final String f23681a;
    @Nullable
    public final Range<CurrencyAmount> f23682b;
    @Nullable
    public final CurrencyAmount f23683c;

    /* compiled from: UT */
    final class C28581 implements Creator<CvvPrepayCreditCard> {
        C28581() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new CvvPrepayCreditCard(parcel);
        }

        public final Object[] newArray(int i) {
            return new CvvPrepayCreditCard[i];
        }
    }

    public CvvPrepayCreditCard(CreditCard creditCard, String str) {
        this(creditCard, str, null, null, null);
    }

    public CvvPrepayCreditCard(CreditCard creditCard, String str, CurrencyAmount currencyAmount, CurrencyAmount currencyAmount2, CurrencyAmount currencyAmount3) {
        super(creditCard);
        this.f23681a = (String) Preconditions.checkNotNull(str);
        this.f23683c = currencyAmount3;
        this.f23682b = m25698a(currencyAmount, currencyAmount2);
    }

    @Nullable
    private static Range<CurrencyAmount> m25698a(@Nullable CurrencyAmount currencyAmount, @Nullable CurrencyAmount currencyAmount2) {
        return (currencyAmount == null || currencyAmount2 == null) ? null : Range.a(currencyAmount, currencyAmount2);
    }

    public CvvPrepayCreditCard(Parcel parcel) {
        super(parcel);
        this.f23681a = parcel.readString();
        this.f23682b = m25698a(m25697a(parcel), m25697a(parcel));
        this.f23683c = m25697a(parcel);
    }

    private static CurrencyAmount m25697a(Parcel parcel) {
        return (CurrencyAmount) ParcelUtil.b(parcel, CurrencyAmount.class);
    }

    public String toString() {
        return super.k().add("cvvToken", this.f23681a).add("validChargeRange", this.f23682b).add("defaultFundingAmount", this.f23683c).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        CurrencyAmount currencyAmount;
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f23681a);
        if (this.f23682b != null) {
            currencyAmount = (CurrencyAmount) this.f23682b.d();
        } else {
            currencyAmount = null;
        }
        parcel.writeParcelable(currencyAmount, i);
        if (this.f23682b != null) {
            currencyAmount = (CurrencyAmount) this.f23682b.g();
        } else {
            currencyAmount = null;
        }
        parcel.writeParcelable(currencyAmount, i);
        parcel.writeParcelable(this.f23683c, i);
    }
}
