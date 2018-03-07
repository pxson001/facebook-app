package com.facebook.appinvites.protocol;

import com.facebook.appinvites.protocol.AppInvitesTextWithEntitiesParsers.AppInvitesTextWithEntitiesParser;
import com.facebook.appinvites.protocol.AppInvitesTextWithEntitiesParsers.AppInvitesTextWithEntitiesParser.RangesParser;
import com.facebook.appinvites.protocol.AppInvitesTextWithEntitiesParsers.AppInvitesTextWithEntitiesParser.RangesParser.EntityParser;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
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
import com.facebook.zero.onboarding.graphql.AssistedOnboardingParsers.AssistedRegSendInviteWithSourceParser;
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

/* compiled from: e50b42763475099e86f400020d44e39e */
public class AppInvitesTextWithEntitiesModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -956332258)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: e50b42763475099e86f400020d44e39e */
    public final class AppInvitesTextWithEntitiesModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<RangesModel> f14634d;
        @Nullable
        private String f14635e;

        /* compiled from: e50b42763475099e86f400020d44e39e */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AppInvitesTextWithEntitiesModel.class, new Deserializer());
            }

            public Object m14871a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(AppInvitesTextWithEntitiesParser.m14897a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object appInvitesTextWithEntitiesModel = new AppInvitesTextWithEntitiesModel();
                ((BaseModel) appInvitesTextWithEntitiesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (appInvitesTextWithEntitiesModel instanceof Postprocessable) {
                    return ((Postprocessable) appInvitesTextWithEntitiesModel).a();
                }
                return appInvitesTextWithEntitiesModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1161383086)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: e50b42763475099e86f400020d44e39e */
        public final class RangesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private EntityModel f14631d;
            private int f14632e;
            private int f14633f;

            /* compiled from: e50b42763475099e86f400020d44e39e */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(RangesModel.class, new Deserializer());
                }

                public Object m14872a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(RangesParser.m14896b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object rangesModel = new RangesModel();
                    ((BaseModel) rangesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (rangesModel instanceof Postprocessable) {
                        return ((Postprocessable) rangesModel).a();
                    }
                    return rangesModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1255661007)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: e50b42763475099e86f400020d44e39e */
            public final class EntityModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                @Nullable
                private GraphQLObjectType f14628d;
                @Nullable
                private String f14629e;
                @Nullable
                private String f14630f;

                /* compiled from: e50b42763475099e86f400020d44e39e */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EntityModel.class, new Deserializer());
                    }

                    public Object m14873a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(EntityParser.m14894a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object entityModel = new EntityModel();
                        ((BaseModel) entityModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (entityModel instanceof Postprocessable) {
                            return ((Postprocessable) entityModel).a();
                        }
                        return entityModel;
                    }
                }

                /* compiled from: e50b42763475099e86f400020d44e39e */
                public class Serializer extends JsonSerializer<EntityModel> {
                    public final void m14874a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EntityModel entityModel = (EntityModel) obj;
                        if (entityModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(entityModel.m14875a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            entityModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        EntityParser.m14895a(entityModel.w_(), entityModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(EntityModel.class, new Serializer());
                    }
                }

                public EntityModel() {
                    super(3);
                }

                @Nullable
                public final GraphQLObjectType m14878b() {
                    if (this.b != null && this.f14628d == null) {
                        this.f14628d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f14628d;
                }

                @Nullable
                public final String m14879c() {
                    this.f14629e = super.a(this.f14629e, 1);
                    return this.f14629e;
                }

                @Nullable
                public final String m14880d() {
                    this.f14630f = super.a(this.f14630f, 2);
                    return this.f14630f;
                }

                @Nullable
                public final String m14877a() {
                    return m14879c();
                }

                public final int jK_() {
                    return 2080559107;
                }

                public final GraphQLVisitableModel m14876a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m14875a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m14878b());
                    int b = flatBufferBuilder.b(m14879c());
                    int b2 = flatBufferBuilder.b(m14880d());
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.b(2, b2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: e50b42763475099e86f400020d44e39e */
            public class Serializer extends JsonSerializer<RangesModel> {
                public final void m14881a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    RangesModel rangesModel = (RangesModel) obj;
                    if (rangesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(rangesModel.m14883a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        rangesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AssistedRegSendInviteWithSourceParser.b(rangesModel.w_(), rangesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(RangesModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ EntityModel m14884a() {
                return m14882j();
            }

            public RangesModel() {
                super(3);
            }

            @Nullable
            private EntityModel m14882j() {
                this.f14631d = (EntityModel) super.a(this.f14631d, 0, EntityModel.class);
                return this.f14631d;
            }

            public final int m14887b() {
                a(0, 1);
                return this.f14632e;
            }

            public final int m14888c() {
                a(0, 2);
                return this.f14633f;
            }

            public final int jK_() {
                return -1024511161;
            }

            public final GraphQLVisitableModel m14885a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m14882j() != null) {
                    EntityModel entityModel = (EntityModel) graphQLModelMutatingVisitor.b(m14882j());
                    if (m14882j() != entityModel) {
                        graphQLVisitableModel = (RangesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f14631d = entityModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m14883a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m14882j());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.a(1, this.f14632e, 0);
                flatBufferBuilder.a(2, this.f14633f, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m14886a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f14632e = mutableFlatBuffer.a(i, 1, 0);
                this.f14633f = mutableFlatBuffer.a(i, 2, 0);
            }
        }

        /* compiled from: e50b42763475099e86f400020d44e39e */
        public class Serializer extends JsonSerializer<AppInvitesTextWithEntitiesModel> {
            public final void m14889a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                AppInvitesTextWithEntitiesModel appInvitesTextWithEntitiesModel = (AppInvitesTextWithEntitiesModel) obj;
                if (appInvitesTextWithEntitiesModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(appInvitesTextWithEntitiesModel.m14890a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    appInvitesTextWithEntitiesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                AppInvitesTextWithEntitiesParser.m14898a(appInvitesTextWithEntitiesModel.w_(), appInvitesTextWithEntitiesModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(AppInvitesTextWithEntitiesModel.class, new Serializer());
            }
        }

        public AppInvitesTextWithEntitiesModel() {
            super(2);
        }

        @Nonnull
        public final ImmutableList<RangesModel> m14892a() {
            this.f14634d = super.a(this.f14634d, 0, RangesModel.class);
            return (ImmutableList) this.f14634d;
        }

        @Nullable
        public final String m14893b() {
            this.f14635e = super.a(this.f14635e, 1);
            return this.f14635e;
        }

        public final int jK_() {
            return -1919764332;
        }

        public final GraphQLVisitableModel m14891a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m14892a() != null) {
                Builder a = ModelHelper.a(m14892a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (AppInvitesTextWithEntitiesModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f14634d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m14890a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m14892a());
            int b = flatBufferBuilder.b(m14893b());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
