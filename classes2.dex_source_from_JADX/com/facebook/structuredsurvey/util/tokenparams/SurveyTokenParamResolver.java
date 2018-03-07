package com.facebook.structuredsurvey.util.tokenparams;

import com.facebook.survey.graphql.StructuredSurveySessionFragmentsModels.StructuredSurveyQuestionTokenParamFragmentModel;
import com.google.common.collect.ImmutableList;

/* compiled from: loginBypassWithMessengerCredentials */
public class SurveyTokenParamResolver {
    private final SurveyTokenParamFactory f16038a;

    public SurveyTokenParamResolver(SurveyTokenParamFactory surveyTokenParamFactory) {
        this.f16038a = surveyTokenParamFactory;
    }

    public final String m22863a(String str, ImmutableList<StructuredSurveyQuestionTokenParamFragmentModel> immutableList) {
        int size = immutableList.size();
        int i = 0;
        String str2 = str;
        while (i < size) {
            StructuredSurveyQuestionTokenParamFragmentModel structuredSurveyQuestionTokenParamFragmentModel = (StructuredSurveyQuestionTokenParamFragmentModel) immutableList.get(i);
            SurveyTokenParamFromSession a = this.f16038a.m22862a(structuredSurveyQuestionTokenParamFragmentModel.j());
            String a2 = structuredSurveyQuestionTokenParamFragmentModel.a();
            if (a != null) {
                String str3 = (String) a.a.get(a2);
                if (str3 != null) {
                    a2 = str2.replace("{" + a2 + "}", str3);
                    i++;
                    str2 = a2;
                }
            }
            a2 = str2;
            i++;
            str2 = a2;
        }
        return str2;
    }
}
