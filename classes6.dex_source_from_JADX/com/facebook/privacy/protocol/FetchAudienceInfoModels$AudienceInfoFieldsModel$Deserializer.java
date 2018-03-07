package com.facebook.privacy.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.privacy.protocol.FetchAudienceInfoModels.AudienceInfoFieldsModel;
import com.facebook.privacy.protocol.FetchAudienceInfoParsers.AudienceInfoFieldsParser;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import java.nio.ByteBuffer;

/* compiled from: sticker_source_object_id */
public class FetchAudienceInfoModels$AudienceInfoFieldsModel$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(AudienceInfoFieldsModel.class, new FetchAudienceInfoModels$AudienceInfoFieldsModel$Deserializer());
    }

    public Object m6040a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        flatBufferBuilder.d(AudienceInfoFieldsParser.a(jsonParser, flatBufferBuilder));
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
        mutableFlatBuffer.a(4, Boolean.valueOf(true));
        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
        Object audienceInfoFieldsModel = new AudienceInfoFieldsModel();
        ((BaseModel) audienceInfoFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
        if (audienceInfoFieldsModel instanceof Postprocessable) {
            return ((Postprocessable) audienceInfoFieldsModel).a();
        }
        return audienceInfoFieldsModel;
    }
}
