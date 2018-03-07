package com.facebook.interstitial.manager;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: TOPIC_CITY */
public class InterstitialTrigger_ActionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(Action.class, new InterstitialTrigger_ActionDeserializer());
    }

    public Object m23261a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return Action.fromString(jsonParser.o());
    }
}
