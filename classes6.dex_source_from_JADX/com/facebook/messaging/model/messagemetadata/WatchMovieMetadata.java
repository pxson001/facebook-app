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
/* compiled from: uploads */
public class WatchMovieMetadata implements MessageMetadata {
    public static final Creator<WatchMovieMetadata> CREATOR = new C00891();
    public final int f1950a;

    /* compiled from: uploads */
    final class C00891 implements Creator<WatchMovieMetadata> {
        C00891() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new WatchMovieMetadata(parcel);
        }

        public final Object[] newArray(int i) {
            return new WatchMovieMetadata[i];
        }

        public final MessageMetadata mo152a(JsonNode jsonNode) {
            return new WatchMovieMetadata(JSONUtil.d(jsonNode.b("confidence")));
        }
    }

    public WatchMovieMetadata(int i) {
        this.f1950a = i;
    }

    public WatchMovieMetadata(Parcel parcel) {
        this.f1950a = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f1950a);
    }

    public final ObjectNode mo153a() {
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        objectNode.a("name", MessageMetadataType.WATCH_MOVIE.value);
        objectNode.a("confidence", this.f1950a);
        return objectNode;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{Integer.valueOf(this.f1950a)});
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof WatchMovieMetadata)) {
            return false;
        }
        if (this.f1950a == ((WatchMovieMetadata) obj).f1950a) {
            return true;
        }
        return false;
    }
}
