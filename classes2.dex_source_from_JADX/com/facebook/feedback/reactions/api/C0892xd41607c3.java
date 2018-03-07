package com.facebook.feedback.reactions.api;

import com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels$ReactionImageFragmentModel.Deserializer;
import com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels$ReactionImageFragmentModel.Serializer;
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
@ModelWithFlatBufferFormatHash(a = -1098422116)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: growth_set_native_name */
public final class C0892xd41607c3 extends BaseModel implements GraphQLVisitableModel {
    private int f22108d;
    @Nullable
    private String f22109e;
    private double f22110f;
    @Nullable
    private String f22111g;
    private int f22112h;

    public C0892xd41607c3() {
        super(5);
    }

    @Nullable
    public final String m29994a() {
        this.f22109e = super.m9948a(this.f22109e, 1);
        return this.f22109e;
    }

    @Nullable
    public final String m29996j() {
        this.f22111g = super.m9948a(this.f22111g, 3);
        return this.f22111g;
    }

    public final int jK_() {
        return 70760763;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        m9958h();
        m9959i();
        return this;
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(m29994a());
        int b2 = flatBufferBuilder.m21502b(m29996j());
        flatBufferBuilder.m21510c(5);
        flatBufferBuilder.m21494a(0, this.f22108d, 0);
        flatBufferBuilder.m21507b(1, b);
        flatBufferBuilder.m21492a(2, this.f22110f, 0.0d);
        flatBufferBuilder.m21507b(3, b2);
        flatBufferBuilder.m21494a(4, this.f22112h, 0);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f22108d = mutableFlatBuffer.m21524a(i, 0, 0);
        this.f22110f = mutableFlatBuffer.m21523a(i, 2, 0.0d);
        this.f22112h = mutableFlatBuffer.m21524a(i, 4, 0);
    }
}
