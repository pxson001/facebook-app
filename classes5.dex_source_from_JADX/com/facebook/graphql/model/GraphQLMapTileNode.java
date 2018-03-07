package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = GraphQLMapTileNodeDeserializer.class)
@JsonSerialize(using = GraphQLMapTileNodeSerializer.class)
/* compiled from: fb_data_policy_url */
public class GraphQLMapTileNode implements Parcelable {
    public static final Creator<GraphQLMapTileNode> CREATOR = new C04311();
    @JsonProperty("node")
    protected final GraphQLMapTile tile;

    /* compiled from: fb_data_policy_url */
    final class C04311 implements Creator<GraphQLMapTileNode> {
        C04311() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLMapTileNode(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLMapTileNode[i];
        }
    }

    public GraphQLMapTileNode() {
        this.tile = null;
    }

    public GraphQLMapTileNode(Parcel parcel) {
        this.tile = (GraphQLMapTile) parcel.readParcelable(GraphQLMapTile.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(m8995a(), i);
    }

    public final GraphQLMapTile m8995a() {
        return this.tile;
    }
}
