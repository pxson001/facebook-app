package com.facebook.contacts.graphql;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.contacts.graphql.ContactGraphQLModels.ContactNameModel;
import com.facebook.contacts.graphql.ContactGraphQLParsers.ContactNameParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: photo_ */
public class ContactGraphQLModels$ContactNameModel$Serializer extends JsonSerializer<ContactNameModel> {
    public final void m11822a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        ContactNameModel contactNameModel = (ContactNameModel) obj;
        if (contactNameModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(contactNameModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            contactNameModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        ContactNameParser.a(contactNameModel.w_(), contactNameModel.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(ContactNameModel.class, new ContactGraphQLModels$ContactNameModel$Serializer());
    }
}
