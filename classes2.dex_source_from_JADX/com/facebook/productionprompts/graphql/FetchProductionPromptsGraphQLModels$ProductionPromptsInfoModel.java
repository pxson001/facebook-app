package com.facebook.productionprompts.graphql;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLPromptConfidence;
import com.facebook.graphql.enums.GraphQLPromptType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import javax.annotation.Nullable;

@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = 1812988101)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: messenger_image_pipeline_onidle_executors */
public final class FetchProductionPromptsGraphQLModels$ProductionPromptsInfoModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
    @Nullable
    private String f15073d;
    @Nullable
    private GraphQLPromptConfidence f15074e;
    @Nullable
    private DefaultTextWithEntitiesLongFieldsModel f15075f;
    @Nullable
    private PromptImageModel f15076g;
    @Nullable
    private PromptSurveyModel f15077h;
    @Nullable
    private PromptTitleModel f15078i;
    @Nullable
    private GraphQLPromptType f15079j;
    private double f15080k;
    @Nullable
    private SuggestedCompositionModel f15081l;
    @Nullable
    private TimeRangeModel f15082m;
    @Nullable
    private String f15083n;

    public FetchProductionPromptsGraphQLModels$ProductionPromptsInfoModel() {
        super(11);
    }

    public final void mo2835a(String str, ConsistencyTuple consistencyTuple) {
        if ("id".equals(str)) {
            consistencyTuple.f18727a = m21613j();
            consistencyTuple.f18728b = u_();
            consistencyTuple.f18729c = 0;
            return;
        }
        consistencyTuple.m26322a();
    }

    public final void mo2836a(String str, Object obj, boolean z) {
        if ("id".equals(str)) {
            m21606a((String) obj);
        }
    }

    @Nullable
    public final String m21613j() {
        this.f15073d = super.m9948a(this.f15073d, 0);
        return this.f15073d;
    }

    private void m21606a(@Nullable String str) {
        this.f15073d = str;
        if (this.f5823b != null && this.f5823b.f15024d) {
            this.f5823b.m21537a(this.f5824c, 0, str);
        }
    }

    @Nullable
    public final GraphQLPromptConfidence m21614k() {
        this.f15074e = (GraphQLPromptConfidence) super.m9954b(this.f15074e, 1, GraphQLPromptConfidence.class, GraphQLPromptConfidence.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f15074e;
    }

    @Nullable
    public final DefaultTextWithEntitiesLongFieldsModel m21615l() {
        this.f15075f = (DefaultTextWithEntitiesLongFieldsModel) super.m9947a(this.f15075f, 2, DefaultTextWithEntitiesLongFieldsModel.class);
        return this.f15075f;
    }

    @Nullable
    public final PromptImageModel m21616m() {
        this.f15076g = (PromptImageModel) super.m9947a(this.f15076g, 3, PromptImageModel.class);
        return this.f15076g;
    }

    @Nullable
    public final PromptSurveyModel m21617n() {
        this.f15077h = (PromptSurveyModel) super.m9947a(this.f15077h, 4, PromptSurveyModel.class);
        return this.f15077h;
    }

    @Nullable
    public final PromptTitleModel m21618o() {
        this.f15078i = (PromptTitleModel) super.m9947a(this.f15078i, 5, PromptTitleModel.class);
        return this.f15078i;
    }

    @Nullable
    public final GraphQLPromptType m21619p() {
        this.f15079j = (GraphQLPromptType) super.m9954b(this.f15079j, 6, GraphQLPromptType.class, GraphQLPromptType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f15079j;
    }

    public final double m21620q() {
        m9949a(0, 7);
        return this.f15080k;
    }

    @Nullable
    public final SuggestedCompositionModel m21621r() {
        this.f15081l = (SuggestedCompositionModel) super.m9947a(this.f15081l, 8, SuggestedCompositionModel.class);
        return this.f15081l;
    }

    @Nullable
    public final TimeRangeModel m21622s() {
        this.f15082m = (TimeRangeModel) super.m9947a(this.f15082m, 9, TimeRangeModel.class);
        return this.f15082m;
    }

    @Nullable
    public final String m21623t() {
        this.f15083n = super.m9948a(this.f15083n, 10);
        return this.f15083n;
    }

    @Nullable
    public final String mo2834a() {
        return m21613j();
    }

    public final int jK_() {
        return -1976808547;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m21615l() != null) {
            DefaultTextWithEntitiesLongFieldsModel defaultTextWithEntitiesLongFieldsModel = (DefaultTextWithEntitiesLongFieldsModel) graphQLModelMutatingVisitor.mo2928b(m21615l());
            if (m21615l() != defaultTextWithEntitiesLongFieldsModel) {
                graphQLVisitableModel = (FetchProductionPromptsGraphQLModels$ProductionPromptsInfoModel) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f15075f = defaultTextWithEntitiesLongFieldsModel;
            }
        }
        if (m21616m() != null) {
            PromptImageModel promptImageModel = (PromptImageModel) graphQLModelMutatingVisitor.mo2928b(m21616m());
            if (m21616m() != promptImageModel) {
                graphQLVisitableModel = (FetchProductionPromptsGraphQLModels$ProductionPromptsInfoModel) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f15076g = promptImageModel;
            }
        }
        if (m21617n() != null) {
            PromptSurveyModel promptSurveyModel = (PromptSurveyModel) graphQLModelMutatingVisitor.mo2928b(m21617n());
            if (m21617n() != promptSurveyModel) {
                graphQLVisitableModel = (FetchProductionPromptsGraphQLModels$ProductionPromptsInfoModel) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f15077h = promptSurveyModel;
            }
        }
        if (m21618o() != null) {
            PromptTitleModel promptTitleModel = (PromptTitleModel) graphQLModelMutatingVisitor.mo2928b(m21618o());
            if (m21618o() != promptTitleModel) {
                graphQLVisitableModel = (FetchProductionPromptsGraphQLModels$ProductionPromptsInfoModel) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f15078i = promptTitleModel;
            }
        }
        if (m21621r() != null) {
            SuggestedCompositionModel suggestedCompositionModel = (SuggestedCompositionModel) graphQLModelMutatingVisitor.mo2928b(m21621r());
            if (m21621r() != suggestedCompositionModel) {
                graphQLVisitableModel = (FetchProductionPromptsGraphQLModels$ProductionPromptsInfoModel) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f15081l = suggestedCompositionModel;
            }
        }
        if (m21622s() != null) {
            TimeRangeModel timeRangeModel = (TimeRangeModel) graphQLModelMutatingVisitor.mo2928b(m21622s());
            if (m21622s() != timeRangeModel) {
                graphQLVisitableModel = (FetchProductionPromptsGraphQLModels$ProductionPromptsInfoModel) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f15082m = timeRangeModel;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(m21613j());
        int a = flatBufferBuilder.m21477a(m21614k());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m21615l());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m21616m());
        int a4 = ModelHelper.m23093a(flatBufferBuilder, m21617n());
        int a5 = ModelHelper.m23093a(flatBufferBuilder, m21618o());
        int a6 = flatBufferBuilder.m21477a(m21619p());
        int a7 = ModelHelper.m23093a(flatBufferBuilder, m21621r());
        int a8 = ModelHelper.m23093a(flatBufferBuilder, m21622s());
        int b2 = flatBufferBuilder.m21502b(m21623t());
        flatBufferBuilder.m21510c(11);
        flatBufferBuilder.m21507b(0, b);
        flatBufferBuilder.m21507b(1, a);
        flatBufferBuilder.m21507b(2, a2);
        flatBufferBuilder.m21507b(3, a3);
        flatBufferBuilder.m21507b(4, a4);
        flatBufferBuilder.m21507b(5, a5);
        flatBufferBuilder.m21507b(6, a6);
        flatBufferBuilder.m21492a(7, this.f15080k, 0.0d);
        flatBufferBuilder.m21507b(8, a7);
        flatBufferBuilder.m21507b(9, a8);
        flatBufferBuilder.m21507b(10, b2);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f15080k = mutableFlatBuffer.m21523a(i, 7, 0.0d);
    }
}
