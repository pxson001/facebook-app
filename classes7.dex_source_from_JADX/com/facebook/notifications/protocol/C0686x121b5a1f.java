package com.facebook.notifications.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels.FirstNotificationsQueryModel;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLParsers.FirstNotificationsQueryParser;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: negativeFeedbackActionOnReportableEntity */
public class C0686x121b5a1f extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(FirstNotificationsQueryModel.class, new C0686x121b5a1f());
    }

    public Object m10054a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = FirstNotificationsQueryParser.m10267a(jsonParser);
        Object firstNotificationsQueryModel = new FirstNotificationsQueryModel();
        ((BaseModel) firstNotificationsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
        if (firstNotificationsQueryModel instanceof Postprocessable) {
            return ((Postprocessable) firstNotificationsQueryModel).a();
        }
        return firstNotificationsQueryModel;
    }
}
