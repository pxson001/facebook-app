package com.facebook.pages.common.protocol.graphql;

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
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.pages.common.protocol.graphql.FetchMoreTabNuxInformationParsers.FetchMoreTabNuxInformationQueryParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;

/* compiled from: setScheduleTime */
public class FetchMoreTabNuxInformationModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 649874177)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: setScheduleTime */
    public final class FetchMoreTabNuxInformationQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        private boolean f1753d;

        /* compiled from: setScheduleTime */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchMoreTabNuxInformationQueryModel.class, new Deserializer());
            }

            public Object m2592a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchMoreTabNuxInformationQueryParser.m2599a(jsonParser);
                Object fetchMoreTabNuxInformationQueryModel = new FetchMoreTabNuxInformationQueryModel();
                ((BaseModel) fetchMoreTabNuxInformationQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchMoreTabNuxInformationQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchMoreTabNuxInformationQueryModel).a();
                }
                return fetchMoreTabNuxInformationQueryModel;
            }
        }

        /* compiled from: setScheduleTime */
        public class Serializer extends JsonSerializer<FetchMoreTabNuxInformationQueryModel> {
            public final void m2593a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchMoreTabNuxInformationQueryModel fetchMoreTabNuxInformationQueryModel = (FetchMoreTabNuxInformationQueryModel) obj;
                if (fetchMoreTabNuxInformationQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchMoreTabNuxInformationQueryModel.m2594a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchMoreTabNuxInformationQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchMoreTabNuxInformationQueryModel.w_();
                int u_ = fetchMoreTabNuxInformationQueryModel.u_();
                jsonGenerator.f();
                boolean a = mutableFlatBuffer.a(u_, 0);
                if (a) {
                    jsonGenerator.a("should_ask_for_menu");
                    jsonGenerator.a(a);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchMoreTabNuxInformationQueryModel.class, new Serializer());
            }
        }

        public FetchMoreTabNuxInformationQueryModel() {
            super(1);
        }

        public final void m2597a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m2598a(String str, Object obj, boolean z) {
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m2595a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m2594a(FlatBufferBuilder flatBufferBuilder) {
            h();
            flatBufferBuilder.c(1);
            flatBufferBuilder.a(0, this.f1753d);
            i();
            return flatBufferBuilder.d();
        }

        public final void m2596a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f1753d = mutableFlatBuffer.a(i, 0);
        }
    }
}
