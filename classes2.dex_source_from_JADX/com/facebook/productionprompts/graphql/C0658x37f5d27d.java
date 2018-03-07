package com.facebook.productionprompts.graphql;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLPromptConfidence;
import com.facebook.graphql.enums.GraphQLPromptType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.productionprompts.graphql.FetchProductionPromptsGraphQLModels$ClientProductionPromptsInfoModel.Deserializer;
import com.facebook.productionprompts.graphql.FetchProductionPromptsGraphQLModels$ClientProductionPromptsInfoModel.Serializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import javax.annotation.Nullable;

@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = -180236914)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: messenger_image_pipeline_onidle_executors */
public final class C0658x37f5d27d extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
    @Nullable
    private String f15086d;
    @Nullable
    private GraphQLPromptConfidence f15087e;
    @Nullable
    private GraphQLPromptType f15088f;
    private double f15089g;
    @Nullable
    private String f15090h;

    public C0658x37f5d27d() {
        super(5);
    }

    @Nullable
    private String m21630n() {
        this.f15086d = super.m9948a(this.f15086d, 0);
        return this.f15086d;
    }

    @Nullable
    public final GraphQLPromptConfidence m21635j() {
        this.f15087e = (GraphQLPromptConfidence) super.m9954b(this.f15087e, 1, GraphQLPromptConfidence.class, GraphQLPromptConfidence.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f15087e;
    }

    @Nullable
    public final GraphQLPromptType m21636k() {
        this.f15088f = (GraphQLPromptType) super.m9954b(this.f15088f, 2, GraphQLPromptType.class, GraphQLPromptType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f15088f;
    }

    public final double m21637l() {
        m9949a(0, 3);
        return this.f15089g;
    }

    @Nullable
    public final String m21638m() {
        this.f15090h = super.m9948a(this.f15090h, 4);
        return this.f15090h;
    }

    @Nullable
    public final String mo2834a() {
        return m21630n();
    }

    public final int jK_() {
        return 955577736;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        m9958h();
        m9959i();
        return this;
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(m21630n());
        int a = flatBufferBuilder.m21477a(m21635j());
        int a2 = flatBufferBuilder.m21477a(m21636k());
        int b2 = flatBufferBuilder.m21502b(m21638m());
        flatBufferBuilder.m21510c(5);
        flatBufferBuilder.m21507b(0, b);
        flatBufferBuilder.m21507b(1, a);
        flatBufferBuilder.m21507b(2, a2);
        flatBufferBuilder.m21492a(3, this.f15089g, 0.0d);
        flatBufferBuilder.m21507b(4, b2);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f15089g = mutableFlatBuffer.m21523a(i, 3, 0.0d);
    }
}
