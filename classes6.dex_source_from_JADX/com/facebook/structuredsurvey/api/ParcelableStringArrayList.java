package com.facebook.structuredsurvey.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

/* compiled from: draft_candidate */
public class ParcelableStringArrayList extends ArrayList<String> implements Parcelable {
    public static final Creator<ParcelableStringArrayList> CREATOR = new C12451();

    /* compiled from: draft_candidate */
    final class C12451 implements Creator<ParcelableStringArrayList> {
        C12451() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ParcelableStringArrayList(parcel);
        }

        public final Object[] newArray(int i) {
            return new ParcelableStringArrayList[i];
        }
    }

    protected ParcelableStringArrayList(Parcel parcel) {
        parcel.readList(this, String.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this);
    }
}
