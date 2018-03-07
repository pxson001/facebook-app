package com.facebook.nearby.v2.resultlist.model;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.nearby.v2.model.NearbyPlacesPlaceModel;
import com.facebook.nearby.v2.model.NearbyPlacesResultListQueryTopic;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.GeoRectangleFragmentModel;
import java.util.ArrayList;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: day_text_color */
public class NearbyPlacesResultListData implements Parcelable {
    public static final Creator<NearbyPlacesResultListData> CREATOR = new C16951();
    public Location f15846a;
    public Location f15847b;
    public String f15848c;
    public NearbyPlacesResultListFilterMask f15849d;
    public NearbyPlacesResultListSortType f15850e;
    public NearbyPlacesResultListSearchType f15851f;
    public NearbyPlacesResultListQueryTopic f15852g;
    public GeoRectangleFragmentModel f15853h;
    private GeoRectangleFragmentModel f15854i;
    private ArrayList<NearbyPlacesPlaceModel> f15855j;
    public String f15856k;
    public boolean f15857l;
    public boolean f15858m;
    public String f15859n;

    /* compiled from: day_text_color */
    final class C16951 implements Creator<NearbyPlacesResultListData> {
        C16951() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new NearbyPlacesResultListData(parcel);
        }

        public final Object[] newArray(int i) {
            return new NearbyPlacesResultListData[i];
        }
    }

    public NearbyPlacesResultListData() {
        this.f15849d = new NearbyPlacesResultListFilterMask(0);
        this.f15850e = NearbyPlacesResultListSortType.RELEVANCE;
        this.f15851f = NearbyPlacesResultListSearchType.NONE;
    }

    public NearbyPlacesResultListData(Location location, Location location2, String str, GeoRectangleFragmentModel geoRectangleFragmentModel, NearbyPlacesResultListFilterMask nearbyPlacesResultListFilterMask, NearbyPlacesResultListSortType nearbyPlacesResultListSortType, NearbyPlacesResultListSearchType nearbyPlacesResultListSearchType, NearbyPlacesResultListQueryTopic nearbyPlacesResultListQueryTopic, GeoRectangleFragmentModel geoRectangleFragmentModel2, ArrayList<NearbyPlacesPlaceModel> arrayList, String str2, boolean z, boolean z2, String str3) {
        this.f15846a = location;
        this.f15847b = location2;
        this.f15848c = str;
        this.f15853h = geoRectangleFragmentModel;
        this.f15849d = nearbyPlacesResultListFilterMask;
        this.f15850e = nearbyPlacesResultListSortType;
        this.f15851f = nearbyPlacesResultListSearchType;
        this.f15852g = nearbyPlacesResultListQueryTopic;
        this.f15854i = geoRectangleFragmentModel2;
        this.f15855j = arrayList;
        this.f15856k = str2;
        this.f15857l = z;
        this.f15858m = z2;
        this.f15859n = str3;
    }

    protected NearbyPlacesResultListData(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.f15846a = (Location) parcel.readParcelable(Location.class.getClassLoader());
        this.f15847b = (Location) parcel.readParcelable(Location.class.getClassLoader());
        this.f15848c = parcel.readString();
        this.f15853h = (GeoRectangleFragmentModel) FlatBufferModelHelper.a(parcel);
        this.f15849d = (NearbyPlacesResultListFilterMask) parcel.readParcelable(NearbyPlacesResultListFilterMask.class.getClassLoader());
        this.f15850e = NearbyPlacesResultListSortType.values()[parcel.readInt()];
        this.f15851f = NearbyPlacesResultListSearchType.values()[parcel.readInt()];
        this.f15852g = (NearbyPlacesResultListQueryTopic) parcel.readParcelable(NearbyPlacesResultListQueryTopic.class.getClassLoader());
        this.f15854i = (GeoRectangleFragmentModel) FlatBufferModelHelper.a(parcel);
        Object arrayList = new ArrayList();
        parcel.readList(arrayList, NearbyPlacesPlaceModel.class.getClassLoader());
        this.f15855j = arrayList;
        this.f15856k = parcel.readString();
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.f15857l = z;
        if (parcel.readByte() == (byte) 0) {
            z2 = false;
        }
        this.f15858m = z2;
        this.f15859n = parcel.readString();
    }

    public final Location m18695a() {
        return this.f15846a;
    }

    public final Location m18696b() {
        return this.f15847b;
    }

    public final String m18697c() {
        return this.f15848c;
    }

    public final GeoRectangleFragmentModel m18698d() {
        return this.f15853h;
    }

    public final NearbyPlacesResultListFilterMask m18699e() {
        return this.f15849d;
    }

    public final NearbyPlacesResultListSortType m18700f() {
        return this.f15850e;
    }

    public final NearbyPlacesResultListSearchType m18701g() {
        return this.f15851f;
    }

    public final NearbyPlacesResultListQueryTopic m18702h() {
        return this.f15852g;
    }

    public final ArrayList<NearbyPlacesPlaceModel> m18703i() {
        if (this.f15855j == null) {
            return null;
        }
        return new ArrayList(this.f15855j);
    }

    public final String m18704j() {
        return this.f15856k;
    }

    public final boolean m18705k() {
        return this.f15857l;
    }

    public final boolean m18706l() {
        return this.f15858m;
    }

    public final String m18707m() {
        return this.f15859n;
    }

    public final GeoRectangleFragmentModel m18708n() {
        return this.f15854i;
    }

    public final boolean m18709o() {
        return (this.f15855j == null || this.f15855j.isEmpty()) ? false : true;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeParcelable(this.f15846a, i);
        parcel.writeParcelable(this.f15847b, i);
        parcel.writeString(this.f15848c);
        FlatBufferModelHelper.a(parcel, this.f15853h);
        parcel.writeParcelable(this.f15849d, i);
        parcel.writeInt(this.f15850e.ordinal());
        parcel.writeInt(this.f15851f.ordinal());
        parcel.writeParcelable(this.f15852g, i);
        FlatBufferModelHelper.a(parcel, this.f15854i);
        parcel.writeList(this.f15855j);
        parcel.writeString(this.f15856k);
        if (this.f15857l) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (!this.f15858m) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeString(this.f15859n);
    }

    public int describeContents() {
        return 0;
    }
}
