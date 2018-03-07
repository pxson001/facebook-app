package com.facebook.structuredsurvey.graphql;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.structuredsurvey.graphql.SurveyIntegrationPointQueryModels$SurveyIntegrationPointQueryModel.Deserializer;
import com.facebook.structuredsurvey.graphql.SurveyIntegrationPointQueryModels$SurveyIntegrationPointQueryModel.Serializer;
import com.facebook.survey.graphql.C0707x489dfaf0;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import javax.annotation.Nullable;

@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = 2049568670)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: logging_level */
public final class C0694x5f57d37f extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
    @Nullable
    private String f16043d;
    @Nullable
    private String f16044e;
    @Nullable
    private C0707x489dfaf0 f16045f;

    public C0694x5f57d37f() {
        super(3);
    }

    @Nullable
    private String m22868k() {
        this.f16043d = super.m9948a(this.f16043d, 0);
        return this.f16043d;
    }

    @Nullable
    private String m22869l() {
        this.f16044e = super.m9948a(this.f16044e, 1);
        return this.f16044e;
    }

    @Nullable
    public final C0707x489dfaf0 m22873j() {
        this.f16045f = (C0707x489dfaf0) super.m9947a(this.f16045f, 2, C0707x489dfaf0.class);
        return this.f16045f;
    }

    @Nullable
    public final String mo2834a() {
        return m22868k();
    }

    public final int jK_() {
        return -781314122;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m22873j() != null) {
            C0707x489dfaf0 c0707x489dfaf0 = (C0707x489dfaf0) graphQLModelMutatingVisitor.mo2928b(m22873j());
            if (m22873j() != c0707x489dfaf0) {
                graphQLVisitableModel = (C0694x5f57d37f) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16045f = c0707x489dfaf0;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(m22868k());
        int b2 = flatBufferBuilder.m21502b(m22869l());
        int a = ModelHelper.m23093a(flatBufferBuilder, m22873j());
        flatBufferBuilder.m21510c(3);
        flatBufferBuilder.m21507b(0, b);
        flatBufferBuilder.m21507b(1, b2);
        flatBufferBuilder.m21507b(2, a);
        m9959i();
        return flatBufferBuilder.m21511d();
    }
}
