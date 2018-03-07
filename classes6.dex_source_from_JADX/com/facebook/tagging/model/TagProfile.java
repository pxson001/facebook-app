package com.facebook.tagging.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.annotations.VisibleForTesting;

/* compiled from: deltaReadReceipt */
public class TagProfile implements Parcelable {
    public static final Creator<TagProfile> CREATOR = new C12791();
    @JsonProperty("photo")
    public final String photoUri;
    @JsonProperty("subtext")
    public final String subtext;
    @JsonProperty("text")
    public final String text;
    @JsonProperty("type")
    public final String type;
    @JsonProperty("uid")
    public final long uid;

    /* compiled from: deltaReadReceipt */
    final class C12791 implements Creator<TagProfile> {
        C12791() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new TagProfile(parcel);
        }

        public final Object[] newArray(int i) {
            return new TagProfile[i];
        }
    }

    @VisibleForTesting
    public TagProfile() {
        this.uid = 0;
        this.photoUri = null;
        this.subtext = null;
        this.text = null;
        this.type = null;
    }

    public TagProfile(Parcel parcel) {
        this.uid = parcel.readLong();
        this.type = parcel.readString();
        this.text = parcel.readString();
        this.subtext = parcel.readString();
        this.photoUri = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.uid);
        parcel.writeString(this.type);
        parcel.writeString(this.text);
        parcel.writeString(this.subtext);
        parcel.writeString(this.photoUri);
    }
}
