package com.facebook.payments.paymentmethods.model;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.infer.annotation.PrivacySource;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.common.base.Objects;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@JsonDeserialize(using = CreditCardDeserializer.class)
@Immutable
/* compiled from: suggestions_at_end_of_session */
public class CreditCard implements FbPaymentCard {
    public static final Creator<CreditCard> CREATOR = new C02181();
    @PrivacySource
    @JsonProperty("billing_address")
    private final BillingAddress mAddress;
    @PrivacySource
    @JsonProperty("card_holder_name")
    @Nullable
    private final String mCardHolderName;
    @PrivacySource
    @JsonProperty("expiry_month")
    private final String mExpiryMonth;
    @PrivacySource
    @JsonProperty("expiry_year")
    private final String mExpiryYear;
    @PrivacySource
    @JsonProperty("card_type")
    private final FbPaymentCardType mFbPaymentCardType;
    @PrivacySource
    @JsonProperty("first6")
    private final String mFirstSix;
    @PrivacySource
    @JsonProperty("id")
    private final String mId;
    @JsonProperty("is_enabled")
    private final boolean mIsEnabled;
    @JsonProperty("is_cvv_tricky_bin")
    private final Boolean mIsTrickyBin;
    @PrivacySource
    @JsonProperty("last4")
    private final String mLastFour;
    @PrivacySource
    @JsonProperty("readable_card_type")
    private final String mReadableCardType;

    /* compiled from: suggestions_at_end_of_session */
    final class C02181 implements Creator<CreditCard> {
        C02181() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new CreditCard(parcel);
        }

        public final Object[] newArray(int i) {
            return new CreditCard[i];
        }
    }

    public CreditCard() {
        this.mId = null;
        this.mExpiryMonth = null;
        this.mExpiryYear = null;
        this.mLastFour = null;
        this.mFirstSix = null;
        this.mFbPaymentCardType = null;
        this.mReadableCardType = null;
        this.mCardHolderName = null;
        this.mIsEnabled = false;
        this.mIsTrickyBin = null;
        this.mAddress = null;
    }

    public CreditCard(String str, String str2, String str3, String str4, String str5, FbPaymentCardType fbPaymentCardType, String str6, @Nullable String str7, boolean z, Boolean bool, BillingAddress billingAddress) {
        this.mId = str;
        this.mExpiryMonth = str2;
        this.mExpiryYear = str3;
        this.mLastFour = str4;
        this.mFirstSix = str5;
        this.mFbPaymentCardType = fbPaymentCardType;
        this.mReadableCardType = str6;
        this.mCardHolderName = str7;
        this.mIsEnabled = z;
        this.mIsTrickyBin = bool;
        this.mAddress = billingAddress;
    }

    public CreditCard(String str, int i, int i2, String str2, String str3, FbPaymentCardType fbPaymentCardType, boolean z, boolean z2, BillingAddress billingAddress) {
        this(str, String.valueOf(i), String.valueOf(i2), str2, str3, fbPaymentCardType, fbPaymentCardType.getHumanReadableName(), null, z, Boolean.valueOf(z2), billingAddress);
    }

    protected CreditCard(CreditCard creditCard) {
        this(creditCard.mo94a(), creditCard.mo96c(), creditCard.mo97d(), creditCard.mo98e(), creditCard.m2155l(), creditCard.mo99f(), creditCard.m2166g(), creditCard.m2156m(), creditCard.m2157n(), creditCard.m2167h(), creditCard.m2158o());
    }

    public final String mo94a() {
        return this.mId;
    }

    public final PaymentMethodType mo95b() {
        return PaymentMethodType.CREDIT_CARD;
    }

    public final Drawable m2159a(Resources resources) {
        return mo99f().getRectangularDrawable(resources);
    }

    public final String mo96c() {
        return m2154a(this.mExpiryMonth);
    }

    public final String mo97d() {
        return this.mExpiryYear;
    }

    public final String mo98e() {
        return this.mLastFour;
    }

    @Deprecated
    private String m2155l() {
        return this.mFirstSix;
    }

    public final FbPaymentCardType mo99f() {
        return this.mFbPaymentCardType;
    }

    public final String m2166g() {
        return this.mReadableCardType;
    }

    private String m2156m() {
        return this.mCardHolderName;
    }

    private boolean m2157n() {
        return this.mIsEnabled;
    }

    public final Boolean m2167h() {
        return this.mIsTrickyBin;
    }

    private BillingAddress m2158o() {
        return this.mAddress;
    }

    public final String mo100i() {
        return this.mAddress.f1942a;
    }

    public final boolean mo101j() {
        return FbPaymentCardUtil.m2174a(this);
    }

    public static String m2154a(String str) {
        if (str.length() < 2) {
            return "0" + str;
        }
        return str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CreditCard creditCard = (CreditCard) obj;
        if (Objects.equal(Boolean.valueOf(this.mIsEnabled), Boolean.valueOf(creditCard.mIsEnabled)) && Objects.equal(this.mIsTrickyBin, creditCard.mIsTrickyBin) && Objects.equal(this.mId, creditCard.mId) && Objects.equal(this.mExpiryMonth, creditCard.mExpiryMonth) && Objects.equal(this.mExpiryYear, creditCard.mExpiryYear) && Objects.equal(this.mLastFour, creditCard.mLastFour) && Objects.equal(this.mFirstSix, creditCard.mFirstSix) && Objects.equal(this.mFbPaymentCardType, creditCard.mFbPaymentCardType) && Objects.equal(this.mReadableCardType, creditCard.mReadableCardType) && Objects.equal(this.mCardHolderName, creditCard.mCardHolderName) && Objects.equal(this.mAddress, creditCard.mAddress)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.mId, this.mExpiryMonth, this.mExpiryYear, this.mLastFour, this.mFirstSix, this.mFbPaymentCardType, this.mReadableCardType, this.mCardHolderName, Boolean.valueOf(this.mIsEnabled), this.mIsTrickyBin, this.mAddress});
    }

    public String toString() {
        return m2170k().toString();
    }

    protected final ToStringHelper m2170k() {
        return MoreObjects.toStringHelper(getClass()).add("id", mo94a()).add("expiryMonth", mo96c()).add("expiryYear", mo97d()).add("lastFour", mo98e()).add("firstSix", m2155l()).add("cardType", mo99f()).add("readableCardType", m2166g()).add("cardHolderName", m2156m()).add("isEnabled", m2157n()).add("isTrickyBin", m2167h()).add("address", m2158o());
    }

    protected CreditCard(Parcel parcel) {
        this.mId = parcel.readString();
        this.mExpiryMonth = parcel.readString();
        this.mExpiryYear = parcel.readString();
        this.mLastFour = parcel.readString();
        this.mFirstSix = parcel.readString();
        this.mFbPaymentCardType = (FbPaymentCardType) ParcelUtil.c(parcel, FbPaymentCardType.class);
        this.mReadableCardType = parcel.readString();
        this.mCardHolderName = parcel.readString();
        this.mIsEnabled = ParcelUtil.a(parcel);
        this.mIsTrickyBin = ParcelUtil.f(parcel);
        this.mAddress = (BillingAddress) parcel.readParcelable(BillingAddress.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mo94a());
        parcel.writeString(this.mExpiryMonth);
        parcel.writeString(this.mExpiryYear);
        parcel.writeString(this.mLastFour);
        parcel.writeString(this.mFirstSix);
        ParcelUtil.a(parcel, this.mFbPaymentCardType);
        parcel.writeString(this.mReadableCardType);
        parcel.writeString(this.mCardHolderName);
        ParcelUtil.a(parcel, this.mIsEnabled);
        ParcelUtil.a(parcel, this.mIsTrickyBin);
        parcel.writeParcelable(this.mAddress, i);
    }

    public int describeContents() {
        return 0;
    }
}
