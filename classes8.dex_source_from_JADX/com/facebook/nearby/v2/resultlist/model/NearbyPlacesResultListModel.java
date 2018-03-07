package com.facebook.nearby.v2.resultlist.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: date_style */
public class NearbyPlacesResultListModel implements Parcelable {
    public static final Creator<NearbyPlacesResultListModel> CREATOR = new C16971();
    public NearbyPlacesResultListSortType f15861a;
    public NearbyPlacesResultListFilterMask f15862b;
    public NearbyPlacesResultListData f15863c;
    public boolean f15864d;

    /* compiled from: date_style */
    final class C16971 implements Creator<NearbyPlacesResultListModel> {
        C16971() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new NearbyPlacesResultListModel(parcel);
        }

        public final Object[] newArray(int i) {
            return new NearbyPlacesResultListModel[i];
        }
    }

    public NearbyPlacesResultListModel(boolean z) {
        this.f15861a = NearbyPlacesResultListSortType.RELEVANCE;
        this.f15862b = new NearbyPlacesResultListFilterMask(0);
        this.f15864d = z;
        this.f15863c = new NearbyPlacesResultListData();
    }

    protected NearbyPlacesResultListModel(Parcel parcel) {
        this.f15861a = NearbyPlacesResultListSortType.values()[parcel.readInt()];
        this.f15862b = (NearbyPlacesResultListFilterMask) parcel.readParcelable(NearbyPlacesResultListFilterMask.class.getClassLoader());
        this.f15864d = parcel.readByte() != (byte) 0;
        this.f15863c = (NearbyPlacesResultListData) parcel.readParcelable(NearbyPlacesResultListData.class.getClassLoader());
    }

    public final boolean m18711b() {
        return this.f15864d;
    }

    public final void m18710a(NearbyPlacesResultListData nearbyPlacesResultListData) {
        if (nearbyPlacesResultListData == null) {
            this.f15863c = new NearbyPlacesResultListData();
        } else if (nearbyPlacesResultListData.m18705k() || this.f15863c == null) {
            this.f15863c = nearbyPlacesResultListData;
        } else {
            ArrayList arrayList;
            Collection i = nearbyPlacesResultListData.m18703i();
            Collection i2 = this.f15863c.m18703i();
            if (i2 != null && i != null) {
                arrayList = new ArrayList();
                arrayList.addAll(i2);
                arrayList.addAll(i);
            } else if (i2 == null) {
                r12 = i;
            } else {
                r12 = i2;
            }
            this.f15863c = new NearbyPlacesResultListData(this.f15863c.m18695a(), this.f15863c.m18696b(), this.f15863c.m18697c(), this.f15863c.m18698d(), this.f15863c.m18699e(), this.f15863c.m18700f(), this.f15863c.m18701g(), this.f15863c.m18702h(), this.f15863c.m18708n(), arrayList, nearbyPlacesResultListData.m18704j(), nearbyPlacesResultListData.m18705k(), nearbyPlacesResultListData.m18706l(), nearbyPlacesResultListData.m18707m());
        }
    }

    public final boolean m18712c() {
        return this.f15863c != null ? this.f15863c.m18709o() : false;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f15861a.ordinal());
        parcel.writeParcelable(this.f15862b, i);
        parcel.writeParcelable(this.f15863c, i);
        parcel.writeByte((byte) (this.f15864d ? 1 : 0));
    }

    public int describeContents() {
        return 0;
    }
}
