package com.facebook.graphql.linkutil;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLModels.GetFeedStoryAttachmentFbLinkGraphQLModel;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLParsers.GetFeedStoryAttachmentFbLinkGraphQLParser.EmployerParser;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLParsers.GetFeedStoryAttachmentFbLinkGraphQLParser.SchoolClassParser;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLParsers.GetFeedStoryAttachmentFbLinkGraphQLParser.SchoolParser;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLParsers.GetFeedStoryAttachmentFbLinkGraphQLParser.WorkProjectParser;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLParsers.GetRedirectionLinkGraphQLParser.RedirectionInfoParser;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: WWW_ACTIVATE */
public class C1135x78e93aea extends JsonSerializer<GetFeedStoryAttachmentFbLinkGraphQLModel> {
    public final void m20487a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        MutableFlatBuffer mutableFlatBuffer;
        GetFeedStoryAttachmentFbLinkGraphQLModel getFeedStoryAttachmentFbLinkGraphQLModel = (GetFeedStoryAttachmentFbLinkGraphQLModel) obj;
        if (getFeedStoryAttachmentFbLinkGraphQLModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(getFeedStoryAttachmentFbLinkGraphQLModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            getFeedStoryAttachmentFbLinkGraphQLModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        mutableFlatBuffer = getFeedStoryAttachmentFbLinkGraphQLModel.w_();
        int u_ = getFeedStoryAttachmentFbLinkGraphQLModel.u_();
        jsonGenerator.f();
        if (mutableFlatBuffer.g(u_, 0) != 0) {
            jsonGenerator.a("__type__");
            SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
        }
        int g = mutableFlatBuffer.g(u_, 1);
        if (g != 0) {
            jsonGenerator.a("employer");
            EmployerParser.m20527a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.g(u_, 2) != 0) {
            jsonGenerator.a("id");
            jsonGenerator.b(mutableFlatBuffer.c(u_, 2));
        }
        g = mutableFlatBuffer.g(u_, 3);
        if (g != 0) {
            jsonGenerator.a("redirection_info");
            RedirectionInfoParser.m20537a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(u_, 4);
        if (g != 0) {
            jsonGenerator.a("school");
            SchoolParser.m20531a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(u_, 5);
        if (g != 0) {
            jsonGenerator.a("school_class");
            SchoolClassParser.m20529a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.g(u_, 6) != 0) {
            jsonGenerator.a("url");
            jsonGenerator.b(mutableFlatBuffer.c(u_, 6));
        }
        g = mutableFlatBuffer.g(u_, 7);
        if (g != 0) {
            jsonGenerator.a("work_project");
            WorkProjectParser.m20533a(mutableFlatBuffer, g, jsonGenerator);
        }
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(GetFeedStoryAttachmentFbLinkGraphQLModel.class, new C1135x78e93aea());
    }
}
