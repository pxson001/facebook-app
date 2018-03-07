package com.facebook.nearby.v2.typeahead.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.nearby.v2.model.NearbyPlacesSearchDataModel;
import javax.annotation.Nullable;

/* compiled from: pagesmanager */
public class NearbyPlacesTypeaheadModel implements Parcelable {
    public static final Creator<NearbyPlacesTypeaheadModel> CREATOR = new C07381();
    public NearbyPlacesSearchDataModel f5217a;
    @Nullable
    public NearbyPlacesPlacesAndTopicsResult f5218b;
    @Nullable
    public NearbyPlacesLocationResult f5219c;

    /* compiled from: pagesmanager */
    final class C07381 implements Creator<NearbyPlacesTypeaheadModel> {
        C07381() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new NearbyPlacesTypeaheadModel(parcel);
        }

        public final Object[] newArray(int i) {
            return new NearbyPlacesTypeaheadModel[i];
        }
    }

    public NearbyPlacesTypeaheadModel(NearbyPlacesSearchDataModel nearbyPlacesSearchDataModel) {
        this.f5217a = new NearbyPlacesSearchDataModel(nearbyPlacesSearchDataModel);
    }

    protected NearbyPlacesTypeaheadModel(Parcel parcel) {
        this.f5217a = (NearbyPlacesSearchDataModel) parcel.readParcelable(NearbyPlacesSearchDataModel.class.getClassLoader());
        this.f5218b = (NearbyPlacesPlacesAndTopicsResult) parcel.readParcelable(NearbyPlacesPlacesAndTopicsResult.class.getClassLoader());
        this.f5219c = (NearbyPlacesLocationResult) parcel.readParcelable(NearbyPlacesLocationResult.class.getClassLoader());
    }

    public final void m4676b() {
        this.f5219c = null;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f5217a, i);
        parcel.writeParcelable(this.f5218b, i);
        parcel.writeParcelable(this.f5219c, i);
    }

    public int describeContents() {
        return 0;
    }
}
