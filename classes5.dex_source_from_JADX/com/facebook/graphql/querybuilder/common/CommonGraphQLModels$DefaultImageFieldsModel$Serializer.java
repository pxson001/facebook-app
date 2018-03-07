package com.facebook.graphql.querybuilder.common;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultImageFieldsParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: editCommentParams */
public class CommonGraphQLModels$DefaultImageFieldsModel$Serializer extends JsonSerializer<DefaultImageFieldsModel> {
    public final void m9718a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) obj;
        if (defaultImageFieldsModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(defaultImageFieldsModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            defaultImageFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        DefaultImageFieldsParser.a(defaultImageFieldsModel.w_(), defaultImageFieldsModel.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(DefaultImageFieldsModel.class, new CommonGraphQLModels$DefaultImageFieldsModel$Serializer());
    }
}
