package com.facebook.feedback.reactions.api;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionSettingsQueryModel;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: selected_privacy_option */
public class C0129xdb2602a7 extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(FetchFeedbackReactionSettingsQueryModel.class, new C0129xdb2602a7());
    }

    public Object m3121a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = C0130x16adaa6a.m3122a(jsonParser);
        Object fetchFeedbackReactionSettingsQueryModel = new FetchFeedbackReactionSettingsQueryModel();
        ((BaseModel) fetchFeedbackReactionSettingsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
        if (fetchFeedbackReactionSettingsQueryModel instanceof Postprocessable) {
            return ((Postprocessable) fetchFeedbackReactionSettingsQueryModel).a();
        }
        return fetchFeedbackReactionSettingsQueryModel;
    }
}
