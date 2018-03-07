package com.facebook.events.feed.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.events.feed.protocol.EventPinnedPostAndRecentStoryGraphQLParsers.EventPinnedPostAndRecentStoryFragmentParser;
import com.facebook.events.feed.protocol.EventPinnedPostAndRecentStoryGraphQLParsers.EventPinnedPostAndRecentStoryFragmentParser.BoostableStoryParser;
import com.facebook.events.feed.protocol.EventPinnedPostAndRecentStoryGraphQLParsers.EventPinnedPostAndRecentStoryFragmentParser.EventCreatorParser;
import com.facebook.events.feed.protocol.EventPinnedPostAndRecentStoryGraphQLParsers.EventPinnedPostAndRecentStoryFragmentParser.EventCreatorParser.AdminInfoParser;
import com.facebook.events.feed.protocol.EventPinnedPostAndRecentStoryGraphQLParsers.EventPinnedPostAndRecentStoryFragmentParser.EventPinnedStoriesParser;
import com.facebook.events.feed.protocol.EventPinnedPostAndRecentStoryGraphQLParsers.EventPinnedPostAndRecentStoryFragmentParser.EventPinnedStoriesParser.EdgesParser;
import com.facebook.events.feed.protocol.EventPinnedPostAndRecentStoryGraphQLParsers.EventPinnedPostAndRecentStoryFragmentParser.EventStoriesParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithBridge;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel;
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

/* compiled from: com.facebook.ads.interstitial.dismissed */
public class EventPinnedPostAndRecentStoryGraphQLModels {

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -962074474)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: com.facebook.ads.interstitial.dismissed */
    public final class EventPinnedPostAndRecentStoryFragmentModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private BoostableStoryModel f17389d;
        @Nullable
        private EventCreatorModel f17390e;
        @Nullable
        private EventPinnedStoriesModel f17391f;
        @Nullable
        private EventStoriesModel f17392g;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -570800568)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: com.facebook.ads.interstitial.dismissed */
        public final class BoostableStoryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f17374d;
            @Nullable
            private String f17375e;

            /* compiled from: com.facebook.ads.interstitial.dismissed */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(BoostableStoryModel.class, new Deserializer());
                }

                public Object m17681a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(BoostableStoryParser.m17741a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object boostableStoryModel = new BoostableStoryModel();
                    ((BaseModel) boostableStoryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (boostableStoryModel instanceof Postprocessable) {
                        return ((Postprocessable) boostableStoryModel).a();
                    }
                    return boostableStoryModel;
                }
            }

            /* compiled from: com.facebook.ads.interstitial.dismissed */
            public class Serializer extends JsonSerializer<BoostableStoryModel> {
                public final void m17682a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    BoostableStoryModel boostableStoryModel = (BoostableStoryModel) obj;
                    if (boostableStoryModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(boostableStoryModel.m17683a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        boostableStoryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    BoostableStoryParser.m17742a(boostableStoryModel.w_(), boostableStoryModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(BoostableStoryModel.class, new Serializer());
                }
            }

            public BoostableStoryModel() {
                super(2);
            }

            public final void m17686a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m17687a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final String m17688b() {
                this.f17374d = super.a(this.f17374d, 0);
                return this.f17374d;
            }

            @Nullable
            public final String m17689c() {
                this.f17375e = super.a(this.f17375e, 1);
                return this.f17375e;
            }

            @Nullable
            public final String m17685a() {
                return m17688b();
            }

            public final int jK_() {
                return 80218325;
            }

            public final GraphQLVisitableModel m17684a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17683a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m17688b());
                int b2 = flatBufferBuilder.b(m17689c());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: com.facebook.ads.interstitial.dismissed */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(EventPinnedPostAndRecentStoryFragmentModel.class, new Deserializer());
            }

            public Object m17690a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(EventPinnedPostAndRecentStoryFragmentParser.m17755a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object eventPinnedPostAndRecentStoryFragmentModel = new EventPinnedPostAndRecentStoryFragmentModel();
                ((BaseModel) eventPinnedPostAndRecentStoryFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (eventPinnedPostAndRecentStoryFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) eventPinnedPostAndRecentStoryFragmentModel).a();
                }
                return eventPinnedPostAndRecentStoryFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 4633995)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: com.facebook.ads.interstitial.dismissed */
        public final class EventCreatorModel extends BaseModel implements GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f17377d;
            @Nullable
            private AdminInfoModel f17378e;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1594547285)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: com.facebook.ads.interstitial.dismissed */
            public final class AdminInfoModel extends BaseModel implements GraphQLVisitableModel {
                private boolean f17376d;

                /* compiled from: com.facebook.ads.interstitial.dismissed */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(AdminInfoModel.class, new Deserializer());
                    }

                    public Object m17691a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(AdminInfoParser.m17743a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object adminInfoModel = new AdminInfoModel();
                        ((BaseModel) adminInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (adminInfoModel instanceof Postprocessable) {
                            return ((Postprocessable) adminInfoModel).a();
                        }
                        return adminInfoModel;
                    }
                }

                /* compiled from: com.facebook.ads.interstitial.dismissed */
                public class Serializer extends JsonSerializer<AdminInfoModel> {
                    public final void m17692a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        AdminInfoModel adminInfoModel = (AdminInfoModel) obj;
                        if (adminInfoModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(adminInfoModel.m17693a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            adminInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        AdminInfoParser.m17744a(adminInfoModel.w_(), adminInfoModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(AdminInfoModel.class, new Serializer());
                    }
                }

                public AdminInfoModel() {
                    super(1);
                }

                public final boolean m17696a() {
                    a(0, 0);
                    return this.f17376d;
                }

                public final int jK_() {
                    return 888797870;
                }

                public final GraphQLVisitableModel m17694a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m17693a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.a(0, this.f17376d);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m17695a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f17376d = mutableFlatBuffer.a(i, 0);
                }
            }

            /* compiled from: com.facebook.ads.interstitial.dismissed */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(EventCreatorModel.class, new Deserializer());
                }

                public Object m17697a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(EventCreatorParser.m17745a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object eventCreatorModel = new EventCreatorModel();
                    ((BaseModel) eventCreatorModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (eventCreatorModel instanceof Postprocessable) {
                        return ((Postprocessable) eventCreatorModel).a();
                    }
                    return eventCreatorModel;
                }
            }

            /* compiled from: com.facebook.ads.interstitial.dismissed */
            public class Serializer extends JsonSerializer<EventCreatorModel> {
                public final void m17698a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    EventCreatorModel eventCreatorModel = (EventCreatorModel) obj;
                    if (eventCreatorModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(eventCreatorModel.m17701a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        eventCreatorModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    EventCreatorParser.m17746a(eventCreatorModel.w_(), eventCreatorModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(EventCreatorModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ AdminInfoModel m17702a() {
                return m17700k();
            }

            public EventCreatorModel() {
                super(2);
            }

            public final void m17704a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m17705a(String str, Object obj, boolean z) {
            }

            @Nullable
            private GraphQLObjectType m17699j() {
                if (this.b != null && this.f17377d == null) {
                    this.f17377d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f17377d;
            }

            @Nullable
            private AdminInfoModel m17700k() {
                this.f17378e = (AdminInfoModel) super.a(this.f17378e, 1, AdminInfoModel.class);
                return this.f17378e;
            }

            public final int jK_() {
                return 63093205;
            }

            public final GraphQLVisitableModel m17703a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m17700k() != null) {
                    AdminInfoModel adminInfoModel = (AdminInfoModel) graphQLModelMutatingVisitor.b(m17700k());
                    if (m17700k() != adminInfoModel) {
                        graphQLVisitableModel = (EventCreatorModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f17378e = adminInfoModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m17701a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m17699j());
                int a2 = ModelHelper.a(flatBufferBuilder, m17700k());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 495874234)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: com.facebook.ads.interstitial.dismissed */
        public final class EventPinnedStoriesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EdgesModel> f17382d;
            @Nullable
            private DefaultPageInfoFieldsModel f17383e;

            /* compiled from: com.facebook.ads.interstitial.dismissed */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(EventPinnedStoriesModel.class, new Deserializer());
                }

                public Object m17706a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(EventPinnedStoriesParser.m17749a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object eventPinnedStoriesModel = new EventPinnedStoriesModel();
                    ((BaseModel) eventPinnedStoriesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (eventPinnedStoriesModel instanceof Postprocessable) {
                        return ((Postprocessable) eventPinnedStoriesModel).a();
                    }
                    return eventPinnedStoriesModel;
                }
            }

            @FragmentModelWithBridge
            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -512247599)
            @JsonSerialize(using = Serializer.class)
            /* compiled from: com.facebook.ads.interstitial.dismissed */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f17379d;
                @Nullable
                private GraphQLStory f17380e;
                @Nullable
                private String f17381f;

                /* compiled from: com.facebook.ads.interstitial.dismissed */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m17707a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(EdgesParser.m17747b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object edgesModel = new EdgesModel();
                        ((BaseModel) edgesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (edgesModel instanceof Postprocessable) {
                            return ((Postprocessable) edgesModel).a();
                        }
                        return edgesModel;
                    }
                }

                /* compiled from: com.facebook.ads.interstitial.dismissed */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m17708a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) obj;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m17709a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        EdgesParser.m17748b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                public EdgesModel() {
                    super(3);
                }

                @Nullable
                public final String m17711a() {
                    this.f17379d = super.a(this.f17379d, 0);
                    return this.f17379d;
                }

                @Nullable
                public final GraphQLStory m17712j() {
                    this.f17380e = (GraphQLStory) super.a(this.f17380e, 1, GraphQLStory.class);
                    return this.f17380e;
                }

                @Nullable
                public final String m17713k() {
                    this.f17381f = super.a(this.f17381f, 2);
                    return this.f17381f;
                }

                public final int jK_() {
                    return 1273421406;
                }

                public final GraphQLVisitableModel m17710a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m17712j() != null) {
                        GraphQLStory graphQLStory = (GraphQLStory) graphQLModelMutatingVisitor.b(m17712j());
                        if (m17712j() != graphQLStory) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f17380e = graphQLStory;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m17709a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m17711a());
                    int a = ModelHelper.a(flatBufferBuilder, m17712j());
                    int b2 = flatBufferBuilder.b(m17713k());
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, a);
                    flatBufferBuilder.b(2, b2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: com.facebook.ads.interstitial.dismissed */
            public class Serializer extends JsonSerializer<EventPinnedStoriesModel> {
                public final void m17714a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    EventPinnedStoriesModel eventPinnedStoriesModel = (EventPinnedStoriesModel) obj;
                    if (eventPinnedStoriesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(eventPinnedStoriesModel.m17716a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        eventPinnedStoriesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    EventPinnedStoriesParser.m17750a(eventPinnedStoriesModel.w_(), eventPinnedStoriesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(EventPinnedStoriesModel.class, new Serializer());
                }
            }

            public EventPinnedStoriesModel() {
                super(2);
            }

            @Nonnull
            public final ImmutableList<EdgesModel> m17718a() {
                this.f17382d = super.a(this.f17382d, 0, EdgesModel.class);
                return (ImmutableList) this.f17382d;
            }

            @Nullable
            private DefaultPageInfoFieldsModel m17715j() {
                this.f17383e = (DefaultPageInfoFieldsModel) super.a(this.f17383e, 1, DefaultPageInfoFieldsModel.class);
                return this.f17383e;
            }

            public final int jK_() {
                return 921907903;
            }

            public final GraphQLVisitableModel m17717a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                DefaultPageInfoFieldsModel defaultPageInfoFieldsModel;
                h();
                if (m17718a() != null) {
                    Builder a = ModelHelper.a(m17718a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        EventPinnedStoriesModel eventPinnedStoriesModel = (EventPinnedStoriesModel) ModelHelper.a(null, this);
                        eventPinnedStoriesModel.f17382d = a.b();
                        graphQLVisitableModel = eventPinnedStoriesModel;
                        if (m17715j() != null) {
                            defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m17715j());
                            if (m17715j() != defaultPageInfoFieldsModel) {
                                graphQLVisitableModel = (EventPinnedStoriesModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f17383e = defaultPageInfoFieldsModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m17715j() != null) {
                    defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m17715j());
                    if (m17715j() != defaultPageInfoFieldsModel) {
                        graphQLVisitableModel = (EventPinnedStoriesModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f17383e = defaultPageInfoFieldsModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m17716a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m17718a());
                int a2 = ModelHelper.a(flatBufferBuilder, m17715j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -991287568)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: com.facebook.ads.interstitial.dismissed */
        public final class EventStoriesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EdgesModel> f17387d;
            @Nullable
            private DefaultPageInfoFieldsModel f17388e;

            /* compiled from: com.facebook.ads.interstitial.dismissed */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(EventStoriesModel.class, new Deserializer());
                }

                public Object m17719a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(EventStoriesParser.m17753a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object eventStoriesModel = new EventStoriesModel();
                    ((BaseModel) eventStoriesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (eventStoriesModel instanceof Postprocessable) {
                        return ((Postprocessable) eventStoriesModel).a();
                    }
                    return eventStoriesModel;
                }
            }

            @FragmentModelWithBridge
            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -512247599)
            @JsonSerialize(using = Serializer.class)
            /* compiled from: com.facebook.ads.interstitial.dismissed */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f17384d;
                @Nullable
                private GraphQLStory f17385e;
                @Nullable
                private String f17386f;

                /* compiled from: com.facebook.ads.interstitial.dismissed */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m17720a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(EventStoriesParser.EdgesParser.m17751b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object edgesModel = new EdgesModel();
                        ((BaseModel) edgesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (edgesModel instanceof Postprocessable) {
                            return ((Postprocessable) edgesModel).a();
                        }
                        return edgesModel;
                    }
                }

                /* compiled from: com.facebook.ads.interstitial.dismissed */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m17721a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) obj;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m17722a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        EventStoriesParser.EdgesParser.m17752b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                public EdgesModel() {
                    super(3);
                }

                @Nullable
                public final String m17724a() {
                    this.f17384d = super.a(this.f17384d, 0);
                    return this.f17384d;
                }

                @Nullable
                public final GraphQLStory m17725j() {
                    this.f17385e = (GraphQLStory) super.a(this.f17385e, 1, GraphQLStory.class);
                    return this.f17385e;
                }

                @Nullable
                public final String m17726k() {
                    this.f17386f = super.a(this.f17386f, 2);
                    return this.f17386f;
                }

                public final int jK_() {
                    return 895260118;
                }

                public final GraphQLVisitableModel m17723a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m17725j() != null) {
                        GraphQLStory graphQLStory = (GraphQLStory) graphQLModelMutatingVisitor.b(m17725j());
                        if (m17725j() != graphQLStory) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f17385e = graphQLStory;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m17722a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m17724a());
                    int a = ModelHelper.a(flatBufferBuilder, m17725j());
                    int b2 = flatBufferBuilder.b(m17726k());
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, a);
                    flatBufferBuilder.b(2, b2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: com.facebook.ads.interstitial.dismissed */
            public class Serializer extends JsonSerializer<EventStoriesModel> {
                public final void m17727a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    EventStoriesModel eventStoriesModel = (EventStoriesModel) obj;
                    if (eventStoriesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(eventStoriesModel.m17729a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        eventStoriesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    EventStoriesParser.m17754a(eventStoriesModel.w_(), eventStoriesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(EventStoriesModel.class, new Serializer());
                }
            }

            public EventStoriesModel() {
                super(2);
            }

            @Nonnull
            public final ImmutableList<EdgesModel> m17731a() {
                this.f17387d = super.a(this.f17387d, 0, EdgesModel.class);
                return (ImmutableList) this.f17387d;
            }

            @Nullable
            private DefaultPageInfoFieldsModel m17728j() {
                this.f17388e = (DefaultPageInfoFieldsModel) super.a(this.f17388e, 1, DefaultPageInfoFieldsModel.class);
                return this.f17388e;
            }

            public final int jK_() {
                return -722505673;
            }

            public final GraphQLVisitableModel m17730a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                DefaultPageInfoFieldsModel defaultPageInfoFieldsModel;
                h();
                if (m17731a() != null) {
                    Builder a = ModelHelper.a(m17731a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        EventStoriesModel eventStoriesModel = (EventStoriesModel) ModelHelper.a(null, this);
                        eventStoriesModel.f17387d = a.b();
                        graphQLVisitableModel = eventStoriesModel;
                        if (m17728j() != null) {
                            defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m17728j());
                            if (m17728j() != defaultPageInfoFieldsModel) {
                                graphQLVisitableModel = (EventStoriesModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f17388e = defaultPageInfoFieldsModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m17728j() != null) {
                    defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m17728j());
                    if (m17728j() != defaultPageInfoFieldsModel) {
                        graphQLVisitableModel = (EventStoriesModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f17388e = defaultPageInfoFieldsModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m17729a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m17731a());
                int a2 = ModelHelper.a(flatBufferBuilder, m17728j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: com.facebook.ads.interstitial.dismissed */
        public class Serializer extends JsonSerializer<EventPinnedPostAndRecentStoryFragmentModel> {
            public final void m17732a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                EventPinnedPostAndRecentStoryFragmentModel eventPinnedPostAndRecentStoryFragmentModel = (EventPinnedPostAndRecentStoryFragmentModel) obj;
                if (eventPinnedPostAndRecentStoryFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(eventPinnedPostAndRecentStoryFragmentModel.m17733a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    eventPinnedPostAndRecentStoryFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                EventPinnedPostAndRecentStoryFragmentParser.m17756a(eventPinnedPostAndRecentStoryFragmentModel.w_(), eventPinnedPostAndRecentStoryFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(EventPinnedPostAndRecentStoryFragmentModel.class, new Serializer());
            }
        }

        public EventPinnedPostAndRecentStoryFragmentModel() {
            super(4);
        }

        public final void m17736a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m17737a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final BoostableStoryModel m17734a() {
            this.f17389d = (BoostableStoryModel) super.a(this.f17389d, 0, BoostableStoryModel.class);
            return this.f17389d;
        }

        @Nullable
        public final EventCreatorModel m17738j() {
            this.f17390e = (EventCreatorModel) super.a(this.f17390e, 1, EventCreatorModel.class);
            return this.f17390e;
        }

        @Nullable
        public final EventPinnedStoriesModel m17739k() {
            this.f17391f = (EventPinnedStoriesModel) super.a(this.f17391f, 2, EventPinnedStoriesModel.class);
            return this.f17391f;
        }

        @Nullable
        public final EventStoriesModel m17740l() {
            this.f17392g = (EventStoriesModel) super.a(this.f17392g, 3, EventStoriesModel.class);
            return this.f17392g;
        }

        public final int jK_() {
            return 67338874;
        }

        public final GraphQLVisitableModel m17735a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17734a() != null) {
                BoostableStoryModel boostableStoryModel = (BoostableStoryModel) graphQLModelMutatingVisitor.b(m17734a());
                if (m17734a() != boostableStoryModel) {
                    graphQLVisitableModel = (EventPinnedPostAndRecentStoryFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17389d = boostableStoryModel;
                }
            }
            if (m17738j() != null) {
                EventCreatorModel eventCreatorModel = (EventCreatorModel) graphQLModelMutatingVisitor.b(m17738j());
                if (m17738j() != eventCreatorModel) {
                    graphQLVisitableModel = (EventPinnedPostAndRecentStoryFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17390e = eventCreatorModel;
                }
            }
            if (m17739k() != null) {
                EventPinnedStoriesModel eventPinnedStoriesModel = (EventPinnedStoriesModel) graphQLModelMutatingVisitor.b(m17739k());
                if (m17739k() != eventPinnedStoriesModel) {
                    graphQLVisitableModel = (EventPinnedPostAndRecentStoryFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17391f = eventPinnedStoriesModel;
                }
            }
            if (m17740l() != null) {
                EventStoriesModel eventStoriesModel = (EventStoriesModel) graphQLModelMutatingVisitor.b(m17740l());
                if (m17740l() != eventStoriesModel) {
                    graphQLVisitableModel = (EventPinnedPostAndRecentStoryFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17392g = eventStoriesModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17733a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m17734a());
            int a2 = ModelHelper.a(flatBufferBuilder, m17738j());
            int a3 = ModelHelper.a(flatBufferBuilder, m17739k());
            int a4 = ModelHelper.a(flatBufferBuilder, m17740l());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, a4);
            i();
            return flatBufferBuilder.d();
        }
    }
}
