package com.facebook.pages.adminedpages.protocol;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.pages.adminedpages.protocol.AdminedPagesPrefetchGraphQLModels.AdminedPagesPrefetchQueryModel.AdminedPagesModel;
import com.facebook.pages.adminedpages.protocol.AdminedPagesPrefetchGraphQLParsers.AdminedPagesPrefetchQueryParser.AdminedPagesParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: currentEntityId must be in initialEntityIds */
public class C1786x95858c7b extends JsonSerializer<AdminedPagesModel> {
    public final void m19516a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AdminedPagesModel adminedPagesModel = (AdminedPagesModel) obj;
        if (adminedPagesModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(adminedPagesModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            adminedPagesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        AdminedPagesParser.a(adminedPagesModel.w_(), adminedPagesModel.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(AdminedPagesModel.class, new C1786x95858c7b());
    }
}
