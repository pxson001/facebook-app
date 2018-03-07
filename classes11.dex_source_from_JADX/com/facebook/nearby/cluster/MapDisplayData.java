package com.facebook.nearby.cluster;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.nearby.model.NearbyPlaceEdgeWrapper;
import com.google.common.collect.ImmutableSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/* compiled from: user_location_accuracy */
public class MapDisplayData implements Parcelable {
    public static final Creator<MapDisplayData> CREATOR = new C00461();
    public final Set<NearbyPlaceCluster> f301a;
    public final Set<NearbyPlaceEdgeWrapper> f302b;
    public final Set<NearbyPlaceEdgeWrapper> f303c;

    /* compiled from: user_location_accuracy */
    final class C00461 implements Creator<MapDisplayData> {
        C00461() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new MapDisplayData(parcel);
        }

        public final Object[] newArray(int i) {
            return new MapDisplayData[i];
        }
    }

    public MapDisplayData(List<NearbyPlaceCluster> list, List<NearbyPlaceEdgeWrapper> list2, List<NearbyPlaceEdgeWrapper> list3) {
        this.f301a = ImmutableSet.copyOf(list);
        this.f302b = ImmutableSet.copyOf(list2);
        this.f303c = ImmutableSet.copyOf(list3);
    }

    public MapDisplayData(Parcel parcel) {
        Collection arrayList = new ArrayList();
        parcel.readTypedList(arrayList, NearbyPlaceCluster.CREATOR);
        Collection arrayList2 = new ArrayList();
        parcel.readTypedList(arrayList2, NearbyPlaceEdgeWrapper.CREATOR);
        Collection arrayList3 = new ArrayList();
        parcel.readTypedList(arrayList3, NearbyPlaceEdgeWrapper.CREATOR);
        this.f301a = ImmutableSet.copyOf(arrayList);
        this.f302b = ImmutableSet.copyOf(arrayList2);
        this.f303c = ImmutableSet.copyOf(arrayList3);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(new ArrayList(this.f301a));
        parcel.writeTypedList(new ArrayList(this.f302b));
        parcel.writeTypedList(new ArrayList(this.f303c));
    }

    public int describeContents() {
        return 0;
    }
}
