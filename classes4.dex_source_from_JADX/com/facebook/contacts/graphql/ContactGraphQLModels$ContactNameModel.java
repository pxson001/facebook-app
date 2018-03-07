package com.facebook.contacts.graphql;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLStructuredNamePart;
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
@ModelWithFlatBufferFormatHash(a = -400262191)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: requires_approval */
public final class ContactGraphQLModels$ContactNameModel extends BaseModel implements GraphQLVisitableModel {
    @Nullable
    private List<PartsModel> f3619d;
    @Nullable
    private String f3620e;

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1501120714)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: requires_approval */
    public final class PartsModel extends BaseModel implements GraphQLVisitableModel {
        private int f3621d;
        private int f3622e;
        @Nullable
        private GraphQLStructuredNamePart f3623f;

        public PartsModel() {
            super(3);
        }

        public final int m4045a() {
            a(0, 0);
            return this.f3621d;
        }

        public final int m4049b() {
            a(0, 1);
            return this.f3622e;
        }

        @Nullable
        public final GraphQLStructuredNamePart m4050c() {
            this.f3623f = (GraphQLStructuredNamePart) super.b(this.f3623f, 2, GraphQLStructuredNamePart.class, GraphQLStructuredNamePart.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f3623f;
        }

        public final int jK_() {
            return 1905097022;
        }

        public final GraphQLVisitableModel m4047a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m4046a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = flatBufferBuilder.a(m4050c());
            flatBufferBuilder.c(3);
            flatBufferBuilder.a(0, this.f3621d, 0);
            flatBufferBuilder.a(1, this.f3622e, 0);
            flatBufferBuilder.b(2, a);
            i();
            return flatBufferBuilder.d();
        }

        public final void m4048a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f3621d = mutableFlatBuffer.a(i, 0, 0);
            this.f3622e = mutableFlatBuffer.a(i, 1, 0);
        }
    }

    public ContactGraphQLModels$ContactNameModel() {
        super(2);
    }

    @Nonnull
    public final ImmutableList<PartsModel> m4043a() {
        this.f3619d = super.a(this.f3619d, 0, PartsModel.class);
        return (ImmutableList) this.f3619d;
    }

    @Nullable
    public final String m4044b() {
        this.f3620e = super.a(this.f3620e, 1);
        return this.f3620e;
    }

    public final int jK_() {
        return 2420395;
    }

    public final GraphQLVisitableModel m4042a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m4043a() != null) {
            Builder a = ModelHelper.a(m4043a(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (ContactGraphQLModels$ContactNameModel) ModelHelper.a(null, this);
                graphQLVisitableModel.f3619d = a.b();
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final int m4041a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m4043a());
        int b = flatBufferBuilder.b(m4044b());
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, b);
        i();
        return flatBufferBuilder.d();
    }
}
