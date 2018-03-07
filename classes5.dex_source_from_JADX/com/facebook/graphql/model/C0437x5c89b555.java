package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.extras.FeedUnitExtra;

/* compiled from: faceweb */
public class C0437x5c89b555 extends FeedUnitExtra {
    public static final Creator<C0437x5c89b555> CREATOR = new C04361();

    /* compiled from: faceweb */
    final class C04361 implements Creator<C0437x5c89b555> {
        C04361() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new C0437x5c89b555(parcel);
        }

        public final Object[] newArray(int i) {
            return new C0437x5c89b555[i];
        }
    }

    protected C0437x5c89b555(Parcel parcel) {
        super(parcel);
    }
}
