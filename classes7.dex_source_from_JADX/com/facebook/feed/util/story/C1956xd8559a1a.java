package com.facebook.feed.util.story;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.feed.util.story.FeedStoryUtilGraphQLModels.ShouldRenderOrganicHScrollGraphQLModel;
import com.facebook.feed.util.story.FeedStoryUtilGraphQLParsers.ShouldRenderOrganicHScrollGraphQLParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: TQUERY_CONSTRUCTION_PARAM; */
public class C1956xd8559a1a extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(ShouldRenderOrganicHScrollGraphQLModel.class, new C1956xd8559a1a());
    }

    public Object m25179a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = ShouldRenderOrganicHScrollGraphQLParser.m25216a(jsonParser);
        Object shouldRenderOrganicHScrollGraphQLModel = new ShouldRenderOrganicHScrollGraphQLModel();
        ((BaseModel) shouldRenderOrganicHScrollGraphQLModel).a(a, FlatBuffer.a(a.a), jsonParser);
        if (shouldRenderOrganicHScrollGraphQLModel instanceof Postprocessable) {
            return ((Postprocessable) shouldRenderOrganicHScrollGraphQLModel).a();
        }
        return shouldRenderOrganicHScrollGraphQLModel;
    }
}
