package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.extras.FeedUnitExtra;

/* compiled from: VIEW_PAGE_ADMIN_POST */
public class C1197xb0e1e3d5 extends FeedUnitExtra {
    public static final Creator<C1197xb0e1e3d5> CREATOR = new C11961();

    /* compiled from: VIEW_PAGE_ADMIN_POST */
    final class C11961 implements Creator<C1197xb0e1e3d5> {
        C11961() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new C1197xb0e1e3d5(parcel);
        }

        public final Object[] newArray(int i) {
            return new C1197xb0e1e3d5[i];
        }
    }

    protected C1197xb0e1e3d5(Parcel parcel) {
        super(parcel);
    }
}
