package com.facebook.ipc.media.data;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.json.FbJsonChecker;
import com.facebook.ipc.media.data.MimeType.Deserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Preconditions;
import java.util.Locale;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonSerializer
@AutoGenJsonDeserializer
@Immutable
/* compiled from: THAI_RESTAURANT */
public final class MediaData implements Parcelable {
    public static final Creator<MediaData> CREATOR = new C13541();
    public static float f14112a = Float.NaN;
    public static double f14113b = Double.NaN;
    @JsonProperty("aspect_ratio")
    public final float mAspectRatio;
    @JsonProperty("focus_point")
    public final FocusPoint mFocusPoint;
    @JsonProperty("height")
    public final int mHeight;
    @JsonProperty(a = true, value = "id")
    public final String mId;
    @JsonProperty("latitude")
    public final double mLatitude;
    @JsonProperty("longitude")
    public final double mLongitude;
    @JsonProperty("mime_type")
    @JsonDeserialize(using = Deserializer.class)
    public final MimeType mMimeType;
    @JsonProperty("orientation")
    public final int mOrientation;
    @JsonProperty(a = true, value = "type")
    public final Type mType;
    @JsonProperty(a = true, value = "uri")
    @JsonDeserialize(using = UriDeserializer.class)
    @JsonSerialize(using = UriSerializer.class)
    public final Uri mUri;
    @JsonProperty("width")
    public final int mWidth;

    /* compiled from: THAI_RESTAURANT */
    final class C13541 implements Creator<MediaData> {
        C13541() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new MediaData(parcel);
        }

        public final Object[] newArray(int i) {
            return new MediaData[i];
        }
    }

    /* compiled from: THAI_RESTAURANT */
    public class Builder {
        @Nullable
        public String f14101a;
        @Nullable
        public Type f14102b;
        @Nullable
        public Uri f14103c;
        public MimeType f14104d = MimeType.f14118e;
        public int f14105e;
        public int f14106f = 0;
        public int f14107g = 0;
        public float f14108h = MediaData.f14112a;
        public FocusPoint f14109i = FocusPoint.f14096a;
        public double f14110j = MediaData.f14113b;
        public double f14111k = MediaData.f14113b;

        public final Builder m23481a(String str) {
            this.f14101a = (String) Preconditions.checkNotNull(str);
            return this;
        }

        public final Builder m23479a(Type type) {
            this.f14102b = (Type) Preconditions.checkNotNull(type);
            return this;
        }

        public final Builder m23478a(Uri uri) {
            Preconditions.checkNotNull(uri);
            Preconditions.checkArgument(uri.isHierarchical());
            this.f14103c = uri;
            return this;
        }

        public final Builder m23480a(MimeType mimeType) {
            this.f14104d = (MimeType) Preconditions.checkNotNull(mimeType);
            return this;
        }

        public final Builder m23477a(double d) {
            boolean z = (d >= -90.0d && d <= 90.0d) || Double.isNaN(d);
            Preconditions.checkArgument(z);
            this.f14110j = d;
            return this;
        }

        public final Builder m23483b(double d) {
            boolean z = (d >= -180.0d && d <= 180.0d) || Double.isNaN(d);
            Preconditions.checkArgument(z);
            this.f14111k = d;
            return this;
        }

        public final MediaData m23482a() {
            return new MediaData(this);
        }
    }

    /* compiled from: THAI_RESTAURANT */
    public enum Type {
        Photo,
        Video
    }

    /* compiled from: THAI_RESTAURANT */
    public class UriDeserializer extends JsonDeserializer<Uri> {
        public Object m23484a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            Object obj = null;
            while (FbJsonChecker.a(jsonParser) != JsonToken.END_OBJECT) {
                if (jsonParser.g() == JsonToken.VALUE_STRING) {
                    obj = Uri.parse(jsonParser.I());
                }
                jsonParser.f();
            }
            return obj;
        }
    }

    /* compiled from: THAI_RESTAURANT */
    public class UriSerializer extends JsonSerializer<Uri> {
        public final void m23485a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            Uri uri = (Uri) obj;
            if (uri == null) {
                throw new IllegalArgumentException("UriSerializer.serialize");
            }
            jsonGenerator.f();
            AutoGenJsonHelper.a(jsonGenerator, "uri", uri.toString());
            jsonGenerator.g();
        }
    }

    public final String toString() {
        return String.format(Locale.US, "{MediaData: %s %s %s}", new Object[]{this.mType, this.mId, this.mUri});
    }

    public final String m23486a() {
        return this.mId;
    }

    public final Type m23487b() {
        return this.mType;
    }

    public final Uri m23488c() {
        return this.mUri;
    }

    public final double m23489j() {
        return this.mLatitude;
    }

    public final double m23490k() {
        return this.mLongitude;
    }

    public MediaData(Builder builder) {
        this.mId = (String) Preconditions.checkNotNull(builder.f14101a);
        this.mType = (Type) Preconditions.checkNotNull(builder.f14102b);
        this.mUri = (Uri) Preconditions.checkNotNull(builder.f14103c);
        this.mMimeType = builder.f14104d;
        this.mOrientation = builder.f14105e;
        this.mWidth = builder.f14106f;
        this.mHeight = builder.f14107g;
        this.mAspectRatio = builder.f14108h;
        this.mFocusPoint = builder.f14109i;
        this.mLatitude = builder.f14110j;
        this.mLongitude = builder.f14111k;
    }

    private MediaData() {
        this.mId = null;
        this.mType = Type.Photo;
        this.mUri = Uri.EMPTY;
        this.mMimeType = MimeType.f14118e;
        this.mOrientation = 0;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mAspectRatio = f14112a;
        this.mFocusPoint = FocusPoint.f14096a;
        this.mLatitude = f14113b;
        this.mLongitude = f14113b;
    }

    public MediaData(Parcel parcel) {
        this.mId = parcel.readString();
        this.mType = Type.valueOf(parcel.readString());
        this.mUri = Uri.parse(parcel.readString());
        this.mMimeType = (MimeType) parcel.readParcelable(MimeType.class.getClassLoader());
        this.mOrientation = parcel.readInt();
        this.mWidth = parcel.readInt();
        this.mHeight = parcel.readInt();
        this.mAspectRatio = parcel.readFloat();
        FocusPoint focusPoint = (FocusPoint) parcel.readParcelable(FocusPoint.class.getClassLoader());
        if (FocusPoint.f14096a.equals(focusPoint)) {
            focusPoint = FocusPoint.f14096a;
        }
        this.mFocusPoint = focusPoint;
        this.mLatitude = parcel.readDouble();
        this.mLongitude = parcel.readDouble();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mId);
        parcel.writeString(this.mType.toString());
        parcel.writeString(this.mUri.toString());
        parcel.writeParcelable(this.mMimeType, i);
        parcel.writeInt(this.mOrientation);
        parcel.writeInt(this.mWidth);
        parcel.writeInt(this.mHeight);
        parcel.writeFloat(this.mAspectRatio);
        parcel.writeParcelable(this.mFocusPoint, i);
        parcel.writeDouble(this.mLatitude);
        parcel.writeDouble(this.mLongitude);
    }
}
