package com.facebook.graphql.querybuilder.common;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultNameFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Parsers.DefaultNameFieldsParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: edit_page_dialog */
public class CommonGraphQL2Models$DefaultNameFieldsModel$Serializer extends JsonSerializer<DefaultNameFieldsModel> {
    public final void m9615a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        DefaultNameFieldsModel defaultNameFieldsModel = (DefaultNameFieldsModel) obj;
        if (defaultNameFieldsModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(defaultNameFieldsModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            defaultNameFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        DefaultNameFieldsParser.a(defaultNameFieldsModel.w_(), defaultNameFieldsModel.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(DefaultNameFieldsModel.class, new CommonGraphQL2Models$DefaultNameFieldsModel$Serializer());
    }
}
