package com.facebook.linkify;

import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.linkify.LinkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL.ProfilePicture;
import com.facebook.proxygen.HTTPTransportCallback;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = 723206835)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: greeting_card_image_size_medium */
public final class LinkifyTargetGraphQLModels$LinkifyTargetGraphQLModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, LinkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL {
    @Nullable
    private GraphQLObjectType f21811d;
    @Nullable
    private String f21812e;
    @Nullable
    private String f21813f;
    @Nullable
    private ProfilePictureModel f21814g;
    @Nullable
    private String f21815h;

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 842551240)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: greeting_card_image_size_medium */
    public final class ProfilePictureModel extends BaseModel implements GraphQLVisitableModel, ProfilePicture {
        @Nullable
        private String f21805d;

        /* compiled from: greeting_card_image_size_medium */
        public final class Builder {
            @Nullable
            public String f21804a;

            public final ProfilePictureModel m29539a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(HTTPTransportCallback.BODY_BYTES_RECEIVED);
                int b = flatBufferBuilder.m21502b(this.f21804a);
                flatBufferBuilder.m21510c(1);
                flatBufferBuilder.m21507b(0, b);
                flatBufferBuilder.m21513d(flatBufferBuilder.m21511d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.m21515e());
                wrap.position(0);
                return new ProfilePictureModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        public ProfilePictureModel() {
            super(1);
        }

        public ProfilePictureModel(MutableFlatBuffer mutableFlatBuffer) {
            super(1);
            mo1412a(mutableFlatBuffer, FlatBuffer.m4026a(mutableFlatBuffer.f15021a));
        }

        @Nullable
        public final String mo3198b() {
            this.f21805d = super.m9948a(this.f21805d, 0);
            return this.f21805d;
        }

        public static ProfilePictureModel m29540a(ProfilePicture profilePicture) {
            if (profilePicture == null) {
                return null;
            }
            if (profilePicture instanceof ProfilePictureModel) {
                return (ProfilePictureModel) profilePicture;
            }
            Builder builder = new Builder();
            builder.f21804a = profilePicture.mo3198b();
            return builder.m29539a();
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
            int b = flatBufferBuilder.m21502b(mo3198b());
            flatBufferBuilder.m21510c(1);
            flatBufferBuilder.m21507b(0, b);
            m9959i();
            return flatBufferBuilder.m21511d();
        }
    }

    /* compiled from: greeting_card_image_size_medium */
    public final class Builder {
        @Nullable
        public GraphQLObjectType f21806a;
        @Nullable
        public String f21807b;
        @Nullable
        public String f21808c;
        @Nullable
        public ProfilePictureModel f21809d;
        @Nullable
        public String f21810e;

        public final LinkifyTargetGraphQLModels$LinkifyTargetGraphQLModel m29545a() {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(HTTPTransportCallback.BODY_BYTES_RECEIVED);
            int a = ModelHelper.m23093a(flatBufferBuilder, this.f21806a);
            int b = flatBufferBuilder.m21502b(this.f21807b);
            int b2 = flatBufferBuilder.m21502b(this.f21808c);
            int a2 = ModelHelper.m23093a(flatBufferBuilder, this.f21809d);
            int b3 = flatBufferBuilder.m21502b(this.f21810e);
            flatBufferBuilder.m21510c(5);
            flatBufferBuilder.m21507b(0, a);
            flatBufferBuilder.m21507b(1, b);
            flatBufferBuilder.m21507b(2, b2);
            flatBufferBuilder.m21507b(3, a2);
            flatBufferBuilder.m21507b(4, b3);
            flatBufferBuilder.m21513d(flatBufferBuilder.m21511d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.m21515e());
            wrap.position(0);
            return new LinkifyTargetGraphQLModels$LinkifyTargetGraphQLModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }
    }

    @Nullable
    public final /* synthetic */ ProfilePicture ad_() {
        return m29546j();
    }

    public LinkifyTargetGraphQLModels$LinkifyTargetGraphQLModel() {
        super(5);
    }

    public LinkifyTargetGraphQLModels$LinkifyTargetGraphQLModel(MutableFlatBuffer mutableFlatBuffer) {
        super(5);
        mo1412a(mutableFlatBuffer, FlatBuffer.m4026a(mutableFlatBuffer.f15021a));
    }

    @Nullable
    public final GraphQLObjectType mo3202b() {
        if (this.f5823b != null && this.f21811d == null) {
            this.f21811d = (GraphQLObjectType) this.f5823b.m21551d(this.f5824c, 0, GraphQLObjectType.class);
        }
        return this.f21811d;
    }

    @Nullable
    public final String mo3203d() {
        this.f21812e = super.m9948a(this.f21812e, 1);
        return this.f21812e;
    }

    @Nullable
    public final String C_() {
        this.f21813f = super.m9948a(this.f21813f, 2);
        return this.f21813f;
    }

    @Nullable
    private ProfilePictureModel m29546j() {
        this.f21814g = (ProfilePictureModel) super.m9947a(this.f21814g, 3, ProfilePictureModel.class);
        return this.f21814g;
    }

    @Nullable
    public final String D_() {
        this.f21815h = super.m9948a(this.f21815h, 4);
        return this.f21815h;
    }

    @Nullable
    public final String mo2834a() {
        return mo3203d();
    }

    public final int jK_() {
        return 2080559107;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m29546j() != null) {
            ProfilePictureModel profilePictureModel = (ProfilePictureModel) graphQLModelMutatingVisitor.mo2928b(m29546j());
            if (m29546j() != profilePictureModel) {
                graphQLVisitableModel = (LinkifyTargetGraphQLModels$LinkifyTargetGraphQLModel) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f21814g = profilePictureModel;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, mo3202b());
        int b = flatBufferBuilder.m21502b(mo3203d());
        int b2 = flatBufferBuilder.m21502b(C_());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m29546j());
        int b3 = flatBufferBuilder.m21502b(D_());
        flatBufferBuilder.m21510c(5);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, b);
        flatBufferBuilder.m21507b(2, b2);
        flatBufferBuilder.m21507b(3, a2);
        flatBufferBuilder.m21507b(4, b3);
        m9959i();
        return flatBufferBuilder.m21511d();
    }
}
