package com.facebook.search.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: no_context_token_reason */
public class CustomFilterValue implements Parcelable {
    public static final Creator<CustomFilterValue> CREATOR = new C08981();

    /* compiled from: no_context_token_reason */
    final class C08981 implements Creator<CustomFilterValue> {
        C08981() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new CustomFilterValue();
        }

        public final Object[] newArray(int i) {
            return new CustomFilterValue[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
    }
}
