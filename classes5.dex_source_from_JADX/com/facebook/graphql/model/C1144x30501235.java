package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.extras.FeedUnitExtra;

/* compiled from: WRITE_ON_TIMELINE */
public class C1144x30501235 extends FeedUnitExtra {
    public static final Creator<C1144x30501235> CREATOR = new C11431();

    /* compiled from: WRITE_ON_TIMELINE */
    final class C11431 implements Creator<C1144x30501235> {
        C11431() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new C1144x30501235(parcel);
        }

        public final Object[] newArray(int i) {
            return new C1144x30501235[i];
        }
    }

    protected C1144x30501235(Parcel parcel) {
        super(parcel);
    }
}
