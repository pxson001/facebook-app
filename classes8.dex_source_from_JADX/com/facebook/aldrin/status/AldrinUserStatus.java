package com.facebook.aldrin.status;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.graphql.enums.GraphQLTosRegionCodeEnum;
import com.facebook.graphql.enums.GraphQLTosTransitionTypeEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = AldrinUserStatusDeserializer.class)
@Immutable
@JsonSerialize(using = AldrinUserStatusSerializer.class)
/* compiled from: left_edge */
public class AldrinUserStatus implements Parcelable {
    public static final Creator<AldrinUserStatus> CREATOR = new C11051();
    @JsonProperty("current_region")
    public final GraphQLTosRegionCodeEnum currentRegion;
    @JsonProperty("effective_region")
    public final GraphQLTosRegionCodeEnum effectiveRegion;
    @JsonProperty("fetch_time")
    public final long fetchTime;
    @JsonProperty("is_cu")
    public final boolean isCu;
    @JsonProperty("should_be_cu")
    public final boolean shouldBeCu;
    @JsonProperty("tos_cookies_url")
    public final String tosCookiesUrl;
    @JsonProperty("tos_privacy_url")
    public final String tosPrivacyUrl;
    @JsonProperty("tos_terms_url")
    public final String tosTermsUrl;
    @JsonProperty("tos_transition_type")
    public final GraphQLTosTransitionTypeEnum tosTransitionType;
    @JsonProperty("tos_version")
    public final String tosVersion;
    @JsonProperty("user_id")
    public final String userId;

    /* compiled from: left_edge */
    final class C11051 implements Creator<AldrinUserStatus> {
        C11051() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new AldrinUserStatus(parcel);
        }

        public final Object[] newArray(int i) {
            return new AldrinUserStatus[i];
        }
    }

    public AldrinUserStatus() {
        this.effectiveRegion = GraphQLTosRegionCodeEnum.GENERAL;
        this.currentRegion = GraphQLTosRegionCodeEnum.GENERAL;
        this.tosTransitionType = GraphQLTosTransitionTypeEnum.NOOP;
        this.isCu = false;
        this.shouldBeCu = false;
        this.tosTermsUrl = "";
        this.tosPrivacyUrl = "";
        this.tosCookiesUrl = "";
        this.tosVersion = "";
        this.fetchTime = 0;
        this.userId = null;
    }

    public AldrinUserStatus(AldrinUserStatusBuilder aldrinUserStatusBuilder) {
        this.effectiveRegion = aldrinUserStatusBuilder.f10374a;
        this.currentRegion = aldrinUserStatusBuilder.f10375b;
        this.tosTransitionType = aldrinUserStatusBuilder.f10376c;
        this.isCu = aldrinUserStatusBuilder.f10377d;
        this.shouldBeCu = aldrinUserStatusBuilder.f10378e;
        this.tosTermsUrl = aldrinUserStatusBuilder.f10379f;
        this.tosPrivacyUrl = aldrinUserStatusBuilder.f10380g;
        this.tosCookiesUrl = aldrinUserStatusBuilder.f10381h;
        this.tosVersion = aldrinUserStatusBuilder.f10382i;
        this.fetchTime = aldrinUserStatusBuilder.f10383j;
        this.userId = aldrinUserStatusBuilder.f10384k;
    }

    public AldrinUserStatus(Parcel parcel) {
        this.effectiveRegion = (GraphQLTosRegionCodeEnum) ParcelUtil.c(parcel, GraphQLTosRegionCodeEnum.class);
        this.currentRegion = (GraphQLTosRegionCodeEnum) ParcelUtil.c(parcel, GraphQLTosRegionCodeEnum.class);
        this.tosTransitionType = (GraphQLTosTransitionTypeEnum) ParcelUtil.c(parcel, GraphQLTosTransitionTypeEnum.class);
        this.isCu = ParcelUtil.a(parcel);
        this.shouldBeCu = ParcelUtil.a(parcel);
        this.tosTermsUrl = parcel.readString();
        this.tosPrivacyUrl = parcel.readString();
        this.tosCookiesUrl = parcel.readString();
        this.tosVersion = parcel.readString();
        this.fetchTime = parcel.readLong();
        this.userId = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtil.a(parcel, this.effectiveRegion);
        ParcelUtil.a(parcel, this.currentRegion);
        ParcelUtil.a(parcel, this.tosTransitionType);
        ParcelUtil.a(parcel, this.isCu);
        ParcelUtil.a(parcel, this.shouldBeCu);
        parcel.writeString(this.tosTermsUrl);
        parcel.writeString(this.tosPrivacyUrl);
        parcel.writeString(this.tosCookiesUrl);
        parcel.writeString(this.tosVersion);
        parcel.writeLong(this.fetchTime);
        parcel.writeString(this.userId);
    }
}
