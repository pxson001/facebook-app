package com.facebook.messaging.graphql.threads;

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
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.messaging.graphql.threads.AppVisibilityQueriesParsers.AttributionVisibilityParser;
import com.facebook.messaging.graphql.threads.AppVisibilityQueriesParsers.AttributionVisibilityParser.MessengerAppAttributionVisibilityParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: video_downloaded_size */
public class AppVisibilityQueriesModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 2034445643)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: video_downloaded_size */
    public final class AttributionVisibilityModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f766d;
        @Nullable
        private MessengerAppAttributionVisibilityModel f767e;

        /* compiled from: video_downloaded_size */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AttributionVisibilityModel.class, new Deserializer());
            }

            public Object m816a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = AttributionVisibilityParser.m834a(jsonParser);
                Object attributionVisibilityModel = new AttributionVisibilityModel();
                ((BaseModel) attributionVisibilityModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (attributionVisibilityModel instanceof Postprocessable) {
                    return ((Postprocessable) attributionVisibilityModel).a();
                }
                return attributionVisibilityModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 660454262)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: video_downloaded_size */
        public final class MessengerAppAttributionVisibilityModel extends BaseModel implements GraphQLVisitableModel {
            private boolean f763d;
            private boolean f764e;
            private boolean f765f;

            /* compiled from: video_downloaded_size */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MessengerAppAttributionVisibilityModel.class, new Deserializer());
                }

                public Object m817a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MessengerAppAttributionVisibilityParser.m832a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object messengerAppAttributionVisibilityModel = new MessengerAppAttributionVisibilityModel();
                    ((BaseModel) messengerAppAttributionVisibilityModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (messengerAppAttributionVisibilityModel instanceof Postprocessable) {
                        return ((Postprocessable) messengerAppAttributionVisibilityModel).a();
                    }
                    return messengerAppAttributionVisibilityModel;
                }
            }

            /* compiled from: video_downloaded_size */
            public class Serializer extends JsonSerializer<MessengerAppAttributionVisibilityModel> {
                public final void m818a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MessengerAppAttributionVisibilityModel messengerAppAttributionVisibilityModel = (MessengerAppAttributionVisibilityModel) obj;
                    if (messengerAppAttributionVisibilityModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(messengerAppAttributionVisibilityModel.m819a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        messengerAppAttributionVisibilityModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MessengerAppAttributionVisibilityParser.m833a(messengerAppAttributionVisibilityModel.w_(), messengerAppAttributionVisibilityModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(MessengerAppAttributionVisibilityModel.class, new Serializer());
                }
            }

            public MessengerAppAttributionVisibilityModel() {
                super(3);
            }

            public final boolean m822a() {
                a(0, 0);
                return this.f763d;
            }

            public final boolean m823j() {
                a(0, 1);
                return this.f764e;
            }

            public final boolean m824k() {
                a(0, 2);
                return this.f765f;
            }

            public final int jK_() {
                return -871385245;
            }

            public final GraphQLVisitableModel m820a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m819a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(3);
                flatBufferBuilder.a(0, this.f763d);
                flatBufferBuilder.a(1, this.f764e);
                flatBufferBuilder.a(2, this.f765f);
                i();
                return flatBufferBuilder.d();
            }

            public final void m821a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f763d = mutableFlatBuffer.a(i, 0);
                this.f764e = mutableFlatBuffer.a(i, 1);
                this.f765f = mutableFlatBuffer.a(i, 2);
            }
        }

        /* compiled from: video_downloaded_size */
        public class Serializer extends JsonSerializer<AttributionVisibilityModel> {
            public final void m825a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                AttributionVisibilityModel attributionVisibilityModel = (AttributionVisibilityModel) obj;
                if (attributionVisibilityModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(attributionVisibilityModel.m827a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    attributionVisibilityModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = attributionVisibilityModel.w_();
                int u_ = attributionVisibilityModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("messenger_app_attribution_visibility");
                    MessengerAppAttributionVisibilityParser.m833a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(AttributionVisibilityModel.class, new Serializer());
            }
        }

        public AttributionVisibilityModel() {
            super(2);
        }

        public final void m830a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m831a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m826j() {
            if (this.b != null && this.f766d == null) {
                this.f766d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f766d;
        }

        @Nullable
        public final MessengerAppAttributionVisibilityModel m829a() {
            this.f767e = (MessengerAppAttributionVisibilityModel) super.a(this.f767e, 1, MessengerAppAttributionVisibilityModel.class);
            return this.f767e;
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m828a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m829a() != null) {
                MessengerAppAttributionVisibilityModel messengerAppAttributionVisibilityModel = (MessengerAppAttributionVisibilityModel) graphQLModelMutatingVisitor.b(m829a());
                if (m829a() != messengerAppAttributionVisibilityModel) {
                    graphQLVisitableModel = (AttributionVisibilityModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f767e = messengerAppAttributionVisibilityModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m827a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m826j());
            int a2 = ModelHelper.a(flatBufferBuilder, m829a());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
