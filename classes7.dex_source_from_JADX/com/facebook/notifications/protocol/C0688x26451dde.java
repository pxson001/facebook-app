package com.facebook.notifications.protocol;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels.FirstNotificationsQueryModel;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLParsers.FirstNotificationsQueryParser.NotificationStoriesParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: negativeFeedbackActionOnReportableEntity */
public class C0688x26451dde extends JsonSerializer<FirstNotificationsQueryModel> {
    public final void m10067a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        MutableFlatBuffer mutableFlatBuffer;
        FirstNotificationsQueryModel firstNotificationsQueryModel = (FirstNotificationsQueryModel) obj;
        if (firstNotificationsQueryModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(firstNotificationsQueryModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            firstNotificationsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        mutableFlatBuffer = firstNotificationsQueryModel.w_();
        int u_ = firstNotificationsQueryModel.u_();
        jsonGenerator.f();
        int g = mutableFlatBuffer.g(u_, 0);
        if (g != 0) {
            jsonGenerator.a("notification_stories");
            NotificationStoriesParser.m10266a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(FirstNotificationsQueryModel.class, new C0688x26451dde());
    }
}
