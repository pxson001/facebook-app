package com.facebook.photos.data.protocol;

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
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.photos.data.protocol.PhotosLocationTagSuggestionMutationsParsers.AcceptPlaceSuggestionMutationParser;
import com.facebook.photos.data.protocol.PhotosLocationTagSuggestionMutationsParsers.PlaceSuggestionMutationPhotoFieldsParser;
import com.facebook.photos.data.protocol.PhotosLocationTagSuggestionMutationsParsers.PlaceSuggestionMutationPhotoFieldsParser.ExplicitPlaceParser;
import com.facebook.photos.data.protocol.PhotosLocationTagSuggestionMutationsParsers.RejectPlaceSuggestionMutationParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: suggested_composition */
public class PhotosLocationTagSuggestionMutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1257208465)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: suggested_composition */
    public final class AcceptPlaceSuggestionMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private PlaceSuggestionMutationPhotoFieldsModel f3562d;

        /* compiled from: suggested_composition */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AcceptPlaceSuggestionMutationModel.class, new Deserializer());
            }

            public Object m4795a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = AcceptPlaceSuggestionMutationParser.m4821a(jsonParser);
                Object acceptPlaceSuggestionMutationModel = new AcceptPlaceSuggestionMutationModel();
                ((BaseModel) acceptPlaceSuggestionMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (acceptPlaceSuggestionMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) acceptPlaceSuggestionMutationModel).a();
                }
                return acceptPlaceSuggestionMutationModel;
            }
        }

        /* compiled from: suggested_composition */
        public class Serializer extends JsonSerializer<AcceptPlaceSuggestionMutationModel> {
            public final void m4796a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                AcceptPlaceSuggestionMutationModel acceptPlaceSuggestionMutationModel = (AcceptPlaceSuggestionMutationModel) obj;
                if (acceptPlaceSuggestionMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(acceptPlaceSuggestionMutationModel.m4798a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    acceptPlaceSuggestionMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = acceptPlaceSuggestionMutationModel.w_();
                int u_ = acceptPlaceSuggestionMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("photo");
                    PlaceSuggestionMutationPhotoFieldsParser.m4825a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(AcceptPlaceSuggestionMutationModel.class, new Serializer());
            }
        }

        public AcceptPlaceSuggestionMutationModel() {
            super(1);
        }

        @Nullable
        private PlaceSuggestionMutationPhotoFieldsModel m4797a() {
            this.f3562d = (PlaceSuggestionMutationPhotoFieldsModel) super.a(this.f3562d, 0, PlaceSuggestionMutationPhotoFieldsModel.class);
            return this.f3562d;
        }

        public final int jK_() {
            return 1091574229;
        }

        public final GraphQLVisitableModel m4799a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m4797a() != null) {
                PlaceSuggestionMutationPhotoFieldsModel placeSuggestionMutationPhotoFieldsModel = (PlaceSuggestionMutationPhotoFieldsModel) graphQLModelMutatingVisitor.b(m4797a());
                if (m4797a() != placeSuggestionMutationPhotoFieldsModel) {
                    graphQLVisitableModel = (AcceptPlaceSuggestionMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3562d = placeSuggestionMutationPhotoFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m4798a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m4797a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -880135352)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: suggested_composition */
    public final class PlaceSuggestionMutationPhotoFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private ExplicitPlaceModel f3565d;
        @Nullable
        private String f3566e;

        /* compiled from: suggested_composition */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PlaceSuggestionMutationPhotoFieldsModel.class, new Deserializer());
            }

            public Object m4800a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PlaceSuggestionMutationPhotoFieldsParser.m4824a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object placeSuggestionMutationPhotoFieldsModel = new PlaceSuggestionMutationPhotoFieldsModel();
                ((BaseModel) placeSuggestionMutationPhotoFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (placeSuggestionMutationPhotoFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) placeSuggestionMutationPhotoFieldsModel).a();
                }
                return placeSuggestionMutationPhotoFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1787905591)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: suggested_composition */
        public final class ExplicitPlaceModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f3563d;
            @Nullable
            private String f3564e;

            /* compiled from: suggested_composition */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ExplicitPlaceModel.class, new Deserializer());
                }

                public Object m4801a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ExplicitPlaceParser.m4822a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object explicitPlaceModel = new ExplicitPlaceModel();
                    ((BaseModel) explicitPlaceModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (explicitPlaceModel instanceof Postprocessable) {
                        return ((Postprocessable) explicitPlaceModel).a();
                    }
                    return explicitPlaceModel;
                }
            }

            /* compiled from: suggested_composition */
            public class Serializer extends JsonSerializer<ExplicitPlaceModel> {
                public final void m4802a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ExplicitPlaceModel explicitPlaceModel = (ExplicitPlaceModel) obj;
                    if (explicitPlaceModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(explicitPlaceModel.m4805a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        explicitPlaceModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ExplicitPlaceParser.m4823a(explicitPlaceModel.w_(), explicitPlaceModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ExplicitPlaceModel.class, new Serializer());
                }
            }

            public ExplicitPlaceModel() {
                super(2);
            }

            public final void m4808a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m4809a(String str, Object obj, boolean z) {
            }

            @Nullable
            private GraphQLObjectType m4803j() {
                if (this.b != null && this.f3563d == null) {
                    this.f3563d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f3563d;
            }

            @Nullable
            private String m4804k() {
                this.f3564e = super.a(this.f3564e, 1);
                return this.f3564e;
            }

            @Nullable
            public final String m4807a() {
                return m4804k();
            }

            public final int jK_() {
                return 77195495;
            }

            public final GraphQLVisitableModel m4806a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m4805a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m4803j());
                int b = flatBufferBuilder.b(m4804k());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: suggested_composition */
        public class Serializer extends JsonSerializer<PlaceSuggestionMutationPhotoFieldsModel> {
            public final void m4810a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PlaceSuggestionMutationPhotoFieldsModel placeSuggestionMutationPhotoFieldsModel = (PlaceSuggestionMutationPhotoFieldsModel) obj;
                if (placeSuggestionMutationPhotoFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(placeSuggestionMutationPhotoFieldsModel.m4813a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    placeSuggestionMutationPhotoFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PlaceSuggestionMutationPhotoFieldsParser.m4825a(placeSuggestionMutationPhotoFieldsModel.w_(), placeSuggestionMutationPhotoFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PlaceSuggestionMutationPhotoFieldsModel.class, new Serializer());
            }
        }

        public PlaceSuggestionMutationPhotoFieldsModel() {
            super(2);
        }

        @Nullable
        private ExplicitPlaceModel m4811j() {
            this.f3565d = (ExplicitPlaceModel) super.a(this.f3565d, 0, ExplicitPlaceModel.class);
            return this.f3565d;
        }

        @Nullable
        private String m4812k() {
            this.f3566e = super.a(this.f3566e, 1);
            return this.f3566e;
        }

        @Nullable
        public final String m4815a() {
            return m4812k();
        }

        public final int jK_() {
            return 77090322;
        }

        public final GraphQLVisitableModel m4814a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m4811j() != null) {
                ExplicitPlaceModel explicitPlaceModel = (ExplicitPlaceModel) graphQLModelMutatingVisitor.b(m4811j());
                if (m4811j() != explicitPlaceModel) {
                    graphQLVisitableModel = (PlaceSuggestionMutationPhotoFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3565d = explicitPlaceModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m4813a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m4811j());
            int b = flatBufferBuilder.b(m4812k());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1257208465)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: suggested_composition */
    public final class RejectPlaceSuggestionMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private PlaceSuggestionMutationPhotoFieldsModel f3567d;

        /* compiled from: suggested_composition */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(RejectPlaceSuggestionMutationModel.class, new Deserializer());
            }

            public Object m4816a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = RejectPlaceSuggestionMutationParser.m4826a(jsonParser);
                Object rejectPlaceSuggestionMutationModel = new RejectPlaceSuggestionMutationModel();
                ((BaseModel) rejectPlaceSuggestionMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (rejectPlaceSuggestionMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) rejectPlaceSuggestionMutationModel).a();
                }
                return rejectPlaceSuggestionMutationModel;
            }
        }

        /* compiled from: suggested_composition */
        public class Serializer extends JsonSerializer<RejectPlaceSuggestionMutationModel> {
            public final void m4817a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                RejectPlaceSuggestionMutationModel rejectPlaceSuggestionMutationModel = (RejectPlaceSuggestionMutationModel) obj;
                if (rejectPlaceSuggestionMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(rejectPlaceSuggestionMutationModel.m4819a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    rejectPlaceSuggestionMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = rejectPlaceSuggestionMutationModel.w_();
                int u_ = rejectPlaceSuggestionMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("photo");
                    PlaceSuggestionMutationPhotoFieldsParser.m4825a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(RejectPlaceSuggestionMutationModel.class, new Serializer());
            }
        }

        public RejectPlaceSuggestionMutationModel() {
            super(1);
        }

        @Nullable
        private PlaceSuggestionMutationPhotoFieldsModel m4818a() {
            this.f3567d = (PlaceSuggestionMutationPhotoFieldsModel) super.a(this.f3567d, 0, PlaceSuggestionMutationPhotoFieldsModel.class);
            return this.f3567d;
        }

        public final int jK_() {
            return -2007009748;
        }

        public final GraphQLVisitableModel m4820a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m4818a() != null) {
                PlaceSuggestionMutationPhotoFieldsModel placeSuggestionMutationPhotoFieldsModel = (PlaceSuggestionMutationPhotoFieldsModel) graphQLModelMutatingVisitor.b(m4818a());
                if (m4818a() != placeSuggestionMutationPhotoFieldsModel) {
                    graphQLVisitableModel = (RejectPlaceSuggestionMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3567d = placeSuggestionMutationPhotoFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m4819a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m4818a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
