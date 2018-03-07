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
/* compiled from: RIGHT_HANDLE_ZOOM_INS */
public final class SouvenirPhotoItem extends SouvenirUriItem implements HasLocalMediaData {
    public static final Creator<SouvenirPhotoItem> CREATOR = new C20951();
    @JsonProperty(a = true, value = "media_data")
    final LocalMediaData mLocalMediaData;

    /* compiled from: RIGHT_HANDLE_ZOOM_INS */
    final class C20951 implements Creator<SouvenirPhotoItem> {
        C20951() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SouvenirPhotoItem(parcel);
        }

        public final Object[] newArray(int i) {
            return new SouvenirPhotoItem[i];
        }
    }

    /* compiled from: RIGHT_HANDLE_ZOOM_INS */
    public class Serializer extends JsonSerializer<SouvenirPhotoItem> {
        public final void m26185a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            SouvenirPhotoItem souvenirPhotoItem = (SouvenirPhotoItem) obj;
            if (souvenirPhotoItem == null) {
                throw new IllegalArgumentException("SouvenirPhotoItem.serialize");
            }
            jsonGenerator.b(SouvenirPhotoItem.class.getSimpleName());
            jsonGenerator.f();
            m26184b(souvenirPhotoItem, jsonGenerator, serializerProvider);
            jsonGenerator.g();
        }

        static {
            FbSerializerProvider.a(SouvenirPhotoItem.class, new Serializer());
        }

        private static void m26184b(SouvenirPhotoItem souvenirPhotoItem, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "media_data", souvenirPhotoItem.mLocalMediaData);
        }
    }

    public SouvenirPhotoItem(LocalMediaData localMediaData) {
        boolean z;
        this.mLocalMediaData = localMediaData;
        if (m26188b().mType == Type.Photo) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
    }

    public final LocalMediaData m26187a() {
        return this.mLocalMediaData;
    }

    public final MediaData m26188b() {
        return this.mLocalMediaData.b();
    }

    public final SouvenirItem.Type hw_() {
        return SouvenirItem.Type.Photo;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof SouvenirPhotoItem) && ((SouvenirPhotoItem) obj).m26186c().equals(m26186c())) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ((m26186c().hashCode() + 85) * 17) + hw_().name().hashCode();
    }

    public final String toString() {
        return String.format(Locale.US, "{SouvenirPhotoItem %s}", new Object[]{this.mLocalMediaData.toString()});
    }

    private SouvenirPhotoItem() {
        this.mLocalMediaData = null;
    }

    public SouvenirPhotoItem(Parcel parcel) {
        super((byte) 0);
        this.mLocalMediaData = (LocalMediaData) parcel.readParcelable(LocalMediaData.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.mLocalMediaData, i);
    }
}
