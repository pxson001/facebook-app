package com.facebook.contacts.graphql;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.contacts.graphql.ContactGraphQLModels.FetchContactsFullQueryModel;
import com.facebook.contacts.graphql.ContactGraphQLParsers.FetchContactsFullQueryParser.MessengerContactsParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: photo_ */
public class ContactGraphQLModels$FetchContactsFullQueryModel$Serializer extends JsonSerializer<FetchContactsFullQueryModel> {
    public final void m11910a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        MutableFlatBuffer mutableFlatBuffer;
        FetchContactsFullQueryModel fetchContactsFullQueryModel = (FetchContactsFullQueryModel) obj;
        if (fetchContactsFullQueryModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(fetchContactsFullQueryModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            fetchContactsFullQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        mutableFlatBuffer = fetchContactsFullQueryModel.w_();
        int u_ = fetchContactsFullQueryModel.u_();
        jsonGenerator.f();
        int g = mutableFlatBuffer.g(u_, 0);
        if (g != 0) {
            jsonGenerator.a("messenger_contacts");
            MessengerContactsParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(FetchContactsFullQueryModel.class, new ContactGraphQLModels$FetchContactsFullQueryModel$Serializer());
    }
}
