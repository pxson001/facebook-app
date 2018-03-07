package com.facebook.quickpromotion.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ImageParameters;

/* compiled from: reaction_forward_scroll */
final class QuickPromotionDefinition$ImageParameters$1 implements Creator<ImageParameters> {
    QuickPromotionDefinition$ImageParameters$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new ImageParameters(parcel);
    }

    public final Object[] newArray(int i) {
        return new ImageParameters[i];
    }
}
