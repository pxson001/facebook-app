package com.facebook.ipc.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import javax.annotation.Nullable;

@AutoGenJsonSerializer
@AutoGenJsonDeserializer
@JsonDeserialize(using = FacebookUserCoverPhotoDeserializer.class)
/* compiled from: TEXT_HEADER_WITH_BADGE */
public class FacebookUserCoverPhoto implements Parcelable {
    public static final Creator<FacebookUserCoverPhoto> CREATOR = new C13611();
    @JsonProperty("cover_id")
    public final long coverID;
    @JsonProperty("offset_x")
    public final float offsetX;
    @JsonProperty("offset_y")
    public final float offsetY;
    @JsonProperty("source")
    @Nullable
    public final String source;

    /* compiled from: TEXT_HEADER_WITH_BADGE */
    final class C13611 implements Creator<FacebookUserCoverPhoto> {
        C13611() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FacebookUserCoverPhoto(parcel);
        }

        public final Object[] newArray(int i) {
            return new FacebookUserCoverPhoto[i];
        }
    }

    public FacebookUserCoverPhoto() {
        this.coverID = -1;
        this.source = null;
        this.offsetX = Float.NaN;
        this.offsetY = Float.NaN;
    }

    public FacebookUserCoverPhoto(@Nullable String str) {
        this.coverID = -1;
        this.source = str;
        this.offsetX = Float.NaN;
        this.offsetY = Float.NaN;
    }

    public FacebookUserCoverPhoto(Parcel parcel) {
        this.coverID = parcel.readLong();
        this.source = parcel.readString();
        this.offsetX = parcel.readFloat();
        this.offsetY = parcel.readFloat();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.coverID);
        parcel.writeString(this.source);
        parcel.writeFloat(this.offsetX);
        parcel.writeFloat(this.offsetY);
    }

    public int describeContents() {
        return 0;
    }
}
