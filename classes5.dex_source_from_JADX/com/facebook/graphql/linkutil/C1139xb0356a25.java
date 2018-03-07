package com.facebook.graphql.linkutil;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLModels.GetRedirectionLinkGraphQLModel.RedirectionInfoModel;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLParsers.GetRedirectionLinkGraphQLParser.RedirectionInfoParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: WWW_ACTIVATE */
public class C1139xb0356a25 extends JsonSerializer<RedirectionInfoModel> {
    public final void m20498a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        RedirectionInfoModel redirectionInfoModel = (RedirectionInfoModel) obj;
        if (redirectionInfoModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(redirectionInfoModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            redirectionInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        RedirectionInfoParser.m20536a(redirectionInfoModel.w_(), redirectionInfoModel.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(RedirectionInfoModel.class, new C1139xb0356a25());
    }
}
