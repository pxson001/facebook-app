package com.facebook.ipc.composer.intent;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.parcels.ParcelUtil;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Strings;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = PlatformConfigurationDeserializer.class)
@JsonSerialize(using = PlatformConfigurationSerializer.class)
/* compiled from: linear_bucket */
public class PlatformConfiguration implements Parcelable {
    public static final Creator<PlatformConfiguration> CREATOR = new C07401();
    @JsonProperty("caption_for_share_link")
    public final String captionForShareLink;
    @JsonProperty("data_failures_fatal")
    public final boolean dataFailuresFatal;
    @JsonProperty("description_for_share_link")
    public final String descriptionForShareLink;
    @JsonProperty("hashtag")
    public final String hashtag;
    @JsonProperty("insights_platform_ref")
    public final String insightsPlatformRef;
    @JsonProperty("name_for_share_link")
    public final String nameForShareLink;
    @JsonProperty("og_action_json_for_robotext")
    @Nullable
    public final String ogActionJsonForRobotext;
    @JsonProperty("og_action_type")
    @Nullable
    public final String ogActionType;
    @JsonProperty("picture_for_share_link")
    public final String pictureForShareLink;

    /* compiled from: linear_bucket */
    final class C07401 implements Creator<PlatformConfiguration> {
        C07401() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PlatformConfiguration(parcel);
        }

        public final Object[] newArray(int i) {
            return new PlatformConfiguration[i];
        }
    }

    /* compiled from: linear_bucket */
    public class Builder {
        public String f11582a;
        public String f11583b;
        public boolean f11584c;
        public String f11585d;
        public String f11586e;
        public String f11587f;
        public String f11588g;
        public String f11589h;
        public String f11590i;

        public Builder(PlatformConfiguration platformConfiguration) {
            this.f11584c = platformConfiguration.dataFailuresFatal;
            this.f11585d = platformConfiguration.insightsPlatformRef;
            this.f11586e = platformConfiguration.hashtag;
            this.f11582a = platformConfiguration.ogActionJsonForRobotext;
            this.f11583b = platformConfiguration.ogActionType;
        }

        public final PlatformConfiguration m18275a() {
            return new PlatformConfiguration(this);
        }
    }

    private PlatformConfiguration() {
        this(new Builder());
    }

    public PlatformConfiguration(Builder builder) {
        this.dataFailuresFatal = builder.f11584c;
        this.insightsPlatformRef = builder.f11585d;
        this.hashtag = builder.f11586e;
        this.ogActionJsonForRobotext = builder.f11582a;
        this.ogActionType = builder.f11583b;
        this.nameForShareLink = builder.f11587f;
        this.captionForShareLink = builder.f11588g;
        this.pictureForShareLink = builder.f11589h;
        this.descriptionForShareLink = builder.f11590i;
    }

    public PlatformConfiguration(Parcel parcel) {
        this.dataFailuresFatal = ParcelUtil.a(parcel);
        this.insightsPlatformRef = parcel.readString();
        this.hashtag = parcel.readString();
        this.ogActionJsonForRobotext = parcel.readString();
        this.ogActionType = parcel.readString();
        this.nameForShareLink = parcel.readString();
        this.captionForShareLink = parcel.readString();
        this.pictureForShareLink = parcel.readString();
        this.descriptionForShareLink = parcel.readString();
    }

    public final Builder m18276a() {
        return new Builder(this);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtil.a(parcel, this.dataFailuresFatal);
        parcel.writeString(this.insightsPlatformRef);
        parcel.writeString(this.hashtag);
        parcel.writeString(this.ogActionJsonForRobotext);
        parcel.writeString(this.ogActionType);
        parcel.writeString(this.nameForShareLink);
        parcel.writeString(this.captionForShareLink);
        parcel.writeString(this.pictureForShareLink);
        parcel.writeString(this.descriptionForShareLink);
    }

    public final boolean m18277b() {
        return (Strings.isNullOrEmpty(this.ogActionJsonForRobotext) || Strings.isNullOrEmpty(this.ogActionType)) ? false : true;
    }
}
