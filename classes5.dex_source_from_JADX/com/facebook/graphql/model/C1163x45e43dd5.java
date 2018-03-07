package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.extras.FeedUnitExtra;

/* compiled from: WORK_MANAGER_GROUP */
public class C1163x45e43dd5 extends FeedUnitExtra {
    public static final Creator<C1163x45e43dd5> CREATOR = new C11621();

    /* compiled from: WORK_MANAGER_GROUP */
    final class C11621 implements Creator<C1163x45e43dd5> {
        C11621() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new C1163x45e43dd5(parcel);
        }

        public final Object[] newArray(int i) {
            return new C1163x45e43dd5[i];
        }
    }

    protected C1163x45e43dd5(Parcel parcel) {
        super(parcel);
    }
}
