package com.facebook.nearby.v2.typeahead.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.nearby.v2.network.NearbyPlacesTypeaheadGraphQLModels.FBNearbyPlacesTypeaheadPlaceFragmentModel;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: pagesmanager/{#%s} */
public class NearbyPlacesPlacesAndTopicsResult implements Parcelable {
    public static final Creator<NearbyPlacesPlacesAndTopicsResult> CREATOR = new C07371();
    public String f5213a;
    public ImmutableList<FBNearbyPlacesTypeaheadPlaceFragmentModel> f5214b;
    public ImmutableList<String> f5215c;
    public String f5216d;

    /* compiled from: pagesmanager/{#%s} */
    final class C07371 implements Creator<NearbyPlacesPlacesAndTopicsResult> {
        C07371() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new NearbyPlacesPlacesAndTopicsResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new NearbyPlacesPlacesAndTopicsResult[i];
        }
    }

    public NearbyPlacesPlacesAndTopicsResult(String str, ArrayList<FBNearbyPlacesTypeaheadPlaceFragmentModel> arrayList, ArrayList<String> arrayList2, String str2) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(arrayList);
        Preconditions.checkNotNull(arrayList2);
        Preconditions.checkNotNull(str2);
        this.f5213a = str;
        this.f5214b = ImmutableList.copyOf(arrayList);
        this.f5215c = ImmutableList.copyOf(arrayList2);
        this.f5216d = str2;
    }

    protected NearbyPlacesPlacesAndTopicsResult(Parcel parcel) {
        this.f5213a = parcel.readString();
        this.f5214b = ImmutableList.copyOf(FlatBufferModelHelper.b(parcel));
        Collection arrayList = new ArrayList();
        parcel.readList(arrayList, String.class.getClassLoader());
        this.f5215c = ImmutableList.copyOf(arrayList);
        this.f5216d = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5213a);
        FlatBufferModelHelper.a(parcel, this.f5214b);
        parcel.writeList(this.f5215c);
        parcel.writeString(this.f5216d);
    }

    public int describeContents() {
        return 0;
    }
}
