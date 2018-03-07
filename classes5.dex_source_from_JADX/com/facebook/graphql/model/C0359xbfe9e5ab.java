package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.extras.FeedUnitExtra;

/* compiled from: getWifiScanTime */
public class C0359xbfe9e5ab extends FeedUnitExtra {
    public static final Creator<C0359xbfe9e5ab> CREATOR = new C03581();

    /* compiled from: getWifiScanTime */
    final class C03581 implements Creator<C0359xbfe9e5ab> {
        C03581() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new C0359xbfe9e5ab(parcel);
        }

        public final Object[] newArray(int i) {
            return new C0359xbfe9e5ab[i];
        }
    }

    protected C0359xbfe9e5ab(Parcel parcel) {
        super(parcel);
    }
}
