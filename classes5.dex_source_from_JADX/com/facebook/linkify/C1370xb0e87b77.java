package com.facebook.linkify;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.linkify.LinkifyTargetGraphQLModels.LinkifyTargetGraphQLModel.ProfilePictureModel;
import com.facebook.linkify.LinkifyTargetGraphQLParsers.LinkifyTargetGraphQLParser.ProfilePictureParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: TELECOM */
public class C1370xb0e87b77 extends JsonSerializer<ProfilePictureModel> {
    public final void m23564a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        ProfilePictureModel profilePictureModel = (ProfilePictureModel) obj;
        if (profilePictureModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(profilePictureModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            profilePictureModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        ProfilePictureParser.m23567a(profilePictureModel.w_(), profilePictureModel.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(ProfilePictureModel.class, new C1370xb0e87b77());
    }
}
