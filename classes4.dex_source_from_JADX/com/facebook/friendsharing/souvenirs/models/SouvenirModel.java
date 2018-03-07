package com.facebook.friendsharing.souvenirs.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = SouvenirModelDeserializer.class)
@Immutable
@JsonSerialize(using = SouvenirModelSerializer.class)
/* compiled from: graph_api_write_id */
public class SouvenirModel implements Parcelable {
    public static final Creator<SouvenirModel> CREATOR = new 1();
    @JsonProperty("items")
    final ImmutableList<SouvenirItem> mItems;
    @JsonProperty("metadata")
    final SouvenirMetadata mMetadata;

    public final SouvenirMetadata m11461a() {
        return this.mMetadata;
    }

    public final ImmutableList<SouvenirItem> m11462b() {
        return this.mItems;
    }

    public String toString() {
        return this.mMetadata.toString();
    }

    public SouvenirModel(SouvenirMetadata souvenirMetadata, ImmutableList<SouvenirItem> immutableList) {
        this.mMetadata = souvenirMetadata;
        this.mItems = immutableList;
    }

    private SouvenirModel() {
        this.mMetadata = null;
        this.mItems = null;
    }

    public SouvenirModel(Parcel parcel) {
        this.mMetadata = (SouvenirMetadata) parcel.readParcelable(SouvenirMetadata.class.getClassLoader());
        this.mItems = SouvenirItemList.a(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mMetadata, i);
        SouvenirItemList.a(this.mItems, parcel, i);
    }
}
