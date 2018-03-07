package com.facebook.api.graphql.fetchstories;

import com.facebook.api.graphql.fetchstories.FetchInvalidStoriesGraphQlParsers.FetchInvalidStoriesParser;
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

/* compiled from: android_suggest_edits */
public class FetchInvalidStoriesGraphQlModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1787905591)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: android_suggest_edits */
    public final class FetchInvalidStoriesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f9682d;
        @Nullable
        private String f9683e;

        /* compiled from: android_suggest_edits */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchInvalidStoriesModel.class, new Deserializer());
            }

            public Object m16675a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchInvalidStoriesParser.m16684a(jsonParser);
                Object fetchInvalidStoriesModel = new FetchInvalidStoriesModel();
                ((BaseModel) fetchInvalidStoriesModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchInvalidStoriesModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchInvalidStoriesModel).a();
                }
                return fetchInvalidStoriesModel;
            }
        }

        /* compiled from: android_suggest_edits */
        public class Serializer extends JsonSerializer<FetchInvalidStoriesModel> {
            public final void m16676a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchInvalidStoriesModel fetchInvalidStoriesModel = (FetchInvalidStoriesModel) obj;
                if (fetchInvalidStoriesModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchInvalidStoriesModel.m16678a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchInvalidStoriesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchInvalidStoriesModel.w_();
                int u_ = fetchInvalidStoriesModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchInvalidStoriesModel.class, new Serializer());
            }
        }

        public FetchInvalidStoriesModel() {
            super(2);
        }

        public final void m16681a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m16682a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m16677k() {
            if (this.b != null && this.f9682d == null) {
                this.f9682d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f9682d;
        }

        @Nullable
        public final String m16683j() {
            this.f9683e = super.a(this.f9683e, 1);
            return this.f9683e;
        }

        @Nullable
        public final String m16680a() {
            return m16683j();
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m16679a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m16678a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16677k());
            int b = flatBufferBuilder.b(m16683j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
