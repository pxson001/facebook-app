package com.facebook.ipc.media.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.json.FbJsonChecker;
import com.facebook.debug.log.BLog;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonSerializer
@AutoGenJsonDeserializer
@Immutable
/* compiled from: TF; */
public final class MimeType implements Parcelable {
    public static final Creator<MimeType> CREATOR = new C13551();
    public static final MimeType f14114a = new MimeType("image/jpeg");
    public static final MimeType f14115b = new MimeType("video/mp4");
    public static final MimeType f14116c = new MimeType("image/png");
    public static final MimeType f14117d = new MimeType("image/gif");
    public static final MimeType f14118e = new MimeType();
    private static final String f14119f = MimeType.class.getSimpleName();
    @JsonProperty(a = true, value = "raw")
    public final String mRawType;

    /* compiled from: TF; */
    final class C13551 implements Creator<MimeType> {
        C13551() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return MimeType.m23492a(parcel.readString());
        }

        public final Object[] newArray(int i) {
            return new MimeType[i];
        }
    }

    /* compiled from: TF; */
    public class Deserializer extends JsonDeserializer<MimeType> {
        public Object m23491a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            String str = null;
            while (FbJsonChecker.a(jsonParser) != JsonToken.END_OBJECT) {
                if (jsonParser.g() == JsonToken.VALUE_STRING) {
                    str = jsonParser.I();
                }
                jsonParser.f();
            }
            if (str != null) {
                return MimeType.m23492a(str);
            }
            throw new JsonParseException("MimeType: missing raw type string", jsonParser.l());
        }
    }

    public static MimeType m23492a(@Nullable String str) {
        if (str == null) {
            return f14118e;
        }
        MimeType[] mimeTypeArr = new MimeType[]{f14114a, f14115b, f14116c, f14117d, f14118e};
        for (int i = 0; i < 5; i++) {
            MimeType mimeType = mimeTypeArr[i];
            if (mimeType.mRawType.equals(str)) {
                return mimeType;
            }
        }
        return new MimeType(str);
    }

    public final String m23493a() {
        return this.mRawType;
    }

    public final String toString() {
        return this.mRawType;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        boolean equals = this.mRawType.equals(((MimeType) obj).mRawType);
        if (equals) {
            BLog.a(f14119f, "Duplicate instance that skipped mapping: %s", new Object[]{this.mRawType});
        }
        return equals;
    }

    public final int hashCode() {
        return this.mRawType.hashCode();
    }

    private MimeType(String str) {
        this.mRawType = (String) Preconditions.checkNotNull(str);
    }

    private MimeType() {
        this.mRawType = "";
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mRawType);
    }
}
