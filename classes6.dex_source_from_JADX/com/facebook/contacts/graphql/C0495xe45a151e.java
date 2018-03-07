package com.facebook.contacts.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.contacts.graphql.ContactGraphQLModels.ContactModel.ImportedPhoneEntriesModel;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import java.nio.ByteBuffer;

/* compiled from: photo_ */
public class C0495xe45a151e extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(ImportedPhoneEntriesModel.class, new C0495xe45a151e());
    }

    public Object m11786a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        flatBufferBuilder.d(ContactGraphQLParsers$ContactParser$ImportedPhoneEntriesParser.m11978b(jsonParser, flatBufferBuilder));
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
        mutableFlatBuffer.a(4, Boolean.valueOf(true));
        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
        Object importedPhoneEntriesModel = new ImportedPhoneEntriesModel();
        ((BaseModel) importedPhoneEntriesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
        if (importedPhoneEntriesModel instanceof Postprocessable) {
            return ((Postprocessable) importedPhoneEntriesModel).a();
        }
        return importedPhoneEntriesModel;
    }
}
