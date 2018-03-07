package com.facebook.video.chromecast.graphql;

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
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.video.chromecast.graphql.FBVideoCastPayloadQueryParsers.FBVideoCastPayloadQueryParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: long_press_on_photo */
public class FBVideoCastPayloadQueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -721607857)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: long_press_on_photo */
    public final class FBVideoCastPayloadQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        private boolean f9695d;
        @Nullable
        private String f9696e;
        @Nullable
        private String f9697f;

        /* compiled from: long_press_on_photo */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FBVideoCastPayloadQueryModel.class, new Deserializer());
            }

            public Object m11419a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FBVideoCastPayloadQueryParser.m11427a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object fBVideoCastPayloadQueryModel = new FBVideoCastPayloadQueryModel();
                ((BaseModel) fBVideoCastPayloadQueryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (fBVideoCastPayloadQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fBVideoCastPayloadQueryModel).a();
                }
                return fBVideoCastPayloadQueryModel;
            }
        }

        /* compiled from: long_press_on_photo */
        public class Serializer extends JsonSerializer<FBVideoCastPayloadQueryModel> {
            public final void m11420a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FBVideoCastPayloadQueryModel fBVideoCastPayloadQueryModel = (FBVideoCastPayloadQueryModel) obj;
                if (fBVideoCastPayloadQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fBVideoCastPayloadQueryModel.m11422a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fBVideoCastPayloadQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fBVideoCastPayloadQueryModel.w_();
                int u_ = fBVideoCastPayloadQueryModel.u_();
                jsonGenerator.f();
                boolean a = mutableFlatBuffer.a(u_, 0);
                if (a) {
                    jsonGenerator.a("can_cast_video");
                    jsonGenerator.a(a);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("video_cast_payload");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 2));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FBVideoCastPayloadQueryModel.class, new Serializer());
            }
        }

        public FBVideoCastPayloadQueryModel() {
            super(3);
        }

        @Nullable
        private String m11421k() {
            this.f9696e = super.a(this.f9696e, 1);
            return this.f9696e;
        }

        @Nullable
        public final String m11426j() {
            this.f9697f = super.a(this.f9697f, 2);
            return this.f9697f;
        }

        @Nullable
        public final String m11424a() {
            return m11421k();
        }

        public final int jK_() {
            return 82650203;
        }

        public final GraphQLVisitableModel m11423a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m11422a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m11421k());
            int b2 = flatBufferBuilder.b(m11426j());
            flatBufferBuilder.c(3);
            flatBufferBuilder.a(0, this.f9695d);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, b2);
            i();
            return flatBufferBuilder.d();
        }

        public final void m11425a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f9695d = mutableFlatBuffer.a(i, 0);
        }
    }
}
