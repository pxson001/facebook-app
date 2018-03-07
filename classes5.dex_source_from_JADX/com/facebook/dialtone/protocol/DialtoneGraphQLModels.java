package com.facebook.dialtone.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.dialtone.protocol.DialtoneGraphQLParsers.DialtonePhotoUnblockMutationParser;
import com.facebook.dialtone.protocol.DialtoneGraphQLParsers.DialtonePhotoUnblockMutationParser.DialtonePhotoQuotaParser;
import com.facebook.dialtone.protocol.DialtoneGraphQLParsers.DialtonePhotoUnblockMutationParser.DialtonePhotoQuotaParser.FreePhotosParser;
import com.facebook.dialtone.protocol.DialtoneGraphQLParsers.FetchDialtonePhotoQuotaParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.nio.ByteBuffer;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: [any property on class  */
public class DialtoneGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 759145898)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: [any property on class  */
    public final class DialtonePhotoUnblockMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private DialtonePhotoQuotaModel f11873d;

        /* compiled from: [any property on class  */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(DialtonePhotoUnblockMutationModel.class, new Deserializer());
            }

            public Object m19883a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = DialtonePhotoUnblockMutationParser.m19928a(jsonParser);
                Object dialtonePhotoUnblockMutationModel = new DialtonePhotoUnblockMutationModel();
                ((BaseModel) dialtonePhotoUnblockMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (dialtonePhotoUnblockMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) dialtonePhotoUnblockMutationModel).a();
                }
                return dialtonePhotoUnblockMutationModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1266053079)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: [any property on class  */
        public final class DialtonePhotoQuotaModel extends BaseModel implements GraphQLVisitableModel {
            private long f11869d;
            @Nullable
            private List<FreePhotosModel> f11870e;
            private int f11871f;
            private int f11872g;

            /* compiled from: [any property on class  */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(DialtonePhotoQuotaModel.class, new Deserializer());
                }

                public Object m19884a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(DialtonePhotoQuotaParser.m19926a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object dialtonePhotoQuotaModel = new DialtonePhotoQuotaModel();
                    ((BaseModel) dialtonePhotoQuotaModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (dialtonePhotoQuotaModel instanceof Postprocessable) {
                        return ((Postprocessable) dialtonePhotoQuotaModel).a();
                    }
                    return dialtonePhotoQuotaModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1284580115)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: [any property on class  */
            public final class FreePhotosModel extends BaseModel implements GraphQLVisitableModel {
                private long f11867d;
                @Nullable
                private String f11868e;

                /* compiled from: [any property on class  */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(FreePhotosModel.class, new Deserializer());
                    }

                    public Object m19885a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(FreePhotosParser.m19925b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object freePhotosModel = new FreePhotosModel();
                        ((BaseModel) freePhotosModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (freePhotosModel instanceof Postprocessable) {
                            return ((Postprocessable) freePhotosModel).a();
                        }
                        return freePhotosModel;
                    }
                }

                /* compiled from: [any property on class  */
                public class Serializer extends JsonSerializer<FreePhotosModel> {
                    public final void m19886a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        FreePhotosModel freePhotosModel = (FreePhotosModel) obj;
                        if (freePhotosModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(freePhotosModel.m19887a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            freePhotosModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        FreePhotosParser.m19924a(freePhotosModel.w_(), freePhotosModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(FreePhotosModel.class, new Serializer());
                    }
                }

                public FreePhotosModel() {
                    super(2);
                }

                public final long m19888a() {
                    a(0, 0);
                    return this.f11867d;
                }

                @Nullable
                public final String m19891j() {
                    this.f11868e = super.a(this.f11868e, 1);
                    return this.f11868e;
                }

                public final int jK_() {
                    return 1762581572;
                }

                public final GraphQLVisitableModel m19889a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m19887a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m19891j());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.a(0, this.f11867d, 0);
                    flatBufferBuilder.b(1, b);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m19890a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f11867d = mutableFlatBuffer.a(i, 0, 0);
                }
            }

            /* compiled from: [any property on class  */
            public class Serializer extends JsonSerializer<DialtonePhotoQuotaModel> {
                public final void m19892a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    DialtonePhotoQuotaModel dialtonePhotoQuotaModel = (DialtonePhotoQuotaModel) obj;
                    if (dialtonePhotoQuotaModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(dialtonePhotoQuotaModel.m19893a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        dialtonePhotoQuotaModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    DialtonePhotoQuotaParser.m19927a(dialtonePhotoQuotaModel.w_(), dialtonePhotoQuotaModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(DialtonePhotoQuotaModel.class, new Serializer());
                }
            }

            public DialtonePhotoQuotaModel() {
                super(4);
            }

            public final long m19894a() {
                a(0, 0);
                return this.f11869d;
            }

            @Nonnull
            public final ImmutableList<FreePhotosModel> m19897j() {
                this.f11870e = super.a(this.f11870e, 1, FreePhotosModel.class);
                return (ImmutableList) this.f11870e;
            }

            public final int m19898k() {
                a(0, 2);
                return this.f11871f;
            }

            public final int jK_() {
                return -722681336;
            }

            public final GraphQLVisitableModel m19895a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m19897j() != null) {
                    Builder a = ModelHelper.a(m19897j(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (DialtonePhotoQuotaModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f11870e = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m19893a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m19897j());
                flatBufferBuilder.c(4);
                flatBufferBuilder.a(0, this.f11869d, 0);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.a(2, this.f11871f, 0);
                flatBufferBuilder.a(3, this.f11872g, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m19896a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f11869d = mutableFlatBuffer.a(i, 0, 0);
                this.f11871f = mutableFlatBuffer.a(i, 2, 0);
                this.f11872g = mutableFlatBuffer.a(i, 3, 0);
            }
        }

        /* compiled from: [any property on class  */
        public class Serializer extends JsonSerializer<DialtonePhotoUnblockMutationModel> {
            public final void m19899a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                DialtonePhotoUnblockMutationModel dialtonePhotoUnblockMutationModel = (DialtonePhotoUnblockMutationModel) obj;
                if (dialtonePhotoUnblockMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(dialtonePhotoUnblockMutationModel.m19900a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    dialtonePhotoUnblockMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = dialtonePhotoUnblockMutationModel.w_();
                int u_ = dialtonePhotoUnblockMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("dialtone_photo_quota");
                    DialtonePhotoQuotaParser.m19927a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(DialtonePhotoUnblockMutationModel.class, new Serializer());
            }
        }

        public DialtonePhotoUnblockMutationModel() {
            super(1);
        }

        @Nullable
        public final DialtonePhotoQuotaModel m19901a() {
            this.f11873d = (DialtonePhotoQuotaModel) super.a(this.f11873d, 0, DialtonePhotoQuotaModel.class);
            return this.f11873d;
        }

        public final int jK_() {
            return 2024943739;
        }

        public final GraphQLVisitableModel m19902a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m19901a() != null) {
                DialtonePhotoQuotaModel dialtonePhotoQuotaModel = (DialtonePhotoQuotaModel) graphQLModelMutatingVisitor.b(m19901a());
                if (m19901a() != dialtonePhotoQuotaModel) {
                    graphQLVisitableModel = (DialtonePhotoUnblockMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11873d = dialtonePhotoQuotaModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m19900a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m19901a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1357755576)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: [any property on class  */
    public final class FetchDialtonePhotoQuotaModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private DialtonePhotoQuotaModel f11880d;

        /* compiled from: [any property on class  */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchDialtonePhotoQuotaModel.class, new Deserializer());
            }

            public Object m19903a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchDialtonePhotoQuotaParser.m19934a(jsonParser);
                Object fetchDialtonePhotoQuotaModel = new FetchDialtonePhotoQuotaModel();
                ((BaseModel) fetchDialtonePhotoQuotaModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchDialtonePhotoQuotaModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchDialtonePhotoQuotaModel).a();
                }
                return fetchDialtonePhotoQuotaModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1716610983)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: [any property on class  */
        public final class DialtonePhotoQuotaModel extends BaseModel implements GraphQLVisitableModel {
            private long f11876d;
            @Nullable
            private List<FreePhotosModel> f11877e;
            private int f11878f;
            private int f11879g;

            /* compiled from: [any property on class  */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(DialtonePhotoQuotaModel.class, new Deserializer());
                }

                public Object m19904a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FetchDialtonePhotoQuotaParser.DialtonePhotoQuotaParser.m19932a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object dialtonePhotoQuotaModel = new DialtonePhotoQuotaModel();
                    ((BaseModel) dialtonePhotoQuotaModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (dialtonePhotoQuotaModel instanceof Postprocessable) {
                        return ((Postprocessable) dialtonePhotoQuotaModel).a();
                    }
                    return dialtonePhotoQuotaModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1284580115)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: [any property on class  */
            public final class FreePhotosModel extends BaseModel implements GraphQLVisitableModel {
                private long f11874d;
                @Nullable
                private String f11875e;

                /* compiled from: [any property on class  */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(FreePhotosModel.class, new Deserializer());
                    }

                    public Object m19905a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(FetchDialtonePhotoQuotaParser.DialtonePhotoQuotaParser.FreePhotosParser.m19931b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object freePhotosModel = new FreePhotosModel();
                        ((BaseModel) freePhotosModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (freePhotosModel instanceof Postprocessable) {
                            return ((Postprocessable) freePhotosModel).a();
                        }
                        return freePhotosModel;
                    }
                }

                /* compiled from: [any property on class  */
                public class Serializer extends JsonSerializer<FreePhotosModel> {
                    public final void m19906a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        FreePhotosModel freePhotosModel = (FreePhotosModel) obj;
                        if (freePhotosModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(freePhotosModel.m19907a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            freePhotosModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        FetchDialtonePhotoQuotaParser.DialtonePhotoQuotaParser.FreePhotosParser.m19930a(freePhotosModel.w_(), freePhotosModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(FreePhotosModel.class, new Serializer());
                    }
                }

                public FreePhotosModel() {
                    super(2);
                }

                public final long m19908a() {
                    a(0, 0);
                    return this.f11874d;
                }

                @Nullable
                public final String m19911j() {
                    this.f11875e = super.a(this.f11875e, 1);
                    return this.f11875e;
                }

                public final int jK_() {
                    return 1762581572;
                }

                public final GraphQLVisitableModel m19909a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m19907a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m19911j());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.a(0, this.f11874d, 0);
                    flatBufferBuilder.b(1, b);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m19910a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f11874d = mutableFlatBuffer.a(i, 0, 0);
                }
            }

            /* compiled from: [any property on class  */
            public class Serializer extends JsonSerializer<DialtonePhotoQuotaModel> {
                public final void m19912a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    DialtonePhotoQuotaModel dialtonePhotoQuotaModel = (DialtonePhotoQuotaModel) obj;
                    if (dialtonePhotoQuotaModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(dialtonePhotoQuotaModel.m19913a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        dialtonePhotoQuotaModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FetchDialtonePhotoQuotaParser.DialtonePhotoQuotaParser.m19933a(dialtonePhotoQuotaModel.w_(), dialtonePhotoQuotaModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(DialtonePhotoQuotaModel.class, new Serializer());
                }
            }

            public DialtonePhotoQuotaModel() {
                super(4);
            }

            public final long m19914a() {
                a(0, 0);
                return this.f11876d;
            }

            @Nonnull
            public final ImmutableList<FreePhotosModel> m19917j() {
                this.f11877e = super.a(this.f11877e, 1, FreePhotosModel.class);
                return (ImmutableList) this.f11877e;
            }

            public final int m19918k() {
                a(0, 2);
                return this.f11878f;
            }

            public final int jK_() {
                return -722681336;
            }

            public final GraphQLVisitableModel m19915a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m19917j() != null) {
                    Builder a = ModelHelper.a(m19917j(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (DialtonePhotoQuotaModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f11877e = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m19913a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m19917j());
                flatBufferBuilder.c(4);
                flatBufferBuilder.a(0, this.f11876d, 0);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.a(2, this.f11878f, 0);
                flatBufferBuilder.a(3, this.f11879g, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m19916a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f11876d = mutableFlatBuffer.a(i, 0, 0);
                this.f11878f = mutableFlatBuffer.a(i, 2, 0);
                this.f11879g = mutableFlatBuffer.a(i, 3, 0);
            }
        }

        /* compiled from: [any property on class  */
        public class Serializer extends JsonSerializer<FetchDialtonePhotoQuotaModel> {
            public final void m19919a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchDialtonePhotoQuotaModel fetchDialtonePhotoQuotaModel = (FetchDialtonePhotoQuotaModel) obj;
                if (fetchDialtonePhotoQuotaModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchDialtonePhotoQuotaModel.m19920a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchDialtonePhotoQuotaModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchDialtonePhotoQuotaModel.w_();
                int u_ = fetchDialtonePhotoQuotaModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("dialtone_photo_quota");
                    FetchDialtonePhotoQuotaParser.DialtonePhotoQuotaParser.m19933a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchDialtonePhotoQuotaModel.class, new Serializer());
            }
        }

        public FetchDialtonePhotoQuotaModel() {
            super(1);
        }

        @Nullable
        public final DialtonePhotoQuotaModel m19921a() {
            this.f11880d = (DialtonePhotoQuotaModel) super.a(this.f11880d, 0, DialtonePhotoQuotaModel.class);
            return this.f11880d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m19922a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m19921a() != null) {
                DialtonePhotoQuotaModel dialtonePhotoQuotaModel = (DialtonePhotoQuotaModel) graphQLModelMutatingVisitor.b(m19921a());
                if (m19921a() != dialtonePhotoQuotaModel) {
                    graphQLVisitableModel = (FetchDialtonePhotoQuotaModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11880d = dialtonePhotoQuotaModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m19920a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m19921a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
