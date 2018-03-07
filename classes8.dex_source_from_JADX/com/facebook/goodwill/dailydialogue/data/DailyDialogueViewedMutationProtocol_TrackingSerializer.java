package com.facebook.goodwill.dailydialogue.data;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: fetch_admin_type */
public class DailyDialogueViewedMutationProtocol_TrackingSerializer extends JsonSerializer<DailyDialogueViewedMutationProtocol$Tracking> {
    public final void m15058a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        DailyDialogueViewedMutationProtocol$Tracking dailyDialogueViewedMutationProtocol$Tracking = (DailyDialogueViewedMutationProtocol$Tracking) obj;
        if (dailyDialogueViewedMutationProtocol$Tracking == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m15057b(dailyDialogueViewedMutationProtocol$Tracking, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(DailyDialogueViewedMutationProtocol$Tracking.class, new DailyDialogueViewedMutationProtocol_TrackingSerializer());
    }

    private static void m15057b(DailyDialogueViewedMutationProtocol$Tracking dailyDialogueViewedMutationProtocol$Tracking, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "daily_dialogue_lightweight_unit_type", dailyDialogueViewedMutationProtocol$Tracking.type);
        AutoGenJsonHelper.a(jsonGenerator, "daily_dialogue_lightweight_unit_id", dailyDialogueViewedMutationProtocol$Tracking.id);
        AutoGenJsonHelper.a(jsonGenerator, "daily_dialogue_lightweight_extra", dailyDialogueViewedMutationProtocol$Tracking.extra);
    }
}
