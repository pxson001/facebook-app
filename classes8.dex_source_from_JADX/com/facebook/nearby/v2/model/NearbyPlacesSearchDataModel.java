package com.facebook.nearby.v2.model;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.facebook.nearby.v2.model.LocationStatusUtil.LocationStatus;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: dialog_type */
public class NearbyPlacesSearchDataModel implements Parcelable {
    public static final Creator<NearbyPlacesSearchDataModel> CREATOR = new C16791();
    public LocationStatus f15304a;
    public boolean f15305b;
    @Nullable
    public Location f15306c;
    @Nullable
    public String f15307d;
    @Nullable
    public String f15308e;
    public double f15309f;
    public double f15310g;
    @Nullable
    public NearbyPlacesResultListQueryTopic f15311h;

    /* compiled from: dialog_type */
    final class C16791 implements Creator<NearbyPlacesSearchDataModel> {
        C16791() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new NearbyPlacesSearchDataModel(parcel);
        }

        public final Object[] newArray(int i) {
            return new NearbyPlacesSearchDataModel[i];
        }
    }

    public NearbyPlacesSearchDataModel(LocationStatus locationStatus) {
        this.f15305b = locationStatus == LocationStatus.OKAY;
        this.f15304a = locationStatus;
        this.f15307d = null;
        this.f15308e = null;
        this.f15306c = null;
        this.f15311h = null;
    }

    public NearbyPlacesSearchDataModel(NearbyPlacesSearchDataModel nearbyPlacesSearchDataModel) {
        NearbyPlacesResultListQueryTopic nearbyPlacesResultListQueryTopic = null;
        Preconditions.checkNotNull(nearbyPlacesSearchDataModel);
        this.f15304a = nearbyPlacesSearchDataModel.f15304a;
        this.f15305b = nearbyPlacesSearchDataModel.f15305b;
        this.f15307d = nearbyPlacesSearchDataModel.f15307d;
        this.f15308e = nearbyPlacesSearchDataModel.f15308e;
        this.f15306c = nearbyPlacesSearchDataModel.f15306c == null ? null : new Location(nearbyPlacesSearchDataModel.f15306c);
        if (nearbyPlacesSearchDataModel.f15311h != null) {
            nearbyPlacesResultListQueryTopic = new NearbyPlacesResultListQueryTopic(nearbyPlacesSearchDataModel.f15311h);
        }
        this.f15311h = nearbyPlacesResultListQueryTopic;
    }

    protected NearbyPlacesSearchDataModel(Parcel parcel) {
        this.f15304a = (LocationStatus) parcel.readSerializable();
        this.f15305b = parcel.readByte() != (byte) 0;
        this.f15307d = parcel.readString();
        this.f15308e = parcel.readString();
        this.f15309f = parcel.readDouble();
        this.f15310g = parcel.readDouble();
        this.f15306c = (Location) parcel.readParcelable(Location.class.getClassLoader());
        this.f15311h = (NearbyPlacesResultListQueryTopic) parcel.readParcelable(NearbyPlacesResultListQueryTopic.class.getClassLoader());
    }

    public final boolean m17760f() {
        return this.f15304a == LocationStatus.OKAY;
    }

    @Nullable
    public final String m17755a() {
        return this.f15307d;
    }

    public final void m17756a(Location location) {
        Preconditions.checkNotNull(location);
        this.f15306c = location;
    }

    @Nullable
    public final Location m17759e() {
        return this.f15306c;
    }

    @Nullable
    public final NearbyPlacesResultListQueryTopic m17757c() {
        return this.f15311h;
    }

    public final NearbyPlacesSearchData$Type m17758d() {
        if (this.f15311h == null) {
            return NearbyPlacesSearchData$Type.INVALID;
        }
        Object obj;
        String str = this.f15311h.f15303b;
        if (str == null || !str.startsWith("keywords_places")) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            return NearbyPlacesSearchData$Type.KEYWORDS_PLACES;
        }
        str = this.f15311h.f15303b;
        if (str == null || !str.startsWith("intersect")) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            return NearbyPlacesSearchData$Type.INTERSECT;
        }
        if (this.f15305b) {
            return NearbyPlacesSearchData$Type.CURRENT_LOCATION;
        }
        if (TextUtils.isEmpty(this.f15307d)) {
            return NearbyPlacesSearchData$Type.INVALID;
        }
        return NearbyPlacesSearchData$Type.SPECIFIED_LOCATION;
    }

    public final boolean m17761h() {
        return !NearbyPlacesSearchData$Type.INVALID.equals(m17758d());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeSerializable(this.f15304a);
        parcel.writeByte((byte) (this.f15305b ? 1 : 0));
        parcel.writeString(this.f15307d);
        parcel.writeString(this.f15308e);
        parcel.writeDouble(this.f15309f);
        parcel.writeDouble(this.f15310g);
        parcel.writeParcelable(this.f15306c, i);
        parcel.writeParcelable(this.f15311h, i);
    }

    public int describeContents() {
        return 0;
    }
}
