package com.facebook.structuredsurvey.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.structuredsurvey.graphql.SurveyIntegrationPointQueryModels.SurveyIntegrationPointQueryModel;
import com.facebook.structuredsurvey.graphql.SurveyIntegrationPointQueryParsers.SurveyIntegrationPointQueryParser;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: download_duration */
public class C1248x9070e5f8 extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(SurveyIntegrationPointQueryModel.class, new C1248x9070e5f8());
    }

    public Object m24824a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = SurveyIntegrationPointQueryParser.m24826a(jsonParser);
        Object surveyIntegrationPointQueryModel = new SurveyIntegrationPointQueryModel();
        ((BaseModel) surveyIntegrationPointQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
        if (surveyIntegrationPointQueryModel instanceof Postprocessable) {
            return ((Postprocessable) surveyIntegrationPointQueryModel).a();
        }
        return surveyIntegrationPointQueryModel;
    }
}
