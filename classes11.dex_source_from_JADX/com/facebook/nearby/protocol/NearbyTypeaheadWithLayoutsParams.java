package com.facebook.nearby.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: topic_searchable */
public class NearbyTypeaheadWithLayoutsParams implements Parcelable {
    public static final Creator<NearbyTypeaheadWithLayoutsParams> CREATOR = new C00861();
    public final SearchNearbyPlacesParams f651a;
    public final FetchNearbyPlacesLayoutParams f652b;

    /* compiled from: topic_searchable */
    final class C00861 implements Creator<NearbyTypeaheadWithLayoutsParams> {
        C00861() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new NearbyTypeaheadWithLayoutsParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new NearbyTypeaheadWithLayoutsParams[i];
        }
    }

    public NearbyTypeaheadWithLayoutsParams(SearchNearbyPlacesParams searchNearbyPlacesParams, FetchNearbyPlacesLayoutParams fetchNearbyPlacesLayoutParams) {
        this.f651a = searchNearbyPlacesParams;
        this.f652b = fetchNearbyPlacesLayoutParams;
    }

    public NearbyTypeaheadWithLayoutsParams(Parcel parcel) {
        this.f651a = (SearchNearbyPlacesParams) parcel.readParcelable(SearchNearbyPlacesParams.class.getClassLoader());
        this.f652b = (FetchNearbyPlacesLayoutParams) parcel.readParcelable(FetchNearbyPlacesLayoutParams.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f651a, i);
        parcel.writeParcelable(this.f652b, i);
    }
}
