package com.facebook.friending.center.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.friending.center.protocol.FriendsCenterFetchRequestsGraphQLParsers.FriendCenterRequestEdgeParser;
import com.facebook.friending.center.protocol.FriendsCenterFetchRequestsGraphQLParsers.FriendCenterRequestEdgeParser.SuggestersParser;
import com.facebook.friending.center.protocol.FriendsCenterFetchRequestsGraphQLParsers.FriendsCenterFetchRequestsQueryParser;
import com.facebook.friending.center.protocol.FriendsCenterFetchRequestsGraphQLParsers.FriendsCenterFetchRequestsQueryParser.FriendingPossibilitiesParser;
import com.facebook.friending.center.protocol.FriendsCenterFetchRequestsGraphQLParsers.FriendsCenterRequestNodeParser;
import com.facebook.friending.center.protocol.FriendsCenterFetchRequestsGraphQLParsers.FriendsCenterRequestNodeParser.SocialContextParser;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
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

/* compiled from: adsmanager */
public class FriendsCenterFetchRequestsGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -977926781)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: adsmanager */
    public final class FriendCenterRequestEdgeModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private FriendsCenterRequestNodeModel f20024d;
        @Nullable
        private List<SuggestersModel> f20025e;

        /* compiled from: adsmanager */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FriendCenterRequestEdgeModel.class, new Deserializer());
            }

            public Object m20234a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FriendCenterRequestEdgeParser.m20278b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object friendCenterRequestEdgeModel = new FriendCenterRequestEdgeModel();
                ((BaseModel) friendCenterRequestEdgeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (friendCenterRequestEdgeModel instanceof Postprocessable) {
                    return ((Postprocessable) friendCenterRequestEdgeModel).a();
                }
                return friendCenterRequestEdgeModel;
            }
        }

        /* compiled from: adsmanager */
        public class Serializer extends JsonSerializer<FriendCenterRequestEdgeModel> {
            public final void m20235a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FriendCenterRequestEdgeModel friendCenterRequestEdgeModel = (FriendCenterRequestEdgeModel) obj;
                if (friendCenterRequestEdgeModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(friendCenterRequestEdgeModel.m20243a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    friendCenterRequestEdgeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FriendCenterRequestEdgeParser.m20279b(friendCenterRequestEdgeModel.w_(), friendCenterRequestEdgeModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FriendCenterRequestEdgeModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 273304230)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: adsmanager */
        public final class SuggestersModel extends BaseModel implements GraphQLVisitableConsistentModel {
            @Nullable
            private String f20023d;

            /* compiled from: adsmanager */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SuggestersModel.class, new Deserializer());
                }

                public Object m20236a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SuggestersParser.m20277b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object suggestersModel = new SuggestersModel();
                    ((BaseModel) suggestersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (suggestersModel instanceof Postprocessable) {
                        return ((Postprocessable) suggestersModel).a();
                    }
                    return suggestersModel;
                }
            }

            /* compiled from: adsmanager */
            public class Serializer extends JsonSerializer<SuggestersModel> {
                public final void m20237a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SuggestersModel suggestersModel = (SuggestersModel) obj;
                    if (suggestersModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(suggestersModel.m20238a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        suggestersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SuggestersParser.m20276a(suggestersModel.w_(), suggestersModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(SuggestersModel.class, new Serializer());
                }
            }

            public SuggestersModel() {
                super(1);
            }

            public final void m20241a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m20242a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final String m20240a() {
                this.f20023d = super.a(this.f20023d, 0);
                return this.f20023d;
            }

            public final int jK_() {
                return 2645995;
            }

            public final GraphQLVisitableModel m20239a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m20238a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m20240a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        public FriendCenterRequestEdgeModel() {
            super(2);
        }

        @Nullable
        public final FriendsCenterRequestNodeModel m20244a() {
            this.f20024d = (FriendsCenterRequestNodeModel) super.a(this.f20024d, 0, FriendsCenterRequestNodeModel.class);
            return this.f20024d;
        }

        @Nonnull
        public final ImmutableList<SuggestersModel> m20246j() {
            this.f20025e = super.a(this.f20025e, 1, SuggestersModel.class);
            return (ImmutableList) this.f20025e;
        }

        public final int jK_() {
            return 923339498;
        }

        public final GraphQLVisitableModel m20245a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m20244a() != null) {
                FriendsCenterRequestNodeModel friendsCenterRequestNodeModel = (FriendsCenterRequestNodeModel) graphQLModelMutatingVisitor.b(m20244a());
                if (m20244a() != friendsCenterRequestNodeModel) {
                    graphQLVisitableModel = (FriendCenterRequestEdgeModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f20024d = friendsCenterRequestNodeModel;
                }
            }
            if (m20246j() != null) {
                Builder a = ModelHelper.a(m20246j(), graphQLModelMutatingVisitor);
                if (a != null) {
                    FriendCenterRequestEdgeModel friendCenterRequestEdgeModel = (FriendCenterRequestEdgeModel) ModelHelper.a(graphQLVisitableModel, this);
                    friendCenterRequestEdgeModel.f20025e = a.b();
                    graphQLVisitableModel = friendCenterRequestEdgeModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m20243a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m20244a());
            int a2 = ModelHelper.a(flatBufferBuilder, m20246j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1859322433)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: adsmanager */
    public final class FriendsCenterFetchRequestsQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private FriendingPossibilitiesModel f20028d;

        /* compiled from: adsmanager */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FriendsCenterFetchRequestsQueryModel.class, new Deserializer());
            }

            public Object m20247a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FriendsCenterFetchRequestsQueryParser.m20282a(jsonParser);
                Object friendsCenterFetchRequestsQueryModel = new FriendsCenterFetchRequestsQueryModel();
                ((BaseModel) friendsCenterFetchRequestsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (friendsCenterFetchRequestsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) friendsCenterFetchRequestsQueryModel).a();
                }
                return friendsCenterFetchRequestsQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1238329022)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: adsmanager */
        public final class FriendingPossibilitiesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<FriendCenterRequestEdgeModel> f20026d;
            @Nullable
            private DefaultPageInfoFieldsModel f20027e;

            /* compiled from: adsmanager */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FriendingPossibilitiesModel.class, new Deserializer());
                }

                public Object m20248a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FriendingPossibilitiesParser.m20280a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object friendingPossibilitiesModel = new FriendingPossibilitiesModel();
                    ((BaseModel) friendingPossibilitiesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (friendingPossibilitiesModel instanceof Postprocessable) {
                        return ((Postprocessable) friendingPossibilitiesModel).a();
                    }
                    return friendingPossibilitiesModel;
                }
            }

            /* compiled from: adsmanager */
            public class Serializer extends JsonSerializer<FriendingPossibilitiesModel> {
                public final void m20249a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FriendingPossibilitiesModel friendingPossibilitiesModel = (FriendingPossibilitiesModel) obj;
                    if (friendingPossibilitiesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(friendingPossibilitiesModel.m20250a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        friendingPossibilitiesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FriendingPossibilitiesParser.m20281a(friendingPossibilitiesModel.w_(), friendingPossibilitiesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(FriendingPossibilitiesModel.class, new Serializer());
                }
            }

            public FriendingPossibilitiesModel() {
                super(2);
            }

            @Nonnull
            public final ImmutableList<FriendCenterRequestEdgeModel> m20252a() {
                this.f20026d = super.a(this.f20026d, 0, FriendCenterRequestEdgeModel.class);
                return (ImmutableList) this.f20026d;
            }

            @Nullable
            public final DefaultPageInfoFieldsModel m20253j() {
                this.f20027e = (DefaultPageInfoFieldsModel) super.a(this.f20027e, 1, DefaultPageInfoFieldsModel.class);
                return this.f20027e;
            }

            public final int jK_() {
                return 1085064779;
            }

            public final GraphQLVisitableModel m20251a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                DefaultPageInfoFieldsModel defaultPageInfoFieldsModel;
                h();
                if (m20252a() != null) {
                    Builder a = ModelHelper.a(m20252a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        FriendingPossibilitiesModel friendingPossibilitiesModel = (FriendingPossibilitiesModel) ModelHelper.a(null, this);
                        friendingPossibilitiesModel.f20026d = a.b();
                        graphQLVisitableModel = friendingPossibilitiesModel;
                        if (m20253j() != null) {
                            defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m20253j());
                            if (m20253j() != defaultPageInfoFieldsModel) {
                                graphQLVisitableModel = (FriendingPossibilitiesModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f20027e = defaultPageInfoFieldsModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m20253j() != null) {
                    defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m20253j());
                    if (m20253j() != defaultPageInfoFieldsModel) {
                        graphQLVisitableModel = (FriendingPossibilitiesModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f20027e = defaultPageInfoFieldsModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m20250a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m20252a());
                int a2 = ModelHelper.a(flatBufferBuilder, m20253j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: adsmanager */
        public class Serializer extends JsonSerializer<FriendsCenterFetchRequestsQueryModel> {
            public final void m20254a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FriendsCenterFetchRequestsQueryModel friendsCenterFetchRequestsQueryModel = (FriendsCenterFetchRequestsQueryModel) obj;
                if (friendsCenterFetchRequestsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(friendsCenterFetchRequestsQueryModel.m20255a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    friendsCenterFetchRequestsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = friendsCenterFetchRequestsQueryModel.w_();
                int u_ = friendsCenterFetchRequestsQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("friending_possibilities");
                    FriendingPossibilitiesParser.m20281a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FriendsCenterFetchRequestsQueryModel.class, new Serializer());
            }
        }

        public FriendsCenterFetchRequestsQueryModel() {
            super(1);
        }

        @Nullable
        public final FriendingPossibilitiesModel m20256a() {
            this.f20028d = (FriendingPossibilitiesModel) super.a(this.f20028d, 0, FriendingPossibilitiesModel.class);
            return this.f20028d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m20257a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m20256a() != null) {
                FriendingPossibilitiesModel friendingPossibilitiesModel = (FriendingPossibilitiesModel) graphQLModelMutatingVisitor.b(m20256a());
                if (m20256a() != friendingPossibilitiesModel) {
                    graphQLVisitableModel = (FriendsCenterFetchRequestsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f20028d = friendingPossibilitiesModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m20255a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m20256a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 2017130788)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: adsmanager */
    public final class FriendsCenterRequestNodeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLFriendshipStatus f20030d;
        @Nullable
        private String f20031e;
        @Nullable
        private String f20032f;
        @Nullable
        private DefaultImageFieldsModel f20033g;
        @Nullable
        private SocialContextModel f20034h;

        /* compiled from: adsmanager */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FriendsCenterRequestNodeModel.class, new Deserializer());
            }

            public Object m20258a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FriendsCenterRequestNodeParser.m20285a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object friendsCenterRequestNodeModel = new FriendsCenterRequestNodeModel();
                ((BaseModel) friendsCenterRequestNodeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (friendsCenterRequestNodeModel instanceof Postprocessable) {
                    return ((Postprocessable) friendsCenterRequestNodeModel).a();
                }
                return friendsCenterRequestNodeModel;
            }
        }

        /* compiled from: adsmanager */
        public class Serializer extends JsonSerializer<FriendsCenterRequestNodeModel> {
            public final void m20259a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FriendsCenterRequestNodeModel friendsCenterRequestNodeModel = (FriendsCenterRequestNodeModel) obj;
                if (friendsCenterRequestNodeModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(friendsCenterRequestNodeModel.m20266a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    friendsCenterRequestNodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FriendsCenterRequestNodeParser.m20286a(friendsCenterRequestNodeModel.w_(), friendsCenterRequestNodeModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FriendsCenterRequestNodeModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: adsmanager */
        public final class SocialContextModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f20029d;

            /* compiled from: adsmanager */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SocialContextModel.class, new Deserializer());
                }

                public Object m20260a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SocialContextParser.m20283a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object socialContextModel = new SocialContextModel();
                    ((BaseModel) socialContextModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (socialContextModel instanceof Postprocessable) {
                        return ((Postprocessable) socialContextModel).a();
                    }
                    return socialContextModel;
                }
            }

            /* compiled from: adsmanager */
            public class Serializer extends JsonSerializer<SocialContextModel> {
                public final void m20261a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SocialContextModel socialContextModel = (SocialContextModel) obj;
                    if (socialContextModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(socialContextModel.m20262a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        socialContextModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SocialContextParser.m20284a(socialContextModel.w_(), socialContextModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(SocialContextModel.class, new Serializer());
                }
            }

            public SocialContextModel() {
                super(1);
            }

            @Nullable
            public final String m20264a() {
                this.f20029d = super.a(this.f20029d, 0);
                return this.f20029d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m20263a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m20262a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m20264a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        public FriendsCenterRequestNodeModel() {
            super(5);
        }

        public final void m20269a(String str, ConsistencyTuple consistencyTuple) {
            if ("friendship_status".equals(str)) {
                consistencyTuple.a = m20271j();
                consistencyTuple.b = u_();
                consistencyTuple.c = 0;
                return;
            }
            consistencyTuple.a();
        }

        public final void m20270a(String str, Object obj, boolean z) {
            if ("friendship_status".equals(str)) {
                m20265a((GraphQLFriendshipStatus) obj);
            }
        }

        @Nullable
        public final GraphQLFriendshipStatus m20271j() {
            this.f20030d = (GraphQLFriendshipStatus) super.b(this.f20030d, 0, GraphQLFriendshipStatus.class, GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f20030d;
        }

        private void m20265a(GraphQLFriendshipStatus graphQLFriendshipStatus) {
            this.f20030d = graphQLFriendshipStatus;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 0, graphQLFriendshipStatus != null ? graphQLFriendshipStatus.name() : null);
            }
        }

        @Nullable
        public final String m20272k() {
            this.f20031e = super.a(this.f20031e, 1);
            return this.f20031e;
        }

        @Nullable
        public final String m20273l() {
            this.f20032f = super.a(this.f20032f, 2);
            return this.f20032f;
        }

        @Nullable
        public final DefaultImageFieldsModel m20274m() {
            this.f20033g = (DefaultImageFieldsModel) super.a(this.f20033g, 3, DefaultImageFieldsModel.class);
            return this.f20033g;
        }

        @Nullable
        public final SocialContextModel m20275n() {
            this.f20034h = (SocialContextModel) super.a(this.f20034h, 4, SocialContextModel.class);
            return this.f20034h;
        }

        @Nullable
        public final String m20268a() {
            return m20272k();
        }

        public final int jK_() {
            return 2645995;
        }

        public final GraphQLVisitableModel m20267a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m20274m() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m20274m());
                if (m20274m() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (FriendsCenterRequestNodeModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f20033g = defaultImageFieldsModel;
                }
            }
            if (m20275n() != null) {
                SocialContextModel socialContextModel = (SocialContextModel) graphQLModelMutatingVisitor.b(m20275n());
                if (m20275n() != socialContextModel) {
                    graphQLVisitableModel = (FriendsCenterRequestNodeModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f20034h = socialContextModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m20266a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = flatBufferBuilder.a(m20271j());
            int b = flatBufferBuilder.b(m20272k());
            int b2 = flatBufferBuilder.b(m20273l());
            int a2 = ModelHelper.a(flatBufferBuilder, m20274m());
            int a3 = ModelHelper.a(flatBufferBuilder, m20275n());
            flatBufferBuilder.c(5);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, a2);
            flatBufferBuilder.b(4, a3);
            i();
            return flatBufferBuilder.d();
        }
    }
}
