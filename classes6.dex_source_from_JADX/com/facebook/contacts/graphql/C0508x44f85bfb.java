package com.facebook.contacts.graphql;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.contacts.graphql.ContactGraphQLModels.FetchContactsFullQueryModel.MessengerContactsModel;
import com.facebook.contacts.graphql.ContactGraphQLParsers.FetchContactsFullQueryParser.MessengerContactsParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: photo_ */
public class C0508x44f85bfb extends JsonSerializer<MessengerContactsModel> {
    public final void m11909a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        MessengerContactsModel messengerContactsModel = (MessengerContactsModel) obj;
        if (messengerContactsModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(messengerContactsModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            messengerContactsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        MessengerContactsParser.a(messengerContactsModel.w_(), messengerContactsModel.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(MessengerContactsModel.class, new C0508x44f85bfb());
    }
}
