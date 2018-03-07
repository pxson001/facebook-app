package com.facebook.reaction.protocol.attachments;

import com.facebook.commerce.core.graphql.CoreCommerceQueryFragmentsModels.ProductItemPriceFieldsModel;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLAttributionSource;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLInterfaces.LinkableTextWithEntities;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLModels.LinkableTextWithEntitiesModel;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesFieldsModel;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLParsers.DefaultTextWithEntitiesFieldsParser;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.reaction.protocol.attachments.ReactionAttachmentsGraphQLInterfaces.ReactionAttributionFooterAttachmentFields;
import com.facebook.reaction.protocol.attachments.ReactionAttachmentsGraphQLInterfaces.ReactionCriticReviewAttachmentFields;
import com.facebook.reaction.protocol.attachments.ReactionAttachmentsGraphQLInterfaces.ReactionPageCommerceAttachmentFields;
import com.facebook.reaction.protocol.attachments.ReactionAttachmentsGraphQLInterfaces.ReactionPageInviteFriendToLikeAttachmentFields;
import com.facebook.reaction.protocol.attachments.ReactionAttachmentsGraphQLInterfaces.ReactionPagePromotionAttachmentFields;
import com.facebook.reaction.protocol.attachments.ReactionAttachmentsGraphQLInterfaces.ReactionStoryAdminPageAttachmentFragment;
import com.facebook.reaction.protocol.attachments.ReactionAttachmentsGraphQLParsers.ReactionAttributionFooterAttachmentFieldsParser;
import com.facebook.reaction.protocol.attachments.ReactionAttachmentsGraphQLParsers.ReactionAttributionFooterAttachmentFieldsParser.AttributionParser;
import com.facebook.reaction.protocol.attachments.ReactionAttachmentsGraphQLParsers.ReactionCriticReviewAttachmentFieldsParser;
import com.facebook.reaction.protocol.attachments.ReactionAttachmentsGraphQLParsers.ReactionCriticReviewAttachmentFieldsParser.ExternalImageParser;
import com.facebook.reaction.protocol.attachments.ReactionAttachmentsGraphQLParsers.ReactionCriticReviewAttachmentFieldsParser.ReviewerParser;
import com.facebook.reaction.protocol.attachments.ReactionAttachmentsGraphQLParsers.ReactionCriticReviewAttachmentFieldsParser.ReviewerParser.ProfilePictureParser;
import com.facebook.reaction.protocol.attachments.ReactionAttachmentsGraphQLParsers.ReactionPageCommerceAttachmentFieldsParser;
import com.facebook.reaction.protocol.attachments.ReactionAttachmentsGraphQLParsers.ReactionPageCommerceAttachmentFieldsParser.ProductParser;
import com.facebook.reaction.protocol.attachments.ReactionAttachmentsGraphQLParsers.ReactionPageCommerceAttachmentFieldsParser.ProductParser.ImageParser;
import com.facebook.reaction.protocol.attachments.ReactionAttachmentsGraphQLParsers.ReactionPageInviteFriendToLikeAttachmentFieldsParser;
import com.facebook.reaction.protocol.attachments.ReactionAttachmentsGraphQLParsers.ReactionPageInviteFriendToLikeAttachmentFieldsParser.InviteeParser;
import com.facebook.reaction.protocol.attachments.ReactionAttachmentsGraphQLParsers.ReactionPageInviteFriendToLikeAttachmentFieldsParser.PageParser;
import com.facebook.reaction.protocol.attachments.ReactionAttachmentsGraphQLParsers.ReactionPagePromotionAttachmentFieldsParser;
import com.facebook.reaction.protocol.attachments.ReactionAttachmentsGraphQLParsers.ReactionPagePromotionAttachmentFieldsParser.ItemParser;
import com.facebook.reaction.protocol.attachments.ReactionAttachmentsGraphQLParsers.ReactionStoryAdminPageAttachmentFragmentParser;
import com.facebook.reaction.protocol.attachments.ReactionAttachmentsGraphQLParsers.ReactionStoryAdminPageAttachmentFragmentParser.StoryAdminPageParser;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLInterfaces.ReactionImageFields;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLModels.ReactionImageFieldsModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: fingerprint_segment_offset */
public class ReactionAttachmentsGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 3365247)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: fingerprint_segment_offset */
    public final class ReactionAttributionFooterAttachmentFieldsModel extends BaseModel implements GraphQLVisitableModel, ReactionAttributionFooterAttachmentFields {
        @Nullable
        private AttributionModel f11979d;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 682898117)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: fingerprint_segment_offset */
        public final class AttributionModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private LinkableTextWithEntitiesModel f11976d;
            @Nullable
            private String f11977e;
            @Nullable
            private GraphQLAttributionSource f11978f;

            /* compiled from: fingerprint_segment_offset */
            public final class Builder {
                @Nullable
                public LinkableTextWithEntitiesModel f11973a;
                @Nullable
                public String f11974b;
                @Nullable
                public GraphQLAttributionSource f11975c;
            }

            /* compiled from: fingerprint_segment_offset */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AttributionModel.class, new Deserializer());
                }

                public Object m14247a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AttributionParser.m14376a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object attributionModel = new AttributionModel();
                    ((BaseModel) attributionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (attributionModel instanceof Postprocessable) {
                        return ((Postprocessable) attributionModel).a();
                    }
                    return attributionModel;
                }
            }

            /* compiled from: fingerprint_segment_offset */
            public class Serializer extends JsonSerializer<AttributionModel> {
                public final void m14248a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AttributionModel attributionModel = (AttributionModel) obj;
                    if (attributionModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(attributionModel.m14251a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        attributionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AttributionParser.m14377a(attributionModel.w_(), attributionModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(AttributionModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ LinkableTextWithEntities m14252a() {
                return m14250j();
            }

            public AttributionModel() {
                super(3);
            }

            public AttributionModel(MutableFlatBuffer mutableFlatBuffer) {
                super(3);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            private LinkableTextWithEntitiesModel m14250j() {
                this.f11976d = (LinkableTextWithEntitiesModel) super.a(this.f11976d, 0, LinkableTextWithEntitiesModel.class);
                return this.f11976d;
            }

            @Nullable
            public final String m14254b() {
                this.f11977e = super.a(this.f11977e, 1);
                return this.f11977e;
            }

            @Nullable
            public final GraphQLAttributionSource m14255c() {
                this.f11978f = (GraphQLAttributionSource) super.b(this.f11978f, 2, GraphQLAttributionSource.class, GraphQLAttributionSource.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f11978f;
            }

            public static AttributionModel m14249a(AttributionModel attributionModel) {
                if (attributionModel == null) {
                    return null;
                }
                if (attributionModel instanceof AttributionModel) {
                    return attributionModel;
                }
                Builder builder = new Builder();
                builder.f11973a = LinkableTextWithEntitiesModel.a(attributionModel.m14252a());
                builder.f11974b = attributionModel.m14254b();
                builder.f11975c = attributionModel.m14255c();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f11973a);
                int b = flatBufferBuilder.b(builder.f11974b);
                int a2 = flatBufferBuilder.a(builder.f11975c);
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, a2);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new AttributionModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return -751942829;
            }

            public final GraphQLVisitableModel m14253a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m14250j() != null) {
                    LinkableTextWithEntitiesModel linkableTextWithEntitiesModel = (LinkableTextWithEntitiesModel) graphQLModelMutatingVisitor.b(m14250j());
                    if (m14250j() != linkableTextWithEntitiesModel) {
                        graphQLVisitableModel = (AttributionModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f11976d = linkableTextWithEntitiesModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m14251a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m14250j());
                int b = flatBufferBuilder.b(m14254b());
                int a2 = flatBufferBuilder.a(m14255c());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: fingerprint_segment_offset */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionAttributionFooterAttachmentFieldsModel.class, new Deserializer());
            }

            public Object m14256a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ReactionAttributionFooterAttachmentFieldsParser.m14378a(jsonParser);
                Object reactionAttributionFooterAttachmentFieldsModel = new ReactionAttributionFooterAttachmentFieldsModel();
                ((BaseModel) reactionAttributionFooterAttachmentFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (reactionAttributionFooterAttachmentFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionAttributionFooterAttachmentFieldsModel).a();
                }
                return reactionAttributionFooterAttachmentFieldsModel;
            }
        }

        /* compiled from: fingerprint_segment_offset */
        public class Serializer extends JsonSerializer<ReactionAttributionFooterAttachmentFieldsModel> {
            public final void m14257a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ReactionAttributionFooterAttachmentFieldsModel reactionAttributionFooterAttachmentFieldsModel = (ReactionAttributionFooterAttachmentFieldsModel) obj;
                if (reactionAttributionFooterAttachmentFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionAttributionFooterAttachmentFieldsModel.m14259a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionAttributionFooterAttachmentFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = reactionAttributionFooterAttachmentFieldsModel.w_();
                int u_ = reactionAttributionFooterAttachmentFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("attribution");
                    AttributionParser.m14377a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ReactionAttributionFooterAttachmentFieldsModel.class, new Serializer());
            }
        }

        public ReactionAttributionFooterAttachmentFieldsModel() {
            super(1);
        }

        @Nullable
        private AttributionModel m14258a() {
            this.f11979d = (AttributionModel) super.a(this.f11979d, 0, AttributionModel.class);
            return this.f11979d;
        }

        public final int jK_() {
            return -1470056463;
        }

        public final GraphQLVisitableModel m14260a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m14258a() != null) {
                AttributionModel attributionModel = (AttributionModel) graphQLModelMutatingVisitor.b(m14258a());
                if (m14258a() != attributionModel) {
                    graphQLVisitableModel = (ReactionAttributionFooterAttachmentFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11979d = attributionModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m14259a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m14258a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -576694397)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: fingerprint_segment_offset */
    public final class ReactionCriticReviewAttachmentFieldsModel extends BaseModel implements GraphQLVisitableModel, ReactionCriticReviewAttachmentFields {
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f11990d;
        @Nullable
        private ExternalImageModel f11991e;
        @Nullable
        private String f11992f;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f11993g;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f11994h;
        @Nullable
        private ReviewerModel f11995i;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f11996j;

        /* compiled from: fingerprint_segment_offset */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionCriticReviewAttachmentFieldsModel.class, new Deserializer());
            }

            public Object m14261a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ReactionCriticReviewAttachmentFieldsParser.m14385a(jsonParser);
                Object reactionCriticReviewAttachmentFieldsModel = new ReactionCriticReviewAttachmentFieldsModel();
                ((BaseModel) reactionCriticReviewAttachmentFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (reactionCriticReviewAttachmentFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionCriticReviewAttachmentFieldsModel).a();
                }
                return reactionCriticReviewAttachmentFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: fingerprint_segment_offset */
        public final class ExternalImageModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f11981d;

            /* compiled from: fingerprint_segment_offset */
            public final class Builder {
                @Nullable
                public String f11980a;
            }

            /* compiled from: fingerprint_segment_offset */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ExternalImageModel.class, new Deserializer());
                }

                public Object m14262a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ExternalImageParser.m14379a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object externalImageModel = new ExternalImageModel();
                    ((BaseModel) externalImageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (externalImageModel instanceof Postprocessable) {
                        return ((Postprocessable) externalImageModel).a();
                    }
                    return externalImageModel;
                }
            }

            /* compiled from: fingerprint_segment_offset */
            public class Serializer extends JsonSerializer<ExternalImageModel> {
                public final void m14263a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ExternalImageModel externalImageModel = (ExternalImageModel) obj;
                    if (externalImageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(externalImageModel.m14265a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        externalImageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ExternalImageParser.m14380a(externalImageModel.w_(), externalImageModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ExternalImageModel.class, new Serializer());
                }
            }

            public ExternalImageModel() {
                super(1);
            }

            public ExternalImageModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m14267a() {
                this.f11981d = super.a(this.f11981d, 0);
                return this.f11981d;
            }

            public static ExternalImageModel m14264a(ExternalImageModel externalImageModel) {
                if (externalImageModel == null) {
                    return null;
                }
                if (externalImageModel instanceof ExternalImageModel) {
                    return externalImageModel;
                }
                Builder builder = new Builder();
                builder.f11980a = externalImageModel.m14267a();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f11980a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new ExternalImageModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m14266a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m14265a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m14267a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1749568526)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: fingerprint_segment_offset */
        public final class ReviewerModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f11987d;
            @Nullable
            private String f11988e;
            @Nullable
            private ProfilePictureModel f11989f;

            /* compiled from: fingerprint_segment_offset */
            public final class Builder {
                @Nullable
                public String f11982a;
                @Nullable
                public String f11983b;
                @Nullable
                public ProfilePictureModel f11984c;
            }

            /* compiled from: fingerprint_segment_offset */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ReviewerModel.class, new Deserializer());
                }

                public Object m14268a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ReviewerParser.m14383a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object reviewerModel = new ReviewerModel();
                    ((BaseModel) reviewerModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (reviewerModel instanceof Postprocessable) {
                        return ((Postprocessable) reviewerModel).a();
                    }
                    return reviewerModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 842551240)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: fingerprint_segment_offset */
            public final class ProfilePictureModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f11986d;

                /* compiled from: fingerprint_segment_offset */
                public final class Builder {
                    @Nullable
                    public String f11985a;
                }

                /* compiled from: fingerprint_segment_offset */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ProfilePictureModel.class, new Deserializer());
                    }

                    public Object m14269a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ProfilePictureParser.m14381a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object profilePictureModel = new ProfilePictureModel();
                        ((BaseModel) profilePictureModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (profilePictureModel instanceof Postprocessable) {
                            return ((Postprocessable) profilePictureModel).a();
                        }
                        return profilePictureModel;
                    }
                }

                /* compiled from: fingerprint_segment_offset */
                public class Serializer extends JsonSerializer<ProfilePictureModel> {
                    public final void m14270a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ProfilePictureModel profilePictureModel = (ProfilePictureModel) obj;
                        if (profilePictureModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(profilePictureModel.m14272a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            profilePictureModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ProfilePictureParser.m14382a(profilePictureModel.w_(), profilePictureModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(ProfilePictureModel.class, new Serializer());
                    }
                }

                public ProfilePictureModel() {
                    super(1);
                }

                public ProfilePictureModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(1);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                @Nullable
                public final String m14274a() {
                    this.f11986d = super.a(this.f11986d, 0);
                    return this.f11986d;
                }

                public static ProfilePictureModel m14271a(ProfilePictureModel profilePictureModel) {
                    if (profilePictureModel == null) {
                        return null;
                    }
                    if (profilePictureModel instanceof ProfilePictureModel) {
                        return profilePictureModel;
                    }
                    Builder builder = new Builder();
                    builder.f11985a = profilePictureModel.m14274a();
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int b = flatBufferBuilder.b(builder.f11985a);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new ProfilePictureModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }

                public final int jK_() {
                    return 70760763;
                }

                public final GraphQLVisitableModel m14273a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m14272a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m14274a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: fingerprint_segment_offset */
            public class Serializer extends JsonSerializer<ReviewerModel> {
                public final void m14275a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ReviewerModel reviewerModel = (ReviewerModel) obj;
                    if (reviewerModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(reviewerModel.m14278a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        reviewerModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ReviewerParser.m14384a(reviewerModel.w_(), reviewerModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ReviewerModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ ProfilePictureModel m14285d() {
                return m14277j();
            }

            public ReviewerModel() {
                super(3);
            }

            public ReviewerModel(MutableFlatBuffer mutableFlatBuffer) {
                super(3);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final void m14281a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m14282a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final String m14283b() {
                this.f11987d = super.a(this.f11987d, 0);
                return this.f11987d;
            }

            @Nullable
            public final String m14284c() {
                this.f11988e = super.a(this.f11988e, 1);
                return this.f11988e;
            }

            @Nullable
            private ProfilePictureModel m14277j() {
                this.f11989f = (ProfilePictureModel) super.a(this.f11989f, 2, ProfilePictureModel.class);
                return this.f11989f;
            }

            public static ReviewerModel m14276a(ReviewerModel reviewerModel) {
                if (reviewerModel == null) {
                    return null;
                }
                if (reviewerModel instanceof ReviewerModel) {
                    return reviewerModel;
                }
                Builder builder = new Builder();
                builder.f11982a = reviewerModel.m14283b();
                builder.f11983b = reviewerModel.m14284c();
                builder.f11984c = ProfilePictureModel.m14271a(reviewerModel.m14285d());
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f11982a);
                int b2 = flatBufferBuilder.b(builder.f11983b);
                int a = ModelHelper.a(flatBufferBuilder, builder.f11984c);
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.b(2, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new ReviewerModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            @Nullable
            public final String m14280a() {
                return m14283b();
            }

            public final int jK_() {
                return 2479791;
            }

            public final GraphQLVisitableModel m14279a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m14277j() != null) {
                    ProfilePictureModel profilePictureModel = (ProfilePictureModel) graphQLModelMutatingVisitor.b(m14277j());
                    if (m14277j() != profilePictureModel) {
                        graphQLVisitableModel = (ReviewerModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f11989f = profilePictureModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m14278a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m14283b());
                int b2 = flatBufferBuilder.b(m14284c());
                int a = ModelHelper.a(flatBufferBuilder, m14277j());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.b(2, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: fingerprint_segment_offset */
        public class Serializer extends JsonSerializer<ReactionCriticReviewAttachmentFieldsModel> {
            public final void m14286a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ReactionCriticReviewAttachmentFieldsModel reactionCriticReviewAttachmentFieldsModel = (ReactionCriticReviewAttachmentFieldsModel) obj;
                if (reactionCriticReviewAttachmentFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionCriticReviewAttachmentFieldsModel.m14294a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionCriticReviewAttachmentFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = reactionCriticReviewAttachmentFieldsModel.w_();
                int u_ = reactionCriticReviewAttachmentFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("byline");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("external_image");
                    ExternalImageParser.m14380a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("external_url");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 2));
                }
                g = mutableFlatBuffer.g(u_, 3);
                if (g != 0) {
                    jsonGenerator.a("published_on");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 4);
                if (g != 0) {
                    jsonGenerator.a("review_title");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 5);
                if (g != 0) {
                    jsonGenerator.a("reviewer");
                    ReviewerParser.m14384a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 6);
                if (g != 0) {
                    jsonGenerator.a("summary");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ReactionCriticReviewAttachmentFieldsModel.class, new Serializer());
            }
        }

        public ReactionCriticReviewAttachmentFieldsModel() {
            super(7);
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel m14287a() {
            this.f11990d = (DefaultTextWithEntitiesFieldsModel) super.a(this.f11990d, 0, DefaultTextWithEntitiesFieldsModel.class);
            return this.f11990d;
        }

        @Nullable
        private ExternalImageModel m14288j() {
            this.f11991e = (ExternalImageModel) super.a(this.f11991e, 1, ExternalImageModel.class);
            return this.f11991e;
        }

        @Nullable
        private String m14289k() {
            this.f11992f = super.a(this.f11992f, 2);
            return this.f11992f;
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel m14290l() {
            this.f11993g = (DefaultTextWithEntitiesFieldsModel) super.a(this.f11993g, 3, DefaultTextWithEntitiesFieldsModel.class);
            return this.f11993g;
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel m14291m() {
            this.f11994h = (DefaultTextWithEntitiesFieldsModel) super.a(this.f11994h, 4, DefaultTextWithEntitiesFieldsModel.class);
            return this.f11994h;
        }

        @Nullable
        private ReviewerModel m14292n() {
            this.f11995i = (ReviewerModel) super.a(this.f11995i, 5, ReviewerModel.class);
            return this.f11995i;
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel m14293o() {
            this.f11996j = (DefaultTextWithEntitiesFieldsModel) super.a(this.f11996j, 6, DefaultTextWithEntitiesFieldsModel.class);
            return this.f11996j;
        }

        public final int jK_() {
            return 1438801660;
        }

        public final GraphQLVisitableModel m14295a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            DefaultTextWithEntitiesFieldsModel defaultTextWithEntitiesFieldsModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m14287a() != null) {
                defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m14287a());
                if (m14287a() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (ReactionCriticReviewAttachmentFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11990d = defaultTextWithEntitiesFieldsModel;
                }
            }
            if (m14288j() != null) {
                ExternalImageModel externalImageModel = (ExternalImageModel) graphQLModelMutatingVisitor.b(m14288j());
                if (m14288j() != externalImageModel) {
                    graphQLVisitableModel = (ReactionCriticReviewAttachmentFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11991e = externalImageModel;
                }
            }
            if (m14290l() != null) {
                defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m14290l());
                if (m14290l() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (ReactionCriticReviewAttachmentFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11993g = defaultTextWithEntitiesFieldsModel;
                }
            }
            if (m14291m() != null) {
                defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m14291m());
                if (m14291m() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (ReactionCriticReviewAttachmentFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11994h = defaultTextWithEntitiesFieldsModel;
                }
            }
            if (m14292n() != null) {
                ReviewerModel reviewerModel = (ReviewerModel) graphQLModelMutatingVisitor.b(m14292n());
                if (m14292n() != reviewerModel) {
                    graphQLVisitableModel = (ReactionCriticReviewAttachmentFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11995i = reviewerModel;
                }
            }
            if (m14293o() != null) {
                defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m14293o());
                if (m14293o() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (ReactionCriticReviewAttachmentFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11996j = defaultTextWithEntitiesFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m14294a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m14287a());
            int a2 = ModelHelper.a(flatBufferBuilder, m14288j());
            int b = flatBufferBuilder.b(m14289k());
            int a3 = ModelHelper.a(flatBufferBuilder, m14290l());
            int a4 = ModelHelper.a(flatBufferBuilder, m14291m());
            int a5 = ModelHelper.a(flatBufferBuilder, m14292n());
            int a6 = ModelHelper.a(flatBufferBuilder, m14293o());
            flatBufferBuilder.c(7);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.b(4, a4);
            flatBufferBuilder.b(5, a5);
            flatBufferBuilder.b(6, a6);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 661100876)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: fingerprint_segment_offset */
    public final class ReactionPageCommerceAttachmentFieldsModel extends BaseModel implements GraphQLVisitableModel, ReactionPageCommerceAttachmentFields {
        @Nullable
        private ProductModel f12007d;

        /* compiled from: fingerprint_segment_offset */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionPageCommerceAttachmentFieldsModel.class, new Deserializer());
            }

            public Object m14296a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ReactionPageCommerceAttachmentFieldsParser.m14390a(jsonParser);
                Object reactionPageCommerceAttachmentFieldsModel = new ReactionPageCommerceAttachmentFieldsModel();
                ((BaseModel) reactionPageCommerceAttachmentFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (reactionPageCommerceAttachmentFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionPageCommerceAttachmentFieldsModel).a();
                }
                return reactionPageCommerceAttachmentFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1528502402)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: fingerprint_segment_offset */
        public final class ProductModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f12003d;
            @Nullable
            private ImageModel f12004e;
            @Nullable
            private String f12005f;
            @Nullable
            private ProductItemPriceFieldsModel f12006g;

            /* compiled from: fingerprint_segment_offset */
            public final class Builder {
                @Nullable
                public String f11997a;
                @Nullable
                public ImageModel f11998b;
                @Nullable
                public String f11999c;
                @Nullable
                public ProductItemPriceFieldsModel f12000d;
            }

            /* compiled from: fingerprint_segment_offset */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ProductModel.class, new Deserializer());
                }

                public Object m14297a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ProductParser.m14388a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object productModel = new ProductModel();
                    ((BaseModel) productModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (productModel instanceof Postprocessable) {
                        return ((Postprocessable) productModel).a();
                    }
                    return productModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 842551240)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: fingerprint_segment_offset */
            public final class ImageModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f12002d;

                /* compiled from: fingerprint_segment_offset */
                public final class Builder {
                    @Nullable
                    public String f12001a;
                }

                /* compiled from: fingerprint_segment_offset */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ImageModel.class, new Deserializer());
                    }

                    public Object m14298a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ImageParser.m14386a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object imageModel = new ImageModel();
                        ((BaseModel) imageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (imageModel instanceof Postprocessable) {
                            return ((Postprocessable) imageModel).a();
                        }
                        return imageModel;
                    }
                }

                /* compiled from: fingerprint_segment_offset */
                public class Serializer extends JsonSerializer<ImageModel> {
                    public final void m14299a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ImageModel imageModel = (ImageModel) obj;
                        if (imageModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(imageModel.m14301a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            imageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ImageParser.m14387a(imageModel.w_(), imageModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(ImageModel.class, new Serializer());
                    }
                }

                public ImageModel() {
                    super(1);
                }

                public ImageModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(1);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                @Nullable
                public final String m14303a() {
                    this.f12002d = super.a(this.f12002d, 0);
                    return this.f12002d;
                }

                public static ImageModel m14300a(ImageModel imageModel) {
                    if (imageModel == null) {
                        return null;
                    }
                    if (imageModel instanceof ImageModel) {
                        return imageModel;
                    }
                    Builder builder = new Builder();
                    builder.f12001a = imageModel.m14303a();
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int b = flatBufferBuilder.b(builder.f12001a);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new ImageModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }

                public final int jK_() {
                    return 70760763;
                }

                public final GraphQLVisitableModel m14302a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m14301a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m14303a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: fingerprint_segment_offset */
            public class Serializer extends JsonSerializer<ProductModel> {
                public final void m14304a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ProductModel productModel = (ProductModel) obj;
                    if (productModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(productModel.m14308a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        productModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ProductParser.m14389a(productModel.w_(), productModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ProductModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ ImageModel m14312c() {
                return m14306j();
            }

            @Nullable
            public final /* synthetic */ ProductItemPriceFieldsModel eO_() {
                return m14307k();
            }

            public ProductModel() {
                super(4);
            }

            public ProductModel(MutableFlatBuffer mutableFlatBuffer) {
                super(4);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m14311b() {
                this.f12003d = super.a(this.f12003d, 0);
                return this.f12003d;
            }

            @Nullable
            private ImageModel m14306j() {
                this.f12004e = (ImageModel) super.a(this.f12004e, 1, ImageModel.class);
                return this.f12004e;
            }

            @Nullable
            public final String m14313d() {
                this.f12005f = super.a(this.f12005f, 2);
                return this.f12005f;
            }

            @Nullable
            private ProductItemPriceFieldsModel m14307k() {
                this.f12006g = (ProductItemPriceFieldsModel) super.a(this.f12006g, 3, ProductItemPriceFieldsModel.class);
                return this.f12006g;
            }

            public static ProductModel m14305a(ProductModel productModel) {
                if (productModel == null) {
                    return null;
                }
                if (productModel instanceof ProductModel) {
                    return productModel;
                }
                Builder builder = new Builder();
                builder.f11997a = productModel.m14311b();
                builder.f11998b = ImageModel.m14300a(productModel.m14312c());
                builder.f11999c = productModel.m14313d();
                builder.f12000d = ProductItemPriceFieldsModel.a(productModel.eO_());
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f11997a);
                int a = ModelHelper.a(flatBufferBuilder, builder.f11998b);
                int b2 = flatBufferBuilder.b(builder.f11999c);
                int a2 = ModelHelper.a(flatBufferBuilder, builder.f12000d);
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.b(2, b2);
                flatBufferBuilder.b(3, a2);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new ProductModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            @Nullable
            public final String m14310a() {
                return m14311b();
            }

            public final int jK_() {
                return 175920258;
            }

            public final GraphQLVisitableModel m14309a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m14306j() != null) {
                    ImageModel imageModel = (ImageModel) graphQLModelMutatingVisitor.b(m14306j());
                    if (m14306j() != imageModel) {
                        graphQLVisitableModel = (ProductModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f12004e = imageModel;
                    }
                }
                if (m14307k() != null) {
                    ProductItemPriceFieldsModel productItemPriceFieldsModel = (ProductItemPriceFieldsModel) graphQLModelMutatingVisitor.b(m14307k());
                    if (m14307k() != productItemPriceFieldsModel) {
                        graphQLVisitableModel = (ProductModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f12006g = productItemPriceFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m14308a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m14311b());
                int a = ModelHelper.a(flatBufferBuilder, m14306j());
                int b2 = flatBufferBuilder.b(m14313d());
                int a2 = ModelHelper.a(flatBufferBuilder, m14307k());
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.b(2, b2);
                flatBufferBuilder.b(3, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: fingerprint_segment_offset */
        public class Serializer extends JsonSerializer<ReactionPageCommerceAttachmentFieldsModel> {
            public final void m14314a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ReactionPageCommerceAttachmentFieldsModel reactionPageCommerceAttachmentFieldsModel = (ReactionPageCommerceAttachmentFieldsModel) obj;
                if (reactionPageCommerceAttachmentFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionPageCommerceAttachmentFieldsModel.m14316a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionPageCommerceAttachmentFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = reactionPageCommerceAttachmentFieldsModel.w_();
                int u_ = reactionPageCommerceAttachmentFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("product");
                    ProductParser.m14389a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ReactionPageCommerceAttachmentFieldsModel.class, new Serializer());
            }
        }

        public ReactionPageCommerceAttachmentFieldsModel() {
            super(1);
        }

        @Nullable
        private ProductModel m14315a() {
            this.f12007d = (ProductModel) super.a(this.f12007d, 0, ProductModel.class);
            return this.f12007d;
        }

        public final int jK_() {
            return 313893893;
        }

        public final GraphQLVisitableModel m14317a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m14315a() != null) {
                ProductModel productModel = (ProductModel) graphQLModelMutatingVisitor.b(m14315a());
                if (m14315a() != productModel) {
                    graphQLVisitableModel = (ReactionPageCommerceAttachmentFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12007d = productModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m14316a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m14315a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 965939343)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: fingerprint_segment_offset */
    public final class ReactionPageInviteFriendToLikeAttachmentFieldsModel extends BaseModel implements GraphQLVisitableModel, ReactionPageInviteFriendToLikeAttachmentFields {
        @Nullable
        private InviteeModel f12015d;
        @Nullable
        private PageModel f12016e;

        /* compiled from: fingerprint_segment_offset */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionPageInviteFriendToLikeAttachmentFieldsModel.class, new Deserializer());
            }

            public Object m14318a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ReactionPageInviteFriendToLikeAttachmentFieldsParser.m14395a(jsonParser);
                Object reactionPageInviteFriendToLikeAttachmentFieldsModel = new ReactionPageInviteFriendToLikeAttachmentFieldsModel();
                ((BaseModel) reactionPageInviteFriendToLikeAttachmentFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (reactionPageInviteFriendToLikeAttachmentFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionPageInviteFriendToLikeAttachmentFieldsModel).a();
                }
                return reactionPageInviteFriendToLikeAttachmentFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 604215985)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: fingerprint_segment_offset */
        public final class InviteeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f12011d;
            @Nullable
            private String f12012e;
            @Nullable
            private ReactionImageFieldsModel f12013f;

            /* compiled from: fingerprint_segment_offset */
            public final class Builder {
                @Nullable
                public String f12008a;
                @Nullable
                public String f12009b;
                @Nullable
                public ReactionImageFieldsModel f12010c;
            }

            /* compiled from: fingerprint_segment_offset */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(InviteeModel.class, new Deserializer());
                }

                public Object m14319a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(InviteeParser.m14391a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object inviteeModel = new InviteeModel();
                    ((BaseModel) inviteeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (inviteeModel instanceof Postprocessable) {
                        return ((Postprocessable) inviteeModel).a();
                    }
                    return inviteeModel;
                }
            }

            /* compiled from: fingerprint_segment_offset */
            public class Serializer extends JsonSerializer<InviteeModel> {
                public final void m14320a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    InviteeModel inviteeModel = (InviteeModel) obj;
                    if (inviteeModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(inviteeModel.m14323a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        inviteeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    InviteeParser.m14392a(inviteeModel.w_(), inviteeModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(InviteeModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ ReactionImageFields m14330d() {
                return m14322j();
            }

            public InviteeModel() {
                super(3);
            }

            public InviteeModel(MutableFlatBuffer mutableFlatBuffer) {
                super(3);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final void m14326a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m14327a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final String m14328b() {
                this.f12011d = super.a(this.f12011d, 0);
                return this.f12011d;
            }

            @Nullable
            public final String m14329c() {
                this.f12012e = super.a(this.f12012e, 1);
                return this.f12012e;
            }

            @Nullable
            private ReactionImageFieldsModel m14322j() {
                this.f12013f = (ReactionImageFieldsModel) super.a(this.f12013f, 2, ReactionImageFieldsModel.class);
                return this.f12013f;
            }

            public static InviteeModel m14321a(InviteeModel inviteeModel) {
                if (inviteeModel == null) {
                    return null;
                }
                if (inviteeModel instanceof InviteeModel) {
                    return inviteeModel;
                }
                Builder builder = new Builder();
                builder.f12008a = inviteeModel.m14328b();
                builder.f12009b = inviteeModel.m14329c();
                builder.f12010c = ReactionImageFieldsModel.m14497a(inviteeModel.m14330d());
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f12008a);
                int b2 = flatBufferBuilder.b(builder.f12009b);
                int a = ModelHelper.a(flatBufferBuilder, builder.f12010c);
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.b(2, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new InviteeModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            @Nullable
            public final String m14325a() {
                return m14328b();
            }

            public final int jK_() {
                return 2645995;
            }

            public final GraphQLVisitableModel m14324a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m14322j() != null) {
                    ReactionImageFieldsModel reactionImageFieldsModel = (ReactionImageFieldsModel) graphQLModelMutatingVisitor.b(m14322j());
                    if (m14322j() != reactionImageFieldsModel) {
                        graphQLVisitableModel = (InviteeModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f12013f = reactionImageFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m14323a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m14328b());
                int b2 = flatBufferBuilder.b(m14329c());
                int a = ModelHelper.a(flatBufferBuilder, m14322j());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.b(2, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: fingerprint_segment_offset */
        public final class PageModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f12014d;

            /* compiled from: fingerprint_segment_offset */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PageModel.class, new Deserializer());
                }

                public Object m14331a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PageParser.m14393a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object pageModel = new PageModel();
                    ((BaseModel) pageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (pageModel instanceof Postprocessable) {
                        return ((Postprocessable) pageModel).a();
                    }
                    return pageModel;
                }
            }

            /* compiled from: fingerprint_segment_offset */
            public class Serializer extends JsonSerializer<PageModel> {
                public final void m14332a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PageModel pageModel = (PageModel) obj;
                    if (pageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pageModel.m14334a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PageParser.m14394a(pageModel.w_(), pageModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PageModel.class, new Serializer());
                }
            }

            public PageModel() {
                super(1);
            }

            public final void m14337a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m14338a(String str, Object obj, boolean z) {
            }

            @Nullable
            private String m14333j() {
                this.f12014d = super.a(this.f12014d, 0);
                return this.f12014d;
            }

            @Nullable
            public final String m14336a() {
                return m14333j();
            }

            public final int jK_() {
                return 2479791;
            }

            public final GraphQLVisitableModel m14335a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m14334a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m14333j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: fingerprint_segment_offset */
        public class Serializer extends JsonSerializer<ReactionPageInviteFriendToLikeAttachmentFieldsModel> {
            public final void m14339a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ReactionPageInviteFriendToLikeAttachmentFieldsModel reactionPageInviteFriendToLikeAttachmentFieldsModel = (ReactionPageInviteFriendToLikeAttachmentFieldsModel) obj;
                if (reactionPageInviteFriendToLikeAttachmentFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionPageInviteFriendToLikeAttachmentFieldsModel.m14342a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionPageInviteFriendToLikeAttachmentFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = reactionPageInviteFriendToLikeAttachmentFieldsModel.w_();
                int u_ = reactionPageInviteFriendToLikeAttachmentFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("invitee");
                    InviteeParser.m14392a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("page");
                    PageParser.m14394a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ReactionPageInviteFriendToLikeAttachmentFieldsModel.class, new Serializer());
            }
        }

        public ReactionPageInviteFriendToLikeAttachmentFieldsModel() {
            super(2);
        }

        @Nullable
        private InviteeModel m14340a() {
            this.f12015d = (InviteeModel) super.a(this.f12015d, 0, InviteeModel.class);
            return this.f12015d;
        }

        @Nullable
        private PageModel m14341j() {
            this.f12016e = (PageModel) super.a(this.f12016e, 1, PageModel.class);
            return this.f12016e;
        }

        public final int jK_() {
            return 1448428852;
        }

        public final GraphQLVisitableModel m14343a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m14340a() != null) {
                InviteeModel inviteeModel = (InviteeModel) graphQLModelMutatingVisitor.b(m14340a());
                if (m14340a() != inviteeModel) {
                    graphQLVisitableModel = (ReactionPageInviteFriendToLikeAttachmentFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12015d = inviteeModel;
                }
            }
            if (m14341j() != null) {
                PageModel pageModel = (PageModel) graphQLModelMutatingVisitor.b(m14341j());
                if (m14341j() != pageModel) {
                    graphQLVisitableModel = (ReactionPageInviteFriendToLikeAttachmentFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12016e = pageModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m14342a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m14340a());
            int a2 = ModelHelper.a(flatBufferBuilder, m14341j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -950381663)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: fingerprint_segment_offset */
    public final class ReactionPagePromotionAttachmentFieldsModel extends BaseModel implements GraphQLVisitableModel, ReactionPagePromotionAttachmentFields {
        @Nullable
        private ItemModel f12025d;

        /* compiled from: fingerprint_segment_offset */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionPagePromotionAttachmentFieldsModel.class, new Deserializer());
            }

            public Object m14344a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ReactionPagePromotionAttachmentFieldsParser.m14398a(jsonParser);
                Object reactionPagePromotionAttachmentFieldsModel = new ReactionPagePromotionAttachmentFieldsModel();
                ((BaseModel) reactionPagePromotionAttachmentFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (reactionPagePromotionAttachmentFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionPagePromotionAttachmentFieldsModel).a();
                }
                return reactionPagePromotionAttachmentFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1542728452)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: fingerprint_segment_offset */
        public final class ItemModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f12021d;
            @Nullable
            private String f12022e;
            @Nullable
            private String f12023f;
            @Nullable
            private String f12024g;

            /* compiled from: fingerprint_segment_offset */
            public final class Builder {
                @Nullable
                public String f12017a;
                @Nullable
                public String f12018b;
                @Nullable
                public String f12019c;
                @Nullable
                public String f12020d;
            }

            /* compiled from: fingerprint_segment_offset */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ItemModel.class, new Deserializer());
                }

                public Object m14345a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ItemParser.m14396a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object itemModel = new ItemModel();
                    ((BaseModel) itemModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (itemModel instanceof Postprocessable) {
                        return ((Postprocessable) itemModel).a();
                    }
                    return itemModel;
                }
            }

            /* compiled from: fingerprint_segment_offset */
            public class Serializer extends JsonSerializer<ItemModel> {
                public final void m14346a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ItemModel itemModel = (ItemModel) obj;
                    if (itemModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(itemModel.m14348a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        itemModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ItemParser.m14397a(itemModel.w_(), itemModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ItemModel.class, new Serializer());
                }
            }

            public ItemModel() {
                super(4);
            }

            public ItemModel(MutableFlatBuffer mutableFlatBuffer) {
                super(4);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m14350a() {
                this.f12021d = super.a(this.f12021d, 0);
                return this.f12021d;
            }

            @Nullable
            public final String m14351b() {
                this.f12022e = super.a(this.f12022e, 1);
                return this.f12022e;
            }

            @Nullable
            public final String m14352c() {
                this.f12023f = super.a(this.f12023f, 2);
                return this.f12023f;
            }

            @Nullable
            public final String m14353d() {
                this.f12024g = super.a(this.f12024g, 3);
                return this.f12024g;
            }

            public static ItemModel m14347a(ItemModel itemModel) {
                if (itemModel == null) {
                    return null;
                }
                if (itemModel instanceof ItemModel) {
                    return itemModel;
                }
                Builder builder = new Builder();
                builder.f12017a = itemModel.m14350a();
                builder.f12018b = itemModel.m14351b();
                builder.f12019c = itemModel.m14352c();
                builder.f12020d = itemModel.m14353d();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f12017a);
                int b2 = flatBufferBuilder.b(builder.f12018b);
                int b3 = flatBufferBuilder.b(builder.f12019c);
                int b4 = flatBufferBuilder.b(builder.f12020d);
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.b(2, b3);
                flatBufferBuilder.b(3, b4);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new ItemModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 427023413;
            }

            public final GraphQLVisitableModel m14349a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m14348a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m14350a());
                int b2 = flatBufferBuilder.b(m14351b());
                int b3 = flatBufferBuilder.b(m14352c());
                int b4 = flatBufferBuilder.b(m14353d());
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.b(2, b3);
                flatBufferBuilder.b(3, b4);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: fingerprint_segment_offset */
        public class Serializer extends JsonSerializer<ReactionPagePromotionAttachmentFieldsModel> {
            public final void m14354a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ReactionPagePromotionAttachmentFieldsModel reactionPagePromotionAttachmentFieldsModel = (ReactionPagePromotionAttachmentFieldsModel) obj;
                if (reactionPagePromotionAttachmentFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionPagePromotionAttachmentFieldsModel.m14356a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionPagePromotionAttachmentFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = reactionPagePromotionAttachmentFieldsModel.w_();
                int u_ = reactionPagePromotionAttachmentFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("item");
                    ItemParser.m14397a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ReactionPagePromotionAttachmentFieldsModel.class, new Serializer());
            }
        }

        public ReactionPagePromotionAttachmentFieldsModel() {
            super(1);
        }

        @Nullable
        private ItemModel m14355a() {
            this.f12025d = (ItemModel) super.a(this.f12025d, 0, ItemModel.class);
            return this.f12025d;
        }

        public final int jK_() {
            return -1410566934;
        }

        public final GraphQLVisitableModel m14357a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m14355a() != null) {
                ItemModel itemModel = (ItemModel) graphQLModelMutatingVisitor.b(m14355a());
                if (m14355a() != itemModel) {
                    graphQLVisitableModel = (ReactionPagePromotionAttachmentFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12025d = itemModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m14356a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m14355a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 820252181)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: fingerprint_segment_offset */
    public final class ReactionStoryAdminPageAttachmentFragmentModel extends BaseModel implements GraphQLVisitableModel, ReactionStoryAdminPageAttachmentFragment {
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f12032d;
        @Nullable
        private StoryAdminPageModel f12033e;

        /* compiled from: fingerprint_segment_offset */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionStoryAdminPageAttachmentFragmentModel.class, new Deserializer());
            }

            public Object m14358a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ReactionStoryAdminPageAttachmentFragmentParser.m14401a(jsonParser);
                Object reactionStoryAdminPageAttachmentFragmentModel = new ReactionStoryAdminPageAttachmentFragmentModel();
                ((BaseModel) reactionStoryAdminPageAttachmentFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (reactionStoryAdminPageAttachmentFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionStoryAdminPageAttachmentFragmentModel).a();
                }
                return reactionStoryAdminPageAttachmentFragmentModel;
            }
        }

        /* compiled from: fingerprint_segment_offset */
        public class Serializer extends JsonSerializer<ReactionStoryAdminPageAttachmentFragmentModel> {
            public final void m14359a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ReactionStoryAdminPageAttachmentFragmentModel reactionStoryAdminPageAttachmentFragmentModel = (ReactionStoryAdminPageAttachmentFragmentModel) obj;
                if (reactionStoryAdminPageAttachmentFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionStoryAdminPageAttachmentFragmentModel.m14374a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionStoryAdminPageAttachmentFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = reactionStoryAdminPageAttachmentFragmentModel.w_();
                int u_ = reactionStoryAdminPageAttachmentFragmentModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("badge_count");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("story_admin_page");
                    StoryAdminPageParser.m14400a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ReactionStoryAdminPageAttachmentFragmentModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 2106355611)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: fingerprint_segment_offset */
        public final class StoryAdminPageModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f12029d;
            @Nullable
            private String f12030e;
            @Nullable
            private DefaultImageFieldsModel f12031f;

            /* compiled from: fingerprint_segment_offset */
            public final class Builder {
                @Nullable
                public String f12026a;
                @Nullable
                public String f12027b;
                @Nullable
                public DefaultImageFieldsModel f12028c;
            }

            /* compiled from: fingerprint_segment_offset */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(StoryAdminPageModel.class, new Deserializer());
                }

                public Object m14360a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(StoryAdminPageParser.m14399a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object storyAdminPageModel = new StoryAdminPageModel();
                    ((BaseModel) storyAdminPageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (storyAdminPageModel instanceof Postprocessable) {
                        return ((Postprocessable) storyAdminPageModel).a();
                    }
                    return storyAdminPageModel;
                }
            }

            /* compiled from: fingerprint_segment_offset */
            public class Serializer extends JsonSerializer<StoryAdminPageModel> {
                public final void m14361a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    StoryAdminPageModel storyAdminPageModel = (StoryAdminPageModel) obj;
                    if (storyAdminPageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(storyAdminPageModel.m14364a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        storyAdminPageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    StoryAdminPageParser.m14400a(storyAdminPageModel.w_(), storyAdminPageModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(StoryAdminPageModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ DefaultImageFields m14371d() {
                return m14363j();
            }

            public StoryAdminPageModel() {
                super(3);
            }

            public StoryAdminPageModel(MutableFlatBuffer mutableFlatBuffer) {
                super(3);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final void m14367a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m14368a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final String m14369b() {
                this.f12029d = super.a(this.f12029d, 0);
                return this.f12029d;
            }

            @Nullable
            public final String m14370c() {
                this.f12030e = super.a(this.f12030e, 1);
                return this.f12030e;
            }

            @Nullable
            private DefaultImageFieldsModel m14363j() {
                this.f12031f = (DefaultImageFieldsModel) super.a(this.f12031f, 2, DefaultImageFieldsModel.class);
                return this.f12031f;
            }

            public static StoryAdminPageModel m14362a(StoryAdminPageModel storyAdminPageModel) {
                if (storyAdminPageModel == null) {
                    return null;
                }
                if (storyAdminPageModel instanceof StoryAdminPageModel) {
                    return storyAdminPageModel;
                }
                Builder builder = new Builder();
                builder.f12026a = storyAdminPageModel.m14369b();
                builder.f12027b = storyAdminPageModel.m14370c();
                builder.f12028c = DefaultImageFieldsModel.a(storyAdminPageModel.m14371d());
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f12026a);
                int b2 = flatBufferBuilder.b(builder.f12027b);
                int a = ModelHelper.a(flatBufferBuilder, builder.f12028c);
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.b(2, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new StoryAdminPageModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            @Nullable
            public final String m14366a() {
                return m14369b();
            }

            public final int jK_() {
                return 2479791;
            }

            public final GraphQLVisitableModel m14365a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m14363j() != null) {
                    DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m14363j());
                    if (m14363j() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (StoryAdminPageModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f12031f = defaultImageFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m14364a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m14369b());
                int b2 = flatBufferBuilder.b(m14370c());
                int a = ModelHelper.a(flatBufferBuilder, m14363j());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.b(2, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        public ReactionStoryAdminPageAttachmentFragmentModel() {
            super(2);
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel m14372a() {
            this.f12032d = (DefaultTextWithEntitiesFieldsModel) super.a(this.f12032d, 0, DefaultTextWithEntitiesFieldsModel.class);
            return this.f12032d;
        }

        @Nullable
        private StoryAdminPageModel m14373j() {
            this.f12033e = (StoryAdminPageModel) super.a(this.f12033e, 1, StoryAdminPageModel.class);
            return this.f12033e;
        }

        public final int jK_() {
            return 1547934325;
        }

        public final GraphQLVisitableModel m14375a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m14372a() != null) {
                DefaultTextWithEntitiesFieldsModel defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m14372a());
                if (m14372a() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (ReactionStoryAdminPageAttachmentFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12032d = defaultTextWithEntitiesFieldsModel;
                }
            }
            if (m14373j() != null) {
                StoryAdminPageModel storyAdminPageModel = (StoryAdminPageModel) graphQLModelMutatingVisitor.b(m14373j());
                if (m14373j() != storyAdminPageModel) {
                    graphQLVisitableModel = (ReactionStoryAdminPageAttachmentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12033e = storyAdminPageModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m14374a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m14372a());
            int a2 = ModelHelper.a(flatBufferBuilder, m14373j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
