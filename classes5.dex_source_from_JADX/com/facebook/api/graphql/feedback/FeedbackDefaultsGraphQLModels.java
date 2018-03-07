package com.facebook.api.graphql.feedback;

import com.facebook.api.graphql.feedback.FeedbackDefaultsGraphQLInterfaces.BaseFeedbackFields;
import com.facebook.api.graphql.feedback.FeedbackDefaultsGraphQLInterfaces.FeedbackRealTimeActivityInfoFields;
import com.facebook.api.graphql.feedback.FeedbackDefaultsGraphQLInterfaces.SimpleFeedFeedback;
import com.facebook.api.graphql.feedback.FeedbackDefaultsGraphQLParsers.BaseFeedbackFieldsParser;
import com.facebook.api.graphql.feedback.FeedbackDefaultsGraphQLParsers.BaseFeedbackFieldsParser.ViewerActsAsPageParser;
import com.facebook.api.graphql.feedback.FeedbackDefaultsGraphQLParsers.FeedbackRealTimeActivityInfoFieldsParser;
import com.facebook.api.graphql.feedback.FeedbackDefaultsGraphQLParsers.FeedbackRealTimeActivityInfoFieldsParser.RealTimeActivityInfoParser;
import com.facebook.api.graphql.feedback.FeedbackDefaultsGraphQLParsers.FeedbackRealTimeActivityInfoFieldsParser.RealTimeActivityInfoParser.RealTimeActivityActorsParser;
import com.facebook.api.graphql.feedback.FeedbackDefaultsGraphQLParsers.FeedbackRealTimeActivityInfoFieldsParser.RealTimeActivityInfoParser.RealTimeActivityActorsParser.NodesParser;
import com.facebook.api.graphql.feedback.FeedbackDefaultsGraphQLParsers.SimpleFeedFeedbackParser;
import com.facebook.api.graphql.feedback.FeedbackDefaultsGraphQLParsers.SimpleFeedFeedbackParser.LikersParser;
import com.facebook.api.graphql.feedback.FeedbackDefaultsGraphQLParsers.SimpleFeedFeedbackParser.ResharesParser;
import com.facebook.api.graphql.feedback.FeedbackDefaultsGraphQLParsers.SimpleFeedFeedbackParser.TopLevelCommentsParser;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ReactionsCountFieldsModel.TopReactionsModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.SimpleReactionsFeedbackFieldsModel.ReactorsModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ViewerReactionsFeedbackFieldsModel.SupportedReactionsModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ViewerReactionsSocialFeedbackFieldsModel.ImportantReactorsModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ViewerReactionsSocialFeedbackFieldsModel.ViewerActsAsPersonModel;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLFeedbackRealTimeActivityType;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
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

/* compiled from: api.flickr.com */
public class FeedbackDefaultsGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 196694664)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: api.flickr.com */
    public final class BaseFeedbackFieldsModel extends BaseModel implements BaseFeedbackFields, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        private boolean f9479d;
        private boolean f9480e;
        private boolean f9481f;
        private boolean f9482g;
        private boolean f9483h;
        private boolean f9484i;
        private boolean f9485j;
        @Nullable
        private String f9486k;
        private boolean f9487l;
        @Nullable
        private String f9488m;
        private boolean f9489n;
        @Nullable
        private String f9490o;
        @Nullable
        private String f9491p;
        @Nullable
        private ViewerActsAsPageModel f9492q;

        /* compiled from: api.flickr.com */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(BaseFeedbackFieldsModel.class, new Deserializer());
            }

            public Object m16154a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(BaseFeedbackFieldsParser.m16282a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object baseFeedbackFieldsModel = new BaseFeedbackFieldsModel();
                ((BaseModel) baseFeedbackFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (baseFeedbackFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) baseFeedbackFieldsModel).a();
                }
                return baseFeedbackFieldsModel;
            }
        }

        /* compiled from: api.flickr.com */
        public class Serializer extends JsonSerializer<BaseFeedbackFieldsModel> {
            public final void m16155a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                BaseFeedbackFieldsModel baseFeedbackFieldsModel = (BaseFeedbackFieldsModel) obj;
                if (baseFeedbackFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(baseFeedbackFieldsModel.m16173a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    baseFeedbackFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                BaseFeedbackFieldsParser.m16283a(baseFeedbackFieldsModel.w_(), baseFeedbackFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(BaseFeedbackFieldsModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 2106355611)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: api.flickr.com */
        public final class ViewerActsAsPageModel extends BaseModel implements C0963x86c33d71, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f9476d;
            @Nullable
            private String f9477e;
            @Nullable
            private DefaultImageFieldsModel f9478f;

            /* compiled from: api.flickr.com */
            public final class Builder {
                @Nullable
                public String f9473a;
                @Nullable
                public String f9474b;
                @Nullable
                public DefaultImageFieldsModel f9475c;
            }

            /* compiled from: api.flickr.com */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ViewerActsAsPageModel.class, new Deserializer());
                }

                public Object m16156a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ViewerActsAsPageParser.m16280a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object viewerActsAsPageModel = new ViewerActsAsPageModel();
                    ((BaseModel) viewerActsAsPageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (viewerActsAsPageModel instanceof Postprocessable) {
                        return ((Postprocessable) viewerActsAsPageModel).a();
                    }
                    return viewerActsAsPageModel;
                }
            }

            /* compiled from: api.flickr.com */
            public class Serializer extends JsonSerializer<ViewerActsAsPageModel> {
                public final void m16157a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ViewerActsAsPageModel viewerActsAsPageModel = (ViewerActsAsPageModel) obj;
                    if (viewerActsAsPageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(viewerActsAsPageModel.m16160a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        viewerActsAsPageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ViewerActsAsPageParser.m16281a(viewerActsAsPageModel.w_(), viewerActsAsPageModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ViewerActsAsPageModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ DefaultImageFields mo1113d() {
                return m16159j();
            }

            public ViewerActsAsPageModel() {
                super(3);
            }

            public ViewerActsAsPageModel(MutableFlatBuffer mutableFlatBuffer) {
                super(3);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final void m16163a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m16164a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final String mo1111b() {
                this.f9476d = super.a(this.f9476d, 0);
                return this.f9476d;
            }

            @Nullable
            public final String mo1112c() {
                this.f9477e = super.a(this.f9477e, 1);
                return this.f9477e;
            }

            @Nullable
            private DefaultImageFieldsModel m16159j() {
                this.f9478f = (DefaultImageFieldsModel) super.a(this.f9478f, 2, DefaultImageFieldsModel.class);
                return this.f9478f;
            }

            public static ViewerActsAsPageModel m16158a(C0963x86c33d71 c0963x86c33d71) {
                if (c0963x86c33d71 == null) {
                    return null;
                }
                if (c0963x86c33d71 instanceof ViewerActsAsPageModel) {
                    return (ViewerActsAsPageModel) c0963x86c33d71;
                }
                Builder builder = new Builder();
                builder.f9473a = c0963x86c33d71.mo1111b();
                builder.f9474b = c0963x86c33d71.mo1112c();
                builder.f9475c = DefaultImageFieldsModel.a(c0963x86c33d71.mo1113d());
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f9473a);
                int b2 = flatBufferBuilder.b(builder.f9474b);
                int a = ModelHelper.a(flatBufferBuilder, builder.f9475c);
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.b(2, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new ViewerActsAsPageModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            @Nullable
            public final String m16162a() {
                return mo1111b();
            }

            public final int jK_() {
                return 2479791;
            }

            public final GraphQLVisitableModel m16161a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m16159j() != null) {
                    DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m16159j());
                    if (m16159j() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (ViewerActsAsPageModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f9478f = defaultImageFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m16160a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(mo1111b());
                int b2 = flatBufferBuilder.b(mo1112c());
                int a = ModelHelper.a(flatBufferBuilder, m16159j());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.b(2, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        @Nullable
        public final /* synthetic */ C0963x86c33d71 m16189p() {
            return m16172q();
        }

        public BaseFeedbackFieldsModel() {
            super(14);
        }

        public final void m16177a(String str, ConsistencyTuple consistencyTuple) {
            if ("can_viewer_comment".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m16180c());
                consistencyTuple.b = u_();
                consistencyTuple.c = 1;
            } else if ("can_viewer_like".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(bU_());
                consistencyTuple.b = u_();
                consistencyTuple.c = 5;
            } else if ("does_viewer_like".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m16184k());
                consistencyTuple.b = u_();
                consistencyTuple.c = 8;
            } else if ("is_viewer_subscribed".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m16186m());
                consistencyTuple.b = u_();
                consistencyTuple.c = 10;
            } else {
                consistencyTuple.a();
            }
        }

        public final void m16178a(String str, Object obj, boolean z) {
            if ("can_viewer_comment".equals(str)) {
                m16168a(((Boolean) obj).booleanValue());
            } else if ("can_viewer_like".equals(str)) {
                m16169b(((Boolean) obj).booleanValue());
            } else if ("does_viewer_like".equals(str)) {
                m16170c(((Boolean) obj).booleanValue());
            } else if ("is_viewer_subscribed".equals(str)) {
                m16171d(((Boolean) obj).booleanValue());
            }
        }

        public final boolean m16179b() {
            a(0, 0);
            return this.f9479d;
        }

        public final boolean m16180c() {
            a(0, 1);
            return this.f9480e;
        }

        private void m16168a(boolean z) {
            this.f9480e = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 1, z);
            }
        }

        public final boolean m16181d() {
            a(0, 2);
            return this.f9481f;
        }

        public final boolean bT_() {
            a(0, 3);
            return this.f9482g;
        }

        public final boolean m16182g() {
            a(0, 4);
            return this.f9483h;
        }

        public final boolean bU_() {
            a(0, 5);
            return this.f9484i;
        }

        private void m16169b(boolean z) {
            this.f9484i = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 5, z);
            }
        }

        public final boolean bV_() {
            a(0, 6);
            return this.f9485j;
        }

        @Nullable
        public final String m16183j() {
            this.f9486k = super.a(this.f9486k, 7);
            return this.f9486k;
        }

        public final boolean m16184k() {
            a(1, 0);
            return this.f9487l;
        }

        private void m16170c(boolean z) {
            this.f9487l = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 8, z);
            }
        }

        @Nullable
        public final String m16185l() {
            this.f9488m = super.a(this.f9488m, 9);
            return this.f9488m;
        }

        public final boolean m16186m() {
            a(1, 2);
            return this.f9489n;
        }

        private void m16171d(boolean z) {
            this.f9489n = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 10, z);
            }
        }

        @Nullable
        public final String m16187n() {
            this.f9490o = super.a(this.f9490o, 11);
            return this.f9490o;
        }

        @Nullable
        public final String m16188o() {
            this.f9491p = super.a(this.f9491p, 12);
            return this.f9491p;
        }

        @Nullable
        private ViewerActsAsPageModel m16172q() {
            this.f9492q = (ViewerActsAsPageModel) super.a(this.f9492q, 13, ViewerActsAsPageModel.class);
            return this.f9492q;
        }

        @Nullable
        public final String m16175a() {
            return m16187n();
        }

        public final int jK_() {
            return -126857307;
        }

        public final GraphQLVisitableModel m16174a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16172q() != null) {
                ViewerActsAsPageModel viewerActsAsPageModel = (ViewerActsAsPageModel) graphQLModelMutatingVisitor.b(m16172q());
                if (m16172q() != viewerActsAsPageModel) {
                    graphQLVisitableModel = (BaseFeedbackFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9492q = viewerActsAsPageModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16173a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m16183j());
            int b2 = flatBufferBuilder.b(m16185l());
            int b3 = flatBufferBuilder.b(m16187n());
            int b4 = flatBufferBuilder.b(m16188o());
            int a = ModelHelper.a(flatBufferBuilder, m16172q());
            flatBufferBuilder.c(14);
            flatBufferBuilder.a(0, this.f9479d);
            flatBufferBuilder.a(1, this.f9480e);
            flatBufferBuilder.a(2, this.f9481f);
            flatBufferBuilder.a(3, this.f9482g);
            flatBufferBuilder.a(4, this.f9483h);
            flatBufferBuilder.a(5, this.f9484i);
            flatBufferBuilder.a(6, this.f9485j);
            flatBufferBuilder.b(7, b);
            flatBufferBuilder.a(8, this.f9487l);
            flatBufferBuilder.b(9, b2);
            flatBufferBuilder.a(10, this.f9489n);
            flatBufferBuilder.b(11, b3);
            flatBufferBuilder.b(12, b4);
            flatBufferBuilder.b(13, a);
            i();
            return flatBufferBuilder.d();
        }

        public final void m16176a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f9479d = mutableFlatBuffer.a(i, 0);
            this.f9480e = mutableFlatBuffer.a(i, 1);
            this.f9481f = mutableFlatBuffer.a(i, 2);
            this.f9482g = mutableFlatBuffer.a(i, 3);
            this.f9483h = mutableFlatBuffer.a(i, 4);
            this.f9484i = mutableFlatBuffer.a(i, 5);
            this.f9485j = mutableFlatBuffer.a(i, 6);
            this.f9487l = mutableFlatBuffer.a(i, 8);
            this.f9489n = mutableFlatBuffer.a(i, 10);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -953813418)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: api.flickr.com */
    public final class FeedbackRealTimeActivityInfoFieldsModel extends BaseModel implements FeedbackRealTimeActivityInfoFields, GraphQLVisitableConsistentModel {
        @Nullable
        private RealTimeActivityInfoModel f9501d;

        /* compiled from: api.flickr.com */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FeedbackRealTimeActivityInfoFieldsModel.class, new Deserializer());
            }

            public Object m16190a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FeedbackRealTimeActivityInfoFieldsParser.m16290a(jsonParser);
                Object feedbackRealTimeActivityInfoFieldsModel = new FeedbackRealTimeActivityInfoFieldsModel();
                ((BaseModel) feedbackRealTimeActivityInfoFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (feedbackRealTimeActivityInfoFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) feedbackRealTimeActivityInfoFieldsModel).a();
                }
                return feedbackRealTimeActivityInfoFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 2122543104)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: api.flickr.com */
        public final class RealTimeActivityInfoModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private RealTimeActivityActorsModel f9498d;
            @Nullable
            private DefaultTextWithEntitiesLongFieldsModel f9499e;
            @Nullable
            private GraphQLFeedbackRealTimeActivityType f9500f;

            /* compiled from: api.flickr.com */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(RealTimeActivityInfoModel.class, new Deserializer());
                }

                public Object m16191a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(RealTimeActivityInfoParser.m16288a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object realTimeActivityInfoModel = new RealTimeActivityInfoModel();
                    ((BaseModel) realTimeActivityInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (realTimeActivityInfoModel instanceof Postprocessable) {
                        return ((Postprocessable) realTimeActivityInfoModel).a();
                    }
                    return realTimeActivityInfoModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1549228254)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: api.flickr.com */
            public final class RealTimeActivityActorsModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private List<NodesModel> f9497d;

                /* compiled from: api.flickr.com */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(RealTimeActivityActorsModel.class, new Deserializer());
                    }

                    public Object m16192a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(RealTimeActivityActorsParser.m16286a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object realTimeActivityActorsModel = new RealTimeActivityActorsModel();
                        ((BaseModel) realTimeActivityActorsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (realTimeActivityActorsModel instanceof Postprocessable) {
                            return ((Postprocessable) realTimeActivityActorsModel).a();
                        }
                        return realTimeActivityActorsModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 289552164)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: api.flickr.com */
                public final class NodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                    @Nullable
                    private GraphQLObjectType f9493d;
                    @Nullable
                    private String f9494e;
                    @Nullable
                    private String f9495f;
                    @Nullable
                    private DefaultImageFieldsModel f9496g;

                    /* compiled from: api.flickr.com */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                        }

                        public Object m16193a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(NodesParser.m16284b(jsonParser, flatBufferBuilder));
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

                    /* compiled from: api.flickr.com */
                    public class Serializer extends JsonSerializer<NodesModel> {
                        public final void m16194a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            NodesModel nodesModel = (NodesModel) obj;
                            if (nodesModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(nodesModel.m16196a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            NodesParser.m16285b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(NodesModel.class, new Serializer());
                        }
                    }

                    @Nullable
                    public final /* synthetic */ DefaultImageFields bW_() {
                        return m16195j();
                    }

                    public NodesModel() {
                        super(4);
                    }

                    public final void m16199a(String str, ConsistencyTuple consistencyTuple) {
                        consistencyTuple.a();
                    }

                    public final void m16200a(String str, Object obj, boolean z) {
                    }

                    @Nullable
                    public final GraphQLObjectType m16201b() {
                        if (this.b != null && this.f9493d == null) {
                            this.f9493d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                        }
                        return this.f9493d;
                    }

                    @Nullable
                    public final String m16202c() {
                        this.f9494e = super.a(this.f9494e, 1);
                        return this.f9494e;
                    }

                    @Nullable
                    public final String m16203d() {
                        this.f9495f = super.a(this.f9495f, 2);
                        return this.f9495f;
                    }

                    @Nullable
                    private DefaultImageFieldsModel m16195j() {
                        this.f9496g = (DefaultImageFieldsModel) super.a(this.f9496g, 3, DefaultImageFieldsModel.class);
                        return this.f9496g;
                    }

                    @Nullable
                    public final String m16198a() {
                        return m16202c();
                    }

                    public final int jK_() {
                        return 63093205;
                    }

                    public final GraphQLVisitableModel m16197a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m16195j() != null) {
                            DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m16195j());
                            if (m16195j() != defaultImageFieldsModel) {
                                graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f9496g = defaultImageFieldsModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m16196a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m16201b());
                        int b = flatBufferBuilder.b(m16202c());
                        int b2 = flatBufferBuilder.b(m16203d());
                        int a2 = ModelHelper.a(flatBufferBuilder, m16195j());
                        flatBufferBuilder.c(4);
                        flatBufferBuilder.b(0, a);
                        flatBufferBuilder.b(1, b);
                        flatBufferBuilder.b(2, b2);
                        flatBufferBuilder.b(3, a2);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: api.flickr.com */
                public class Serializer extends JsonSerializer<RealTimeActivityActorsModel> {
                    public final void m16204a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        RealTimeActivityActorsModel realTimeActivityActorsModel = (RealTimeActivityActorsModel) obj;
                        if (realTimeActivityActorsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(realTimeActivityActorsModel.m16205a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            realTimeActivityActorsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        RealTimeActivityActorsParser.m16287a(realTimeActivityActorsModel.w_(), realTimeActivityActorsModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(RealTimeActivityActorsModel.class, new Serializer());
                    }
                }

                public RealTimeActivityActorsModel() {
                    super(1);
                }

                @Nonnull
                public final ImmutableList<NodesModel> m16207a() {
                    this.f9497d = super.a(this.f9497d, 0, NodesModel.class);
                    return (ImmutableList) this.f9497d;
                }

                public final int jK_() {
                    return 1841524795;
                }

                public final GraphQLVisitableModel m16206a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m16207a() != null) {
                        Builder a = ModelHelper.a(m16207a(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            graphQLVisitableModel = (RealTimeActivityActorsModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f9497d = a.b();
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m16205a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m16207a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: api.flickr.com */
            public class Serializer extends JsonSerializer<RealTimeActivityInfoModel> {
                public final void m16208a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    RealTimeActivityInfoModel realTimeActivityInfoModel = (RealTimeActivityInfoModel) obj;
                    if (realTimeActivityInfoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(realTimeActivityInfoModel.m16211a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        realTimeActivityInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    RealTimeActivityInfoParser.m16289a(realTimeActivityInfoModel.w_(), realTimeActivityInfoModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(RealTimeActivityInfoModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ RealTimeActivityActorsModel m16212a() {
                return m16209j();
            }

            @Nullable
            public final /* synthetic */ DefaultTextWithEntitiesLongFields m16214b() {
                return m16210k();
            }

            public RealTimeActivityInfoModel() {
                super(3);
            }

            @Nullable
            private RealTimeActivityActorsModel m16209j() {
                this.f9498d = (RealTimeActivityActorsModel) super.a(this.f9498d, 0, RealTimeActivityActorsModel.class);
                return this.f9498d;
            }

            @Nullable
            private DefaultTextWithEntitiesLongFieldsModel m16210k() {
                this.f9499e = (DefaultTextWithEntitiesLongFieldsModel) super.a(this.f9499e, 1, DefaultTextWithEntitiesLongFieldsModel.class);
                return this.f9499e;
            }

            @Nullable
            public final GraphQLFeedbackRealTimeActivityType m16215c() {
                this.f9500f = (GraphQLFeedbackRealTimeActivityType) super.b(this.f9500f, 2, GraphQLFeedbackRealTimeActivityType.class, GraphQLFeedbackRealTimeActivityType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f9500f;
            }

            public final int jK_() {
                return 446720205;
            }

            public final GraphQLVisitableModel m16213a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m16209j() != null) {
                    RealTimeActivityActorsModel realTimeActivityActorsModel = (RealTimeActivityActorsModel) graphQLModelMutatingVisitor.b(m16209j());
                    if (m16209j() != realTimeActivityActorsModel) {
                        graphQLVisitableModel = (RealTimeActivityInfoModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f9498d = realTimeActivityActorsModel;
                    }
                }
                if (m16210k() != null) {
                    DefaultTextWithEntitiesLongFieldsModel defaultTextWithEntitiesLongFieldsModel = (DefaultTextWithEntitiesLongFieldsModel) graphQLModelMutatingVisitor.b(m16210k());
                    if (m16210k() != defaultTextWithEntitiesLongFieldsModel) {
                        graphQLVisitableModel = (RealTimeActivityInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f9499e = defaultTextWithEntitiesLongFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m16211a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m16209j());
                int a2 = ModelHelper.a(flatBufferBuilder, m16210k());
                int a3 = flatBufferBuilder.a(m16215c());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, a3);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: api.flickr.com */
        public class Serializer extends JsonSerializer<FeedbackRealTimeActivityInfoFieldsModel> {
            public final void m16216a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FeedbackRealTimeActivityInfoFieldsModel feedbackRealTimeActivityInfoFieldsModel = (FeedbackRealTimeActivityInfoFieldsModel) obj;
                if (feedbackRealTimeActivityInfoFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(feedbackRealTimeActivityInfoFieldsModel.m16218a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    feedbackRealTimeActivityInfoFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = feedbackRealTimeActivityInfoFieldsModel.w_();
                int u_ = feedbackRealTimeActivityInfoFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("real_time_activity_info");
                    RealTimeActivityInfoParser.m16289a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FeedbackRealTimeActivityInfoFieldsModel.class, new Serializer());
            }
        }

        public FeedbackRealTimeActivityInfoFieldsModel() {
            super(1);
        }

        public final void m16220a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m16221a(String str, Object obj, boolean z) {
        }

        @Nullable
        private RealTimeActivityInfoModel m16217a() {
            this.f9501d = (RealTimeActivityInfoModel) super.a(this.f9501d, 0, RealTimeActivityInfoModel.class);
            return this.f9501d;
        }

        public final int jK_() {
            return -126857307;
        }

        public final GraphQLVisitableModel m16219a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16217a() != null) {
                RealTimeActivityInfoModel realTimeActivityInfoModel = (RealTimeActivityInfoModel) graphQLModelMutatingVisitor.b(m16217a());
                if (m16217a() != realTimeActivityInfoModel) {
                    graphQLVisitableModel = (FeedbackRealTimeActivityInfoFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9501d = realTimeActivityInfoModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16218a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16217a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1691851477)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: api.flickr.com */
    public final class SimpleFeedFeedbackModel extends BaseModel implements SimpleFeedFeedback, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private ViewerActsAsPageModel f9506A;
        @Nullable
        private ViewerActsAsPersonModel f9507B;
        private int f9508C;
        private boolean f9509d;
        private boolean f9510e;
        private boolean f9511f;
        private boolean f9512g;
        private boolean f9513h;
        private boolean f9514i;
        private boolean f9515j;
        private boolean f9516k;
        @Nullable
        private String f9517l;
        private boolean f9518m;
        private boolean f9519n;
        @Nullable
        private String f9520o;
        @Nullable
        private ImportantReactorsModel f9521p;
        private boolean f9522q;
        @Nullable
        private String f9523r;
        @Nullable
        private LikersModel f9524s;
        @Nullable
        private ReactorsModel f9525t;
        @Nullable
        private RealTimeActivityInfoModel f9526u;
        @Nullable
        private String f9527v;
        @Nullable
        private ResharesModel f9528w;
        @Nullable
        private List<SupportedReactionsModel> f9529x;
        @Nullable
        private TopLevelCommentsModel f9530y;
        @Nullable
        private TopReactionsModel f9531z;

        /* compiled from: api.flickr.com */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SimpleFeedFeedbackModel.class, new Deserializer());
            }

            public Object m16222a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(SimpleFeedFeedbackParser.m16297a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object simpleFeedFeedbackModel = new SimpleFeedFeedbackModel();
                ((BaseModel) simpleFeedFeedbackModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (simpleFeedFeedbackModel instanceof Postprocessable) {
                    return ((Postprocessable) simpleFeedFeedbackModel).a();
                }
                return simpleFeedFeedbackModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: api.flickr.com */
        public final class LikersModel extends BaseModel implements GraphQLVisitableModel {
            private int f9502d;

            /* compiled from: api.flickr.com */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(LikersModel.class, new Deserializer());
                }

                public Object m16223a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(LikersParser.m16291a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object likersModel = new LikersModel();
                    ((BaseModel) likersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (likersModel instanceof Postprocessable) {
                        return ((Postprocessable) likersModel).a();
                    }
                    return likersModel;
                }
            }

            /* compiled from: api.flickr.com */
            public class Serializer extends JsonSerializer<LikersModel> {
                public final void m16224a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    LikersModel likersModel = (LikersModel) obj;
                    if (likersModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(likersModel.m16226a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        likersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    LikersParser.m16292a(likersModel.w_(), likersModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(LikersModel.class, new Serializer());
                }
            }

            public LikersModel() {
                super(1);
            }

            public final int m16225a() {
                a(0, 0);
                return this.f9502d;
            }

            public final void m16228a(int i) {
                this.f9502d = i;
                if (this.b != null && this.b.d) {
                    this.b.b(this.c, 0, i);
                }
            }

            public final int jK_() {
                return 733369288;
            }

            public final GraphQLVisitableModel m16227a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m16226a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f9502d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m16229a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f9502d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: api.flickr.com */
        public final class ResharesModel extends BaseModel implements GraphQLVisitableModel {
            private int f9503d;

            /* compiled from: api.flickr.com */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ResharesModel.class, new Deserializer());
                }

                public Object m16230a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ResharesParser.m16293a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object resharesModel = new ResharesModel();
                    ((BaseModel) resharesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (resharesModel instanceof Postprocessable) {
                        return ((Postprocessable) resharesModel).a();
                    }
                    return resharesModel;
                }
            }

            /* compiled from: api.flickr.com */
            public class Serializer extends JsonSerializer<ResharesModel> {
                public final void m16231a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ResharesModel resharesModel = (ResharesModel) obj;
                    if (resharesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(resharesModel.m16233a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        resharesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ResharesParser.m16294a(resharesModel.w_(), resharesModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ResharesModel.class, new Serializer());
                }
            }

            public ResharesModel() {
                super(1);
            }

            public final int m16232a() {
                a(0, 0);
                return this.f9503d;
            }

            public final void m16235a(int i) {
                this.f9503d = i;
                if (this.b != null && this.b.d) {
                    this.b.b(this.c, 0, i);
                }
            }

            public final int jK_() {
                return -1260671207;
            }

            public final GraphQLVisitableModel m16234a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m16233a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f9503d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m16236a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f9503d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: api.flickr.com */
        public class Serializer extends JsonSerializer<SimpleFeedFeedbackModel> {
            public final void m16237a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                SimpleFeedFeedbackModel simpleFeedFeedbackModel = (SimpleFeedFeedbackModel) obj;
                if (simpleFeedFeedbackModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(simpleFeedFeedbackModel.m16263a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    simpleFeedFeedbackModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                SimpleFeedFeedbackParser.m16298a(simpleFeedFeedbackModel.w_(), simpleFeedFeedbackModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(SimpleFeedFeedbackModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -2056444745)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: api.flickr.com */
        public final class TopLevelCommentsModel extends BaseModel implements GraphQLVisitableModel {
            private int f9504d;
            private int f9505e;

            /* compiled from: api.flickr.com */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TopLevelCommentsModel.class, new Deserializer());
                }

                public Object m16238a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TopLevelCommentsParser.m16295a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object topLevelCommentsModel = new TopLevelCommentsModel();
                    ((BaseModel) topLevelCommentsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (topLevelCommentsModel instanceof Postprocessable) {
                        return ((Postprocessable) topLevelCommentsModel).a();
                    }
                    return topLevelCommentsModel;
                }
            }

            /* compiled from: api.flickr.com */
            public class Serializer extends JsonSerializer<TopLevelCommentsModel> {
                public final void m16239a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TopLevelCommentsModel topLevelCommentsModel = (TopLevelCommentsModel) obj;
                    if (topLevelCommentsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(topLevelCommentsModel.m16241a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        topLevelCommentsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TopLevelCommentsParser.m16296a(topLevelCommentsModel.w_(), topLevelCommentsModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(TopLevelCommentsModel.class, new Serializer());
                }
            }

            public TopLevelCommentsModel() {
                super(2);
            }

            public final int m16240a() {
                a(0, 0);
                return this.f9504d;
            }

            public final void m16243a(int i) {
                this.f9504d = i;
                if (this.b != null && this.b.d) {
                    this.b.b(this.c, 0, i);
                }
            }

            public final int m16245b() {
                a(0, 1);
                return this.f9505e;
            }

            public final void m16246b(int i) {
                this.f9505e = i;
                if (this.b != null && this.b.d) {
                    this.b.b(this.c, 1, i);
                }
            }

            public final int jK_() {
                return 899897761;
            }

            public final GraphQLVisitableModel m16242a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m16241a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f9504d, 0);
                flatBufferBuilder.a(1, this.f9505e, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m16244a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f9504d = mutableFlatBuffer.a(i, 0, 0);
                this.f9505e = mutableFlatBuffer.a(i, 1, 0);
            }
        }

        @Nullable
        public final /* synthetic */ C0963x86c33d71 m16279p() {
            return m16261y();
        }

        public SimpleFeedFeedbackModel() {
            super(26);
        }

        public final void m16267a(String str, ConsistencyTuple consistencyTuple) {
            if ("can_viewer_comment".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m16270c());
                consistencyTuple.b = u_();
                consistencyTuple.c = 1;
            } else if ("can_viewer_like".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(bU_());
                consistencyTuple.b = u_();
                consistencyTuple.c = 5;
            } else if ("does_viewer_like".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m16274k());
                consistencyTuple.b = u_();
                consistencyTuple.c = 10;
            } else if ("is_viewer_subscribed".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m16276m());
                consistencyTuple.b = u_();
                consistencyTuple.c = 13;
            } else {
                if ("likers.count".equals(str)) {
                    LikersModel r = m16254r();
                    if (r != null) {
                        consistencyTuple.a = Integer.valueOf(r.m16225a());
                        consistencyTuple.b = r.u_();
                        consistencyTuple.c = 0;
                        return;
                    }
                } else if ("reactors.count".equals(str)) {
                    ReactorsModel s = m16255s();
                    if (s != null) {
                        consistencyTuple.a = Integer.valueOf(s.m17067a());
                        consistencyTuple.b = s.u_();
                        consistencyTuple.c = 0;
                        return;
                    }
                } else if ("reshares.count".equals(str)) {
                    ResharesModel u = m16257u();
                    if (u != null) {
                        consistencyTuple.a = Integer.valueOf(u.m16232a());
                        consistencyTuple.b = u.u_();
                        consistencyTuple.c = 0;
                        return;
                    }
                } else if ("top_level_comments.count".equals(str)) {
                    r0 = m16259w();
                    if (r0 != null) {
                        consistencyTuple.a = Integer.valueOf(r0.m16240a());
                        consistencyTuple.b = r0.u_();
                        consistencyTuple.c = 0;
                        return;
                    }
                } else if ("top_level_comments.total_count".equals(str)) {
                    r0 = m16259w();
                    if (r0 != null) {
                        consistencyTuple.a = Integer.valueOf(r0.m16245b());
                        consistencyTuple.b = r0.u_();
                        consistencyTuple.c = 1;
                        return;
                    }
                } else if ("viewer_feedback_reaction_key".equals(str)) {
                    consistencyTuple.a = Integer.valueOf(m16247A());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 25;
                    return;
                }
                consistencyTuple.a();
            }
        }

        public final void m16268a(String str, Object obj, boolean z) {
            if ("can_viewer_comment".equals(str)) {
                m16249a(((Boolean) obj).booleanValue());
            } else if ("can_viewer_like".equals(str)) {
                m16250b(((Boolean) obj).booleanValue());
            } else if ("does_viewer_like".equals(str)) {
                m16251c(((Boolean) obj).booleanValue());
            } else if ("is_viewer_subscribed".equals(str)) {
                m16252d(((Boolean) obj).booleanValue());
            } else if ("likers.count".equals(str)) {
                LikersModel r = m16254r();
                if (r == null) {
                    return;
                }
                if (z) {
                    r = (LikersModel) r.clone();
                    r.m16228a(((Integer) obj).intValue());
                    this.f9524s = r;
                    return;
                }
                r.m16228a(((Integer) obj).intValue());
            } else if ("reactors.count".equals(str)) {
                ReactorsModel s = m16255s();
                if (s == null) {
                    return;
                }
                if (z) {
                    s = (ReactorsModel) s.clone();
                    s.m17070a(((Integer) obj).intValue());
                    this.f9525t = s;
                    return;
                }
                s.m17070a(((Integer) obj).intValue());
            } else if ("reshares.count".equals(str)) {
                ResharesModel u = m16257u();
                if (u == null) {
                    return;
                }
                if (z) {
                    u = (ResharesModel) u.clone();
                    u.m16235a(((Integer) obj).intValue());
                    this.f9528w = u;
                    return;
                }
                u.m16235a(((Integer) obj).intValue());
            } else if ("top_level_comments.count".equals(str)) {
                r0 = m16259w();
                if (r0 == null) {
                    return;
                }
                if (z) {
                    r0 = (TopLevelCommentsModel) r0.clone();
                    r0.m16243a(((Integer) obj).intValue());
                    this.f9530y = r0;
                    return;
                }
                r0.m16243a(((Integer) obj).intValue());
            } else if ("top_level_comments.total_count".equals(str)) {
                r0 = m16259w();
                if (r0 == null) {
                    return;
                }
                if (z) {
                    r0 = (TopLevelCommentsModel) r0.clone();
                    r0.m16246b(((Integer) obj).intValue());
                    this.f9530y = r0;
                    return;
                }
                r0.m16246b(((Integer) obj).intValue());
            } else if ("viewer_feedback_reaction_key".equals(str)) {
                m16248a(((Integer) obj).intValue());
            }
        }

        public final boolean m16269b() {
            a(0, 0);
            return this.f9509d;
        }

        public final boolean m16270c() {
            a(0, 1);
            return this.f9510e;
        }

        private void m16249a(boolean z) {
            this.f9510e = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 1, z);
            }
        }

        public final boolean m16271d() {
            a(0, 2);
            return this.f9511f;
        }

        public final boolean bT_() {
            a(0, 3);
            return this.f9512g;
        }

        public final boolean m16272g() {
            a(0, 4);
            return this.f9513h;
        }

        public final boolean bU_() {
            a(0, 5);
            return this.f9514i;
        }

        private void m16250b(boolean z) {
            this.f9514i = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 5, z);
            }
        }

        public final boolean bV_() {
            a(0, 7);
            return this.f9516k;
        }

        @Nullable
        public final String m16273j() {
            this.f9517l = super.a(this.f9517l, 8);
            return this.f9517l;
        }

        public final boolean m16274k() {
            a(1, 2);
            return this.f9519n;
        }

        private void m16251c(boolean z) {
            this.f9519n = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 10, z);
            }
        }

        @Nullable
        public final String m16275l() {
            this.f9520o = super.a(this.f9520o, 11);
            return this.f9520o;
        }

        @Nullable
        private ImportantReactorsModel m16253q() {
            this.f9521p = (ImportantReactorsModel) super.a(this.f9521p, 12, ImportantReactorsModel.class);
            return this.f9521p;
        }

        public final boolean m16276m() {
            a(1, 5);
            return this.f9522q;
        }

        private void m16252d(boolean z) {
            this.f9522q = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 13, z);
            }
        }

        @Nullable
        public final String m16277n() {
            this.f9523r = super.a(this.f9523r, 14);
            return this.f9523r;
        }

        @Nullable
        private LikersModel m16254r() {
            this.f9524s = (LikersModel) super.a(this.f9524s, 15, LikersModel.class);
            return this.f9524s;
        }

        @Nullable
        private ReactorsModel m16255s() {
            this.f9525t = (ReactorsModel) super.a(this.f9525t, 16, ReactorsModel.class);
            return this.f9525t;
        }

        @Nullable
        private RealTimeActivityInfoModel m16256t() {
            this.f9526u = (RealTimeActivityInfoModel) super.a(this.f9526u, 17, RealTimeActivityInfoModel.class);
            return this.f9526u;
        }

        @Nullable
        public final String m16278o() {
            this.f9527v = super.a(this.f9527v, 18);
            return this.f9527v;
        }

        @Nullable
        private ResharesModel m16257u() {
            this.f9528w = (ResharesModel) super.a(this.f9528w, 19, ResharesModel.class);
            return this.f9528w;
        }

        @Nonnull
        private ImmutableList<SupportedReactionsModel> m16258v() {
            this.f9529x = super.a(this.f9529x, 20, SupportedReactionsModel.class);
            return (ImmutableList) this.f9529x;
        }

        @Nullable
        private TopLevelCommentsModel m16259w() {
            this.f9530y = (TopLevelCommentsModel) super.a(this.f9530y, 21, TopLevelCommentsModel.class);
            return this.f9530y;
        }

        @Nullable
        private TopReactionsModel m16260x() {
            this.f9531z = (TopReactionsModel) super.a(this.f9531z, 22, TopReactionsModel.class);
            return this.f9531z;
        }

        @Nullable
        private ViewerActsAsPageModel m16261y() {
            this.f9506A = (ViewerActsAsPageModel) super.a(this.f9506A, 23, ViewerActsAsPageModel.class);
            return this.f9506A;
        }

        @Nullable
        private ViewerActsAsPersonModel m16262z() {
            this.f9507B = (ViewerActsAsPersonModel) super.a(this.f9507B, 24, ViewerActsAsPersonModel.class);
            return this.f9507B;
        }

        private int m16247A() {
            a(3, 1);
            return this.f9508C;
        }

        private void m16248a(int i) {
            this.f9508C = i;
            if (this.b != null && this.b.d) {
                this.b.b(this.c, 25, i);
            }
        }

        @Nullable
        public final String m16265a() {
            return m16277n();
        }

        public final int jK_() {
            return -126857307;
        }

        public final GraphQLVisitableModel m16264a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16253q() != null) {
                ImportantReactorsModel importantReactorsModel = (ImportantReactorsModel) graphQLModelMutatingVisitor.b(m16253q());
                if (m16253q() != importantReactorsModel) {
                    graphQLVisitableModel = (SimpleFeedFeedbackModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9521p = importantReactorsModel;
                }
            }
            if (m16254r() != null) {
                LikersModel likersModel = (LikersModel) graphQLModelMutatingVisitor.b(m16254r());
                if (m16254r() != likersModel) {
                    graphQLVisitableModel = (SimpleFeedFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9524s = likersModel;
                }
            }
            if (m16255s() != null) {
                ReactorsModel reactorsModel = (ReactorsModel) graphQLModelMutatingVisitor.b(m16255s());
                if (m16255s() != reactorsModel) {
                    graphQLVisitableModel = (SimpleFeedFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9525t = reactorsModel;
                }
            }
            if (m16256t() != null) {
                RealTimeActivityInfoModel realTimeActivityInfoModel = (RealTimeActivityInfoModel) graphQLModelMutatingVisitor.b(m16256t());
                if (m16256t() != realTimeActivityInfoModel) {
                    graphQLVisitableModel = (SimpleFeedFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9526u = realTimeActivityInfoModel;
                }
            }
            if (m16257u() != null) {
                ResharesModel resharesModel = (ResharesModel) graphQLModelMutatingVisitor.b(m16257u());
                if (m16257u() != resharesModel) {
                    graphQLVisitableModel = (SimpleFeedFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9528w = resharesModel;
                }
            }
            if (m16258v() != null) {
                Builder a = ModelHelper.a(m16258v(), graphQLModelMutatingVisitor);
                if (a != null) {
                    SimpleFeedFeedbackModel simpleFeedFeedbackModel = (SimpleFeedFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    simpleFeedFeedbackModel.f9529x = a.b();
                    graphQLVisitableModel = simpleFeedFeedbackModel;
                }
            }
            if (m16259w() != null) {
                TopLevelCommentsModel topLevelCommentsModel = (TopLevelCommentsModel) graphQLModelMutatingVisitor.b(m16259w());
                if (m16259w() != topLevelCommentsModel) {
                    graphQLVisitableModel = (SimpleFeedFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9530y = topLevelCommentsModel;
                }
            }
            if (m16260x() != null) {
                TopReactionsModel topReactionsModel = (TopReactionsModel) graphQLModelMutatingVisitor.b(m16260x());
                if (m16260x() != topReactionsModel) {
                    graphQLVisitableModel = (SimpleFeedFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9531z = topReactionsModel;
                }
            }
            if (m16261y() != null) {
                ViewerActsAsPageModel viewerActsAsPageModel = (ViewerActsAsPageModel) graphQLModelMutatingVisitor.b(m16261y());
                if (m16261y() != viewerActsAsPageModel) {
                    graphQLVisitableModel = (SimpleFeedFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9506A = viewerActsAsPageModel;
                }
            }
            if (m16262z() != null) {
                ViewerActsAsPersonModel viewerActsAsPersonModel = (ViewerActsAsPersonModel) graphQLModelMutatingVisitor.b(m16262z());
                if (m16262z() != viewerActsAsPersonModel) {
                    graphQLVisitableModel = (SimpleFeedFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9507B = viewerActsAsPersonModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16263a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m16273j());
            int b2 = flatBufferBuilder.b(m16275l());
            int a = ModelHelper.a(flatBufferBuilder, m16253q());
            int b3 = flatBufferBuilder.b(m16277n());
            int a2 = ModelHelper.a(flatBufferBuilder, m16254r());
            int a3 = ModelHelper.a(flatBufferBuilder, m16255s());
            int a4 = ModelHelper.a(flatBufferBuilder, m16256t());
            int b4 = flatBufferBuilder.b(m16278o());
            int a5 = ModelHelper.a(flatBufferBuilder, m16257u());
            int a6 = ModelHelper.a(flatBufferBuilder, m16258v());
            int a7 = ModelHelper.a(flatBufferBuilder, m16259w());
            int a8 = ModelHelper.a(flatBufferBuilder, m16260x());
            int a9 = ModelHelper.a(flatBufferBuilder, m16261y());
            int a10 = ModelHelper.a(flatBufferBuilder, m16262z());
            flatBufferBuilder.c(26);
            flatBufferBuilder.a(0, this.f9509d);
            flatBufferBuilder.a(1, this.f9510e);
            flatBufferBuilder.a(2, this.f9511f);
            flatBufferBuilder.a(3, this.f9512g);
            flatBufferBuilder.a(4, this.f9513h);
            flatBufferBuilder.a(5, this.f9514i);
            flatBufferBuilder.a(6, this.f9515j);
            flatBufferBuilder.a(7, this.f9516k);
            flatBufferBuilder.b(8, b);
            flatBufferBuilder.a(9, this.f9518m);
            flatBufferBuilder.a(10, this.f9519n);
            flatBufferBuilder.b(11, b2);
            flatBufferBuilder.b(12, a);
            flatBufferBuilder.a(13, this.f9522q);
            flatBufferBuilder.b(14, b3);
            flatBufferBuilder.b(15, a2);
            flatBufferBuilder.b(16, a3);
            flatBufferBuilder.b(17, a4);
            flatBufferBuilder.b(18, b4);
            flatBufferBuilder.b(19, a5);
            flatBufferBuilder.b(20, a6);
            flatBufferBuilder.b(21, a7);
            flatBufferBuilder.b(22, a8);
            flatBufferBuilder.b(23, a9);
            flatBufferBuilder.b(24, a10);
            flatBufferBuilder.a(25, this.f9508C, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m16266a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f9509d = mutableFlatBuffer.a(i, 0);
            this.f9510e = mutableFlatBuffer.a(i, 1);
            this.f9511f = mutableFlatBuffer.a(i, 2);
            this.f9512g = mutableFlatBuffer.a(i, 3);
            this.f9513h = mutableFlatBuffer.a(i, 4);
            this.f9514i = mutableFlatBuffer.a(i, 5);
            this.f9515j = mutableFlatBuffer.a(i, 6);
            this.f9516k = mutableFlatBuffer.a(i, 7);
            this.f9518m = mutableFlatBuffer.a(i, 9);
            this.f9519n = mutableFlatBuffer.a(i, 10);
            this.f9522q = mutableFlatBuffer.a(i, 13);
            this.f9508C = mutableFlatBuffer.a(i, 25, 0);
        }
    }
}
