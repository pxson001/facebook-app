package com.facebook.pages.adminedpages.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.pages.adminedpages.protocol.AdminedPagesPrefetchGraphQLModels.AdminedPagesPrefetchQueryModel.AdminedPagesModel.NodesModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import java.nio.ByteBuffer;

/* compiled from: currentEntityId must be in initialEntityIds */
public class C1783xa88d12d6 extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(NodesModel.class, new C1783xa88d12d6());
    }

    public Object m19507a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        flatBufferBuilder.d(C1789x4f009d7.m19524b(jsonParser, flatBufferBuilder));
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
        mutableFlatBuffer.a(4, Boolean.valueOf(true));
        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
        Object nodesModel = new NodesModel();
        ((BaseModel) nodesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
        if (nodesModel instanceof Postprocessable) {
            return ((Postprocessable) nodesModel).a();
        }
        return nodesModel;
    }
}
