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
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.timeline.protocol.TimelineVisitedMutationParsers.TimelineVisitedMutationParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: data_received */
public class TimelineVisitedMutationModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: data_received */
    public final class TimelineVisitedMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f17893d;

        /* compiled from: data_received */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TimelineVisitedMutationModel.class, new Deserializer());
            }

            public Object m26420a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = TimelineVisitedMutationParser.m26425a(jsonParser);
                Object timelineVisitedMutationModel = new TimelineVisitedMutationModel();
                ((BaseModel) timelineVisitedMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (timelineVisitedMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) timelineVisitedMutationModel).a();
                }
                return timelineVisitedMutationModel;
            }
        }

        /* compiled from: data_received */
        public class Serializer extends JsonSerializer<TimelineVisitedMutationModel> {
            public final void m26421a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                TimelineVisitedMutationModel timelineVisitedMutationModel = (TimelineVisitedMutationModel) obj;
                if (timelineVisitedMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(timelineVisitedMutationModel.m26423a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    timelineVisitedMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = timelineVisitedMutationModel.w_();
                int u_ = timelineVisitedMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(TimelineVisitedMutationModel.class, new Serializer());
            }
        }

        public TimelineVisitedMutationModel() {
            super(1);
        }

        @Nullable
        private String m26422a() {
            this.f17893d = super.a(this.f17893d, 0);
            return this.f17893d;
        }

        public final int jK_() {
            return -1594681324;
        }

        public final GraphQLVisitableModel m26424a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m26423a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m26422a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
