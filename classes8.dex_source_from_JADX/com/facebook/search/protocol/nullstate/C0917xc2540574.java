package com.facebook.search.protocol.nullstate;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.search.protocol.nullstate.FetchNullStateModulesGraphQLModels.NullStateModuleQueryModel.ProviderModel.ModulesModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import java.nio.ByteBuffer;

/* compiled from: multi_photo_attachment */
public class C0917xc2540574 extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(ModulesModel.class, new C0917xc2540574());
    }

    public Object m9427a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        flatBufferBuilder.d(C0922x2ae50003.m9483b(jsonParser, flatBufferBuilder));
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
        mutableFlatBuffer.a(4, Boolean.valueOf(true));
        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
        Object modulesModel = new ModulesModel();
        ((BaseModel) modulesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
        if (modulesModel instanceof Postprocessable) {
            return ((Postprocessable) modulesModel).a();
        }
        return modulesModel;
    }
}
