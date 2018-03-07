package com.facebook.appdiscovery.lite.protocol;

import com.facebook.appdiscovery.lite.protocol.AppFragmentsGraphQLInterfaces.ActorFacePileFragment;
import com.facebook.appdiscovery.lite.protocol.AppFragmentsGraphQLParsers.ActorFacePileFragmentParser;
import com.facebook.appdiscovery.lite.protocol.AppFragmentsGraphQLParsers.AppStoreAppFragmentParser;
import com.facebook.appdiscovery.lite.protocol.AppFragmentsGraphQLParsers.AppStoreAppFragmentParser.DescriptionParser;
import com.facebook.appdiscovery.lite.protocol.AppFragmentsGraphQLParsers.AppStoreAppFragmentParser.LikesContextSentenceParser;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLDigitalGoodStoreType;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
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

/* compiled from: is_deleted_client = ? AND is_unarchived_client = ? AND section_name = ? */
public class AppFragmentsGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 289552164)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: is_deleted_client = ? AND is_unarchived_client = ? AND section_name = ? */
    public final class ActorFacePileFragmentModel extends BaseModel implements ActorFacePileFragment, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f10595d;
        @Nullable
        private String f10596e;
        @Nullable
        private String f10597f;
        @Nullable
        private DefaultImageFieldsModel f10598g;

        /* compiled from: is_deleted_client = ? AND is_unarchived_client = ? AND section_name = ? */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ActorFacePileFragmentModel.class, new Deserializer());
            }

            public Object m12501a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ActorFacePileFragmentParser.b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object actorFacePileFragmentModel = new ActorFacePileFragmentModel();
                ((BaseModel) actorFacePileFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (actorFacePileFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) actorFacePileFragmentModel).a();
                }
                return actorFacePileFragmentModel;
            }
        }

        /* compiled from: is_deleted_client = ? AND is_unarchived_client = ? AND section_name = ? */
        public class Serializer extends JsonSerializer<ActorFacePileFragmentModel> {
            public final void m12502a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ActorFacePileFragmentModel actorFacePileFragmentModel = (ActorFacePileFragmentModel) obj;
                if (actorFacePileFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(actorFacePileFragmentModel.m12506a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    actorFacePileFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ActorFacePileFragmentParser.b(actorFacePileFragmentModel.w_(), actorFacePileFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ActorFacePileFragmentModel.class, new Serializer());
            }
        }

        public ActorFacePileFragmentModel() {
            super(4);
        }

        public final void m12509a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m12510a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m12503j() {
            if (this.b != null && this.f10595d == null) {
                this.f10595d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f10595d;
        }

        @Nullable
        private String m12504k() {
            this.f10596e = super.a(this.f10596e, 1);
            return this.f10596e;
        }

        @Nullable
        public final String mo747b() {
            this.f10597f = super.a(this.f10597f, 2);
            return this.f10597f;
        }

        @Nullable
        private DefaultImageFieldsModel m12505l() {
            this.f10598g = (DefaultImageFieldsModel) super.a(this.f10598g, 3, DefaultImageFieldsModel.class);
            return this.f10598g;
        }

        @Nullable
        public final String m12508a() {
            return m12504k();
        }

        public final int jK_() {
            return 63093205;
        }

        public final GraphQLVisitableModel m12507a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m12505l() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m12505l());
                if (m12505l() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (ActorFacePileFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10598g = defaultImageFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m12506a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m12503j());
            int b = flatBufferBuilder.b(m12504k());
            int b2 = flatBufferBuilder.b(mo747b());
            int a2 = ModelHelper.a(flatBufferBuilder, m12505l());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 998782249)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: is_deleted_client = ? AND is_unarchived_client = ? AND section_name = ? */
    public final class AppStoreAppFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f10601d;
        @Nullable
        private String f10602e;
        @Nullable
        private String f10603f;
        @Nullable
        private List<DefaultImageFieldsModel> f10604g;
        @Nullable
        private DescriptionModel f10605h;
        @Nullable
        private String f10606i;
        @Nullable
        private LikesContextSentenceModel f10607j;
        @Nullable
        private List<DefaultImageFieldsModel> f10608k;
        @Nullable
        private PlatformApplicationFragmentModel f10609l;
        @Nullable
        private String f10610m;
        @Nullable
        private List<GraphQLDigitalGoodStoreType> f10611n;
        @Nullable
        private SocialContextSentenceFragmentModel f10612o;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: is_deleted_client = ? AND is_unarchived_client = ? AND section_name = ? */
        public final class DescriptionModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f10599d;

            /* compiled from: is_deleted_client = ? AND is_unarchived_client = ? AND section_name = ? */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(DescriptionModel.class, new Deserializer());
                }

                public Object m12512a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(DescriptionParser.a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object descriptionModel = new DescriptionModel();
                    ((BaseModel) descriptionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (descriptionModel instanceof Postprocessable) {
                        return ((Postprocessable) descriptionModel).a();
                    }
                    return descriptionModel;
                }
            }

            /* compiled from: is_deleted_client = ? AND is_unarchived_client = ? AND section_name = ? */
            public class Serializer extends JsonSerializer<DescriptionModel> {
                public final void m12513a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    DescriptionModel descriptionModel = (DescriptionModel) obj;
                    if (descriptionModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(descriptionModel.m12515a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        descriptionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    DescriptionParser.a(descriptionModel.w_(), descriptionModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(DescriptionModel.class, new Serializer());
                }
            }

            public DescriptionModel() {
                super(1);
            }

            @Nullable
            private String m12514a() {
                this.f10599d = super.a(this.f10599d, 0);
                return this.f10599d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m12516a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m12515a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m12514a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: is_deleted_client = ? AND is_unarchived_client = ? AND section_name = ? */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AppStoreAppFragmentModel.class, new Deserializer());
            }

            public Object m12517a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(AppStoreAppFragmentParser.a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object appStoreAppFragmentModel = new AppStoreAppFragmentModel();
                ((BaseModel) appStoreAppFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (appStoreAppFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) appStoreAppFragmentModel).a();
                }
                return appStoreAppFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: is_deleted_client = ? AND is_unarchived_client = ? AND section_name = ? */
        public final class LikesContextSentenceModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f10600d;

            /* compiled from: is_deleted_client = ? AND is_unarchived_client = ? AND section_name = ? */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(LikesContextSentenceModel.class, new Deserializer());
                }

                public Object m12518a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(LikesContextSentenceParser.a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object likesContextSentenceModel = new LikesContextSentenceModel();
                    ((BaseModel) likesContextSentenceModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (likesContextSentenceModel instanceof Postprocessable) {
                        return ((Postprocessable) likesContextSentenceModel).a();
                    }
                    return likesContextSentenceModel;
                }
            }

            /* compiled from: is_deleted_client = ? AND is_unarchived_client = ? AND section_name = ? */
            public class Serializer extends JsonSerializer<LikesContextSentenceModel> {
                public final void m12519a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    LikesContextSentenceModel likesContextSentenceModel = (LikesContextSentenceModel) obj;
                    if (likesContextSentenceModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(likesContextSentenceModel.m12521a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        likesContextSentenceModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    LikesContextSentenceParser.a(likesContextSentenceModel.w_(), likesContextSentenceModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(LikesContextSentenceModel.class, new Serializer());
                }
            }

            public LikesContextSentenceModel() {
                super(1);
            }

            @Nullable
            private String m12520a() {
                this.f10600d = super.a(this.f10600d, 0);
                return this.f10600d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m12522a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m12521a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m12520a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: is_deleted_client = ? AND is_unarchived_client = ? AND section_name = ? */
        public class Serializer extends JsonSerializer<AppStoreAppFragmentModel> {
            public final void m12523a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                AppStoreAppFragmentModel appStoreAppFragmentModel = (AppStoreAppFragmentModel) obj;
                if (appStoreAppFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(appStoreAppFragmentModel.m12532a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    appStoreAppFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                AppStoreAppFragmentParser.a(appStoreAppFragmentModel.w_(), appStoreAppFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(AppStoreAppFragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ SocialContextSentenceFragmentModel m12538g() {
            return m12531q();
        }

        @Nullable
        public final /* synthetic */ PlatformApplicationFragmentModel kU_() {
            return m12528n();
        }

        public AppStoreAppFragmentModel() {
            super(12);
        }

        @Nullable
        private String m12524j() {
            this.f10601d = super.a(this.f10601d, 0);
            return this.f10601d;
        }

        @Nullable
        public final String m12534a() {
            this.f10602e = super.a(this.f10602e, 1);
            return this.f10602e;
        }

        @Nullable
        public final String m12535b() {
            this.f10603f = super.a(this.f10603f, 2);
            return this.f10603f;
        }

        @Nonnull
        public final ImmutableList<DefaultImageFieldsModel> m12536c() {
            this.f10604g = super.a(this.f10604g, 3, DefaultImageFieldsModel.class);
            return (ImmutableList) this.f10604g;
        }

        @Nullable
        private DescriptionModel m12525k() {
            this.f10605h = (DescriptionModel) super.a(this.f10605h, 4, DescriptionModel.class);
            return this.f10605h;
        }

        @Nullable
        public final String m12537d() {
            this.f10606i = super.a(this.f10606i, 5);
            return this.f10606i;
        }

        @Nullable
        private LikesContextSentenceModel m12526l() {
            this.f10607j = (LikesContextSentenceModel) super.a(this.f10607j, 6, LikesContextSentenceModel.class);
            return this.f10607j;
        }

        @Nonnull
        private ImmutableList<DefaultImageFieldsModel> m12527m() {
            this.f10608k = super.a(this.f10608k, 7, DefaultImageFieldsModel.class);
            return (ImmutableList) this.f10608k;
        }

        @Nullable
        private PlatformApplicationFragmentModel m12528n() {
            this.f10609l = (PlatformApplicationFragmentModel) super.a(this.f10609l, 8, PlatformApplicationFragmentModel.class);
            return this.f10609l;
        }

        @Nullable
        private String m12529o() {
            this.f10610m = super.a(this.f10610m, 9);
            return this.f10610m;
        }

        @Nonnull
        private ImmutableList<GraphQLDigitalGoodStoreType> m12530p() {
            this.f10611n = super.c(this.f10611n, 10, GraphQLDigitalGoodStoreType.class);
            return (ImmutableList) this.f10611n;
        }

        @Nullable
        private SocialContextSentenceFragmentModel m12531q() {
            this.f10612o = (SocialContextSentenceFragmentModel) super.a(this.f10612o, 11, SocialContextSentenceFragmentModel.class);
            return this.f10612o;
        }

        public final int jK_() {
            return 1254437328;
        }

        public final GraphQLVisitableModel m12533a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            AppStoreAppFragmentModel appStoreAppFragmentModel;
            GraphQLVisitableModel graphQLVisitableModel;
            DescriptionModel descriptionModel;
            LikesContextSentenceModel likesContextSentenceModel;
            Builder a;
            PlatformApplicationFragmentModel platformApplicationFragmentModel;
            SocialContextSentenceFragmentModel socialContextSentenceFragmentModel;
            h();
            if (m12536c() != null) {
                Builder a2 = ModelHelper.a(m12536c(), graphQLModelMutatingVisitor);
                if (a2 != null) {
                    appStoreAppFragmentModel = (AppStoreAppFragmentModel) ModelHelper.a(null, this);
                    appStoreAppFragmentModel.f10604g = a2.b();
                    graphQLVisitableModel = appStoreAppFragmentModel;
                    if (m12525k() != null) {
                        descriptionModel = (DescriptionModel) graphQLModelMutatingVisitor.b(m12525k());
                        if (m12525k() != descriptionModel) {
                            graphQLVisitableModel = (AppStoreAppFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f10605h = descriptionModel;
                        }
                    }
                    if (m12526l() != null) {
                        likesContextSentenceModel = (LikesContextSentenceModel) graphQLModelMutatingVisitor.b(m12526l());
                        if (m12526l() != likesContextSentenceModel) {
                            graphQLVisitableModel = (AppStoreAppFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f10607j = likesContextSentenceModel;
                        }
                    }
                    if (m12527m() != null) {
                        a = ModelHelper.a(m12527m(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            appStoreAppFragmentModel = (AppStoreAppFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            appStoreAppFragmentModel.f10608k = a.b();
                            graphQLVisitableModel = appStoreAppFragmentModel;
                        }
                    }
                    if (m12528n() != null) {
                        platformApplicationFragmentModel = (PlatformApplicationFragmentModel) graphQLModelMutatingVisitor.b(m12528n());
                        if (m12528n() != platformApplicationFragmentModel) {
                            graphQLVisitableModel = (AppStoreAppFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f10609l = platformApplicationFragmentModel;
                        }
                    }
                    if (m12531q() != null) {
                        socialContextSentenceFragmentModel = (SocialContextSentenceFragmentModel) graphQLModelMutatingVisitor.b(m12531q());
                        if (m12531q() != socialContextSentenceFragmentModel) {
                            graphQLVisitableModel = (AppStoreAppFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f10612o = socialContextSentenceFragmentModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m12525k() != null) {
                descriptionModel = (DescriptionModel) graphQLModelMutatingVisitor.b(m12525k());
                if (m12525k() != descriptionModel) {
                    graphQLVisitableModel = (AppStoreAppFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10605h = descriptionModel;
                }
            }
            if (m12526l() != null) {
                likesContextSentenceModel = (LikesContextSentenceModel) graphQLModelMutatingVisitor.b(m12526l());
                if (m12526l() != likesContextSentenceModel) {
                    graphQLVisitableModel = (AppStoreAppFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10607j = likesContextSentenceModel;
                }
            }
            if (m12527m() != null) {
                a = ModelHelper.a(m12527m(), graphQLModelMutatingVisitor);
                if (a != null) {
                    appStoreAppFragmentModel = (AppStoreAppFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    appStoreAppFragmentModel.f10608k = a.b();
                    graphQLVisitableModel = appStoreAppFragmentModel;
                }
            }
            if (m12528n() != null) {
                platformApplicationFragmentModel = (PlatformApplicationFragmentModel) graphQLModelMutatingVisitor.b(m12528n());
                if (m12528n() != platformApplicationFragmentModel) {
                    graphQLVisitableModel = (AppStoreAppFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10609l = platformApplicationFragmentModel;
                }
            }
            if (m12531q() != null) {
                socialContextSentenceFragmentModel = (SocialContextSentenceFragmentModel) graphQLModelMutatingVisitor.b(m12531q());
                if (m12531q() != socialContextSentenceFragmentModel) {
                    graphQLVisitableModel = (AppStoreAppFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10612o = socialContextSentenceFragmentModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m12532a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m12524j());
            int b2 = flatBufferBuilder.b(m12534a());
            int b3 = flatBufferBuilder.b(m12535b());
            int a = ModelHelper.a(flatBufferBuilder, m12536c());
            int a2 = ModelHelper.a(flatBufferBuilder, m12525k());
            int b4 = flatBufferBuilder.b(m12537d());
            int a3 = ModelHelper.a(flatBufferBuilder, m12526l());
            int a4 = ModelHelper.a(flatBufferBuilder, m12527m());
            int a5 = ModelHelper.a(flatBufferBuilder, m12528n());
            int b5 = flatBufferBuilder.b(m12529o());
            int d = flatBufferBuilder.d(m12530p());
            int a6 = ModelHelper.a(flatBufferBuilder, m12531q());
            flatBufferBuilder.c(12);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.b(2, b3);
            flatBufferBuilder.b(3, a);
            flatBufferBuilder.b(4, a2);
            flatBufferBuilder.b(5, b4);
            flatBufferBuilder.b(6, a3);
            flatBufferBuilder.b(7, a4);
            flatBufferBuilder.b(8, a5);
            flatBufferBuilder.b(9, b5);
            flatBufferBuilder.b(10, d);
            flatBufferBuilder.b(11, a6);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 343165445)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: is_deleted_client = ? AND is_unarchived_client = ? AND section_name = ? */
    public final class PlatformApplicationFragmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private List<String> f10613d;
        @Nullable
        private List<String> f10614e;
        @Nullable
        private AppCenterCategoryTextModel f10615f;
        @Nullable
        private DefaultImageFieldsModel f10616g;
        @Nullable
        private FriendsWhoRecentlyUsedModel f10617h;
        @Nullable
        private FriendsWhoUsedModel f10618i;
        @Nullable
        private GlobalUsageSummarySentenceModel f10619j;
        @Nullable
        private String f10620k;
        @Nullable
        private String f10621l;
        @Nullable
        private NativeStoreObjectModel f10622m;
        @Nullable
        private String f10623n;
        @Nullable
        private SocialUsageSentenceWithNamesModel f10624o;
        @Nullable
        private SocialUsageSummarySentenceModel f10625p;
        @Nullable
        private DefaultImageFieldsModel f10626q;

        public PlatformApplicationFragmentModel() {
            super(14);
        }

        @Nonnull
        public final ImmutableList<String> m12553b() {
            this.f10613d = super.a(this.f10613d, 0);
            return (ImmutableList) this.f10613d;
        }

        @Nonnull
        public final ImmutableList<String> m12554c() {
            this.f10614e = super.a(this.f10614e, 1);
            return (ImmutableList) this.f10614e;
        }

        @Nullable
        private AppCenterCategoryTextModel m12539j() {
            this.f10615f = (AppCenterCategoryTextModel) super.a(this.f10615f, 2, AppCenterCategoryTextModel.class);
            return this.f10615f;
        }

        @Nullable
        private DefaultImageFieldsModel m12540k() {
            this.f10616g = (DefaultImageFieldsModel) super.a(this.f10616g, 3, DefaultImageFieldsModel.class);
            return this.f10616g;
        }

        @Nullable
        private FriendsWhoRecentlyUsedModel m12541l() {
            this.f10617h = (FriendsWhoRecentlyUsedModel) super.a(this.f10617h, 4, FriendsWhoRecentlyUsedModel.class);
            return this.f10617h;
        }

        @Nullable
        private FriendsWhoUsedModel m12542m() {
            this.f10618i = (FriendsWhoUsedModel) super.a(this.f10618i, 5, FriendsWhoUsedModel.class);
            return this.f10618i;
        }

        @Nullable
        private GlobalUsageSummarySentenceModel m12543n() {
            this.f10619j = (GlobalUsageSummarySentenceModel) super.a(this.f10619j, 6, GlobalUsageSummarySentenceModel.class);
            return this.f10619j;
        }

        @Nullable
        private String m12544o() {
            this.f10620k = super.a(this.f10620k, 7);
            return this.f10620k;
        }

        @Nullable
        public final String m12555d() {
            this.f10621l = super.a(this.f10621l, 8);
            return this.f10621l;
        }

        @Nullable
        private NativeStoreObjectModel m12545p() {
            this.f10622m = (NativeStoreObjectModel) super.a(this.f10622m, 9, NativeStoreObjectModel.class);
            return this.f10622m;
        }

        @Nullable
        private String m12546q() {
            this.f10623n = super.a(this.f10623n, 10);
            return this.f10623n;
        }

        @Nullable
        private SocialUsageSentenceWithNamesModel m12547r() {
            this.f10624o = (SocialUsageSentenceWithNamesModel) super.a(this.f10624o, 11, SocialUsageSentenceWithNamesModel.class);
            return this.f10624o;
        }

        @Nullable
        private SocialUsageSummarySentenceModel m12548s() {
            this.f10625p = (SocialUsageSummarySentenceModel) super.a(this.f10625p, 12, SocialUsageSummarySentenceModel.class);
            return this.f10625p;
        }

        @Nullable
        private DefaultImageFieldsModel m12549t() {
            this.f10626q = (DefaultImageFieldsModel) super.a(this.f10626q, 13, DefaultImageFieldsModel.class);
            return this.f10626q;
        }

        @Nullable
        public final String m12552a() {
            return m12544o();
        }

        public final int jK_() {
            return -1072845520;
        }

        public final GraphQLVisitableModel m12551a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            DefaultImageFieldsModel defaultImageFieldsModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m12539j() != null) {
                AppCenterCategoryTextModel appCenterCategoryTextModel = (AppCenterCategoryTextModel) graphQLModelMutatingVisitor.b(m12539j());
                if (m12539j() != appCenterCategoryTextModel) {
                    graphQLVisitableModel = (PlatformApplicationFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10615f = appCenterCategoryTextModel;
                }
            }
            if (m12540k() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m12540k());
                if (m12540k() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (PlatformApplicationFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10616g = defaultImageFieldsModel;
                }
            }
            if (m12541l() != null) {
                FriendsWhoRecentlyUsedModel friendsWhoRecentlyUsedModel = (FriendsWhoRecentlyUsedModel) graphQLModelMutatingVisitor.b(m12541l());
                if (m12541l() != friendsWhoRecentlyUsedModel) {
                    graphQLVisitableModel = (PlatformApplicationFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10617h = friendsWhoRecentlyUsedModel;
                }
            }
            if (m12542m() != null) {
                FriendsWhoUsedModel friendsWhoUsedModel = (FriendsWhoUsedModel) graphQLModelMutatingVisitor.b(m12542m());
                if (m12542m() != friendsWhoUsedModel) {
                    graphQLVisitableModel = (PlatformApplicationFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10618i = friendsWhoUsedModel;
                }
            }
            if (m12543n() != null) {
                GlobalUsageSummarySentenceModel globalUsageSummarySentenceModel = (GlobalUsageSummarySentenceModel) graphQLModelMutatingVisitor.b(m12543n());
                if (m12543n() != globalUsageSummarySentenceModel) {
                    graphQLVisitableModel = (PlatformApplicationFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10619j = globalUsageSummarySentenceModel;
                }
            }
            if (m12545p() != null) {
                NativeStoreObjectModel nativeStoreObjectModel = (NativeStoreObjectModel) graphQLModelMutatingVisitor.b(m12545p());
                if (m12545p() != nativeStoreObjectModel) {
                    graphQLVisitableModel = (PlatformApplicationFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10622m = nativeStoreObjectModel;
                }
            }
            if (m12547r() != null) {
                SocialUsageSentenceWithNamesModel socialUsageSentenceWithNamesModel = (SocialUsageSentenceWithNamesModel) graphQLModelMutatingVisitor.b(m12547r());
                if (m12547r() != socialUsageSentenceWithNamesModel) {
                    graphQLVisitableModel = (PlatformApplicationFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10624o = socialUsageSentenceWithNamesModel;
                }
            }
            if (m12548s() != null) {
                SocialUsageSummarySentenceModel socialUsageSummarySentenceModel = (SocialUsageSummarySentenceModel) graphQLModelMutatingVisitor.b(m12548s());
                if (m12548s() != socialUsageSummarySentenceModel) {
                    graphQLVisitableModel = (PlatformApplicationFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10625p = socialUsageSummarySentenceModel;
                }
            }
            if (m12549t() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m12549t());
                if (m12549t() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (PlatformApplicationFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10626q = defaultImageFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m12550a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int c = flatBufferBuilder.c(m12553b());
            int c2 = flatBufferBuilder.c(m12554c());
            int a = ModelHelper.a(flatBufferBuilder, m12539j());
            int a2 = ModelHelper.a(flatBufferBuilder, m12540k());
            int a3 = ModelHelper.a(flatBufferBuilder, m12541l());
            int a4 = ModelHelper.a(flatBufferBuilder, m12542m());
            int a5 = ModelHelper.a(flatBufferBuilder, m12543n());
            int b = flatBufferBuilder.b(m12544o());
            int b2 = flatBufferBuilder.b(m12555d());
            int a6 = ModelHelper.a(flatBufferBuilder, m12545p());
            int b3 = flatBufferBuilder.b(m12546q());
            int a7 = ModelHelper.a(flatBufferBuilder, m12547r());
            int a8 = ModelHelper.a(flatBufferBuilder, m12548s());
            int a9 = ModelHelper.a(flatBufferBuilder, m12549t());
            flatBufferBuilder.c(14);
            flatBufferBuilder.b(0, c);
            flatBufferBuilder.b(1, c2);
            flatBufferBuilder.b(2, a);
            flatBufferBuilder.b(3, a2);
            flatBufferBuilder.b(4, a3);
            flatBufferBuilder.b(5, a4);
            flatBufferBuilder.b(6, a5);
            flatBufferBuilder.b(7, b);
            flatBufferBuilder.b(8, b2);
            flatBufferBuilder.b(9, a6);
            flatBufferBuilder.b(10, b3);
            flatBufferBuilder.b(11, a7);
            flatBufferBuilder.b(12, a8);
            flatBufferBuilder.b(13, a9);
            i();
            return flatBufferBuilder.d();
        }
    }
}
