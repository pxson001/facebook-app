package com.facebook.api.feed;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.collect.Lists;
import java.util.HashMap;
import java.util.List;

/* compiled from: audience_id */
public class CheckForInvalidStoriesParams implements Parcelable {
    public static final Creator<CheckForInvalidStoriesParams> CREATOR = new C09361();
    public final List<String> f8683a = Lists.a();
    private HashMap<String, List<String>> f8684b;

    /* compiled from: audience_id */
    final class C09361 implements Creator<CheckForInvalidStoriesParams> {
        C09361() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new CheckForInvalidStoriesParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new CheckForInvalidStoriesParams[i];
        }
    }

    public CheckForInvalidStoriesParams(Parcel parcel) {
        parcel.readStringList(this.f8683a);
        this.f8684b = (HashMap) parcel.readSerializable();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringList(this.f8683a);
        parcel.writeSerializable(this.f8684b);
    }
}
