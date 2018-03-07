package com.facebook.graphql.querybuilder.common;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultNamePartFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Parsers.DefaultNamePartFieldsParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: edit_page_dialog */
public class CommonGraphQL2Models$DefaultNamePartFieldsModel$Serializer extends JsonSerializer<DefaultNamePartFieldsModel> {
    public final void m9617a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        DefaultNamePartFieldsModel defaultNamePartFieldsModel = (DefaultNamePartFieldsModel) obj;
        if (defaultNamePartFieldsModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(defaultNamePartFieldsModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            defaultNamePartFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        DefaultNamePartFieldsParser.a(defaultNamePartFieldsModel.w_(), defaultNamePartFieldsModel.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(DefaultNamePartFieldsModel.class, new CommonGraphQL2Models$DefaultNamePartFieldsModel$Serializer());
    }
}
