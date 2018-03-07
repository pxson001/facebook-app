package com.facebook.graphql.querybuilder.common;

import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLStructuredNamePart;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import javax.annotation.Nullable;

@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = 1501120714)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: snapshot_gks */
public final class CommonGraphQL2Models$DefaultNamePartFieldsModel extends BaseModel implements CommonGraphQL2Interfaces$DefaultNamePartFields, GraphQLVisitableModel {
    private int f1986d;
    private int f1987e;
    @Nullable
    private GraphQLStructuredNamePart f1988f;

    public CommonGraphQL2Models$DefaultNamePartFieldsModel() {
        super(3);
    }

    public CommonGraphQL2Models$DefaultNamePartFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
        super(3);
        a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
    }

    public final int mo139a() {
        a(0, 0);
        return this.f1986d;
    }

    public final int t_() {
        a(0, 1);
        return this.f1987e;
    }

    @Nullable
    public final GraphQLStructuredNamePart mo140c() {
        this.f1988f = (GraphQLStructuredNamePart) super.b(this.f1988f, 2, GraphQLStructuredNamePart.class, GraphQLStructuredNamePart.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f1988f;
    }

    public final int jK_() {
        return 1905097022;
    }

    public final GraphQLVisitableModel m2079a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public final int m2078a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = flatBufferBuilder.a(mo140c());
        flatBufferBuilder.c(3);
        flatBufferBuilder.a(0, this.f1986d, 0);
        flatBufferBuilder.a(1, this.f1987e, 0);
        flatBufferBuilder.b(2, a);
        i();
        return flatBufferBuilder.d();
    }

    public final void m2080a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f1986d = mutableFlatBuffer.a(i, 0, 0);
        this.f1987e = mutableFlatBuffer.a(i, 1, 0);
    }
}
