package com.facebook.privacy.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.privacy.protocol.FetchAudienceInfoModels.FetchAudienceInfoForLoginModel;
import com.facebook.privacy.protocol.FetchAudienceInfoParsers.FetchAudienceInfoForLoginParser;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: sticker_source_object_id */
public class C0233x9e0ff2ec extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(FetchAudienceInfoForLoginModel.class, new C0233x9e0ff2ec());
    }

    public Object m6042a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = FetchAudienceInfoForLoginParser.m6047a(jsonParser);
        Object fetchAudienceInfoForLoginModel = new FetchAudienceInfoForLoginModel();
        ((BaseModel) fetchAudienceInfoForLoginModel).a(a, FlatBuffer.a(a.a), jsonParser);
        if (fetchAudienceInfoForLoginModel instanceof Postprocessable) {
            return ((Postprocessable) fetchAudienceInfoForLoginModel).a();
        }
        return fetchAudienceInfoForLoginModel;
    }
}
