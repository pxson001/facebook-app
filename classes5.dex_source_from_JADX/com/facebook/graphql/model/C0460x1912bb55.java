package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.extras.FeedUnitExtra;

/* compiled from: enable_ad_network_bridging */
public class C0460x1912bb55 extends FeedUnitExtra {
    public static final Creator<C0460x1912bb55> CREATOR = new C04591();

    /* compiled from: enable_ad_network_bridging */
    final class C04591 implements Creator<C0460x1912bb55> {
        C04591() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new C0460x1912bb55(parcel);
        }

        public final Object[] newArray(int i) {
            return new C0460x1912bb55[i];
        }
    }

    protected C0460x1912bb55(Parcel parcel) {
        super(parcel);
    }
}
