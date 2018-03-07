package com.facebook.feed.util.story;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.feed.util.story.FeedStoryUtilGraphQLModels.ShouldDisplayProfilePictureGraphQLModel.ActorsModel.ProfilePictureModel;
import com.facebook.feed.util.story.FeedStoryUtilGraphQLParsers.ShouldDisplayProfilePictureGraphQLParser.ActorsParser.ProfilePictureParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: TQUERY_CONSTRUCTION_PARAM; */
public class C1944xf02def25 extends JsonSerializer<ProfilePictureModel> {
    public final void m25123a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        ProfilePictureModel profilePictureModel = (ProfilePictureModel) obj;
        if (profilePictureModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(profilePictureModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            profilePictureModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        ProfilePictureParser.m25193a(profilePictureModel.w_(), profilePictureModel.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(ProfilePictureModel.class, new C1944xf02def25());
    }
}
