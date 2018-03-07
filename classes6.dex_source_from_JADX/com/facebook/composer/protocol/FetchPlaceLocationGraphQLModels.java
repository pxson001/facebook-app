package com.facebook.composer.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.composer.protocol.FetchPlaceLocationGraphQLParsers.FetchPlaceLocationQueryParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultLocationFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultLocationFieldsParser;
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

/* compiled from: place_address */
public class FetchPlaceLocationGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -249302027)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: place_address */
    public final class FetchPlaceLocationQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f7907d;
        @Nullable
        private String f7908e;
        @Nullable
        private DefaultLocationFieldsModel f7909f;
        @Nullable
        private String f7910g;

        /* compiled from: place_address */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchPlaceLocationQueryModel.class, new Deserializer());
            }

            public Object m11439a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchPlaceLocationQueryParser.m11450a(jsonParser);
                Object fetchPlaceLocationQueryModel = new FetchPlaceLocationQueryModel();
                ((BaseModel) fetchPlaceLocationQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchPlaceLocationQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchPlaceLocationQueryModel).a();
                }
                return fetchPlaceLocationQueryModel;
            }
        }

        /* compiled from: place_address */
        public class Serializer extends JsonSerializer<FetchPlaceLocationQueryModel> {
            public final void m11440a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchPlaceLocationQueryModel fetchPlaceLocationQueryModel = (FetchPlaceLocationQueryModel) obj;
                if (fetchPlaceLocationQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchPlaceLocationQueryModel.m11442a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchPlaceLocationQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchPlaceLocationQueryModel.w_();
                int u_ = fetchPlaceLocationQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                int g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("location");
                    DefaultLocationFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 3) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 3));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchPlaceLocationQueryModel.class, new Serializer());
            }
        }

        public FetchPlaceLocationQueryModel() {
            super(4);
        }

        public final void m11445a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m11446a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m11441m() {
            if (this.b != null && this.f7907d == null) {
                this.f7907d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f7907d;
        }

        @Nullable
        public final String m11447j() {
            this.f7908e = super.a(this.f7908e, 1);
            return this.f7908e;
        }

        @Nullable
        public final DefaultLocationFieldsModel m11448k() {
            this.f7909f = (DefaultLocationFieldsModel) super.a(this.f7909f, 2, DefaultLocationFieldsModel.class);
            return this.f7909f;
        }

        @Nullable
        public final String m11449l() {
            this.f7910g = super.a(this.f7910g, 3);
            return this.f7910g;
        }

        @Nullable
        public final String m11444a() {
            return m11447j();
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m11443a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m11448k() != null) {
                DefaultLocationFieldsModel defaultLocationFieldsModel = (DefaultLocationFieldsModel) graphQLModelMutatingVisitor.b(m11448k());
                if (m11448k() != defaultLocationFieldsModel) {
                    graphQLVisitableModel = (FetchPlaceLocationQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f7909f = defaultLocationFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m11442a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m11441m());
            int b = flatBufferBuilder.b(m11447j());
            int a2 = ModelHelper.a(flatBufferBuilder, m11448k());
            int b2 = flatBufferBuilder.b(m11449l());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, b2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
