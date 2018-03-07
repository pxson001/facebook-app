package com.facebook.notifications.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels.NotificationsEdgeFieldsModel;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLParsers.NotificationsEdgeFieldsParser;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import java.nio.ByteBuffer;

/* compiled from: negativeFeedbackActionOnReportableEntity */
public class C0692x99cd40ed extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(NotificationsEdgeFieldsModel.class, new C0692x99cd40ed());
    }

    public Object m10205a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        flatBufferBuilder.d(NotificationsEdgeFieldsParser.m10311a(jsonParser, flatBufferBuilder));
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
        mutableFlatBuffer.a(4, Boolean.valueOf(true));
        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
        Object notificationsEdgeFieldsModel = new NotificationsEdgeFieldsModel();
        ((BaseModel) notificationsEdgeFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
        if (notificationsEdgeFieldsModel instanceof Postprocessable) {
            return ((Postprocessable) notificationsEdgeFieldsModel).a();
        }
        return notificationsEdgeFieldsModel;
    }
}
