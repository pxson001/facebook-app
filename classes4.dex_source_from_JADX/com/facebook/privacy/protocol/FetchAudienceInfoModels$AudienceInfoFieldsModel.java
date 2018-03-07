package com.facebook.privacy.protocol;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import javax.annotation.Nullable;

@FragmentModelWithBridge
@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = -220018755)
@JsonSerialize(using = Serializer.class)
/* compiled from: sms_in_readonly_mode */
public final class FetchAudienceInfoModels$AudienceInfoFieldsModel extends BaseModel implements GraphQLVisitableModel {
    private boolean f2154d;
    private boolean f2155e;
    private boolean f2156f;
    private boolean f2157g;
    @Nullable
    private C0164x41da8659 f2158h;

    public FetchAudienceInfoModels$AudienceInfoFieldsModel() {
        super(5);
    }

    public final boolean m2313a() {
        a(0, 0);
        return this.f2154d;
    }

    public final boolean m2314j() {
        a(0, 1);
        return this.f2155e;
    }

    public final boolean m2315k() {
        a(0, 2);
        return this.f2156f;
    }

    public final boolean m2316l() {
        a(0, 3);
        return this.f2157g;
    }

    @Nullable
    public final C0164x41da8659 m2317m() {
        this.f2158h = (C0164x41da8659) super.a(this.f2158h, 4, C0164x41da8659.class);
        return this.f2158h;
    }

    public final int jK_() {
        return -1563921166;
    }

    public final GraphQLVisitableModel m2311a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m2317m() != null) {
            C0164x41da8659 c0164x41da8659 = (C0164x41da8659) graphQLModelMutatingVisitor.b(m2317m());
            if (m2317m() != c0164x41da8659) {
                graphQLVisitableModel = (FetchAudienceInfoModels$AudienceInfoFieldsModel) ModelHelper.a(null, this);
                graphQLVisitableModel.f2158h = c0164x41da8659;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final int m2310a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m2317m());
        flatBufferBuilder.c(5);
        flatBufferBuilder.a(0, this.f2154d);
        flatBufferBuilder.a(1, this.f2155e);
        flatBufferBuilder.a(2, this.f2156f);
        flatBufferBuilder.a(3, this.f2157g);
        flatBufferBuilder.b(4, a);
        i();
        return flatBufferBuilder.d();
    }

    public final void m2312a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f2154d = mutableFlatBuffer.a(i, 0);
        this.f2155e = mutableFlatBuffer.a(i, 1);
        this.f2156f = mutableFlatBuffer.a(i, 2);
        this.f2157g = mutableFlatBuffer.a(i, 3);
    }
}
