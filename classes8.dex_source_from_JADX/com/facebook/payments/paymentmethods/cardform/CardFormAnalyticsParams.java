package com.facebook.payments.paymentmethods.cardform;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.util.StringUtil;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: targetSelectorClient was garbage collected */
public final class CardFormAnalyticsParams implements Parcelable {
    public static final Creator<CardFormAnalyticsParams> CREATOR = new C01851();
    @Nullable
    public final String f1768a;
    public final String f1769b;

    /* compiled from: targetSelectorClient was garbage collected */
    final class C01851 implements Creator<CardFormAnalyticsParams> {
        C01851() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new CardFormAnalyticsParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new CardFormAnalyticsParams[i];
        }
    }

    public static CardFormAnalyticsParamsBuilder newBuilder() {
        return new CardFormAnalyticsParamsBuilder();
    }

    public CardFormAnalyticsParams(CardFormAnalyticsParamsBuilder cardFormAnalyticsParamsBuilder) {
        boolean z;
        if (StringUtil.c(cardFormAnalyticsParamsBuilder.f1771b)) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z);
        this.f1768a = cardFormAnalyticsParamsBuilder.f1770a;
        this.f1769b = cardFormAnalyticsParamsBuilder.f1771b;
    }

    public CardFormAnalyticsParams(Parcel parcel) {
        this.f1768a = parcel.readString();
        this.f1769b = parcel.readString();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f1768a);
        parcel.writeString(this.f1769b);
    }
}
