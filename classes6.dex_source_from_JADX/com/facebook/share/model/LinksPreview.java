package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@AutoGenJsonDeserializer
/* compiled from: server_specified_transcode_dimension */
public class LinksPreview implements Parcelable {
    public static final Creator<LinksPreview> CREATOR = new C02961();
    @JsonProperty("caption")
    public final String caption;
    @JsonProperty("description")
    public final String description;
    @JsonProperty("href")
    public final String href;
    @JsonProperty("media")
    public final List<Media> media;
    @JsonProperty("name")
    public final String name;
    @JsonProperty("properties")
    public final Map<String, String> properties;

    /* compiled from: server_specified_transcode_dimension */
    final class C02961 implements Creator<LinksPreview> {
        C02961() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new LinksPreview(parcel);
        }

        public final Object[] newArray(int i) {
            return new LinksPreview[i];
        }
    }

    @AutoGenJsonDeserializer
    /* compiled from: server_specified_transcode_dimension */
    public class Media implements Parcelable {
        public static final Creator<Media> CREATOR = new C02971();
        @JsonProperty("height")
        public final int height;
        @JsonProperty("src")
        public final String src;
        @JsonProperty("type")
        public final String type;
        @JsonProperty("width")
        public final int width;

        /* compiled from: server_specified_transcode_dimension */
        final class C02971 implements Creator<Media> {
            C02971() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new Media(parcel);
            }

            public final Object[] newArray(int i) {
                return new Media[i];
            }
        }

        public Media() {
            this.type = null;
            this.src = null;
            this.width = 0;
            this.height = 0;
        }

        public Media(Parcel parcel) {
            this.type = parcel.readString();
            this.src = parcel.readString();
            this.width = parcel.readInt();
            this.height = parcel.readInt();
        }

        public String toString() {
            return this.src;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.type);
            parcel.writeString(this.src);
            parcel.writeInt(this.width);
            parcel.writeInt(this.height);
        }
    }

    public LinksPreview() {
        this.href = null;
        this.name = null;
        this.caption = null;
        this.description = null;
        this.media = Collections.emptyList();
        this.properties = Collections.emptyMap();
    }

    public LinksPreview(Parcel parcel) {
        this.href = parcel.readString();
        this.name = parcel.readString();
        this.caption = parcel.readString();
        this.description = parcel.readString();
        this.media = parcel.readArrayList(Media.class.getClassLoader());
        this.properties = parcel.readHashMap(String.class.getClassLoader());
    }

    public String toString() {
        return this.name;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.href);
        parcel.writeString(this.name);
        parcel.writeString(this.caption);
        parcel.writeString(this.description);
        parcel.writeList(this.media);
        parcel.writeMap(this.properties);
    }

    @JsonIgnore
    public final Media m7697a() {
        if (this.media == null) {
            return null;
        }
        for (Media media : this.media) {
            if ("image".equals(media.type)) {
                return media;
            }
        }
        return null;
    }

    @JsonIgnore
    public final String m7698b() {
        Media a = m7697a();
        return a != null ? a.src : null;
    }
}
