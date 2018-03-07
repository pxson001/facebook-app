package com.facebook.pages.adminedpages.protocol;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.pages.adminedpages.protocol.AdminedPagesPrefetchGraphQLModels.AdminedPagesPrefetchQueryModel;
import com.facebook.pages.adminedpages.protocol.AdminedPagesPrefetchGraphQLParsers.AdminedPagesPrefetchQueryParser.AdminedPagesParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: currentEntityId must be in initialEntityIds */
public class C1788xa17f35aa extends JsonSerializer<AdminedPagesPrefetchQueryModel> {
    public final void m19519a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        MutableFlatBuffer mutableFlatBuffer;
        AdminedPagesPrefetchQueryModel adminedPagesPrefetchQueryModel = (AdminedPagesPrefetchQueryModel) obj;
        if (adminedPagesPrefetchQueryModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(adminedPagesPrefetchQueryModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            adminedPagesPrefetchQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        mutableFlatBuffer = adminedPagesPrefetchQueryModel.w_();
        int u_ = adminedPagesPrefetchQueryModel.u_();
        jsonGenerator.f();
        int g = mutableFlatBuffer.g(u_, 0);
        if (g != 0) {
            jsonGenerator.a("admined_pages");
            AdminedPagesParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(AdminedPagesPrefetchQueryModel.class, new C1788xa17f35aa());
    }
}
