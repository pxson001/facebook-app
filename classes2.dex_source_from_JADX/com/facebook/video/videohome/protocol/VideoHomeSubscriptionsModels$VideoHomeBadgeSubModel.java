package com.facebook.video.videohome.protocol;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLVideoHomeBadgeUpdateReason;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import javax.annotation.Nullable;

@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = -382813346)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: goodwill */
public final class VideoHomeSubscriptionsModels$VideoHomeBadgeSubModel extends BaseModel implements GraphQLVisitableModel {
    private int f22163d;
    @Nullable
    private GraphQLVideoHomeBadgeUpdateReason f22164e;
    private int f22165f;
    private int f22166g;

    public VideoHomeSubscriptionsModels$VideoHomeBadgeSubModel() {
        super(4);
    }

    public final int m30045a() {
        m9949a(0, 0);
        return this.f22163d;
    }

    @Nullable
    public final GraphQLVideoHomeBadgeUpdateReason m30049j() {
        this.f22164e = (GraphQLVideoHomeBadgeUpdateReason) super.m9954b(this.f22164e, 1, GraphQLVideoHomeBadgeUpdateReason.class, GraphQLVideoHomeBadgeUpdateReason.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f22164e;
    }

    public final int m30050k() {
        m9949a(0, 2);
        return this.f22165f;
    }

    public final int m30051l() {
        m9949a(0, 3);
        return this.f22166g;
    }

    public final int jK_() {
        return -1190812779;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        m9958h();
        m9959i();
        return this;
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = flatBufferBuilder.m21477a(m30049j());
        flatBufferBuilder.m21510c(4);
        flatBufferBuilder.m21494a(0, this.f22163d, 0);
        flatBufferBuilder.m21507b(1, a);
        flatBufferBuilder.m21494a(2, this.f22165f, 0);
        flatBufferBuilder.m21494a(3, this.f22166g, 0);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f22163d = mutableFlatBuffer.m21524a(i, 0, 0);
        this.f22165f = mutableFlatBuffer.m21524a(i, 2, 0);
        this.f22166g = mutableFlatBuffer.m21524a(i, 3, 0);
    }
}
