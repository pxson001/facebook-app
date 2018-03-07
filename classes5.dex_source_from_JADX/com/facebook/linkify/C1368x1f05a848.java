package com.facebook.linkify;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.linkify.LinkifyTargetGraphQLModels.LinkifyTargetGraphQLModel;
import com.facebook.linkify.LinkifyTargetGraphQLParsers.LinkifyTargetGraphQLParser;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: TELECOM */
public class C1368x1f05a848 extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(LinkifyTargetGraphQLModel.class, new C1368x1f05a848());
    }

    public Object m23562a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = LinkifyTargetGraphQLParser.m23568a(jsonParser);
        Object linkifyTargetGraphQLModel = new LinkifyTargetGraphQLModel();
        ((BaseModel) linkifyTargetGraphQLModel).a(a, FlatBuffer.a(a.a), jsonParser);
        if (linkifyTargetGraphQLModel instanceof Postprocessable) {
            return ((Postprocessable) linkifyTargetGraphQLModel).a();
        }
        return linkifyTargetGraphQLModel;
    }
}
