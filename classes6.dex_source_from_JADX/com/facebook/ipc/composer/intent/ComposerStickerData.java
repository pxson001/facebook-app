package com.facebook.ipc.composer.intent;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.stickers.model.Sticker;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = ComposerStickerDataDeserializer.class)
@Immutable
@JsonSerialize(using = ComposerStickerDataSerializer.class)
/* compiled from: live_broadcast_id */
public class ComposerStickerData implements Parcelable {
    @JsonIgnore
    public static final Creator<ComposerStickerData> CREATOR = new C07381();
    @JsonProperty("animated_disk_uri")
    @Nullable
    public final String animatedDiskUri;
    @JsonProperty("animated_web_uri")
    @Nullable
    public final String animatedWebUri;
    @JsonProperty("pack_id")
    public final String packId;
    @JsonProperty("static_disk_uri")
    @Nullable
    public final String staticDiskUri;
    @JsonProperty("static_web_uri")
    @Nullable
    public final String staticWebUri;
    @JsonProperty("sticker_id")
    public final String stickerId;

    /* compiled from: live_broadcast_id */
    final class C07381 implements Creator<ComposerStickerData> {
        C07381() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ComposerStickerData(parcel);
        }

        public final Object[] newArray(int i) {
            return new ComposerStickerData[i];
        }
    }

    /* compiled from: live_broadcast_id */
    public class Builder {
        public String f11566a = null;
        public String f11567b = null;
        @Nullable
        public String f11568c = null;
        @Nullable
        public String f11569d = null;
        @Nullable
        public String f11570e = null;
        @Nullable
        public String f11571f = null;

        public static Builder m18254a(Sticker sticker) {
            String str;
            String str2 = null;
            Builder builder = new Builder();
            builder.f11566a = sticker.f4938a;
            builder = builder;
            builder.f11567b = sticker.f4939b;
            Builder builder2 = builder;
            if (sticker.f4940c == null) {
                str = null;
            } else {
                str = sticker.f4940c.toString();
            }
            builder2.f11568c = str;
            builder2 = builder2;
            if (sticker.f4941d == null) {
                str = null;
            } else {
                str = sticker.f4941d.toString();
            }
            builder2.f11569d = str;
            builder2 = builder2;
            if (sticker.f4942e == null) {
                str = null;
            } else {
                str = sticker.f4942e.toString();
            }
            builder2.f11570e = str;
            builder = builder2;
            if (sticker.f4943f != null) {
                str2 = sticker.f4943f.toString();
            }
            builder.f11571f = str2;
            return builder;
        }

        public final ComposerStickerData m18255a() {
            return new ComposerStickerData(this);
        }
    }

    /* compiled from: live_broadcast_id */
    public interface ProvidesStickerData {
        ComposerStickerData m18256r();
    }

    @JsonIgnore
    private ComposerStickerData() {
        this(new Builder());
    }

    @JsonIgnore
    public ComposerStickerData(Builder builder) {
        this.stickerId = builder.f11566a;
        this.packId = builder.f11567b;
        this.staticWebUri = builder.f11568c;
        this.staticDiskUri = builder.f11569d;
        this.animatedWebUri = builder.f11570e;
        this.animatedDiskUri = builder.f11571f;
    }

    @JsonIgnore
    public ComposerStickerData(Parcel parcel) {
        this.stickerId = parcel.readString();
        this.packId = parcel.readString();
        this.staticWebUri = parcel.readString();
        this.staticDiskUri = parcel.readString();
        this.animatedWebUri = parcel.readString();
        this.animatedDiskUri = parcel.readString();
    }

    @JsonIgnore
    public int describeContents() {
        return 0;
    }

    @JsonIgnore
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.stickerId);
        parcel.writeString(this.packId);
        parcel.writeString(this.staticWebUri);
        parcel.writeString(this.staticDiskUri);
        parcel.writeString(this.animatedWebUri);
        parcel.writeString(this.animatedDiskUri);
    }
}
