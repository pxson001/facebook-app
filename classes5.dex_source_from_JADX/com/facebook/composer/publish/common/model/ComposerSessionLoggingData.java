package com.facebook.composer.publish.common.model;

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
@JsonSerialize(using = ComposerSessionLoggingDataSerializer.class)
/* compiled from: activity_admin_info */
public class ComposerSessionLoggingData implements Parcelable {
    public static final Creator<ComposerSessionLoggingData> CREATOR = new C10901();
    public final long f11595a;
    public final int f11596b;
    public final int f11597c;

    /* compiled from: activity_admin_info */
    final class C10901 implements Creator<ComposerSessionLoggingData> {
        C10901() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ComposerSessionLoggingData(parcel);
        }

        public final Object[] newArray(int i) {
            return new ComposerSessionLoggingData[i];
        }
    }

    @AutoGenJsonDeserializer
    @JsonDeserialize(using = ComposerSessionLoggingData_BuilderDeserializer.class)
    /* compiled from: activity_admin_info */
    public class Builder {
        public long f11591a;
        public int f11592b;
        public int f11593c;

        public Builder(ComposerSessionLoggingData composerSessionLoggingData) {
            Preconditions.checkNotNull(composerSessionLoggingData);
            if (composerSessionLoggingData instanceof ComposerSessionLoggingData) {
                composerSessionLoggingData = composerSessionLoggingData;
                this.f11591a = composerSessionLoggingData.f11595a;
                this.f11592b = composerSessionLoggingData.f11596b;
                this.f11593c = composerSessionLoggingData.f11597c;
                return;
            }
            this.f11591a = composerSessionLoggingData.getCompositionDuration();
            this.f11592b = composerSessionLoggingData.getNumberOfPastes();
            this.f11593c = composerSessionLoggingData.getNumberOfKeystrokes();
        }

        public final ComposerSessionLoggingData m19720a() {
            return new ComposerSessionLoggingData(this);
        }

        @JsonProperty("composition_duration")
        public Builder setCompositionDuration(long j) {
            this.f11591a = j;
            return this;
        }

        @JsonProperty("number_of_copy_pastes")
        public Builder setNumberOfCopyPastes(int i) {
            this.f11592b = i;
            return this;
        }

        @JsonProperty("number_of_keystrokes")
        public Builder setNumberOfKeystrokes(int i) {
            this.f11593c = i;
            return this;
        }
    }

    /* compiled from: activity_admin_info */
    class Deserializer extends JsonDeserializer<ComposerSessionLoggingData> {
        private static final ComposerSessionLoggingData_BuilderDeserializer f11594a = new ComposerSessionLoggingData_BuilderDeserializer();

        private Deserializer() {
        }

        public Object m19721a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return ((Builder) f11594a.a(jsonParser, deserializationContext)).m19720a();
        }
    }

    public ComposerSessionLoggingData(Builder builder) {
        this.f11595a = ((Long) Preconditions.checkNotNull(Long.valueOf(builder.f11591a))).longValue();
        this.f11596b = ((Integer) Preconditions.checkNotNull(Integer.valueOf(builder.f11592b))).intValue();
        this.f11597c = ((Integer) Preconditions.checkNotNull(Integer.valueOf(builder.f11593c))).intValue();
    }

    public ComposerSessionLoggingData(Parcel parcel) {
        this.f11595a = parcel.readLong();
        this.f11596b = parcel.readInt();
        this.f11597c = parcel.readInt();
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder m19722a(ComposerSessionLoggingData composerSessionLoggingData) {
        return new Builder(composerSessionLoggingData);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f11595a);
        parcel.writeInt(this.f11596b);
        parcel.writeInt(this.f11597c);
    }

    public int describeContents() {
        return 0;
    }

    @JsonProperty("composition_duration")
    public long getCompositionDuration() {
        return this.f11595a;
    }

    @JsonProperty("number_of_copy_pastes")
    public int getNumberOfPastes() {
        return this.f11596b;
    }

    @JsonProperty("number_of_keystrokes")
    public int getNumberOfKeystrokes() {
        return this.f11597c;
    }
}
