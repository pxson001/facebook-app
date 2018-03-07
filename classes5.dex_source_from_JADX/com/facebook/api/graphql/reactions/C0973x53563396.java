package com.facebook.api.graphql.reactions;

import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ReactionsCountFieldsModel.TopReactionsModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.ReactionsCountFieldsParser.TopReactionsParser;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: android_place_picker_long_press_report_duplicates */
public class C0973x53563396 extends JsonSerializer<TopReactionsModel> {
    public final void m17057a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        TopReactionsModel topReactionsModel = (TopReactionsModel) obj;
        if (topReactionsModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(topReactionsModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            topReactionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        TopReactionsParser.m17160a(topReactionsModel.w_(), topReactionsModel.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(TopReactionsModel.class, new C0973x53563396());
    }
}
