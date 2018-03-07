package com.facebook.ipc.composer.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = MarketplaceCrossPostSettingModelDeserializer.class)
@JsonSerialize(using = MarketplaceCrossPostSettingModelSerializer.class)
/* compiled from: TIMELINE_PROFILE_PICTURE_CLICK */
public class MarketplaceCrossPostSettingModel implements Parcelable {
    public static final Creator<MarketplaceCrossPostSettingModel> CREATOR = new C13361();
    @JsonProperty("check_box_label")
    public final String checkBoxLabel;
    @JsonProperty("intercept_accept_button_label")
    public final String interceptAcceptButtonLabel;
    @JsonProperty("intercept_decline_button_label")
    public final String interceptDeclineButtonLabel;
    @JsonProperty("is_compulsory")
    public final Integer isCompulsory;
    @JsonProperty("is_enabled")
    public final Integer isEnabled;
    @JsonProperty("nux_label")
    public final String nuxLabel;
    @JsonProperty("shold_show_intercept")
    public final Integer shouldShowIntercept;
    @JsonProperty("shold_show_nux")
    public final Integer shouldShowNux;
    @JsonProperty("upsell_accept_button_label")
    public final String upsellAcceptButtonLabel;
    @JsonProperty("upsell_decline_button_label")
    public final String upsellDeclineButtonLabel;
    @JsonProperty("upsell_people_label")
    public final String upsellPeopleLabel;
    @JsonProperty("upsell_pin_label")
    public final String upsellPinLabel;
    @JsonProperty("upsell_Time_label")
    public final String upsellTimeLabel;
    @JsonProperty("upsell_title_label")
    public final String upsellTitleLabel;

    /* compiled from: TIMELINE_PROFILE_PICTURE_CLICK */
    final class C13361 implements Creator<MarketplaceCrossPostSettingModel> {
        C13361() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new MarketplaceCrossPostSettingModel(parcel);
        }

        public final Object[] newArray(int i) {
            return new MarketplaceCrossPostSettingModel[i];
        }
    }

    /* compiled from: TIMELINE_PROFILE_PICTURE_CLICK */
    public class Builder {
        public boolean f13984a;
        public boolean f13985b;
        public boolean f13986c;
        public boolean f13987d;
        public String f13988e;
        public String f13989f;
        public String f13990g;
        public String f13991h;
        public String f13992i;
        public String f13993j;
        public String f13994k;
        public String f13995l;
        public String f13996m;
        public String f13997n;
    }

    @JsonIgnore
    private MarketplaceCrossPostSettingModel() {
        this(new Builder());
    }

    public MarketplaceCrossPostSettingModel(Builder builder) {
        int i;
        int i2 = 1;
        this.isEnabled = Integer.valueOf(builder.f13984a ? 1 : 0);
        if (builder.f13985b) {
            i = 1;
        } else {
            i = 0;
        }
        this.shouldShowIntercept = Integer.valueOf(i);
        if (builder.f13986c) {
            i = 1;
        } else {
            i = 0;
        }
        this.shouldShowNux = Integer.valueOf(i);
        if (!builder.f13987d) {
            i2 = 0;
        }
        this.isCompulsory = Integer.valueOf(i2);
        this.nuxLabel = builder.f13988e;
        this.checkBoxLabel = builder.f13989f;
        this.upsellTitleLabel = builder.f13990g;
        this.upsellPeopleLabel = builder.f13991h;
        this.upsellPinLabel = builder.f13992i;
        this.upsellTimeLabel = builder.f13993j;
        this.interceptAcceptButtonLabel = builder.f13994k;
        this.interceptDeclineButtonLabel = builder.f13995l;
        this.upsellAcceptButtonLabel = builder.f13996m;
        this.upsellDeclineButtonLabel = builder.f13997n;
    }

    public MarketplaceCrossPostSettingModel(Parcel parcel) {
        this.isEnabled = Integer.valueOf(parcel.readInt());
        this.shouldShowIntercept = Integer.valueOf(parcel.readInt());
        this.shouldShowNux = Integer.valueOf(parcel.readInt());
        this.isCompulsory = Integer.valueOf(parcel.readInt());
        this.nuxLabel = parcel.readString();
        this.checkBoxLabel = parcel.readString();
        this.upsellTitleLabel = parcel.readString();
        this.upsellPeopleLabel = parcel.readString();
        this.upsellPinLabel = parcel.readString();
        this.upsellTimeLabel = parcel.readString();
        this.interceptAcceptButtonLabel = parcel.readString();
        this.interceptDeclineButtonLabel = parcel.readString();
        this.upsellAcceptButtonLabel = parcel.readString();
        this.upsellDeclineButtonLabel = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public final Boolean m23374a() {
        boolean z = true;
        if (this.isEnabled.intValue() != 1) {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    public final Boolean m23375b() {
        boolean z = true;
        if (this.shouldShowIntercept.intValue() != 1) {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    public final Boolean m23376c() {
        boolean z = true;
        if (this.isCompulsory.intValue() != 1) {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.isEnabled.intValue());
        parcel.writeInt(this.shouldShowIntercept.intValue());
        parcel.writeInt(this.shouldShowNux.intValue());
        parcel.writeInt(this.isCompulsory.intValue());
        parcel.writeString(this.nuxLabel);
        parcel.writeString(this.checkBoxLabel);
        parcel.writeString(this.upsellTitleLabel);
        parcel.writeString(this.upsellPeopleLabel);
        parcel.writeString(this.upsellPinLabel);
        parcel.writeString(this.upsellTimeLabel);
        parcel.writeString(this.interceptAcceptButtonLabel);
        parcel.writeString(this.interceptDeclineButtonLabel);
        parcel.writeString(this.upsellAcceptButtonLabel);
        parcel.writeString(this.upsellDeclineButtonLabel);
    }
}
