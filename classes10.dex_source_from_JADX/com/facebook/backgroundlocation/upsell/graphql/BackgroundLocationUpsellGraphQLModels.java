package com.facebook.backgroundlocation.upsell.graphql;

import com.facebook.backgroundlocation.upsell.graphql.BackgroundLocationUpsellGraphQLParsers.BackgroundLocationUpsellProfileParser;
import com.facebook.backgroundlocation.upsell.graphql.BackgroundLocationUpsellGraphQLParsers.BackgroundLocationUpsellProfileParser.ProfilePictureParser;
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
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultNameFieldsModel;
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

/* compiled from: desired_time_between_updates_ms */
public class BackgroundLocationUpsellGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 631668578)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: desired_time_between_updates_ms */
    public final class BackgroundLocationUpsellProfileModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private String f15073d;
        @Nullable
        private ProfilePictureModel f15074e;
        @Nullable
        private String f15075f;
        @Nullable
        private DefaultNameFieldsModel f15076g;

        /* compiled from: desired_time_between_updates_ms */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(BackgroundLocationUpsellProfileModel.class, new Deserializer());
            }

            public Object m15574a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(BackgroundLocationUpsellProfileParser.m15595b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object backgroundLocationUpsellProfileModel = new BackgroundLocationUpsellProfileModel();
                ((BaseModel) backgroundLocationUpsellProfileModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (backgroundLocationUpsellProfileModel instanceof Postprocessable) {
                    return ((Postprocessable) backgroundLocationUpsellProfileModel).a();
                }
                return backgroundLocationUpsellProfileModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: desired_time_between_updates_ms */
        public final class ProfilePictureModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f15072d;

            /* compiled from: desired_time_between_updates_ms */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ProfilePictureModel.class, new Deserializer());
                }

                public Object m15575a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ProfilePictureParser.m15591a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object profilePictureModel = new ProfilePictureModel();
                    ((BaseModel) profilePictureModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (profilePictureModel instanceof Postprocessable) {
                        return ((Postprocessable) profilePictureModel).a();
                    }
                    return profilePictureModel;
                }
            }

            /* compiled from: desired_time_between_updates_ms */
            public class Serializer extends JsonSerializer<ProfilePictureModel> {
                public final void m15576a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ProfilePictureModel profilePictureModel = (ProfilePictureModel) obj;
                    if (profilePictureModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(profilePictureModel.m15577a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        profilePictureModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ProfilePictureParser.m15592a(profilePictureModel.w_(), profilePictureModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ProfilePictureModel.class, new Serializer());
                }
            }

            public ProfilePictureModel() {
                super(1);
            }

            @Nullable
            public final String m15579a() {
                this.f15072d = super.a(this.f15072d, 0);
                return this.f15072d;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m15578a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m15577a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m15579a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: desired_time_between_updates_ms */
        public class Serializer extends JsonSerializer<BackgroundLocationUpsellProfileModel> {
            public final void m15580a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                BackgroundLocationUpsellProfileModel backgroundLocationUpsellProfileModel = (BackgroundLocationUpsellProfileModel) obj;
                if (backgroundLocationUpsellProfileModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(backgroundLocationUpsellProfileModel.m15583a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    backgroundLocationUpsellProfileModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                BackgroundLocationUpsellProfileParser.m15596b(backgroundLocationUpsellProfileModel.w_(), backgroundLocationUpsellProfileModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(BackgroundLocationUpsellProfileModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ ProfilePictureModel m15589c() {
            return m15581j();
        }

        public BackgroundLocationUpsellProfileModel() {
            super(4);
        }

        public final void m15586a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m15587a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final String m15588b() {
            this.f15073d = super.a(this.f15073d, 0);
            return this.f15073d;
        }

        @Nullable
        private ProfilePictureModel m15581j() {
            this.f15074e = (ProfilePictureModel) super.a(this.f15074e, 1, ProfilePictureModel.class);
            return this.f15074e;
        }

        @Nullable
        public final String m15590d() {
            this.f15075f = super.a(this.f15075f, 2);
            return this.f15075f;
        }

        @Nullable
        private DefaultNameFieldsModel m15582k() {
            this.f15076g = (DefaultNameFieldsModel) super.a(this.f15076g, 3, DefaultNameFieldsModel.class);
            return this.f15076g;
        }

        @Nullable
        public final String m15585a() {
            return m15588b();
        }

        public final int jK_() {
            return 2645995;
        }

        public final GraphQLVisitableModel m15584a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15581j() != null) {
                ProfilePictureModel profilePictureModel = (ProfilePictureModel) graphQLModelMutatingVisitor.b(m15581j());
                if (m15581j() != profilePictureModel) {
                    graphQLVisitableModel = (BackgroundLocationUpsellProfileModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f15074e = profilePictureModel;
                }
            }
            if (m15582k() != null) {
                DefaultNameFieldsModel defaultNameFieldsModel = (DefaultNameFieldsModel) graphQLModelMutatingVisitor.b(m15582k());
                if (m15582k() != defaultNameFieldsModel) {
                    graphQLVisitableModel = (BackgroundLocationUpsellProfileModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f15076g = defaultNameFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15583a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m15588b());
            int a = ModelHelper.a(flatBufferBuilder, m15581j());
            int b2 = flatBufferBuilder.b(m15590d());
            int a2 = ModelHelper.a(flatBufferBuilder, m15582k());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
