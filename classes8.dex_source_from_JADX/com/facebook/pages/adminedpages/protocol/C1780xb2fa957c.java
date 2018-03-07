package com.facebook.pages.adminedpages.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.pages.adminedpages.protocol.AdminedPagesPrefetchGraphQLModels.AdminedPagesPrefetchQueryModel.AdminedPagesModel;
import com.facebook.pages.adminedpages.protocol.AdminedPagesPrefetchGraphQLParsers.AdminedPagesPrefetchQueryParser.AdminedPagesParser;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import java.nio.ByteBuffer;

/* compiled from: currentEntityId must be in initialEntityIds */
public class C1780xb2fa957c extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(AdminedPagesModel.class, new C1780xb2fa957c());
    }

    public Object m19491a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        flatBufferBuilder.d(AdminedPagesParser.a(jsonParser, flatBufferBuilder));
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
        mutableFlatBuffer.a(4, Boolean.valueOf(true));
        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
        Object adminedPagesModel = new AdminedPagesModel();
        ((BaseModel) adminedPagesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
        if (adminedPagesModel instanceof Postprocessable) {
            return ((Postprocessable) adminedPagesModel).a();
        }
        return adminedPagesModel;
    }
}
