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
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.timeline.protocol.FetchTimelinePromptGraphQLParsers.TimelinePromptApproximateCountFieldsParser;
import com.facebook.timeline.protocol.FetchTimelinePromptGraphQLParsers.TimelinePromptFieldsParser;
import com.facebook.timeline.protocol.FetchTimelinePromptGraphQLParsers.TimelinePromptParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: delay_5 */
public class FetchTimelinePromptGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1723990064)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: delay_5 */
    public final class TimelinePromptApproximateCountFieldsModel extends BaseModel implements GraphQLVisitableModel {
        private int f17824d;

        /* compiled from: delay_5 */
        public final class Builder {
            public int f17823a;
        }

        /* compiled from: delay_5 */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TimelinePromptApproximateCountFieldsModel.class, new Deserializer());
            }

            public Object m26129a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(TimelinePromptApproximateCountFieldsParser.m26150a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object timelinePromptApproximateCountFieldsModel = new TimelinePromptApproximateCountFieldsModel();
                ((BaseModel) timelinePromptApproximateCountFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (timelinePromptApproximateCountFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) timelinePromptApproximateCountFieldsModel).a();
                }
                return timelinePromptApproximateCountFieldsModel;
            }
        }

        /* compiled from: delay_5 */
        public class Serializer extends JsonSerializer<TimelinePromptApproximateCountFieldsModel> {
            public final void m26130a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                TimelinePromptApproximateCountFieldsModel timelinePromptApproximateCountFieldsModel = (TimelinePromptApproximateCountFieldsModel) obj;
                if (timelinePromptApproximateCountFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(timelinePromptApproximateCountFieldsModel.m26132a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    timelinePromptApproximateCountFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                TimelinePromptApproximateCountFieldsParser.m26151a(timelinePromptApproximateCountFieldsModel.w_(), timelinePromptApproximateCountFieldsModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(TimelinePromptApproximateCountFieldsModel.class, new Serializer());
            }
        }

        public TimelinePromptApproximateCountFieldsModel() {
            super(1);
        }

        public TimelinePromptApproximateCountFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(1);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final int m26131a() {
            a(0, 0);
            return this.f17824d;
        }

        public final int jK_() {
            return 382256763;
        }

        public final GraphQLVisitableModel m26133a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m26132a(FlatBufferBuilder flatBufferBuilder) {
            h();
            flatBufferBuilder.c(1);
            flatBufferBuilder.a(0, this.f17824d, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m26134a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f17824d = mutableFlatBuffer.a(i, 0, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -170253822)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: delay_5 */
    public final class TimelinePromptFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private TimelinePromptApproximateCountFieldsModel f17825d;
        @Nullable
        private String f17826e;
        @Nullable
        private String f17827f;

        /* compiled from: delay_5 */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TimelinePromptFieldsModel.class, new Deserializer());
            }

            public Object m26135a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(TimelinePromptFieldsParser.m26152a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object timelinePromptFieldsModel = new TimelinePromptFieldsModel();
                ((BaseModel) timelinePromptFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (timelinePromptFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) timelinePromptFieldsModel).a();
                }
                return timelinePromptFieldsModel;
            }
        }

        /* compiled from: delay_5 */
        public class Serializer extends JsonSerializer<TimelinePromptFieldsModel> {
            public final void m26136a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                TimelinePromptFieldsModel timelinePromptFieldsModel = (TimelinePromptFieldsModel) obj;
                if (timelinePromptFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(timelinePromptFieldsModel.m26138a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    timelinePromptFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                TimelinePromptFieldsParser.m26153a(timelinePromptFieldsModel.w_(), timelinePromptFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(TimelinePromptFieldsModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ TimelinePromptApproximateCountFieldsModel m26140a() {
            return m26137j();
        }

        public TimelinePromptFieldsModel() {
            super(3);
        }

        @Nullable
        private TimelinePromptApproximateCountFieldsModel m26137j() {
            this.f17825d = (TimelinePromptApproximateCountFieldsModel) super.a(this.f17825d, 0, TimelinePromptApproximateCountFieldsModel.class);
            return this.f17825d;
        }

        @Nullable
        public final String m26141b() {
            this.f17826e = super.a(this.f17826e, 1);
            return this.f17826e;
        }

        @Nullable
        public final String m26142c() {
            this.f17827f = super.a(this.f17827f, 2);
            return this.f17827f;
        }

        public final int jK_() {
            return -452726491;
        }

        public final GraphQLVisitableModel m26139a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m26137j() != null) {
                TimelinePromptApproximateCountFieldsModel timelinePromptApproximateCountFieldsModel = (TimelinePromptApproximateCountFieldsModel) graphQLModelMutatingVisitor.b(m26137j());
                if (m26137j() != timelinePromptApproximateCountFieldsModel) {
                    graphQLVisitableModel = (TimelinePromptFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17825d = timelinePromptApproximateCountFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m26138a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m26137j());
            int b = flatBufferBuilder.b(m26141b());
            int b2 = flatBufferBuilder.b(m26142c());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, b2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -229878520)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: delay_5 */
    public final class TimelinePromptModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private TimelinePromptFieldsModel f17828d;

        /* compiled from: delay_5 */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TimelinePromptModel.class, new Deserializer());
            }

            public Object m26143a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = TimelinePromptParser.m26154a(jsonParser);
                Object timelinePromptModel = new TimelinePromptModel();
                ((BaseModel) timelinePromptModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (timelinePromptModel instanceof Postprocessable) {
                    return ((Postprocessable) timelinePromptModel).a();
                }
                return timelinePromptModel;
            }
        }

        /* compiled from: delay_5 */
        public class Serializer extends JsonSerializer<TimelinePromptModel> {
            public final void m26144a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                TimelinePromptModel timelinePromptModel = (TimelinePromptModel) obj;
                if (timelinePromptModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(timelinePromptModel.m26145a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    timelinePromptModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = timelinePromptModel.w_();
                int u_ = timelinePromptModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("timeline_prompt");
                    TimelinePromptFieldsParser.m26153a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(TimelinePromptModel.class, new Serializer());
            }
        }

        public TimelinePromptModel() {
            super(1);
        }

        public final void m26148a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m26149a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final TimelinePromptFieldsModel m26147a() {
            this.f17828d = (TimelinePromptFieldsModel) super.a(this.f17828d, 0, TimelinePromptFieldsModel.class);
            return this.f17828d;
        }

        public final int jK_() {
            return 2645995;
        }

        public final GraphQLVisitableModel m26146a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m26147a() != null) {
                TimelinePromptFieldsModel timelinePromptFieldsModel = (TimelinePromptFieldsModel) graphQLModelMutatingVisitor.b(m26147a());
                if (m26147a() != timelinePromptFieldsModel) {
                    graphQLVisitableModel = (TimelinePromptModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17828d = timelinePromptFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m26145a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m26147a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
