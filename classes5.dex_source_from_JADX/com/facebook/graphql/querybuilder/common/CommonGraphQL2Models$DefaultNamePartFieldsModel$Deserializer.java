package com.facebook.graphql.querybuilder.common;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultNamePartFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Parsers.DefaultNamePartFieldsParser;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import java.nio.ByteBuffer;

/* compiled from: edit_page_dialog */
public class CommonGraphQL2Models$DefaultNamePartFieldsModel$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(DefaultNamePartFieldsModel.class, new CommonGraphQL2Models$DefaultNamePartFieldsModel$Deserializer());
    }

    public Object m9616a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        flatBufferBuilder.d(DefaultNamePartFieldsParser.b(jsonParser, flatBufferBuilder));
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
        mutableFlatBuffer.a(4, Boolean.valueOf(true));
        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
        Object defaultNamePartFieldsModel = new DefaultNamePartFieldsModel();
        ((BaseModel) defaultNamePartFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
        if (defaultNamePartFieldsModel instanceof Postprocessable) {
            return ((Postprocessable) defaultNamePartFieldsModel).a();
        }
        return defaultNamePartFieldsModel;
    }
}
