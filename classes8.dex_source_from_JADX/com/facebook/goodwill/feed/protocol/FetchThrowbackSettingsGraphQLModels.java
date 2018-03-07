package com.facebook.goodwill.feed.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.goodwill.feed.protocol.FetchThrowbackSettingsGraphQLParsers.ThrowbackSettingsSubscriptionMutationParser;
import com.facebook.goodwill.feed.protocol.FetchThrowbackSettingsGraphQLParsers.ThrowbackSettingsSubscriptionMutationParser.ViewerParser;
import com.facebook.goodwill.feed.protocol.FetchThrowbackSettingsGraphQLParsers.ThrowbackSettingsSubscriptionMutationParser.ViewerParser.ThrowbackParser;
import com.facebook.goodwill.feed.protocol.FetchThrowbackSettingsGraphQLParsers.ThrowbackSettingsSubscriptionMutationParser.ViewerParser.ThrowbackParser.ThrowbackSettingsParser;
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
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: fetchMoreAlbumsList */
public class FetchThrowbackSettingsGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -791161594)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: fetchMoreAlbumsList */
    public final class ThrowbackSettingsSubscriptionMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ViewerModel f13492d;

        /* compiled from: fetchMoreAlbumsList */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ThrowbackSettingsSubscriptionMutationModel.class, new Deserializer());
            }

            public Object m15241a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ThrowbackSettingsSubscriptionMutationParser.m15268a(jsonParser);
                Object throwbackSettingsSubscriptionMutationModel = new ThrowbackSettingsSubscriptionMutationModel();
                ((BaseModel) throwbackSettingsSubscriptionMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (throwbackSettingsSubscriptionMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) throwbackSettingsSubscriptionMutationModel).a();
                }
                return throwbackSettingsSubscriptionMutationModel;
            }
        }

        /* compiled from: fetchMoreAlbumsList */
        public class Serializer extends JsonSerializer<ThrowbackSettingsSubscriptionMutationModel> {
            public final void m15242a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ThrowbackSettingsSubscriptionMutationModel throwbackSettingsSubscriptionMutationModel = (ThrowbackSettingsSubscriptionMutationModel) obj;
                if (throwbackSettingsSubscriptionMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(throwbackSettingsSubscriptionMutationModel.m15260a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    throwbackSettingsSubscriptionMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = throwbackSettingsSubscriptionMutationModel.w_();
                int u_ = throwbackSettingsSubscriptionMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("viewer");
                    ViewerParser.m15267a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ThrowbackSettingsSubscriptionMutationModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1593187239)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: fetchMoreAlbumsList */
        public final class ViewerModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private ThrowbackModel f13491d;

            /* compiled from: fetchMoreAlbumsList */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ViewerModel.class, new Deserializer());
                }

                public Object m15243a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ViewerParser.m15266a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object viewerModel = new ViewerModel();
                    ((BaseModel) viewerModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (viewerModel instanceof Postprocessable) {
                        return ((Postprocessable) viewerModel).a();
                    }
                    return viewerModel;
                }
            }

            /* compiled from: fetchMoreAlbumsList */
            public class Serializer extends JsonSerializer<ViewerModel> {
                public final void m15244a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ViewerModel viewerModel = (ViewerModel) obj;
                    if (viewerModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(viewerModel.m15257a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        viewerModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ViewerParser.m15267a(viewerModel.w_(), viewerModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ViewerModel.class, new Serializer());
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1612684860)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: fetchMoreAlbumsList */
            public final class ThrowbackModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private ThrowbackSettingsModel f13490d;

                /* compiled from: fetchMoreAlbumsList */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ThrowbackModel.class, new Deserializer());
                    }

                    public Object m15245a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ThrowbackParser.m15264a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object throwbackModel = new ThrowbackModel();
                        ((BaseModel) throwbackModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (throwbackModel instanceof Postprocessable) {
                            return ((Postprocessable) throwbackModel).a();
                        }
                        return throwbackModel;
                    }
                }

                /* compiled from: fetchMoreAlbumsList */
                public class Serializer extends JsonSerializer<ThrowbackModel> {
                    public final void m15246a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ThrowbackModel throwbackModel = (ThrowbackModel) obj;
                        if (throwbackModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(throwbackModel.m15254a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            throwbackModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ThrowbackParser.m15265a(throwbackModel.w_(), throwbackModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(ThrowbackModel.class, new Serializer());
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -65393487)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: fetchMoreAlbumsList */
                public final class ThrowbackSettingsModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f13488d;
                    @Nullable
                    private String f13489e;

                    /* compiled from: fetchMoreAlbumsList */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(ThrowbackSettingsModel.class, new Deserializer());
                        }

                        public Object m15247a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(ThrowbackSettingsParser.m15262a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object throwbackSettingsModel = new ThrowbackSettingsModel();
                            ((BaseModel) throwbackSettingsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (throwbackSettingsModel instanceof Postprocessable) {
                                return ((Postprocessable) throwbackSettingsModel).a();
                            }
                            return throwbackSettingsModel;
                        }
                    }

                    /* compiled from: fetchMoreAlbumsList */
                    public class Serializer extends JsonSerializer<ThrowbackSettingsModel> {
                        public final void m15248a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            ThrowbackSettingsModel throwbackSettingsModel = (ThrowbackSettingsModel) obj;
                            if (throwbackSettingsModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(throwbackSettingsModel.m15251a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                throwbackSettingsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            ThrowbackSettingsParser.m15263a(throwbackSettingsModel.w_(), throwbackSettingsModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(ThrowbackSettingsModel.class, new Serializer());
                        }
                    }

                    public ThrowbackSettingsModel() {
                        super(2);
                    }

                    @Nullable
                    private String m15249a() {
                        this.f13488d = super.a(this.f13488d, 0);
                        return this.f13488d;
                    }

                    @Nullable
                    private String m15250j() {
                        this.f13489e = super.a(this.f13489e, 1);
                        return this.f13489e;
                    }

                    public final int jK_() {
                        return 1199989153;
                    }

                    public final GraphQLVisitableModel m15252a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m15251a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m15249a());
                        int b2 = flatBufferBuilder.b(m15250j());
                        flatBufferBuilder.c(2);
                        flatBufferBuilder.b(0, b);
                        flatBufferBuilder.b(1, b2);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                public ThrowbackModel() {
                    super(1);
                }

                @Nullable
                private ThrowbackSettingsModel m15253a() {
                    this.f13490d = (ThrowbackSettingsModel) super.a(this.f13490d, 0, ThrowbackSettingsModel.class);
                    return this.f13490d;
                }

                public final int jK_() {
                    return -302803958;
                }

                public final GraphQLVisitableModel m15255a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m15253a() != null) {
                        ThrowbackSettingsModel throwbackSettingsModel = (ThrowbackSettingsModel) graphQLModelMutatingVisitor.b(m15253a());
                        if (m15253a() != throwbackSettingsModel) {
                            graphQLVisitableModel = (ThrowbackModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f13490d = throwbackSettingsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m15254a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m15253a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            public ViewerModel() {
                super(1);
            }

            @Nullable
            private ThrowbackModel m15256a() {
                this.f13491d = (ThrowbackModel) super.a(this.f13491d, 0, ThrowbackModel.class);
                return this.f13491d;
            }

            public final int jK_() {
                return -1732764110;
            }

            public final GraphQLVisitableModel m15258a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m15256a() != null) {
                    ThrowbackModel throwbackModel = (ThrowbackModel) graphQLModelMutatingVisitor.b(m15256a());
                    if (m15256a() != throwbackModel) {
                        graphQLVisitableModel = (ViewerModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f13491d = throwbackModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m15257a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m15256a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        public ThrowbackSettingsSubscriptionMutationModel() {
            super(1);
        }

        @Nullable
        private ViewerModel m15259a() {
            this.f13492d = (ViewerModel) super.a(this.f13492d, 0, ViewerModel.class);
            return this.f13492d;
        }

        public final int jK_() {
            return -435399533;
        }

        public final GraphQLVisitableModel m15261a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15259a() != null) {
                ViewerModel viewerModel = (ViewerModel) graphQLModelMutatingVisitor.b(m15259a());
                if (m15259a() != viewerModel) {
                    graphQLVisitableModel = (ThrowbackSettingsSubscriptionMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13492d = viewerModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15260a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m15259a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
