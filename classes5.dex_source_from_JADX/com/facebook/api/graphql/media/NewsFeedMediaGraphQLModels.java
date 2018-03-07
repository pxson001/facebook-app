package com.facebook.api.graphql.media;

import com.facebook.api.graphql.media.NewsFeedMediaGraphQLInterfaces.SphericalMetadata;
import com.facebook.api.graphql.media.NewsFeedMediaGraphQLParsers.AttributionAppMediaMetadataParser;
import com.facebook.api.graphql.media.NewsFeedMediaGraphQLParsers.AttributionAppMediaMetadataParser.AttributionAppParser;
import com.facebook.api.graphql.media.NewsFeedMediaGraphQLParsers.AttributionAppMediaMetadataParser.AttributionAppParser.NativeStoreObjectParser;
import com.facebook.api.graphql.media.NewsFeedMediaGraphQLParsers.AttributionAppMediaMetadataParser.AttributionAppParser.SquareLogoParser;
import com.facebook.api.graphql.media.NewsFeedMediaGraphQLParsers.SphericalMetadataParser;
import com.facebook.api.graphql.media.NewsFeedMediaGraphQLParsers.SphericalMetadataParser.GuidedTourParser;
import com.facebook.api.graphql.media.NewsFeedMediaGraphQLParsers.SphericalMetadataParser.GuidedTourParser.KeyframesParser;
import com.facebook.api.graphql.media.NewsFeedMediaGraphQLParsers.VideoChannelIdForVideoFragmentParser;
import com.facebook.api.graphql.media.NewsFeedMediaGraphQLParsers.VideoChannelIdForVideoFragmentParser.VideoChannelParser;
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
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
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

/* compiled from: android_post_call */
public class NewsFeedMediaGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1466300310)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: android_post_call */
    public final class AttributionAppMediaMetadataModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GraphQLObjectType f9726d;
        @Nullable
        private AttributionAppModel f9727e;
        @Nullable
        private String f9728f;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 597898442)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_post_call */
        public final class AttributionAppModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f9722d;
            @Nullable
            private String f9723e;
            @Nullable
            private NativeStoreObjectModel f9724f;
            @Nullable
            private SquareLogoModel f9725g;

            /* compiled from: android_post_call */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AttributionAppModel.class, new Deserializer());
                }

                public Object m16793a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AttributionAppParser.m16864a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object attributionAppModel = new AttributionAppModel();
                    ((BaseModel) attributionAppModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (attributionAppModel instanceof Postprocessable) {
                        return ((Postprocessable) attributionAppModel).a();
                    }
                    return attributionAppModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -960429245)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: android_post_call */
            public final class NativeStoreObjectModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f9720d;

                /* compiled from: android_post_call */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NativeStoreObjectModel.class, new Deserializer());
                    }

                    public Object m16794a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NativeStoreObjectParser.m16860a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object nativeStoreObjectModel = new NativeStoreObjectModel();
                        ((BaseModel) nativeStoreObjectModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (nativeStoreObjectModel instanceof Postprocessable) {
                            return ((Postprocessable) nativeStoreObjectModel).a();
                        }
                        return nativeStoreObjectModel;
                    }
                }

                /* compiled from: android_post_call */
                public class Serializer extends JsonSerializer<NativeStoreObjectModel> {
                    public final void m16795a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NativeStoreObjectModel nativeStoreObjectModel = (NativeStoreObjectModel) obj;
                        if (nativeStoreObjectModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nativeStoreObjectModel.m16797a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nativeStoreObjectModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NativeStoreObjectParser.m16861a(nativeStoreObjectModel.w_(), nativeStoreObjectModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(NativeStoreObjectModel.class, new Serializer());
                    }
                }

                public NativeStoreObjectModel() {
                    super(1);
                }

                @Nullable
                private String m16796a() {
                    this.f9720d = super.a(this.f9720d, 0);
                    return this.f9720d;
                }

                public final int jK_() {
                    return -1304127138;
                }

                public final GraphQLVisitableModel m16798a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m16797a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m16796a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: android_post_call */
            public class Serializer extends JsonSerializer<AttributionAppModel> {
                public final void m16799a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AttributionAppModel attributionAppModel = (AttributionAppModel) obj;
                    if (attributionAppModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(attributionAppModel.m16809a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        attributionAppModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AttributionAppParser.m16865a(attributionAppModel.w_(), attributionAppModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(AttributionAppModel.class, new Serializer());
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 842551240)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: android_post_call */
            public final class SquareLogoModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f9721d;

                /* compiled from: android_post_call */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(SquareLogoModel.class, new Deserializer());
                    }

                    public Object m16800a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(SquareLogoParser.m16862a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object squareLogoModel = new SquareLogoModel();
                        ((BaseModel) squareLogoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (squareLogoModel instanceof Postprocessable) {
                            return ((Postprocessable) squareLogoModel).a();
                        }
                        return squareLogoModel;
                    }
                }

                /* compiled from: android_post_call */
                public class Serializer extends JsonSerializer<SquareLogoModel> {
                    public final void m16801a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        SquareLogoModel squareLogoModel = (SquareLogoModel) obj;
                        if (squareLogoModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(squareLogoModel.m16803a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            squareLogoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        SquareLogoParser.m16863a(squareLogoModel.w_(), squareLogoModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(SquareLogoModel.class, new Serializer());
                    }
                }

                public SquareLogoModel() {
                    super(1);
                }

                @Nullable
                private String m16802a() {
                    this.f9721d = super.a(this.f9721d, 0);
                    return this.f9721d;
                }

                public final int jK_() {
                    return 70760763;
                }

                public final GraphQLVisitableModel m16804a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m16803a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m16802a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            public AttributionAppModel() {
                super(4);
            }

            @Nullable
            private String m16805j() {
                this.f9722d = super.a(this.f9722d, 0);
                return this.f9722d;
            }

            @Nullable
            private String m16806k() {
                this.f9723e = super.a(this.f9723e, 1);
                return this.f9723e;
            }

            @Nullable
            private NativeStoreObjectModel m16807l() {
                this.f9724f = (NativeStoreObjectModel) super.a(this.f9724f, 2, NativeStoreObjectModel.class);
                return this.f9724f;
            }

            @Nullable
            private SquareLogoModel m16808m() {
                this.f9725g = (SquareLogoModel) super.a(this.f9725g, 3, SquareLogoModel.class);
                return this.f9725g;
            }

            @Nullable
            public final String m16811a() {
                return m16805j();
            }

            public final int jK_() {
                return -1072845520;
            }

            public final GraphQLVisitableModel m16810a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m16807l() != null) {
                    NativeStoreObjectModel nativeStoreObjectModel = (NativeStoreObjectModel) graphQLModelMutatingVisitor.b(m16807l());
                    if (m16807l() != nativeStoreObjectModel) {
                        graphQLVisitableModel = (AttributionAppModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f9724f = nativeStoreObjectModel;
                    }
                }
                if (m16808m() != null) {
                    SquareLogoModel squareLogoModel = (SquareLogoModel) graphQLModelMutatingVisitor.b(m16808m());
                    if (m16808m() != squareLogoModel) {
                        graphQLVisitableModel = (AttributionAppModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f9725g = squareLogoModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m16809a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m16805j());
                int b2 = flatBufferBuilder.b(m16806k());
                int a = ModelHelper.a(flatBufferBuilder, m16807l());
                int a2 = ModelHelper.a(flatBufferBuilder, m16808m());
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.b(2, a);
                flatBufferBuilder.b(3, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: android_post_call */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AttributionAppMediaMetadataModel.class, new Deserializer());
            }

            public Object m16812a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = AttributionAppMediaMetadataParser.m16866a(jsonParser);
                Object attributionAppMediaMetadataModel = new AttributionAppMediaMetadataModel();
                ((BaseModel) attributionAppMediaMetadataModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (attributionAppMediaMetadataModel instanceof Postprocessable) {
                    return ((Postprocessable) attributionAppMediaMetadataModel).a();
                }
                return attributionAppMediaMetadataModel;
            }
        }

        /* compiled from: android_post_call */
        public class Serializer extends JsonSerializer<AttributionAppMediaMetadataModel> {
            public final void m16813a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                AttributionAppMediaMetadataModel attributionAppMediaMetadataModel = (AttributionAppMediaMetadataModel) obj;
                if (attributionAppMediaMetadataModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(attributionAppMediaMetadataModel.m16817a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    attributionAppMediaMetadataModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = attributionAppMediaMetadataModel.w_();
                int u_ = attributionAppMediaMetadataModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("attribution_app");
                    AttributionAppParser.m16865a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("attribution_app_metadata");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 2));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(AttributionAppMediaMetadataModel.class, new Serializer());
            }
        }

        public AttributionAppMediaMetadataModel() {
            super(3);
        }

        @Nullable
        private GraphQLObjectType m16814a() {
            if (this.b != null && this.f9726d == null) {
                this.f9726d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f9726d;
        }

        @Nullable
        private AttributionAppModel m16815j() {
            this.f9727e = (AttributionAppModel) super.a(this.f9727e, 1, AttributionAppModel.class);
            return this.f9727e;
        }

        @Nullable
        private String m16816k() {
            this.f9728f = super.a(this.f9728f, 2);
            return this.f9728f;
        }

        public final int jK_() {
            return 74219460;
        }

        public final GraphQLVisitableModel m16818a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16815j() != null) {
                AttributionAppModel attributionAppModel = (AttributionAppModel) graphQLModelMutatingVisitor.b(m16815j());
                if (m16815j() != attributionAppModel) {
                    graphQLVisitableModel = (AttributionAppMediaMetadataModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9727e = attributionAppModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16817a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16814a());
            int a2 = ModelHelper.a(flatBufferBuilder, m16815j());
            int b = flatBufferBuilder.b(m16816k());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1411058639)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: android_post_call */
    public final class SphericalMetadataModel extends BaseModel implements SphericalMetadata, GraphQLVisitableModel {
        @Nullable
        private GuidedTourModel f9737d;
        private int f9738e;
        private int f9739f;
        private int f9740g;
        private boolean f9741h;
        @Nullable
        private String f9742i;
        private double f9743j;
        private double f9744k;
        @Nullable
        private String f9745l;
        @Nullable
        private String f9746m;
        private int f9747n;

        /* compiled from: android_post_call */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SphericalMetadataModel.class, new Deserializer());
            }

            public Object m16819a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(SphericalMetadataParser.m16871a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object sphericalMetadataModel = new SphericalMetadataModel();
                ((BaseModel) sphericalMetadataModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (sphericalMetadataModel instanceof Postprocessable) {
                    return ((Postprocessable) sphericalMetadataModel).a();
                }
                return sphericalMetadataModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1676418073)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_post_call */
        public final class GuidedTourModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<KeyframesModel> f9736d;

            /* compiled from: android_post_call */
            public final class Builder {
                @Nullable
                public ImmutableList<KeyframesModel> f9729a;

                public final GuidedTourModel m16820a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a = ModelHelper.a(flatBufferBuilder, this.f9729a);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new GuidedTourModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: android_post_call */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(GuidedTourModel.class, new Deserializer());
                }

                public Object m16821a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(GuidedTourParser.m16869a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object guidedTourModel = new GuidedTourModel();
                    ((BaseModel) guidedTourModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (guidedTourModel instanceof Postprocessable) {
                        return ((Postprocessable) guidedTourModel).a();
                    }
                    return guidedTourModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1886856453)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: android_post_call */
            public final class KeyframesModel extends BaseModel implements GraphQLVisitableModel {
                private int f9733d;
                private long f9734e;
                private int f9735f;

                /* compiled from: android_post_call */
                public final class Builder {
                    public int f9730a;
                    public long f9731b;
                    public int f9732c;

                    public final KeyframesModel m16822a() {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.c(3);
                        flatBufferBuilder.a(0, this.f9730a, 0);
                        flatBufferBuilder.a(1, this.f9731b, 0);
                        flatBufferBuilder.a(2, this.f9732c, 0);
                        flatBufferBuilder.d(flatBufferBuilder.d());
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        return new KeyframesModel(new MutableFlatBuffer(wrap, null, null, true, null));
                    }
                }

                /* compiled from: android_post_call */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(KeyframesModel.class, new Deserializer());
                    }

                    public Object m16823a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(KeyframesParser.m16868b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object keyframesModel = new KeyframesModel();
                        ((BaseModel) keyframesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (keyframesModel instanceof Postprocessable) {
                            return ((Postprocessable) keyframesModel).a();
                        }
                        return keyframesModel;
                    }
                }

                /* compiled from: android_post_call */
                public class Serializer extends JsonSerializer<KeyframesModel> {
                    public final void m16824a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        KeyframesModel keyframesModel = (KeyframesModel) obj;
                        if (keyframesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(keyframesModel.m16827a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            keyframesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        KeyframesParser.m16867a(keyframesModel.w_(), keyframesModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(KeyframesModel.class, new Serializer());
                    }
                }

                public KeyframesModel() {
                    super(3);
                }

                public KeyframesModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(3);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                public final int m16826a() {
                    a(0, 0);
                    return this.f9733d;
                }

                public final long m16830b() {
                    a(0, 1);
                    return this.f9734e;
                }

                public final int m16831c() {
                    a(0, 2);
                    return this.f9735f;
                }

                public static KeyframesModel m16825a(KeyframesModel keyframesModel) {
                    if (keyframesModel == null) {
                        return null;
                    }
                    if (keyframesModel instanceof KeyframesModel) {
                        return keyframesModel;
                    }
                    Builder builder = new Builder();
                    builder.f9730a = keyframesModel.m16826a();
                    builder.f9731b = keyframesModel.m16830b();
                    builder.f9732c = keyframesModel.m16831c();
                    return builder.m16822a();
                }

                public final int jK_() {
                    return -1058659927;
                }

                public final GraphQLVisitableModel m16828a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m16827a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.a(0, this.f9733d, 0);
                    flatBufferBuilder.a(1, this.f9734e, 0);
                    flatBufferBuilder.a(2, this.f9735f, 0);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m16829a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f9733d = mutableFlatBuffer.a(i, 0, 0);
                    this.f9734e = mutableFlatBuffer.a(i, 1, 0);
                    this.f9735f = mutableFlatBuffer.a(i, 2, 0);
                }
            }

            /* compiled from: android_post_call */
            public class Serializer extends JsonSerializer<GuidedTourModel> {
                public final void m16832a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    GuidedTourModel guidedTourModel = (GuidedTourModel) obj;
                    if (guidedTourModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(guidedTourModel.m16834a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        guidedTourModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    GuidedTourParser.m16870a(guidedTourModel.w_(), guidedTourModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(GuidedTourModel.class, new Serializer());
                }
            }

            public GuidedTourModel() {
                super(1);
            }

            public GuidedTourModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nonnull
            public final ImmutableList<KeyframesModel> m16836a() {
                this.f9736d = super.a(this.f9736d, 0, KeyframesModel.class);
                return (ImmutableList) this.f9736d;
            }

            public static GuidedTourModel m16833a(GuidedTourModel guidedTourModel) {
                if (guidedTourModel == null) {
                    return null;
                }
                if (guidedTourModel instanceof GuidedTourModel) {
                    return guidedTourModel;
                }
                Builder builder = new Builder();
                com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
                for (int i = 0; i < guidedTourModel.m16836a().size(); i++) {
                    builder2.c(KeyframesModel.m16825a((KeyframesModel) guidedTourModel.m16836a().get(i)));
                }
                builder.f9729a = builder2.b();
                return builder.m16820a();
            }

            public final int jK_() {
                return 302897691;
            }

            public final GraphQLVisitableModel m16835a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m16836a() != null) {
                    com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m16836a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (GuidedTourModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f9736d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m16834a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m16836a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: android_post_call */
        public class Serializer extends JsonSerializer<SphericalMetadataModel> {
            public final void m16837a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                SphericalMetadataModel sphericalMetadataModel = (SphericalMetadataModel) obj;
                if (sphericalMetadataModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(sphericalMetadataModel.m16842a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    sphericalMetadataModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                SphericalMetadataParser.m16872a(sphericalMetadataModel.w_(), sphericalMetadataModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(SphericalMetadataModel.class, new Serializer());
            }
        }

        public SphericalMetadataModel() {
            super(11);
        }

        @Nullable
        private GuidedTourModel m16838a() {
            this.f9737d = (GuidedTourModel) super.a(this.f9737d, 0, GuidedTourModel.class);
            return this.f9737d;
        }

        @Nullable
        private String m16839j() {
            this.f9742i = super.a(this.f9742i, 5);
            return this.f9742i;
        }

        @Nullable
        private String m16840k() {
            this.f9745l = super.a(this.f9745l, 8);
            return this.f9745l;
        }

        @Nullable
        private String m16841l() {
            this.f9746m = super.a(this.f9746m, 9);
            return this.f9746m;
        }

        public final int jK_() {
            return 82650203;
        }

        public final GraphQLVisitableModel m16843a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16838a() != null) {
                GuidedTourModel guidedTourModel = (GuidedTourModel) graphQLModelMutatingVisitor.b(m16838a());
                if (m16838a() != guidedTourModel) {
                    graphQLVisitableModel = (SphericalMetadataModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9737d = guidedTourModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16842a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16838a());
            int b = flatBufferBuilder.b(m16839j());
            int b2 = flatBufferBuilder.b(m16840k());
            int b3 = flatBufferBuilder.b(m16841l());
            flatBufferBuilder.c(11);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.a(1, this.f9738e, 0);
            flatBufferBuilder.a(2, this.f9739f, 0);
            flatBufferBuilder.a(3, this.f9740g, 0);
            flatBufferBuilder.a(4, this.f9741h);
            flatBufferBuilder.b(5, b);
            flatBufferBuilder.a(6, this.f9743j, 0.0d);
            flatBufferBuilder.a(7, this.f9744k, 0.0d);
            flatBufferBuilder.b(8, b2);
            flatBufferBuilder.b(9, b3);
            flatBufferBuilder.a(10, this.f9747n, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m16844a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f9738e = mutableFlatBuffer.a(i, 1, 0);
            this.f9739f = mutableFlatBuffer.a(i, 2, 0);
            this.f9740g = mutableFlatBuffer.a(i, 3, 0);
            this.f9741h = mutableFlatBuffer.a(i, 4);
            this.f9743j = mutableFlatBuffer.a(i, 6, 0.0d);
            this.f9744k = mutableFlatBuffer.a(i, 7, 0.0d);
            this.f9747n = mutableFlatBuffer.a(i, 10, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -17549091)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: android_post_call */
    public final class VideoChannelIdForVideoFragmentModel extends BaseModel implements GraphQLVisitableModel {
        private boolean f9750d;
        @Nullable
        private VideoChannelModel f9751e;

        /* compiled from: android_post_call */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(VideoChannelIdForVideoFragmentModel.class, new Deserializer());
            }

            public Object m16845a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = VideoChannelIdForVideoFragmentParser.m16875a(jsonParser);
                Object videoChannelIdForVideoFragmentModel = new VideoChannelIdForVideoFragmentModel();
                ((BaseModel) videoChannelIdForVideoFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (videoChannelIdForVideoFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) videoChannelIdForVideoFragmentModel).a();
                }
                return videoChannelIdForVideoFragmentModel;
            }
        }

        /* compiled from: android_post_call */
        public class Serializer extends JsonSerializer<VideoChannelIdForVideoFragmentModel> {
            public final void m16846a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                VideoChannelIdForVideoFragmentModel videoChannelIdForVideoFragmentModel = (VideoChannelIdForVideoFragmentModel) obj;
                if (videoChannelIdForVideoFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(videoChannelIdForVideoFragmentModel.m16857a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    videoChannelIdForVideoFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = videoChannelIdForVideoFragmentModel.w_();
                int u_ = videoChannelIdForVideoFragmentModel.u_();
                jsonGenerator.f();
                boolean a = mutableFlatBuffer.a(u_, 0);
                if (a) {
                    jsonGenerator.a("should_open_single_publisher");
                    jsonGenerator.a(a);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("video_channel");
                    VideoChannelParser.m16874a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(VideoChannelIdForVideoFragmentModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1787905591)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_post_call */
        public final class VideoChannelModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f9748d;
            @Nullable
            private String f9749e;

            /* compiled from: android_post_call */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(VideoChannelModel.class, new Deserializer());
                }

                public Object m16847a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(VideoChannelParser.m16873a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object videoChannelModel = new VideoChannelModel();
                    ((BaseModel) videoChannelModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (videoChannelModel instanceof Postprocessable) {
                        return ((Postprocessable) videoChannelModel).a();
                    }
                    return videoChannelModel;
                }
            }

            /* compiled from: android_post_call */
            public class Serializer extends JsonSerializer<VideoChannelModel> {
                public final void m16848a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    VideoChannelModel videoChannelModel = (VideoChannelModel) obj;
                    if (videoChannelModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(videoChannelModel.m16851a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        videoChannelModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    VideoChannelParser.m16874a(videoChannelModel.w_(), videoChannelModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(VideoChannelModel.class, new Serializer());
                }
            }

            public VideoChannelModel() {
                super(2);
            }

            public final void m16854a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m16855a(String str, Object obj, boolean z) {
            }

            @Nullable
            private GraphQLObjectType m16849j() {
                if (this.b != null && this.f9748d == null) {
                    this.f9748d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f9748d;
            }

            @Nullable
            private String m16850k() {
                this.f9749e = super.a(this.f9749e, 1);
                return this.f9749e;
            }

            @Nullable
            public final String m16853a() {
                return m16850k();
            }

            public final int jK_() {
                return 756114472;
            }

            public final GraphQLVisitableModel m16852a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m16851a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m16849j());
                int b = flatBufferBuilder.b(m16850k());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        public VideoChannelIdForVideoFragmentModel() {
            super(2);
        }

        @Nullable
        private VideoChannelModel m16856a() {
            this.f9751e = (VideoChannelModel) super.a(this.f9751e, 1, VideoChannelModel.class);
            return this.f9751e;
        }

        public final int jK_() {
            return 82650203;
        }

        public final GraphQLVisitableModel m16858a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16856a() != null) {
                VideoChannelModel videoChannelModel = (VideoChannelModel) graphQLModelMutatingVisitor.b(m16856a());
                if (m16856a() != videoChannelModel) {
                    graphQLVisitableModel = (VideoChannelIdForVideoFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9751e = videoChannelModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16857a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16856a());
            flatBufferBuilder.c(2);
            flatBufferBuilder.a(0, this.f9750d);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }

        public final void m16859a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f9750d = mutableFlatBuffer.a(i, 0);
        }
    }
}
