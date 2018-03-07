package com.facebook.heisman.protocol;

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
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.heisman.protocol.ProfileOverlayCategoryGraphQLModels.ProfileOverlayCategoryFieldsModel;
import com.facebook.heisman.protocol.ProfileOverlayPagesByImageOverlayGraphQLParsers.ProfileOverlayPagesByImageOverlayQueryParser;
import com.facebook.heisman.protocol.ProfileOverlayPagesByImageOverlayGraphQLParsers.ProfileOverlayPagesByImageOverlayQueryParser.AssociatedPagesParser;
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

/* compiled from: playbackType */
public class ProfileOverlayPagesByImageOverlayGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1706122111)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: playbackType */
    public final class ProfileOverlayPagesByImageOverlayQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f6136d;
        @Nullable
        private List<AssociatedPagesModel> f6137e;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 219671710)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: playbackType */
        public final class AssociatedPagesModel extends BaseModel implements GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f6134d;
            @Nullable
            private ProfileOverlayCategoryFieldsModel f6135e;

            /* compiled from: playbackType */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AssociatedPagesModel.class, new Deserializer());
                }

                public Object m7998a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AssociatedPagesParser.m8014b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object associatedPagesModel = new AssociatedPagesModel();
                    ((BaseModel) associatedPagesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (associatedPagesModel instanceof Postprocessable) {
                        return ((Postprocessable) associatedPagesModel).a();
                    }
                    return associatedPagesModel;
                }
            }

            /* compiled from: playbackType */
            public class Serializer extends JsonSerializer<AssociatedPagesModel> {
                public final void m7999a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AssociatedPagesModel associatedPagesModel = (AssociatedPagesModel) obj;
                    if (associatedPagesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(associatedPagesModel.m8001a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        associatedPagesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AssociatedPagesParser.m8015b(associatedPagesModel.w_(), associatedPagesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(AssociatedPagesModel.class, new Serializer());
                }
            }

            public AssociatedPagesModel() {
                super(2);
            }

            public final void m8004a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m8005a(String str, Object obj, boolean z) {
            }

            @Nullable
            private GraphQLObjectType m8000j() {
                if (this.b != null && this.f6134d == null) {
                    this.f6134d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f6134d;
            }

            @Nullable
            public final ProfileOverlayCategoryFieldsModel m8003a() {
                this.f6135e = (ProfileOverlayCategoryFieldsModel) super.a(this.f6135e, 1, ProfileOverlayCategoryFieldsModel.class);
                return this.f6135e;
            }

            public final int jK_() {
                return 1355227529;
            }

            public final GraphQLVisitableModel m8002a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m8003a() != null) {
                    ProfileOverlayCategoryFieldsModel profileOverlayCategoryFieldsModel = (ProfileOverlayCategoryFieldsModel) graphQLModelMutatingVisitor.b(m8003a());
                    if (m8003a() != profileOverlayCategoryFieldsModel) {
                        graphQLVisitableModel = (AssociatedPagesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f6135e = profileOverlayCategoryFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m8001a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m8000j());
                int a2 = ModelHelper.a(flatBufferBuilder, m8003a());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: playbackType */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ProfileOverlayPagesByImageOverlayQueryModel.class, new Deserializer());
            }

            public Object m8006a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ProfileOverlayPagesByImageOverlayQueryParser.m8016a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object profileOverlayPagesByImageOverlayQueryModel = new ProfileOverlayPagesByImageOverlayQueryModel();
                ((BaseModel) profileOverlayPagesByImageOverlayQueryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (profileOverlayPagesByImageOverlayQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) profileOverlayPagesByImageOverlayQueryModel).a();
                }
                return profileOverlayPagesByImageOverlayQueryModel;
            }
        }

        /* compiled from: playbackType */
        public class Serializer extends JsonSerializer<ProfileOverlayPagesByImageOverlayQueryModel> {
            public final void m8007a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ProfileOverlayPagesByImageOverlayQueryModel profileOverlayPagesByImageOverlayQueryModel = (ProfileOverlayPagesByImageOverlayQueryModel) obj;
                if (profileOverlayPagesByImageOverlayQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(profileOverlayPagesByImageOverlayQueryModel.m8009a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    profileOverlayPagesByImageOverlayQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = profileOverlayPagesByImageOverlayQueryModel.w_();
                int u_ = profileOverlayPagesByImageOverlayQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("associated_pages");
                    jsonGenerator.d();
                    for (int i = 0; i < mutableFlatBuffer.c(g); i++) {
                        AssociatedPagesParser.m8015b(mutableFlatBuffer, mutableFlatBuffer.m(g, i), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ProfileOverlayPagesByImageOverlayQueryModel.class, new Serializer());
            }
        }

        public ProfileOverlayPagesByImageOverlayQueryModel() {
            super(2);
        }

        public final void m8012a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m8013a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m8008j() {
            if (this.b != null && this.f6136d == null) {
                this.f6136d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f6136d;
        }

        @Nonnull
        public final ImmutableList<AssociatedPagesModel> m8011a() {
            this.f6137e = super.a(this.f6137e, 1, AssociatedPagesModel.class);
            return (ImmutableList) this.f6137e;
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m8010a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m8011a() != null) {
                Builder a = ModelHelper.a(m8011a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (ProfileOverlayPagesByImageOverlayQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f6137e = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m8009a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m8008j());
            int a2 = ModelHelper.a(flatBufferBuilder, m8011a());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
