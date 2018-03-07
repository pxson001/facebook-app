package com.facebook.messaging.contextbanner.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLTimelineContextListItemType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.messaging.contextbanner.graphql.ProfileContextQueryParsers.ContextItemsListParser;
import com.facebook.messaging.contextbanner.graphql.ProfileContextQueryParsers.ContextItemsListParser.NodesParser;
import com.facebook.messaging.contextbanner.graphql.ProfileContextQueryParsers.ContextItemsListParser.NodesParser.TitleParser;
import com.facebook.messaging.contextbanner.graphql.ProfileContextQueryParsers.ProfileContextItemsParser;
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

/* compiled from: sub_action */
public class ProfileContextQueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -333855506)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: sub_action */
    public final class ContextItemsListModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<NodesModel> f2212d;

        /* compiled from: sub_action */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ContextItemsListModel.class, new Deserializer());
            }

            public Object m2054a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ContextItemsListParser.m2082a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object contextItemsListModel = new ContextItemsListModel();
                ((BaseModel) contextItemsListModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (contextItemsListModel instanceof Postprocessable) {
                    return ((Postprocessable) contextItemsListModel).a();
                }
                return contextItemsListModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 773984638)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: sub_action */
        public final class NodesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private GraphQLTimelineContextListItemType f2210d;
            @Nullable
            private TitleModel f2211e;

            /* compiled from: sub_action */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                }

                public Object m2055a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(NodesParser.m2080b(jsonParser, flatBufferBuilder));
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

            /* compiled from: sub_action */
            public class Serializer extends JsonSerializer<NodesModel> {
                public final void m2056a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    NodesModel nodesModel = (NodesModel) obj;
                    if (nodesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(nodesModel.m2062a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    NodesParser.m2081b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(NodesModel.class, new Serializer());
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1352864475)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: sub_action */
            public final class TitleModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f2209d;

                /* compiled from: sub_action */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(TitleModel.class, new Deserializer());
                    }

                    public Object m2057a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(TitleParser.m2078a(jsonParser, flatBufferBuilder));
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

                /* compiled from: sub_action */
                public class Serializer extends JsonSerializer<TitleModel> {
                    public final void m2058a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        TitleModel titleModel = (TitleModel) obj;
                        if (titleModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(titleModel.m2059a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            titleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        TitleParser.m2079a(titleModel.w_(), titleModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(TitleModel.class, new Serializer());
                    }
                }

                public TitleModel() {
                    super(1);
                }

                @Nullable
                public final String m2061a() {
                    this.f2209d = super.a(this.f2209d, 0);
                    return this.f2209d;
                }

                public final int jK_() {
                    return -1919764332;
                }

                public final GraphQLVisitableModel m2060a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m2059a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m2061a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            public NodesModel() {
                super(2);
            }

            @Nullable
            public final GraphQLTimelineContextListItemType m2063a() {
                this.f2210d = (GraphQLTimelineContextListItemType) super.b(this.f2210d, 0, GraphQLTimelineContextListItemType.class, GraphQLTimelineContextListItemType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f2210d;
            }

            @Nullable
            public final TitleModel m2065j() {
                this.f2211e = (TitleModel) super.a(this.f2211e, 1, TitleModel.class);
                return this.f2211e;
            }

            public final int jK_() {
                return -2140001025;
            }

            public final GraphQLVisitableModel m2064a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m2065j() != null) {
                    TitleModel titleModel = (TitleModel) graphQLModelMutatingVisitor.b(m2065j());
                    if (m2065j() != titleModel) {
                        graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f2211e = titleModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m2062a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = flatBufferBuilder.a(m2063a());
                int a2 = ModelHelper.a(flatBufferBuilder, m2065j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: sub_action */
        public class Serializer extends JsonSerializer<ContextItemsListModel> {
            public final void m2066a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ContextItemsListModel contextItemsListModel = (ContextItemsListModel) obj;
                if (contextItemsListModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(contextItemsListModel.m2067a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    contextItemsListModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ContextItemsListParser.m2083a(contextItemsListModel.w_(), contextItemsListModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ContextItemsListModel.class, new Serializer());
            }
        }

        public ContextItemsListModel() {
            super(1);
        }

        @Nonnull
        public final ImmutableList<NodesModel> m2069a() {
            this.f2212d = super.a(this.f2212d, 0, NodesModel.class);
            return (ImmutableList) this.f2212d;
        }

        public final int jK_() {
            return -2113882798;
        }

        public final GraphQLVisitableModel m2068a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2069a() != null) {
                Builder a = ModelHelper.a(m2069a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (ContextItemsListModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f2212d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2067a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m2069a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -6609612)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: sub_action */
    public final class ProfileContextItemsModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private ContextItemsListModel f2213d;
        @Nullable
        private ContextItemsListModel f2214e;

        /* compiled from: sub_action */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ProfileContextItemsModel.class, new Deserializer());
            }

            public Object m2070a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ProfileContextItemsParser.m2084a(jsonParser);
                Object profileContextItemsModel = new ProfileContextItemsModel();
                ((BaseModel) profileContextItemsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (profileContextItemsModel instanceof Postprocessable) {
                    return ((Postprocessable) profileContextItemsModel).a();
                }
                return profileContextItemsModel;
            }
        }

        /* compiled from: sub_action */
        public class Serializer extends JsonSerializer<ProfileContextItemsModel> {
            public final void m2071a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ProfileContextItemsModel profileContextItemsModel = (ProfileContextItemsModel) obj;
                if (profileContextItemsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(profileContextItemsModel.m2072a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    profileContextItemsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = profileContextItemsModel.w_();
                int u_ = profileContextItemsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("specific_context_items");
                    ContextItemsListParser.m2083a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("top_context_item");
                    ContextItemsListParser.m2083a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ProfileContextItemsModel.class, new Serializer());
            }
        }

        public ProfileContextItemsModel() {
            super(2);
        }

        public final void m2075a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m2076a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final ContextItemsListModel m2074a() {
            this.f2213d = (ContextItemsListModel) super.a(this.f2213d, 0, ContextItemsListModel.class);
            return this.f2213d;
        }

        @Nullable
        public final ContextItemsListModel m2077j() {
            this.f2214e = (ContextItemsListModel) super.a(this.f2214e, 1, ContextItemsListModel.class);
            return this.f2214e;
        }

        public final int jK_() {
            return 2645995;
        }

        public final GraphQLVisitableModel m2073a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            ContextItemsListModel contextItemsListModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2074a() != null) {
                contextItemsListModel = (ContextItemsListModel) graphQLModelMutatingVisitor.b(m2074a());
                if (m2074a() != contextItemsListModel) {
                    graphQLVisitableModel = (ProfileContextItemsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f2213d = contextItemsListModel;
                }
            }
            if (m2077j() != null) {
                contextItemsListModel = (ContextItemsListModel) graphQLModelMutatingVisitor.b(m2077j());
                if (m2077j() != contextItemsListModel) {
                    graphQLVisitableModel = (ProfileContextItemsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f2214e = contextItemsListModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2072a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m2074a());
            int a2 = ModelHelper.a(flatBufferBuilder, m2077j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
