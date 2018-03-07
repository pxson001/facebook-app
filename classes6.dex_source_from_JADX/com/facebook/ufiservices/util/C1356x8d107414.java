package com.facebook.ufiservices.util;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLModels.LinkableUtilAddLinksGraphQLModel;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLParsers.LinkableUtilAddLinksGraphQLParser;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: crop_profile_picture */
public class C1356x8d107414 extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(LinkableUtilAddLinksGraphQLModel.class, new C1356x8d107414());
    }

    public Object m26886a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = LinkableUtilAddLinksGraphQLParser.m26931a(jsonParser);
        Object linkableUtilAddLinksGraphQLModel = new LinkableUtilAddLinksGraphQLModel();
        ((BaseModel) linkableUtilAddLinksGraphQLModel).a(a, FlatBuffer.a(a.a), jsonParser);
        if (linkableUtilAddLinksGraphQLModel instanceof Postprocessable) {
            return ((Postprocessable) linkableUtilAddLinksGraphQLModel).a();
        }
        return linkableUtilAddLinksGraphQLModel;
    }
}
