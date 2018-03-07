package com.facebook.graphql.linkutil;

import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLModels$GetRedirectionLinkGraphQLModel$RedirectionInfoModel.Builder;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLModels$GetRedirectionLinkGraphQLModel$RedirectionInfoModel.Deserializer;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLModels$GetRedirectionLinkGraphQLModel$RedirectionInfoModel.Serializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.proxygen.HTTPTransportCallback;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = 2144446797)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: goodwill_throwback_remove_link_status_timepill */
public final class C0890x64054611 extends BaseModel implements GraphQLVisitableModel {
    @Nullable
    private String f22093d;

    public C0890x64054611() {
        super(1);
    }

    public C0890x64054611(MutableFlatBuffer mutableFlatBuffer) {
        super(1);
        mo1412a(mutableFlatBuffer, FlatBuffer.m4026a(mutableFlatBuffer.f15021a));
    }

    @Nullable
    public final String m29963a() {
        this.f22093d = super.m9948a(this.f22093d, 0);
        return this.f22093d;
    }

    public static C0890x64054611 m29960a(C0890x64054611 c0890x64054611) {
        if (c0890x64054611 == null) {
            return null;
        }
        if (c0890x64054611 instanceof C0890x64054611) {
            return c0890x64054611;
        }
        Builder builder = new Builder();
        builder.a = c0890x64054611.m29963a();
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(HTTPTransportCallback.BODY_BYTES_RECEIVED);
        int b = flatBufferBuilder.m21502b(builder.a);
        flatBufferBuilder.m21510c(1);
        flatBufferBuilder.m21507b(0, b);
        flatBufferBuilder.m21513d(flatBufferBuilder.m21511d());
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.m21515e());
        wrap.position(0);
        return new C0890x64054611(new MutableFlatBuffer(wrap, null, null, true, null));
    }

    public final int jK_() {
        return -986866342;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        m9958h();
        m9959i();
        return this;
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(m29963a());
        flatBufferBuilder.m21510c(1);
        flatBufferBuilder.m21507b(0, b);
        m9959i();
        return flatBufferBuilder.m21511d();
    }
}
