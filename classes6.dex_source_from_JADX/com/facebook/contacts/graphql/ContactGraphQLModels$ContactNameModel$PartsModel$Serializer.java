package com.facebook.contacts.graphql;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.contacts.graphql.ContactGraphQLModels.ContactNameModel.PartsModel;
import com.facebook.contacts.graphql.ContactGraphQLParsers.ContactNameParser.PartsParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: photo_ */
public class ContactGraphQLModels$ContactNameModel$PartsModel$Serializer extends JsonSerializer<PartsModel> {
    public final void m11821a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        PartsModel partsModel = (PartsModel) obj;
        if (partsModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(partsModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            partsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        PartsParser.a(partsModel.w_(), partsModel.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(PartsModel.class, new ContactGraphQLModels$ContactNameModel$PartsModel$Serializer());
    }
}
