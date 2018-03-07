package com.facebook.ipc.composer.intent;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.ipc.composer.intent.graphql.FetchComposerTargetDataPrivacyScopeInterfaces.ComposerTargetDataPrivacyScopeFields;
import com.facebook.ipc.composer.intent.graphql.FetchComposerTargetDataPrivacyScopeModels.ComposerTargetDataPrivacyScopeFieldsModel;
import com.facebook.ipc.composer.model.TargetType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = ComposerTargetDataDeserializer.class)
@JsonSerialize(using = ComposerTargetDataSerializer.class)
/* compiled from: link_menu_uri */
public class ComposerTargetData implements Parcelable {
    @JsonIgnore
    public static final Creator<ComposerTargetData> CREATOR = new C07391();
    public static final ComposerTargetData f11579a = new Builder(-1, TargetType.UNDIRECTED).m18263a();
    @JsonProperty("acts_as_target")
    public final boolean actsAsTarget;
    @JsonProperty("target_id")
    public final long targetId;
    @JsonProperty("target_name")
    public final String targetName;
    @JsonProperty("target_privacy")
    public final ComposerTargetDataPrivacyScopeFieldsModel targetPrivacy;
    @JsonProperty("target_profile_pic_url")
    public final String targetProfilePicUrl;
    @JsonProperty("target_type")
    public final TargetType targetType;

    /* compiled from: link_menu_uri */
    final class C07391 implements Creator<ComposerTargetData> {
        C07391() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ComposerTargetData(parcel);
        }

        public final Object[] newArray(int i) {
            return new ComposerTargetData[i];
        }
    }

    /* compiled from: link_menu_uri */
    public class Builder {
        public long f11573a = -1;
        public TargetType f11574b = TargetType.OTHER;
        public String f11575c = "";
        public String f11576d = "";
        public ComposerTargetDataPrivacyScopeFieldsModel f11577e = null;
        public boolean f11578f = false;

        public Builder(long j, TargetType targetType) {
            this.f11573a = j;
            if (targetType != null) {
                this.f11574b = targetType;
            }
        }

        public Builder(ComposerTargetData composerTargetData) {
            this.f11573a = composerTargetData.targetId;
            this.f11574b = composerTargetData.targetType;
            this.f11575c = composerTargetData.targetName;
            this.f11576d = composerTargetData.targetProfilePicUrl;
            this.f11577e = composerTargetData.targetPrivacy;
            this.f11578f = composerTargetData.actsAsTarget;
        }

        public final Builder m18262a(TargetType targetType) {
            this.f11574b = targetType;
            return this;
        }

        public final Builder m18261a(ComposerTargetDataPrivacyScopeFields composerTargetDataPrivacyScopeFields) {
            this.f11577e = ComposerTargetDataPrivacyScopeFieldsModel.m18312a(composerTargetDataPrivacyScopeFields);
            return this;
        }

        public final ComposerTargetData m18263a() {
            return new ComposerTargetData(this);
        }
    }

    /* compiled from: link_menu_uri */
    public interface ProvidesTargetData {
        ComposerTargetData m18264s();
    }

    @JsonIgnore
    private ComposerTargetData() {
        this(new Builder());
    }

    @JsonIgnore
    public ComposerTargetData(Builder builder) {
        this.targetId = builder.f11573a;
        this.targetType = builder.f11574b;
        this.targetName = builder.f11575c;
        this.targetProfilePicUrl = builder.f11576d;
        this.targetPrivacy = builder.f11577e;
        this.actsAsTarget = builder.f11578f;
    }

    @JsonIgnore
    public ComposerTargetData(Parcel parcel) {
        this.targetId = parcel.readLong();
        this.targetType = TargetType.fromString(parcel.readString());
        this.targetName = parcel.readString();
        this.targetProfilePicUrl = parcel.readString();
        this.targetPrivacy = (ComposerTargetDataPrivacyScopeFieldsModel) FlatBufferModelHelper.a(parcel);
        this.actsAsTarget = ParcelUtil.a(parcel);
    }

    @JsonIgnore
    public int describeContents() {
        return 0;
    }

    @JsonIgnore
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.targetId);
        parcel.writeString(this.targetType.toString());
        parcel.writeString(this.targetName);
        parcel.writeString(this.targetProfilePicUrl);
        FlatBufferModelHelper.a(parcel, this.targetPrivacy);
        ParcelUtil.a(parcel, this.actsAsTarget);
    }

    public final boolean m18265a() {
        return this.targetType == TargetType.PAGE && this.actsAsTarget;
    }

    public final boolean m18266b() {
        return this.targetType == TargetType.UNDIRECTED;
    }
}
