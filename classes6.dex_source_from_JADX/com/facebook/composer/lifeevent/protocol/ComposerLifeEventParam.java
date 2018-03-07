package com.facebook.composer.lifeevent.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.graphql.enums.GraphQLLifeEventAPIIdentifier;
import com.facebook.uicontrib.datepicker.Date;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = ComposerLifeEventParamDeserializer.class)
@JsonSerialize(using = ComposerLifeEventParamSerializer.class)
/* compiled from: place_likelihood */
public class ComposerLifeEventParam implements Parcelable {
    @JsonIgnore
    public static final Creator<ComposerLifeEventParam> CREATOR = new C04641();
    @JsonProperty("composer_session_id")
    public final String composerSessionId;
    @JsonProperty("description")
    public final String description;
    @JsonProperty("employer_hub_id")
    public final String employerHubId;
    @JsonProperty("end_date")
    public final String endDate;
    @JsonProperty("icon_id")
    public final String iconId;
    @JsonProperty("is_current")
    public final boolean isCurrent;
    @JsonProperty("is_graduate")
    public final boolean isGraduated;
    @JsonProperty("life_event_type")
    public final GraphQLLifeEventAPIIdentifier lifeEventType;
    @JsonProperty("photo_fbids")
    public final ImmutableList<String> photoFbids;
    @JsonProperty("place")
    public final String place;
    @JsonProperty("privacy")
    public final String privacy;
    @JsonProperty("school_hub_id")
    public final String schoolHubId;
    @JsonProperty("school_type")
    public final String schoolType;
    @JsonProperty("should_update_relationship_status")
    public final boolean shouldUpdateRelationshipStatus;
    @JsonProperty("start_date")
    public final String startDate;
    @JsonProperty("story")
    public final String story;
    @JsonProperty("surface")
    public final String surface;
    @JsonProperty("tags")
    public final ImmutableList<String> tags;
    @JsonProperty("user_id")
    public final String userId;

    /* compiled from: place_likelihood */
    final class C04641 implements Creator<ComposerLifeEventParam> {
        C04641() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ComposerLifeEventParam(parcel);
        }

        public final Object[] newArray(int i) {
            return new ComposerLifeEventParam[i];
        }
    }

    /* compiled from: place_likelihood */
    public class Builder {
        public String f7842a;
        public String f7843b;
        public String f7844c;
        public String f7845d;
        public String f7846e;
        public String f7847f;
        public String f7848g;
        public String f7849h;
        public String f7850i;
        public String f7851j;
        public ImmutableList<String> f7852k;
        public ImmutableList<String> f7853l;
        public GraphQLLifeEventAPIIdentifier f7854m;
        public boolean f7855n;
        public boolean f7856o;
        public String f7857p;
        public String f7858q;
        public boolean f7859r;
        public String f7860s;

        public Builder() {
            this.f7852k = RegularImmutableList.a;
            this.f7853l = RegularImmutableList.a;
        }

        public final ComposerLifeEventParam m11268a() {
            Preconditions.checkNotNull(this.f7842a);
            Preconditions.checkNotNull(this.f7843b);
            Preconditions.checkNotNull(this.f7844c);
            Preconditions.checkNotNull(this.f7845d);
            Preconditions.checkNotNull(this.f7849h);
            Preconditions.checkNotNull(this.f7851j);
            Preconditions.checkNotNull(this.f7854m);
            return new ComposerLifeEventParam(this);
        }

        public Builder(ComposerLifeEventParam composerLifeEventParam) {
            this.f7842a = composerLifeEventParam.composerSessionId;
            this.f7843b = composerLifeEventParam.userId;
            this.f7844c = composerLifeEventParam.iconId;
            this.f7845d = composerLifeEventParam.description;
            this.f7846e = composerLifeEventParam.story;
            this.f7847f = composerLifeEventParam.startDate;
            this.f7848g = composerLifeEventParam.endDate;
            this.f7849h = composerLifeEventParam.surface;
            this.f7850i = composerLifeEventParam.place;
            this.f7851j = composerLifeEventParam.privacy;
            this.f7852k = composerLifeEventParam.tags;
            this.f7853l = composerLifeEventParam.photoFbids;
            this.f7854m = composerLifeEventParam.lifeEventType;
            this.f7855n = composerLifeEventParam.shouldUpdateRelationshipStatus;
            this.f7856o = composerLifeEventParam.isGraduated;
            this.f7857p = composerLifeEventParam.schoolType;
            this.f7858q = composerLifeEventParam.schoolHubId;
            this.f7859r = composerLifeEventParam.isCurrent;
            this.f7860s = composerLifeEventParam.employerHubId;
        }

        public final Builder m11269b(ImmutableList<String> immutableList) {
            this.f7853l = immutableList;
            return this;
        }

        public static String m11267c(Date date) {
            if (date == null) {
                return null;
            }
            StringBuilder append = new StringBuilder("{\"year\":").append(date.m7933a());
            append.append(",\"month\":").append(date.m7934b() == null ? "null" : String.valueOf(date.m7934b()));
            append.append(",\"day\":").append(date.m7935c() == null ? "null" : String.valueOf(date.m7935c()));
            return append.append("}").toString();
        }
    }

    @JsonIgnore
    private ComposerLifeEventParam() {
        this(new Builder());
    }

    @JsonIgnore
    public ComposerLifeEventParam(Builder builder) {
        this.composerSessionId = builder.f7842a;
        this.userId = builder.f7843b;
        this.iconId = builder.f7844c;
        this.description = builder.f7845d;
        this.story = builder.f7846e;
        this.startDate = builder.f7847f;
        this.endDate = builder.f7848g;
        this.surface = builder.f7849h;
        this.place = builder.f7850i;
        this.privacy = builder.f7851j;
        this.tags = builder.f7852k;
        this.photoFbids = builder.f7853l;
        this.lifeEventType = builder.f7854m;
        this.shouldUpdateRelationshipStatus = builder.f7855n;
        this.isGraduated = builder.f7856o;
        this.schoolType = builder.f7857p;
        this.schoolHubId = builder.f7858q;
        this.isCurrent = builder.f7859r;
        this.employerHubId = builder.f7860s;
    }

    @JsonIgnore
    public ComposerLifeEventParam(Parcel parcel) {
        this.composerSessionId = parcel.readString();
        this.userId = parcel.readString();
        this.iconId = parcel.readString();
        this.description = parcel.readString();
        this.story = parcel.readString();
        this.startDate = parcel.readString();
        this.endDate = parcel.readString();
        this.surface = parcel.readString();
        this.place = parcel.readString();
        this.privacy = parcel.readString();
        this.tags = ImmutableList.copyOf(parcel.createStringArrayList());
        this.photoFbids = ImmutableList.copyOf(parcel.createStringArrayList());
        this.lifeEventType = GraphQLLifeEventAPIIdentifier.fromString(parcel.readString());
        this.shouldUpdateRelationshipStatus = ParcelUtil.a(parcel);
        this.isGraduated = ParcelUtil.a(parcel);
        this.schoolType = parcel.readString();
        this.schoolHubId = parcel.readString();
        this.isCurrent = ParcelUtil.a(parcel);
        this.employerHubId = parcel.readString();
    }

    @JsonIgnore
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.composerSessionId);
        parcel.writeString(this.userId);
        parcel.writeString(this.iconId);
        parcel.writeString(this.description);
        parcel.writeString(this.story);
        parcel.writeString(this.startDate);
        parcel.writeString(this.endDate);
        parcel.writeString(this.surface);
        parcel.writeString(this.place);
        parcel.writeString(this.privacy);
        parcel.writeStringList(this.tags);
        parcel.writeStringList(this.photoFbids);
        parcel.writeString(this.lifeEventType.toString());
        ParcelUtil.a(parcel, this.shouldUpdateRelationshipStatus);
        ParcelUtil.a(parcel, this.isGraduated);
        parcel.writeString(this.schoolType);
        parcel.writeString(this.schoolHubId);
        ParcelUtil.a(parcel, this.isCurrent);
        parcel.writeString(this.employerHubId);
    }

    @JsonIgnore
    public int describeContents() {
        return 0;
    }
}
