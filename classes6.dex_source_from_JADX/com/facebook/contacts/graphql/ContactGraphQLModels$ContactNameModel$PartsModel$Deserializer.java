package com.facebook.contacts.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.contacts.graphql.ContactGraphQLModels.ContactNameModel.PartsModel;
import com.facebook.contacts.graphql.ContactGraphQLParsers.ContactNameParser.PartsParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import java.nio.ByteBuffer;

/* compiled from: photo_ */
public class ContactGraphQLModels$ContactNameModel$PartsModel$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(PartsModel.class, new ContactGraphQLModels$ContactNameModel$PartsModel$Deserializer());
    }

    public Object m11820a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        flatBufferBuilder.d(PartsParser.b(jsonParser, flatBufferBuilder));
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
        mutableFlatBuffer.a(4, Boolean.valueOf(true));
        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
        Object partsModel = new PartsModel();
        ((BaseModel) partsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
        if (partsModel instanceof Postprocessable) {
            return ((Postprocessable) partsModel).a();
        }
        return partsModel;
    }
}
