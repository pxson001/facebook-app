package com.facebook.structuredsurvey.util.tokenparams;

import com.facebook.graphql.enums.GraphQLStructuredSurveyQuestionTokenParamType;
import com.facebook.proxygen.HTTPTransportCallback;
import java.util.HashMap;

/* compiled from: login_approval_resend_code */
public class SurveyTokenParamFactory {
    public final HashMap<GraphQLStructuredSurveyQuestionTokenParamType, SurveyTokenParam> f16037a = new HashMap();

    public final SurveyTokenParamFromSession m22862a(GraphQLStructuredSurveyQuestionTokenParamType graphQLStructuredSurveyQuestionTokenParamType) {
        SurveyTokenParamFromSession surveyTokenParamFromSession = (SurveyTokenParamFromSession) this.f16037a.get(graphQLStructuredSurveyQuestionTokenParamType);
        if (surveyTokenParamFromSession != null) {
            return surveyTokenParamFromSession;
        }
        SurveyTokenParamFromSession surveyTokenParamFromSession2 = null;
        switch (1.a[graphQLStructuredSurveyQuestionTokenParamType.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                surveyTokenParamFromSession2 = new SurveyTokenParamFromSession();
                break;
        }
        this.f16037a.put(graphQLStructuredSurveyQuestionTokenParamType, surveyTokenParamFromSession2);
        return surveyTokenParamFromSession2;
    }
}
