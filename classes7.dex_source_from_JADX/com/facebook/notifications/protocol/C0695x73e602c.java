package com.facebook.notifications.protocol;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels.NotificationsEdgeFieldsModel;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLParsers.NotificationsEdgeFieldsParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: negativeFeedbackActionOnReportableEntity */
public class C0695x73e602c extends JsonSerializer<NotificationsEdgeFieldsModel> {
    public final void m10257a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        NotificationsEdgeFieldsModel notificationsEdgeFieldsModel = (NotificationsEdgeFieldsModel) obj;
        if (notificationsEdgeFieldsModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(notificationsEdgeFieldsModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            notificationsEdgeFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        NotificationsEdgeFieldsParser.m10314b(notificationsEdgeFieldsModel.w_(), notificationsEdgeFieldsModel.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(NotificationsEdgeFieldsModel.class, new C0695x73e602c());
    }
}
