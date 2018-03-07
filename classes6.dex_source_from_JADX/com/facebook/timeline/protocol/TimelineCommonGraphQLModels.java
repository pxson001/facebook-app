package com.facebook.timeline.protocol;

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
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageUriFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultImageUriFieldsParser;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.timeline.protocol.TimelineCommonGraphQLParsers.TimelinePhotoUriQueryParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: db_bootstrap_entities_last_fetch_ms */
public class TimelineCommonGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 214320372)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: db_bootstrap_entities_last_fetch_ms */
    public final class TimelinePhotoUriQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f17856d;
        @Nullable
        private DefaultImageUriFieldsModel f17857e;

        /* compiled from: db_bootstrap_entities_last_fetch_ms */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TimelinePhotoUriQueryModel.class, new Deserializer());
            }

            public Object m26323a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = TimelinePhotoUriQueryParser.m26331a(jsonParser);
                Object timelinePhotoUriQueryModel = new TimelinePhotoUriQueryModel();
                ((BaseModel) timelinePhotoUriQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (timelinePhotoUriQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) timelinePhotoUriQueryModel).a();
                }
                return timelinePhotoUriQueryModel;
            }
        }

        /* compiled from: db_bootstrap_entities_last_fetch_ms */
        public class Serializer extends JsonSerializer<TimelinePhotoUriQueryModel> {
            public final void m26324a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                TimelinePhotoUriQueryModel timelinePhotoUriQueryModel = (TimelinePhotoUriQueryModel) obj;
                if (timelinePhotoUriQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(timelinePhotoUriQueryModel.m26326a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    timelinePhotoUriQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = timelinePhotoUriQueryModel.w_();
                int u_ = timelinePhotoUriQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("image");
                    DefaultImageUriFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(TimelinePhotoUriQueryModel.class, new Serializer());
            }
        }

        public TimelinePhotoUriQueryModel() {
            super(2);
        }

        public final void m26329a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m26330a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m26325j() {
            if (this.b != null && this.f17856d == null) {
                this.f17856d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f17856d;
        }

        @Nullable
        public final DefaultImageUriFieldsModel m26327a() {
            this.f17857e = (DefaultImageUriFieldsModel) super.a(this.f17857e, 1, DefaultImageUriFieldsModel.class);
            return this.f17857e;
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m26328a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m26327a() != null) {
                DefaultImageUriFieldsModel defaultImageUriFieldsModel = (DefaultImageUriFieldsModel) graphQLModelMutatingVisitor.b(m26327a());
                if (m26327a() != defaultImageUriFieldsModel) {
                    graphQLVisitableModel = (TimelinePhotoUriQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17857e = defaultImageUriFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m26326a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m26325j());
            int a2 = ModelHelper.a(flatBufferBuilder, m26327a());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
