package com.facebook.nearby.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.fbservice.results.BaseResult;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.google.common.collect.ImmutableMap;
import java.util.Map;

/* compiled from: typeaheadPlace */
public class FetchNearbyPlacesLayoutResult extends BaseResult implements Parcelable {
    public static final Creator<FetchNearbyPlacesLayoutResult> CREATOR = new C00811();
    public final ImmutableMap<String, String> f522a;

    /* compiled from: typeaheadPlace */
    final class C00811 implements Creator<FetchNearbyPlacesLayoutResult> {
        C00811() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchNearbyPlacesLayoutResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchNearbyPlacesLayoutResult[i];
        }
    }

    public FetchNearbyPlacesLayoutResult(DataFreshnessResult dataFreshnessResult, long j, Map<String, String> map) {
        super(dataFreshnessResult, j);
        this.f522a = ImmutableMap.copyOf(map);
    }

    public FetchNearbyPlacesLayoutResult(Parcel parcel) {
        super(parcel);
        this.f522a = (ImmutableMap) parcel.readSerializable();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeSerializable(this.f522a);
    }

    public int describeContents() {
        return 0;
    }
}
