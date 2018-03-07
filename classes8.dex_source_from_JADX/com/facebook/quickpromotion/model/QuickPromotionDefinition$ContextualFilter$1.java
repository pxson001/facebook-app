package com.facebook.quickpromotion.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ContextualFilter;

/* compiled from: reaction_forward_scroll */
final class QuickPromotionDefinition$ContextualFilter$1 implements Creator<ContextualFilter> {
    QuickPromotionDefinition$ContextualFilter$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new ContextualFilter(parcel);
    }

    public final Object[] newArray(int i) {
        return new ContextualFilter[i];
    }
}
