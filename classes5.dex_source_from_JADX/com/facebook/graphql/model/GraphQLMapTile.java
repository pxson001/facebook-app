package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = GraphQLMapTileDeserializer.class)
@JsonSerialize(using = GraphQLMapTileSerializer.class)
/* compiled from: fb_imgproc */
public class GraphQLMapTile implements Parcelable {
    public static final Creator<GraphQLMapTile> CREATOR = new C04301();
    @JsonProperty("placesRenderPriority2")
    protected final GraphQLPlacesTileResultsConnection backgroundPlaces;
    @JsonProperty("bounds")
    protected final GraphQLGeoRectangle bounds;
    @JsonProperty("creation_time")
    protected final long creationTime;
    @JsonProperty("tile_key")
    protected final String id;
    @JsonProperty("max_zoom")
    protected final float maxZoom;
    @JsonProperty("min_zoom")
    protected final float minZoom;
    @JsonProperty("placesRenderPriority1")
    protected final GraphQLPlacesTileResultsConnection places;
    @JsonProperty("ttl")
    protected final long timeToLiveInSeconds;

    /* compiled from: fb_imgproc */
    final class C04301 implements Creator<GraphQLMapTile> {
        C04301() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLMapTile(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLMapTile[i];
        }
    }

    public GraphQLMapTile() {
        this.id = null;
        this.bounds = null;
        this.creationTime = 0;
        this.timeToLiveInSeconds = 0;
        this.minZoom = 0.0f;
        this.maxZoom = 0.0f;
        this.places = null;
        this.backgroundPlaces = null;
    }

    public GraphQLMapTile(Parcel parcel) {
        this.id = parcel.readString();
        this.creationTime = parcel.readLong();
        this.timeToLiveInSeconds = parcel.readLong();
        this.bounds = (GraphQLGeoRectangle) FlatBufferModelHelper.m4278a(parcel);
        this.minZoom = parcel.readFloat();
        this.maxZoom = parcel.readFloat();
        this.places = (GraphQLPlacesTileResultsConnection) FlatBufferModelHelper.m4278a(parcel);
        this.backgroundPlaces = (GraphQLPlacesTileResultsConnection) FlatBufferModelHelper.m4278a(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m8985a());
        parcel.writeLong(m8986b());
        parcel.writeLong(m8987c());
        FlatBufferModelHelper.m4288a(parcel, m8988d());
        parcel.writeFloat(m8989e());
        parcel.writeFloat(m8990f());
        FlatBufferModelHelper.m4288a(parcel, m8991g());
        FlatBufferModelHelper.m4288a(parcel, m8992h());
    }

    public final String m8985a() {
        return this.id;
    }

    public final long m8986b() {
        return this.creationTime;
    }

    public final long m8987c() {
        return this.timeToLiveInSeconds;
    }

    public final GraphQLGeoRectangle m8988d() {
        return this.bounds;
    }

    public final float m8989e() {
        return this.minZoom;
    }

    public final float m8990f() {
        return this.maxZoom;
    }

    public final GraphQLPlacesTileResultsConnection m8991g() {
        return this.places;
    }

    public final GraphQLPlacesTileResultsConnection m8992h() {
        return this.backgroundPlaces;
    }
}
