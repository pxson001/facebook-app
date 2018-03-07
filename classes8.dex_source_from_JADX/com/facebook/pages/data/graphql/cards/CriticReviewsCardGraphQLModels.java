package com.facebook.pages.data.graphql.cards;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.pages.data.graphql.cards.CriticReviewsCardGraphQLParsers.CriticReviewsCardQueryParser;
import com.facebook.pages.data.graphql.cards.CriticReviewsCardGraphQLParsers.CriticReviewsCardQueryParser.CriticReviewsReceivedParser;
import com.facebook.pages.data.graphql.cards.CriticReviewsCardGraphQLParsers.CriticReviewsCardQueryParser.CriticReviewsReceivedParser.NodesParser;
import com.facebook.pages.data.graphql.cards.CriticReviewsCardGraphQLParsers.CriticReviewsCardQueryParser.CriticReviewsReceivedParser.NodesParser.BylineParser;
import com.facebook.pages.data.graphql.cards.CriticReviewsCardGraphQLParsers.CriticReviewsCardQueryParser.CriticReviewsReceivedParser.NodesParser.ExternalImageParser;
import com.facebook.pages.data.graphql.cards.CriticReviewsCardGraphQLParsers.CriticReviewsCardQueryParser.CriticReviewsReceivedParser.NodesParser.PublishedOnParser;
import com.facebook.pages.data.graphql.cards.CriticReviewsCardGraphQLParsers.CriticReviewsCardQueryParser.CriticReviewsReceivedParser.NodesParser.ReviewerParser;
import com.facebook.pages.data.graphql.cards.CriticReviewsCardGraphQLParsers.CriticReviewsCardQueryParser.CriticReviewsReceivedParser.NodesParser.ReviewerParser.ProfilePictureParser;
import com.facebook.pages.data.graphql.cards.CriticReviewsCardGraphQLParsers.CriticReviewsCardQueryParser.CriticReviewsReceivedParser.NodesParser.SummaryParser;
import com.facebook.pages.data.graphql.cards.CriticReviewsCardGraphQLParsers.CriticReviewsCardQueryParser.CriticReviewsReceivedParser.NodesParser.TitleParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.nio.ByteBuffer;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: context_profile_has_profile_video */
public class CriticReviewsCardGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 657500059)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: context_profile_has_profile_video */
    public final class CriticReviewsCardQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private CriticReviewsReceivedModel f16955d;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1885767342)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: context_profile_has_profile_video */
        public final class CriticReviewsReceivedModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f16954d;

            /* compiled from: context_profile_has_profile_video */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CriticReviewsReceivedModel.class, new Deserializer());
                }

                public Object m20273a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CriticReviewsReceivedParser.m20357a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object criticReviewsReceivedModel = new CriticReviewsReceivedModel();
                    ((BaseModel) criticReviewsReceivedModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (criticReviewsReceivedModel instanceof Postprocessable) {
                        return ((Postprocessable) criticReviewsReceivedModel).a();
                    }
                    return criticReviewsReceivedModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -2059849978)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: context_profile_has_profile_video */
            public final class NodesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private BylineModel f16947d;
                @Nullable
                private ExternalImageModel f16948e;
                @Nullable
                private String f16949f;
                @Nullable
                private PublishedOnModel f16950g;
                @Nullable
                private ReviewerModel f16951h;
                @Nullable
                private SummaryModel f16952i;
                @Nullable
                private TitleModel f16953j;

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -1352864475)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: context_profile_has_profile_video */
                public final class BylineModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f16938d;

                    /* compiled from: context_profile_has_profile_video */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(BylineModel.class, new Deserializer());
                        }

                        public Object m20274a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(BylineParser.m20341a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object bylineModel = new BylineModel();
                            ((BaseModel) bylineModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (bylineModel instanceof Postprocessable) {
                                return ((Postprocessable) bylineModel).a();
                            }
                            return bylineModel;
                        }
                    }

                    /* compiled from: context_profile_has_profile_video */
                    public class Serializer extends JsonSerializer<BylineModel> {
                        public final void m20275a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            BylineModel bylineModel = (BylineModel) obj;
                            if (bylineModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(bylineModel.m20276a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                bylineModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            BylineParser.m20342a(bylineModel.w_(), bylineModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(BylineModel.class, new Serializer());
                        }
                    }

                    public BylineModel() {
                        super(1);
                    }

                    @Nullable
                    public final String m20278a() {
                        this.f16938d = super.a(this.f16938d, 0);
                        return this.f16938d;
                    }

                    public final int jK_() {
                        return -1919764332;
                    }

                    public final GraphQLVisitableModel m20277a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m20276a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m20278a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: context_profile_has_profile_video */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m20279a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NodesParser.m20355b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object nodesModel = new NodesModel();
                        ((BaseModel) nodesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (nodesModel instanceof Postprocessable) {
                            return ((Postprocessable) nodesModel).a();
                        }
                        return nodesModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 842551240)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: context_profile_has_profile_video */
                public final class ExternalImageModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f16939d;

                    /* compiled from: context_profile_has_profile_video */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(ExternalImageModel.class, new Deserializer());
                        }

                        public Object m20280a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(ExternalImageParser.m20343a(jsonParser, flatBufferBuilder));
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

                    /* compiled from: context_profile_has_profile_video */
                    public class Serializer extends JsonSerializer<ExternalImageModel> {
                        public final void m20281a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            ExternalImageModel externalImageModel = (ExternalImageModel) obj;
                            if (externalImageModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(externalImageModel.m20282a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                externalImageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            ExternalImageParser.m20344a(externalImageModel.w_(), externalImageModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(ExternalImageModel.class, new Serializer());
                        }
                    }

                    public ExternalImageModel() {
                        super(1);
                    }

                    @Nullable
                    public final String m20284a() {
                        this.f16939d = super.a(this.f16939d, 0);
                        return this.f16939d;
                    }

                    public final int jK_() {
                        return 70760763;
                    }

                    public final GraphQLVisitableModel m20283a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m20282a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m20284a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -1352864475)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: context_profile_has_profile_video */
                public final class PublishedOnModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f16940d;

                    /* compiled from: context_profile_has_profile_video */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(PublishedOnModel.class, new Deserializer());
                        }

                        public Object m20285a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(PublishedOnParser.m20345a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object publishedOnModel = new PublishedOnModel();
                            ((BaseModel) publishedOnModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (publishedOnModel instanceof Postprocessable) {
                                return ((Postprocessable) publishedOnModel).a();
                            }
                            return publishedOnModel;
                        }
                    }

                    /* compiled from: context_profile_has_profile_video */
                    public class Serializer extends JsonSerializer<PublishedOnModel> {
                        public final void m20286a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            PublishedOnModel publishedOnModel = (PublishedOnModel) obj;
                            if (publishedOnModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(publishedOnModel.m20287a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                publishedOnModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            PublishedOnParser.m20346a(publishedOnModel.w_(), publishedOnModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(PublishedOnModel.class, new Serializer());
                        }
                    }

                    public PublishedOnModel() {
                        super(1);
                    }

                    @Nullable
                    public final String m20289a() {
                        this.f16940d = super.a(this.f16940d, 0);
                        return this.f16940d;
                    }

                    public final int jK_() {
                        return -1919764332;
                    }

                    public final GraphQLVisitableModel m20288a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m20287a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m20289a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -28082189)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: context_profile_has_profile_video */
                public final class ReviewerModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                    @Nullable
                    private String f16942d;
                    @Nullable
                    private String f16943e;
                    @Nullable
                    private ProfilePictureModel f16944f;

                    /* compiled from: context_profile_has_profile_video */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(ReviewerModel.class, new Deserializer());
                        }

                        public Object m20290a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(ReviewerParser.m20349a(jsonParser, flatBufferBuilder));
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
                    /* compiled from: context_profile_has_profile_video */
                    public final class ProfilePictureModel extends BaseModel implements GraphQLVisitableModel {
                        @Nullable
                        private String f16941d;

                        /* compiled from: context_profile_has_profile_video */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(ProfilePictureModel.class, new Deserializer());
                            }

                            public Object m20291a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(ProfilePictureParser.m20347a(jsonParser, flatBufferBuilder));
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

                        /* compiled from: context_profile_has_profile_video */
                        public class Serializer extends JsonSerializer<ProfilePictureModel> {
                            public final void m20292a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                ProfilePictureModel profilePictureModel = (ProfilePictureModel) obj;
                                if (profilePictureModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(profilePictureModel.m20293a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    profilePictureModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                ProfilePictureParser.m20348a(profilePictureModel.w_(), profilePictureModel.u_(), jsonGenerator);
                            }

                            static {
                                FbSerializerProvider.a(ProfilePictureModel.class, new Serializer());
                            }
                        }

                        public ProfilePictureModel() {
                            super(1);
                        }

                        @Nullable
                        public final String m20295a() {
                            this.f16941d = super.a(this.f16941d, 0);
                            return this.f16941d;
                        }

                        public final int jK_() {
                            return 70760763;
                        }

                        public final GraphQLVisitableModel m20294a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            h();
                            i();
                            return this;
                        }

                        public final int m20293a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int b = flatBufferBuilder.b(m20295a());
                            flatBufferBuilder.c(1);
                            flatBufferBuilder.b(0, b);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    /* compiled from: context_profile_has_profile_video */
                    public class Serializer extends JsonSerializer<ReviewerModel> {
                        public final void m20296a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            ReviewerModel reviewerModel = (ReviewerModel) obj;
                            if (reviewerModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(reviewerModel.m20298a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                reviewerModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            ReviewerParser.m20350a(reviewerModel.w_(), reviewerModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(ReviewerModel.class, new Serializer());
                        }
                    }

                    @Nullable
                    public final /* synthetic */ ProfilePictureModel m20305d() {
                        return m20297j();
                    }

                    public ReviewerModel() {
                        super(3);
                    }

                    public final void m20301a(String str, ConsistencyTuple consistencyTuple) {
                        consistencyTuple.a();
                    }

                    public final void m20302a(String str, Object obj, boolean z) {
                    }

                    @Nullable
                    public final String m20303b() {
                        this.f16942d = super.a(this.f16942d, 0);
                        return this.f16942d;
                    }

                    @Nullable
                    public final String m20304c() {
                        this.f16943e = super.a(this.f16943e, 1);
                        return this.f16943e;
                    }

                    @Nullable
                    private ProfilePictureModel m20297j() {
                        this.f16944f = (ProfilePictureModel) super.a(this.f16944f, 2, ProfilePictureModel.class);
                        return this.f16944f;
                    }

                    @Nullable
                    public final String m20300a() {
                        return m20303b();
                    }

                    public final int jK_() {
                        return 2479791;
                    }

                    public final GraphQLVisitableModel m20299a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m20297j() != null) {
                            ProfilePictureModel profilePictureModel = (ProfilePictureModel) graphQLModelMutatingVisitor.b(m20297j());
                            if (m20297j() != profilePictureModel) {
                                graphQLVisitableModel = (ReviewerModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f16944f = profilePictureModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m20298a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m20303b());
                        int b2 = flatBufferBuilder.b(m20304c());
                        int a = ModelHelper.a(flatBufferBuilder, m20297j());
                        flatBufferBuilder.c(3);
                        flatBufferBuilder.b(0, b);
                        flatBufferBuilder.b(1, b2);
                        flatBufferBuilder.b(2, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: context_profile_has_profile_video */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m20306a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m20323a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NodesParser.m20356b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -1352864475)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: context_profile_has_profile_video */
                public final class SummaryModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f16945d;

                    /* compiled from: context_profile_has_profile_video */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(SummaryModel.class, new Deserializer());
                        }

                        public Object m20307a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(SummaryParser.m20351a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object summaryModel = new SummaryModel();
                            ((BaseModel) summaryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (summaryModel instanceof Postprocessable) {
                                return ((Postprocessable) summaryModel).a();
                            }
                            return summaryModel;
                        }
                    }

                    /* compiled from: context_profile_has_profile_video */
                    public class Serializer extends JsonSerializer<SummaryModel> {
                        public final void m20308a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            SummaryModel summaryModel = (SummaryModel) obj;
                            if (summaryModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(summaryModel.m20309a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                summaryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            SummaryParser.m20352a(summaryModel.w_(), summaryModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(SummaryModel.class, new Serializer());
                        }
                    }

                    public SummaryModel() {
                        super(1);
                    }

                    @Nullable
                    public final String m20311a() {
                        this.f16945d = super.a(this.f16945d, 0);
                        return this.f16945d;
                    }

                    public final int jK_() {
                        return -1919764332;
                    }

                    public final GraphQLVisitableModel m20310a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m20309a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m20311a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -1352864475)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: context_profile_has_profile_video */
                public final class TitleModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f16946d;

                    /* compiled from: context_profile_has_profile_video */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(TitleModel.class, new Deserializer());
                        }

                        public Object m20312a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(TitleParser.m20353a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object titleModel = new TitleModel();
                            ((BaseModel) titleModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (titleModel instanceof Postprocessable) {
                                return ((Postprocessable) titleModel).a();
                            }
                            return titleModel;
                        }
                    }

                    /* compiled from: context_profile_has_profile_video */
                    public class Serializer extends JsonSerializer<TitleModel> {
                        public final void m20313a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            TitleModel titleModel = (TitleModel) obj;
                            if (titleModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(titleModel.m20314a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                titleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            TitleParser.m20354a(titleModel.w_(), titleModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(TitleModel.class, new Serializer());
                        }
                    }

                    public TitleModel() {
                        super(1);
                    }

                    @Nullable
                    public final String m20316a() {
                        this.f16946d = super.a(this.f16946d, 0);
                        return this.f16946d;
                    }

                    public final int jK_() {
                        return -1919764332;
                    }

                    public final GraphQLVisitableModel m20315a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m20314a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m20316a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                @Nullable
                public final /* synthetic */ BylineModel m20325a() {
                    return m20317j();
                }

                @Nullable
                public final /* synthetic */ ExternalImageModel m20326b() {
                    return m20318k();
                }

                @Nullable
                public final /* synthetic */ PublishedOnModel m20328d() {
                    return m20319l();
                }

                @Nullable
                public final /* synthetic */ SummaryModel m20329g() {
                    return m20321n();
                }

                @Nullable
                public final /* synthetic */ TitleModel ks_() {
                    return m20322o();
                }

                @Nullable
                public final /* synthetic */ ReviewerModel kt_() {
                    return m20320m();
                }

                public NodesModel() {
                    super(7);
                }

                @Nullable
                private BylineModel m20317j() {
                    this.f16947d = (BylineModel) super.a(this.f16947d, 0, BylineModel.class);
                    return this.f16947d;
                }

                @Nullable
                private ExternalImageModel m20318k() {
                    this.f16948e = (ExternalImageModel) super.a(this.f16948e, 1, ExternalImageModel.class);
                    return this.f16948e;
                }

                @Nullable
                public final String m20327c() {
                    this.f16949f = super.a(this.f16949f, 2);
                    return this.f16949f;
                }

                @Nullable
                private PublishedOnModel m20319l() {
                    this.f16950g = (PublishedOnModel) super.a(this.f16950g, 3, PublishedOnModel.class);
                    return this.f16950g;
                }

                @Nullable
                private ReviewerModel m20320m() {
                    this.f16951h = (ReviewerModel) super.a(this.f16951h, 4, ReviewerModel.class);
                    return this.f16951h;
                }

                @Nullable
                private SummaryModel m20321n() {
                    this.f16952i = (SummaryModel) super.a(this.f16952i, 5, SummaryModel.class);
                    return this.f16952i;
                }

                @Nullable
                private TitleModel m20322o() {
                    this.f16953j = (TitleModel) super.a(this.f16953j, 6, TitleModel.class);
                    return this.f16953j;
                }

                public final int jK_() {
                    return 1418709260;
                }

                public final GraphQLVisitableModel m20324a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m20317j() != null) {
                        BylineModel bylineModel = (BylineModel) graphQLModelMutatingVisitor.b(m20317j());
                        if (m20317j() != bylineModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f16947d = bylineModel;
                        }
                    }
                    if (m20318k() != null) {
                        ExternalImageModel externalImageModel = (ExternalImageModel) graphQLModelMutatingVisitor.b(m20318k());
                        if (m20318k() != externalImageModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f16948e = externalImageModel;
                        }
                    }
                    if (m20319l() != null) {
                        PublishedOnModel publishedOnModel = (PublishedOnModel) graphQLModelMutatingVisitor.b(m20319l());
                        if (m20319l() != publishedOnModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f16950g = publishedOnModel;
                        }
                    }
                    if (m20320m() != null) {
                        ReviewerModel reviewerModel = (ReviewerModel) graphQLModelMutatingVisitor.b(m20320m());
                        if (m20320m() != reviewerModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f16951h = reviewerModel;
                        }
                    }
                    if (m20321n() != null) {
                        SummaryModel summaryModel = (SummaryModel) graphQLModelMutatingVisitor.b(m20321n());
                        if (m20321n() != summaryModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f16952i = summaryModel;
                        }
                    }
                    if (m20322o() != null) {
                        TitleModel titleModel = (TitleModel) graphQLModelMutatingVisitor.b(m20322o());
                        if (m20322o() != titleModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f16953j = titleModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m20323a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m20317j());
                    int a2 = ModelHelper.a(flatBufferBuilder, m20318k());
                    int b = flatBufferBuilder.b(m20327c());
                    int a3 = ModelHelper.a(flatBufferBuilder, m20319l());
                    int a4 = ModelHelper.a(flatBufferBuilder, m20320m());
                    int a5 = ModelHelper.a(flatBufferBuilder, m20321n());
                    int a6 = ModelHelper.a(flatBufferBuilder, m20322o());
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

            /* compiled from: context_profile_has_profile_video */
            public class Serializer extends JsonSerializer<CriticReviewsReceivedModel> {
                public final void m20330a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CriticReviewsReceivedModel criticReviewsReceivedModel = (CriticReviewsReceivedModel) obj;
                    if (criticReviewsReceivedModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(criticReviewsReceivedModel.m20331a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        criticReviewsReceivedModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CriticReviewsReceivedParser.m20358a(criticReviewsReceivedModel.w_(), criticReviewsReceivedModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(CriticReviewsReceivedModel.class, new Serializer());
                }
            }

            public CriticReviewsReceivedModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<NodesModel> m20333a() {
                this.f16954d = super.a(this.f16954d, 0, NodesModel.class);
                return (ImmutableList) this.f16954d;
            }

            public final int jK_() {
                return 1832156247;
            }

            public final GraphQLVisitableModel m20332a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m20333a() != null) {
                    Builder a = ModelHelper.a(m20333a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (CriticReviewsReceivedModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f16954d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m20331a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m20333a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: context_profile_has_profile_video */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CriticReviewsCardQueryModel.class, new Deserializer());
            }

            public Object m20334a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = CriticReviewsCardQueryParser.m20359a(jsonParser);
                Object criticReviewsCardQueryModel = new CriticReviewsCardQueryModel();
                ((BaseModel) criticReviewsCardQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (criticReviewsCardQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) criticReviewsCardQueryModel).a();
                }
                return criticReviewsCardQueryModel;
            }
        }

        /* compiled from: context_profile_has_profile_video */
        public class Serializer extends JsonSerializer<CriticReviewsCardQueryModel> {
            public final void m20335a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                CriticReviewsCardQueryModel criticReviewsCardQueryModel = (CriticReviewsCardQueryModel) obj;
                if (criticReviewsCardQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(criticReviewsCardQueryModel.m20336a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    criticReviewsCardQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = criticReviewsCardQueryModel.w_();
                int u_ = criticReviewsCardQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("critic_reviews_received");
                    CriticReviewsReceivedParser.m20358a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(CriticReviewsCardQueryModel.class, new Serializer());
            }
        }

        public CriticReviewsCardQueryModel() {
            super(1);
        }

        public final void m20339a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m20340a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final CriticReviewsReceivedModel m20338a() {
            this.f16955d = (CriticReviewsReceivedModel) super.a(this.f16955d, 0, CriticReviewsReceivedModel.class);
            return this.f16955d;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m20337a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m20338a() != null) {
                CriticReviewsReceivedModel criticReviewsReceivedModel = (CriticReviewsReceivedModel) graphQLModelMutatingVisitor.b(m20338a());
                if (m20338a() != criticReviewsReceivedModel) {
                    graphQLVisitableModel = (CriticReviewsCardQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f16955d = criticReviewsReceivedModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m20336a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m20338a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
