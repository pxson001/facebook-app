package com.facebook.richdocument.model.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.FBFullImageFragmentModel;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLDocumentNativeAdType;
import com.facebook.graphql.enums.GraphQLDocumentVideoAutoplayStyle;
import com.facebook.graphql.enums.GraphQLDocumentVideoControlStyle;
import com.facebook.graphql.enums.GraphQLDocumentVideoLoopingStyle;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.FBVideoModel;
import com.facebook.richdocument.model.graphql.RichDocumentNativeAdsGraphqlParsers.RichDocumentHTMLNativeAdFragmentParser;
import com.facebook.richdocument.model.graphql.RichDocumentNativeAdsGraphqlParsers.RichDocumentHTMLNativeAdFragmentParser.FallbackNativeAdParser;
import com.facebook.richdocument.model.graphql.RichDocumentNativeAdsGraphqlParsers.RichDocumentNativeAdFragmentParser;
import com.facebook.richdocument.model.graphql.RichDocumentNativeAdsGraphqlParsers.RichDocumentNativeAdFragmentParser.NativeTypedAdObjectParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: photo_in_collection */
public class RichDocumentNativeAdsGraphqlModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1108275729)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: photo_in_collection */
    public final class RichDocumentHTMLNativeAdFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private FallbackNativeAdModel f6349d;

        /* compiled from: photo_in_collection */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(RichDocumentHTMLNativeAdFragmentModel.class, new Deserializer());
            }

            public Object m6697a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = RichDocumentHTMLNativeAdFragmentParser.m6763a(jsonParser);
                Object richDocumentHTMLNativeAdFragmentModel = new RichDocumentHTMLNativeAdFragmentModel();
                ((BaseModel) richDocumentHTMLNativeAdFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (richDocumentHTMLNativeAdFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) richDocumentHTMLNativeAdFragmentModel).a();
                }
                return richDocumentHTMLNativeAdFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1956063304)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: photo_in_collection */
        public final class FallbackNativeAdModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private GraphQLObjectType f6326d;
            @Nullable
            private FBFullImageFragmentModel f6327e;
            @Nullable
            private String f6328f;
            @Nullable
            private String f6329g;
            @Nullable
            private String f6330h;
            @Nullable
            private String f6331i;
            @Nullable
            private String f6332j;
            @Nullable
            private String f6333k;
            @Nullable
            private String f6334l;
            @Nullable
            private FBFullImageFragmentModel f6335m;
            @Nullable
            private FBFullImageFragmentModel f6336n;
            @Nullable
            private String f6337o;
            @Nullable
            private GraphQLDocumentNativeAdType f6338p;
            @Nullable
            private String f6339q;
            @Nullable
            private String f6340r;
            @Nullable
            private String f6341s;
            @Nullable
            private String f6342t;
            @Nullable
            private FBVideoModel f6343u;
            @Nullable
            private GraphQLDocumentVideoAutoplayStyle f6344v;
            @Nullable
            private GraphQLDocumentVideoControlStyle f6345w;
            @Nullable
            private GraphQLDocumentVideoLoopingStyle f6346x;
            @Nullable
            private String f6347y;
            @Nullable
            private String f6348z;

            /* compiled from: photo_in_collection */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FallbackNativeAdModel.class, new Deserializer());
                }

                public Object m6698a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FallbackNativeAdParser.m6761a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object fallbackNativeAdModel = new FallbackNativeAdModel();
                    ((BaseModel) fallbackNativeAdModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (fallbackNativeAdModel instanceof Postprocessable) {
                        return ((Postprocessable) fallbackNativeAdModel).a();
                    }
                    return fallbackNativeAdModel;
                }
            }

            /* compiled from: photo_in_collection */
            public class Serializer extends JsonSerializer<FallbackNativeAdModel> {
                public final void m6699a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FallbackNativeAdModel fallbackNativeAdModel = (FallbackNativeAdModel) obj;
                    if (fallbackNativeAdModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(fallbackNativeAdModel.m6708a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        fallbackNativeAdModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FallbackNativeAdParser.m6762a(fallbackNativeAdModel.w_(), fallbackNativeAdModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(FallbackNativeAdModel.class, new Serializer());
                }
            }

            public FallbackNativeAdModel() {
                super(23);
            }

            @Nullable
            private GraphQLObjectType m6705x() {
                if (this.b != null && this.f6326d == null) {
                    this.f6326d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f6326d;
            }

            @Nullable
            private FBFullImageFragmentModel m6706y() {
                this.f6327e = (FBFullImageFragmentModel) super.a(this.f6327e, 1, FBFullImageFragmentModel.class);
                return this.f6327e;
            }

            @Nullable
            public final String m6710a() {
                this.f6328f = super.a(this.f6328f, 2);
                return this.f6328f;
            }

            @Nullable
            private String m6707z() {
                this.f6329g = super.a(this.f6329g, 3);
                return this.f6329g;
            }

            @Nullable
            public final String m6711j() {
                this.f6330h = super.a(this.f6330h, 4);
                return this.f6330h;
            }

            @Nullable
            public final String m6712k() {
                this.f6331i = super.a(this.f6331i, 5);
                return this.f6331i;
            }

            @Nullable
            public final String m6713l() {
                this.f6332j = super.a(this.f6332j, 6);
                return this.f6332j;
            }

            @Nullable
            private String m6700A() {
                this.f6333k = super.a(this.f6333k, 7);
                return this.f6333k;
            }

            @Nullable
            public final String m6714m() {
                this.f6334l = super.a(this.f6334l, 8);
                return this.f6334l;
            }

            @Nullable
            private FBFullImageFragmentModel m6701B() {
                this.f6335m = (FBFullImageFragmentModel) super.a(this.f6335m, 9, FBFullImageFragmentModel.class);
                return this.f6335m;
            }

            @Nullable
            public final FBFullImageFragmentModel m6715n() {
                this.f6336n = (FBFullImageFragmentModel) super.a(this.f6336n, 10, FBFullImageFragmentModel.class);
                return this.f6336n;
            }

            @Nullable
            public final String m6716o() {
                this.f6337o = super.a(this.f6337o, 11);
                return this.f6337o;
            }

            @Nullable
            public final GraphQLDocumentNativeAdType m6717p() {
                this.f6338p = (GraphQLDocumentNativeAdType) super.b(this.f6338p, 12, GraphQLDocumentNativeAdType.class, GraphQLDocumentNativeAdType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f6338p;
            }

            @Nullable
            private String m6702C() {
                this.f6339q = super.a(this.f6339q, 13);
                return this.f6339q;
            }

            @Nullable
            public final String m6718q() {
                this.f6340r = super.a(this.f6340r, 14);
                return this.f6340r;
            }

            @Nullable
            public final String m6719r() {
                this.f6341s = super.a(this.f6341s, 15);
                return this.f6341s;
            }

            @Nullable
            public final String m6720s() {
                this.f6342t = super.a(this.f6342t, 16);
                return this.f6342t;
            }

            @Nullable
            public final FBVideoModel m6721t() {
                this.f6343u = (FBVideoModel) super.a(this.f6343u, 17, FBVideoModel.class);
                return this.f6343u;
            }

            @Nullable
            public final GraphQLDocumentVideoAutoplayStyle m6722u() {
                this.f6344v = (GraphQLDocumentVideoAutoplayStyle) super.b(this.f6344v, 18, GraphQLDocumentVideoAutoplayStyle.class, GraphQLDocumentVideoAutoplayStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f6344v;
            }

            @Nullable
            public final GraphQLDocumentVideoControlStyle m6723v() {
                this.f6345w = (GraphQLDocumentVideoControlStyle) super.b(this.f6345w, 19, GraphQLDocumentVideoControlStyle.class, GraphQLDocumentVideoControlStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f6345w;
            }

            @Nullable
            public final GraphQLDocumentVideoLoopingStyle m6724w() {
                this.f6346x = (GraphQLDocumentVideoLoopingStyle) super.b(this.f6346x, 20, GraphQLDocumentVideoLoopingStyle.class, GraphQLDocumentVideoLoopingStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f6346x;
            }

            @Nullable
            private String m6703D() {
                this.f6347y = super.a(this.f6347y, 21);
                return this.f6347y;
            }

            @Nullable
            private String m6704E() {
                this.f6348z = super.a(this.f6348z, 22);
                return this.f6348z;
            }

            public final int jK_() {
                return 997998661;
            }

            public final GraphQLVisitableModel m6709a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                FBFullImageFragmentModel fBFullImageFragmentModel;
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m6706y() != null) {
                    fBFullImageFragmentModel = (FBFullImageFragmentModel) graphQLModelMutatingVisitor.b(m6706y());
                    if (m6706y() != fBFullImageFragmentModel) {
                        graphQLVisitableModel = (FallbackNativeAdModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f6327e = fBFullImageFragmentModel;
                    }
                }
                if (m6701B() != null) {
                    fBFullImageFragmentModel = (FBFullImageFragmentModel) graphQLModelMutatingVisitor.b(m6701B());
                    if (m6701B() != fBFullImageFragmentModel) {
                        graphQLVisitableModel = (FallbackNativeAdModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f6335m = fBFullImageFragmentModel;
                    }
                }
                if (m6715n() != null) {
                    fBFullImageFragmentModel = (FBFullImageFragmentModel) graphQLModelMutatingVisitor.b(m6715n());
                    if (m6715n() != fBFullImageFragmentModel) {
                        graphQLVisitableModel = (FallbackNativeAdModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f6336n = fBFullImageFragmentModel;
                    }
                }
                if (m6721t() != null) {
                    FBVideoModel fBVideoModel = (FBVideoModel) graphQLModelMutatingVisitor.b(m6721t());
                    if (m6721t() != fBVideoModel) {
                        graphQLVisitableModel = (FallbackNativeAdModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f6343u = fBVideoModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m6708a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m6705x());
                int a2 = ModelHelper.a(flatBufferBuilder, m6706y());
                int b = flatBufferBuilder.b(m6710a());
                int b2 = flatBufferBuilder.b(m6707z());
                int b3 = flatBufferBuilder.b(m6711j());
                int b4 = flatBufferBuilder.b(m6712k());
                int b5 = flatBufferBuilder.b(m6713l());
                int b6 = flatBufferBuilder.b(m6700A());
                int b7 = flatBufferBuilder.b(m6714m());
                int a3 = ModelHelper.a(flatBufferBuilder, m6701B());
                int a4 = ModelHelper.a(flatBufferBuilder, m6715n());
                int b8 = flatBufferBuilder.b(m6716o());
                int a5 = flatBufferBuilder.a(m6717p());
                int b9 = flatBufferBuilder.b(m6702C());
                int b10 = flatBufferBuilder.b(m6718q());
                int b11 = flatBufferBuilder.b(m6719r());
                int b12 = flatBufferBuilder.b(m6720s());
                int a6 = ModelHelper.a(flatBufferBuilder, m6721t());
                int a7 = flatBufferBuilder.a(m6722u());
                int a8 = flatBufferBuilder.a(m6723v());
                int a9 = flatBufferBuilder.a(m6724w());
                int b13 = flatBufferBuilder.b(m6703D());
                int b14 = flatBufferBuilder.b(m6704E());
                flatBufferBuilder.c(23);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, b);
                flatBufferBuilder.b(3, b2);
                flatBufferBuilder.b(4, b3);
                flatBufferBuilder.b(5, b4);
                flatBufferBuilder.b(6, b5);
                flatBufferBuilder.b(7, b6);
                flatBufferBuilder.b(8, b7);
                flatBufferBuilder.b(9, a3);
                flatBufferBuilder.b(10, a4);
                flatBufferBuilder.b(11, b8);
                flatBufferBuilder.b(12, a5);
                flatBufferBuilder.b(13, b9);
                flatBufferBuilder.b(14, b10);
                flatBufferBuilder.b(15, b11);
                flatBufferBuilder.b(16, b12);
                flatBufferBuilder.b(17, a6);
                flatBufferBuilder.b(18, a7);
                flatBufferBuilder.b(19, a8);
                flatBufferBuilder.b(20, a9);
                flatBufferBuilder.b(21, b13);
                flatBufferBuilder.b(22, b14);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: photo_in_collection */
        public class Serializer extends JsonSerializer<RichDocumentHTMLNativeAdFragmentModel> {
            public final void m6725a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                RichDocumentHTMLNativeAdFragmentModel richDocumentHTMLNativeAdFragmentModel = (RichDocumentHTMLNativeAdFragmentModel) obj;
                if (richDocumentHTMLNativeAdFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(richDocumentHTMLNativeAdFragmentModel.m6726a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    richDocumentHTMLNativeAdFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = richDocumentHTMLNativeAdFragmentModel.w_();
                int u_ = richDocumentHTMLNativeAdFragmentModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("fallback_native_ad");
                    FallbackNativeAdParser.m6762a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(RichDocumentHTMLNativeAdFragmentModel.class, new Serializer());
            }
        }

        public RichDocumentHTMLNativeAdFragmentModel() {
            super(1);
        }

        @Nullable
        public final FallbackNativeAdModel m6728a() {
            this.f6349d = (FallbackNativeAdModel) super.a(this.f6349d, 0, FallbackNativeAdModel.class);
            return this.f6349d;
        }

        public final int jK_() {
            return 1475051230;
        }

        public final GraphQLVisitableModel m6727a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m6728a() != null) {
                FallbackNativeAdModel fallbackNativeAdModel = (FallbackNativeAdModel) graphQLModelMutatingVisitor.b(m6728a());
                if (m6728a() != fallbackNativeAdModel) {
                    graphQLVisitableModel = (RichDocumentHTMLNativeAdFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f6349d = fallbackNativeAdModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m6726a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m6728a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2110324648)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: photo_in_collection */
    public final class RichDocumentNativeAdFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private NativeTypedAdObjectModel f6373d;

        /* compiled from: photo_in_collection */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(RichDocumentNativeAdFragmentModel.class, new Deserializer());
            }

            public Object m6729a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = RichDocumentNativeAdFragmentParser.m6766a(jsonParser);
                Object richDocumentNativeAdFragmentModel = new RichDocumentNativeAdFragmentModel();
                ((BaseModel) richDocumentNativeAdFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (richDocumentNativeAdFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) richDocumentNativeAdFragmentModel).a();
                }
                return richDocumentNativeAdFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1956063304)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: photo_in_collection */
        public final class NativeTypedAdObjectModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private GraphQLObjectType f6350d;
            @Nullable
            private FBFullImageFragmentModel f6351e;
            @Nullable
            private String f6352f;
            @Nullable
            private String f6353g;
            @Nullable
            private String f6354h;
            @Nullable
            private String f6355i;
            @Nullable
            private String f6356j;
            @Nullable
            private String f6357k;
            @Nullable
            private String f6358l;
            @Nullable
            private FBFullImageFragmentModel f6359m;
            @Nullable
            private FBFullImageFragmentModel f6360n;
            @Nullable
            private String f6361o;
            @Nullable
            private GraphQLDocumentNativeAdType f6362p;
            @Nullable
            private String f6363q;
            @Nullable
            private String f6364r;
            @Nullable
            private String f6365s;
            @Nullable
            private String f6366t;
            @Nullable
            private FBVideoModel f6367u;
            @Nullable
            private GraphQLDocumentVideoAutoplayStyle f6368v;
            @Nullable
            private GraphQLDocumentVideoControlStyle f6369w;
            @Nullable
            private GraphQLDocumentVideoLoopingStyle f6370x;
            @Nullable
            private String f6371y;
            @Nullable
            private String f6372z;

            /* compiled from: photo_in_collection */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(NativeTypedAdObjectModel.class, new Deserializer());
                }

                public Object m6730a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(NativeTypedAdObjectParser.m6764a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object nativeTypedAdObjectModel = new NativeTypedAdObjectModel();
                    ((BaseModel) nativeTypedAdObjectModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (nativeTypedAdObjectModel instanceof Postprocessable) {
                        return ((Postprocessable) nativeTypedAdObjectModel).a();
                    }
                    return nativeTypedAdObjectModel;
                }
            }

            /* compiled from: photo_in_collection */
            public class Serializer extends JsonSerializer<NativeTypedAdObjectModel> {
                public final void m6731a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    NativeTypedAdObjectModel nativeTypedAdObjectModel = (NativeTypedAdObjectModel) obj;
                    if (nativeTypedAdObjectModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(nativeTypedAdObjectModel.m6740a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        nativeTypedAdObjectModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    NativeTypedAdObjectParser.m6765a(nativeTypedAdObjectModel.w_(), nativeTypedAdObjectModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(NativeTypedAdObjectModel.class, new Serializer());
                }
            }

            public NativeTypedAdObjectModel() {
                super(23);
            }

            @Nullable
            private GraphQLObjectType m6737x() {
                if (this.b != null && this.f6350d == null) {
                    this.f6350d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f6350d;
            }

            @Nullable
            private FBFullImageFragmentModel m6738y() {
                this.f6351e = (FBFullImageFragmentModel) super.a(this.f6351e, 1, FBFullImageFragmentModel.class);
                return this.f6351e;
            }

            @Nullable
            public final String m6742a() {
                this.f6352f = super.a(this.f6352f, 2);
                return this.f6352f;
            }

            @Nullable
            private String m6739z() {
                this.f6353g = super.a(this.f6353g, 3);
                return this.f6353g;
            }

            @Nullable
            public final String m6743j() {
                this.f6354h = super.a(this.f6354h, 4);
                return this.f6354h;
            }

            @Nullable
            public final String m6744k() {
                this.f6355i = super.a(this.f6355i, 5);
                return this.f6355i;
            }

            @Nullable
            public final String m6745l() {
                this.f6356j = super.a(this.f6356j, 6);
                return this.f6356j;
            }

            @Nullable
            private String m6732A() {
                this.f6357k = super.a(this.f6357k, 7);
                return this.f6357k;
            }

            @Nullable
            public final String m6746m() {
                this.f6358l = super.a(this.f6358l, 8);
                return this.f6358l;
            }

            @Nullable
            private FBFullImageFragmentModel m6733B() {
                this.f6359m = (FBFullImageFragmentModel) super.a(this.f6359m, 9, FBFullImageFragmentModel.class);
                return this.f6359m;
            }

            @Nullable
            public final FBFullImageFragmentModel m6747n() {
                this.f6360n = (FBFullImageFragmentModel) super.a(this.f6360n, 10, FBFullImageFragmentModel.class);
                return this.f6360n;
            }

            @Nullable
            public final String m6748o() {
                this.f6361o = super.a(this.f6361o, 11);
                return this.f6361o;
            }

            @Nullable
            public final GraphQLDocumentNativeAdType m6749p() {
                this.f6362p = (GraphQLDocumentNativeAdType) super.b(this.f6362p, 12, GraphQLDocumentNativeAdType.class, GraphQLDocumentNativeAdType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f6362p;
            }

            @Nullable
            private String m6734C() {
                this.f6363q = super.a(this.f6363q, 13);
                return this.f6363q;
            }

            @Nullable
            public final String m6750q() {
                this.f6364r = super.a(this.f6364r, 14);
                return this.f6364r;
            }

            @Nullable
            public final String m6751r() {
                this.f6365s = super.a(this.f6365s, 15);
                return this.f6365s;
            }

            @Nullable
            public final String m6752s() {
                this.f6366t = super.a(this.f6366t, 16);
                return this.f6366t;
            }

            @Nullable
            public final FBVideoModel m6753t() {
                this.f6367u = (FBVideoModel) super.a(this.f6367u, 17, FBVideoModel.class);
                return this.f6367u;
            }

            @Nullable
            public final GraphQLDocumentVideoAutoplayStyle m6754u() {
                this.f6368v = (GraphQLDocumentVideoAutoplayStyle) super.b(this.f6368v, 18, GraphQLDocumentVideoAutoplayStyle.class, GraphQLDocumentVideoAutoplayStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f6368v;
            }

            @Nullable
            public final GraphQLDocumentVideoControlStyle m6755v() {
                this.f6369w = (GraphQLDocumentVideoControlStyle) super.b(this.f6369w, 19, GraphQLDocumentVideoControlStyle.class, GraphQLDocumentVideoControlStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f6369w;
            }

            @Nullable
            public final GraphQLDocumentVideoLoopingStyle m6756w() {
                this.f6370x = (GraphQLDocumentVideoLoopingStyle) super.b(this.f6370x, 20, GraphQLDocumentVideoLoopingStyle.class, GraphQLDocumentVideoLoopingStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f6370x;
            }

            @Nullable
            private String m6735D() {
                this.f6371y = super.a(this.f6371y, 21);
                return this.f6371y;
            }

            @Nullable
            private String m6736E() {
                this.f6372z = super.a(this.f6372z, 22);
                return this.f6372z;
            }

            public final int jK_() {
                return 997998661;
            }

            public final GraphQLVisitableModel m6741a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                FBFullImageFragmentModel fBFullImageFragmentModel;
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m6738y() != null) {
                    fBFullImageFragmentModel = (FBFullImageFragmentModel) graphQLModelMutatingVisitor.b(m6738y());
                    if (m6738y() != fBFullImageFragmentModel) {
                        graphQLVisitableModel = (NativeTypedAdObjectModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f6351e = fBFullImageFragmentModel;
                    }
                }
                if (m6733B() != null) {
                    fBFullImageFragmentModel = (FBFullImageFragmentModel) graphQLModelMutatingVisitor.b(m6733B());
                    if (m6733B() != fBFullImageFragmentModel) {
                        graphQLVisitableModel = (NativeTypedAdObjectModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f6359m = fBFullImageFragmentModel;
                    }
                }
                if (m6747n() != null) {
                    fBFullImageFragmentModel = (FBFullImageFragmentModel) graphQLModelMutatingVisitor.b(m6747n());
                    if (m6747n() != fBFullImageFragmentModel) {
                        graphQLVisitableModel = (NativeTypedAdObjectModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f6360n = fBFullImageFragmentModel;
                    }
                }
                if (m6753t() != null) {
                    FBVideoModel fBVideoModel = (FBVideoModel) graphQLModelMutatingVisitor.b(m6753t());
                    if (m6753t() != fBVideoModel) {
                        graphQLVisitableModel = (NativeTypedAdObjectModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f6367u = fBVideoModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m6740a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m6737x());
                int a2 = ModelHelper.a(flatBufferBuilder, m6738y());
                int b = flatBufferBuilder.b(m6742a());
                int b2 = flatBufferBuilder.b(m6739z());
                int b3 = flatBufferBuilder.b(m6743j());
                int b4 = flatBufferBuilder.b(m6744k());
                int b5 = flatBufferBuilder.b(m6745l());
                int b6 = flatBufferBuilder.b(m6732A());
                int b7 = flatBufferBuilder.b(m6746m());
                int a3 = ModelHelper.a(flatBufferBuilder, m6733B());
                int a4 = ModelHelper.a(flatBufferBuilder, m6747n());
                int b8 = flatBufferBuilder.b(m6748o());
                int a5 = flatBufferBuilder.a(m6749p());
                int b9 = flatBufferBuilder.b(m6734C());
                int b10 = flatBufferBuilder.b(m6750q());
                int b11 = flatBufferBuilder.b(m6751r());
                int b12 = flatBufferBuilder.b(m6752s());
                int a6 = ModelHelper.a(flatBufferBuilder, m6753t());
                int a7 = flatBufferBuilder.a(m6754u());
                int a8 = flatBufferBuilder.a(m6755v());
                int a9 = flatBufferBuilder.a(m6756w());
                int b13 = flatBufferBuilder.b(m6735D());
                int b14 = flatBufferBuilder.b(m6736E());
                flatBufferBuilder.c(23);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, b);
                flatBufferBuilder.b(3, b2);
                flatBufferBuilder.b(4, b3);
                flatBufferBuilder.b(5, b4);
                flatBufferBuilder.b(6, b5);
                flatBufferBuilder.b(7, b6);
                flatBufferBuilder.b(8, b7);
                flatBufferBuilder.b(9, a3);
                flatBufferBuilder.b(10, a4);
                flatBufferBuilder.b(11, b8);
                flatBufferBuilder.b(12, a5);
                flatBufferBuilder.b(13, b9);
                flatBufferBuilder.b(14, b10);
                flatBufferBuilder.b(15, b11);
                flatBufferBuilder.b(16, b12);
                flatBufferBuilder.b(17, a6);
                flatBufferBuilder.b(18, a7);
                flatBufferBuilder.b(19, a8);
                flatBufferBuilder.b(20, a9);
                flatBufferBuilder.b(21, b13);
                flatBufferBuilder.b(22, b14);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: photo_in_collection */
        public class Serializer extends JsonSerializer<RichDocumentNativeAdFragmentModel> {
            public final void m6757a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                RichDocumentNativeAdFragmentModel richDocumentNativeAdFragmentModel = (RichDocumentNativeAdFragmentModel) obj;
                if (richDocumentNativeAdFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(richDocumentNativeAdFragmentModel.m6758a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    richDocumentNativeAdFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = richDocumentNativeAdFragmentModel.w_();
                int u_ = richDocumentNativeAdFragmentModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("native_typed_ad_object");
                    NativeTypedAdObjectParser.m6765a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(RichDocumentNativeAdFragmentModel.class, new Serializer());
            }
        }

        public RichDocumentNativeAdFragmentModel() {
            super(1);
        }

        @Nullable
        public final NativeTypedAdObjectModel m6760a() {
            this.f6373d = (NativeTypedAdObjectModel) super.a(this.f6373d, 0, NativeTypedAdObjectModel.class);
            return this.f6373d;
        }

        public final int jK_() {
            return 812338247;
        }

        public final GraphQLVisitableModel m6759a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m6760a() != null) {
                NativeTypedAdObjectModel nativeTypedAdObjectModel = (NativeTypedAdObjectModel) graphQLModelMutatingVisitor.b(m6760a());
                if (m6760a() != nativeTypedAdObjectModel) {
                    graphQLVisitableModel = (RichDocumentNativeAdFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f6373d = nativeTypedAdObjectModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m6758a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m6760a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
