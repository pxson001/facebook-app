package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.extras.FeedUnitExtra;

/* compiled from: filtered_claim_count */
public class C0418x718cae15 extends FeedUnitExtra {
    public static final Creator<C0418x718cae15> CREATOR = new C04171();

    /* compiled from: filtered_claim_count */
    final class C04171 implements Creator<C0418x718cae15> {
        C04171() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new C0418x718cae15(parcel);
        }

        public final Object[] newArray(int i) {
            return new C0418x718cae15[i];
        }
    }

    protected C0418x718cae15(Parcel parcel) {
        super(parcel);
    }
}
