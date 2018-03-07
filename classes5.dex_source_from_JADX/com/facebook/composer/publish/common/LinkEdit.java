package com.facebook.composer.publish.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.parcels.ParcelUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Objects;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = LinkEditDeserializer.class)
@JsonSerialize(using = LinkEditSerializer.class)
/* compiled from: ad_sharing_status */
public class LinkEdit implements Parcelable {
    public static final Creator<LinkEdit> CREATOR = new C10841();
    @JsonIgnore
    public static final LinkEdit f11513a = new LinkEdit(Boolean.valueOf(true));
    @JsonProperty("link_data")
    public final LinkData linkData;
    @JsonProperty("no_link")
    public final Boolean noLink;

    /* compiled from: ad_sharing_status */
    final class C10841 implements Creator<LinkEdit> {
        C10841() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new LinkEdit(parcel);
        }

        public final Object[] newArray(int i) {
            return new LinkEdit[i];
        }
    }

    @AutoGenJsonDeserializer
    @AutoGenJsonSerializer
    @JsonDeserialize(using = LinkEdit_LinkDataDeserializer.class)
    @JsonSerialize(using = LinkEdit_LinkDataSerializer.class)
    /* compiled from: ad_sharing_status */
    public final class LinkData implements Parcelable {
        public static final Creator<LinkData> CREATOR = new C10851();
        @JsonProperty("link")
        public final String link;

        /* compiled from: ad_sharing_status */
        final class C10851 implements Creator<LinkData> {
            C10851() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new LinkData(parcel);
            }

            public final Object[] newArray(int i) {
                return new LinkData[i];
            }
        }

        private LinkData() {
            this.link = null;
        }

        private LinkData(String str) {
            this.link = str;
        }

        public LinkData(Parcel parcel) {
            this.link = parcel.readString();
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.link);
        }

        public final int describeContents() {
            return 0;
        }

        public static LinkData m19658a(String str) {
            return new LinkData(str);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return Objects.equal(this.link, ((LinkData) obj).link);
        }

        public final int hashCode() {
            return Objects.hashCode(new Object[]{this.link});
        }
    }

    private LinkEdit() {
        this.noLink = null;
        this.linkData = null;
    }

    private LinkEdit(Boolean bool) {
        this.noLink = bool;
        this.linkData = null;
    }

    private LinkEdit(LinkData linkData) {
        this.noLink = null;
        this.linkData = linkData;
    }

    public LinkEdit(Parcel parcel) {
        this.noLink = ParcelUtil.m3834f(parcel);
        this.linkData = (LinkData) parcel.readParcelable(LinkData.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtil.m3819a(parcel, this.noLink);
        parcel.writeParcelable(this.linkData, i);
    }

    public int describeContents() {
        return 0;
    }

    public static LinkEdit m19659a(String str) {
        return new LinkEdit(LinkData.m19658a(str));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LinkEdit linkEdit = (LinkEdit) obj;
        if (Objects.equal(this.noLink, linkEdit.noLink) && Objects.equal(this.linkData, linkEdit.linkData)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.noLink, this.linkData});
    }
}
