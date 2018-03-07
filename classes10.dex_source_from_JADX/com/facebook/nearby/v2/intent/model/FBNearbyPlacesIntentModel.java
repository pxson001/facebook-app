package com.facebook.nearby.v2.intent.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.nearby.v2.model.NearbyPlacesPlaceModel;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: payments_pay_submitted */
public class FBNearbyPlacesIntentModel implements Parcelable {
    public static final Creator<FBNearbyPlacesIntentModel> CREATOR = new C07161();
    public ImmutableList<NearbyPlacesPlaceModel> f5151a;

    /* compiled from: payments_pay_submitted */
    final class C07161 implements Creator<FBNearbyPlacesIntentModel> {
        C07161() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FBNearbyPlacesIntentModel(parcel);
        }

        public final Object[] newArray(int i) {
            return new FBNearbyPlacesIntentModel[i];
        }
    }

    public FBNearbyPlacesIntentModel() {
        this.f5151a = new Builder().b();
    }

    public FBNearbyPlacesIntentModel(Parcel parcel) {
        Collection arrayList = new ArrayList();
        parcel.readList(arrayList, NearbyPlacesPlaceModel.class.getClassLoader());
        this.f5151a = ImmutableList.copyOf(arrayList);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f5151a);
    }

    public int describeContents() {
        return 0;
    }
}
