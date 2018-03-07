package com.facebook.graphql.linkutil;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLModels.GetRedirectionLinkGraphQLModel.RedirectionInfoModel;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLParsers.GetRedirectionLinkGraphQLParser.RedirectionInfoParser;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import java.nio.ByteBuffer;

/* compiled from: WWW_ACTIVATE */
public class C1138xe129b0a6 extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(RedirectionInfoModel.class, new C1138xe129b0a6());
    }

    public Object m20497a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        flatBufferBuilder.d(RedirectionInfoParser.m20538b(jsonParser, flatBufferBuilder));
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
        mutableFlatBuffer.a(4, Boolean.valueOf(true));
        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
        Object redirectionInfoModel = new RedirectionInfoModel();
        ((BaseModel) redirectionInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
        if (redirectionInfoModel instanceof Postprocessable) {
            return ((Postprocessable) redirectionInfoModel).a();
        }
        return redirectionInfoModel;
    }
}
