package com.facebook.facecastdisplay.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.facecastdisplay.protocol.FetchMomentsOfInterestQueryParsers.FetchMomentsOfInterestQueryParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: sticker_removed */
public class FetchMomentsOfInterestQueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 2133334777)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: sticker_removed */
    public final class FetchMomentsOfInterestQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private String f3252d;
        @Nullable
        private List<Integer> f3253e;

        /* compiled from: sticker_removed */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchMomentsOfInterestQueryModel.class, new Deserializer());
            }

            public Object m3998a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchMomentsOfInterestQueryParser.m4005a(jsonParser);
                Object fetchMomentsOfInterestQueryModel = new FetchMomentsOfInterestQueryModel();
                ((BaseModel) fetchMomentsOfInterestQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchMomentsOfInterestQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchMomentsOfInterestQueryModel).a();
                }
                return fetchMomentsOfInterestQueryModel;
            }
        }

        /* compiled from: sticker_removed */
        public class Serializer extends JsonSerializer<FetchMomentsOfInterestQueryModel> {
            public final void m3999a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchMomentsOfInterestQueryModel fetchMomentsOfInterestQueryModel = (FetchMomentsOfInterestQueryModel) obj;
                if (fetchMomentsOfInterestQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchMomentsOfInterestQueryModel.m4001a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchMomentsOfInterestQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchMomentsOfInterestQueryModel.w_();
                int u_ = fetchMomentsOfInterestQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("moments_of_interest");
                    SerializerHelpers.b(mutableFlatBuffer.d(u_, 1), jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchMomentsOfInterestQueryModel.class, new Serializer());
            }
        }

        public FetchMomentsOfInterestQueryModel() {
            super(2);
        }

        @Nullable
        private String m4000k() {
            this.f3252d = super.a(this.f3252d, 0);
            return this.f3252d;
        }

        @Nonnull
        public final ImmutableList<Integer> m4004j() {
            this.f3253e = super.b(this.f3253e, 1);
            return (ImmutableList) this.f3253e;
        }

        @Nullable
        public final String m4003a() {
            return m4000k();
        }

        public final int jK_() {
            return 82650203;
        }

        public final GraphQLVisitableModel m4002a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m4001a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m4000k());
            int a = flatBufferBuilder.a(m4004j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
