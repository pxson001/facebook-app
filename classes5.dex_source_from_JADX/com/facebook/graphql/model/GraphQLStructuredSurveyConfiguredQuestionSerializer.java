package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: US-ASCII */
public class GraphQLStructuredSurveyConfiguredQuestionSerializer extends JsonSerializer<GraphQLStructuredSurveyConfiguredQuestion> {
    public final void m21955a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLStructuredSurveyConfiguredQuestion graphQLStructuredSurveyConfiguredQuestion = (GraphQLStructuredSurveyConfiguredQuestion) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        jsonGenerator.a("allow_write_in_response", graphQLStructuredSurveyConfiguredQuestion.m21945a());
        if (graphQLStructuredSurveyConfiguredQuestion.m21946j() != null) {
            jsonGenerator.a("body");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLStructuredSurveyConfiguredQuestion.m21946j(), true);
        }
        if (graphQLStructuredSurveyConfiguredQuestion.m21947k() != null) {
            jsonGenerator.a("custom_question_type", graphQLStructuredSurveyConfiguredQuestion.m21947k().toString());
        }
        jsonGenerator.a("is_required", graphQLStructuredSurveyConfiguredQuestion.m21948l());
        if (graphQLStructuredSurveyConfiguredQuestion.m21949m() != null) {
            jsonGenerator.a("message");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLStructuredSurveyConfiguredQuestion.m21949m(), true);
        }
        if (graphQLStructuredSurveyConfiguredQuestion.m21950n() != null) {
            jsonGenerator.a("question_class", graphQLStructuredSurveyConfiguredQuestion.m21950n().toString());
        }
        if (graphQLStructuredSurveyConfiguredQuestion.m21951o() != null) {
            jsonGenerator.a("question_id", graphQLStructuredSurveyConfiguredQuestion.m21951o());
        }
        jsonGenerator.a("response_options");
        if (graphQLStructuredSurveyConfiguredQuestion.m21952p() != null) {
            jsonGenerator.d();
            for (GraphQLStructuredSurveyResponseOption graphQLStructuredSurveyResponseOption : graphQLStructuredSurveyConfiguredQuestion.m21952p()) {
                if (graphQLStructuredSurveyResponseOption != null) {
                    GraphQLStructuredSurveyResponseOption__JsonHelper.m21995a(jsonGenerator, graphQLStructuredSurveyResponseOption, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("subquestion_labels");
        if (graphQLStructuredSurveyConfiguredQuestion.m21953q() != null) {
            jsonGenerator.d();
            for (GraphQLTextWithEntities graphQLTextWithEntities : graphQLStructuredSurveyConfiguredQuestion.m21953q()) {
                if (graphQLTextWithEntities != null) {
                    GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLTextWithEntities, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLStructuredSurveyConfiguredQuestion.class, new GraphQLStructuredSurveyConfiguredQuestionSerializer());
    }
}
