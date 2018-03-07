package com.facebook.productionprompts.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.productionprompts.graphql.FetchProductionPromptsGraphQLModels.FetchProductionPromptsQueryModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: user_sem_res_tracking */
public class C0140x2c58fecd extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(FetchProductionPromptsQueryModel.class, new C0140x2c58fecd());
    }

    public Object m3284a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = C0141xeb903f2e.m3285a(jsonParser);
        Object fetchProductionPromptsQueryModel = new FetchProductionPromptsQueryModel();
        ((BaseModel) fetchProductionPromptsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
        if (fetchProductionPromptsQueryModel instanceof Postprocessable) {
            return ((Postprocessable) fetchProductionPromptsQueryModel).a();
        }
        return fetchProductionPromptsQueryModel;
    }
}
