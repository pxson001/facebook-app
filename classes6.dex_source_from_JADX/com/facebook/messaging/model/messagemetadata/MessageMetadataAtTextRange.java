package com.facebook.messaging.model.messagemetadata;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.util.JSONUtil;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.common.util.StringUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableMap;
import java.util.Iterator;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: url_promo */
public class MessageMetadataAtTextRange implements Parcelable {
    public static final Creator<MessageMetadataAtTextRange> CREATOR = new C00851();
    public static ImmutableMap<MessageMetadataType, MessageMetadata.Creator> f1938e = null;
    public final Type f1939a;
    public final int f1940b;
    public final int f1941c;
    public final MessageMetadata f1942d;

    /* compiled from: url_promo */
    final class C00851 implements Creator<MessageMetadataAtTextRange> {
        C00851() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new MessageMetadataAtTextRange(parcel);
        }

        public final Object[] newArray(int i) {
            return new MessageMetadataAtTextRange[i];
        }
    }

    /* compiled from: url_promo */
    public enum Type {
        NONE(0),
        CONCEPT(1),
        INTENT(2);
        
        public final int value;

        private Type(int i) {
            this.value = i;
        }

        public static Type fromRawValue(int i) {
            for (Type type : values()) {
                if (Objects.equal(Integer.valueOf(type.value), Integer.valueOf(i))) {
                    return type;
                }
            }
            return NONE;
        }
    }

    private MessageMetadataAtTextRange(Type type, int i, int i2, MessageMetadata messageMetadata) {
        this.f1939a = type;
        this.f1940b = i;
        this.f1941c = i2;
        this.f1942d = messageMetadata;
    }

    public MessageMetadataAtTextRange(Parcel parcel) {
        this.f1939a = Type.fromRawValue(parcel.readInt());
        this.f1940b = parcel.readInt();
        this.f1941c = parcel.readInt();
        this.f1942d = (MessageMetadata) parcel.readParcelable(MessageMetadata.class.getClassLoader());
    }

    public static ImmutableList<MessageMetadataAtTextRange> m3290a(ObjectMapper objectMapper, FbErrorReporter fbErrorReporter, String str) {
        if (StringUtil.a(str)) {
            return ImmutableList.of();
        }
        Builder builder = ImmutableList.builder();
        JsonNode jsonNode = null;
        try {
            jsonNode = objectMapper.a(str);
        } catch (Throwable e) {
            fbErrorReporter.a("MessageMetadataAtTextRange", "Error while parsing MessageMetadataAtTextRange", e);
        }
        if (jsonNode != null) {
            Iterator it = jsonNode.iterator();
            while (it.hasNext()) {
                MessageMetadataAtTextRange a = m3289a(fbErrorReporter, (JsonNode) it.next());
                if (a != null) {
                    builder.c(a);
                }
            }
        }
        return builder.b();
    }

    @Nullable
    private static MessageMetadataAtTextRange m3289a(AbstractFbErrorReporter abstractFbErrorReporter, JsonNode jsonNode) {
        MessageMetadata a;
        Type fromRawValue = Type.fromRawValue(JSONUtil.d(jsonNode.b("type")));
        JsonNode b = jsonNode.b("data");
        MessageMetadataType fromRawValue2 = MessageMetadataType.fromRawValue(JSONUtil.b(b.b("name")));
        if (f1938e == null) {
            f1938e = ImmutableMap.builder().b(MessageMetadataType.TIMESTAMP, TimestampMetadata.CREATOR).b(MessageMetadataType.WATCH_MOVIE, WatchMovieMetadata.CREATOR).b();
        }
        MessageMetadata.Creator creator = (MessageMetadata.Creator) f1938e.get(fromRawValue2);
        if (creator != null) {
            a = creator.mo152a(b);
        } else {
            a = null;
        }
        if (a != null) {
            return new MessageMetadataAtTextRange(fromRawValue, JSONUtil.d(jsonNode.b("offset")), JSONUtil.d(jsonNode.b("length")), a);
        }
        abstractFbErrorReporter.a("MessageMetadataAtTextRange", StringLocaleUtil.a("Could not create metadata for type %s", new Object[]{fromRawValue2.value}));
        return null;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f1939a.value);
        parcel.writeInt(this.f1940b);
        parcel.writeInt(this.f1941c);
        parcel.writeParcelable(this.f1942d, i);
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{Integer.valueOf(this.f1939a.value), Integer.valueOf(this.f1940b), Integer.valueOf(this.f1941c), this.f1942d});
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof MessageMetadataAtTextRange)) {
            return false;
        }
        MessageMetadataAtTextRange messageMetadataAtTextRange = (MessageMetadataAtTextRange) obj;
        if (Objects.equal(Integer.valueOf(this.f1939a.value), Integer.valueOf(messageMetadataAtTextRange.f1939a.value)) && Objects.equal(Integer.valueOf(this.f1940b), Integer.valueOf(messageMetadataAtTextRange.f1940b)) && Objects.equal(Integer.valueOf(this.f1941c), Integer.valueOf(messageMetadataAtTextRange.f1941c)) && this.f1942d.equals(messageMetadataAtTextRange.f1942d)) {
            return true;
        }
        return false;
    }
}
