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
@ModelWithFlatBufferFormatHash(a = 448355107)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: requires_approval */
public final class ContactGraphQLModels$ContactsSyncFullModel$PageInfoModel extends BaseModel implements ContactGraphQLInterfaces$ContactsPageInfo, GraphQLVisitableModel {
    @Nullable
    private String f3596d;
    @Nullable
    private String f3597e;
    private boolean f3598f;

    public ContactGraphQLModels$ContactsSyncFullModel$PageInfoModel() {
        super(3);
    }

    @Nullable
    public final String m4015c() {
        this.f3596d = super.a(this.f3596d, 0);
        return this.f3596d;
    }

    @Nullable
    public final String mo291a() {
        this.f3597e = super.a(this.f3597e, 1);
        return this.f3597e;
    }

    public final boolean mo292b() {
        a(0, 2);
        return this.f3598f;
    }

    public final int jK_() {
        return 923779069;
    }

    public final GraphQLVisitableModel m4011a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public final int m4010a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m4015c());
        int b2 = flatBufferBuilder.b(mo291a());
        flatBufferBuilder.c(3);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, b2);
        flatBufferBuilder.a(2, this.f3598f);
        i();
        return flatBufferBuilder.d();
    }

    public final void m4013a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f3598f = mutableFlatBuffer.a(i, 2);
    }
}
