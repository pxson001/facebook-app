package com.facebook.ipc.composer.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Preconditions;

@AutoGenJsonSerializer
@JsonDeserialize(using = Deserializer.class)
@JsonSerialize(using = ComposerLaunchLoggingParamsSerializer.class)
/* compiled from: TODAY_RICH */
public class ComposerLaunchLoggingParams implements Parcelable {
    public static final Creator<ComposerLaunchLoggingParams> CREATOR = new C13281();
    public final ComposerEntryPicker f13954a;
    public final String f13955b;
    public final ComposerSourceSurface f13956c;

    /* compiled from: TODAY_RICH */
    final class C13281 implements Creator<ComposerLaunchLoggingParams> {
        C13281() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ComposerLaunchLoggingParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new ComposerLaunchLoggingParams[i];
        }
    }

    @AutoGenJsonDeserializer
    @JsonDeserialize(using = ComposerLaunchLoggingParams_BuilderDeserializer.class)
    /* compiled from: TODAY_RICH */
    public class Builder {
        private static final ComposerEntryPicker f13948a = ComposerEntryPicker.NONE;
        private static final ComposerSourceSurface f13949b = ComposerSourceSurface.UNKNOWN;
        public ComposerEntryPicker f13950c = f13948a;
        public String f13951d = "";
        public ComposerSourceSurface f13952e = f13949b;

        static {
            C1329xe6e694ca c1329xe6e694ca = new C1329xe6e694ca();
            C1330xde21b1fc c1330xde21b1fc = new C1330xde21b1fc();
        }

        public Builder(ComposerLaunchLoggingParams composerLaunchLoggingParams) {
            Preconditions.checkNotNull(composerLaunchLoggingParams);
            if (composerLaunchLoggingParams instanceof ComposerLaunchLoggingParams) {
                composerLaunchLoggingParams = composerLaunchLoggingParams;
                this.f13950c = composerLaunchLoggingParams.f13954a;
                this.f13951d = composerLaunchLoggingParams.f13955b;
                this.f13952e = composerLaunchLoggingParams.f13956c;
                return;
            }
            this.f13950c = composerLaunchLoggingParams.getEntryPicker();
            this.f13951d = composerLaunchLoggingParams.getEntryPointDescription();
            this.f13952e = composerLaunchLoggingParams.getSourceSurface();
        }

        public final ComposerLaunchLoggingParams m23310a() {
            return new ComposerLaunchLoggingParams(this);
        }

        @JsonProperty("entry_picker")
        public Builder setEntryPicker(ComposerEntryPicker composerEntryPicker) {
            this.f13950c = composerEntryPicker;
            return this;
        }

        @JsonProperty("entry_point_description")
        public Builder setEntryPointDescription(String str) {
            this.f13951d = str;
            return this;
        }

        @JsonProperty("source_surface")
        public Builder setSourceSurface(ComposerSourceSurface composerSourceSurface) {
            this.f13952e = composerSourceSurface;
            return this;
        }
    }

    /* compiled from: TODAY_RICH */
    class Deserializer extends JsonDeserializer<ComposerLaunchLoggingParams> {
        private static final ComposerLaunchLoggingParams_BuilderDeserializer f13953a = new ComposerLaunchLoggingParams_BuilderDeserializer();

        private Deserializer() {
        }

        public Object m23311a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return ((Builder) f13953a.a(jsonParser, deserializationContext)).m23310a();
        }
    }

    public ComposerLaunchLoggingParams(Builder builder) {
        this.f13954a = (ComposerEntryPicker) Preconditions.checkNotNull(builder.f13950c);
        this.f13955b = (String) Preconditions.checkNotNull(builder.f13951d);
        this.f13956c = (ComposerSourceSurface) Preconditions.checkNotNull(builder.f13952e);
    }

    public ComposerLaunchLoggingParams(Parcel parcel) {
        this.f13954a = ComposerEntryPicker.valueOf(parcel.readString());
        this.f13955b = parcel.readString();
        this.f13956c = ComposerSourceSurface.valueOf(parcel.readString());
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder m23312a(ComposerLaunchLoggingParams composerLaunchLoggingParams) {
        return new Builder(composerLaunchLoggingParams);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f13954a.name());
        parcel.writeString(this.f13955b);
        parcel.writeString(this.f13956c.name());
    }

    public int describeContents() {
        return 0;
    }

    @JsonProperty("entry_picker")
    public ComposerEntryPicker getEntryPicker() {
        return this.f13954a;
    }

    @JsonProperty("entry_point_description")
    public String getEntryPointDescription() {
        return this.f13955b;
    }

    @JsonProperty("source_surface")
    public ComposerSourceSurface getSourceSurface() {
        return this.f13956c;
    }
}
