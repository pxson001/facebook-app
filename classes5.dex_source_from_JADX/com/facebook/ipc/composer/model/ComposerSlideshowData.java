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
import javax.annotation.Nullable;

@AutoGenJsonSerializer
@JsonDeserialize(using = Deserializer.class)
@JsonSerialize(using = ComposerSlideshowDataSerializer.class)
/* compiled from: TKEY; */
public class ComposerSlideshowData implements Parcelable {
    public static final Creator<ComposerSlideshowData> CREATOR = new C13331();
    @Nullable
    public final String f13972a;

    /* compiled from: TKEY; */
    final class C13331 implements Creator<ComposerSlideshowData> {
        C13331() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ComposerSlideshowData(parcel);
        }

        public final Object[] newArray(int i) {
            return new ComposerSlideshowData[i];
        }
    }

    @AutoGenJsonDeserializer
    @JsonDeserialize(using = ComposerSlideshowData_BuilderDeserializer.class)
    /* compiled from: TKEY; */
    public class Builder {
        @Nullable
        public String f13970a;

        public Builder(ComposerSlideshowData composerSlideshowData) {
            Preconditions.checkNotNull(composerSlideshowData);
            if (composerSlideshowData instanceof ComposerSlideshowData) {
                this.f13970a = composerSlideshowData.f13972a;
            } else {
                this.f13970a = composerSlideshowData.getAudioTrackId();
            }
        }

        public final ComposerSlideshowData m23349a() {
            return new ComposerSlideshowData(this);
        }

        @JsonProperty("audio_track_id")
        public Builder setAudioTrackId(@Nullable String str) {
            this.f13970a = str;
            return this;
        }
    }

    /* compiled from: TKEY; */
    class Deserializer extends JsonDeserializer<ComposerSlideshowData> {
        private static final ComposerSlideshowData_BuilderDeserializer f13971a = new ComposerSlideshowData_BuilderDeserializer();

        private Deserializer() {
        }

        public Object m23350a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return ((Builder) f13971a.a(jsonParser, deserializationContext)).m23349a();
        }
    }

    public ComposerSlideshowData(Builder builder) {
        this.f13972a = builder.f13970a;
    }

    public ComposerSlideshowData(Parcel parcel) {
        if (parcel.readInt() == 0) {
            this.f13972a = null;
        } else {
            this.f13972a = parcel.readString();
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder m23351a(ComposerSlideshowData composerSlideshowData) {
        return new Builder(composerSlideshowData);
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (this.f13972a == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeString(this.f13972a);
    }

    public int describeContents() {
        return 0;
    }

    @JsonProperty("audio_track_id")
    @Nullable
    public String getAudioTrackId() {
        return this.f13972a;
    }
}
