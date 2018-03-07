package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.extras.FeedUnitExtra;

/* compiled from: fqlMultiQueryMethod */
public class C0408xbaf02c49 extends FeedUnitExtra {
    public static final Creator<C0408xbaf02c49> CREATOR = new C04071();

    /* compiled from: fqlMultiQueryMethod */
    final class C04071 implements Creator<C0408xbaf02c49> {
        C04071() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new C0408xbaf02c49(parcel);
        }

        public final Object[] newArray(int i) {
            return new C0408xbaf02c49[i];
        }
    }

    protected C0408xbaf02c49(Parcel parcel) {
        super(parcel);
    }
}
