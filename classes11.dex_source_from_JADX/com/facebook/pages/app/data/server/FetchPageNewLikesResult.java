package com.facebook.pages.app.data.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.fbservice.results.BaseResult;
import com.facebook.pages.app.data.model.FacebookProfile;
import com.google.common.collect.ImmutableList;

/* compiled from: suggestions_per_collection */
public class FetchPageNewLikesResult extends BaseResult implements Parcelable {
    public static final Creator<FetchPageNewLikesResult> CREATOR = new C01651();
    private final ImmutableList<FacebookProfile> f1213a;

    /* compiled from: suggestions_per_collection */
    final class C01651 implements Creator<FetchPageNewLikesResult> {
        C01651() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchPageNewLikesResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchPageNewLikesResult[i];
        }
    }

    protected FetchPageNewLikesResult(Parcel parcel) {
        super(parcel);
        this.f1213a = ImmutableList.copyOf(parcel.readArrayList(null));
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeList(this.f1213a);
    }

    public int describeContents() {
        return 0;
    }
}
