package com.facebook.api.graphql.fetchmedia;

import com.facebook.api.graphql.feed.NewsFeedDefaultsFeedbackGraphQLModels.NewsFeedDefaultsCompleteFeedbackModel;
import com.facebook.api.graphql.feed.NewsFeedDefaultsFeedbackGraphQLParsers.NewsFeedDefaultsCompleteFeedbackParser;
import com.facebook.api.graphql.feedback.FeedbackDefaultsGraphQLModels.SimpleFeedFeedbackModel;
import com.facebook.api.graphql.feedback.FeedbackDefaultsGraphQLParsers.SimpleFeedFeedbackParser;
import com.facebook.api.graphql.fetchmedia.FetchSingleMediaGraphQLParsers.StaticCompleteFeedbackMediaQueryParser;
import com.facebook.api.graphql.fetchmedia.FetchSingleMediaGraphQLParsers.StaticSimpleFeedbackMediaQueryParser;
import com.facebook.api.graphql.fetchmedia.FetchSingleMediaGraphQLParsers.StaticSimpleFeedbackMediaQueryWithAttributionParser;
import com.facebook.api.graphql.fetchmedia.FetchSingleMediaGraphQLParsers.StaticSimpleFeedbackMediaQueryWithAttributionParser.OwnerParser;
import com.facebook.api.graphql.fetchmedia.FetchSingleMediaGraphQLParsers.StaticSimpleFeedbackMediaQueryWithAttributionParser.PrivacyScopeParser;
import com.facebook.api.graphql.fetchmedia.FetchSingleMediaGraphQLParsers.StaticSimpleFeedbackMediaQueryWithAttributionParser.PrivacyScopeParser.IconImageParser;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithBridge;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.SerializerHelpers;
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
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: android_timeline_report_dialog */
public class FetchSingleMediaGraphQLModels {

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 2011349660)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: android_timeline_report_dialog */
    public final class StaticCompleteFeedbackMediaQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f9653d;
        @Nullable
        private NewsFeedDefaultsCompleteFeedbackModel f9654e;
        @Nullable
        private String f9655f;

        /* compiled from: android_timeline_report_dialog */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(StaticCompleteFeedbackMediaQueryModel.class, new Deserializer());
            }

            public Object m16549a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = StaticCompleteFeedbackMediaQueryParser.m16595a(jsonParser);
                Object staticCompleteFeedbackMediaQueryModel = new StaticCompleteFeedbackMediaQueryModel();
                ((BaseModel) staticCompleteFeedbackMediaQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (staticCompleteFeedbackMediaQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) staticCompleteFeedbackMediaQueryModel).a();
                }
                return staticCompleteFeedbackMediaQueryModel;
            }
        }

        /* compiled from: android_timeline_report_dialog */
        public class Serializer extends JsonSerializer<StaticCompleteFeedbackMediaQueryModel> {
            public final void m16550a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                StaticCompleteFeedbackMediaQueryModel staticCompleteFeedbackMediaQueryModel = (StaticCompleteFeedbackMediaQueryModel) obj;
                if (staticCompleteFeedbackMediaQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(staticCompleteFeedbackMediaQueryModel.m16554a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    staticCompleteFeedbackMediaQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = staticCompleteFeedbackMediaQueryModel.w_();
                int u_ = staticCompleteFeedbackMediaQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("feedback");
                    NewsFeedDefaultsCompleteFeedbackParser.m15890a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 2));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(StaticCompleteFeedbackMediaQueryModel.class, new Serializer());
            }
        }

        public StaticCompleteFeedbackMediaQueryModel() {
            super(3);
        }

        public final void m16557a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m16558a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m16551j() {
            if (this.b != null && this.f9653d == null) {
                this.f9653d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f9653d;
        }

        @Nullable
        private NewsFeedDefaultsCompleteFeedbackModel m16552k() {
            this.f9654e = (NewsFeedDefaultsCompleteFeedbackModel) super.a(this.f9654e, 1, NewsFeedDefaultsCompleteFeedbackModel.class);
            return this.f9654e;
        }

        @Nullable
        private String m16553l() {
            this.f9655f = super.a(this.f9655f, 2);
            return this.f9655f;
        }

        @Nullable
        public final String m16556a() {
            return m16553l();
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m16555a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16552k() != null) {
                NewsFeedDefaultsCompleteFeedbackModel newsFeedDefaultsCompleteFeedbackModel = (NewsFeedDefaultsCompleteFeedbackModel) graphQLModelMutatingVisitor.b(m16552k());
                if (m16552k() != newsFeedDefaultsCompleteFeedbackModel) {
                    graphQLVisitableModel = (StaticCompleteFeedbackMediaQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9654e = newsFeedDefaultsCompleteFeedbackModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16554a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16551j());
            int a2 = ModelHelper.a(flatBufferBuilder, m16552k());
            int b = flatBufferBuilder.b(m16553l());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1774577127)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: android_timeline_report_dialog */
    public final class StaticSimpleFeedbackMediaQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private GraphQLObjectType f9656d;
        @Nullable
        private SimpleFeedFeedbackModel f9657e;
        @Nullable
        private String f9658f;

        /* compiled from: android_timeline_report_dialog */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(StaticSimpleFeedbackMediaQueryModel.class, new Deserializer());
            }

            public Object m16559a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = StaticSimpleFeedbackMediaQueryParser.m16596a(jsonParser);
                Object staticSimpleFeedbackMediaQueryModel = new StaticSimpleFeedbackMediaQueryModel();
                ((BaseModel) staticSimpleFeedbackMediaQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (staticSimpleFeedbackMediaQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) staticSimpleFeedbackMediaQueryModel).a();
                }
                return staticSimpleFeedbackMediaQueryModel;
            }
        }

        /* compiled from: android_timeline_report_dialog */
        public class Serializer extends JsonSerializer<StaticSimpleFeedbackMediaQueryModel> {
            public final void m16560a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                StaticSimpleFeedbackMediaQueryModel staticSimpleFeedbackMediaQueryModel = (StaticSimpleFeedbackMediaQueryModel) obj;
                if (staticSimpleFeedbackMediaQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(staticSimpleFeedbackMediaQueryModel.m16564a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    staticSimpleFeedbackMediaQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = staticSimpleFeedbackMediaQueryModel.w_();
                int u_ = staticSimpleFeedbackMediaQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("feedback");
                    SimpleFeedFeedbackParser.m16298a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 2));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(StaticSimpleFeedbackMediaQueryModel.class, new Serializer());
            }
        }

        public StaticSimpleFeedbackMediaQueryModel() {
            super(3);
        }

        @Nullable
        private GraphQLObjectType m16561j() {
            if (this.b != null && this.f9656d == null) {
                this.f9656d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f9656d;
        }

        @Nullable
        private SimpleFeedFeedbackModel m16562k() {
            this.f9657e = (SimpleFeedFeedbackModel) super.a(this.f9657e, 1, SimpleFeedFeedbackModel.class);
            return this.f9657e;
        }

        @Nullable
        private String m16563l() {
            this.f9658f = super.a(this.f9658f, 2);
            return this.f9658f;
        }

        @Nullable
        public final String m16566a() {
            return m16563l();
        }

        public final int jK_() {
            return 74219460;
        }

        public final GraphQLVisitableModel m16565a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16562k() != null) {
                SimpleFeedFeedbackModel simpleFeedFeedbackModel = (SimpleFeedFeedbackModel) graphQLModelMutatingVisitor.b(m16562k());
                if (m16562k() != simpleFeedFeedbackModel) {
                    graphQLVisitableModel = (StaticSimpleFeedbackMediaQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9657e = simpleFeedFeedbackModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16564a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16561j());
            int a2 = ModelHelper.a(flatBufferBuilder, m16562k());
            int b = flatBufferBuilder.b(m16563l());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 2054180934)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: android_timeline_report_dialog */
    public final class StaticSimpleFeedbackMediaQueryWithAttributionModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private GraphQLObjectType f9663d;
        @Nullable
        private SimpleFeedFeedbackModel f9664e;
        @Nullable
        private String f9665f;
        @Nullable
        private OwnerModel f9666g;
        @Nullable
        private PrivacyScopeModel f9667h;

        /* compiled from: android_timeline_report_dialog */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(StaticSimpleFeedbackMediaQueryWithAttributionModel.class, new Deserializer());
            }

            public Object m16567a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = StaticSimpleFeedbackMediaQueryWithAttributionParser.m16603a(jsonParser);
                Object staticSimpleFeedbackMediaQueryWithAttributionModel = new StaticSimpleFeedbackMediaQueryWithAttributionModel();
                ((BaseModel) staticSimpleFeedbackMediaQueryWithAttributionModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (staticSimpleFeedbackMediaQueryWithAttributionModel instanceof Postprocessable) {
                    return ((Postprocessable) staticSimpleFeedbackMediaQueryWithAttributionModel).a();
                }
                return staticSimpleFeedbackMediaQueryWithAttributionModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -341630258)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_timeline_report_dialog */
        public final class OwnerModel extends BaseModel implements GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f9659d;
            @Nullable
            private String f9660e;

            /* compiled from: android_timeline_report_dialog */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(OwnerModel.class, new Deserializer());
                }

                public Object m16568a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(OwnerParser.m16597a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object ownerModel = new OwnerModel();
                    ((BaseModel) ownerModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (ownerModel instanceof Postprocessable) {
                        return ((Postprocessable) ownerModel).a();
                    }
                    return ownerModel;
                }
            }

            /* compiled from: android_timeline_report_dialog */
            public class Serializer extends JsonSerializer<OwnerModel> {
                public final void m16569a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    OwnerModel ownerModel = (OwnerModel) obj;
                    if (ownerModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ownerModel.m16572a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        ownerModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    OwnerParser.m16598a(ownerModel.w_(), ownerModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(OwnerModel.class, new Serializer());
                }
            }

            public OwnerModel() {
                super(2);
            }

            public final void m16574a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m16575a(String str, Object obj, boolean z) {
            }

            @Nullable
            private GraphQLObjectType m16570a() {
                if (this.b != null && this.f9659d == null) {
                    this.f9659d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f9659d;
            }

            @Nullable
            private String m16571j() {
                this.f9660e = super.a(this.f9660e, 1);
                return this.f9660e;
            }

            public final int jK_() {
                return 63093205;
            }

            public final GraphQLVisitableModel m16573a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m16572a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m16570a());
                int b = flatBufferBuilder.b(m16571j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -2026825410)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_timeline_report_dialog */
        public final class PrivacyScopeModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private IconImageModel f9662d;

            /* compiled from: android_timeline_report_dialog */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PrivacyScopeModel.class, new Deserializer());
                }

                public Object m16576a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PrivacyScopeParser.m16601a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object privacyScopeModel = new PrivacyScopeModel();
                    ((BaseModel) privacyScopeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (privacyScopeModel instanceof Postprocessable) {
                        return ((Postprocessable) privacyScopeModel).a();
                    }
                    return privacyScopeModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 842551240)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: android_timeline_report_dialog */
            public final class IconImageModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f9661d;

                /* compiled from: android_timeline_report_dialog */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(IconImageModel.class, new Deserializer());
                    }

                    public Object m16577a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(IconImageParser.m16599a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object iconImageModel = new IconImageModel();
                        ((BaseModel) iconImageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (iconImageModel instanceof Postprocessable) {
                            return ((Postprocessable) iconImageModel).a();
                        }
                        return iconImageModel;
                    }
                }

                /* compiled from: android_timeline_report_dialog */
                public class Serializer extends JsonSerializer<IconImageModel> {
                    public final void m16578a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        IconImageModel iconImageModel = (IconImageModel) obj;
                        if (iconImageModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(iconImageModel.m16580a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            iconImageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        IconImageParser.m16600a(iconImageModel.w_(), iconImageModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(IconImageModel.class, new Serializer());
                    }
                }

                public IconImageModel() {
                    super(1);
                }

                @Nullable
                private String m16579a() {
                    this.f9661d = super.a(this.f9661d, 0);
                    return this.f9661d;
                }

                public final int jK_() {
                    return 70760763;
                }

                public final GraphQLVisitableModel m16581a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m16580a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m16579a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: android_timeline_report_dialog */
            public class Serializer extends JsonSerializer<PrivacyScopeModel> {
                public final void m16582a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PrivacyScopeModel privacyScopeModel = (PrivacyScopeModel) obj;
                    if (privacyScopeModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(privacyScopeModel.m16584a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        privacyScopeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PrivacyScopeParser.m16602a(privacyScopeModel.w_(), privacyScopeModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PrivacyScopeModel.class, new Serializer());
                }
            }

            public PrivacyScopeModel() {
                super(1);
            }

            @Nullable
            private IconImageModel m16583a() {
                this.f9662d = (IconImageModel) super.a(this.f9662d, 0, IconImageModel.class);
                return this.f9662d;
            }

            public final int jK_() {
                return -476351540;
            }

            public final GraphQLVisitableModel m16585a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m16583a() != null) {
                    IconImageModel iconImageModel = (IconImageModel) graphQLModelMutatingVisitor.b(m16583a());
                    if (m16583a() != iconImageModel) {
                        graphQLVisitableModel = (PrivacyScopeModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f9662d = iconImageModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m16584a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m16583a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: android_timeline_report_dialog */
        public class Serializer extends JsonSerializer<StaticSimpleFeedbackMediaQueryWithAttributionModel> {
            public final void m16586a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                StaticSimpleFeedbackMediaQueryWithAttributionModel staticSimpleFeedbackMediaQueryWithAttributionModel = (StaticSimpleFeedbackMediaQueryWithAttributionModel) obj;
                if (staticSimpleFeedbackMediaQueryWithAttributionModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(staticSimpleFeedbackMediaQueryWithAttributionModel.m16592a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    staticSimpleFeedbackMediaQueryWithAttributionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = staticSimpleFeedbackMediaQueryWithAttributionModel.w_();
                int u_ = staticSimpleFeedbackMediaQueryWithAttributionModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("feedback");
                    SimpleFeedFeedbackParser.m16298a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 2));
                }
                g = mutableFlatBuffer.g(u_, 3);
                if (g != 0) {
                    jsonGenerator.a("owner");
                    OwnerParser.m16598a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 4);
                if (g != 0) {
                    jsonGenerator.a("privacy_scope");
                    PrivacyScopeParser.m16602a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(StaticSimpleFeedbackMediaQueryWithAttributionModel.class, new Serializer());
            }
        }

        public StaticSimpleFeedbackMediaQueryWithAttributionModel() {
            super(5);
        }

        @Nullable
        private GraphQLObjectType m16587j() {
            if (this.b != null && this.f9663d == null) {
                this.f9663d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f9663d;
        }

        @Nullable
        private SimpleFeedFeedbackModel m16588k() {
            this.f9664e = (SimpleFeedFeedbackModel) super.a(this.f9664e, 1, SimpleFeedFeedbackModel.class);
            return this.f9664e;
        }

        @Nullable
        private String m16589l() {
            this.f9665f = super.a(this.f9665f, 2);
            return this.f9665f;
        }

        @Nullable
        private OwnerModel m16590m() {
            this.f9666g = (OwnerModel) super.a(this.f9666g, 3, OwnerModel.class);
            return this.f9666g;
        }

        @Nullable
        private PrivacyScopeModel m16591n() {
            this.f9667h = (PrivacyScopeModel) super.a(this.f9667h, 4, PrivacyScopeModel.class);
            return this.f9667h;
        }

        @Nullable
        public final String m16594a() {
            return m16589l();
        }

        public final int jK_() {
            return 74219460;
        }

        public final GraphQLVisitableModel m16593a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16588k() != null) {
                SimpleFeedFeedbackModel simpleFeedFeedbackModel = (SimpleFeedFeedbackModel) graphQLModelMutatingVisitor.b(m16588k());
                if (m16588k() != simpleFeedFeedbackModel) {
                    graphQLVisitableModel = (StaticSimpleFeedbackMediaQueryWithAttributionModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9664e = simpleFeedFeedbackModel;
                }
            }
            if (m16590m() != null) {
                OwnerModel ownerModel = (OwnerModel) graphQLModelMutatingVisitor.b(m16590m());
                if (m16590m() != ownerModel) {
                    graphQLVisitableModel = (StaticSimpleFeedbackMediaQueryWithAttributionModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9666g = ownerModel;
                }
            }
            if (m16591n() != null) {
                PrivacyScopeModel privacyScopeModel = (PrivacyScopeModel) graphQLModelMutatingVisitor.b(m16591n());
                if (m16591n() != privacyScopeModel) {
                    graphQLVisitableModel = (StaticSimpleFeedbackMediaQueryWithAttributionModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9667h = privacyScopeModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16592a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16587j());
            int a2 = ModelHelper.a(flatBufferBuilder, m16588k());
            int b = flatBufferBuilder.b(m16589l());
            int a3 = ModelHelper.a(flatBufferBuilder, m16590m());
            int a4 = ModelHelper.a(flatBufferBuilder, m16591n());
            flatBufferBuilder.c(5);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.b(4, a4);
            i();
            return flatBufferBuilder.d();
        }
    }
}
