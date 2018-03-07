package com.facebook.directinstall.util;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.directinstall.util.DirectInstallApplicationUtilsGraphQLModels.GetNativeAppDetailsActorGraphQLModel;
import com.facebook.directinstall.util.DirectInstallApplicationUtilsGraphQLParsers.GetNativeAppDetailsActorGraphQLParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: ogActionType */
public class C0590xd7ce94c extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GetNativeAppDetailsActorGraphQLModel.class, new C0590xd7ce94c());
    }

    public Object m12564a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GetNativeAppDetailsActorGraphQLParser.m12661a(jsonParser);
        Object getNativeAppDetailsActorGraphQLModel = new GetNativeAppDetailsActorGraphQLModel();
        ((BaseModel) getNativeAppDetailsActorGraphQLModel).a(a, FlatBuffer.a(a.a), jsonParser);
        if (getNativeAppDetailsActorGraphQLModel instanceof Postprocessable) {
            return ((Postprocessable) getNativeAppDetailsActorGraphQLModel).a();
        }
        return getNativeAppDetailsActorGraphQLModel;
    }
}
