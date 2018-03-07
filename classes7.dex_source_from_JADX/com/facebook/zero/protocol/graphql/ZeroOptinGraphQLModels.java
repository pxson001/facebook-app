package com.facebook.zero.protocol.graphql;

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
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.zero.protocol.graphql.ZeroOptinGraphQLParsers.FetchZeroOptinQueryParser;
import com.facebook.zero.protocol.graphql.ZeroOptinGraphQLParsers.ZeroDefaultOptinFieldsParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: yWave */
public class ZeroOptinGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -823989020)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: yWave */
    public final class FetchZeroOptinQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ZeroDefaultOptinFieldsModel f169d;

        /* compiled from: yWave */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchZeroOptinQueryModel.class, new Deserializer());
            }

            public Object m128a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchZeroOptinQueryParser.m162a(jsonParser);
                Object fetchZeroOptinQueryModel = new FetchZeroOptinQueryModel();
                ((BaseModel) fetchZeroOptinQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchZeroOptinQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchZeroOptinQueryModel).a();
                }
                return fetchZeroOptinQueryModel;
            }
        }

        /* compiled from: yWave */
        public class Serializer extends JsonSerializer<FetchZeroOptinQueryModel> {
            public final void m129a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchZeroOptinQueryModel fetchZeroOptinQueryModel = (FetchZeroOptinQueryModel) obj;
                if (fetchZeroOptinQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchZeroOptinQueryModel.m130a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchZeroOptinQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchZeroOptinQueryModel.w_();
                int u_ = fetchZeroOptinQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("zero_optin");
                    ZeroDefaultOptinFieldsParser.m164a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchZeroOptinQueryModel.class, new Serializer());
            }
        }

        public FetchZeroOptinQueryModel() {
            super(1);
        }

        @Nullable
        public final ZeroDefaultOptinFieldsModel m132a() {
            this.f169d = (ZeroDefaultOptinFieldsModel) super.a(this.f169d, 0, ZeroDefaultOptinFieldsModel.class);
            return this.f169d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m131a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m132a() != null) {
                ZeroDefaultOptinFieldsModel zeroDefaultOptinFieldsModel = (ZeroDefaultOptinFieldsModel) graphQLModelMutatingVisitor.b(m132a());
                if (m132a() != zeroDefaultOptinFieldsModel) {
                    graphQLVisitableModel = (FetchZeroOptinQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f169d = zeroDefaultOptinFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m130a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m132a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 287420427)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: yWave */
    public final class ZeroDefaultOptinFieldsModel extends BaseModel implements GraphQLVisitableModel {
        private int f170A;
        @Nullable
        private String f171d;
        @Nullable
        private String f172e;
        @Nullable
        private String f173f;
        @Nullable
        private String f174g;
        private int f175h;
        @Nullable
        private String f176i;
        @Nullable
        private List<String> f177j;
        @Nullable
        private String f178k;
        @Nullable
        private String f179l;
        @Nullable
        private String f180m;
        @Nullable
        private String f181n;
        @Nullable
        private String f182o;
        @Nullable
        private String f183p;
        @Nullable
        private String f184q;
        @Nullable
        private String f185r;
        @Nullable
        private String f186s;
        private boolean f187t;
        @Nullable
        private String f188u;
        @Nullable
        private String f189v;
        private boolean f190w;
        @Nullable
        private String f191x;
        @Nullable
        private String f192y;
        @Nullable
        private String f193z;

        /* compiled from: yWave */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ZeroDefaultOptinFieldsModel.class, new Deserializer());
            }

            public Object m133a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ZeroDefaultOptinFieldsParser.m163a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object zeroDefaultOptinFieldsModel = new ZeroDefaultOptinFieldsModel();
                ((BaseModel) zeroDefaultOptinFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (zeroDefaultOptinFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) zeroDefaultOptinFieldsModel).a();
                }
                return zeroDefaultOptinFieldsModel;
            }
        }

        /* compiled from: yWave */
        public class Serializer extends JsonSerializer<ZeroDefaultOptinFieldsModel> {
            public final void m134a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ZeroDefaultOptinFieldsModel zeroDefaultOptinFieldsModel = (ZeroDefaultOptinFieldsModel) obj;
                if (zeroDefaultOptinFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(zeroDefaultOptinFieldsModel.m141a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    zeroDefaultOptinFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ZeroDefaultOptinFieldsParser.m164a(zeroDefaultOptinFieldsModel.w_(), zeroDefaultOptinFieldsModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(ZeroDefaultOptinFieldsModel.class, new Serializer());
            }
        }

        public ZeroDefaultOptinFieldsModel() {
            super(24);
        }

        @Nullable
        public final String m143a() {
            this.f171d = super.a(this.f171d, 0);
            return this.f171d;
        }

        @Nullable
        public final String m145j() {
            this.f172e = super.a(this.f172e, 1);
            return this.f172e;
        }

        @Nullable
        public final String m146k() {
            this.f173f = super.a(this.f173f, 2);
            return this.f173f;
        }

        @Nullable
        public final String m147l() {
            this.f174g = super.a(this.f174g, 3);
            return this.f174g;
        }

        public final int m148m() {
            a(0, 4);
            return this.f175h;
        }

        @Nullable
        public final String m149n() {
            this.f176i = super.a(this.f176i, 5);
            return this.f176i;
        }

        @Nonnull
        public final ImmutableList<String> m150o() {
            this.f177j = super.a(this.f177j, 6);
            return (ImmutableList) this.f177j;
        }

        @Nullable
        public final String m151p() {
            this.f178k = super.a(this.f178k, 7);
            return this.f178k;
        }

        @Nullable
        public final String m152q() {
            this.f179l = super.a(this.f179l, 8);
            return this.f179l;
        }

        @Nullable
        public final String m153r() {
            this.f180m = super.a(this.f180m, 9);
            return this.f180m;
        }

        @Nullable
        public final String m154s() {
            this.f181n = super.a(this.f181n, 10);
            return this.f181n;
        }

        @Nullable
        public final String m155t() {
            this.f182o = super.a(this.f182o, 11);
            return this.f182o;
        }

        @Nullable
        public final String m156u() {
            this.f183p = super.a(this.f183p, 12);
            return this.f183p;
        }

        @Nullable
        public final String m157v() {
            this.f184q = super.a(this.f184q, 13);
            return this.f184q;
        }

        @Nullable
        public final String m158w() {
            this.f185r = super.a(this.f185r, 14);
            return this.f185r;
        }

        @Nullable
        public final String m159x() {
            this.f186s = super.a(this.f186s, 15);
            return this.f186s;
        }

        public final boolean m160y() {
            a(2, 0);
            return this.f187t;
        }

        @Nullable
        public final String m161z() {
            this.f188u = super.a(this.f188u, 17);
            return this.f188u;
        }

        @Nullable
        public final String m135A() {
            this.f189v = super.a(this.f189v, 18);
            return this.f189v;
        }

        public final boolean m136B() {
            a(2, 3);
            return this.f190w;
        }

        @Nullable
        public final String m137C() {
            this.f191x = super.a(this.f191x, 20);
            return this.f191x;
        }

        @Nullable
        public final String m138D() {
            this.f192y = super.a(this.f192y, 21);
            return this.f192y;
        }

        @Nullable
        public final String m139E() {
            this.f193z = super.a(this.f193z, 22);
            return this.f193z;
        }

        public final int m140F() {
            a(2, 7);
            return this.f170A;
        }

        public final int jK_() {
            return -1567444929;
        }

        public final GraphQLVisitableModel m142a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m141a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m143a());
            int b2 = flatBufferBuilder.b(m145j());
            int b3 = flatBufferBuilder.b(m146k());
            int b4 = flatBufferBuilder.b(m147l());
            int b5 = flatBufferBuilder.b(m149n());
            int c = flatBufferBuilder.c(m150o());
            int b6 = flatBufferBuilder.b(m151p());
            int b7 = flatBufferBuilder.b(m152q());
            int b8 = flatBufferBuilder.b(m153r());
            int b9 = flatBufferBuilder.b(m154s());
            int b10 = flatBufferBuilder.b(m155t());
            int b11 = flatBufferBuilder.b(m156u());
            int b12 = flatBufferBuilder.b(m157v());
            int b13 = flatBufferBuilder.b(m158w());
            int b14 = flatBufferBuilder.b(m159x());
            int b15 = flatBufferBuilder.b(m161z());
            int b16 = flatBufferBuilder.b(m135A());
            int b17 = flatBufferBuilder.b(m137C());
            int b18 = flatBufferBuilder.b(m138D());
            int b19 = flatBufferBuilder.b(m139E());
            flatBufferBuilder.c(24);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.b(2, b3);
            flatBufferBuilder.b(3, b4);
            flatBufferBuilder.a(4, this.f175h, 0);
            flatBufferBuilder.b(5, b5);
            flatBufferBuilder.b(6, c);
            flatBufferBuilder.b(7, b6);
            flatBufferBuilder.b(8, b7);
            flatBufferBuilder.b(9, b8);
            flatBufferBuilder.b(10, b9);
            flatBufferBuilder.b(11, b10);
            flatBufferBuilder.b(12, b11);
            flatBufferBuilder.b(13, b12);
            flatBufferBuilder.b(14, b13);
            flatBufferBuilder.b(15, b14);
            flatBufferBuilder.a(16, this.f187t);
            flatBufferBuilder.b(17, b15);
            flatBufferBuilder.b(18, b16);
            flatBufferBuilder.a(19, this.f190w);
            flatBufferBuilder.b(20, b17);
            flatBufferBuilder.b(21, b18);
            flatBufferBuilder.b(22, b19);
            flatBufferBuilder.a(23, this.f170A, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m144a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f175h = mutableFlatBuffer.a(i, 4, 0);
            this.f187t = mutableFlatBuffer.a(i, 16);
            this.f190w = mutableFlatBuffer.a(i, 19);
            this.f170A = mutableFlatBuffer.a(i, 23, 0);
        }
    }
}
