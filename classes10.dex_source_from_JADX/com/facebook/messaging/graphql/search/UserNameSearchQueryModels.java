package com.facebook.messaging.graphql.search;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.messaging.graphql.search.UserNameSearchQueryParsers.UserNameSearchQueryParser;
import com.facebook.messaging.graphql.search.UserNameSearchQueryParsers.UserNameSearchQueryParser.SearchResultsParser;
import com.facebook.messaging.graphql.search.UserNameSearchQueryParsers.UserNameSearchQueryParser.SearchResultsParser.NodesParser;
import com.facebook.messaging.graphql.search.UserNameSearchQueryParsers.UserNameSearchQueryParser.SearchResultsParser.NodesParser.MutualFriendsParser;
import com.facebook.messaging.graphql.search.UserNameSearchQueryParsers.UserNameSearchQueryParser.SearchResultsParser.NodesParser.ProfileImageSmallParser;
import com.facebook.messaging.graphql.search.UserNameSearchQueryParsers.UserNameSearchQueryParser.SearchResultsParser.NodesParser.TimelineContextItemsParser;
import com.facebook.messaging.graphql.search.UserNameSearchQueryParsers.UserNameSearchQueryParser.SearchResultsParser.NodesParser.TimelineContextItemsParser.TimelineContextItemsNodesParser;
import com.facebook.messaging.graphql.search.UserNameSearchQueryParsers.UserNameSearchQueryParser.SearchResultsParser.NodesParser.TimelineContextItemsParser.TimelineContextItemsNodesParser.TitleParser;
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

/* compiled from: since_boot_clock_age_ms */
public class UserNameSearchQueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -95564304)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: since_boot_clock_age_ms */
    public final class UserNameSearchQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private SearchResultsModel f2417d;

        /* compiled from: since_boot_clock_age_ms */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(UserNameSearchQueryModel.class, new Deserializer());
            }

            public Object m2263a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = UserNameSearchQueryParser.m2330a(jsonParser);
                Object userNameSearchQueryModel = new UserNameSearchQueryModel();
                ((BaseModel) userNameSearchQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (userNameSearchQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) userNameSearchQueryModel).a();
                }
                return userNameSearchQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -826846719)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: since_boot_clock_age_ms */
        public final class SearchResultsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f2416d;

            /* compiled from: since_boot_clock_age_ms */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SearchResultsModel.class, new Deserializer());
                }

                public Object m2264a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SearchResultsParser.m2328a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object searchResultsModel = new SearchResultsModel();
                    ((BaseModel) searchResultsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (searchResultsModel instanceof Postprocessable) {
                        return ((Postprocessable) searchResultsModel).a();
                    }
                    return searchResultsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 299961545)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: since_boot_clock_age_ms */
            public final class NodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                @Nullable
                private GraphQLObjectType f2405d;
                private double f2406e;
                @Nullable
                private GraphQLFriendshipStatus f2407f;
                @Nullable
                private String f2408g;
                private boolean f2409h;
                private boolean f2410i;
                @Nullable
                private MutualFriendsModel f2411j;
                @Nullable
                private String f2412k;
                @Nullable
                private ProfileImageSmallModel f2413l;
                @Nullable
                private TimelineContextItemsModel f2414m;
                @Nullable
                private String f2415n;

                /* compiled from: since_boot_clock_age_ms */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m2265a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NodesParser.m2326b(jsonParser, flatBufferBuilder));
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
                @ModelWithFlatBufferFormatHash(a = -1723990064)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: since_boot_clock_age_ms */
                public final class MutualFriendsModel extends BaseModel implements GraphQLVisitableModel {
                    private int f2400d;

                    /* compiled from: since_boot_clock_age_ms */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(MutualFriendsModel.class, new Deserializer());
                        }

                        public Object m2266a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(MutualFriendsParser.m2316a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object mutualFriendsModel = new MutualFriendsModel();
                            ((BaseModel) mutualFriendsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (mutualFriendsModel instanceof Postprocessable) {
                                return ((Postprocessable) mutualFriendsModel).a();
                            }
                            return mutualFriendsModel;
                        }
                    }

                    /* compiled from: since_boot_clock_age_ms */
                    public class Serializer extends JsonSerializer<MutualFriendsModel> {
                        public final void m2267a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            MutualFriendsModel mutualFriendsModel = (MutualFriendsModel) obj;
                            if (mutualFriendsModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(mutualFriendsModel.m2269a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                mutualFriendsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            MutualFriendsParser.m2317a(mutualFriendsModel.w_(), mutualFriendsModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(MutualFriendsModel.class, new Serializer());
                        }
                    }

                    public MutualFriendsModel() {
                        super(1);
                    }

                    public final int m2268a() {
                        a(0, 0);
                        return this.f2400d;
                    }

                    public final int jK_() {
                        return 1532278911;
                    }

                    public final GraphQLVisitableModel m2270a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m2269a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.a(0, this.f2400d, 0);
                        i();
                        return flatBufferBuilder.d();
                    }

                    public final void m2271a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                        super.a(mutableFlatBuffer, i, obj);
                        this.f2400d = mutableFlatBuffer.a(i, 0, 0);
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 842551240)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: since_boot_clock_age_ms */
                public final class ProfileImageSmallModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f2401d;

                    /* compiled from: since_boot_clock_age_ms */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(ProfileImageSmallModel.class, new Deserializer());
                        }

                        public Object m2272a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(ProfileImageSmallParser.m2318a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object profileImageSmallModel = new ProfileImageSmallModel();
                            ((BaseModel) profileImageSmallModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (profileImageSmallModel instanceof Postprocessable) {
                                return ((Postprocessable) profileImageSmallModel).a();
                            }
                            return profileImageSmallModel;
                        }
                    }

                    /* compiled from: since_boot_clock_age_ms */
                    public class Serializer extends JsonSerializer<ProfileImageSmallModel> {
                        public final void m2273a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            ProfileImageSmallModel profileImageSmallModel = (ProfileImageSmallModel) obj;
                            if (profileImageSmallModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(profileImageSmallModel.m2274a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                profileImageSmallModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            ProfileImageSmallParser.m2319a(profileImageSmallModel.w_(), profileImageSmallModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(ProfileImageSmallModel.class, new Serializer());
                        }
                    }

                    public ProfileImageSmallModel() {
                        super(1);
                    }

                    @Nullable
                    public final String m2276a() {
                        this.f2401d = super.a(this.f2401d, 0);
                        return this.f2401d;
                    }

                    public final int jK_() {
                        return 70760763;
                    }

                    public final GraphQLVisitableModel m2275a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m2274a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m2276a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: since_boot_clock_age_ms */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m2277a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m2294a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NodesParser.m2327b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -894676741)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: since_boot_clock_age_ms */
                public final class TimelineContextItemsModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private List<TimelineContextItemsNodesModel> f2404d;

                    /* compiled from: since_boot_clock_age_ms */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(TimelineContextItemsModel.class, new Deserializer());
                        }

                        public Object m2278a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(TimelineContextItemsParser.m2324a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object timelineContextItemsModel = new TimelineContextItemsModel();
                            ((BaseModel) timelineContextItemsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (timelineContextItemsModel instanceof Postprocessable) {
                                return ((Postprocessable) timelineContextItemsModel).a();
                            }
                            return timelineContextItemsModel;
                        }
                    }

                    /* compiled from: since_boot_clock_age_ms */
                    public class Serializer extends JsonSerializer<TimelineContextItemsModel> {
                        public final void m2279a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            TimelineContextItemsModel timelineContextItemsModel = (TimelineContextItemsModel) obj;
                            if (timelineContextItemsModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(timelineContextItemsModel.m2290a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                timelineContextItemsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            TimelineContextItemsParser.m2325a(timelineContextItemsModel.w_(), timelineContextItemsModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(TimelineContextItemsModel.class, new Serializer());
                        }
                    }

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = -270360651)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: since_boot_clock_age_ms */
                    public final class TimelineContextItemsNodesModel extends BaseModel implements GraphQLVisitableModel {
                        @Nullable
                        private TitleModel f2403d;

                        /* compiled from: since_boot_clock_age_ms */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(TimelineContextItemsNodesModel.class, new Deserializer());
                            }

                            public Object m2280a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(TimelineContextItemsNodesParser.m2322b(jsonParser, flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                Object timelineContextItemsNodesModel = new TimelineContextItemsNodesModel();
                                ((BaseModel) timelineContextItemsNodesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                if (timelineContextItemsNodesModel instanceof Postprocessable) {
                                    return ((Postprocessable) timelineContextItemsNodesModel).a();
                                }
                                return timelineContextItemsNodesModel;
                            }
                        }

                        /* compiled from: since_boot_clock_age_ms */
                        public class Serializer extends JsonSerializer<TimelineContextItemsNodesModel> {
                            public final void m2281a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                TimelineContextItemsNodesModel timelineContextItemsNodesModel = (TimelineContextItemsNodesModel) obj;
                                if (timelineContextItemsNodesModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(timelineContextItemsNodesModel.m2287a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    timelineContextItemsNodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                TimelineContextItemsNodesParser.m2323b(timelineContextItemsNodesModel.w_(), timelineContextItemsNodesModel.u_(), jsonGenerator, serializerProvider);
                            }

                            static {
                                FbSerializerProvider.a(TimelineContextItemsNodesModel.class, new Serializer());
                            }
                        }

                        @JsonDeserialize(using = Deserializer.class)
                        @ModelWithFlatBufferFormatHash(a = -1352864475)
                        @JsonSerialize(using = Serializer.class)
                        @FragmentModelWithoutBridge
                        /* compiled from: since_boot_clock_age_ms */
                        public final class TitleModel extends BaseModel implements GraphQLVisitableModel {
                            @Nullable
                            private String f2402d;

                            /* compiled from: since_boot_clock_age_ms */
                            public class Deserializer extends FbJsonDeserializer {
                                static {
                                    GlobalAutoGenDeserializerCache.a(TitleModel.class, new Deserializer());
                                }

                                public Object m2282a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(TitleParser.m2320a(jsonParser, flatBufferBuilder));
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

                            /* compiled from: since_boot_clock_age_ms */
                            public class Serializer extends JsonSerializer<TitleModel> {
                                public final void m2283a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                    TitleModel titleModel = (TitleModel) obj;
                                    if (titleModel.w_() == null) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(titleModel.m2284a(flatBufferBuilder));
                                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                        wrap.position(0);
                                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                        titleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                    }
                                    TitleParser.m2321a(titleModel.w_(), titleModel.u_(), jsonGenerator);
                                }

                                static {
                                    FbSerializerProvider.a(TitleModel.class, new Serializer());
                                }
                            }

                            public TitleModel() {
                                super(1);
                            }

                            @Nullable
                            public final String m2286a() {
                                this.f2402d = super.a(this.f2402d, 0);
                                return this.f2402d;
                            }

                            public final int jK_() {
                                return -1919764332;
                            }

                            public final GraphQLVisitableModel m2285a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                h();
                                i();
                                return this;
                            }

                            public final int m2284a(FlatBufferBuilder flatBufferBuilder) {
                                h();
                                int b = flatBufferBuilder.b(m2286a());
                                flatBufferBuilder.c(1);
                                flatBufferBuilder.b(0, b);
                                i();
                                return flatBufferBuilder.d();
                            }
                        }

                        public TimelineContextItemsNodesModel() {
                            super(1);
                        }

                        @Nullable
                        public final TitleModel m2289a() {
                            this.f2403d = (TitleModel) super.a(this.f2403d, 0, TitleModel.class);
                            return this.f2403d;
                        }

                        public final int jK_() {
                            return -2140001025;
                        }

                        public final GraphQLVisitableModel m2288a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            GraphQLVisitableModel graphQLVisitableModel = null;
                            h();
                            if (m2289a() != null) {
                                TitleModel titleModel = (TitleModel) graphQLModelMutatingVisitor.b(m2289a());
                                if (m2289a() != titleModel) {
                                    graphQLVisitableModel = (TimelineContextItemsNodesModel) ModelHelper.a(null, this);
                                    graphQLVisitableModel.f2403d = titleModel;
                                }
                            }
                            i();
                            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                        }

                        public final int m2287a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int a = ModelHelper.a(flatBufferBuilder, m2289a());
                            flatBufferBuilder.c(1);
                            flatBufferBuilder.b(0, a);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    public TimelineContextItemsModel() {
                        super(1);
                    }

                    @Nonnull
                    public final ImmutableList<TimelineContextItemsNodesModel> m2292a() {
                        this.f2404d = super.a(this.f2404d, 0, TimelineContextItemsNodesModel.class);
                        return (ImmutableList) this.f2404d;
                    }

                    public final int jK_() {
                        return -2113882798;
                    }

                    public final GraphQLVisitableModel m2291a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m2292a() != null) {
                            Builder a = ModelHelper.a(m2292a(), graphQLModelMutatingVisitor);
                            if (a != null) {
                                graphQLVisitableModel = (TimelineContextItemsModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f2404d = a.b();
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m2290a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m2292a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                public NodesModel() {
                    super(11);
                }

                @Nullable
                private GraphQLObjectType m2293t() {
                    if (this.b != null && this.f2405d == null) {
                        this.f2405d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f2405d;
                }

                public final double m2298j() {
                    a(0, 1);
                    return this.f2406e;
                }

                @Nullable
                public final GraphQLFriendshipStatus m2299k() {
                    this.f2407f = (GraphQLFriendshipStatus) super.b(this.f2407f, 2, GraphQLFriendshipStatus.class, GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                    return this.f2407f;
                }

                @Nullable
                public final String m2300l() {
                    this.f2408g = super.a(this.f2408g, 3);
                    return this.f2408g;
                }

                public final boolean m2301m() {
                    a(0, 4);
                    return this.f2409h;
                }

                public final boolean m2302n() {
                    a(0, 5);
                    return this.f2410i;
                }

                @Nullable
                public final MutualFriendsModel m2303o() {
                    this.f2411j = (MutualFriendsModel) super.a(this.f2411j, 6, MutualFriendsModel.class);
                    return this.f2411j;
                }

                @Nullable
                public final String m2304p() {
                    this.f2412k = super.a(this.f2412k, 7);
                    return this.f2412k;
                }

                @Nullable
                public final ProfileImageSmallModel m2305q() {
                    this.f2413l = (ProfileImageSmallModel) super.a(this.f2413l, 8, ProfileImageSmallModel.class);
                    return this.f2413l;
                }

                @Nullable
                public final TimelineContextItemsModel m2306r() {
                    this.f2414m = (TimelineContextItemsModel) super.a(this.f2414m, 9, TimelineContextItemsModel.class);
                    return this.f2414m;
                }

                @Nullable
                public final String m2307s() {
                    this.f2415n = super.a(this.f2415n, 10);
                    return this.f2415n;
                }

                @Nullable
                public final String m2296a() {
                    return m2300l();
                }

                public final int jK_() {
                    return 1283375906;
                }

                public final GraphQLVisitableModel m2295a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m2303o() != null) {
                        MutualFriendsModel mutualFriendsModel = (MutualFriendsModel) graphQLModelMutatingVisitor.b(m2303o());
                        if (m2303o() != mutualFriendsModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f2411j = mutualFriendsModel;
                        }
                    }
                    if (m2305q() != null) {
                        ProfileImageSmallModel profileImageSmallModel = (ProfileImageSmallModel) graphQLModelMutatingVisitor.b(m2305q());
                        if (m2305q() != profileImageSmallModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f2413l = profileImageSmallModel;
                        }
                    }
                    if (m2306r() != null) {
                        TimelineContextItemsModel timelineContextItemsModel = (TimelineContextItemsModel) graphQLModelMutatingVisitor.b(m2306r());
                        if (m2306r() != timelineContextItemsModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f2414m = timelineContextItemsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m2294a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m2293t());
                    int a2 = flatBufferBuilder.a(m2299k());
                    int b = flatBufferBuilder.b(m2300l());
                    int a3 = ModelHelper.a(flatBufferBuilder, m2303o());
                    int b2 = flatBufferBuilder.b(m2304p());
                    int a4 = ModelHelper.a(flatBufferBuilder, m2305q());
                    int a5 = ModelHelper.a(flatBufferBuilder, m2306r());
                    int b3 = flatBufferBuilder.b(m2307s());
                    flatBufferBuilder.c(11);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.a(1, this.f2406e, 0.0d);
                    flatBufferBuilder.b(2, a2);
                    flatBufferBuilder.b(3, b);
                    flatBufferBuilder.a(4, this.f2409h);
                    flatBufferBuilder.a(5, this.f2410i);
                    flatBufferBuilder.b(6, a3);
                    flatBufferBuilder.b(7, b2);
                    flatBufferBuilder.b(8, a4);
                    flatBufferBuilder.b(9, a5);
                    flatBufferBuilder.b(10, b3);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m2297a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f2406e = mutableFlatBuffer.a(i, 1, 0.0d);
                    this.f2409h = mutableFlatBuffer.a(i, 4);
                    this.f2410i = mutableFlatBuffer.a(i, 5);
                }
            }

            /* compiled from: since_boot_clock_age_ms */
            public class Serializer extends JsonSerializer<SearchResultsModel> {
                public final void m2308a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SearchResultsModel searchResultsModel = (SearchResultsModel) obj;
                    if (searchResultsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(searchResultsModel.m2309a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        searchResultsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SearchResultsParser.m2329a(searchResultsModel.w_(), searchResultsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(SearchResultsModel.class, new Serializer());
                }
            }

            public SearchResultsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<NodesModel> m2311a() {
                this.f2416d = super.a(this.f2416d, 0, NodesModel.class);
                return (ImmutableList) this.f2416d;
            }

            public final int jK_() {
                return 1843101810;
            }

            public final GraphQLVisitableModel m2310a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m2311a() != null) {
                    Builder a = ModelHelper.a(m2311a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (SearchResultsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f2416d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m2309a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m2311a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: since_boot_clock_age_ms */
        public class Serializer extends JsonSerializer<UserNameSearchQueryModel> {
            public final void m2312a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                UserNameSearchQueryModel userNameSearchQueryModel = (UserNameSearchQueryModel) obj;
                if (userNameSearchQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(userNameSearchQueryModel.m2313a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    userNameSearchQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = userNameSearchQueryModel.w_();
                int u_ = userNameSearchQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("search_results");
                    SearchResultsParser.m2329a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(UserNameSearchQueryModel.class, new Serializer());
            }
        }

        public UserNameSearchQueryModel() {
            super(1);
        }

        @Nullable
        public final SearchResultsModel m2315a() {
            this.f2417d = (SearchResultsModel) super.a(this.f2417d, 0, SearchResultsModel.class);
            return this.f2417d;
        }

        public final int jK_() {
            return 332244357;
        }

        public final GraphQLVisitableModel m2314a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2315a() != null) {
                SearchResultsModel searchResultsModel = (SearchResultsModel) graphQLModelMutatingVisitor.b(m2315a());
                if (m2315a() != searchResultsModel) {
                    graphQLVisitableModel = (UserNameSearchQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f2417d = searchResultsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2313a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m2315a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
