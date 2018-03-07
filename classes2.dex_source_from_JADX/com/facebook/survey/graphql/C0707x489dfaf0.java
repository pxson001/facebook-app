package com.facebook.survey.graphql;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.survey.graphql.StructuredSurveySessionFragmentsModels$StructuredSurveySessionFragmentModel.Deserializer;
import com.facebook.survey.graphql.StructuredSurveySessionFragmentsModels$StructuredSurveySessionFragmentModel.Serializer;
import com.facebook.survey.graphql.StructuredSurveySessionFragmentsModels$StructuredSurveySessionFragmentModel.SurveyModel;
import com.facebook.survey.graphql.StructuredSurveySessionFragmentsModels.SurveyConfigFragmentModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import javax.annotation.Nullable;

@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = -1337999988)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: location_age_seconds */
public final class C0707x489dfaf0 extends BaseModel implements GraphQLVisitableModel {
    @Nullable
    private SurveyConfigFragmentModel f16701d;
    @Nullable
    private String f16702e;
    @Nullable
    private String f16703f;
    @Nullable
    private SurveyModel f16704g;

    public C0707x489dfaf0() {
        super(4);
    }

    @Nullable
    public final SurveyConfigFragmentModel m23599a() {
        this.f16701d = (SurveyConfigFragmentModel) super.m9947a(this.f16701d, 0, SurveyConfigFragmentModel.class);
        return this.f16701d;
    }

    @Nullable
    public final String m23600j() {
        this.f16702e = super.m9948a(this.f16702e, 1);
        return this.f16702e;
    }

    @Nullable
    public final String m23601k() {
        this.f16703f = super.m9948a(this.f16703f, 2);
        return this.f16703f;
    }

    @Nullable
    public final SurveyModel m23602l() {
        this.f16704g = (SurveyModel) super.m9947a(this.f16704g, 3, SurveyModel.class);
        return this.f16704g;
    }

    public final int jK_() {
        return 1205816299;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m23599a() != null) {
            SurveyConfigFragmentModel surveyConfigFragmentModel = (SurveyConfigFragmentModel) graphQLModelMutatingVisitor.mo2928b(m23599a());
            if (m23599a() != surveyConfigFragmentModel) {
                graphQLVisitableModel = (C0707x489dfaf0) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16701d = surveyConfigFragmentModel;
            }
        }
        if (m23602l() != null) {
            SurveyModel surveyModel = (SurveyModel) graphQLModelMutatingVisitor.mo2928b(m23602l());
            if (m23602l() != surveyModel) {
                graphQLVisitableModel = (C0707x489dfaf0) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16704g = surveyModel;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m23599a());
        int b = flatBufferBuilder.m21502b(m23600j());
        int b2 = flatBufferBuilder.m21502b(m23601k());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m23602l());
        flatBufferBuilder.m21510c(4);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, b);
        flatBufferBuilder.m21507b(2, b2);
        flatBufferBuilder.m21507b(3, a2);
        m9959i();
        return flatBufferBuilder.m21511d();
    }
}
