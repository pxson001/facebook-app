package com.facebook.linkify;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.linkify.LinkifyTargetGraphQLModels.LinkifyTargetGraphQLModel.ProfilePictureModel;
import com.facebook.linkify.LinkifyTargetGraphQLParsers.LinkifyTargetGraphQLParser.ProfilePictureParser;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import java.nio.ByteBuffer;

/* compiled from: TELECOM */
public class C1369x815db578 extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(ProfilePictureModel.class, new C1369x815db578());
    }

    public Object m23563a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        flatBufferBuilder.d(ProfilePictureParser.m23566a(jsonParser, flatBufferBuilder));
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
        mutableFlatBuffer.a(4, Boolean.valueOf(true));
        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
        Object profilePictureModel = new ProfilePictureModel();
        ((BaseModel) profilePictureModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
        if (profilePictureModel instanceof Postprocessable) {
            return ((Postprocessable) profilePictureModel).a();
        }
        return profilePictureModel;
    }
}
