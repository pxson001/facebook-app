package com.facebook.nearby.v2.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.nearby.v2.logging.NearbyPlacesSession;
import com.facebook.nearby.v2.logging.NearbyPlacesSession.EntryPoint;
import com.facebook.nearby.v2.logging.NearbyPlacesSession.ImpressionSource;
import com.facebook.nearby.v2.model.LocationStatusUtil.LocationStatus;
import com.facebook.search.results.model.SearchResultsMutableContext;

/* compiled from: direct_source */
public class NearbyPlacesFragmentModel implements Parcelable, NearbyPlacesSearchDataProvider {
    public static final Creator<NearbyPlacesFragmentModel> CREATOR = new C16761();
    public NearbyPlacesSession f15299a;
    public NearbyPlacesSearchDataModel f15300b;

    /* compiled from: direct_source */
    final class C16761 implements Creator<NearbyPlacesFragmentModel> {
        C16761() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new NearbyPlacesFragmentModel(parcel);
        }

        public final Object[] newArray(int i) {
            return new NearbyPlacesFragmentModel[i];
        }
    }

    public NearbyPlacesFragmentModel(EntryPoint entryPoint, ImpressionSource impressionSource, LocationStatus locationStatus) {
        this.f15299a = new NearbyPlacesSession(entryPoint, impressionSource);
        this.f15300b = new NearbyPlacesSearchDataModel(locationStatus);
    }

    public NearbyPlacesFragmentModel(EntryPoint entryPoint, ImpressionSource impressionSource, LocationStatus locationStatus, SearchResultsMutableContext searchResultsMutableContext) {
        this.f15299a = new NearbyPlacesSession(entryPoint, impressionSource, searchResultsMutableContext);
        this.f15300b = new NearbyPlacesSearchDataModel(locationStatus);
    }

    public final /* synthetic */ NearbyPlacesSearchDataModel mo918c() {
        return this.f15300b;
    }

    public NearbyPlacesFragmentModel(Parcel parcel) {
        this.f15299a = (NearbyPlacesSession) parcel.readParcelable(NearbyPlacesSession.class.getClassLoader());
        this.f15300b = (NearbyPlacesSearchDataModel) parcel.readParcelable(NearbyPlacesSearchDataModel.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f15299a, i);
        parcel.writeParcelable(this.f15300b, i);
    }

    public int describeContents() {
        return 0;
    }
}
