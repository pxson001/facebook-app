package com.facebook.pages.data.graphql.notificationcounts;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.pages.data.graphql.notificationcounts.FetchNotificationCountsGraphQLModels.FetchNotificationCountsQueryModel;
import com.facebook.pages.data.graphql.notificationcounts.FetchNotificationCountsGraphQLParsers.FetchNotificationCountsQueryParser.AdminedPagesParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: reactionStories' feedUnitFragment's title is null */
public class C0363xef0536a6 extends JsonSerializer<FetchNotificationCountsQueryModel> {
    public final void m3682a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        MutableFlatBuffer mutableFlatBuffer;
        FetchNotificationCountsQueryModel fetchNotificationCountsQueryModel = (FetchNotificationCountsQueryModel) obj;
        if (fetchNotificationCountsQueryModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(fetchNotificationCountsQueryModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            fetchNotificationCountsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        mutableFlatBuffer = fetchNotificationCountsQueryModel.w_();
        int u_ = fetchNotificationCountsQueryModel.u_();
        jsonGenerator.f();
        int g = mutableFlatBuffer.g(u_, 0);
        if (g != 0) {
            jsonGenerator.a("admined_pages");
            AdminedPagesParser.m3723a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(FetchNotificationCountsQueryModel.class, new C0363xef0536a6());
    }
}
