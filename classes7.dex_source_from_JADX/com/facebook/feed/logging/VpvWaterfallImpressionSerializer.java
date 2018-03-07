package com.facebook.feed.logging;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: android.intent.action.CLOSE_SYSTEM_DIALOGS */
public class VpvWaterfallImpressionSerializer extends JsonSerializer<VpvWaterfallImpression> {
    public final void m22806a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        VpvWaterfallImpression vpvWaterfallImpression = (VpvWaterfallImpression) obj;
        if (vpvWaterfallImpression == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m22805b(vpvWaterfallImpression, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(VpvWaterfallImpression.class, new VpvWaterfallImpressionSerializer());
    }

    private static void m22805b(VpvWaterfallImpression vpvWaterfallImpression, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "stage", Integer.valueOf(vpvWaterfallImpression.stage));
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "tracking", vpvWaterfallImpression.trackingCodes);
    }
}
