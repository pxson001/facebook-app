package com.facebook.notifications.protocol;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels.NotificationsDeltaConnectionFieldsModel;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLParsers.NotificationsDeltaConnectionFieldsParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: negativeFeedbackActionOnReportableEntity */
public class C0690x452ab873 extends JsonSerializer<NotificationsDeltaConnectionFieldsModel> {
    public final void m10183a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        NotificationsDeltaConnectionFieldsModel notificationsDeltaConnectionFieldsModel = (NotificationsDeltaConnectionFieldsModel) obj;
        if (notificationsDeltaConnectionFieldsModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(notificationsDeltaConnectionFieldsModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            notificationsDeltaConnectionFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        NotificationsDeltaConnectionFieldsParser.m10296a(notificationsDeltaConnectionFieldsModel.w_(), notificationsDeltaConnectionFieldsModel.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(NotificationsDeltaConnectionFieldsModel.class, new C0690x452ab873());
    }
}
