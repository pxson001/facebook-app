package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.extras.FeedUnitExtra;

/* compiled from: group_context_rows */
public class C0340x25b054b7 extends FeedUnitExtra {
    public static final Creator<C0340x25b054b7> CREATOR = new C03391();

    /* compiled from: group_context_rows */
    final class C03391 implements Creator<C0340x25b054b7> {
        C03391() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new C0340x25b054b7(parcel);
        }

        public final Object[] newArray(int i) {
            return new C0340x25b054b7[i];
        }
    }

    protected C0340x25b054b7(Parcel parcel) {
        super(parcel);
    }
}
