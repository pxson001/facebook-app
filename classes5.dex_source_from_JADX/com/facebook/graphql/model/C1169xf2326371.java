package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.extras.FeedUnitExtra;

/* compiled from: WIZARD_SEARCH */
public class C1169xf2326371 extends FeedUnitExtra {
    public static final Creator<C1169xf2326371> CREATOR = new C11681();

    /* compiled from: WIZARD_SEARCH */
    final class C11681 implements Creator<C1169xf2326371> {
        C11681() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new C1169xf2326371(parcel);
        }

        public final Object[] newArray(int i) {
            return new C1169xf2326371[i];
        }
    }

    protected C1169xf2326371(Parcel parcel) {
        super(parcel);
    }
}
