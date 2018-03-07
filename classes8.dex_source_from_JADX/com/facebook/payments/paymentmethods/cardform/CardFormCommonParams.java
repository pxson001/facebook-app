package com.facebook.payments.paymentmethods.cardform;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.payments.model.PaymentItemType;
import com.facebook.payments.paymentmethods.model.FbPaymentCard;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: tapped_result_position */
public final class CardFormCommonParams implements Parcelable, CardFormParams {
    public static final Creator<CardFormCommonParams> CREATOR = new C01861();
    public final CardFormStyle f1772a;
    public final CardFormAnalyticsParams f1773b;
    public final CardFormStyleParams f1774c;
    @Nullable
    public final FbPaymentCard f1775d;
    public final PaymentItemType f1776e;

    /* compiled from: tapped_result_position */
    final class C01861 implements Creator<CardFormCommonParams> {
        C01861() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new CardFormCommonParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new CardFormCommonParams[i];
        }
    }

    public static CardFormCommonParamsBuilder newBuilder() {
        return new CardFormCommonParamsBuilder();
    }

    public CardFormCommonParams(CardFormCommonParamsBuilder cardFormCommonParamsBuilder) {
        CardFormStyleParams e;
        this.f1772a = (CardFormStyle) Preconditions.checkNotNull(cardFormCommonParamsBuilder.f1777a);
        this.f1773b = (CardFormAnalyticsParams) Preconditions.checkNotNull(cardFormCommonParamsBuilder.f1778b);
        if (cardFormCommonParamsBuilder.f1779c == null) {
            e = CardFormStyleParams.newBuilder().m2033e();
        } else {
            e = cardFormCommonParamsBuilder.f1779c;
        }
        this.f1774c = e;
        this.f1775d = cardFormCommonParamsBuilder.f1780d;
        this.f1776e = (PaymentItemType) Preconditions.checkNotNull(cardFormCommonParamsBuilder.f1781e);
    }

    public CardFormCommonParams(Parcel parcel) {
        this.f1772a = (CardFormStyle) ParcelUtil.c(parcel, CardFormStyle.class);
        this.f1773b = (CardFormAnalyticsParams) parcel.readParcelable(CardFormAnalyticsParams.class.getClassLoader());
        this.f1774c = (CardFormStyleParams) parcel.readParcelable(CardFormStyleParams.class.getClassLoader());
        this.f1775d = (FbPaymentCard) parcel.readParcelable(FbPaymentCard.class.getClassLoader());
        this.f1776e = (PaymentItemType) ParcelUtil.c(parcel, PaymentItemType.class);
    }

    public final CardFormCommonParams mo78a() {
        return this;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        ParcelUtil.a(parcel, this.f1772a);
        parcel.writeParcelable(this.f1773b, i);
        parcel.writeParcelable(this.f1774c, i);
        parcel.writeParcelable(this.f1775d, i);
        ParcelUtil.a(parcel, this.f1776e);
    }
}
