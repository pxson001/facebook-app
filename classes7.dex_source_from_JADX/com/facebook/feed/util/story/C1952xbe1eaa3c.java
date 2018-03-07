package com.facebook.feed.util.story;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.feed.util.story.FeedStoryUtilGraphQLModels.ShouldDisplayProfilePictureGraphQLModel;
import com.facebook.feed.util.story.FeedStoryUtilGraphQLParsers.IsPopularObjectsStoryGraphQLParser.AttachmentsParser;
import com.facebook.feed.util.story.FeedStoryUtilGraphQLParsers.ShouldDisplayProfilePictureGraphQLParser.ActorsParser;
import com.facebook.feed.util.story.FeedStoryUtilGraphQLParsers.ShouldDisplayProfilePictureGraphQLParser.AllSubstoriesParser;
import com.facebook.feed.util.story.FeedStoryUtilGraphQLParsers.ShouldDisplayProfilePictureGraphQLParser.AttachedStoryParser;
import com.facebook.feed.util.story.FeedStoryUtilGraphQLParsers.ShouldDisplayProfilePictureGraphQLParser.FeedbackParser;
import com.facebook.feed.util.story.FeedStoryUtilGraphQLParsers.ShouldDisplayProfilePictureGraphQLParser.MessageParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: TQUERY_CONSTRUCTION_PARAM; */
public class C1952xbe1eaa3c extends JsonSerializer<ShouldDisplayProfilePictureGraphQLModel> {
    public final void m25155a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        MutableFlatBuffer mutableFlatBuffer;
        ShouldDisplayProfilePictureGraphQLModel shouldDisplayProfilePictureGraphQLModel = (ShouldDisplayProfilePictureGraphQLModel) obj;
        if (shouldDisplayProfilePictureGraphQLModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(shouldDisplayProfilePictureGraphQLModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            shouldDisplayProfilePictureGraphQLModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        mutableFlatBuffer = shouldDisplayProfilePictureGraphQLModel.w_();
        int u_ = shouldDisplayProfilePictureGraphQLModel.u_();
        jsonGenerator.f();
        int g = mutableFlatBuffer.g(u_, 0);
        if (g != 0) {
            jsonGenerator.a("actors");
            jsonGenerator.d();
            for (int i = 0; i < mutableFlatBuffer.c(g); i++) {
                ActorsParser.m25196b(mutableFlatBuffer, mutableFlatBuffer.m(g, i), jsonGenerator, serializerProvider);
            }
            jsonGenerator.e();
        }
        g = mutableFlatBuffer.g(u_, 1);
        if (g != 0) {
            jsonGenerator.a("all_substories");
            AllSubstoriesParser.m25200a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(u_, 2);
        if (g != 0) {
            jsonGenerator.a("attached_story");
            AttachedStoryParser.m25202a(mutableFlatBuffer, g, jsonGenerator);
        }
        g = mutableFlatBuffer.g(u_, 3);
        if (g != 0) {
            jsonGenerator.a("attachments");
            AttachmentsParser.m25183a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(u_, 4);
        if (g != 0) {
            jsonGenerator.a("feedback");
            FeedbackParser.m25204a(mutableFlatBuffer, g, jsonGenerator);
        }
        boolean a = mutableFlatBuffer.a(u_, 5);
        if (a) {
            jsonGenerator.a("has_comprehensive_title");
            jsonGenerator.a(a);
        }
        g = mutableFlatBuffer.g(u_, 6);
        if (g != 0) {
            jsonGenerator.a("message");
            MessageParser.m25206a(mutableFlatBuffer, g, jsonGenerator);
        }
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(ShouldDisplayProfilePictureGraphQLModel.class, new C1952xbe1eaa3c());
    }
}
