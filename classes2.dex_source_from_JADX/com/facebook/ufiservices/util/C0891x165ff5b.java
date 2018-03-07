package com.facebook.ufiservices.util;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLModels$LinkableUtilApplyAggregatedLinksGraphQLModel$AggregatedRangesModel.Deserializer;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLModels$LinkableUtilApplyAggregatedLinksGraphQLModel$AggregatedRangesModel.SampleEntitiesModel;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLModels$LinkableUtilApplyAggregatedLinksGraphQLModel$AggregatedRangesModel.Serializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = 958483744)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: gradient */
public final class C0891x165ff5b extends BaseModel implements GraphQLVisitableModel {
    private int f22094d;
    private int f22095e;
    @Nullable
    private List<SampleEntitiesModel> f22096f;

    public C0891x165ff5b() {
        super(3);
    }

    public final int m29964a() {
        m9949a(0, 0);
        return this.f22094d;
    }

    public final int m29968b() {
        m9949a(0, 1);
        return this.f22095e;
    }

    @Nonnull
    public final ImmutableList<SampleEntitiesModel> m29969c() {
        this.f22096f = super.m9944a(this.f22096f, 2, SampleEntitiesModel.class);
        return (ImmutableList) this.f22096f;
    }

    public final int jK_() {
        return 1563462756;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m29969c() != null) {
            Builder a = ModelHelper.m23097a(m29969c(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (C0891x165ff5b) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f22096f = a.m1068b();
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23094a(flatBufferBuilder, m29969c());
        flatBufferBuilder.m21510c(3);
        flatBufferBuilder.m21494a(0, this.f22094d, 0);
        flatBufferBuilder.m21494a(1, this.f22095e, 0);
        flatBufferBuilder.m21507b(2, a);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f22094d = mutableFlatBuffer.m21524a(i, 0, 0);
        this.f22095e = mutableFlatBuffer.m21524a(i, 1, 0);
    }
}
