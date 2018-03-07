package com.facebook.ufiservices.util;

import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLInterfaces.LinkableUtilApplyAggregatedLinksGraphQL;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLModels$LinkableUtilApplyAggregatedLinksGraphQLModel.Deserializer;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLModels$LinkableUtilApplyAggregatedLinksGraphQLModel.Serializer;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLModels.LinkableUtilApplyAggregatedLinksGraphQLModel.AggregatedRangesModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = -708097642)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: o2i_ul_pl */
public final class C0285xc5d8b1b1 extends BaseModel implements GraphQLVisitableModel, LinkableUtilApplyAggregatedLinksGraphQL {
    @Nullable
    private List<AggregatedRangesModel> f6390d;
    @Nullable
    private String f6391e;

    public C0285xc5d8b1b1() {
        super(2);
    }

    public C0285xc5d8b1b1(MutableFlatBuffer mutableFlatBuffer) {
        super(2);
        a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
    }

    @Nonnull
    public final ImmutableList<AggregatedRangesModel> m6850c() {
        this.f6390d = super.a(this.f6390d, 0, AggregatedRangesModel.class);
        return (ImmutableList) this.f6390d;
    }

    @Nullable
    public final String m6849a() {
        this.f6391e = super.a(this.f6391e, 1);
        return this.f6391e;
    }

    public final int jK_() {
        return -1919764332;
    }

    public final GraphQLVisitableModel m6848a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m6850c() != null) {
            Builder a = ModelHelper.a(m6850c(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (C0285xc5d8b1b1) ModelHelper.a(null, this);
                graphQLVisitableModel.f6390d = a.b();
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final int m6847a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m6850c());
        int b = flatBufferBuilder.b(m6849a());
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, b);
        i();
        return flatBufferBuilder.d();
    }
}
