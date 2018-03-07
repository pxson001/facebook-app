package com.facebook.contacts.graphql;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.contacts.graphql.ContactGraphQLModels.SquareImageModel;
import com.facebook.contacts.graphql.ContactGraphQLParsers.SquareImageParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: photo_ */
public class ContactGraphQLModels$SquareImageModel$Serializer extends JsonSerializer<SquareImageModel> {
    public final void m11970a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        SquareImageModel squareImageModel = (SquareImageModel) obj;
        if (squareImageModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(squareImageModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            squareImageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        SquareImageParser.a(squareImageModel.w_(), squareImageModel.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(SquareImageModel.class, new ContactGraphQLModels$SquareImageModel$Serializer());
    }
}
