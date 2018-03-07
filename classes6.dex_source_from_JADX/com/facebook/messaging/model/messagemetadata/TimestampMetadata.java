package com.facebook.messaging.model.messagemetadata;

import android.os.Parcel;
import com.facebook.common.util.JSONUtil;
import com.facebook.messaging.model.messagemetadata.MessageMetadata.Creator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Objects;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: uploads_in_progress */
public class TimestampMetadata implements MessageMetadata {
    public static final Creator<TimestampMetadata> CREATOR = new C00881();
    public final long f1949a;

    /* compiled from: uploads_in_progress */
    final class C00881 implements Creator<TimestampMetadata> {
        C00881() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new TimestampMetadata(parcel);
        }

        public final Object[] newArray(int i) {
            return new TimestampMetadata[i];
        }

        public final MessageMetadata mo152a(JsonNode jsonNode) {
            return new TimestampMetadata(JSONUtil.c(jsonNode.b("value")));
        }
    }

    public TimestampMetadata(long j) {
        this.f1949a = j;
    }

    public TimestampMetadata(Parcel parcel) {
        this.f1949a = parcel.readLong();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f1949a);
    }

    public final ObjectNode mo153a() {
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        objectNode.a("name", MessageMetadataType.TIMESTAMP.value);
        objectNode.a("value", this.f1949a);
        return objectNode;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{Long.valueOf(this.f1949a)});
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof TimestampMetadata)) {
            return false;
        }
        if (this.f1949a == ((TimestampMetadata) obj).f1949a) {
            return true;
        }
        return false;
    }
}
