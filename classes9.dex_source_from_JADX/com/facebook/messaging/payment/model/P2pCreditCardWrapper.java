package com.facebook.messaging.payment.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.Postprocessable;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.common.util.StringUtil;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@JsonDeserialize(using = P2pCreditCardWrapperDeserializer.class)
@Immutable
/* compiled from: idpToken */
public class P2pCreditCardWrapper implements Parcelable, Postprocessable<P2pCreditCardWrapper> {
    public static final Creator<P2pCreditCardWrapper> CREATOR = new C14821();
    @JsonProperty("commerce_payment_eligible")
    private final boolean mCommercePaymentEligible;
    @JsonProperty("id")
    private final String mId;
    @JsonProperty("is_default_receiving")
    private final boolean mIsDefaultReceiving;
    @JsonProperty("mobile_csc_verified")
    private final boolean mIsMobileCSCVerified;
    @JsonProperty("web_csc_verified")
    private final boolean mIsWebCSCVerified;
    @JsonProperty("zip_verified")
    private final boolean mIsZipVerified;
    @JsonProperty("method_category")
    private final String mMethodCategory;
    @JsonProperty("credit_card")
    private final P2pCreditCard mP2pCreditCard;
    @JsonProperty("personal_transfer_eligible")
    private final boolean mPersonalTransferEligible;

    /* compiled from: idpToken */
    final class C14821 implements Creator<P2pCreditCardWrapper> {
        C14821() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new P2pCreditCardWrapper(parcel);
        }

        public final Object[] newArray(int i) {
            return new P2pCreditCardWrapper[i];
        }
    }

    public P2pCreditCardWrapper(Parcel parcel) {
        this.mId = parcel.readString();
        this.mP2pCreditCard = (P2pCreditCard) parcel.readParcelable(P2pCreditCard.class.getClassLoader());
        this.mIsMobileCSCVerified = ParcelUtil.a(parcel);
        this.mIsWebCSCVerified = ParcelUtil.a(parcel);
        this.mIsZipVerified = ParcelUtil.a(parcel);
        this.mMethodCategory = parcel.readString();
        this.mCommercePaymentEligible = ParcelUtil.a(parcel);
        this.mPersonalTransferEligible = ParcelUtil.a(parcel);
        this.mIsDefaultReceiving = ParcelUtil.a(parcel);
    }

    private P2pCreditCardWrapper() {
        this.mId = null;
        this.mP2pCreditCard = null;
        this.mIsMobileCSCVerified = false;
        this.mIsWebCSCVerified = false;
        this.mIsZipVerified = false;
        this.mMethodCategory = null;
        this.mCommercePaymentEligible = false;
        this.mPersonalTransferEligible = false;
        this.mIsDefaultReceiving = false;
    }

    public final P2pCreditCard m13489b() {
        return this.mP2pCreditCard;
    }

    public final boolean m13490c() {
        return this.mIsMobileCSCVerified;
    }

    public final boolean m13491d() {
        return this.mIsWebCSCVerified;
    }

    public final boolean m13492e() {
        return this.mIsZipVerified;
    }

    public final String m13493f() {
        return this.mMethodCategory;
    }

    public final boolean m13494g() {
        return this.mCommercePaymentEligible;
    }

    public final boolean m13495h() {
        return this.mPersonalTransferEligible;
    }

    public final boolean m13496i() {
        return this.mIsDefaultReceiving;
    }

    public String toString() {
        return Objects.toStringHelper(this).add("id", this.mId).add("credit_card", this.mP2pCreditCard).add("mobile_csc_verified", this.mIsMobileCSCVerified).add("web_csc_verified", this.mIsWebCSCVerified).add("zip_verified", this.mIsZipVerified).add("method_category", this.mMethodCategory).add("commerce_payment_eligible", this.mCommercePaymentEligible).add("personal_transfer_eligible", this.mPersonalTransferEligible).add("is_default_receiving", this.mIsDefaultReceiving).toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mId);
        parcel.writeParcelable(this.mP2pCreditCard, i);
        ParcelUtil.a(parcel, this.mIsMobileCSCVerified);
        ParcelUtil.a(parcel, this.mIsWebCSCVerified);
        ParcelUtil.a(parcel, this.mIsZipVerified);
        parcel.writeString(this.mMethodCategory);
        ParcelUtil.a(parcel, this.mCommercePaymentEligible);
        ParcelUtil.a(parcel, this.mPersonalTransferEligible);
        ParcelUtil.a(parcel, this.mIsDefaultReceiving);
    }

    public final Object m13488a() {
        Preconditions.checkArgument(!StringUtil.a(this.mId));
        Preconditions.checkNotNull(this.mP2pCreditCard);
        return this;
    }
}
