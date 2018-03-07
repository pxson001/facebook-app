package com.facebook.nearby.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.fbservice.results.BaseResult;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.nearby.common.SearchSuggestion;
import com.facebook.nearby.model.TypeaheadPlace;
import java.util.List;

/* compiled from: topTextInput */
public class SearchNearbyPlacesResult extends BaseResult implements Parcelable {
    public static final Creator<SearchNearbyPlacesResult> CREATOR = new C00901();
    public final String f718a;
    public final String f719b;
    public final List<SearchSuggestion> f720c;
    public final List<TypeaheadPlace> f721d;

    /* compiled from: topTextInput */
    final class C00901 implements Creator<SearchNearbyPlacesResult> {
        C00901() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SearchNearbyPlacesResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new SearchNearbyPlacesResult[i];
        }
    }

    protected SearchNearbyPlacesResult(DataFreshnessResult dataFreshnessResult, long j, String str, String str2, List<SearchSuggestion> list, List<TypeaheadPlace> list2) {
        super(dataFreshnessResult, j);
        this.f718a = str;
        this.f719b = str2;
        this.f720c = list;
        this.f721d = list2;
    }

    public SearchNearbyPlacesResult(Parcel parcel) {
        super(parcel);
        this.f718a = parcel.readString();
        this.f719b = parcel.readString();
        this.f720c = parcel.readArrayList(SearchSuggestion.class.getClassLoader());
        this.f721d = parcel.readArrayList(TypeaheadPlace.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f718a);
        parcel.writeString(this.f719b);
        parcel.writeList(this.f720c);
        parcel.writeList(this.f721d);
    }

    public int describeContents() {
        return 0;
    }
}
