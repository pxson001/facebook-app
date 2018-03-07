package com.facebook.nearby.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.Objects;

@AutoGenJsonDeserializer
@JsonDeserialize(using = TypeaheadPlaceWithLayoutDeserializer.class)
/* compiled from: unlocked */
public class TypeaheadPlaceWithLayout implements Parcelable {
    public static final Creator<NearbyPlaceEdgeWithLayout> CREATOR = new C00561();
    @JsonProperty("layout")
    public final String layout;
    @JsonProperty("typeahead_place")
    public final TypeaheadPlace typeaheadPlace;

    /* compiled from: unlocked */
    final class C00561 implements Creator<NearbyPlaceEdgeWithLayout> {
        C00561() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new NearbyPlaceEdgeWithLayout(parcel);
        }

        public final Object[] newArray(int i) {
            return new NearbyPlaceEdgeWithLayout[i];
        }
    }

    private TypeaheadPlaceWithLayout() {
        this.typeaheadPlace = null;
        this.layout = null;
    }

    public TypeaheadPlaceWithLayout(TypeaheadPlace typeaheadPlace, String str) {
        this.typeaheadPlace = typeaheadPlace;
        this.layout = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.typeaheadPlace, i);
        parcel.writeString(this.layout);
    }

    public int describeContents() {
        return 0;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.typeaheadPlace, this.layout});
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!getClass().equals(obj.getClass())) {
            return false;
        }
        TypeaheadPlaceWithLayout typeaheadPlaceWithLayout = (TypeaheadPlaceWithLayout) obj;
        if (Objects.equal(typeaheadPlaceWithLayout.typeaheadPlace, this.typeaheadPlace) && Objects.equal(typeaheadPlaceWithLayout.layout, this.layout)) {
            return true;
        }
        return false;
    }
}
