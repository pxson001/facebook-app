package com.facebook.ufiservices.util;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLModels.LinkableUtilApplyAggregatedLinksGraphQLModel;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLParsers.LinkableUtilApplyAggregatedLinksGraphQLParser;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: crop_profile_picture */
public class C1372x2c1a2906 extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(LinkableUtilApplyAggregatedLinksGraphQLModel.class, new C1372x2c1a2906());
    }

    public Object m26906a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = LinkableUtilApplyAggregatedLinksGraphQLParser.m26950a(jsonParser);
        Object linkableUtilApplyAggregatedLinksGraphQLModel = new LinkableUtilApplyAggregatedLinksGraphQLModel();
        ((BaseModel) linkableUtilApplyAggregatedLinksGraphQLModel).a(a, FlatBuffer.a(a.a), jsonParser);
        if (linkableUtilApplyAggregatedLinksGraphQLModel instanceof Postprocessable) {
            return ((Postprocessable) linkableUtilApplyAggregatedLinksGraphQLModel).a();
        }
        return linkableUtilApplyAggregatedLinksGraphQLModel;
    }
}
