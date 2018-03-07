package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.extras.FeedUnitExtra;

/* compiled from: fullLatestVersion */
public class C0384xb882ae5 extends FeedUnitExtra {
    public static final Creator<C0384xb882ae5> CREATOR = new C03831();

    /* compiled from: fullLatestVersion */
    final class C03831 implements Creator<C0384xb882ae5> {
        C03831() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new C0384xb882ae5(parcel);
        }

        public final Object[] newArray(int i) {
            return new C0384xb882ae5[i];
        }
    }

    protected C0384xb882ae5(Parcel parcel) {
        super(parcel);
    }
}
