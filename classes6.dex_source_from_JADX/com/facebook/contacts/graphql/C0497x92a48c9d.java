package com.facebook.contacts.graphql;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.contacts.graphql.ContactGraphQLModels.ContactModel.ImportedPhoneEntriesModel;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: photo_ */
public class C0497x92a48c9d extends JsonSerializer<ImportedPhoneEntriesModel> {
    public final void m11797a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        ImportedPhoneEntriesModel importedPhoneEntriesModel = (ImportedPhoneEntriesModel) obj;
        if (importedPhoneEntriesModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(importedPhoneEntriesModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            importedPhoneEntriesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        ContactGraphQLParsers$ContactParser$ImportedPhoneEntriesParser.m11979b(importedPhoneEntriesModel.w_(), importedPhoneEntriesModel.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(ImportedPhoneEntriesModel.class, new C0497x92a48c9d());
    }
}
