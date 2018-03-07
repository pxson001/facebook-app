package com.facebook.feed.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.feed.protocol.NewsFeedMutationsParsers.PlaceReviewXoutParser;
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

/* compiled from: method/ubersearch.get */
public class NewsFeedMutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: method/ubersearch.get */
    public final class PlaceReviewXoutModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f10351d;

        /* compiled from: method/ubersearch.get */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PlaceReviewXoutModel.class, new Deserializer());
            }

            public Object m16392a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PlaceReviewXoutParser.m16397a(jsonParser);
                Object placeReviewXoutModel = new PlaceReviewXoutModel();
                ((BaseModel) placeReviewXoutModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (placeReviewXoutModel instanceof Postprocessable) {
                    return ((Postprocessable) placeReviewXoutModel).a();
                }
                return placeReviewXoutModel;
            }
        }

        /* compiled from: method/ubersearch.get */
        public class Serializer extends JsonSerializer<PlaceReviewXoutModel> {
            public final void m16393a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PlaceReviewXoutModel placeReviewXoutModel = (PlaceReviewXoutModel) obj;
                if (placeReviewXoutModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(placeReviewXoutModel.m16395a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    placeReviewXoutModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = placeReviewXoutModel.w_();
                int u_ = placeReviewXoutModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PlaceReviewXoutModel.class, new Serializer());
            }
        }

        public PlaceReviewXoutModel() {
            super(1);
        }

        @Nullable
        private String m16394a() {
            this.f10351d = super.a(this.f10351d, 0);
            return this.f10351d;
        }

        public final int jK_() {
            return 1256225208;
        }

        public final GraphQLVisitableModel m16396a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m16395a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m16394a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
