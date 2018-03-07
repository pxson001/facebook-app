package com.facebook.contacts.graphql;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import javax.annotation.Nullable;

@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = -439669600)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: requires_approval */
public final class ContactGraphQLModels$SquareImageModel extends BaseModel implements GraphQLVisitableModel {
    @Nullable
    private String f3666d;
    private int f3667e;

    public ContactGraphQLModels$SquareImageModel() {
        super(2);
    }

    @Nullable
    public final String m4097a() {
        this.f3666d = super.a(this.f3666d, 0);
        return this.f3666d;
    }

    public final int m4099b() {
        a(0, 1);
        return this.f3667e;
    }

    public final int jK_() {
        return 70760763;
    }

    public final GraphQLVisitableModel m4096a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public final int m4095a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m4097a());
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.a(1, this.f3667e, 0);
        i();
        return flatBufferBuilder.d();
    }

    public final void m4098a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f3667e = mutableFlatBuffer.a(i, 1, 0);
    }
}
