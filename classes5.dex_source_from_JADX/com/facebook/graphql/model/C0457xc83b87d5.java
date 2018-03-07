package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.extras.FeedUnitExtra;

/* compiled from: error_for_logging */
public class C0457xc83b87d5 extends FeedUnitExtra {
    public static final Creator<C0457xc83b87d5> CREATOR = new C04561();

    /* compiled from: error_for_logging */
    final class C04561 implements Creator<C0457xc83b87d5> {
        C04561() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new C0457xc83b87d5(parcel);
        }

        public final Object[] newArray(int i) {
            return new C0457xc83b87d5[i];
        }
    }

    protected C0457xc83b87d5(Parcel parcel) {
        super(parcel);
    }
}
