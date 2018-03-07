package com.facebook.composer.privacy.common.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.composer.privacy.common.graphql.FetchProfileDetailsGraphQLParsers.ProfileDetailsParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.ipc.composer.intent.graphql.FetchComposerTargetDataPrivacyScopeInterfaces.ComposerTargetDataPrivacyScopeFields;
import com.facebook.ipc.composer.intent.graphql.FetchComposerTargetDataPrivacyScopeModels.ComposerTargetDataPrivacyScopeFieldsModel;
import com.facebook.ipc.composer.intent.graphql.FetchComposerTargetDataPrivacyScopeParsers.ComposerTargetDataPrivacyScopeFieldsParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: tapped_nearby_location */
public class FetchProfileDetailsGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1393444074)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: tapped_nearby_location */
    public final class ProfileDetailsModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f2069d;
        @Nullable
        private String f2070e;
        @Nullable
        private ComposerTargetDataPrivacyScopeFieldsModel f2071f;

        /* compiled from: tapped_nearby_location */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ProfileDetailsModel.class, new Deserializer());
            }

            public Object m2045a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ProfileDetailsParser.m2055a(jsonParser);
                Object profileDetailsModel = new ProfileDetailsModel();
                ((BaseModel) profileDetailsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (profileDetailsModel instanceof Postprocessable) {
                    return ((Postprocessable) profileDetailsModel).a();
                }
                return profileDetailsModel;
            }
        }

        /* compiled from: tapped_nearby_location */
        public class Serializer extends JsonSerializer<ProfileDetailsModel> {
            public final void m2046a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ProfileDetailsModel profileDetailsModel = (ProfileDetailsModel) obj;
                if (profileDetailsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(profileDetailsModel.m2050a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    profileDetailsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = profileDetailsModel.w_();
                int u_ = profileDetailsModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                int g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("posted_item_privacy_scope");
                    ComposerTargetDataPrivacyScopeFieldsParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ProfileDetailsModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ ComposerTargetDataPrivacyScopeFields m2052a() {
            return m2049l();
        }

        public ProfileDetailsModel() {
            super(3);
        }

        public final void m2053a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m2054a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m2047j() {
            if (this.b != null && this.f2069d == null) {
                this.f2069d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f2069d;
        }

        @Nullable
        private String m2048k() {
            this.f2070e = super.a(this.f2070e, 1);
            return this.f2070e;
        }

        @Nullable
        private ComposerTargetDataPrivacyScopeFieldsModel m2049l() {
            this.f2071f = (ComposerTargetDataPrivacyScopeFieldsModel) super.a(this.f2071f, 2, ComposerTargetDataPrivacyScopeFieldsModel.class);
            return this.f2071f;
        }

        public final int jK_() {
            return 1355227529;
        }

        public final GraphQLVisitableModel m2051a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2049l() != null) {
                ComposerTargetDataPrivacyScopeFieldsModel composerTargetDataPrivacyScopeFieldsModel = (ComposerTargetDataPrivacyScopeFieldsModel) graphQLModelMutatingVisitor.b(m2049l());
                if (m2049l() != composerTargetDataPrivacyScopeFieldsModel) {
                    graphQLVisitableModel = (ProfileDetailsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f2071f = composerTargetDataPrivacyScopeFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2050a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m2047j());
            int b = flatBufferBuilder.b(m2048k());
            int a2 = ModelHelper.a(flatBufferBuilder, m2049l());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
