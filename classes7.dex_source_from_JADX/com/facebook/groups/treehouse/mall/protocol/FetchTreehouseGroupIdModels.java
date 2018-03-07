package com.facebook.groups.treehouse.mall.protocol;

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
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.groups.treehouse.mall.protocol.FetchTreehouseGroupIdParsers.FetchTreehouseGroupIdParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: profile_nav_tile_click */
public class FetchTreehouseGroupIdModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1801334754)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: profile_nav_tile_click */
    public final class FetchTreehouseGroupIdModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private String f5897d;

        /* compiled from: profile_nav_tile_click */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchTreehouseGroupIdModel.class, new Deserializer());
            }

            public Object m7495a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchTreehouseGroupIdParser.m7503a(jsonParser);
                Object fetchTreehouseGroupIdModel = new FetchTreehouseGroupIdModel();
                ((BaseModel) fetchTreehouseGroupIdModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchTreehouseGroupIdModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchTreehouseGroupIdModel).a();
                }
                return fetchTreehouseGroupIdModel;
            }
        }

        /* compiled from: profile_nav_tile_click */
        public class Serializer extends JsonSerializer<FetchTreehouseGroupIdModel> {
            public final void m7496a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchTreehouseGroupIdModel fetchTreehouseGroupIdModel = (FetchTreehouseGroupIdModel) obj;
                if (fetchTreehouseGroupIdModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchTreehouseGroupIdModel.m7498a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchTreehouseGroupIdModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchTreehouseGroupIdModel.w_();
                int u_ = fetchTreehouseGroupIdModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchTreehouseGroupIdModel.class, new Serializer());
            }
        }

        public FetchTreehouseGroupIdModel() {
            super(1);
        }

        public final void m7501a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m7502a(String str, Object obj, boolean z) {
        }

        @Nullable
        private String m7497j() {
            this.f5897d = super.a(this.f5897d, 0);
            return this.f5897d;
        }

        @Nullable
        public final String m7500a() {
            return m7497j();
        }

        public final int jK_() {
            return 69076575;
        }

        public final GraphQLVisitableModel m7499a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m7498a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m7497j());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
