package com.facebook.nearby.v2.typeahead.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.nearby.v2.network.NearbyPlacesTypeaheadGraphQLModels.FBNearbyPlacesTypeaheadLocationResultsConnectionFragmentModel.EdgesModel.NodeModel;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

/* compiled from: paid_impressions */
public class NearbyPlacesLocationResult implements Parcelable {
    public static final Creator<NearbyPlacesLocationResult> CREATOR = new C07361();
    public String f5210a;
    public ImmutableList<NodeModel> f5211b;
    public String f5212c;

    /* compiled from: paid_impressions */
    final class C07361 implements Creator<NearbyPlacesLocationResult> {
        C07361() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new NearbyPlacesLocationResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new NearbyPlacesLocationResult[i];
        }
    }

    public NearbyPlacesLocationResult(String str, ImmutableList<NodeModel> immutableList, String str2) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(immutableList);
        Preconditions.checkNotNull(str2);
        this.f5210a = str;
        this.f5211b = immutableList;
        this.f5212c = str2;
    }

    protected NearbyPlacesLocationResult(Parcel parcel) {
        this.f5210a = parcel.readString();
        this.f5211b = ImmutableList.copyOf(FlatBufferModelHelper.b(parcel));
        this.f5212c = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5210a);
        FlatBufferModelHelper.a(parcel, this.f5211b);
        parcel.writeString(this.f5212c);
    }

    public int describeContents() {
        return 0;
    }
}
