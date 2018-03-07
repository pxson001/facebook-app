package com.facebook.messaging.events.graphql;

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
import com.facebook.messaging.events.graphql.EventRemindersMutationParsers.LightweightEventCreateParser;
import com.facebook.messaging.events.graphql.EventRemindersMutationParsers.LightweightEventDeleteParser;
import com.facebook.messaging.events.graphql.EventRemindersMutationParsers.LightweightEventRsvpParser;
import com.facebook.messaging.events.graphql.EventRemindersMutationParsers.LightweightEventUpdateParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: sms_guest_ */
public class EventRemindersMutationModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: sms_guest_ */
    public final class LightweightEventCreateModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f2374d;

        /* compiled from: sms_guest_ */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(LightweightEventCreateModel.class, new Deserializer());
            }

            public Object m2214a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = LightweightEventCreateParser.m2234a(jsonParser);
                Object lightweightEventCreateModel = new LightweightEventCreateModel();
                ((BaseModel) lightweightEventCreateModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (lightweightEventCreateModel instanceof Postprocessable) {
                    return ((Postprocessable) lightweightEventCreateModel).a();
                }
                return lightweightEventCreateModel;
            }
        }

        /* compiled from: sms_guest_ */
        public class Serializer extends JsonSerializer<LightweightEventCreateModel> {
            public final void m2215a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                LightweightEventCreateModel lightweightEventCreateModel = (LightweightEventCreateModel) obj;
                if (lightweightEventCreateModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(lightweightEventCreateModel.m2217a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    lightweightEventCreateModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = lightweightEventCreateModel.w_();
                int u_ = lightweightEventCreateModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(LightweightEventCreateModel.class, new Serializer());
            }
        }

        public LightweightEventCreateModel() {
            super(1);
        }

        @Nullable
        private String m2216a() {
            this.f2374d = super.a(this.f2374d, 0);
            return this.f2374d;
        }

        public final int jK_() {
            return 133845125;
        }

        public final GraphQLVisitableModel m2218a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m2217a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m2216a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: sms_guest_ */
    public final class LightweightEventDeleteModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f2375d;

        /* compiled from: sms_guest_ */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(LightweightEventDeleteModel.class, new Deserializer());
            }

            public Object m2219a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = LightweightEventDeleteParser.m2235a(jsonParser);
                Object lightweightEventDeleteModel = new LightweightEventDeleteModel();
                ((BaseModel) lightweightEventDeleteModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (lightweightEventDeleteModel instanceof Postprocessable) {
                    return ((Postprocessable) lightweightEventDeleteModel).a();
                }
                return lightweightEventDeleteModel;
            }
        }

        /* compiled from: sms_guest_ */
        public class Serializer extends JsonSerializer<LightweightEventDeleteModel> {
            public final void m2220a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                LightweightEventDeleteModel lightweightEventDeleteModel = (LightweightEventDeleteModel) obj;
                if (lightweightEventDeleteModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(lightweightEventDeleteModel.m2222a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    lightweightEventDeleteModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = lightweightEventDeleteModel.w_();
                int u_ = lightweightEventDeleteModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(LightweightEventDeleteModel.class, new Serializer());
            }
        }

        public LightweightEventDeleteModel() {
            super(1);
        }

        @Nullable
        private String m2221a() {
            this.f2375d = super.a(this.f2375d, 0);
            return this.f2375d;
        }

        public final int jK_() {
            return 55285750;
        }

        public final GraphQLVisitableModel m2223a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m2222a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m2221a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: sms_guest_ */
    public final class LightweightEventRsvpModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f2376d;

        /* compiled from: sms_guest_ */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(LightweightEventRsvpModel.class, new Deserializer());
            }

            public Object m2224a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = LightweightEventRsvpParser.m2236a(jsonParser);
                Object lightweightEventRsvpModel = new LightweightEventRsvpModel();
                ((BaseModel) lightweightEventRsvpModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (lightweightEventRsvpModel instanceof Postprocessable) {
                    return ((Postprocessable) lightweightEventRsvpModel).a();
                }
                return lightweightEventRsvpModel;
            }
        }

        /* compiled from: sms_guest_ */
        public class Serializer extends JsonSerializer<LightweightEventRsvpModel> {
            public final void m2225a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                LightweightEventRsvpModel lightweightEventRsvpModel = (LightweightEventRsvpModel) obj;
                if (lightweightEventRsvpModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(lightweightEventRsvpModel.m2227a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    lightweightEventRsvpModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = lightweightEventRsvpModel.w_();
                int u_ = lightweightEventRsvpModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(LightweightEventRsvpModel.class, new Serializer());
            }
        }

        public LightweightEventRsvpModel() {
            super(1);
        }

        @Nullable
        private String m2226a() {
            this.f2376d = super.a(this.f2376d, 0);
            return this.f2376d;
        }

        public final int jK_() {
            return 2011283430;
        }

        public final GraphQLVisitableModel m2228a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m2227a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m2226a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: sms_guest_ */
    public final class LightweightEventUpdateModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f2377d;

        /* compiled from: sms_guest_ */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(LightweightEventUpdateModel.class, new Deserializer());
            }

            public Object m2229a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = LightweightEventUpdateParser.m2237a(jsonParser);
                Object lightweightEventUpdateModel = new LightweightEventUpdateModel();
                ((BaseModel) lightweightEventUpdateModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (lightweightEventUpdateModel instanceof Postprocessable) {
                    return ((Postprocessable) lightweightEventUpdateModel).a();
                }
                return lightweightEventUpdateModel;
            }
        }

        /* compiled from: sms_guest_ */
        public class Serializer extends JsonSerializer<LightweightEventUpdateModel> {
            public final void m2230a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                LightweightEventUpdateModel lightweightEventUpdateModel = (LightweightEventUpdateModel) obj;
                if (lightweightEventUpdateModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(lightweightEventUpdateModel.m2232a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    lightweightEventUpdateModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = lightweightEventUpdateModel.w_();
                int u_ = lightweightEventUpdateModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(LightweightEventUpdateModel.class, new Serializer());
            }
        }

        public LightweightEventUpdateModel() {
            super(1);
        }

        @Nullable
        private String m2231a() {
            this.f2377d = super.a(this.f2377d, 0);
            return this.f2377d;
        }

        public final int jK_() {
            return 1305314584;
        }

        public final GraphQLVisitableModel m2233a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m2232a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m2231a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
