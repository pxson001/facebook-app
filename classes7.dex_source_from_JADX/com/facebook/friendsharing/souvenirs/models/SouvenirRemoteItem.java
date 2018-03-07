package com.facebook.friendsharing.souvenirs.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.friendsharing.souvenirs.models.SouvenirItem.Deserializer;
import com.facebook.friendsharing.souvenirs.models.SouvenirItem.Type;
import com.facebook.friendsharing.souvenirs.protocols.FetchSouvenirsModels.SouvenirsMediaFieldsModel;
import com.facebook.ipc.media.data.HasMediaData;
import com.facebook.ipc.media.data.MediaData;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Locale;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer(baseDeserializer = "com.facebook.friendsharing.souvenirs.models.SouvenirUriItemDeserializer")
@JsonDeserialize(using = Deserializer.class)
@Immutable
@JsonSerialize(using = Serializer.class)
/* compiled from: RIDGE_NUX */
public final class SouvenirRemoteItem extends SouvenirUriItem implements HasMediaData {
    public static final Creator<SouvenirRemoteItem> CREATOR = new C20961();
    @JsonProperty(a = true, value = "media_data")
    final MediaData mMediaData;
    @JsonProperty(a = true, value = "model")
    final SouvenirsMediaFieldsModel mMediaModel;

    /* compiled from: RIDGE_NUX */
    final class C20961 implements Creator<SouvenirRemoteItem> {
        C20961() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SouvenirRemoteItem(parcel);
        }

        public final Object[] newArray(int i) {
            return new SouvenirRemoteItem[i];
        }
    }

    /* compiled from: RIDGE_NUX */
    public class Serializer extends JsonSerializer<SouvenirRemoteItem> {
        public final void m26194a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            SouvenirRemoteItem souvenirRemoteItem = (SouvenirRemoteItem) obj;
            if (souvenirRemoteItem == null) {
                throw new IllegalArgumentException("SouvenirPhotoItem.serialize");
            }
            jsonGenerator.b(SouvenirRemoteItem.class.getSimpleName());
            jsonGenerator.f();
            m26193b(souvenirRemoteItem, jsonGenerator, serializerProvider);
            jsonGenerator.g();
        }

        static {
            FbSerializerProvider.a(SouvenirRemoteItem.class, new Serializer());
        }

        private static void m26193b(SouvenirRemoteItem souvenirRemoteItem, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "media_data", souvenirRemoteItem.mMediaData);
            AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "model", souvenirRemoteItem.mMediaModel);
        }
    }

    public final MediaData m26195b() {
        return this.mMediaData;
    }

    public final Type hw_() {
        return m26195b().mType == MediaData.Type.Photo ? Type.Photo : Type.Video;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof SouvenirRemoteItem) && this.mMediaModel.equals(((SouvenirRemoteItem) obj).mMediaModel)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ((m26186c().hashCode() + 85) * 17) + hw_().name().hashCode();
    }

    public final String toString() {
        return String.format(Locale.US, "{SouvenirRemoteItem %s}", new Object[]{m26195b().toString()});
    }

    private SouvenirRemoteItem() {
        this.mMediaData = null;
        this.mMediaModel = null;
    }

    public SouvenirRemoteItem(Parcel parcel) {
        super((byte) 0);
        this.mMediaData = (MediaData) parcel.readParcelable(MediaData.class.getClassLoader());
        this.mMediaModel = (SouvenirsMediaFieldsModel) FlatBufferModelHelper.a(parcel);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.mMediaData, i);
        FlatBufferModelHelper.a(parcel, this.mMediaModel);
    }
}
