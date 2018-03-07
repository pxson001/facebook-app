package com.facebook.nearby.v2.model;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLInterfaces.NearbyPagePlaceInfoFragment.Hours;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLInterfaces.NearbyPlacesHugeResultCellPageInformationFragment;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLInterfaces.Photo320Fragment;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.BrowseNearbyPlacesFullImageFragmentModel;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.NearbyPagePlaceInfoFragmentModel.AddressModel;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.NearbyPagePlaceInfoFragmentModel.OverallStarRatingModel;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.NearbyPlacesFriendsWhoVisitedFragmentModel.FriendsWhoVisitedModel;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;

/* compiled from: did_see_content */
public class NearbyPlacesPlaceModel implements Parcelable {
    public static final Creator<NearbyPlacesPlaceModel> CREATOR = new C16771();
    public NearbyPlacesHugeResultCellPageInformationFragment f15301a;

    /* compiled from: did_see_content */
    final class C16771 implements Creator<NearbyPlacesPlaceModel> {
        C16771() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new NearbyPlacesPlaceModel(parcel);
        }

        public final Object[] newArray(int i) {
            return new NearbyPlacesPlaceModel[i];
        }
    }

    public NearbyPlacesPlaceModel(NearbyPlacesHugeResultCellPageInformationFragment nearbyPlacesHugeResultCellPageInformationFragment) {
        Preconditions.checkNotNull(nearbyPlacesHugeResultCellPageInformationFragment);
        this.f15301a = nearbyPlacesHugeResultCellPageInformationFragment;
    }

    protected NearbyPlacesPlaceModel(Parcel parcel) {
        this.f15301a = (NearbyPlacesHugeResultCellPageInformationFragment) FlatBufferModelHelper.a(parcel);
    }

    public final String m17737a() {
        return this.f15301a.mo942o();
    }

    public final String m17738b() {
        return this.f15301a.mo939l();
    }

    public final AddressModel m17739c() {
        return this.f15301a.mo930b();
    }

    public final BrowseNearbyPlacesFullImageFragmentModel m17740d() {
        return this.f15301a.mo952y();
    }

    public final FriendsWhoVisitedModel m17741e() {
        return this.f15301a.mo934j();
    }

    public final Location m17742f() {
        if (!m17751p()) {
            return null;
        }
        Location location = new Location("");
        location.setLatitude(this.f15301a.mo941n().m17853a());
        location.setLongitude(this.f15301a.mo941n().m17857b());
        return location;
    }

    public final String m17743g() {
        return m17751p() ? this.f15301a.mo941n().m17858c() : null;
    }

    public final String m17744h() {
        return m17752q() ? this.f15301a.mo950w() : null;
    }

    public final ImmutableList<String> m17745i() {
        return this.f15301a.mo926H();
    }

    public final int m17746j() {
        if (this.f15301a.mo944q() == null) {
            return 0;
        }
        return this.f15301a.mo944q().m17871a();
    }

    public final ImmutableList<String> m17747k() {
        return this.f15301a.mo924F();
    }

    public final ImmutableList<Photo320Fragment> m17748l() {
        if (m17753s()) {
            return this.f15301a.mo923E();
        }
        return null;
    }

    public final ImmutableList<Hours> m17749m() {
        if (m17754v()) {
            return this.f15301a.mo937k();
        }
        return null;
    }

    public final OverallStarRatingModel m17750n() {
        return this.f15301a.mo943p();
    }

    public final boolean m17751p() {
        return this.f15301a.mo941n() != null;
    }

    public final boolean m17752q() {
        return !Strings.isNullOrEmpty(this.f15301a.mo950w());
    }

    public final boolean m17753s() {
        return (this.f15301a.mo923E() == null || this.f15301a.mo923E().isEmpty()) ? false : true;
    }

    public final boolean m17754v() {
        return (this.f15301a.mo937k() == null || this.f15301a.mo937k().isEmpty()) ? false : true;
    }

    public void writeToParcel(Parcel parcel, int i) {
        FlatBufferModelHelper.a(parcel, (Flattenable) this.f15301a);
    }

    public int describeContents() {
        return 0;
    }
}
