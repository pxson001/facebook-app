package com.facebook.device.resourcemonitor;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: school */
public class MonitoredProcessDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(MonitoredProcess.class, new MonitoredProcessDeserializer());
    }

    public Object m4051a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return MonitoredProcess.fromString(jsonParser.o());
    }
}
