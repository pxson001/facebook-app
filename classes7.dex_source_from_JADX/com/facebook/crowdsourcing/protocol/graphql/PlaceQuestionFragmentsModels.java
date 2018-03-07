package com.facebook.crowdsourcing.protocol.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.crowdsourcing.protocol.graphql.PlaceQuestionFragmentsParsers.PlaceQuestionAnswerFieldsParser;
import com.facebook.crowdsourcing.protocol.graphql.PlaceQuestionFragmentsParsers.PlaceQuestionAnswerFieldsParser.PlaceQuestionAnswerLabelParser;
import com.facebook.crowdsourcing.protocol.graphql.PlaceQuestionFragmentsParsers.PlaceQuestionFieldsParser;
import com.facebook.crowdsourcing.protocol.graphql.PlaceQuestionFragmentsParsers.PlaceQuestionFieldsParser.PlaceQuestionPhotoParser;
import com.facebook.crowdsourcing.protocol.graphql.PlaceQuestionFragmentsParsers.PlaceQuestionFieldsParser.PlaceQuestionPhotoParser.ImageParser;
import com.facebook.crowdsourcing.protocol.graphql.PlaceQuestionFragmentsParsers.PlaceQuestionFieldsParser.PlaceQuestionPlaceParser;
import com.facebook.crowdsourcing.protocol.graphql.PlaceQuestionFragmentsParsers.PlaceQuestionFieldsParser.PlaceQuestionPlaceParser.AddressParser;
import com.facebook.crowdsourcing.protocol.graphql.PlaceQuestionFragmentsParsers.PlaceQuestionFieldsParser.PlaceQuestionPlaceParser.CityParser;
import com.facebook.crowdsourcing.protocol.graphql.PlaceQuestionFragmentsParsers.PlaceQuestionFieldsParser.PlaceQuestionPlaceParser.ProfilePictureParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLPlaceQuestionOrientation;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultLocationFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultLocationFieldsModel;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel;
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

/* compiled from: taggable_activity_id */
public class PlaceQuestionFragmentsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -447850661)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: taggable_activity_id */
    public final class PlaceQuestionAnswerFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private PlaceQuestionAnswerLabelModel f2338d;
        @Nullable
        private String f2339e;

        /* compiled from: taggable_activity_id */
        public final class Builder {
            @Nullable
            public PlaceQuestionAnswerLabelModel f2334a;
            @Nullable
            public String f2335b;
        }

        /* compiled from: taggable_activity_id */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PlaceQuestionAnswerFieldsModel.class, new Deserializer());
            }

            public Object m2386a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PlaceQuestionAnswerFieldsParser.m2469b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object placeQuestionAnswerFieldsModel = new PlaceQuestionAnswerFieldsModel();
                ((BaseModel) placeQuestionAnswerFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (placeQuestionAnswerFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) placeQuestionAnswerFieldsModel).a();
                }
                return placeQuestionAnswerFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: taggable_activity_id */
        public final class PlaceQuestionAnswerLabelModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f2337d;

            /* compiled from: taggable_activity_id */
            public final class Builder {
                @Nullable
                public String f2336a;
            }

            /* compiled from: taggable_activity_id */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PlaceQuestionAnswerLabelModel.class, new Deserializer());
                }

                public Object m2387a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PlaceQuestionAnswerLabelParser.m2467a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object placeQuestionAnswerLabelModel = new PlaceQuestionAnswerLabelModel();
                    ((BaseModel) placeQuestionAnswerLabelModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (placeQuestionAnswerLabelModel instanceof Postprocessable) {
                        return ((Postprocessable) placeQuestionAnswerLabelModel).a();
                    }
                    return placeQuestionAnswerLabelModel;
                }
            }

            /* compiled from: taggable_activity_id */
            public class Serializer extends JsonSerializer<PlaceQuestionAnswerLabelModel> {
                public final void m2388a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PlaceQuestionAnswerLabelModel placeQuestionAnswerLabelModel = (PlaceQuestionAnswerLabelModel) obj;
                    if (placeQuestionAnswerLabelModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(placeQuestionAnswerLabelModel.m2390a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        placeQuestionAnswerLabelModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PlaceQuestionAnswerLabelParser.m2468a(placeQuestionAnswerLabelModel.w_(), placeQuestionAnswerLabelModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PlaceQuestionAnswerLabelModel.class, new Serializer());
                }
            }

            public PlaceQuestionAnswerLabelModel() {
                super(1);
            }

            public PlaceQuestionAnswerLabelModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m2392a() {
                this.f2337d = super.a(this.f2337d, 0);
                return this.f2337d;
            }

            public static PlaceQuestionAnswerLabelModel m2389a(PlaceQuestionAnswerLabelModel placeQuestionAnswerLabelModel) {
                if (placeQuestionAnswerLabelModel == null) {
                    return null;
                }
                if (placeQuestionAnswerLabelModel instanceof PlaceQuestionAnswerLabelModel) {
                    return placeQuestionAnswerLabelModel;
                }
                Builder builder = new Builder();
                builder.f2336a = placeQuestionAnswerLabelModel.m2392a();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f2336a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new PlaceQuestionAnswerLabelModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m2391a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m2390a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m2392a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: taggable_activity_id */
        public class Serializer extends JsonSerializer<PlaceQuestionAnswerFieldsModel> {
            public final void m2393a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PlaceQuestionAnswerFieldsModel placeQuestionAnswerFieldsModel = (PlaceQuestionAnswerFieldsModel) obj;
                if (placeQuestionAnswerFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(placeQuestionAnswerFieldsModel.m2396a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    placeQuestionAnswerFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PlaceQuestionAnswerFieldsParser.m2470b(placeQuestionAnswerFieldsModel.w_(), placeQuestionAnswerFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PlaceQuestionAnswerFieldsModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ PlaceQuestionAnswerLabelModel m2397a() {
            return m2395j();
        }

        public PlaceQuestionAnswerFieldsModel() {
            super(2);
        }

        public PlaceQuestionAnswerFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(2);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        private PlaceQuestionAnswerLabelModel m2395j() {
            this.f2338d = (PlaceQuestionAnswerLabelModel) super.a(this.f2338d, 0, PlaceQuestionAnswerLabelModel.class);
            return this.f2338d;
        }

        @Nullable
        public final String m2399b() {
            this.f2339e = super.a(this.f2339e, 1);
            return this.f2339e;
        }

        public static PlaceQuestionAnswerFieldsModel m2394a(PlaceQuestionAnswerFieldsModel placeQuestionAnswerFieldsModel) {
            if (placeQuestionAnswerFieldsModel == null) {
                return null;
            }
            if (placeQuestionAnswerFieldsModel instanceof PlaceQuestionAnswerFieldsModel) {
                return placeQuestionAnswerFieldsModel;
            }
            Builder builder = new Builder();
            builder.f2334a = PlaceQuestionAnswerLabelModel.m2389a(placeQuestionAnswerFieldsModel.m2397a());
            builder.f2335b = placeQuestionAnswerFieldsModel.m2399b();
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int a = ModelHelper.a(flatBufferBuilder, builder.f2334a);
            int b = flatBufferBuilder.b(builder.f2335b);
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new PlaceQuestionAnswerFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        public final int jK_() {
            return -1827014645;
        }

        public final GraphQLVisitableModel m2398a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2395j() != null) {
                PlaceQuestionAnswerLabelModel placeQuestionAnswerLabelModel = (PlaceQuestionAnswerLabelModel) graphQLModelMutatingVisitor.b(m2395j());
                if (m2395j() != placeQuestionAnswerLabelModel) {
                    graphQLVisitableModel = (PlaceQuestionAnswerFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f2338d = placeQuestionAnswerLabelModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2396a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m2395j());
            int b = flatBufferBuilder.b(m2399b());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 692848677)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: taggable_activity_id */
    public final class PlaceQuestionFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private String f2372d;
        @Nullable
        private List<PlaceQuestionAnswerFieldsModel> f2373e;
        @Nullable
        private DefaultTextWithEntitiesLongFieldsModel f2374f;
        @Nullable
        private GraphQLPlaceQuestionOrientation f2375g;
        @Nullable
        private PlaceQuestionPhotoModel f2376h;
        @Nullable
        private PlaceQuestionPlaceModel f2377i;
        @Nullable
        private DefaultTextWithEntitiesLongFieldsModel f2378j;
        @Nullable
        private DefaultTextWithEntitiesLongFieldsModel f2379k;

        /* compiled from: taggable_activity_id */
        public final class Builder {
            @Nullable
            public String f2340a;
            @Nullable
            public ImmutableList<PlaceQuestionAnswerFieldsModel> f2341b;
            @Nullable
            public DefaultTextWithEntitiesLongFieldsModel f2342c;
            @Nullable
            public GraphQLPlaceQuestionOrientation f2343d;
            @Nullable
            public PlaceQuestionPhotoModel f2344e;
            @Nullable
            public PlaceQuestionPlaceModel f2345f;
            @Nullable
            public DefaultTextWithEntitiesLongFieldsModel f2346g;
            @Nullable
            public DefaultTextWithEntitiesLongFieldsModel f2347h;

            public final PlaceQuestionFieldsModel m2400a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(this.f2340a);
                int a = ModelHelper.a(flatBufferBuilder, this.f2341b);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f2342c);
                int a3 = flatBufferBuilder.a(this.f2343d);
                int a4 = ModelHelper.a(flatBufferBuilder, this.f2344e);
                int a5 = ModelHelper.a(flatBufferBuilder, this.f2345f);
                int a6 = ModelHelper.a(flatBufferBuilder, this.f2346g);
                int a7 = ModelHelper.a(flatBufferBuilder, this.f2347h);
                flatBufferBuilder.c(8);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.b(2, a2);
                flatBufferBuilder.b(3, a3);
                flatBufferBuilder.b(4, a4);
                flatBufferBuilder.b(5, a5);
                flatBufferBuilder.b(6, a6);
                flatBufferBuilder.b(7, a7);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new PlaceQuestionFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: taggable_activity_id */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PlaceQuestionFieldsModel.class, new Deserializer());
            }

            public Object m2401a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PlaceQuestionFieldsParser.m2483a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object placeQuestionFieldsModel = new PlaceQuestionFieldsModel();
                ((BaseModel) placeQuestionFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (placeQuestionFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) placeQuestionFieldsModel).a();
                }
                return placeQuestionFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 260943865)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: taggable_activity_id */
        public final class PlaceQuestionPhotoModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private ImageModel f2351d;

            /* compiled from: taggable_activity_id */
            public final class Builder {
                @Nullable
                public ImageModel f2348a;
            }

            /* compiled from: taggable_activity_id */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PlaceQuestionPhotoModel.class, new Deserializer());
                }

                public Object m2402a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PlaceQuestionPhotoParser.m2473a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object placeQuestionPhotoModel = new PlaceQuestionPhotoModel();
                    ((BaseModel) placeQuestionPhotoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (placeQuestionPhotoModel instanceof Postprocessable) {
                        return ((Postprocessable) placeQuestionPhotoModel).a();
                    }
                    return placeQuestionPhotoModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 842551240)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: taggable_activity_id */
            public final class ImageModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f2350d;

                /* compiled from: taggable_activity_id */
                public final class Builder {
                    @Nullable
                    public String f2349a;
                }

                /* compiled from: taggable_activity_id */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ImageModel.class, new Deserializer());
                    }

                    public Object m2403a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ImageParser.m2471a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object imageModel = new ImageModel();
                        ((BaseModel) imageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (imageModel instanceof Postprocessable) {
                            return ((Postprocessable) imageModel).a();
                        }
                        return imageModel;
                    }
                }

                /* compiled from: taggable_activity_id */
                public class Serializer extends JsonSerializer<ImageModel> {
                    public final void m2404a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ImageModel imageModel = (ImageModel) obj;
                        if (imageModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(imageModel.m2406a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            imageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ImageParser.m2472a(imageModel.w_(), imageModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(ImageModel.class, new Serializer());
                    }
                }

                public ImageModel() {
                    super(1);
                }

                public ImageModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(1);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                @Nullable
                public final String m2408a() {
                    this.f2350d = super.a(this.f2350d, 0);
                    return this.f2350d;
                }

                public static ImageModel m2405a(ImageModel imageModel) {
                    if (imageModel == null) {
                        return null;
                    }
                    if (imageModel instanceof ImageModel) {
                        return imageModel;
                    }
                    Builder builder = new Builder();
                    builder.f2349a = imageModel.m2408a();
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int b = flatBufferBuilder.b(builder.f2349a);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new ImageModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }

                public final int jK_() {
                    return 70760763;
                }

                public final GraphQLVisitableModel m2407a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m2406a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m2408a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: taggable_activity_id */
            public class Serializer extends JsonSerializer<PlaceQuestionPhotoModel> {
                public final void m2409a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PlaceQuestionPhotoModel placeQuestionPhotoModel = (PlaceQuestionPhotoModel) obj;
                    if (placeQuestionPhotoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(placeQuestionPhotoModel.m2412a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        placeQuestionPhotoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PlaceQuestionPhotoParser.m2474a(placeQuestionPhotoModel.w_(), placeQuestionPhotoModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PlaceQuestionPhotoModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ ImageModel m2413a() {
                return m2411j();
            }

            public PlaceQuestionPhotoModel() {
                super(1);
            }

            public PlaceQuestionPhotoModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            private ImageModel m2411j() {
                this.f2351d = (ImageModel) super.a(this.f2351d, 0, ImageModel.class);
                return this.f2351d;
            }

            public static PlaceQuestionPhotoModel m2410a(PlaceQuestionPhotoModel placeQuestionPhotoModel) {
                if (placeQuestionPhotoModel == null) {
                    return null;
                }
                if (placeQuestionPhotoModel instanceof PlaceQuestionPhotoModel) {
                    return placeQuestionPhotoModel;
                }
                Builder builder = new Builder();
                builder.f2348a = ImageModel.m2405a(placeQuestionPhotoModel.m2413a());
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f2348a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new PlaceQuestionPhotoModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 77090322;
            }

            public final GraphQLVisitableModel m2414a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m2411j() != null) {
                    ImageModel imageModel = (ImageModel) graphQLModelMutatingVisitor.b(m2411j());
                    if (m2411j() != imageModel) {
                        graphQLVisitableModel = (PlaceQuestionPhotoModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f2351d = imageModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m2412a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m2411j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1822889825)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: taggable_activity_id */
        public final class PlaceQuestionPlaceModel extends BaseModel implements GraphQLVisitableConsistentModel {
            @Nullable
            private AddressModel f2366d;
            @Nullable
            private List<String> f2367e;
            @Nullable
            private CityModel f2368f;
            @Nullable
            private String f2369g;
            @Nullable
            private DefaultLocationFieldsModel f2370h;
            @Nullable
            private ProfilePictureModel f2371i;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 514620785)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: taggable_activity_id */
            public final class AddressModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f2354d;
                @Nullable
                private String f2355e;

                /* compiled from: taggable_activity_id */
                public final class Builder {
                    @Nullable
                    public String f2352a;
                    @Nullable
                    public String f2353b;
                }

                /* compiled from: taggable_activity_id */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(AddressModel.class, new Deserializer());
                    }

                    public Object m2415a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(AddressParser.m2475a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object addressModel = new AddressModel();
                        ((BaseModel) addressModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (addressModel instanceof Postprocessable) {
                            return ((Postprocessable) addressModel).a();
                        }
                        return addressModel;
                    }
                }

                /* compiled from: taggable_activity_id */
                public class Serializer extends JsonSerializer<AddressModel> {
                    public final void m2416a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        AddressModel addressModel = (AddressModel) obj;
                        if (addressModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(addressModel.m2418a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            addressModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        AddressParser.m2476a(addressModel.w_(), addressModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(AddressModel.class, new Serializer());
                    }
                }

                public AddressModel() {
                    super(2);
                }

                public AddressModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(2);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                @Nullable
                public final String m2420a() {
                    this.f2354d = super.a(this.f2354d, 0);
                    return this.f2354d;
                }

                @Nullable
                public final String m2421b() {
                    this.f2355e = super.a(this.f2355e, 1);
                    return this.f2355e;
                }

                public static AddressModel m2417a(AddressModel addressModel) {
                    if (addressModel == null) {
                        return null;
                    }
                    if (addressModel instanceof AddressModel) {
                        return addressModel;
                    }
                    Builder builder = new Builder();
                    builder.f2352a = addressModel.m2420a();
                    builder.f2353b = addressModel.m2421b();
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int b = flatBufferBuilder.b(builder.f2352a);
                    int b2 = flatBufferBuilder.b(builder.f2353b);
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, b2);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new AddressModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }

                public final int jK_() {
                    return 799251025;
                }

                public final GraphQLVisitableModel m2419a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m2418a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m2420a());
                    int b2 = flatBufferBuilder.b(m2421b());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, b2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: taggable_activity_id */
            public final class Builder {
                @Nullable
                public AddressModel f2356a;
                @Nullable
                public ImmutableList<String> f2357b;
                @Nullable
                public CityModel f2358c;
                @Nullable
                public String f2359d;
                @Nullable
                public DefaultLocationFieldsModel f2360e;
                @Nullable
                public ProfilePictureModel f2361f;
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 483014131)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: taggable_activity_id */
            public final class CityModel extends BaseModel implements GraphQLVisitableConsistentModel {
                @Nullable
                private String f2363d;

                /* compiled from: taggable_activity_id */
                public final class Builder {
                    @Nullable
                    public String f2362a;
                }

                /* compiled from: taggable_activity_id */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(CityModel.class, new Deserializer());
                    }

                    public Object m2422a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(CityParser.m2477a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object cityModel = new CityModel();
                        ((BaseModel) cityModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (cityModel instanceof Postprocessable) {
                            return ((Postprocessable) cityModel).a();
                        }
                        return cityModel;
                    }
                }

                /* compiled from: taggable_activity_id */
                public class Serializer extends JsonSerializer<CityModel> {
                    public final void m2423a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        CityModel cityModel = (CityModel) obj;
                        if (cityModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(cityModel.m2425a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            cityModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        CityParser.m2478a(cityModel.w_(), cityModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(CityModel.class, new Serializer());
                    }
                }

                public CityModel() {
                    super(1);
                }

                public CityModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(1);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                public final void m2428a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m2429a(String str, Object obj, boolean z) {
                }

                @Nullable
                public final String m2427a() {
                    this.f2363d = super.a(this.f2363d, 0);
                    return this.f2363d;
                }

                public static CityModel m2424a(CityModel cityModel) {
                    if (cityModel == null) {
                        return null;
                    }
                    if (cityModel instanceof CityModel) {
                        return cityModel;
                    }
                    Builder builder = new Builder();
                    builder.f2362a = cityModel.m2427a();
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int b = flatBufferBuilder.b(builder.f2362a);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new CityModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }

                public final int jK_() {
                    return 2479791;
                }

                public final GraphQLVisitableModel m2426a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m2425a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m2427a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: taggable_activity_id */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PlaceQuestionPlaceModel.class, new Deserializer());
                }

                public Object m2430a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PlaceQuestionPlaceParser.m2481a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object placeQuestionPlaceModel = new PlaceQuestionPlaceModel();
                    ((BaseModel) placeQuestionPlaceModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (placeQuestionPlaceModel instanceof Postprocessable) {
                        return ((Postprocessable) placeQuestionPlaceModel).a();
                    }
                    return placeQuestionPlaceModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 842551240)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: taggable_activity_id */
            public final class ProfilePictureModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f2365d;

                /* compiled from: taggable_activity_id */
                public final class Builder {
                    @Nullable
                    public String f2364a;
                }

                /* compiled from: taggable_activity_id */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ProfilePictureModel.class, new Deserializer());
                    }

                    public Object m2431a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ProfilePictureParser.m2479a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object profilePictureModel = new ProfilePictureModel();
                        ((BaseModel) profilePictureModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (profilePictureModel instanceof Postprocessable) {
                            return ((Postprocessable) profilePictureModel).a();
                        }
                        return profilePictureModel;
                    }
                }

                /* compiled from: taggable_activity_id */
                public class Serializer extends JsonSerializer<ProfilePictureModel> {
                    public final void m2432a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ProfilePictureModel profilePictureModel = (ProfilePictureModel) obj;
                        if (profilePictureModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(profilePictureModel.m2434a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            profilePictureModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ProfilePictureParser.m2480a(profilePictureModel.w_(), profilePictureModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(ProfilePictureModel.class, new Serializer());
                    }
                }

                public ProfilePictureModel() {
                    super(1);
                }

                public ProfilePictureModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(1);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                @Nullable
                public final String m2436a() {
                    this.f2365d = super.a(this.f2365d, 0);
                    return this.f2365d;
                }

                public static ProfilePictureModel m2433a(ProfilePictureModel profilePictureModel) {
                    if (profilePictureModel == null) {
                        return null;
                    }
                    if (profilePictureModel instanceof ProfilePictureModel) {
                        return profilePictureModel;
                    }
                    Builder builder = new Builder();
                    builder.f2364a = profilePictureModel.m2436a();
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int b = flatBufferBuilder.b(builder.f2364a);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new ProfilePictureModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }

                public final int jK_() {
                    return 70760763;
                }

                public final GraphQLVisitableModel m2435a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m2434a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m2436a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: taggable_activity_id */
            public class Serializer extends JsonSerializer<PlaceQuestionPlaceModel> {
                public final void m2437a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PlaceQuestionPlaceModel placeQuestionPlaceModel = (PlaceQuestionPlaceModel) obj;
                    if (placeQuestionPlaceModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(placeQuestionPlaceModel.m2443a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        placeQuestionPlaceModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PlaceQuestionPlaceParser.m2482a(placeQuestionPlaceModel.w_(), placeQuestionPlaceModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PlaceQuestionPlaceModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ AddressModel m2444a() {
                return m2439j();
            }

            @Nullable
            public final /* synthetic */ CityModel m2449c() {
                return m2440k();
            }

            @Nullable
            public final /* synthetic */ DefaultLocationFields es_() {
                return m2441l();
            }

            @Nullable
            public final /* synthetic */ ProfilePictureModel m2451g() {
                return m2442m();
            }

            public PlaceQuestionPlaceModel() {
                super(6);
            }

            public PlaceQuestionPlaceModel(MutableFlatBuffer mutableFlatBuffer) {
                super(6);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final void m2446a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m2447a(String str, Object obj, boolean z) {
            }

            @Nullable
            private AddressModel m2439j() {
                this.f2366d = (AddressModel) super.a(this.f2366d, 0, AddressModel.class);
                return this.f2366d;
            }

            @Nonnull
            public final ImmutableList<String> m2448b() {
                this.f2367e = super.a(this.f2367e, 1);
                return (ImmutableList) this.f2367e;
            }

            @Nullable
            private CityModel m2440k() {
                this.f2368f = (CityModel) super.a(this.f2368f, 2, CityModel.class);
                return this.f2368f;
            }

            @Nullable
            public final String m2450d() {
                this.f2369g = super.a(this.f2369g, 3);
                return this.f2369g;
            }

            @Nullable
            private DefaultLocationFieldsModel m2441l() {
                this.f2370h = (DefaultLocationFieldsModel) super.a(this.f2370h, 4, DefaultLocationFieldsModel.class);
                return this.f2370h;
            }

            @Nullable
            private ProfilePictureModel m2442m() {
                this.f2371i = (ProfilePictureModel) super.a(this.f2371i, 5, ProfilePictureModel.class);
                return this.f2371i;
            }

            public static PlaceQuestionPlaceModel m2438a(PlaceQuestionPlaceModel placeQuestionPlaceModel) {
                if (placeQuestionPlaceModel == null) {
                    return null;
                }
                if (placeQuestionPlaceModel instanceof PlaceQuestionPlaceModel) {
                    return placeQuestionPlaceModel;
                }
                Builder builder = new Builder();
                builder.f2356a = AddressModel.m2417a(placeQuestionPlaceModel.m2444a());
                com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
                for (int i = 0; i < placeQuestionPlaceModel.m2448b().size(); i++) {
                    builder2.c(placeQuestionPlaceModel.m2448b().get(i));
                }
                builder.f2357b = builder2.b();
                builder.f2358c = CityModel.m2424a(placeQuestionPlaceModel.m2449c());
                builder.f2359d = placeQuestionPlaceModel.m2450d();
                builder.f2360e = DefaultLocationFieldsModel.a(placeQuestionPlaceModel.es_());
                builder.f2361f = ProfilePictureModel.m2433a(placeQuestionPlaceModel.m2451g());
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f2356a);
                int c = flatBufferBuilder.c(builder.f2357b);
                int a2 = ModelHelper.a(flatBufferBuilder, builder.f2358c);
                int b = flatBufferBuilder.b(builder.f2359d);
                int a3 = ModelHelper.a(flatBufferBuilder, builder.f2360e);
                int a4 = ModelHelper.a(flatBufferBuilder, builder.f2361f);
                flatBufferBuilder.c(6);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, c);
                flatBufferBuilder.b(2, a2);
                flatBufferBuilder.b(3, b);
                flatBufferBuilder.b(4, a3);
                flatBufferBuilder.b(5, a4);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new PlaceQuestionPlaceModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 2479791;
            }

            public final GraphQLVisitableModel m2445a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m2439j() != null) {
                    AddressModel addressModel = (AddressModel) graphQLModelMutatingVisitor.b(m2439j());
                    if (m2439j() != addressModel) {
                        graphQLVisitableModel = (PlaceQuestionPlaceModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f2366d = addressModel;
                    }
                }
                if (m2440k() != null) {
                    CityModel cityModel = (CityModel) graphQLModelMutatingVisitor.b(m2440k());
                    if (m2440k() != cityModel) {
                        graphQLVisitableModel = (PlaceQuestionPlaceModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f2368f = cityModel;
                    }
                }
                if (m2441l() != null) {
                    DefaultLocationFieldsModel defaultLocationFieldsModel = (DefaultLocationFieldsModel) graphQLModelMutatingVisitor.b(m2441l());
                    if (m2441l() != defaultLocationFieldsModel) {
                        graphQLVisitableModel = (PlaceQuestionPlaceModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f2370h = defaultLocationFieldsModel;
                    }
                }
                if (m2442m() != null) {
                    ProfilePictureModel profilePictureModel = (ProfilePictureModel) graphQLModelMutatingVisitor.b(m2442m());
                    if (m2442m() != profilePictureModel) {
                        graphQLVisitableModel = (PlaceQuestionPlaceModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f2371i = profilePictureModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m2443a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m2439j());
                int c = flatBufferBuilder.c(m2448b());
                int a2 = ModelHelper.a(flatBufferBuilder, m2440k());
                int b = flatBufferBuilder.b(m2450d());
                int a3 = ModelHelper.a(flatBufferBuilder, m2441l());
                int a4 = ModelHelper.a(flatBufferBuilder, m2442m());
                flatBufferBuilder.c(6);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, c);
                flatBufferBuilder.b(2, a2);
                flatBufferBuilder.b(3, b);
                flatBufferBuilder.b(4, a3);
                flatBufferBuilder.b(5, a4);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: taggable_activity_id */
        public class Serializer extends JsonSerializer<PlaceQuestionFieldsModel> {
            public final void m2452a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PlaceQuestionFieldsModel placeQuestionFieldsModel = (PlaceQuestionFieldsModel) obj;
                if (placeQuestionFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(placeQuestionFieldsModel.m2459a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    placeQuestionFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PlaceQuestionFieldsParser.m2484b(placeQuestionFieldsModel.w_(), placeQuestionFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PlaceQuestionFieldsModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ DefaultTextWithEntitiesLongFields m2464d() {
            return m2454k();
        }

        @Nullable
        public final /* synthetic */ DefaultTextWithEntitiesLongFields eq_() {
            return m2457n();
        }

        @Nullable
        public final /* synthetic */ PlaceQuestionPlaceModel er_() {
            return m2456m();
        }

        @Nullable
        public final /* synthetic */ PlaceQuestionPhotoModel m2465g() {
            return m2455l();
        }

        @Nullable
        public final /* synthetic */ DefaultTextWithEntitiesLongFields m2466j() {
            return m2458o();
        }

        public PlaceQuestionFieldsModel() {
            super(8);
        }

        public PlaceQuestionFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(8);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final String m2462b() {
            this.f2372d = super.a(this.f2372d, 0);
            return this.f2372d;
        }

        @Nonnull
        public final ImmutableList<PlaceQuestionAnswerFieldsModel> m2463c() {
            this.f2373e = super.a(this.f2373e, 1, PlaceQuestionAnswerFieldsModel.class);
            return (ImmutableList) this.f2373e;
        }

        @Nullable
        private DefaultTextWithEntitiesLongFieldsModel m2454k() {
            this.f2374f = (DefaultTextWithEntitiesLongFieldsModel) super.a(this.f2374f, 2, DefaultTextWithEntitiesLongFieldsModel.class);
            return this.f2374f;
        }

        @Nullable
        public final GraphQLPlaceQuestionOrientation ep_() {
            this.f2375g = (GraphQLPlaceQuestionOrientation) super.b(this.f2375g, 3, GraphQLPlaceQuestionOrientation.class, GraphQLPlaceQuestionOrientation.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f2375g;
        }

        @Nullable
        private PlaceQuestionPhotoModel m2455l() {
            this.f2376h = (PlaceQuestionPhotoModel) super.a(this.f2376h, 4, PlaceQuestionPhotoModel.class);
            return this.f2376h;
        }

        @Nullable
        private PlaceQuestionPlaceModel m2456m() {
            this.f2377i = (PlaceQuestionPlaceModel) super.a(this.f2377i, 5, PlaceQuestionPlaceModel.class);
            return this.f2377i;
        }

        @Nullable
        private DefaultTextWithEntitiesLongFieldsModel m2457n() {
            this.f2378j = (DefaultTextWithEntitiesLongFieldsModel) super.a(this.f2378j, 6, DefaultTextWithEntitiesLongFieldsModel.class);
            return this.f2378j;
        }

        @Nullable
        private DefaultTextWithEntitiesLongFieldsModel m2458o() {
            this.f2379k = (DefaultTextWithEntitiesLongFieldsModel) super.a(this.f2379k, 7, DefaultTextWithEntitiesLongFieldsModel.class);
            return this.f2379k;
        }

        public static PlaceQuestionFieldsModel m2453a(PlaceQuestionFieldsModel placeQuestionFieldsModel) {
            if (placeQuestionFieldsModel == null) {
                return null;
            }
            if (placeQuestionFieldsModel instanceof PlaceQuestionFieldsModel) {
                return placeQuestionFieldsModel;
            }
            Builder builder = new Builder();
            builder.f2340a = placeQuestionFieldsModel.m2462b();
            com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i = 0; i < placeQuestionFieldsModel.m2463c().size(); i++) {
                builder2.c(PlaceQuestionAnswerFieldsModel.m2394a((PlaceQuestionAnswerFieldsModel) placeQuestionFieldsModel.m2463c().get(i)));
            }
            builder.f2341b = builder2.b();
            builder.f2342c = DefaultTextWithEntitiesLongFieldsModel.a(placeQuestionFieldsModel.m2464d());
            builder.f2343d = placeQuestionFieldsModel.ep_();
            builder.f2344e = PlaceQuestionPhotoModel.m2410a(placeQuestionFieldsModel.m2465g());
            builder.f2345f = PlaceQuestionPlaceModel.m2438a(placeQuestionFieldsModel.er_());
            builder.f2346g = DefaultTextWithEntitiesLongFieldsModel.a(placeQuestionFieldsModel.eq_());
            builder.f2347h = DefaultTextWithEntitiesLongFieldsModel.a(placeQuestionFieldsModel.m2466j());
            return builder.m2400a();
        }

        @Nullable
        public final String m2461a() {
            return m2462b();
        }

        public final int jK_() {
            return -397495827;
        }

        public final GraphQLVisitableModel m2460a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel;
            DefaultTextWithEntitiesLongFieldsModel defaultTextWithEntitiesLongFieldsModel;
            PlaceQuestionPhotoModel placeQuestionPhotoModel;
            PlaceQuestionPlaceModel placeQuestionPlaceModel;
            h();
            if (m2463c() != null) {
                com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m2463c(), graphQLModelMutatingVisitor);
                if (a != null) {
                    PlaceQuestionFieldsModel placeQuestionFieldsModel = (PlaceQuestionFieldsModel) ModelHelper.a(null, this);
                    placeQuestionFieldsModel.f2373e = a.b();
                    graphQLVisitableModel = placeQuestionFieldsModel;
                    if (m2454k() != null) {
                        defaultTextWithEntitiesLongFieldsModel = (DefaultTextWithEntitiesLongFieldsModel) graphQLModelMutatingVisitor.b(m2454k());
                        if (m2454k() != defaultTextWithEntitiesLongFieldsModel) {
                            graphQLVisitableModel = (PlaceQuestionFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f2374f = defaultTextWithEntitiesLongFieldsModel;
                        }
                    }
                    if (m2455l() != null) {
                        placeQuestionPhotoModel = (PlaceQuestionPhotoModel) graphQLModelMutatingVisitor.b(m2455l());
                        if (m2455l() != placeQuestionPhotoModel) {
                            graphQLVisitableModel = (PlaceQuestionFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f2376h = placeQuestionPhotoModel;
                        }
                    }
                    if (m2456m() != null) {
                        placeQuestionPlaceModel = (PlaceQuestionPlaceModel) graphQLModelMutatingVisitor.b(m2456m());
                        if (m2456m() != placeQuestionPlaceModel) {
                            graphQLVisitableModel = (PlaceQuestionFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f2377i = placeQuestionPlaceModel;
                        }
                    }
                    if (m2457n() != null) {
                        defaultTextWithEntitiesLongFieldsModel = (DefaultTextWithEntitiesLongFieldsModel) graphQLModelMutatingVisitor.b(m2457n());
                        if (m2457n() != defaultTextWithEntitiesLongFieldsModel) {
                            graphQLVisitableModel = (PlaceQuestionFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f2378j = defaultTextWithEntitiesLongFieldsModel;
                        }
                    }
                    if (m2458o() != null) {
                        defaultTextWithEntitiesLongFieldsModel = (DefaultTextWithEntitiesLongFieldsModel) graphQLModelMutatingVisitor.b(m2458o());
                        if (m2458o() != defaultTextWithEntitiesLongFieldsModel) {
                            graphQLVisitableModel = (PlaceQuestionFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f2379k = defaultTextWithEntitiesLongFieldsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m2454k() != null) {
                defaultTextWithEntitiesLongFieldsModel = (DefaultTextWithEntitiesLongFieldsModel) graphQLModelMutatingVisitor.b(m2454k());
                if (m2454k() != defaultTextWithEntitiesLongFieldsModel) {
                    graphQLVisitableModel = (PlaceQuestionFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f2374f = defaultTextWithEntitiesLongFieldsModel;
                }
            }
            if (m2455l() != null) {
                placeQuestionPhotoModel = (PlaceQuestionPhotoModel) graphQLModelMutatingVisitor.b(m2455l());
                if (m2455l() != placeQuestionPhotoModel) {
                    graphQLVisitableModel = (PlaceQuestionFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f2376h = placeQuestionPhotoModel;
                }
            }
            if (m2456m() != null) {
                placeQuestionPlaceModel = (PlaceQuestionPlaceModel) graphQLModelMutatingVisitor.b(m2456m());
                if (m2456m() != placeQuestionPlaceModel) {
                    graphQLVisitableModel = (PlaceQuestionFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f2377i = placeQuestionPlaceModel;
                }
            }
            if (m2457n() != null) {
                defaultTextWithEntitiesLongFieldsModel = (DefaultTextWithEntitiesLongFieldsModel) graphQLModelMutatingVisitor.b(m2457n());
                if (m2457n() != defaultTextWithEntitiesLongFieldsModel) {
                    graphQLVisitableModel = (PlaceQuestionFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f2378j = defaultTextWithEntitiesLongFieldsModel;
                }
            }
            if (m2458o() != null) {
                defaultTextWithEntitiesLongFieldsModel = (DefaultTextWithEntitiesLongFieldsModel) graphQLModelMutatingVisitor.b(m2458o());
                if (m2458o() != defaultTextWithEntitiesLongFieldsModel) {
                    graphQLVisitableModel = (PlaceQuestionFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f2379k = defaultTextWithEntitiesLongFieldsModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m2459a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m2462b());
            int a = ModelHelper.a(flatBufferBuilder, m2463c());
            int a2 = ModelHelper.a(flatBufferBuilder, m2454k());
            int a3 = flatBufferBuilder.a(ep_());
            int a4 = ModelHelper.a(flatBufferBuilder, m2455l());
            int a5 = ModelHelper.a(flatBufferBuilder, m2456m());
            int a6 = ModelHelper.a(flatBufferBuilder, m2457n());
            int a7 = ModelHelper.a(flatBufferBuilder, m2458o());
            flatBufferBuilder.c(8);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.b(4, a4);
            flatBufferBuilder.b(5, a5);
            flatBufferBuilder.b(6, a6);
            flatBufferBuilder.b(7, a7);
            i();
            return flatBufferBuilder.d();
        }
    }
}
