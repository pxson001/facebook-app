package com.facebook.nearby.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.results.BaseResult;
import com.facebook.nearby.common.SearchSuggestion;
import com.facebook.nearby.model.TypeaheadPlace;
import com.facebook.nearby.model.TypeaheadPlaceWithLayout;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;

/* compiled from: topic_ids */
public class NearbyTypeaheadWithLayoutsResult extends BaseResult implements Parcelable {
    public static final Creator<NearbyTypeaheadWithLayoutsResult> CREATOR = new C00871();
    private static final Class<?> f653e = NearbyTypeaheadWithLayoutsResult.class;
    public final String f654a;
    public final String f655b;
    public final List<SearchSuggestion> f656c;
    public final List<TypeaheadPlaceWithLayout> f657d;

    /* compiled from: topic_ids */
    final class C00871 implements Creator<NearbyTypeaheadWithLayoutsResult> {
        C00871() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new NearbyTypeaheadWithLayoutsResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new NearbyTypeaheadWithLayoutsResult[i];
        }
    }

    public NearbyTypeaheadWithLayoutsResult(SearchNearbyPlacesResult searchNearbyPlacesResult, FetchNearbyPlacesLayoutResult fetchNearbyPlacesLayoutResult) {
        super(searchNearbyPlacesResult.freshness, searchNearbyPlacesResult.clientTimeMs);
        this.f654a = searchNearbyPlacesResult.f718a;
        this.f655b = searchNearbyPlacesResult.f719b;
        this.f656c = searchNearbyPlacesResult.f720c;
        this.f657d = m897a(searchNearbyPlacesResult, fetchNearbyPlacesLayoutResult);
    }

    public NearbyTypeaheadWithLayoutsResult(Parcel parcel) {
        super(parcel);
        this.f654a = parcel.readString();
        this.f655b = parcel.readString();
        this.f656c = parcel.readArrayList(SearchSuggestion.class.getClassLoader());
        this.f657d = parcel.readArrayList(TypeaheadPlaceWithLayout.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f654a);
        parcel.writeString(this.f655b);
        parcel.writeList(this.f656c);
        parcel.writeList(this.f657d);
    }

    public int describeContents() {
        return 0;
    }

    private static ImmutableList<TypeaheadPlaceWithLayout> m897a(SearchNearbyPlacesResult searchNearbyPlacesResult, FetchNearbyPlacesLayoutResult fetchNearbyPlacesLayoutResult) {
        Map c;
        if (fetchNearbyPlacesLayoutResult == null) {
            c = Maps.c();
        } else {
            c = fetchNearbyPlacesLayoutResult.f522a;
        }
        Builder builder = ImmutableList.builder();
        int i = !c.isEmpty() ? 1 : 0;
        for (TypeaheadPlace typeaheadPlace : searchNearbyPlacesResult.f721d) {
            String str = (String) c.get(typeaheadPlace.f396a);
            if (i != 0 && str == null) {
                BLog.a(f653e, "missing layout for place id = %s", new Object[]{typeaheadPlace.f396a});
            }
            builder.c(new TypeaheadPlaceWithLayout(typeaheadPlace, str));
        }
        return builder.b();
    }
}
