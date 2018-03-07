package com.facebook.ufiservices.util;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLModels.LinkableUtilApplyActorsLinksGraphQLModel;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLParsers.LinkableUtilApplyActorsLinksGraphQLParser;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import java.nio.ByteBuffer;

/* compiled from: crop_profile_picture */
public class C1358x58dbeb5f extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(LinkableUtilApplyActorsLinksGraphQLModel.class, new C1358x58dbeb5f());
    }

    public Object m26888a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        flatBufferBuilder.d(LinkableUtilApplyActorsLinksGraphQLParser.m26942a(jsonParser, flatBufferBuilder));
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
        mutableFlatBuffer.a(4, Boolean.valueOf(true));
        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
        Object linkableUtilApplyActorsLinksGraphQLModel = new LinkableUtilApplyActorsLinksGraphQLModel();
        ((BaseModel) linkableUtilApplyActorsLinksGraphQLModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
        if (linkableUtilApplyActorsLinksGraphQLModel instanceof Postprocessable) {
            return ((Postprocessable) linkableUtilApplyActorsLinksGraphQLModel).a();
        }
        return linkableUtilApplyActorsLinksGraphQLModel;
    }
}
