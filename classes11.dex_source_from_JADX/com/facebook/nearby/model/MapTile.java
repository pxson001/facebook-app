package com.facebook.nearby.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLGeoRectangle;
import com.facebook.graphql.model.GraphQLHelper;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.Objects;
import java.util.List;

@AutoGenJsonSerializer
@AutoGenJsonDeserializer
@JsonDeserialize(using = MapTileDeserializer.class)
/* compiled from: update_services_data */
public class MapTile implements Parcelable {
    public static final Creator<MapTile> CREATOR = new C00511();
    @JsonProperty("backgroundPlaces")
    public final List<NearbyPlaceEdgeWithLayout> backgroundPlaces;
    @JsonProperty("bounds")
    public final GraphQLGeoRectangle bounds;
    @JsonProperty("creationTime")
    public final long creationTime;
    @JsonProperty("id")
    public final String id;
    @JsonProperty("maxZoom")
    public final float maxZoom;
    @JsonProperty("minZoom")
    public final float minZoom;
    @JsonProperty("places")
    public final List<NearbyPlaceEdgeWithLayout> places;
    @JsonProperty("timeToLiveInSeconds")
    public final long timeToLiveInSeconds;

    /* compiled from: update_services_data */
    final class C00511 implements Creator<MapTile> {
        C00511() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new MapTile(parcel);
        }

        public final Object[] newArray(int i) {
            return new MapTile[i];
        }
    }

    public MapTile(String str, long j, long j2, float f, float f2, GraphQLGeoRectangle graphQLGeoRectangle, List<NearbyPlaceEdgeWithLayout> list, List<NearbyPlaceEdgeWithLayout> list2) {
        this.id = str;
        this.bounds = graphQLGeoRectangle;
        this.creationTime = j;
        this.timeToLiveInSeconds = j2;
        this.minZoom = f;
        this.maxZoom = f2;
        this.places = list;
        this.backgroundPlaces = list2;
    }

    public MapTile(Parcel parcel) {
        this.id = parcel.readString();
        this.creationTime = parcel.readLong();
        this.timeToLiveInSeconds = parcel.readLong();
        this.bounds = (GraphQLGeoRectangle) FlatBufferModelHelper.a(parcel);
        this.minZoom = parcel.readFloat();
        this.maxZoom = parcel.readFloat();
        this.places = parcel.readArrayList(NearbyPlaceEdgeWithLayout.class.getClassLoader());
        this.backgroundPlaces = parcel.readArrayList(NearbyPlaceEdgeWithLayout.class.getClassLoader());
    }

    public MapTile() {
        this.id = null;
        this.bounds = null;
        this.creationTime = 0;
        this.timeToLiveInSeconds = 0;
        this.minZoom = 0.0f;
        this.maxZoom = 0.0f;
        this.places = null;
        this.backgroundPlaces = null;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeLong(this.creationTime);
        parcel.writeLong(this.timeToLiveInSeconds);
        FlatBufferModelHelper.a(parcel, this.bounds);
        parcel.writeFloat(this.minZoom);
        parcel.writeFloat(this.maxZoom);
        parcel.writeList(this.places);
        parcel.writeList(this.backgroundPlaces);
    }

    public final long m483a() {
        return this.timeToLiveInSeconds * 1000;
    }

    public final boolean m484a(long j) {
        return this.creationTime + this.timeToLiveInSeconds < j;
    }

    public int hashCode() {
        r0 = new Object[8];
        GraphQLGeoRectangle graphQLGeoRectangle = this.bounds;
        r0[3] = Integer.valueOf(Objects.hashCode(new Object[]{Double.valueOf(graphQLGeoRectangle.j()), Double.valueOf(graphQLGeoRectangle.k()), Double.valueOf(graphQLGeoRectangle.l()), Double.valueOf(graphQLGeoRectangle.a())}));
        r0[4] = Float.valueOf(this.minZoom);
        r0[5] = Float.valueOf(this.maxZoom);
        r0[6] = this.places;
        r0[7] = this.backgroundPlaces;
        return Objects.hashCode(r0);
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
        MapTile mapTile = (MapTile) obj;
        if (Objects.equal(mapTile.id, this.id) && Objects.equal(Long.valueOf(mapTile.creationTime), Long.valueOf(this.creationTime)) && Objects.equal(Long.valueOf(mapTile.timeToLiveInSeconds), Long.valueOf(this.timeToLiveInSeconds)) && GraphQLHelper.a(mapTile.bounds, this.bounds) && Objects.equal(Float.valueOf(mapTile.minZoom), Float.valueOf(this.minZoom)) && Objects.equal(Float.valueOf(mapTile.maxZoom), Float.valueOf(this.maxZoom)) && Objects.equal(mapTile.places, this.places) && Objects.equal(mapTile.backgroundPlaces, this.backgroundPlaces)) {
            return true;
        }
        return false;
    }
}
