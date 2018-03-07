package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.extras.FeedUnitExtra;

/* compiled from: event_ticket_order_id */
public class C0449x3fc54715 extends FeedUnitExtra {
    public static final Creator<C0449x3fc54715> CREATOR = new C04481();

    /* compiled from: event_ticket_order_id */
    final class C04481 implements Creator<C0449x3fc54715> {
        C04481() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new C0449x3fc54715(parcel);
        }

        public final Object[] newArray(int i) {
            return new C0449x3fc54715[i];
        }
    }

    protected C0449x3fc54715(Parcel parcel) {
        super(parcel);
    }
}
