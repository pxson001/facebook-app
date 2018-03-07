package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.extras.FeedUnitExtra;

/* compiled from: Unable to retrieve Data power stats */
public class C1239xa5c44575 extends FeedUnitExtra {
    public static final Creator<C1239xa5c44575> CREATOR = new C12381();

    /* compiled from: Unable to retrieve Data power stats */
    final class C12381 implements Creator<C1239xa5c44575> {
        C12381() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new C1239xa5c44575(parcel);
        }

        public final Object[] newArray(int i) {
            return new C1239xa5c44575[i];
        }
    }

    protected C1239xa5c44575(Parcel parcel) {
        super(parcel);
    }
}
