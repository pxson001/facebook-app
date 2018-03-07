package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.graphql.model.extras.FeedUnitExtra;

/* compiled from: TaggableActivityPreviewTemplate */
public class C1275x703d991f extends FeedUnitExtra {
    public static final Creator<C1275x703d991f> CREATOR = new C12741();

    /* compiled from: TaggableActivityPreviewTemplate */
    final class C12741 implements Creator<C1275x703d991f> {
        C12741() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new C1275x703d991f(parcel);
        }

        public final Object[] newArray(int i) {
            return new C1275x703d991f[i];
        }
    }

    protected C1275x703d991f(Parcel parcel) {
        super(parcel);
    }
}
