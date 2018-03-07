package com.facebook.ipc.composer.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.ipc.media.data.MediaData;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;

@AutoGenJsonSerializer
@JsonDeserialize(using = Deserializer.class)
@JsonSerialize(using = ComposerVideoTaggingInfoSerializer.class)
/* compiled from: TIMELINE_UNIT */
public class ComposerVideoTaggingInfo implements Parcelable {
    public static final Creator<ComposerVideoTaggingInfo> CREATOR = new C13351();
    private final ImmutableList<MediaData> f13981a;
    private final boolean f13982b;

    /* compiled from: TIMELINE_UNIT */
    final class C13351 implements Creator<ComposerVideoTaggingInfo> {
        C13351() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ComposerVideoTaggingInfo(parcel);
        }

        public final Object[] newArray(int i) {
            return new ComposerVideoTaggingInfo[i];
        }
    }

    @AutoGenJsonDeserializer
    @JsonDeserialize(using = ComposerVideoTaggingInfo_BuilderDeserializer.class)
    /* compiled from: TIMELINE_UNIT */
    public class Builder {
        public ImmutableList<MediaData> f13978a = RegularImmutableList.a;
        public boolean f13979b;

        public final ComposerVideoTaggingInfo m23368a() {
            return new ComposerVideoTaggingInfo(this);
        }

        @JsonProperty("frames")
        public Builder setFrames(ImmutableList<MediaData> immutableList) {
            this.f13978a = immutableList;
            return this;
        }

        @JsonProperty("has_faceboxes")
        public Builder setHasFaceboxes(boolean z) {
            this.f13979b = z;
            return this;
        }
    }

    /* compiled from: TIMELINE_UNIT */
    class Deserializer extends JsonDeserializer<ComposerVideoTaggingInfo> {
        private static final ComposerVideoTaggingInfo_BuilderDeserializer f13980a = new ComposerVideoTaggingInfo_BuilderDeserializer();

        private Deserializer() {
        }

        public Object m23369a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return ((Builder) f13980a.a(jsonParser, deserializationContext)).m23368a();
        }
    }

    public ComposerVideoTaggingInfo(Builder builder) {
        this.f13981a = (ImmutableList) Preconditions.checkNotNull(builder.f13978a);
        this.f13982b = ((Boolean) Preconditions.checkNotNull(Boolean.valueOf(builder.f13979b))).booleanValue();
    }

    public ComposerVideoTaggingInfo(Parcel parcel) {
        boolean z = false;
        MediaData[] mediaDataArr = new MediaData[parcel.readInt()];
        for (int i = 0; i < mediaDataArr.length; i++) {
            mediaDataArr[i] = (MediaData) parcel.readParcelable(MediaData.class.getClassLoader());
        }
        this.f13981a = ImmutableList.copyOf(mediaDataArr);
        if (parcel.readInt() == 1) {
            z = true;
        }
        this.f13982b = z;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        parcel.writeInt(this.f13981a.size());
        int size = this.f13981a.size();
        for (int i3 = 0; i3 < size; i3++) {
            parcel.writeParcelable((MediaData) this.f13981a.get(i3), i);
        }
        if (this.f13982b) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
    }

    public int describeContents() {
        return 0;
    }

    @JsonProperty("frames")
    public ImmutableList<MediaData> getFrames() {
        return this.f13981a;
    }

    @JsonProperty("has_faceboxes")
    public boolean hasFaceboxes() {
        return this.f13982b;
    }
}
