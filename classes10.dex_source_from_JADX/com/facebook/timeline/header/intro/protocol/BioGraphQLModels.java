package com.facebook.timeline.header.intro.protocol;

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
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.timeline.header.intro.protocol.BioGraphQLParsers.BioQueryParser;
import com.facebook.timeline.header.intro.protocol.BioGraphQLParsers.BioQueryParser.ProfileIntroCardParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: fetch_intro_card */
public class BioGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1619119064)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: fetch_intro_card */
    public final class BioQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private ProfileIntroCardModel f11835d;

        /* compiled from: fetch_intro_card */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(BioQueryModel.class, new Deserializer());
            }

            public Object m11896a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = BioQueryParser.m11912a(jsonParser);
                Object bioQueryModel = new BioQueryModel();
                ((BaseModel) bioQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (bioQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) bioQueryModel).a();
                }
                return bioQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 121127825)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: fetch_intro_card */
        public final class ProfileIntroCardModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private DefaultTextWithEntitiesFieldsModel f11833d;
            private boolean f11834e;

            /* compiled from: fetch_intro_card */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ProfileIntroCardModel.class, new Deserializer());
                }

                public Object m11897a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ProfileIntroCardParser.m11910a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object profileIntroCardModel = new ProfileIntroCardModel();
                    ((BaseModel) profileIntroCardModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (profileIntroCardModel instanceof Postprocessable) {
                        return ((Postprocessable) profileIntroCardModel).a();
                    }
                    return profileIntroCardModel;
                }
            }

            /* compiled from: fetch_intro_card */
            public class Serializer extends JsonSerializer<ProfileIntroCardModel> {
                public final void m11898a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ProfileIntroCardModel profileIntroCardModel = (ProfileIntroCardModel) obj;
                    if (profileIntroCardModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(profileIntroCardModel.m11899a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        profileIntroCardModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ProfileIntroCardParser.m11911a(profileIntroCardModel.w_(), profileIntroCardModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ProfileIntroCardModel.class, new Serializer());
                }
            }

            public ProfileIntroCardModel() {
                super(2);
            }

            @Nullable
            public final DefaultTextWithEntitiesFieldsModel m11900a() {
                this.f11833d = (DefaultTextWithEntitiesFieldsModel) super.a(this.f11833d, 0, DefaultTextWithEntitiesFieldsModel.class);
                return this.f11833d;
            }

            public final boolean m11903j() {
                a(0, 1);
                return this.f11834e;
            }

            public final int jK_() {
                return 2102913043;
            }

            public final GraphQLVisitableModel m11901a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m11900a() != null) {
                    DefaultTextWithEntitiesFieldsModel defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m11900a());
                    if (m11900a() != defaultTextWithEntitiesFieldsModel) {
                        graphQLVisitableModel = (ProfileIntroCardModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f11833d = defaultTextWithEntitiesFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m11899a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m11900a());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.a(1, this.f11834e);
                i();
                return flatBufferBuilder.d();
            }

            public final void m11902a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f11834e = mutableFlatBuffer.a(i, 1);
            }
        }

        /* compiled from: fetch_intro_card */
        public class Serializer extends JsonSerializer<BioQueryModel> {
            public final void m11904a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                BioQueryModel bioQueryModel = (BioQueryModel) obj;
                if (bioQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(bioQueryModel.m11905a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    bioQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = bioQueryModel.w_();
                int u_ = bioQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("profile_intro_card");
                    ProfileIntroCardParser.m11911a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(BioQueryModel.class, new Serializer());
            }
        }

        public BioQueryModel() {
            super(1);
        }

        public final void m11908a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m11909a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final ProfileIntroCardModel m11907a() {
            this.f11835d = (ProfileIntroCardModel) super.a(this.f11835d, 0, ProfileIntroCardModel.class);
            return this.f11835d;
        }

        public final int jK_() {
            return 2645995;
        }

        public final GraphQLVisitableModel m11906a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m11907a() != null) {
                ProfileIntroCardModel profileIntroCardModel = (ProfileIntroCardModel) graphQLModelMutatingVisitor.b(m11907a());
                if (m11907a() != profileIntroCardModel) {
                    graphQLVisitableModel = (BioQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11835d = profileIntroCardModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m11905a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m11907a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
