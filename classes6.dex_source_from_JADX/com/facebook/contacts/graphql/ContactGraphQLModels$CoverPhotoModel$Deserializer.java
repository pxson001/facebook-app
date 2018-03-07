package com.facebook.contacts.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.contacts.graphql.ContactGraphQLModels.CoverPhotoModel;
import com.facebook.contacts.graphql.ContactGraphQLParsers.CoverPhotoParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import java.nio.ByteBuffer;

/* compiled from: photo_ */
public class ContactGraphQLModels$CoverPhotoModel$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(CoverPhotoModel.class, new ContactGraphQLModels$CoverPhotoModel$Deserializer());
    }

    public Object m11839a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        flatBufferBuilder.d(CoverPhotoParser.m11988a(jsonParser, flatBufferBuilder));
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
        mutableFlatBuffer.a(4, Boolean.valueOf(true));
        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
        Object coverPhotoModel = new CoverPhotoModel();
        ((BaseModel) coverPhotoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
        if (coverPhotoModel instanceof Postprocessable) {
            return ((Postprocessable) coverPhotoModel).a();
        }
        return coverPhotoModel;
    }
}
