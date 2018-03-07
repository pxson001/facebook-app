package com.facebook.graphql.linkutil;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLModels.GetFeedStoryAttachmentFbLinkGraphQLModel;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLParsers.GetFeedStoryAttachmentFbLinkGraphQLParser;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: WWW_ACTIVATE */
public class C1131x4c2c642b extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GetFeedStoryAttachmentFbLinkGraphQLModel.class, new C1131x4c2c642b());
    }

    public Object m20462a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GetFeedStoryAttachmentFbLinkGraphQLParser.m20534a(jsonParser);
        Object getFeedStoryAttachmentFbLinkGraphQLModel = new GetFeedStoryAttachmentFbLinkGraphQLModel();
        ((BaseModel) getFeedStoryAttachmentFbLinkGraphQLModel).a(a, FlatBuffer.a(a.a), jsonParser);
        if (getFeedStoryAttachmentFbLinkGraphQLModel instanceof Postprocessable) {
            return ((Postprocessable) getFeedStoryAttachmentFbLinkGraphQLModel).a();
        }
        return getFeedStoryAttachmentFbLinkGraphQLModel;
    }
}
