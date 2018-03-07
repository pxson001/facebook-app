package com.facebook.feed.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.feed.protocol.QuestionAddPollOptionModels.QuestionAddResponseMutationModel;
import com.facebook.feed.protocol.QuestionAddPollOptionParsers.QuestionAddResponseMutationParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: messenger_user */
public class C0621x9b837268 extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(QuestionAddResponseMutationModel.class, new C0621x9b837268());
    }

    public Object m16403a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = QuestionAddResponseMutationParser.m16405a(jsonParser);
        Object questionAddResponseMutationModel = new QuestionAddResponseMutationModel();
        ((BaseModel) questionAddResponseMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
        if (questionAddResponseMutationModel instanceof Postprocessable) {
            return ((Postprocessable) questionAddResponseMutationModel).a();
        }
        return questionAddResponseMutationModel;
    }
}
