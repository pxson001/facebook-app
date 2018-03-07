package com.facebook.adspayments.protocol;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.util.Quartet;
import com.facebook.payments.model.CurrencyAmount;

/* compiled from: USE_SERP_ENDPOINT */
public class CvvPrepayData extends Quartet<Boolean, CurrencyAmount, CurrencyAmount, CurrencyAmount> {
    public static final Creator<CvvPrepayData> CREATOR = new C28611();

    /* compiled from: USE_SERP_ENDPOINT */
    final class C28611 implements Creator<CvvPrepayData> {
        C28611() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new CvvPrepayData(parcel);
        }

        public final Object[] newArray(int i) {
            return new CvvPrepayData[i];
        }
    }

    public CvvPrepayData(boolean z, CurrencyAmount currencyAmount, CurrencyAmount currencyAmount2, CurrencyAmount currencyAmount3) {
        super(Boolean.valueOf(z), currencyAmount, currencyAmount2, currencyAmount3);
    }

    public CvvPrepayData(Parcel parcel) {
        super(parcel);
    }
}
