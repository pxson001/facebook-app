package com.facebook.http.protocol;

import com.facebook.debug.log.BLog;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: fbresources_disabled_fb4a */
public class BatchJsonParser extends DepthCountingJsonParser {
    public BatchJsonParser(JsonParser jsonParser, boolean z) {
        super(jsonParser, z);
    }

    public void close() {
    }

    public final void mo892K() {
        this.f11950b.close();
    }

    public final boolean m12557L() {
        try {
            JsonToken c = c();
            while (c != null) {
                if (this.f11948c == 2 && c == JsonToken.START_ARRAY) {
                    return true;
                }
                if (this.f11948c == 1 && c == JsonToken.VALUE_NULL) {
                    return true;
                }
                if (this.f11948c == 0 && c == JsonToken.VALUE_NULL) {
                    return true;
                }
                if (this.f11948c == 2 && c == JsonToken.START_OBJECT) {
                    return true;
                }
                c = c();
            }
        } catch (Throwable e) {
            BLog.b(getClass().getSimpleName(), "Error finding next batch.", e);
        }
        return false;
    }
}
