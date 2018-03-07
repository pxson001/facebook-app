package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.extras.FeedUnitExtra;

/* compiled from: getRecentLogFiles */
public class C0368x7c7dd35 extends FeedUnitExtra {
    public static final Creator<C0368x7c7dd35> CREATOR = new C03671();

    /* compiled from: getRecentLogFiles */
    final class C03671 implements Creator<C0368x7c7dd35> {
        C03671() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new C0368x7c7dd35(parcel);
        }

        public final Object[] newArray(int i) {
            return new C0368x7c7dd35[i];
        }
    }

    protected C0368x7c7dd35(Parcel parcel) {
        super(parcel);
    }
}
