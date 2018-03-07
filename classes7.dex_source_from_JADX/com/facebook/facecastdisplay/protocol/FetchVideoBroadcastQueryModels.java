package com.facebook.facecastdisplay.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.facecastdisplay.protocol.FetchVideoBroadcastQueryParsers.VideoBroadcastFragmentParser;
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

/* compiled from: sticker_picker_opened */
public class FetchVideoBroadcastQueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 308005118)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: sticker_picker_opened */
    public final class VideoBroadcastFragmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        private int f3254d;
        private int f3255e;
        @Nullable
        private GraphQLVideoBroadcastStatus f3256f;
        private int f3257g;
        private int f3258h;
        @Nullable
        private String f3259i;
        private boolean f3260j;
        private int f3261k;
        private int f3262l;
        @Nullable
        private String f3263m;
        @Nullable
        private String f3264n;
        private int f3265o;
        @Nullable
        private String f3266p;
        @Nullable
        private String f3267q;
        @Nullable
        private String f3268r;

        /* compiled from: sticker_picker_opened */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(VideoBroadcastFragmentModel.class, new Deserializer());
            }

            public Object m4007a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(VideoBroadcastFragmentParser.m4025a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object videoBroadcastFragmentModel = new VideoBroadcastFragmentModel();
                ((BaseModel) videoBroadcastFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (videoBroadcastFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) videoBroadcastFragmentModel).a();
                }
                return videoBroadcastFragmentModel;
            }
        }

        /* compiled from: sticker_picker_opened */
        public class Serializer extends JsonSerializer<VideoBroadcastFragmentModel> {
            public final void m4008a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                VideoBroadcastFragmentModel videoBroadcastFragmentModel = (VideoBroadcastFragmentModel) obj;
                if (videoBroadcastFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(videoBroadcastFragmentModel.m4009a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    videoBroadcastFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                VideoBroadcastFragmentParser.m4026a(videoBroadcastFragmentModel.w_(), videoBroadcastFragmentModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(VideoBroadcastFragmentModel.class, new Serializer());
            }
        }

        public VideoBroadcastFragmentModel() {
            super(15);
        }

        public final int m4013b() {
            a(0, 0);
            return this.f3254d;
        }

        public final int m4014c() {
            a(0, 1);
            return this.f3255e;
        }

        @Nullable
        public final GraphQLVideoBroadcastStatus m4015d() {
            this.f3256f = (GraphQLVideoBroadcastStatus) super.b(this.f3256f, 2, GraphQLVideoBroadcastStatus.class, GraphQLVideoBroadcastStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f3256f;
        }

        public final int fk_() {
            a(0, 3);
            return this.f3257g;
        }

        public final int m4016g() {
            a(0, 4);
            return this.f3258h;
        }

        @Nullable
        public final String m4021n() {
            this.f3259i = super.a(this.f3259i, 5);
            return this.f3259i;
        }

        public final boolean m4022o() {
            a(0, 6);
            return this.f3260j;
        }

        public final int m4023p() {
            a(0, 7);
            return this.f3261k;
        }

        public final int m4024q() {
            a(1, 0);
            return this.f3262l;
        }

        @Nullable
        public final String fl_() {
            this.f3263m = super.a(this.f3263m, 9);
            return this.f3263m;
        }

        @Nullable
        public final String fm_() {
            this.f3264n = super.a(this.f3264n, 10);
            return this.f3264n;
        }

        public final int m4017j() {
            a(1, 3);
            return this.f3265o;
        }

        @Nullable
        public final String m4018k() {
            this.f3266p = super.a(this.f3266p, 12);
            return this.f3266p;
        }

        @Nullable
        public final String m4019l() {
            this.f3267q = super.a(this.f3267q, 13);
            return this.f3267q;
        }

        @Nullable
        public final String m4020m() {
            this.f3268r = super.a(this.f3268r, 14);
            return this.f3268r;
        }

        @Nullable
        public final String m4011a() {
            return m4021n();
        }

        public final int jK_() {
            return 82650203;
        }

        public final GraphQLVisitableModel m4010a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m4009a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = flatBufferBuilder.a(m4015d());
            int b = flatBufferBuilder.b(m4021n());
            int b2 = flatBufferBuilder.b(fl_());
            int b3 = flatBufferBuilder.b(fm_());
            int b4 = flatBufferBuilder.b(m4018k());
            int b5 = flatBufferBuilder.b(m4019l());
            int b6 = flatBufferBuilder.b(m4020m());
            flatBufferBuilder.c(15);
            flatBufferBuilder.a(0, this.f3254d, 0);
            flatBufferBuilder.a(1, this.f3255e, 0);
            flatBufferBuilder.b(2, a);
            flatBufferBuilder.a(3, this.f3257g, 0);
            flatBufferBuilder.a(4, this.f3258h, 0);
            flatBufferBuilder.b(5, b);
            flatBufferBuilder.a(6, this.f3260j);
            flatBufferBuilder.a(7, this.f3261k, 0);
            flatBufferBuilder.a(8, this.f3262l, 0);
            flatBufferBuilder.b(9, b2);
            flatBufferBuilder.b(10, b3);
            flatBufferBuilder.a(11, this.f3265o, 0);
            flatBufferBuilder.b(12, b4);
            flatBufferBuilder.b(13, b5);
            flatBufferBuilder.b(14, b6);
            i();
            return flatBufferBuilder.d();
        }

        public final void m4012a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f3254d = mutableFlatBuffer.a(i, 0, 0);
            this.f3255e = mutableFlatBuffer.a(i, 1, 0);
            this.f3257g = mutableFlatBuffer.a(i, 3, 0);
            this.f3258h = mutableFlatBuffer.a(i, 4, 0);
            this.f3260j = mutableFlatBuffer.a(i, 6);
            this.f3261k = mutableFlatBuffer.a(i, 7, 0);
            this.f3262l = mutableFlatBuffer.a(i, 8, 0);
            this.f3265o = mutableFlatBuffer.a(i, 11, 0);
        }
    }
}
