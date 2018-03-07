package com.facebook.crowdsourcing.protocol.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.crowdsourcing.protocol.graphql.PlaceQuestionMutationsParsers.PlaceQuestionAnswerSubmitParser;
import com.facebook.crowdsourcing.protocol.graphql.PlaceQuestionMutationsParsers.PlaceQuestionSkipParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
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

/* compiled from: tag_scroll_View */
public class PlaceQuestionMutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: tag_scroll_View */
    public final class PlaceQuestionAnswerSubmitModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f2380d;

        /* compiled from: tag_scroll_View */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PlaceQuestionAnswerSubmitModel.class, new Deserializer());
            }

            public Object m2487a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PlaceQuestionAnswerSubmitParser.m2497a(jsonParser);
                Object placeQuestionAnswerSubmitModel = new PlaceQuestionAnswerSubmitModel();
                ((BaseModel) placeQuestionAnswerSubmitModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (placeQuestionAnswerSubmitModel instanceof Postprocessable) {
                    return ((Postprocessable) placeQuestionAnswerSubmitModel).a();
                }
                return placeQuestionAnswerSubmitModel;
            }
        }

        /* compiled from: tag_scroll_View */
        public class Serializer extends JsonSerializer<PlaceQuestionAnswerSubmitModel> {
            public final void m2488a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PlaceQuestionAnswerSubmitModel placeQuestionAnswerSubmitModel = (PlaceQuestionAnswerSubmitModel) obj;
                if (placeQuestionAnswerSubmitModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(placeQuestionAnswerSubmitModel.m2490a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    placeQuestionAnswerSubmitModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = placeQuestionAnswerSubmitModel.w_();
                int u_ = placeQuestionAnswerSubmitModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PlaceQuestionAnswerSubmitModel.class, new Serializer());
            }
        }

        public PlaceQuestionAnswerSubmitModel() {
            super(1);
        }

        @Nullable
        private String m2489a() {
            this.f2380d = super.a(this.f2380d, 0);
            return this.f2380d;
        }

        public final int jK_() {
            return 49514250;
        }

        public final GraphQLVisitableModel m2491a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m2490a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m2489a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: tag_scroll_View */
    public final class PlaceQuestionSkipModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f2381d;

        /* compiled from: tag_scroll_View */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PlaceQuestionSkipModel.class, new Deserializer());
            }

            public Object m2492a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PlaceQuestionSkipParser.m2498a(jsonParser);
                Object placeQuestionSkipModel = new PlaceQuestionSkipModel();
                ((BaseModel) placeQuestionSkipModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (placeQuestionSkipModel instanceof Postprocessable) {
                    return ((Postprocessable) placeQuestionSkipModel).a();
                }
                return placeQuestionSkipModel;
            }
        }

        /* compiled from: tag_scroll_View */
        public class Serializer extends JsonSerializer<PlaceQuestionSkipModel> {
            public final void m2493a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PlaceQuestionSkipModel placeQuestionSkipModel = (PlaceQuestionSkipModel) obj;
                if (placeQuestionSkipModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(placeQuestionSkipModel.m2495a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    placeQuestionSkipModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = placeQuestionSkipModel.w_();
                int u_ = placeQuestionSkipModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PlaceQuestionSkipModel.class, new Serializer());
            }
        }

        public PlaceQuestionSkipModel() {
            super(1);
        }

        @Nullable
        private String m2494a() {
            this.f2381d = super.a(this.f2381d, 0);
            return this.f2381d;
        }

        public final int jK_() {
            return 347044705;
        }

        public final GraphQLVisitableModel m2496a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m2495a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m2494a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
