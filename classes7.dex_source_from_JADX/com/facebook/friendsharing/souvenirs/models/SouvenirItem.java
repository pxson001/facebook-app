package com.facebook.friendsharing.souvenirs.models;

import android.os.Parcelable;
import com.facebook.common.json.FbJsonDeserializer;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.HashMap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@JsonDeserialize(using = Deserializer.class)
@Immutable
/* compiled from: RTC_VOICEMAIL */
public interface SouvenirItem extends Parcelable {

    /* compiled from: RTC_VOICEMAIL */
    public class Deserializer extends JsonDeserializer<SouvenirItem> {
        @Nullable
        private HashMap<String, FbJsonDeserializer> f24061a = null;

        private HashMap<String, FbJsonDeserializer> m26164e() {
            if (this.f24061a == null) {
                this.f24061a = new HashMap(4);
                this.f24061a.put(SouvenirPhotoItem.class.getSimpleName(), new SouvenirPhotoItemDeserializer());
                this.f24061a.put(SouvenirVideoItem.class.getSimpleName(), new SouvenirVideoItemDeserializer());
                this.f24061a.put(SouvenirBurstItem.class.getSimpleName(), new SouvenirBurstItemDeserializer());
                this.f24061a.put(SouvenirRemoteItem.class.getSimpleName(), new SouvenirRemoteItemDeserializer());
            }
            return this.f24061a;
        }

        public Object m26165a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            String o = jsonParser.o();
            FbJsonDeserializer fbJsonDeserializer = (FbJsonDeserializer) m26164e().get(o);
            if (fbJsonDeserializer != null) {
                return (SouvenirItem) fbJsonDeserializer.a(jsonParser, deserializationContext);
            }
            throw new IllegalArgumentException("SouvenirItem deserialize: " + o);
        }
    }

    /* compiled from: RTC_VOICEMAIL */
    public enum Type {
        Photo,
        Video,
        Burst
    }

    Type hw_();
}
