package com.facebook.timeline.profilemedia.sync.protocol;

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
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.timeline.profilemedia.sync.protocol.FetchProfilePicGraphQLParsers.FetchProfilePicGraphQLParser;
import com.facebook.timeline.profilemedia.sync.protocol.FetchProfilePicGraphQLParsers.FetchProfilePicGraphQLParser.ActorParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: mSuggestifierResponseId */
public class FetchProfilePicGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1599794534)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: mSuggestifierResponseId */
    public final class FetchProfilePicGraphQLModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ActorModel f9191d;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -365594542)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: mSuggestifierResponseId */
        public final class ActorModel extends BaseModel implements GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f9186d;
            @Nullable
            private DefaultImageFieldsModel f9187e;
            @Nullable
            private DefaultImageFieldsModel f9188f;
            @Nullable
            private DefaultImageFieldsModel f9189g;
            @Nullable
            private DefaultImageFieldsModel f9190h;

            /* compiled from: mSuggestifierResponseId */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ActorModel.class, new Deserializer());
                }

                public Object m10962a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ActorParser.m10978a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object actorModel = new ActorModel();
                    ((BaseModel) actorModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (actorModel instanceof Postprocessable) {
                        return ((Postprocessable) actorModel).a();
                    }
                    return actorModel;
                }
            }

            /* compiled from: mSuggestifierResponseId */
            public class Serializer extends JsonSerializer<ActorModel> {
                public final void m10963a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ActorModel actorModel = (ActorModel) obj;
                    if (actorModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(actorModel.m10965a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        actorModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ActorParser.m10979a(actorModel.w_(), actorModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ActorModel.class, new Serializer());
                }
            }

            public ActorModel() {
                super(5);
            }

            public final void m10968a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m10969a(String str, Object obj, boolean z) {
            }

            @Nullable
            private GraphQLObjectType m10964m() {
                if (this.b != null && this.f9186d == null) {
                    this.f9186d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f9186d;
            }

            @Nullable
            public final DefaultImageFieldsModel m10966a() {
                this.f9187e = (DefaultImageFieldsModel) super.a(this.f9187e, 1, DefaultImageFieldsModel.class);
                return this.f9187e;
            }

            @Nullable
            public final DefaultImageFieldsModel m10970j() {
                this.f9188f = (DefaultImageFieldsModel) super.a(this.f9188f, 2, DefaultImageFieldsModel.class);
                return this.f9188f;
            }

            @Nullable
            public final DefaultImageFieldsModel m10971k() {
                this.f9189g = (DefaultImageFieldsModel) super.a(this.f9189g, 3, DefaultImageFieldsModel.class);
                return this.f9189g;
            }

            @Nullable
            public final DefaultImageFieldsModel m10972l() {
                this.f9190h = (DefaultImageFieldsModel) super.a(this.f9190h, 4, DefaultImageFieldsModel.class);
                return this.f9190h;
            }

            public final int jK_() {
                return 63093205;
            }

            public final GraphQLVisitableModel m10967a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                DefaultImageFieldsModel defaultImageFieldsModel;
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m10966a() != null) {
                    defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m10966a());
                    if (m10966a() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (ActorModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f9187e = defaultImageFieldsModel;
                    }
                }
                if (m10970j() != null) {
                    defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m10970j());
                    if (m10970j() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (ActorModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f9188f = defaultImageFieldsModel;
                    }
                }
                if (m10971k() != null) {
                    defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m10971k());
                    if (m10971k() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (ActorModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f9189g = defaultImageFieldsModel;
                    }
                }
                if (m10972l() != null) {
                    defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m10972l());
                    if (m10972l() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (ActorModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f9190h = defaultImageFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m10965a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m10964m());
                int a2 = ModelHelper.a(flatBufferBuilder, m10966a());
                int a3 = ModelHelper.a(flatBufferBuilder, m10970j());
                int a4 = ModelHelper.a(flatBufferBuilder, m10971k());
                int a5 = ModelHelper.a(flatBufferBuilder, m10972l());
                flatBufferBuilder.c(5);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, a3);
                flatBufferBuilder.b(3, a4);
                flatBufferBuilder.b(4, a5);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: mSuggestifierResponseId */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchProfilePicGraphQLModel.class, new Deserializer());
            }

            public Object m10973a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchProfilePicGraphQLParser.m10980a(jsonParser);
                Object fetchProfilePicGraphQLModel = new FetchProfilePicGraphQLModel();
                ((BaseModel) fetchProfilePicGraphQLModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchProfilePicGraphQLModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchProfilePicGraphQLModel).a();
                }
                return fetchProfilePicGraphQLModel;
            }
        }

        /* compiled from: mSuggestifierResponseId */
        public class Serializer extends JsonSerializer<FetchProfilePicGraphQLModel> {
            public final void m10974a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchProfilePicGraphQLModel fetchProfilePicGraphQLModel = (FetchProfilePicGraphQLModel) obj;
                if (fetchProfilePicGraphQLModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchProfilePicGraphQLModel.m10975a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchProfilePicGraphQLModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchProfilePicGraphQLModel.w_();
                int u_ = fetchProfilePicGraphQLModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("actor");
                    ActorParser.m10979a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchProfilePicGraphQLModel.class, new Serializer());
            }
        }

        public FetchProfilePicGraphQLModel() {
            super(1);
        }

        @Nullable
        public final ActorModel m10977a() {
            this.f9191d = (ActorModel) super.a(this.f9191d, 0, ActorModel.class);
            return this.f9191d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m10976a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m10977a() != null) {
                ActorModel actorModel = (ActorModel) graphQLModelMutatingVisitor.b(m10977a());
                if (m10977a() != actorModel) {
                    graphQLVisitableModel = (FetchProfilePicGraphQLModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9191d = actorModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m10975a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m10977a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
