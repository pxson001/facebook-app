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
import com.facebook.ufiservices.util.LinkifyUtilGraphQLInterfaces.LinkableUtilApplyActorsLinksGraphQL;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLModels$LinkableUtilApplyActorsLinksGraphQLModel.Deserializer;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLModels$LinkableUtilApplyActorsLinksGraphQLModel.RangesModel;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLModels$LinkableUtilApplyActorsLinksGraphQLModel.Serializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = -1997014647)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: o2i_ul_pl */
public final class C0284x840d12b8 extends BaseModel implements GraphQLVisitableModel, LinkableUtilApplyActorsLinksGraphQL {
    @Nullable
    private List<RangesModel> f6388d;
    @Nullable
    private String f6389e;

    public C0284x840d12b8() {
        super(2);
    }

    public C0284x840d12b8(MutableFlatBuffer mutableFlatBuffer) {
        super(2);
        a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
    }

    @Nonnull
    public final ImmutableList<RangesModel> m6846b() {
        this.f6388d = super.a(this.f6388d, 0, RangesModel.class);
        return (ImmutableList) this.f6388d;
    }

    @Nullable
    public final String m6845a() {
        this.f6389e = super.a(this.f6389e, 1);
        return this.f6389e;
    }

    public final int jK_() {
        return -1919764332;
    }

    public final GraphQLVisitableModel m6844a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m6846b() != null) {
            Builder a = ModelHelper.a(m6846b(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (C0284x840d12b8) ModelHelper.a(null, this);
                graphQLVisitableModel.f6388d = a.b();
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final int m6843a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m6846b());
        int b = flatBufferBuilder.b(m6845a());
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, b);
        i();
        return flatBufferBuilder.d();
    }
}
