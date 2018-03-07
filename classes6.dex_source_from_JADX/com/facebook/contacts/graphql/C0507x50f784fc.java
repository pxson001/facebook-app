package com.facebook.contacts.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.contacts.graphql.ContactGraphQLModels.FetchContactsFullQueryModel.MessengerContactsModel;
import com.facebook.contacts.graphql.ContactGraphQLParsers.FetchContactsFullQueryParser.MessengerContactsParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import java.nio.ByteBuffer;

/* compiled from: photo_ */
public class C0507x50f784fc extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(MessengerContactsModel.class, new C0507x50f784fc());
    }

    public Object m11908a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        flatBufferBuilder.d(MessengerContactsParser.a(jsonParser, flatBufferBuilder));
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
        mutableFlatBuffer.a(4, Boolean.valueOf(true));
        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
        Object messengerContactsModel = new MessengerContactsModel();
        ((BaseModel) messengerContactsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
        if (messengerContactsModel instanceof Postprocessable) {
            return ((Postprocessable) messengerContactsModel).a();
        }
        return messengerContactsModel;
    }
}
