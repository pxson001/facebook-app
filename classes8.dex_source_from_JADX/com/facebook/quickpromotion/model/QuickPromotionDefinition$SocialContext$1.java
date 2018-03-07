package com.facebook.quickpromotion.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.SocialContext;

/* compiled from: reaction_forward_scroll */
final class QuickPromotionDefinition$SocialContext$1 implements Creator<SocialContext> {
    QuickPromotionDefinition$SocialContext$1() {
    }

    public final Object createFromParcel(Parcel parcel) {
        return new SocialContext(parcel);
    }

    public final Object[] newArray(int i) {
        return new SocialContext[i];
    }
}
