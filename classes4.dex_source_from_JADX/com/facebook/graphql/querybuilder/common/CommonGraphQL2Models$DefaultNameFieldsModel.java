package com.facebook.graphql.querybuilder.common;

import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultNameFields;
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
@ModelWithFlatBufferFormatHash(a = 1522168816)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: snapshot_gks */
public final class CommonGraphQL2Models$DefaultNameFieldsModel extends BaseModel implements DefaultNameFields, GraphQLVisitableModel {
    @Nullable
    private String f1983d;
    @Nullable
    private List<CommonGraphQL2Models$DefaultNamePartFieldsModel> f1984e;
    @Nullable
    private String f1985f;

    public CommonGraphQL2Models$DefaultNameFieldsModel() {
        super(3);
    }

    public CommonGraphQL2Models$DefaultNameFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
        super(3);
        a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
    }

    @Nullable
    private String m2073j() {
        this.f1983d = super.a(this.f1983d, 0);
        return this.f1983d;
    }

    @Nonnull
    public final ImmutableList<CommonGraphQL2Models$DefaultNamePartFieldsModel> m2076a() {
        this.f1984e = super.a(this.f1984e, 1, CommonGraphQL2Models$DefaultNamePartFieldsModel.class);
        return (ImmutableList) this.f1984e;
    }

    @Nullable
    public final String s_() {
        this.f1985f = super.a(this.f1985f, 2);
        return this.f1985f;
    }

    public final int jK_() {
        return 2420395;
    }

    public final GraphQLVisitableModel m2075a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m2076a() != null) {
            Builder a = ModelHelper.a(m2076a(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (CommonGraphQL2Models$DefaultNameFieldsModel) ModelHelper.a(null, this);
                graphQLVisitableModel.f1984e = a.b();
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final int m2074a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m2073j());
        int a = ModelHelper.a(flatBufferBuilder, m2076a());
        int b2 = flatBufferBuilder.b(s_());
        flatBufferBuilder.c(3);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, a);
        flatBufferBuilder.b(2, b2);
        i();
        return flatBufferBuilder.d();
    }
}
