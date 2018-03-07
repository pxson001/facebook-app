package com.facebook.quickpromotion.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.BooleanFilter;

/* compiled from: reaction_forward_scroll */
final class QuickPromotionDefinition$BooleanFilter$1 implements Creator<BooleanFilter> {
    QuickPromotionDefinition$BooleanFilter$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new BooleanFilter(parcel);
    }

    public final Object[] newArray(int i) {
        return new BooleanFilter[i];
    }
}
