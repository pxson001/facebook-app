package com.facebook.quickpromotion.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: reaction_forward_scroll */
final class QuickPromotionDefinition$1 implements Creator<QuickPromotionDefinition> {
    QuickPromotionDefinition$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new QuickPromotionDefinition(parcel);
    }

    public final Object[] newArray(int i) {
        return new QuickPromotionDefinition[i];
    }
}
