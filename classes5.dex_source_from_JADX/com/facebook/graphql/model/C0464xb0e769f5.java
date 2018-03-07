package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.extras.FeedUnitExtra;

/* compiled from: emailSignInOptions */
public class C0464xb0e769f5 extends FeedUnitExtra {
    public static final Creator<C0464xb0e769f5> CREATOR = new C04631();

    /* compiled from: emailSignInOptions */
    final class C04631 implements Creator<C0464xb0e769f5> {
        C04631() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new C0464xb0e769f5(parcel);
        }

        public final Object[] newArray(int i) {
            return new C0464xb0e769f5[i];
        }
    }

    protected C0464xb0e769f5(Parcel parcel) {
        super(parcel);
    }
}
