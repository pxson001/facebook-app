package com.facebook.messaging.payment.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.Postprocessable;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentCurrencyQuantityModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentCurrencyQuantityModel.Builder;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.Objects;
import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@JsonDeserialize(using = AmountDeserializer.class)
@Immutable
/* compiled from: imageCount */
public class Amount implements Parcelable, Postprocessable<Amount> {
    public static final Creator<Amount> CREATOR = new C14791();
    static final Amount f13194a = new Amount("USD", 0, 0);
    static final Amount f13195b = new Amount("USD", 0, 0);
    @JsonProperty("amount_with_offset")
    private final int mAmountWithOffset;
    @JsonProperty("currency")
    private String mCurrency;
    @JsonProperty("offset")
    private final int mOffset;

    /* compiled from: imageCount */
    final class C14791 implements Creator<Amount> {
        C14791() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new Amount(parcel);
        }

        public final Object[] newArray(int i) {
            return new Amount[i];
        }
    }

    public final /* synthetic */ Object m13466a() {
        return m13465f();
    }

    public Amount(String str, int i, int i2) {
        this.mCurrency = str;
        this.mOffset = i;
        this.mAmountWithOffset = i2;
        m13465f();
    }

    @Nonnull
    public final String m13467b() {
        return this.mCurrency;
    }

    public final int m13468c() {
        return this.mOffset;
    }

    public final int m13469d() {
        return this.mAmountWithOffset;
    }

    protected Amount(Parcel parcel) {
        this.mCurrency = parcel.readString();
        this.mOffset = parcel.readInt();
        this.mAmountWithOffset = parcel.readInt();
        m13465f();
    }

    private Amount() {
        this.mCurrency = null;
        this.mOffset = -1;
        this.mAmountWithOffset = -1;
    }

    public String toString() {
        return Objects.toStringHelper(this).add("currency", this.mCurrency).add("offset", this.mOffset).add("amount_with_offset", this.mAmountWithOffset).toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mCurrency);
        parcel.writeInt(this.mOffset);
        parcel.writeInt(this.mAmountWithOffset);
    }

    private Amount m13465f() {
        this.mCurrency = this.mCurrency != null ? this.mCurrency : "USD";
        return this;
    }

    public final PaymentCurrencyQuantityModel m13470e() {
        Builder builder = new Builder();
        builder.f13310a = this.mAmountWithOffset;
        builder = builder;
        builder.f13311b = this.mCurrency;
        builder = builder;
        builder.f13312c = this.mOffset;
        return builder.m13698a();
    }
}
