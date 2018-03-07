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
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = 1087166275)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: gradient */
public final class LinkifyUtilGraphQLModels$LinkableUtilAddLinksGraphQLModel extends BaseModel implements GraphQLVisitableModel, LinkifyUtilGraphQLInterfaces$LinkableUtilApplyActorsLinksGraphQL, C0881xeef6f5c8 {
    @Nullable
    private List<C0891x165ff5b> f22067d;
    @Nullable
    private List<C0882xfbc399e7> f22068e;
    @Nullable
    private String f22069f;

    public LinkifyUtilGraphQLModels$LinkableUtilAddLinksGraphQLModel() {
        super(3);
    }

    public LinkifyUtilGraphQLModels$LinkableUtilAddLinksGraphQLModel(MutableFlatBuffer mutableFlatBuffer) {
        super(3);
        mo1412a(mutableFlatBuffer, FlatBuffer.m4026a(mutableFlatBuffer.f15021a));
    }

    @Nonnull
    public final ImmutableList<C0891x165ff5b> mo3225c() {
        this.f22067d = super.m9944a(this.f22067d, 0, C0891x165ff5b.class);
        return (ImmutableList) this.f22067d;
    }

    @Nonnull
    public final ImmutableList<C0882xfbc399e7> mo3224b() {
        this.f22068e = super.m9944a(this.f22068e, 1, C0882xfbc399e7.class);
        return (ImmutableList) this.f22068e;
    }

    @Nullable
    public final String mo3223a() {
        this.f22069f = super.m9948a(this.f22069f, 2);
        return this.f22069f;
    }

    public final int jK_() {
        return -1919764332;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        Builder a;
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (mo3225c() != null) {
            a = ModelHelper.m23097a(mo3225c(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (LinkifyUtilGraphQLModels$LinkableUtilAddLinksGraphQLModel) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f22067d = a.m1068b();
            }
        }
        if (mo3224b() != null) {
            a = ModelHelper.m23097a(mo3224b(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (LinkifyUtilGraphQLModels$LinkableUtilAddLinksGraphQLModel) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f22068e = a.m1068b();
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23094a(flatBufferBuilder, mo3225c());
        int a2 = ModelHelper.m23094a(flatBufferBuilder, mo3224b());
        int b = flatBufferBuilder.m21502b(mo3223a());
        flatBufferBuilder.m21510c(3);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, a2);
        flatBufferBuilder.m21507b(2, b);
        m9959i();
        return flatBufferBuilder.m21511d();
    }
}
