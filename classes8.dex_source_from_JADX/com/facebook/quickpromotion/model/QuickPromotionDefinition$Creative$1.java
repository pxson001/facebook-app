package com.facebook.quickpromotion.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.Creative;

/* compiled from: reaction_forward_scroll */
final class QuickPromotionDefinition$Creative$1 implements Creator<Creative> {
    QuickPromotionDefinition$Creative$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new Creative(parcel);
    }

    public final Object[] newArray(int i) {
        return new Creative[i];
    }
}
