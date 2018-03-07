package com.facebook.nearby.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLPlacesTileResultsEdge;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.Objects;

@AutoGenJsonSerializer
@AutoGenJsonDeserializer
@JsonDeserialize(using = NearbyPlaceEdgeWithLayoutDeserializer.class)
/* compiled from: unused2 */
public class NearbyPlaceEdgeWithLayout implements Parcelable {
    public static final Creator<NearbyPlaceEdgeWithLayout> CREATOR = new C00521();
    @JsonProperty("layout")
    public final String layout;
    @JsonProperty("placeEdge")
    public final GraphQLPlacesTileResultsEdge placeEdge;

    /* compiled from: unused2 */
    final class C00521 implements Creator<NearbyPlaceEdgeWithLayout> {
        C00521() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new NearbyPlaceEdgeWithLayout(parcel);
        }

        public final Object[] newArray(int i) {
            return new NearbyPlaceEdgeWithLayout[i];
        }
    }

    public NearbyPlaceEdgeWithLayout() {
        this.placeEdge = null;
        this.layout = null;
    }

    public NearbyPlaceEdgeWithLayout(Parcel parcel) {
        this.placeEdge = (GraphQLPlacesTileResultsEdge) FlatBufferModelHelper.a(parcel);
        this.layout = parcel.readString();
    }

    public NearbyPlaceEdgeWithLayout(GraphQLPlacesTileResultsEdge graphQLPlacesTileResultsEdge, String str) {
        this.placeEdge = graphQLPlacesTileResultsEdge;
        this.layout = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        FlatBufferModelHelper.a(parcel, this.placeEdge);
        parcel.writeString(this.layout);
    }

    public int describeContents() {
        return 0;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.placeEdge, this.layout});
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
        NearbyPlaceEdgeWithLayout nearbyPlaceEdgeWithLayout = (NearbyPlaceEdgeWithLayout) obj;
        GraphQLPlacesTileResultsEdge graphQLPlacesTileResultsEdge = nearbyPlaceEdgeWithLayout.placeEdge;
        GraphQLPlacesTileResultsEdge graphQLPlacesTileResultsEdge2 = this.placeEdge;
        Object obj2 = 1;
        if (!(graphQLPlacesTileResultsEdge == null && graphQLPlacesTileResultsEdge2 == null)) {
            if (graphQLPlacesTileResultsEdge == null || graphQLPlacesTileResultsEdge2 == null) {
                obj2 = null;
            } else if (!(Objects.equal(Double.valueOf(graphQLPlacesTileResultsEdge.k()), Double.valueOf(graphQLPlacesTileResultsEdge2.k())) && Objects.equal(graphQLPlacesTileResultsEdge.a().ae(), graphQLPlacesTileResultsEdge2.a().ae()))) {
                obj2 = null;
            }
        }
        if (obj2 == null || !Objects.equal(nearbyPlaceEdgeWithLayout.layout, this.layout)) {
            return false;
        }
        return true;
    }
}
