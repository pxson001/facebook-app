package com.facebook.quickpromotion.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.Action;

/* compiled from: reaction_forward_scroll */
final class QuickPromotionDefinition$Action$1 implements Creator<Action> {
    QuickPromotionDefinition$Action$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new Action(parcel);
    }

    public final Object[] newArray(int i) {
        return new Action[i];
    }
}
