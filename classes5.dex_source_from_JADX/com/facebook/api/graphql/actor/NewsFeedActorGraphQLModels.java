package com.facebook.api.graphql.actor;

import com.facebook.api.graphql.actor.NewsFeedActorGraphQLParsers.DefaultProfileFieldsParser;
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
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
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

/* compiled from: app_section_time_created */
public class NewsFeedActorGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 289552164)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: app_section_time_created */
    public final class DefaultProfileFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f9094d;
        @Nullable
        private String f9095e;
        @Nullable
        private String f9096f;
        @Nullable
        private DefaultImageFieldsModel f9097g;

        /* compiled from: app_section_time_created */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(DefaultProfileFieldsModel.class, new Deserializer());
            }

            public Object m15409a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(DefaultProfileFieldsParser.m15420a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object defaultProfileFieldsModel = new DefaultProfileFieldsModel();
                ((BaseModel) defaultProfileFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (defaultProfileFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) defaultProfileFieldsModel).a();
                }
                return defaultProfileFieldsModel;
            }
        }

        /* compiled from: app_section_time_created */
        public class Serializer extends JsonSerializer<DefaultProfileFieldsModel> {
            public final void m15410a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                DefaultProfileFieldsModel defaultProfileFieldsModel = (DefaultProfileFieldsModel) obj;
                if (defaultProfileFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(defaultProfileFieldsModel.m15415a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    defaultProfileFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                DefaultProfileFieldsParser.m15421a(defaultProfileFieldsModel.w_(), defaultProfileFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(DefaultProfileFieldsModel.class, new Serializer());
            }
        }

        public DefaultProfileFieldsModel() {
            super(4);
        }

        public final void m15418a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m15419a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m15411j() {
            if (this.b != null && this.f9094d == null) {
                this.f9094d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f9094d;
        }

        @Nullable
        private String m15412k() {
            this.f9095e = super.a(this.f9095e, 1);
            return this.f9095e;
        }

        @Nullable
        private String m15413l() {
            this.f9096f = super.a(this.f9096f, 2);
            return this.f9096f;
        }

        @Nullable
        private DefaultImageFieldsModel m15414m() {
            this.f9097g = (DefaultImageFieldsModel) super.a(this.f9097g, 3, DefaultImageFieldsModel.class);
            return this.f9097g;
        }

        @Nullable
        public final String m15417a() {
            return m15412k();
        }

        public final int jK_() {
            return 1355227529;
        }

        public final GraphQLVisitableModel m15416a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15414m() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m15414m());
                if (m15414m() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (DefaultProfileFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9097g = defaultImageFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15415a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m15411j());
            int b = flatBufferBuilder.b(m15412k());
            int b2 = flatBufferBuilder.b(m15413l());
            int a2 = ModelHelper.a(flatBufferBuilder, m15414m());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
