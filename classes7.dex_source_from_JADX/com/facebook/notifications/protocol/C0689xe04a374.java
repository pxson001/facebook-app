package com.facebook.notifications.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels.NotificationsDeltaConnectionFieldsModel;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLParsers.NotificationsDeltaConnectionFieldsParser;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import java.nio.ByteBuffer;

/* compiled from: negativeFeedbackActionOnReportableEntity */
public class C0689xe04a374 extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(NotificationsDeltaConnectionFieldsModel.class, new C0689xe04a374());
    }

    public Object m10182a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        flatBufferBuilder.d(NotificationsDeltaConnectionFieldsParser.m10295a(jsonParser, flatBufferBuilder));
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
        mutableFlatBuffer.a(4, Boolean.valueOf(true));
        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
        Object notificationsDeltaConnectionFieldsModel = new NotificationsDeltaConnectionFieldsModel();
        ((BaseModel) notificationsDeltaConnectionFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
        if (notificationsDeltaConnectionFieldsModel instanceof Postprocessable) {
            return ((Postprocessable) notificationsDeltaConnectionFieldsModel).a();
        }
        return notificationsDeltaConnectionFieldsModel;
    }
}
