package com.facebook.graphql.querybuilder.common;

import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import javax.annotation.Nullable;

@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = 729935302)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: sms_takeover_send_message */
public final class CommonGraphQLModels$DefaultImageFieldsModel extends BaseModel implements DefaultImageFields, GraphQLVisitableModel {
    private int f1994d;
    @Nullable
    private String f1995e;
    private int f1996f;

    public CommonGraphQLModels$DefaultImageFieldsModel() {
        super(3);
    }

    public CommonGraphQLModels$DefaultImageFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
        super(3);
        a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
    }

    public final int m2090a() {
        a(0, 0);
        return this.f1994d;
    }

    @Nullable
    public final String m2094b() {
        this.f1995e = super.a(this.f1995e, 1);
        return this.f1995e;
    }

    public final int m2095c() {
        a(0, 2);
        return this.f1996f;
    }

    public static CommonGraphQLModels$DefaultImageFieldsModel m2089a(DefaultImageFields defaultImageFields) {
        if (defaultImageFields == null) {
            return null;
        }
        if (defaultImageFields instanceof CommonGraphQLModels$DefaultImageFieldsModel) {
            return (CommonGraphQLModels$DefaultImageFieldsModel) defaultImageFields;
        }
        Builder builder = new Builder();
        builder.a = defaultImageFields.a();
        builder.b = defaultImageFields.b();
        builder.c = defaultImageFields.c();
        return builder.a();
    }

    public final int jK_() {
        return 70760763;
    }

    public final GraphQLVisitableModel m2092a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public final int m2091a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m2094b());
        flatBufferBuilder.c(3);
        flatBufferBuilder.a(0, this.f1994d, 0);
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.a(2, this.f1996f, 0);
        i();
        return flatBufferBuilder.d();
    }

    public final void m2093a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f1994d = mutableFlatBuffer.a(i, 0, 0);
        this.f1996f = mutableFlatBuffer.a(i, 2, 0);
    }
}
