package com.facebook.ipc.slideshow;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.model.ComposerSlideshowData;
import com.facebook.ipc.media.MediaItem;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;

@AutoGenJsonSerializer
@JsonDeserialize(using = Deserializer.class)
@JsonSerialize(using = SlideshowEditConfigurationSerializer.class)
/* compiled from: unitComponentStyle */
public class SlideshowEditConfiguration implements Parcelable {
    public static final Creator<SlideshowEditConfiguration> CREATOR = new C01061();
    private final SlideshowEditConfigurationSpec$Action f1176a;
    @Nullable
    private final ComposerConfiguration f1177b;
    private final ImmutableList<MediaItem> f1178c;
    private final String f1179d;
    @Nullable
    private final ComposerSlideshowData f1180e;
    private final SlideshowEditConfigurationSpec$Source f1181f;

    /* compiled from: unitComponentStyle */
    final class C01061 implements Creator<SlideshowEditConfiguration> {
        C01061() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SlideshowEditConfiguration(parcel);
        }

        public final Object[] newArray(int i) {
            return new SlideshowEditConfiguration[i];
        }
    }

    @AutoGenJsonDeserializer
    @JsonDeserialize(using = SlideshowEditConfiguration_BuilderDeserializer.class)
    /* compiled from: unitComponentStyle */
    public class Builder {
        private static final SlideshowEditConfigurationSpec$Action f1167a = SlideshowEditConfigurationSpec$Action.NONE;
        private static final SlideshowEditConfigurationSpec$Source f1168b = SlideshowEditConfigurationSpec$Source.SIMPLE_PICKER;
        public SlideshowEditConfigurationSpec$Action f1169c = f1167a;
        @Nullable
        public ComposerConfiguration f1170d;
        public ImmutableList<MediaItem> f1171e = RegularImmutableList.a;
        public String f1172f = "";
        @Nullable
        public ComposerSlideshowData f1173g;
        public SlideshowEditConfigurationSpec$Source f1174h = f1168b;

        static {
            SlideshowEditConfigurationSpec$DefaultActionProvider slideshowEditConfigurationSpec$DefaultActionProvider = new SlideshowEditConfigurationSpec$DefaultActionProvider();
            SlideshowEditConfigurationSpec$DefaultSourceProvider slideshowEditConfigurationSpec$DefaultSourceProvider = new SlideshowEditConfigurationSpec$DefaultSourceProvider();
        }

        public final SlideshowEditConfiguration m1394a() {
            return new SlideshowEditConfiguration(this);
        }

        @JsonProperty("action_when_done")
        public Builder setActionWhenDone(SlideshowEditConfigurationSpec$Action slideshowEditConfigurationSpec$Action) {
            this.f1169c = slideshowEditConfigurationSpec$Action;
            return this;
        }

        @JsonProperty("composer_configuration")
        public Builder setComposerConfiguration(@Nullable ComposerConfiguration composerConfiguration) {
            this.f1170d = composerConfiguration;
            return this;
        }

        @JsonProperty("media_items")
        public Builder setMediaItems(ImmutableList<MediaItem> immutableList) {
            this.f1171e = immutableList;
            return this;
        }

        @JsonProperty("session_id")
        public Builder setSessionId(String str) {
            this.f1172f = str;
            return this;
        }

        @JsonProperty("slideshow_data")
        public Builder setSlideshowData(@Nullable ComposerSlideshowData composerSlideshowData) {
            this.f1173g = composerSlideshowData;
            return this;
        }

        @JsonProperty("source")
        public Builder setSource(SlideshowEditConfigurationSpec$Source slideshowEditConfigurationSpec$Source) {
            this.f1174h = slideshowEditConfigurationSpec$Source;
            return this;
        }
    }

    /* compiled from: unitComponentStyle */
    class Deserializer extends JsonDeserializer<SlideshowEditConfiguration> {
        private static final SlideshowEditConfiguration_BuilderDeserializer f1175a = new SlideshowEditConfiguration_BuilderDeserializer();

        private Deserializer() {
        }

        public Object m1395a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return ((Builder) f1175a.a(jsonParser, deserializationContext)).m1394a();
        }
    }

    public SlideshowEditConfiguration(Builder builder) {
        this.f1176a = (SlideshowEditConfigurationSpec$Action) Preconditions.checkNotNull(builder.f1169c);
        this.f1177b = builder.f1170d;
        this.f1178c = (ImmutableList) Preconditions.checkNotNull(builder.f1171e);
        this.f1179d = (String) Preconditions.checkNotNull(builder.f1172f);
        this.f1180e = builder.f1173g;
        this.f1181f = (SlideshowEditConfigurationSpec$Source) Preconditions.checkNotNull(builder.f1174h);
    }

    public SlideshowEditConfiguration(Parcel parcel) {
        this.f1176a = SlideshowEditConfigurationSpec$Action.valueOf(parcel.readString());
        if (parcel.readInt() == 0) {
            this.f1177b = null;
        } else {
            this.f1177b = (ComposerConfiguration) parcel.readParcelable(ComposerConfiguration.class.getClassLoader());
        }
        MediaItem[] mediaItemArr = new MediaItem[parcel.readInt()];
        for (int i = 0; i < mediaItemArr.length; i++) {
            mediaItemArr[i] = (MediaItem) parcel.readParcelable(MediaItem.class.getClassLoader());
        }
        this.f1178c = ImmutableList.copyOf(mediaItemArr);
        this.f1179d = parcel.readString();
        if (parcel.readInt() == 0) {
            this.f1180e = null;
        } else {
            this.f1180e = (ComposerSlideshowData) parcel.readParcelable(ComposerSlideshowData.class.getClassLoader());
        }
        this.f1181f = SlideshowEditConfigurationSpec$Source.valueOf(parcel.readString());
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f1176a.name());
        if (this.f1177b == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeParcelable(this.f1177b, i);
        }
        parcel.writeInt(this.f1178c.size());
        int size = this.f1178c.size();
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeParcelable((MediaItem) this.f1178c.get(i2), i);
        }
        parcel.writeString(this.f1179d);
        if (this.f1180e == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeParcelable(this.f1180e, i);
        }
        parcel.writeString(this.f1181f.name());
    }

    public int describeContents() {
        return 0;
    }

    @JsonProperty("action_when_done")
    public SlideshowEditConfigurationSpec$Action getActionWhenDone() {
        return this.f1176a;
    }

    @JsonProperty("composer_configuration")
    @Nullable
    public ComposerConfiguration getComposerConfiguration() {
        return this.f1177b;
    }

    @JsonProperty("media_items")
    public ImmutableList<MediaItem> getMediaItems() {
        return this.f1178c;
    }

    @JsonProperty("session_id")
    public String getSessionId() {
        return this.f1179d;
    }

    @JsonProperty("slideshow_data")
    @Nullable
    public ComposerSlideshowData getSlideshowData() {
        return this.f1180e;
    }

    @JsonProperty("source")
    public SlideshowEditConfigurationSpec$Source getSource() {
        return this.f1181f;
    }
}
