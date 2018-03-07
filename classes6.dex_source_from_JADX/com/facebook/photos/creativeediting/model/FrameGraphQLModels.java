package com.facebook.photos.creativeediting.model;

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
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.photos.creativeediting.model.FrameGraphQLParsers.FramePackParser;
import com.facebook.photos.creativeediting.model.FrameGraphQLParsers.FrameParser;
import com.facebook.photos.creativeediting.model.FrameGraphQLParsers.FrameParser.StickerAssetsParser;
import com.facebook.photos.creativeediting.model.FrameGraphQLParsers.FrameParser.StickerAssetsParser.NodesParser;
import com.facebook.photos.creativeediting.model.FrameGraphQLParsers.FrameParser.StickerAssetsParser.NodesParser.LandscapePositionParser;
import com.facebook.photos.creativeediting.model.FrameGraphQLParsers.FrameParser.StickerAssetsParser.NodesParser.PortraitPositionParser;
import com.facebook.photos.creativeediting.model.FrameGraphQLParsers.FrameParser.StickerAssetsParser.NodesParser.StickerParser;
import com.facebook.photos.creativeediting.model.FrameGraphQLParsers.FrameParser.StickerAssetsParser.NodesParser.StickerParser.PreviewImageParser;
import com.facebook.photos.creativeediting.model.FrameGraphQLParsers.FrameParser.TextAssetsParser;
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

/* compiled from: survey_param_type */
public class FrameGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1915894318)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: survey_param_type */
    public final class FrameModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        private long f3481d;
        @Nullable
        private String f3482e;
        private long f3483f;
        @Nullable
        private StickerAssetsModel f3484g;
        @Nullable
        private TextAssetsModel f3485h;

        /* compiled from: survey_param_type */
        public final class Builder {
            public long f3398a;
            @Nullable
            public String f3399b;
            public long f3400c;
            @Nullable
            public StickerAssetsModel f3401d;
            @Nullable
            public TextAssetsModel f3402e;

            public final FrameModel m4513a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(this.f3399b);
                int a = ModelHelper.a(flatBufferBuilder, this.f3401d);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f3402e);
                flatBufferBuilder.c(5);
                flatBufferBuilder.a(0, this.f3398a, 0);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.a(2, this.f3400c, 0);
                flatBufferBuilder.b(3, a);
                flatBufferBuilder.b(4, a2);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new FrameModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: survey_param_type */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FrameModel.class, new Deserializer());
            }

            public Object m4514a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FrameParser.m4666b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object frameModel = new FrameModel();
                ((BaseModel) frameModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (frameModel instanceof Postprocessable) {
                    return ((Postprocessable) frameModel).a();
                }
                return frameModel;
            }
        }

        /* compiled from: survey_param_type */
        public class Serializer extends JsonSerializer<FrameModel> {
            public final void m4515a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FrameModel frameModel = (FrameModel) obj;
                if (frameModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(frameModel.m4623a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    frameModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FrameParser.m4667b(frameModel.w_(), frameModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FrameModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1120177653)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: survey_param_type */
        public final class StickerAssetsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f3446d;

            /* compiled from: survey_param_type */
            public final class Builder {
                @Nullable
                public ImmutableList<NodesModel> f3403a;

                public final StickerAssetsModel m4516a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a = ModelHelper.a(flatBufferBuilder, this.f3403a);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new StickerAssetsModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: survey_param_type */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(StickerAssetsModel.class, new Deserializer());
                }

                public Object m4517a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(StickerAssetsParser.m4655a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object stickerAssetsModel = new StickerAssetsModel();
                    ((BaseModel) stickerAssetsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (stickerAssetsModel instanceof Postprocessable) {
                        return ((Postprocessable) stickerAssetsModel).a();
                    }
                    return stickerAssetsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 509001162)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: survey_param_type */
            public final class NodesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private LandscapePositionModel f3442d;
                @Nullable
                private PortraitPositionModel f3443e;
                private double f3444f;
                @Nullable
                private StickerModel f3445g;

                /* compiled from: survey_param_type */
                public final class Builder {
                    @Nullable
                    public LandscapePositionModel f3404a;
                    @Nullable
                    public PortraitPositionModel f3405b;
                    public double f3406c;
                    @Nullable
                    public StickerModel f3407d;

                    public final NodesModel m4518a() {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        int a = ModelHelper.a(flatBufferBuilder, this.f3404a);
                        int a2 = ModelHelper.a(flatBufferBuilder, this.f3405b);
                        int a3 = ModelHelper.a(flatBufferBuilder, this.f3407d);
                        flatBufferBuilder.c(4);
                        flatBufferBuilder.b(0, a);
                        flatBufferBuilder.b(1, a2);
                        flatBufferBuilder.a(2, this.f3406c, 0.0d);
                        flatBufferBuilder.b(3, a3);
                        flatBufferBuilder.d(flatBufferBuilder.d());
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        return new NodesModel(new MutableFlatBuffer(wrap, null, null, true, null));
                    }
                }

                /* compiled from: survey_param_type */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m4519a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NodesParser.m4653b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object nodesModel = new NodesModel();
                        ((BaseModel) nodesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (nodesModel instanceof Postprocessable) {
                            return ((Postprocessable) nodesModel).a();
                        }
                        return nodesModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -102816494)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: survey_param_type */
                public final class LandscapePositionModel extends BaseModel implements GraphQLVisitableModel {
                    private double f3414d;
                    @Nullable
                    private String f3415e;
                    private double f3416f;
                    @Nullable
                    private String f3417g;
                    @Nullable
                    private String f3418h;
                    private double f3419i;

                    /* compiled from: survey_param_type */
                    public final class Builder {
                        public double f3408a;
                        @Nullable
                        public String f3409b;
                        public double f3410c;
                        @Nullable
                        public String f3411d;
                        @Nullable
                        public String f3412e;
                        public double f3413f;

                        public final LandscapePositionModel m4520a() {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            int b = flatBufferBuilder.b(this.f3409b);
                            int b2 = flatBufferBuilder.b(this.f3411d);
                            int b3 = flatBufferBuilder.b(this.f3412e);
                            flatBufferBuilder.c(6);
                            flatBufferBuilder.a(0, this.f3408a, 0.0d);
                            flatBufferBuilder.b(1, b);
                            flatBufferBuilder.a(2, this.f3410c, 0.0d);
                            flatBufferBuilder.b(3, b2);
                            flatBufferBuilder.b(4, b3);
                            flatBufferBuilder.a(5, this.f3413f, 0.0d);
                            flatBufferBuilder.d(flatBufferBuilder.d());
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            return new LandscapePositionModel(new MutableFlatBuffer(wrap, null, null, true, null));
                        }
                    }

                    /* compiled from: survey_param_type */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(LandscapePositionModel.class, new Deserializer());
                        }

                        public Object m4521a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(LandscapePositionParser.m4645a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object landscapePositionModel = new LandscapePositionModel();
                            ((BaseModel) landscapePositionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (landscapePositionModel instanceof Postprocessable) {
                                return ((Postprocessable) landscapePositionModel).a();
                            }
                            return landscapePositionModel;
                        }
                    }

                    /* compiled from: survey_param_type */
                    public class Serializer extends JsonSerializer<LandscapePositionModel> {
                        public final void m4522a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            LandscapePositionModel landscapePositionModel = (LandscapePositionModel) obj;
                            if (landscapePositionModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(landscapePositionModel.m4525a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                landscapePositionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            LandscapePositionParser.m4646a(landscapePositionModel.w_(), landscapePositionModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(LandscapePositionModel.class, new Serializer());
                        }
                    }

                    public LandscapePositionModel() {
                        super(6);
                    }

                    public LandscapePositionModel(MutableFlatBuffer mutableFlatBuffer) {
                        super(6);
                        a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }

                    public final double m4524a() {
                        a(0, 0);
                        return this.f3414d;
                    }

                    @Nullable
                    public final String m4528b() {
                        this.f3415e = super.a(this.f3415e, 1);
                        return this.f3415e;
                    }

                    public final double m4529c() {
                        a(0, 2);
                        return this.f3416f;
                    }

                    @Nullable
                    public final String m4530d() {
                        this.f3417g = super.a(this.f3417g, 3);
                        return this.f3417g;
                    }

                    @Nullable
                    public final String bF_() {
                        this.f3418h = super.a(this.f3418h, 4);
                        return this.f3418h;
                    }

                    public final double m4531g() {
                        a(0, 5);
                        return this.f3419i;
                    }

                    public static LandscapePositionModel m4523a(LandscapePositionModel landscapePositionModel) {
                        if (landscapePositionModel == null) {
                            return null;
                        }
                        if (landscapePositionModel instanceof LandscapePositionModel) {
                            return landscapePositionModel;
                        }
                        Builder builder = new Builder();
                        builder.f3408a = landscapePositionModel.m4524a();
                        builder.f3409b = landscapePositionModel.m4528b();
                        builder.f3410c = landscapePositionModel.m4529c();
                        builder.f3411d = landscapePositionModel.m4530d();
                        builder.f3412e = landscapePositionModel.bF_();
                        builder.f3413f = landscapePositionModel.m4531g();
                        return builder.m4520a();
                    }

                    public final int jK_() {
                        return 17303136;
                    }

                    public final GraphQLVisitableModel m4526a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m4525a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m4528b());
                        int b2 = flatBufferBuilder.b(m4530d());
                        int b3 = flatBufferBuilder.b(bF_());
                        flatBufferBuilder.c(6);
                        flatBufferBuilder.a(0, this.f3414d, 0.0d);
                        flatBufferBuilder.b(1, b);
                        flatBufferBuilder.a(2, this.f3416f, 0.0d);
                        flatBufferBuilder.b(3, b2);
                        flatBufferBuilder.b(4, b3);
                        flatBufferBuilder.a(5, this.f3419i, 0.0d);
                        i();
                        return flatBufferBuilder.d();
                    }

                    public final void m4527a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                        super.a(mutableFlatBuffer, i, obj);
                        this.f3414d = mutableFlatBuffer.a(i, 0, 0.0d);
                        this.f3416f = mutableFlatBuffer.a(i, 2, 0.0d);
                        this.f3419i = mutableFlatBuffer.a(i, 5, 0.0d);
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -102816494)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: survey_param_type */
                public final class PortraitPositionModel extends BaseModel implements GraphQLVisitableModel {
                    private double f3426d;
                    @Nullable
                    private String f3427e;
                    private double f3428f;
                    @Nullable
                    private String f3429g;
                    @Nullable
                    private String f3430h;
                    private double f3431i;

                    /* compiled from: survey_param_type */
                    public final class Builder {
                        public double f3420a;
                        @Nullable
                        public String f3421b;
                        public double f3422c;
                        @Nullable
                        public String f3423d;
                        @Nullable
                        public String f3424e;
                        public double f3425f;

                        public final PortraitPositionModel m4532a() {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            int b = flatBufferBuilder.b(this.f3421b);
                            int b2 = flatBufferBuilder.b(this.f3423d);
                            int b3 = flatBufferBuilder.b(this.f3424e);
                            flatBufferBuilder.c(6);
                            flatBufferBuilder.a(0, this.f3420a, 0.0d);
                            flatBufferBuilder.b(1, b);
                            flatBufferBuilder.a(2, this.f3422c, 0.0d);
                            flatBufferBuilder.b(3, b2);
                            flatBufferBuilder.b(4, b3);
                            flatBufferBuilder.a(5, this.f3425f, 0.0d);
                            flatBufferBuilder.d(flatBufferBuilder.d());
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            return new PortraitPositionModel(new MutableFlatBuffer(wrap, null, null, true, null));
                        }
                    }

                    /* compiled from: survey_param_type */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(PortraitPositionModel.class, new Deserializer());
                        }

                        public Object m4533a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(PortraitPositionParser.m4647a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object portraitPositionModel = new PortraitPositionModel();
                            ((BaseModel) portraitPositionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (portraitPositionModel instanceof Postprocessable) {
                                return ((Postprocessable) portraitPositionModel).a();
                            }
                            return portraitPositionModel;
                        }
                    }

                    /* compiled from: survey_param_type */
                    public class Serializer extends JsonSerializer<PortraitPositionModel> {
                        public final void m4534a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            PortraitPositionModel portraitPositionModel = (PortraitPositionModel) obj;
                            if (portraitPositionModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(portraitPositionModel.m4537a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                portraitPositionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            PortraitPositionParser.m4648a(portraitPositionModel.w_(), portraitPositionModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(PortraitPositionModel.class, new Serializer());
                        }
                    }

                    public PortraitPositionModel() {
                        super(6);
                    }

                    public PortraitPositionModel(MutableFlatBuffer mutableFlatBuffer) {
                        super(6);
                        a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }

                    public final double m4536a() {
                        a(0, 0);
                        return this.f3426d;
                    }

                    @Nullable
                    public final String m4540b() {
                        this.f3427e = super.a(this.f3427e, 1);
                        return this.f3427e;
                    }

                    public final double m4541c() {
                        a(0, 2);
                        return this.f3428f;
                    }

                    @Nullable
                    public final String m4542d() {
                        this.f3429g = super.a(this.f3429g, 3);
                        return this.f3429g;
                    }

                    @Nullable
                    public final String bG_() {
                        this.f3430h = super.a(this.f3430h, 4);
                        return this.f3430h;
                    }

                    public final double m4543g() {
                        a(0, 5);
                        return this.f3431i;
                    }

                    public static PortraitPositionModel m4535a(PortraitPositionModel portraitPositionModel) {
                        if (portraitPositionModel == null) {
                            return null;
                        }
                        if (portraitPositionModel instanceof PortraitPositionModel) {
                            return portraitPositionModel;
                        }
                        Builder builder = new Builder();
                        builder.f3420a = portraitPositionModel.m4536a();
                        builder.f3421b = portraitPositionModel.m4540b();
                        builder.f3422c = portraitPositionModel.m4541c();
                        builder.f3423d = portraitPositionModel.m4542d();
                        builder.f3424e = portraitPositionModel.bG_();
                        builder.f3425f = portraitPositionModel.m4543g();
                        return builder.m4532a();
                    }

                    public final int jK_() {
                        return 17303136;
                    }

                    public final GraphQLVisitableModel m4538a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m4537a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m4540b());
                        int b2 = flatBufferBuilder.b(m4542d());
                        int b3 = flatBufferBuilder.b(bG_());
                        flatBufferBuilder.c(6);
                        flatBufferBuilder.a(0, this.f3426d, 0.0d);
                        flatBufferBuilder.b(1, b);
                        flatBufferBuilder.a(2, this.f3428f, 0.0d);
                        flatBufferBuilder.b(3, b2);
                        flatBufferBuilder.b(4, b3);
                        flatBufferBuilder.a(5, this.f3431i, 0.0d);
                        i();
                        return flatBufferBuilder.d();
                    }

                    public final void m4539a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                        super.a(mutableFlatBuffer, i, obj);
                        this.f3426d = mutableFlatBuffer.a(i, 0, 0.0d);
                        this.f3428f = mutableFlatBuffer.a(i, 2, 0.0d);
                        this.f3431i = mutableFlatBuffer.a(i, 5, 0.0d);
                    }
                }

                /* compiled from: survey_param_type */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m4544a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m4569a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NodesParser.m4654b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -469056159)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: survey_param_type */
                public final class StickerModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                    @Nullable
                    private String f3440d;
                    @Nullable
                    private PreviewImageModel f3441e;

                    /* compiled from: survey_param_type */
                    public final class Builder {
                        @Nullable
                        public String f3432a;
                        @Nullable
                        public PreviewImageModel f3433b;

                        public final StickerModel m4545a() {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            int b = flatBufferBuilder.b(this.f3432a);
                            int a = ModelHelper.a(flatBufferBuilder, this.f3433b);
                            flatBufferBuilder.c(2);
                            flatBufferBuilder.b(0, b);
                            flatBufferBuilder.b(1, a);
                            flatBufferBuilder.d(flatBufferBuilder.d());
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            return new StickerModel(new MutableFlatBuffer(wrap, null, null, true, null));
                        }
                    }

                    /* compiled from: survey_param_type */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(StickerModel.class, new Deserializer());
                        }

                        public Object m4546a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(StickerParser.m4651a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object stickerModel = new StickerModel();
                            ((BaseModel) stickerModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (stickerModel instanceof Postprocessable) {
                                return ((Postprocessable) stickerModel).a();
                            }
                            return stickerModel;
                        }
                    }

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = 729935302)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: survey_param_type */
                    public final class PreviewImageModel extends BaseModel implements GraphQLVisitableModel {
                        private int f3437d;
                        @Nullable
                        private String f3438e;
                        private int f3439f;

                        /* compiled from: survey_param_type */
                        public final class Builder {
                            public int f3434a;
                            @Nullable
                            public String f3435b;
                            public int f3436c;

                            public final PreviewImageModel m4547a() {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                int b = flatBufferBuilder.b(this.f3435b);
                                flatBufferBuilder.c(3);
                                flatBufferBuilder.a(0, this.f3434a, 0);
                                flatBufferBuilder.b(1, b);
                                flatBufferBuilder.a(2, this.f3436c, 0);
                                flatBufferBuilder.d(flatBufferBuilder.d());
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                return new PreviewImageModel(new MutableFlatBuffer(wrap, null, null, true, null));
                            }
                        }

                        /* compiled from: survey_param_type */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(PreviewImageModel.class, new Deserializer());
                            }

                            public Object m4548a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(PreviewImageParser.m4649a(jsonParser, flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                Object previewImageModel = new PreviewImageModel();
                                ((BaseModel) previewImageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                if (previewImageModel instanceof Postprocessable) {
                                    return ((Postprocessable) previewImageModel).a();
                                }
                                return previewImageModel;
                            }
                        }

                        /* compiled from: survey_param_type */
                        public class Serializer extends JsonSerializer<PreviewImageModel> {
                            public final void m4549a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                PreviewImageModel previewImageModel = (PreviewImageModel) obj;
                                if (previewImageModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(previewImageModel.m4552a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    previewImageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                PreviewImageParser.m4650a(previewImageModel.w_(), previewImageModel.u_(), jsonGenerator);
                            }

                            static {
                                FbSerializerProvider.a(PreviewImageModel.class, new Serializer());
                            }
                        }

                        public PreviewImageModel() {
                            super(3);
                        }

                        public PreviewImageModel(MutableFlatBuffer mutableFlatBuffer) {
                            super(3);
                            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }

                        public final int m4551a() {
                            a(0, 0);
                            return this.f3437d;
                        }

                        @Nullable
                        public final String m4555b() {
                            this.f3438e = super.a(this.f3438e, 1);
                            return this.f3438e;
                        }

                        public final int m4556c() {
                            a(0, 2);
                            return this.f3439f;
                        }

                        public static PreviewImageModel m4550a(PreviewImageModel previewImageModel) {
                            if (previewImageModel == null) {
                                return null;
                            }
                            if (previewImageModel instanceof PreviewImageModel) {
                                return previewImageModel;
                            }
                            Builder builder = new Builder();
                            builder.f3434a = previewImageModel.m4551a();
                            builder.f3435b = previewImageModel.m4555b();
                            builder.f3436c = previewImageModel.m4556c();
                            return builder.m4547a();
                        }

                        public final int jK_() {
                            return 70760763;
                        }

                        public final GraphQLVisitableModel m4553a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            h();
                            i();
                            return this;
                        }

                        public final int m4552a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int b = flatBufferBuilder.b(m4555b());
                            flatBufferBuilder.c(3);
                            flatBufferBuilder.a(0, this.f3437d, 0);
                            flatBufferBuilder.b(1, b);
                            flatBufferBuilder.a(2, this.f3439f, 0);
                            i();
                            return flatBufferBuilder.d();
                        }

                        public final void m4554a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                            super.a(mutableFlatBuffer, i, obj);
                            this.f3437d = mutableFlatBuffer.a(i, 0, 0);
                            this.f3439f = mutableFlatBuffer.a(i, 2, 0);
                        }
                    }

                    /* compiled from: survey_param_type */
                    public class Serializer extends JsonSerializer<StickerModel> {
                        public final void m4557a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            StickerModel stickerModel = (StickerModel) obj;
                            if (stickerModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(stickerModel.m4560a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                stickerModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            StickerParser.m4652a(stickerModel.w_(), stickerModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(StickerModel.class, new Serializer());
                        }
                    }

                    @Nullable
                    public final /* synthetic */ PreviewImageModel m4564c() {
                        return m4559j();
                    }

                    public StickerModel() {
                        super(2);
                    }

                    public StickerModel(MutableFlatBuffer mutableFlatBuffer) {
                        super(2);
                        a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }

                    @Nullable
                    public final String m4563b() {
                        this.f3440d = super.a(this.f3440d, 0);
                        return this.f3440d;
                    }

                    @Nullable
                    private PreviewImageModel m4559j() {
                        this.f3441e = (PreviewImageModel) super.a(this.f3441e, 1, PreviewImageModel.class);
                        return this.f3441e;
                    }

                    public static StickerModel m4558a(StickerModel stickerModel) {
                        if (stickerModel == null) {
                            return null;
                        }
                        if (stickerModel instanceof StickerModel) {
                            return stickerModel;
                        }
                        Builder builder = new Builder();
                        builder.f3432a = stickerModel.m4563b();
                        builder.f3433b = PreviewImageModel.m4550a(stickerModel.m4564c());
                        return builder.m4545a();
                    }

                    @Nullable
                    public final String m4562a() {
                        return m4563b();
                    }

                    public final int jK_() {
                        return -225599203;
                    }

                    public final GraphQLVisitableModel m4561a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m4559j() != null) {
                            PreviewImageModel previewImageModel = (PreviewImageModel) graphQLModelMutatingVisitor.b(m4559j());
                            if (m4559j() != previewImageModel) {
                                graphQLVisitableModel = (StickerModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f3441e = previewImageModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m4560a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m4563b());
                        int a = ModelHelper.a(flatBufferBuilder, m4559j());
                        flatBufferBuilder.c(2);
                        flatBufferBuilder.b(0, b);
                        flatBufferBuilder.b(1, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                @Nullable
                public final /* synthetic */ LandscapePositionModel m4571a() {
                    return m4566j();
                }

                @Nullable
                public final /* synthetic */ PortraitPositionModel m4573b() {
                    return m4567k();
                }

                @Nullable
                public final /* synthetic */ StickerModel m4575d() {
                    return m4568l();
                }

                public NodesModel() {
                    super(4);
                }

                public NodesModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(4);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                @Nullable
                private LandscapePositionModel m4566j() {
                    this.f3442d = (LandscapePositionModel) super.a(this.f3442d, 0, LandscapePositionModel.class);
                    return this.f3442d;
                }

                @Nullable
                private PortraitPositionModel m4567k() {
                    this.f3443e = (PortraitPositionModel) super.a(this.f3443e, 1, PortraitPositionModel.class);
                    return this.f3443e;
                }

                public final double m4574c() {
                    a(0, 2);
                    return this.f3444f;
                }

                @Nullable
                private StickerModel m4568l() {
                    this.f3445g = (StickerModel) super.a(this.f3445g, 3, StickerModel.class);
                    return this.f3445g;
                }

                public static NodesModel m4565a(NodesModel nodesModel) {
                    if (nodesModel == null) {
                        return null;
                    }
                    if (nodesModel instanceof NodesModel) {
                        return nodesModel;
                    }
                    Builder builder = new Builder();
                    builder.f3404a = LandscapePositionModel.m4523a(nodesModel.m4571a());
                    builder.f3405b = PortraitPositionModel.m4535a(nodesModel.m4573b());
                    builder.f3406c = nodesModel.m4574c();
                    builder.f3407d = StickerModel.m4558a(nodesModel.m4575d());
                    return builder.m4518a();
                }

                public final int jK_() {
                    return 953712804;
                }

                public final GraphQLVisitableModel m4570a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m4566j() != null) {
                        LandscapePositionModel landscapePositionModel = (LandscapePositionModel) graphQLModelMutatingVisitor.b(m4566j());
                        if (m4566j() != landscapePositionModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f3442d = landscapePositionModel;
                        }
                    }
                    if (m4567k() != null) {
                        PortraitPositionModel portraitPositionModel = (PortraitPositionModel) graphQLModelMutatingVisitor.b(m4567k());
                        if (m4567k() != portraitPositionModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f3443e = portraitPositionModel;
                        }
                    }
                    if (m4568l() != null) {
                        StickerModel stickerModel = (StickerModel) graphQLModelMutatingVisitor.b(m4568l());
                        if (m4568l() != stickerModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f3445g = stickerModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m4569a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m4566j());
                    int a2 = ModelHelper.a(flatBufferBuilder, m4567k());
                    int a3 = ModelHelper.a(flatBufferBuilder, m4568l());
                    flatBufferBuilder.c(4);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    flatBufferBuilder.a(2, this.f3444f, 0.0d);
                    flatBufferBuilder.b(3, a3);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m4572a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f3444f = mutableFlatBuffer.a(i, 2, 0.0d);
                }
            }

            /* compiled from: survey_param_type */
            public class Serializer extends JsonSerializer<StickerAssetsModel> {
                public final void m4576a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    StickerAssetsModel stickerAssetsModel = (StickerAssetsModel) obj;
                    if (stickerAssetsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(stickerAssetsModel.m4578a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        stickerAssetsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    StickerAssetsParser.m4656a(stickerAssetsModel.w_(), stickerAssetsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(StickerAssetsModel.class, new Serializer());
                }
            }

            public StickerAssetsModel() {
                super(1);
            }

            public StickerAssetsModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nonnull
            public final ImmutableList<NodesModel> m4580a() {
                this.f3446d = super.a(this.f3446d, 0, NodesModel.class);
                return (ImmutableList) this.f3446d;
            }

            public static StickerAssetsModel m4577a(StickerAssetsModel stickerAssetsModel) {
                if (stickerAssetsModel == null) {
                    return null;
                }
                if (stickerAssetsModel instanceof StickerAssetsModel) {
                    return stickerAssetsModel;
                }
                Builder builder = new Builder();
                com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
                for (int i = 0; i < stickerAssetsModel.m4580a().size(); i++) {
                    builder2.c(NodesModel.m4565a((NodesModel) stickerAssetsModel.m4580a().get(i)));
                }
                builder.f3403a = builder2.b();
                return builder.m4516a();
            }

            public final int jK_() {
                return 1006114957;
            }

            public final GraphQLVisitableModel m4579a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m4580a() != null) {
                    com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m4580a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (StickerAssetsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f3446d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m4578a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m4580a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -594174899)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: survey_param_type */
        public final class TextAssetsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f3480d;

            /* compiled from: survey_param_type */
            public final class Builder {
                @Nullable
                public ImmutableList<NodesModel> f3447a;
            }

            /* compiled from: survey_param_type */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TextAssetsModel.class, new Deserializer());
                }

                public Object m4581a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TextAssetsParser.m4663a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object textAssetsModel = new TextAssetsModel();
                    ((BaseModel) textAssetsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (textAssetsModel instanceof Postprocessable) {
                        return ((Postprocessable) textAssetsModel).a();
                    }
                    return textAssetsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 278152420)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: survey_param_type */
            public final class NodesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private LandscapePositionModel f3476d;
                @Nullable
                private PortraitPositionModel f3477e;
                @Nullable
                private String f3478f;
                @Nullable
                private String f3479g;

                /* compiled from: survey_param_type */
                public final class Builder {
                    @Nullable
                    public LandscapePositionModel f3448a;
                    @Nullable
                    public PortraitPositionModel f3449b;
                    @Nullable
                    public String f3450c;
                    @Nullable
                    public String f3451d;
                }

                /* compiled from: survey_param_type */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m4582a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(TextAssetsParser.NodesParser.m4661b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object nodesModel = new NodesModel();
                        ((BaseModel) nodesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (nodesModel instanceof Postprocessable) {
                            return ((Postprocessable) nodesModel).a();
                        }
                        return nodesModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -102816494)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: survey_param_type */
                public final class LandscapePositionModel extends BaseModel implements GraphQLVisitableModel {
                    private double f3458d;
                    @Nullable
                    private String f3459e;
                    private double f3460f;
                    @Nullable
                    private String f3461g;
                    @Nullable
                    private String f3462h;
                    private double f3463i;

                    /* compiled from: survey_param_type */
                    public final class Builder {
                        public double f3452a;
                        @Nullable
                        public String f3453b;
                        public double f3454c;
                        @Nullable
                        public String f3455d;
                        @Nullable
                        public String f3456e;
                        public double f3457f;
                    }

                    /* compiled from: survey_param_type */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(LandscapePositionModel.class, new Deserializer());
                        }

                        public Object m4583a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(TextAssetsParser.NodesParser.LandscapePositionParser.m4657a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object landscapePositionModel = new LandscapePositionModel();
                            ((BaseModel) landscapePositionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (landscapePositionModel instanceof Postprocessable) {
                                return ((Postprocessable) landscapePositionModel).a();
                            }
                            return landscapePositionModel;
                        }
                    }

                    /* compiled from: survey_param_type */
                    public class Serializer extends JsonSerializer<LandscapePositionModel> {
                        public final void m4584a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            LandscapePositionModel landscapePositionModel = (LandscapePositionModel) obj;
                            if (landscapePositionModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(landscapePositionModel.m4587a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                landscapePositionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            TextAssetsParser.NodesParser.LandscapePositionParser.m4658a(landscapePositionModel.w_(), landscapePositionModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(LandscapePositionModel.class, new Serializer());
                        }
                    }

                    public LandscapePositionModel() {
                        super(6);
                    }

                    public LandscapePositionModel(MutableFlatBuffer mutableFlatBuffer) {
                        super(6);
                        a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }

                    public final double m4586a() {
                        a(0, 0);
                        return this.f3458d;
                    }

                    @Nullable
                    public final String m4590b() {
                        this.f3459e = super.a(this.f3459e, 1);
                        return this.f3459e;
                    }

                    public final double m4591c() {
                        a(0, 2);
                        return this.f3460f;
                    }

                    @Nullable
                    public final String m4592d() {
                        this.f3461g = super.a(this.f3461g, 3);
                        return this.f3461g;
                    }

                    @Nullable
                    public final String bH_() {
                        this.f3462h = super.a(this.f3462h, 4);
                        return this.f3462h;
                    }

                    public final double m4593g() {
                        a(0, 5);
                        return this.f3463i;
                    }

                    public static LandscapePositionModel m4585a(LandscapePositionModel landscapePositionModel) {
                        if (landscapePositionModel == null) {
                            return null;
                        }
                        if (landscapePositionModel instanceof LandscapePositionModel) {
                            return landscapePositionModel;
                        }
                        Builder builder = new Builder();
                        builder.f3452a = landscapePositionModel.m4586a();
                        builder.f3453b = landscapePositionModel.m4590b();
                        builder.f3454c = landscapePositionModel.m4591c();
                        builder.f3455d = landscapePositionModel.m4592d();
                        builder.f3456e = landscapePositionModel.bH_();
                        builder.f3457f = landscapePositionModel.m4593g();
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        int b = flatBufferBuilder.b(builder.f3453b);
                        int b2 = flatBufferBuilder.b(builder.f3455d);
                        int b3 = flatBufferBuilder.b(builder.f3456e);
                        flatBufferBuilder.c(6);
                        flatBufferBuilder.a(0, builder.f3452a, 0.0d);
                        flatBufferBuilder.b(1, b);
                        flatBufferBuilder.a(2, builder.f3454c, 0.0d);
                        flatBufferBuilder.b(3, b2);
                        flatBufferBuilder.b(4, b3);
                        flatBufferBuilder.a(5, builder.f3457f, 0.0d);
                        flatBufferBuilder.d(flatBufferBuilder.d());
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        return new LandscapePositionModel(new MutableFlatBuffer(wrap, null, null, true, null));
                    }

                    public final int jK_() {
                        return 17303136;
                    }

                    public final GraphQLVisitableModel m4588a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m4587a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m4590b());
                        int b2 = flatBufferBuilder.b(m4592d());
                        int b3 = flatBufferBuilder.b(bH_());
                        flatBufferBuilder.c(6);
                        flatBufferBuilder.a(0, this.f3458d, 0.0d);
                        flatBufferBuilder.b(1, b);
                        flatBufferBuilder.a(2, this.f3460f, 0.0d);
                        flatBufferBuilder.b(3, b2);
                        flatBufferBuilder.b(4, b3);
                        flatBufferBuilder.a(5, this.f3463i, 0.0d);
                        i();
                        return flatBufferBuilder.d();
                    }

                    public final void m4589a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                        super.a(mutableFlatBuffer, i, obj);
                        this.f3458d = mutableFlatBuffer.a(i, 0, 0.0d);
                        this.f3460f = mutableFlatBuffer.a(i, 2, 0.0d);
                        this.f3463i = mutableFlatBuffer.a(i, 5, 0.0d);
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -102816494)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: survey_param_type */
                public final class PortraitPositionModel extends BaseModel implements GraphQLVisitableModel {
                    private double f3470d;
                    @Nullable
                    private String f3471e;
                    private double f3472f;
                    @Nullable
                    private String f3473g;
                    @Nullable
                    private String f3474h;
                    private double f3475i;

                    /* compiled from: survey_param_type */
                    public final class Builder {
                        public double f3464a;
                        @Nullable
                        public String f3465b;
                        public double f3466c;
                        @Nullable
                        public String f3467d;
                        @Nullable
                        public String f3468e;
                        public double f3469f;
                    }

                    /* compiled from: survey_param_type */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(PortraitPositionModel.class, new Deserializer());
                        }

                        public Object m4594a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(TextAssetsParser.NodesParser.PortraitPositionParser.m4659a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object portraitPositionModel = new PortraitPositionModel();
                            ((BaseModel) portraitPositionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (portraitPositionModel instanceof Postprocessable) {
                                return ((Postprocessable) portraitPositionModel).a();
                            }
                            return portraitPositionModel;
                        }
                    }

                    /* compiled from: survey_param_type */
                    public class Serializer extends JsonSerializer<PortraitPositionModel> {
                        public final void m4595a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            PortraitPositionModel portraitPositionModel = (PortraitPositionModel) obj;
                            if (portraitPositionModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(portraitPositionModel.m4598a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                portraitPositionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            TextAssetsParser.NodesParser.PortraitPositionParser.m4660a(portraitPositionModel.w_(), portraitPositionModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(PortraitPositionModel.class, new Serializer());
                        }
                    }

                    public PortraitPositionModel() {
                        super(6);
                    }

                    public PortraitPositionModel(MutableFlatBuffer mutableFlatBuffer) {
                        super(6);
                        a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }

                    public final double m4597a() {
                        a(0, 0);
                        return this.f3470d;
                    }

                    @Nullable
                    public final String m4601b() {
                        this.f3471e = super.a(this.f3471e, 1);
                        return this.f3471e;
                    }

                    public final double m4602c() {
                        a(0, 2);
                        return this.f3472f;
                    }

                    @Nullable
                    public final String m4603d() {
                        this.f3473g = super.a(this.f3473g, 3);
                        return this.f3473g;
                    }

                    @Nullable
                    public final String bI_() {
                        this.f3474h = super.a(this.f3474h, 4);
                        return this.f3474h;
                    }

                    public final double m4604g() {
                        a(0, 5);
                        return this.f3475i;
                    }

                    public static PortraitPositionModel m4596a(PortraitPositionModel portraitPositionModel) {
                        if (portraitPositionModel == null) {
                            return null;
                        }
                        if (portraitPositionModel instanceof PortraitPositionModel) {
                            return portraitPositionModel;
                        }
                        Builder builder = new Builder();
                        builder.f3464a = portraitPositionModel.m4597a();
                        builder.f3465b = portraitPositionModel.m4601b();
                        builder.f3466c = portraitPositionModel.m4602c();
                        builder.f3467d = portraitPositionModel.m4603d();
                        builder.f3468e = portraitPositionModel.bI_();
                        builder.f3469f = portraitPositionModel.m4604g();
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        int b = flatBufferBuilder.b(builder.f3465b);
                        int b2 = flatBufferBuilder.b(builder.f3467d);
                        int b3 = flatBufferBuilder.b(builder.f3468e);
                        flatBufferBuilder.c(6);
                        flatBufferBuilder.a(0, builder.f3464a, 0.0d);
                        flatBufferBuilder.b(1, b);
                        flatBufferBuilder.a(2, builder.f3466c, 0.0d);
                        flatBufferBuilder.b(3, b2);
                        flatBufferBuilder.b(4, b3);
                        flatBufferBuilder.a(5, builder.f3469f, 0.0d);
                        flatBufferBuilder.d(flatBufferBuilder.d());
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        return new PortraitPositionModel(new MutableFlatBuffer(wrap, null, null, true, null));
                    }

                    public final int jK_() {
                        return 17303136;
                    }

                    public final GraphQLVisitableModel m4599a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m4598a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m4601b());
                        int b2 = flatBufferBuilder.b(m4603d());
                        int b3 = flatBufferBuilder.b(bI_());
                        flatBufferBuilder.c(6);
                        flatBufferBuilder.a(0, this.f3470d, 0.0d);
                        flatBufferBuilder.b(1, b);
                        flatBufferBuilder.a(2, this.f3472f, 0.0d);
                        flatBufferBuilder.b(3, b2);
                        flatBufferBuilder.b(4, b3);
                        flatBufferBuilder.a(5, this.f3475i, 0.0d);
                        i();
                        return flatBufferBuilder.d();
                    }

                    public final void m4600a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                        super.a(mutableFlatBuffer, i, obj);
                        this.f3470d = mutableFlatBuffer.a(i, 0, 0.0d);
                        this.f3472f = mutableFlatBuffer.a(i, 2, 0.0d);
                        this.f3475i = mutableFlatBuffer.a(i, 5, 0.0d);
                    }
                }

                /* compiled from: survey_param_type */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m4605a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m4609a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        TextAssetsParser.NodesParser.m4662b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ LandscapePositionModel m4611a() {
                    return m4607j();
                }

                @Nullable
                public final /* synthetic */ PortraitPositionModel m4612b() {
                    return m4608k();
                }

                public NodesModel() {
                    super(4);
                }

                public NodesModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(4);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                @Nullable
                private LandscapePositionModel m4607j() {
                    this.f3476d = (LandscapePositionModel) super.a(this.f3476d, 0, LandscapePositionModel.class);
                    return this.f3476d;
                }

                @Nullable
                private PortraitPositionModel m4608k() {
                    this.f3477e = (PortraitPositionModel) super.a(this.f3477e, 1, PortraitPositionModel.class);
                    return this.f3477e;
                }

                @Nullable
                public final String m4613c() {
                    this.f3478f = super.a(this.f3478f, 2);
                    return this.f3478f;
                }

                @Nullable
                public final String m4614d() {
                    this.f3479g = super.a(this.f3479g, 3);
                    return this.f3479g;
                }

                public static NodesModel m4606a(NodesModel nodesModel) {
                    if (nodesModel == null) {
                        return null;
                    }
                    if (nodesModel instanceof NodesModel) {
                        return nodesModel;
                    }
                    Builder builder = new Builder();
                    builder.f3448a = LandscapePositionModel.m4585a(nodesModel.m4611a());
                    builder.f3449b = PortraitPositionModel.m4596a(nodesModel.m4612b());
                    builder.f3450c = nodesModel.m4613c();
                    builder.f3451d = nodesModel.m4614d();
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a = ModelHelper.a(flatBufferBuilder, builder.f3448a);
                    int a2 = ModelHelper.a(flatBufferBuilder, builder.f3449b);
                    int b = flatBufferBuilder.b(builder.f3450c);
                    int b2 = flatBufferBuilder.b(builder.f3451d);
                    flatBufferBuilder.c(4);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    flatBufferBuilder.b(2, b);
                    flatBufferBuilder.b(3, b2);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new NodesModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }

                public final int jK_() {
                    return 1184980774;
                }

                public final GraphQLVisitableModel m4610a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m4607j() != null) {
                        LandscapePositionModel landscapePositionModel = (LandscapePositionModel) graphQLModelMutatingVisitor.b(m4607j());
                        if (m4607j() != landscapePositionModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f3476d = landscapePositionModel;
                        }
                    }
                    if (m4608k() != null) {
                        PortraitPositionModel portraitPositionModel = (PortraitPositionModel) graphQLModelMutatingVisitor.b(m4608k());
                        if (m4608k() != portraitPositionModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f3477e = portraitPositionModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m4609a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m4607j());
                    int a2 = ModelHelper.a(flatBufferBuilder, m4608k());
                    int b = flatBufferBuilder.b(m4613c());
                    int b2 = flatBufferBuilder.b(m4614d());
                    flatBufferBuilder.c(4);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    flatBufferBuilder.b(2, b);
                    flatBufferBuilder.b(3, b2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: survey_param_type */
            public class Serializer extends JsonSerializer<TextAssetsModel> {
                public final void m4615a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TextAssetsModel textAssetsModel = (TextAssetsModel) obj;
                    if (textAssetsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(textAssetsModel.m4617a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        textAssetsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TextAssetsParser.m4664a(textAssetsModel.w_(), textAssetsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(TextAssetsModel.class, new Serializer());
                }
            }

            public TextAssetsModel() {
                super(1);
            }

            public TextAssetsModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nonnull
            public final ImmutableList<NodesModel> m4619a() {
                this.f3480d = super.a(this.f3480d, 0, NodesModel.class);
                return (ImmutableList) this.f3480d;
            }

            public static TextAssetsModel m4616a(TextAssetsModel textAssetsModel) {
                if (textAssetsModel == null) {
                    return null;
                }
                if (textAssetsModel instanceof TextAssetsModel) {
                    return textAssetsModel;
                }
                Builder builder = new Builder();
                com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
                for (int i = 0; i < textAssetsModel.m4619a().size(); i++) {
                    builder2.c(NodesModel.m4606a((NodesModel) textAssetsModel.m4619a().get(i)));
                }
                builder.f3447a = builder2.b();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f3447a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new TextAssetsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 1916764836;
            }

            public final GraphQLVisitableModel m4618a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m4619a() != null) {
                    com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m4619a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (TextAssetsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f3480d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m4617a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m4619a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        @Nullable
        public final /* synthetic */ StickerAssetsModel bE_() {
            return m4621j();
        }

        @Nullable
        public final /* synthetic */ TextAssetsModel m4630g() {
            return m4622k();
        }

        public FrameModel() {
            super(5);
        }

        public FrameModel(MutableFlatBuffer mutableFlatBuffer) {
            super(5);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final long m4627b() {
            a(0, 0);
            return this.f3481d;
        }

        @Nullable
        public final String m4628c() {
            this.f3482e = super.a(this.f3482e, 1);
            return this.f3482e;
        }

        public final long m4629d() {
            a(0, 2);
            return this.f3483f;
        }

        @Nullable
        private StickerAssetsModel m4621j() {
            this.f3484g = (StickerAssetsModel) super.a(this.f3484g, 3, StickerAssetsModel.class);
            return this.f3484g;
        }

        @Nullable
        private TextAssetsModel m4622k() {
            this.f3485h = (TextAssetsModel) super.a(this.f3485h, 4, TextAssetsModel.class);
            return this.f3485h;
        }

        public static FrameModel m4620a(FrameModel frameModel) {
            if (frameModel == null) {
                return null;
            }
            if (frameModel instanceof FrameModel) {
                return frameModel;
            }
            Builder builder = new Builder();
            builder.f3398a = frameModel.m4627b();
            builder.f3399b = frameModel.m4628c();
            builder.f3400c = frameModel.m4629d();
            builder.f3401d = StickerAssetsModel.m4577a(frameModel.bE_());
            builder.f3402e = TextAssetsModel.m4616a(frameModel.m4630g());
            return builder.m4513a();
        }

        @Nullable
        public final String m4625a() {
            return m4628c();
        }

        public final int jK_() {
            return -1168082343;
        }

        public final GraphQLVisitableModel m4624a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m4621j() != null) {
                StickerAssetsModel stickerAssetsModel = (StickerAssetsModel) graphQLModelMutatingVisitor.b(m4621j());
                if (m4621j() != stickerAssetsModel) {
                    graphQLVisitableModel = (FrameModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3484g = stickerAssetsModel;
                }
            }
            if (m4622k() != null) {
                TextAssetsModel textAssetsModel = (TextAssetsModel) graphQLModelMutatingVisitor.b(m4622k());
                if (m4622k() != textAssetsModel) {
                    graphQLVisitableModel = (FrameModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3485h = textAssetsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m4623a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m4628c());
            int a = ModelHelper.a(flatBufferBuilder, m4621j());
            int a2 = ModelHelper.a(flatBufferBuilder, m4622k());
            flatBufferBuilder.c(5);
            flatBufferBuilder.a(0, this.f3481d, 0);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.a(2, this.f3483f, 0);
            flatBufferBuilder.b(3, a);
            flatBufferBuilder.b(4, a2);
            i();
            return flatBufferBuilder.d();
        }

        public final void m4626a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f3481d = mutableFlatBuffer.a(i, 0, 0);
            this.f3483f = mutableFlatBuffer.a(i, 2, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1048617277)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: survey_param_type */
    public final class FramePackModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        private long f3491d;
        @Nullable
        private List<FrameModel> f3492e;
        @Nullable
        private String f3493f;
        @Nullable
        private String f3494g;
        private long f3495h;

        /* compiled from: survey_param_type */
        public final class Builder {
            public long f3486a;
            @Nullable
            public ImmutableList<FrameModel> f3487b;
            @Nullable
            public String f3488c;
            @Nullable
            public String f3489d;
            public long f3490e;

            public final FramePackModel m4631a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f3487b);
                int b = flatBufferBuilder.b(this.f3488c);
                int b2 = flatBufferBuilder.b(this.f3489d);
                flatBufferBuilder.c(5);
                flatBufferBuilder.a(0, this.f3486a, 0);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.b(2, b);
                flatBufferBuilder.b(3, b2);
                flatBufferBuilder.a(4, this.f3490e, 0);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new FramePackModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: survey_param_type */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FramePackModel.class, new Deserializer());
            }

            public Object m4632a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FramePackParser.m4643a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object framePackModel = new FramePackModel();
                ((BaseModel) framePackModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (framePackModel instanceof Postprocessable) {
                    return ((Postprocessable) framePackModel).a();
                }
                return framePackModel;
            }
        }

        /* compiled from: survey_param_type */
        public class Serializer extends JsonSerializer<FramePackModel> {
            public final void m4633a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FramePackModel framePackModel = (FramePackModel) obj;
                if (framePackModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(framePackModel.m4635a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    framePackModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FramePackParser.m4644b(framePackModel.w_(), framePackModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FramePackModel.class, new Serializer());
            }
        }

        public FramePackModel() {
            super(5);
        }

        public FramePackModel(MutableFlatBuffer mutableFlatBuffer) {
            super(5);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final long m4639b() {
            a(0, 0);
            return this.f3491d;
        }

        @Nonnull
        public final ImmutableList<FrameModel> m4640c() {
            this.f3492e = super.a(this.f3492e, 1, FrameModel.class);
            return (ImmutableList) this.f3492e;
        }

        @Nullable
        public final String m4641d() {
            this.f3493f = super.a(this.f3493f, 2);
            return this.f3493f;
        }

        @Nullable
        public final String bJ_() {
            this.f3494g = super.a(this.f3494g, 3);
            return this.f3494g;
        }

        public final long m4642g() {
            a(0, 4);
            return this.f3495h;
        }

        public static FramePackModel m4634a(FramePackModel framePackModel) {
            if (framePackModel == null) {
                return null;
            }
            if (framePackModel instanceof FramePackModel) {
                return framePackModel;
            }
            Builder builder = new Builder();
            builder.f3486a = framePackModel.m4639b();
            com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i = 0; i < framePackModel.m4640c().size(); i++) {
                builder2.c(FrameModel.m4620a((FrameModel) framePackModel.m4640c().get(i)));
            }
            builder.f3487b = builder2.b();
            builder.f3488c = framePackModel.m4641d();
            builder.f3489d = framePackModel.bJ_();
            builder.f3490e = framePackModel.m4642g();
            return builder.m4631a();
        }

        @Nullable
        public final String m4637a() {
            return m4641d();
        }

        public final int jK_() {
            return 1184857106;
        }

        public final GraphQLVisitableModel m4636a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m4640c() != null) {
                com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m4640c(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (FramePackModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3492e = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m4635a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m4640c());
            int b = flatBufferBuilder.b(m4641d());
            int b2 = flatBufferBuilder.b(bJ_());
            flatBufferBuilder.c(5);
            flatBufferBuilder.a(0, this.f3491d, 0);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.b(3, b2);
            flatBufferBuilder.a(4, this.f3495h, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m4638a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f3491d = mutableFlatBuffer.a(i, 0, 0);
            this.f3495h = mutableFlatBuffer.a(i, 4, 0);
        }
    }
}
