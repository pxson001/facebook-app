package com.facebook.pages.adminedpages.protocol;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.pages.adminedpages.protocol.AdminedPagesPrefetchGraphQLModels.AdminedPagesPrefetchQueryModel.AdminedPagesModel.NodesModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: currentEntityId must be in initialEntityIds */
public class C1785xac6b9855 extends JsonSerializer<NodesModel> {
    public final void m19515a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        NodesModel nodesModel = (NodesModel) obj;
        if (nodesModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(nodesModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        C1789x4f009d7.m19525b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(NodesModel.class, new C1785xac6b9855());
    }
}
