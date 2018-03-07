package com.facebook.ipc.composer.intent;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = ComposerShareParamsDeserializer.class)
@JsonSerialize(using = ComposerShareParamsSerializer.class)
/* compiled from: load */
public class ComposerShareParams implements Parcelable {
    @JsonIgnore
    public static final Creator<ComposerShareParams> CREATOR = new C07371();
    @JsonProperty("include_reshare_context")
    public final boolean includeReshareContext;
    @JsonProperty("link_for_share")
    @Nullable
    public final String linkForShare;
    @JsonProperty("quote_text")
    @Nullable
    public final String quoteText;
    @JsonProperty("share_preview")
    public final SharePreview sharePreview;
    @JsonProperty("share_tracking")
    public final String shareTracking;
    @JsonProperty("shareable")
    @Nullable
    public final GraphQLEntity shareable;

    /* compiled from: load */
    final class C07371 implements Creator<ComposerShareParams> {
        C07371() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ComposerShareParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new ComposerShareParams[i];
        }
    }

    /* compiled from: load */
    public final class Builder {
        public boolean f11559a;
        @Nullable
        public final GraphQLEntity f11560b;
        @Nullable
        public final String f11561c;
        @Nullable
        public SharePreview f11562d;
        @Nullable
        public String f11563e;
        @Nullable
        public String f11564f;

        private Builder(@Nullable GraphQLEntity graphQLEntity, @Nullable String str) {
            this.f11560b = graphQLEntity;
            this.f11561c = str;
        }

        public Builder(ComposerShareParams composerShareParams) {
            this.f11560b = composerShareParams.shareable;
            this.f11561c = composerShareParams.linkForShare;
            this.f11562d = composerShareParams.sharePreview;
            this.f11563e = composerShareParams.shareTracking;
            this.f11564f = composerShareParams.quoteText;
            this.f11559a = composerShareParams.includeReshareContext;
        }

        public static Builder m18242a() {
            return new Builder(null, null);
        }

        public static Builder m18244a(String str) {
            return new Builder(null, str);
        }

        public static Builder m18243a(GraphQLEntity graphQLEntity) {
            return new Builder(graphQLEntity, null);
        }

        public final Builder m18245a(@Nullable SharePreview sharePreview) {
            this.f11562d = sharePreview;
            return this;
        }

        public final Builder m18246b(@Nullable String str) {
            this.f11563e = str;
            return this;
        }

        public final Builder m18248c(@Nullable String str) {
            this.f11564f = str;
            return this;
        }

        public final ComposerShareParams m18247b() {
            return new ComposerShareParams(this);
        }
    }

    /* compiled from: load */
    public interface ProvidesShareParams {
        ComposerShareParams m18249q();
    }

    @JsonIgnore
    private ComposerShareParams() {
        this(Builder.m18242a());
    }

    @JsonIgnore
    public ComposerShareParams(Builder builder) {
        this.sharePreview = builder.f11562d;
        this.shareable = builder.f11560b;
        this.linkForShare = builder.f11561c;
        this.shareTracking = builder.f11563e;
        this.quoteText = builder.f11564f;
        this.includeReshareContext = builder.f11559a;
        if (this.linkForShare != null && this.shareable != null) {
            throw new IllegalArgumentException("A story can have only one type of attachment: Can't share both a link and a shareable entity");
        }
    }

    @JsonIgnore
    public ComposerShareParams(Parcel parcel) {
        this.sharePreview = (SharePreview) parcel.readParcelable(SharePreview.class.getClassLoader());
        this.shareable = (GraphQLEntity) FlatBufferModelHelper.a(parcel);
        this.linkForShare = parcel.readString();
        this.shareTracking = parcel.readString();
        this.quoteText = parcel.readString();
        this.includeReshareContext = ParcelUtil.a(parcel);
    }

    @JsonIgnore
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.sharePreview, i);
        FlatBufferModelHelper.a(parcel, this.shareable);
        parcel.writeString(this.linkForShare);
        parcel.writeString(this.shareTracking);
        parcel.writeString(this.quoteText);
        ParcelUtil.a(parcel, this.includeReshareContext);
    }

    @JsonIgnore
    public int describeContents() {
        return 0;
    }
}
