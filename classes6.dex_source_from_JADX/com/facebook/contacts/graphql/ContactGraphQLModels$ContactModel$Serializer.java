package com.facebook.contacts.graphql;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.contacts.graphql.ContactGraphQLModels.ContactModel;
import com.facebook.contacts.graphql.ContactGraphQLParsers.ContactParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: photo_ */
public class ContactGraphQLModels$ContactModel$Serializer extends JsonSerializer<ContactModel> {
    public final void m11818a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        ContactModel contactModel = (ContactModel) obj;
        if (contactModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(contactModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            contactModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        ContactParser.b(contactModel.w_(), contactModel.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(ContactModel.class, new ContactGraphQLModels$ContactModel$Serializer());
    }
}
