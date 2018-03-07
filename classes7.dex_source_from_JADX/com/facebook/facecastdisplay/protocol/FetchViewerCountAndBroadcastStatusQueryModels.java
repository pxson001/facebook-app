package com.facebook.facecastdisplay.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.facecastdisplay.protocol.FetchViewerCountAndBroadcastStatusQueryParsers.FetchViewerCountAndBroadcastStatusQueryParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLVideoBroadcastStatus;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
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

/* compiled from: sticker_keyboard_hidden */
public class FetchViewerCountAndBroadcastStatusQueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 2007343956)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: sticker_keyboard_hidden */
    public final class FetchViewerCountAndBroadcastStatusQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private GraphQLVideoBroadcastStatus f3269d;
        @Nullable
        private String f3270e;
        private int f3271f;
        private int f3272g;

        /* compiled from: sticker_keyboard_hidden */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchViewerCountAndBroadcastStatusQueryModel.class, new Deserializer());
            }

            public Object m4030a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FetchViewerCountAndBroadcastStatusQueryParser.m4040a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object fetchViewerCountAndBroadcastStatusQueryModel = new FetchViewerCountAndBroadcastStatusQueryModel();
                ((BaseModel) fetchViewerCountAndBroadcastStatusQueryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (fetchViewerCountAndBroadcastStatusQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchViewerCountAndBroadcastStatusQueryModel).a();
                }
                return fetchViewerCountAndBroadcastStatusQueryModel;
            }
        }

        /* compiled from: sticker_keyboard_hidden */
        public class Serializer extends JsonSerializer<FetchViewerCountAndBroadcastStatusQueryModel> {
            public final void m4031a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchViewerCountAndBroadcastStatusQueryModel fetchViewerCountAndBroadcastStatusQueryModel = (FetchViewerCountAndBroadcastStatusQueryModel) obj;
                if (fetchViewerCountAndBroadcastStatusQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchViewerCountAndBroadcastStatusQueryModel.m4033a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchViewerCountAndBroadcastStatusQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchViewerCountAndBroadcastStatusQueryModel.w_();
                int u_ = fetchViewerCountAndBroadcastStatusQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("broadcast_status");
                    jsonGenerator.b(mutableFlatBuffer.b(u_, 0));
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                int a = mutableFlatBuffer.a(u_, 2, 0);
                if (a != 0) {
                    jsonGenerator.a("live_viewer_count");
                    jsonGenerator.b(a);
                }
                a = mutableFlatBuffer.a(u_, 3, 0);
                if (a != 0) {
                    jsonGenerator.a("live_viewer_count_read_only");
                    jsonGenerator.b(a);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchViewerCountAndBroadcastStatusQueryModel.class, new Serializer());
            }
        }

        public FetchViewerCountAndBroadcastStatusQueryModel() {
            super(4);
        }

        @Nullable
        public final GraphQLVideoBroadcastStatus m4037j() {
            this.f3269d = (GraphQLVideoBroadcastStatus) super.b(this.f3269d, 0, GraphQLVideoBroadcastStatus.class, GraphQLVideoBroadcastStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f3269d;
        }

        @Nullable
        private String m4032m() {
            this.f3270e = super.a(this.f3270e, 1);
            return this.f3270e;
        }

        public final int m4038k() {
            a(0, 2);
            return this.f3271f;
        }

        public final int m4039l() {
            a(0, 3);
            return this.f3272g;
        }

        @Nullable
        public final String m4035a() {
            return m4032m();
        }

        public final int jK_() {
            return 82650203;
        }

        public final GraphQLVisitableModel m4034a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m4033a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = flatBufferBuilder.a(m4037j());
            int b = flatBufferBuilder.b(m4032m());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.a(2, this.f3271f, 0);
            flatBufferBuilder.a(3, this.f3272g, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m4036a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f3271f = mutableFlatBuffer.a(i, 2, 0);
            this.f3272g = mutableFlatBuffer.a(i, 3, 0);
        }
    }
}
