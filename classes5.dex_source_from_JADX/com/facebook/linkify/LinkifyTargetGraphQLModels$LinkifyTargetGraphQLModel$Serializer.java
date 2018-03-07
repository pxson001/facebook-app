package com.facebook.linkify;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.linkify.LinkifyTargetGraphQLModels.LinkifyTargetGraphQLModel;
import com.facebook.linkify.LinkifyTargetGraphQLParsers.LinkifyTargetGraphQLParser.ProfilePictureParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: TELECOM */
public class LinkifyTargetGraphQLModels$LinkifyTargetGraphQLModel$Serializer extends JsonSerializer<LinkifyTargetGraphQLModel> {
    public final void m23565a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        MutableFlatBuffer mutableFlatBuffer;
        LinkifyTargetGraphQLModel linkifyTargetGraphQLModel = (LinkifyTargetGraphQLModel) obj;
        if (linkifyTargetGraphQLModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(linkifyTargetGraphQLModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            linkifyTargetGraphQLModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        mutableFlatBuffer = linkifyTargetGraphQLModel.w_();
        int u_ = linkifyTargetGraphQLModel.u_();
        jsonGenerator.f();
        if (mutableFlatBuffer.g(u_, 0) != 0) {
            jsonGenerator.a("__type__");
            SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
        }
        if (mutableFlatBuffer.g(u_, 1) != 0) {
            jsonGenerator.a("id");
            jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
        }
        if (mutableFlatBuffer.g(u_, 2) != 0) {
            jsonGenerator.a("name");
            jsonGenerator.b(mutableFlatBuffer.c(u_, 2));
        }
        int g = mutableFlatBuffer.g(u_, 3);
        if (g != 0) {
            jsonGenerator.a("profile_picture");
            ProfilePictureParser.m23567a(mutableFlatBuffer, g, jsonGenerator);
        }
        if (mutableFlatBuffer.g(u_, 4) != 0) {
            jsonGenerator.a("url");
            jsonGenerator.b(mutableFlatBuffer.c(u_, 4));
        }
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(LinkifyTargetGraphQLModel.class, new LinkifyTargetGraphQLModels$LinkifyTargetGraphQLModel$Serializer());
    }
}
