package com.facebook.contacts.graphql;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.contacts.graphql.ContactGraphQLModels.CoverPhotoModel;
import com.facebook.contacts.graphql.ContactGraphQLParsers.CoverPhotoParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: photo_ */
public class ContactGraphQLModels$CoverPhotoModel$Serializer extends JsonSerializer<CoverPhotoModel> {
    public final void m11845a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        CoverPhotoModel coverPhotoModel = (CoverPhotoModel) obj;
        if (coverPhotoModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(coverPhotoModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            coverPhotoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        CoverPhotoParser.m11989a(coverPhotoModel.w_(), coverPhotoModel.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(CoverPhotoModel.class, new ContactGraphQLModels$CoverPhotoModel$Serializer());
    }
}
