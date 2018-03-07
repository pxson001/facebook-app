package com.facebook.controller.connectioncontroller.pageinfo;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.controller.connectioncontroller.pageinfo.ConnectionControllerPageInfoGraphQLParsers.ConnectionControllerPageInfoGraphQLParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
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

/* compiled from: optin_interstitial_back_pressed */
public class ConnectionControllerPageInfoGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 921619519)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: optin_interstitial_back_pressed */
    public final class ConnectionControllerPageInfoGraphQLModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f8644d;
        private boolean f8645e;
        private boolean f8646f;
        @Nullable
        private String f8647g;

        /* compiled from: optin_interstitial_back_pressed */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ConnectionControllerPageInfoGraphQLModel.class, new Deserializer());
            }

            public Object m12436a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ConnectionControllerPageInfoGraphQLParser.m12445a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object connectionControllerPageInfoGraphQLModel = new ConnectionControllerPageInfoGraphQLModel();
                ((BaseModel) connectionControllerPageInfoGraphQLModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (connectionControllerPageInfoGraphQLModel instanceof Postprocessable) {
                    return ((Postprocessable) connectionControllerPageInfoGraphQLModel).a();
                }
                return connectionControllerPageInfoGraphQLModel;
            }
        }

        /* compiled from: optin_interstitial_back_pressed */
        public class Serializer extends JsonSerializer<ConnectionControllerPageInfoGraphQLModel> {
            public final void m12437a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ConnectionControllerPageInfoGraphQLModel connectionControllerPageInfoGraphQLModel = (ConnectionControllerPageInfoGraphQLModel) obj;
                if (connectionControllerPageInfoGraphQLModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(connectionControllerPageInfoGraphQLModel.m12438a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    connectionControllerPageInfoGraphQLModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ConnectionControllerPageInfoGraphQLParser.m12446a(connectionControllerPageInfoGraphQLModel.w_(), connectionControllerPageInfoGraphQLModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(ConnectionControllerPageInfoGraphQLModel.class, new Serializer());
            }
        }

        public ConnectionControllerPageInfoGraphQLModel() {
            super(4);
        }

        @Nullable
        public final String m12440a() {
            this.f8644d = super.a(this.f8644d, 0);
            return this.f8644d;
        }

        public final boolean m12442b() {
            a(0, 1);
            return this.f8645e;
        }

        public final boolean m12443c() {
            a(0, 2);
            return this.f8646f;
        }

        @Nullable
        public final String m12444d() {
            this.f8647g = super.a(this.f8647g, 3);
            return this.f8647g;
        }

        public final int jK_() {
            return 923779069;
        }

        public final GraphQLVisitableModel m12439a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m12438a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m12440a());
            int b2 = flatBufferBuilder.b(m12444d());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.a(1, this.f8645e);
            flatBufferBuilder.a(2, this.f8646f);
            flatBufferBuilder.b(3, b2);
            i();
            return flatBufferBuilder.d();
        }

        public final void m12441a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f8645e = mutableFlatBuffer.a(i, 1);
            this.f8646f = mutableFlatBuffer.a(i, 2);
        }
    }
}
