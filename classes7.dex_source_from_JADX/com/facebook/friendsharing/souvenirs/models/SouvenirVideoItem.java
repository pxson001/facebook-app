package com.facebook.friendsharing.souvenirs.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.friendsharing.souvenirs.models.SouvenirItem.Deserializer;
import com.facebook.ipc.media.data.HasLocalMediaData;
import com.facebook.ipc.media.data.LocalMediaData;
import com.facebook.ipc.media.data.MediaData;
import com.facebook.ipc.media.data.MediaData.Type;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Preconditions;
import java.util.Locale;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer(baseDeserializer = "com.facebook.friendsharing.souvenirs.models.SouvenirUriItemDeserializer")
@JsonDeserialize(using = Deserializer.class)
@Immutable
@JsonSerialize(using = Serializer.class)
/* compiled from: REVEALED */
public final class SouvenirVideoItem extends SouvenirUriItem implements HasLocalMediaData {
    public static final Creator<SouvenirVideoItem> CREATOR = new C20971();
    @JsonProperty("duration")
    final long mDurationMsecs;
    @JsonProperty(a = true, value = "media_data")
    final LocalMediaData mLocalMediaData;

    /* compiled from: REVEALED */
    final class C20971 implements Creator<SouvenirVideoItem> {
        C20971() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SouvenirVideoItem(parcel);
        }

        public final Object[] newArray(int i) {
            return new SouvenirVideoItem[i];
        }
    }

    /* compiled from: REVEALED */
    public class Serializer extends JsonSerializer<SouvenirVideoItem> {
        public final void m26201a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            SouvenirVideoItem souvenirVideoItem = (SouvenirVideoItem) obj;
            if (souvenirVideoItem == null) {
                throw new IllegalArgumentException("SouvenirVideoItem.serialize");
            }
            jsonGenerator.b(SouvenirVideoItem.class.getSimpleName());
            jsonGenerator.f();
            m26200b(souvenirVideoItem, jsonGenerator, serializerProvider);
            jsonGenerator.g();
        }

        static {
            FbSerializerProvider.a(SouvenirVideoItem.class, new Serializer());
        }

        private static void m26200b(SouvenirVideoItem souvenirVideoItem, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "media_data", souvenirVideoItem.mLocalMediaData);
            AutoGenJsonHelper.a(jsonGenerator, "duration", Long.valueOf(souvenirVideoItem.mDurationMsecs));
        }
    }

    public SouvenirVideoItem(LocalMediaData localMediaData, long j) {
        boolean z;
        this.mLocalMediaData = localMediaData;
        if (m26203b().mType == Type.Video) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        this.mDurationMsecs = j;
    }

    public final LocalMediaData m26202a() {
        return this.mLocalMediaData;
    }

    public final MediaData m26203b() {
        return this.mLocalMediaData.b();
    }

    public final SouvenirItem.Type hw_() {
        return SouvenirItem.Type.Video;
    }

    public final long m26204d() {
        return this.mDurationMsecs;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof SouvenirVideoItem) && ((SouvenirVideoItem) obj).m26186c().equals(m26186c())) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ((m26186c().hashCode() + 85) * 17) + hw_().name().hashCode();
    }

    public final String toString() {
        return String.format(Locale.US, "{SouvenirVideoItem %s}", new Object[]{this.mLocalMediaData.toString()});
    }

    private SouvenirVideoItem() {
        this.mLocalMediaData = null;
        this.mDurationMsecs = 0;
    }

    public SouvenirVideoItem(Parcel parcel) {
        super((byte) 0);
        this.mLocalMediaData = (LocalMediaData) parcel.readParcelable(LocalMediaData.class.getClassLoader());
        this.mDurationMsecs = parcel.readLong();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.mLocalMediaData, i);
        parcel.writeLong(this.mDurationMsecs);
    }
}
