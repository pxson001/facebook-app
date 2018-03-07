package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.extras.FeedUnitExtra;

/* compiled from: is-forced-subtitle */
public class C0291xdf2b2075 extends FeedUnitExtra {
    public static final Creator<C0291xdf2b2075> CREATOR = new C02901();

    /* compiled from: is-forced-subtitle */
    final class C02901 implements Creator<C0291xdf2b2075> {
        C02901() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new C0291xdf2b2075(parcel);
        }

        public final Object[] newArray(int i) {
            return new C0291xdf2b2075[i];
        }
    }

    protected C0291xdf2b2075(Parcel parcel) {
        super(parcel);
    }
}
