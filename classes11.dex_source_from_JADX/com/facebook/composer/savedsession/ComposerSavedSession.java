package com.facebook.composer.savedsession;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.composer.model.Composition;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.intent.ComposerPageData;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.model.ComposerLocation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Preconditions;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = ComposerSavedSessionDeserializer.class)
@JsonSerialize(using = ComposerSavedSessionSerializer.class)
/* compiled from: fetchedFromCache */
public class ComposerSavedSession implements Parcelable {
    @JsonIgnore
    public static final Creator<ComposerSavedSession> CREATOR = new C08721();
    @JsonProperty("composition")
    public final Composition composition;
    @JsonProperty("configuration")
    public final ComposerConfiguration configuration;
    @JsonProperty("creation_time_ms")
    public final long creationTimeMs;
    @JsonProperty("load_attempts")
    public final int loadAttempts;
    @JsonProperty("page_data")
    public final ComposerPageData pageData;
    @JsonProperty("photos_enabled")
    public final boolean photosEnabled;
    @JsonProperty("plugin_state")
    public final String pluginState;
    @JsonProperty("privacy_has_changed")
    public final boolean privacyHasChanged;
    @JsonProperty("privacy_override")
    public final GraphQLPrivacyOption privacyOverride;
    @JsonProperty("session_id")
    public final String sessionId;
    @JsonProperty("target_data")
    public final ComposerTargetData targetData;
    @JsonProperty("version")
    public final int version;
    @JsonProperty("viewer_coordinates")
    public final ComposerLocation viewerCoordinates;

    /* compiled from: fetchedFromCache */
    final class C08721 implements Creator<ComposerSavedSession> {
        C08721() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ComposerSavedSession(parcel);
        }

        public final Object[] newArray(int i) {
            return new ComposerSavedSession[i];
        }
    }

    /* compiled from: fetchedFromCache */
    public class Builder {
        public int f6914a;
        public int f6915b = 60;
        public long f6916c;
        public String f6917d;
        public ComposerConfiguration f6918e;
        public Composition f6919f;
        public ComposerLocation f6920g;
        public ComposerTargetData f6921h;
        public ComposerPageData f6922i;
        public GraphQLPrivacyOption f6923j;
        public boolean f6924k = false;
        public boolean f6925l;
        public String f6926m;

        public Builder(String str, ComposerConfiguration composerConfiguration, Composition composition) {
            this.f6917d = str;
            this.f6918e = composerConfiguration;
            this.f6919f = composition;
        }

        public Builder(ComposerSavedSession composerSavedSession) {
            this.f6915b = composerSavedSession.version;
            this.f6916c = composerSavedSession.creationTimeMs;
            this.f6914a = composerSavedSession.loadAttempts;
            this.f6917d = composerSavedSession.sessionId;
            this.f6918e = composerSavedSession.configuration;
            this.f6919f = composerSavedSession.composition;
            this.f6920g = composerSavedSession.viewerCoordinates;
            this.f6921h = composerSavedSession.targetData;
            this.f6922i = composerSavedSession.pageData;
            this.f6923j = composerSavedSession.privacyOverride;
            this.f6925l = composerSavedSession.privacyHasChanged;
            this.f6926m = composerSavedSession.pluginState;
        }

        public final Builder m8236a(long j) {
            this.f6916c = j;
            return this;
        }

        public final Builder m8235a(int i) {
            this.f6914a = i;
            return this;
        }

        public final Builder m8239a(ComposerLocation composerLocation) {
            this.f6920g = composerLocation;
            return this;
        }

        public final Builder m8238a(ComposerTargetData composerTargetData) {
            this.f6921h = composerTargetData;
            return this;
        }

        public final Builder m8237a(GraphQLPrivacyOption graphQLPrivacyOption) {
            this.f6923j = graphQLPrivacyOption;
            return this;
        }

        public final Builder m8241a(boolean z) {
            this.f6925l = z;
            return this;
        }

        public final Builder m8240a(String str) {
            this.f6926m = str;
            return this;
        }

        public final ComposerSavedSession m8242a() {
            return new ComposerSavedSession(this);
        }
    }

    @JsonIgnore
    private ComposerSavedSession() {
        this.version = 0;
        this.creationTimeMs = 0;
        this.loadAttempts = 0;
        this.sessionId = null;
        this.configuration = null;
        this.composition = null;
        this.viewerCoordinates = null;
        this.targetData = null;
        this.pageData = null;
        this.privacyOverride = null;
        this.photosEnabled = false;
        this.privacyHasChanged = false;
        this.pluginState = null;
    }

    @JsonIgnore
    public ComposerSavedSession(Builder builder) {
        this.version = builder.f6915b;
        this.creationTimeMs = builder.f6916c;
        this.loadAttempts = builder.f6914a;
        this.sessionId = (String) Preconditions.checkNotNull(builder.f6917d);
        this.configuration = (ComposerConfiguration) Preconditions.checkNotNull(builder.f6918e);
        this.composition = (Composition) Preconditions.checkNotNull(builder.f6919f);
        this.viewerCoordinates = builder.f6920g;
        this.targetData = builder.f6921h;
        this.pageData = builder.f6922i;
        this.privacyOverride = builder.f6923j;
        this.photosEnabled = builder.f6924k;
        this.privacyHasChanged = builder.f6925l;
        this.pluginState = builder.f6926m;
    }

    @JsonIgnore
    public ComposerSavedSession(Parcel parcel) {
        this.version = parcel.readInt();
        this.creationTimeMs = parcel.readLong();
        this.loadAttempts = parcel.readInt();
        this.sessionId = parcel.readString();
        this.configuration = (ComposerConfiguration) parcel.readParcelable(ComposerConfiguration.class.getClassLoader());
        this.composition = (Composition) parcel.readParcelable(Composition.class.getClassLoader());
        this.viewerCoordinates = (ComposerLocation) parcel.readParcelable(ComposerLocation.class.getClassLoader());
        this.targetData = (ComposerTargetData) parcel.readParcelable(ComposerTargetData.class.getClassLoader());
        this.pageData = (ComposerPageData) parcel.readParcelable(ComposerPageData.class.getClassLoader());
        this.privacyOverride = (GraphQLPrivacyOption) FlatBufferModelHelper.a(parcel);
        this.photosEnabled = ParcelUtil.a(parcel);
        this.privacyHasChanged = ParcelUtil.a(parcel);
        this.pluginState = parcel.readString();
    }

    @JsonIgnore
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.version);
        parcel.writeLong(this.creationTimeMs);
        parcel.writeInt(this.loadAttempts);
        parcel.writeString(this.sessionId);
        parcel.writeParcelable(this.configuration, i);
        parcel.writeParcelable(this.composition, i);
        parcel.writeParcelable(this.viewerCoordinates, i);
        parcel.writeParcelable(this.targetData, i);
        parcel.writeParcelable(this.pageData, i);
        FlatBufferModelHelper.a(parcel, this.privacyOverride);
        ParcelUtil.a(parcel, this.photosEnabled);
        ParcelUtil.a(parcel, this.privacyHasChanged);
        parcel.writeString(this.pluginState);
    }

    @JsonIgnore
    public int describeContents() {
        return 0;
    }
}
