package com.facebook.nearby.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: totalTime */
public class NearbyTilesWithLayoutsParams implements Parcelable {
    public static final Creator<NearbyTilesWithLayoutsParams> CREATOR = new C00841();
    public final NearbyTilesParams f642a;
    public final FetchNearbyPlacesLayoutParams f643b;

    /* compiled from: totalTime */
    final class C00841 implements Creator<NearbyTilesWithLayoutsParams> {
        C00841() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new NearbyTilesWithLayoutsParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new NearbyTilesWithLayoutsParams[i];
        }
    }

    private NearbyTilesWithLayoutsParams() {
        this.f642a = null;
        this.f643b = null;
    }

    public NearbyTilesWithLayoutsParams(NearbyTilesParams nearbyTilesParams, FetchNearbyPlacesLayoutParams fetchNearbyPlacesLayoutParams) {
        this.f642a = nearbyTilesParams;
        this.f643b = fetchNearbyPlacesLayoutParams;
    }

    public NearbyTilesWithLayoutsParams(Parcel parcel) {
        this.f642a = (NearbyTilesParams) parcel.readParcelable(NearbyTilesParams.class.getClassLoader());
        this.f643b = (FetchNearbyPlacesLayoutParams) parcel.readParcelable(FetchNearbyPlacesLayoutParams.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f642a, i);
        parcel.writeParcelable(this.f643b, i);
    }
}
