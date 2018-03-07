package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.extras.FeedUnitExtra;

/* compiled from: frames_cta */
public class C0405x201e5ea5 extends FeedUnitExtra {
    public static final Creator<C0405x201e5ea5> CREATOR = new C04041();

    /* compiled from: frames_cta */
    final class C04041 implements Creator<C0405x201e5ea5> {
        C04041() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new C0405x201e5ea5(parcel);
        }

        public final Object[] newArray(int i) {
            return new C0405x201e5ea5[i];
        }
    }

    protected C0405x201e5ea5(Parcel parcel) {
        super(parcel);
    }
}
