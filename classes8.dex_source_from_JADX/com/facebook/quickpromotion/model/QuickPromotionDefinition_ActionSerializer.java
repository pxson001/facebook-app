package com.facebook.quickpromotion.model;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.Action;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: reaction_events */
public class QuickPromotionDefinition_ActionSerializer extends JsonSerializer<Action> {
    public final void m4622a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        Action action = (Action) obj;
        if (action == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m4621b(action, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(Action.class, new QuickPromotionDefinition_ActionSerializer());
    }

    private static void m4621b(Action action, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "style", action.a());
        AutoGenJsonHelper.a(jsonGenerator, "title", action.title);
        AutoGenJsonHelper.a(jsonGenerator, "url", action.url);
        AutoGenJsonHelper.a(jsonGenerator, "limit", Integer.valueOf(action.limit));
        AutoGenJsonHelper.a(jsonGenerator, "dismiss_promotion", Boolean.valueOf(action.dismissPromotion));
    }
}
