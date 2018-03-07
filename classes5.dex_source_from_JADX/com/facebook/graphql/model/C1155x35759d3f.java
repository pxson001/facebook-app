package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.extras.FeedUnitExtra;

/* compiled from: WRAPPER_OBJECT */
public class C1155x35759d3f extends FeedUnitExtra {
    public static final Creator<C1155x35759d3f> CREATOR = new C11541();

    /* compiled from: WRAPPER_OBJECT */
    final class C11541 implements Creator<C1155x35759d3f> {
        C11541() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new C1155x35759d3f(parcel);
        }

        public final Object[] newArray(int i) {
            return new C1155x35759d3f[i];
        }
    }

    protected C1155x35759d3f(Parcel parcel) {
        super(parcel);
    }
}
