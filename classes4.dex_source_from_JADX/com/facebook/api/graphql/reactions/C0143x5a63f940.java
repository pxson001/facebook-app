package com.facebook.api.graphql.reactions;

import com.facebook.api.graphql.reactions.ReactionsGraphQLModels$ReactionsCountFieldsModel$TopReactionsModel.Builder;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels$ReactionsCountFieldsModel$TopReactionsModel.Deserializer;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels$ReactionsCountFieldsModel$TopReactionsModel.EdgesModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels$ReactionsCountFieldsModel$TopReactionsModel.Serializer;
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
import java.nio.ByteBuffer;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = 1525510373)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: rtt_window */
public final class C0143x5a63f940 extends BaseModel implements GraphQLVisitableModel {
    @Nullable
    private List<EdgesModel> f3009d;

    public C0143x5a63f940() {
        super(1);
    }

    public C0143x5a63f940(MutableFlatBuffer mutableFlatBuffer) {
        super(1);
        a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
    }

    @Nonnull
    public final ImmutableList<EdgesModel> m3307a() {
        this.f3009d = super.a(this.f3009d, 0, EdgesModel.class);
        return (ImmutableList) this.f3009d;
    }

    public static C0143x5a63f940 m3304a(C0143x5a63f940 c0143x5a63f940) {
        if (c0143x5a63f940 == null) {
            return null;
        }
        if (c0143x5a63f940 instanceof C0143x5a63f940) {
            return c0143x5a63f940;
        }
        Builder builder = new Builder();
        ImmutableList.Builder builder2 = ImmutableList.builder();
        for (int i = 0; i < c0143x5a63f940.m3307a().size(); i++) {
            builder2.c(EdgesModel.a((EdgesModel) c0143x5a63f940.m3307a().get(i)));
        }
        builder.a = builder2.b();
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = ModelHelper.a(flatBufferBuilder, builder.a);
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.d(flatBufferBuilder.d());
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        return new C0143x5a63f940(new MutableFlatBuffer(wrap, null, null, true, null));
    }

    public final int jK_() {
        return 1791249011;
    }

    public final GraphQLVisitableModel m3306a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m3307a() != null) {
            ImmutableList.Builder a = ModelHelper.a(m3307a(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (C0143x5a63f940) ModelHelper.a(null, this);
                graphQLVisitableModel.f3009d = a.b();
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final int m3305a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m3307a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }
}
